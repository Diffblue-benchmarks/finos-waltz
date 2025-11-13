package org.finos.waltz.service.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipKindDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelKindStat;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipKind;
import org.finos.waltz.model.legal_entity.LegalEntityRelKindStat;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipKindServiceDiffblueTest {
  /**
   * Test {@link LegalEntityRelationshipKindService#getById(long)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipKindService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipKind LegalEntityRelationshipKindService.getById(long)"
  })
  void testGetById() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(legalEntityRelationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableLegalEntityRelationshipKind.builder()
                .cardinality(Cardinality.ZERO_ONE)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(ofResult.atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .requiredRole("Required Role")
                .targetKind(EntityKind.ALL)
                .build());

    // Act
    LegalEntityRelationshipKind actualById =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao).getById(1L);

    // Assert
    verify(legalEntityRelationshipKindDao).getById(1L);
    assertTrue(actualById instanceof ImmutableLegalEntityRelationshipKind);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("42", actualById.externalId());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("Required Role", actualById.requiredRole());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(Cardinality.ZERO_ONE, actualById.cardinality());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityKind.ALL, actualById.targetKind());
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#findAll()}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipKindService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipKindService.findAll()"})
  void testFindAll() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<LegalEntityRelationshipKind> actualFindAllResult =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao).findAll();

    // Assert
    verify(legalEntityRelationshipKindDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#findUsageStats()}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipKindService#findUsageStats()}
   */
  @Test
  @DisplayName("Test findUsageStats()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipKindService.findUsageStats()"})
  void testFindUsageStats() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.findUsageStats()).thenReturn(new HashSet<>());

    // Act
    Set<LegalEntityRelKindStat> actualFindUsageStatsResult =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao).findUsageStats();

    // Assert
    verify(legalEntityRelationshipKindDao).findUsageStats();
    assertTrue(actualFindUsageStatsResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector2() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector3() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector4() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector_givenActive() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector_givenInHouse() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }

  /**
   * Test {@link LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipKindService#getUsageStatsByKindAndSelector(Long, IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getUsageStatsByKindAndSelector(Long, IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelKindStat LegalEntityRelationshipKindService.getUsageStatsByKindAndSelector(Long, IdSelectionOptions)"
  })
  void testGetUsageStatsByKindAndSelector_givenPending() {
    // Arrange
    LegalEntityRelationshipKindDao legalEntityRelationshipKindDao =
        mock(LegalEntityRelationshipKindDao.class);
    when(legalEntityRelationshipKindDao.getUsageStatsByKindAndSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(
            ImmutableLegalEntityRelKindStat.builder()
                .legalEntityCount(3)
                .relKindId(1L)
                .relationshipCount(3)
                .targetEntityCount(3)
                .build());
    LegalEntityRelationshipKindService legalEntityRelationshipKindService =
        new LegalEntityRelationshipKindService(legalEntityRelationshipKindDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
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

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelKindStat actualUsageStatsByKindAndSelector =
        legalEntityRelationshipKindService.getUsageStatsByKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipKindDao)
        .getUsageStatsByKindAndSelector(eq(1L), isA(Select.class));
    assertTrue(actualUsageStatsByKindAndSelector instanceof ImmutableLegalEntityRelKindStat);
    assertEquals(1L, actualUsageStatsByKindAndSelector.relKindId());
    assertEquals(3, actualUsageStatsByKindAndSelector.legalEntityCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.relationshipCount());
    assertEquals(3, actualUsageStatsByKindAndSelector.targetEntityCount());
  }
}
