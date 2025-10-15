package org.finos.waltz.service.entity_search;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.service.actor.ActorService;
import org.finos.waltz.service.app_group.AppGroupService;
import org.finos.waltz.service.application.ApplicationService;
import org.finos.waltz.service.change_initiative.ChangeInitiativeService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.database_information.DatabaseInformationService;
import org.finos.waltz.service.end_user_app.EndUserAppService;
import org.finos.waltz.service.flow_diagram.FlowDiagramService;
import org.finos.waltz.service.legal_entity.LegalEntityService;
import org.finos.waltz.service.licence.LicenceService;
import org.finos.waltz.service.logical_data_element.LogicalDataElementService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.orgunit.OrganisationalUnitService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.roadmap.RoadmapService;
import org.finos.waltz.service.server_information.ServerInformationService;
import org.finos.waltz.service.software_catalog.SoftwareCatalogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntitySearchServiceDiffblueTest {
  @Mock private ActorService actorService;

  @Mock private AppGroupService appGroupService;

  @Mock private ApplicationService applicationService;

  @Mock private ChangeInitiativeService changeInitiativeService;

  @Mock private DBExecutorPoolInterface dBExecutorPoolInterface;

  @Mock private DataTypeService dataTypeService;

  @Mock private DatabaseInformationService databaseInformationService;

  @Mock private EndUserAppService endUserAppService;

  @InjectMocks private EntitySearchService entitySearchService;

  @Mock private FlowDiagramService flowDiagramService;

  @Mock private LegalEntityService legalEntityService;

  @Mock private LicenceService licenceService;

  @Mock private LogicalDataElementService logicalDataElementService;

  @Mock private MeasurableService measurableService;

  @Mock private OrganisationalUnitService organisationalUnitService;

  @Mock private PersonService personService;

  @Mock private PhysicalSpecificationService physicalSpecificationService;

  @Mock private RoadmapService roadmapService;

  @Mock private ServerInformationService serverInformationService;

  @Mock private SoftwareCatalogService softwareCatalogService;

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        entitySearchService
            .search(
                builderResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .searchQuery("Search Query")
                    .userId("42")
                    .build())
            .isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#entityKinds()} return {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given ArrayList(); when EntitySearchOptions entityKinds() return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_givenArrayList_whenEntitySearchOptionsEntityKindsReturnArrayList() {
    // Arrange
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityKinds()).thenReturn(new ArrayList<>());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<EntityReference> actualSearchResult = entitySearchService.search(options);

    // Assert
    verify(options).entityKinds();
    verify(options, atLeast(1)).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given empty string; when EntitySearchOptions searchQuery() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_givenEmptyString_whenEntitySearchOptionsSearchQueryReturnEmptyString() {
    // Arrange
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.searchQuery()).thenReturn("");

    // Act
    List<EntityReference> actualSearchResult = entitySearchService.search(options);

    // Assert
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'null'; when EntitySearchOptions searchQuery() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_givenNull_whenEntitySearchOptionsSearchQueryReturnNull() {
    // Arrange
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.searchQuery()).thenReturn(null);

    // Act
    List<EntityReference> actualSearchResult = entitySearchService.search(options);

    // Assert
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link EntitySearchService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitySearchService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySearchService.search(EntitySearchOptions)"})
  void testSearch_thenThrowUnsupportedOperationException() {
    // Arrange
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.entityKinds()).thenThrow(new UnsupportedOperationException());
    when(options.searchQuery()).thenReturn("Search Query");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> entitySearchService.search(options));
    verify(options).entityKinds();
    verify(options, atLeast(1)).searchQuery();
  }
}
