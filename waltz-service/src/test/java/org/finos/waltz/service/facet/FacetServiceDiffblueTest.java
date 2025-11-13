package org.finos.waltz.service.facet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FacetServiceDiffblueTest {
  /**
   * Test {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getApplicationKindTallies(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FacetService.getApplicationKindTallies(IdSelectionOptions)"})
  void testGetApplicationKindTallies() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    FacetService facetService = new FacetService(applicationDao);

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
    List<Tally<String>> actualApplicationKindTallies =
        facetService.getApplicationKindTallies(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    assertTrue(actualApplicationKindTallies.isEmpty());
  }

  /**
   * Test {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getApplicationKindTallies(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FacetService.getApplicationKindTallies(IdSelectionOptions)"})
  void testGetApplicationKindTallies2() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    FacetService facetService = new FacetService(applicationDao);

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
    List<Tally<String>> actualApplicationKindTallies =
        facetService.getApplicationKindTallies(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    assertTrue(actualApplicationKindTallies.isEmpty());
  }

  /**
   * Test {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getApplicationKindTallies(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FacetService.getApplicationKindTallies(IdSelectionOptions)"})
  void testGetApplicationKindTallies3() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    FacetService facetService = new FacetService(applicationDao);

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
    List<Tally<String>> actualApplicationKindTallies =
        facetService.getApplicationKindTallies(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    assertTrue(actualApplicationKindTallies.isEmpty());
  }

  /**
   * Test {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getApplicationKindTallies(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FacetService.getApplicationKindTallies(IdSelectionOptions)"})
  void testGetApplicationKindTallies4() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    FacetService facetService = new FacetService(applicationDao);

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
    List<Tally<String>> actualApplicationKindTallies =
        facetService.getApplicationKindTallies(
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    assertTrue(actualApplicationKindTallies.isEmpty());
  }

  /**
   * Test {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link FacetService#getApplicationKindTallies(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getApplicationKindTallies(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FacetService.getApplicationKindTallies(IdSelectionOptions)"})
  void testGetApplicationKindTallies5() {
    // Arrange
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.countByApplicationKind(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    FacetService facetService = new FacetService(applicationDao);

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
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

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    List<Tally<String>> actualApplicationKindTallies =
        facetService.getApplicationKindTallies(
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(applicationDao).countByApplicationKind(isA(Select.class));
    assertTrue(actualApplicationKindTallies.isEmpty());
  }
}
