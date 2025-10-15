package org.finos.waltz.data.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.roadmap.ImmutableRoadmap;
import org.finos.waltz.model.roadmap.ImmutableRoadmap.Builder;
import org.finos.waltz.model.roadmap.Roadmap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoadmapSearchDaoDiffblueTest {
  @Mock private RoadmapDao roadmapDao;

  @InjectMocks private RoadmapSearchDao roadmapSearchDao;

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    when(roadmapDao.findAll()).thenReturn(new ArrayList<>());

    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    Builder builderResult = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapDao.findAll()).thenReturn(roadmapList);

    ImmutableEntitySearchOptions.Builder builderResult2 = ImmutableEntitySearchOptions.builder();

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch3() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    Builder builderResult = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Builder builderResult2 = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult2 =
        builderResult2
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapDao.findAll()).thenReturn(roadmapList);

    ImmutableEntitySearchOptions.Builder builderResult3 = ImmutableEntitySearchOptions.builder();

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult3
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch4() {
    // Arrange
    when(roadmapDao.findAll()).thenReturn(new ArrayList<>());

    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch5() {
    // Arrange
    when(roadmapDao.findAll()).thenReturn(new ArrayList<>());

    ImmutableEntitySearchOptions.Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("search")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link EntitySearchOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given ArrayList(); then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenArrayList_thenCallsEntityLifecycleStatuses() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    Builder builderResult = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapDao.findAll()).thenReturn(roadmapList);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new ArrayList<>());
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(options).entityLifecycleStatuses();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given array of {@link EntityLifecycleStatus} with {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given array of EntityLifecycleStatus with 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenArrayOfEntityLifecycleStatusWithActive() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    Builder builderResult = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapDao.findAll()).thenReturn(roadmapList);

    ImmutableEntitySearchOptions.Builder builderResult2 = ImmutableEntitySearchOptions.builder();
    builderResult2.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given array of {@link EntityLifecycleStatus} with {@code ACTIVE}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given array of EntityLifecycleStatus with 'ACTIVE'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenArrayOfEntityLifecycleStatusWithActive_thenReturnArrayList() {
    // Arrange
    ArrayList<Roadmap> roadmapList = new ArrayList<>();

    Builder builderResult = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);
    roadmapList.add(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    when(roadmapDao.findAll()).thenReturn(roadmapList);

    ImmutableEntitySearchOptions.Builder builderResult2 = ImmutableEntitySearchOptions.builder();
    builderResult2.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Act
    List<Roadmap> actualSearchResult =
        roadmapSearchDao.search(
            builderResult2
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    verify(roadmapDao).findAll();
    assertEquals(roadmapList, actualSearchResult);
  }

  /**
   * Test {@link RoadmapSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#limit()} return one.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link RoadmapSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given one; when EntitySearchOptions limit() return one; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RoadmapSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenOne_whenEntitySearchOptionsLimitReturnOne_thenCallsLimit() {
    // Arrange
    when(roadmapDao.findAll()).thenReturn(new ArrayList<>());

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<Roadmap> actualSearchResult = roadmapSearchDao.search(options);

    // Assert
    verify(roadmapDao).findAll();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }
}
