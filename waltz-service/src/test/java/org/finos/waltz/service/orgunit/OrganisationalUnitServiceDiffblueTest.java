package org.finos.waltz.service.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.orgunit.search.OrganisationalUnitSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
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
class OrganisationalUnitServiceDiffblueTest {
  @Mock private OrganisationalUnitDao organisationalUnitDao;

  @Mock private OrganisationalUnitSearchDao organisationalUnitSearchDao;

  @InjectMocks private OrganisationalUnitService organisationalUnitService;

  /**
   * Test {@link OrganisationalUnitService#findAll()}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.findAll()"})
  void testFindAll() {
    // Arrange
    when(organisationalUnitDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OrganisationalUnit> actualFindAllResult = organisationalUnitService.findAll();

    // Assert
    verify(organisationalUnitDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitService#findRelatedByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#findRelatedByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findRelatedByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.findRelatedByEntityRef(EntityReference)"})
  void testFindRelatedByEntityRef() {
    // Arrange
    when(organisationalUnitDao.findRelatedByEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrganisationalUnit> actualFindRelatedByEntityRefResult =
        organisationalUnitService.findRelatedByEntityRef(null);

    // Assert
    verify(organisationalUnitDao).findRelatedByEntityRef(isNull());
    assertTrue(actualFindRelatedByEntityRefResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitService#getById(long)}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrganisationalUnit OrganisationalUnitService.getById(long)"})
  void testGetById() {
    // Arrange
    when(organisationalUnitDao.getById(anyLong()))
        .thenReturn(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Act
    OrganisationalUnit actualById = organisationalUnitService.getById(1L);

    // Assert
    verify(organisationalUnitDao).getById(1L);
    assertTrue(actualById instanceof ImmutableOrganisationalUnit);
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(EntityKind.ALL, actualById.kind());
  }

  /**
   * Test {@link OrganisationalUnitService#updateDescription(long, String)}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#updateDescription(long, String)}
   */
  @Test
  @DisplayName("Test updateDescription(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer OrganisationalUnitService.updateDescription(long, String)"})
  void testUpdateDescription() {
    // Arrange
    when(organisationalUnitDao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(1);

    // Act
    Integer actualUpdateDescriptionResult =
        organisationalUnitService.updateDescription(
            1L, "The characteristics of someone or something");

    // Assert
    verify(organisationalUnitDao)
        .updateDescription(1L, "The characteristics of someone or something");
    assertEquals(1, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Test {@link OrganisationalUnitService#findByIds(Long[])}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#findByIds(Long[])}
   */
  @Test
  @DisplayName("Test findByIds(Long[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.findByIds(Long[])"})
  void testFindByIds() {
    // Arrange
    when(organisationalUnitDao.findByIds((Long[]) Mockito.any())).thenReturn(new ArrayList<>());

    // Act
    List<OrganisationalUnit> actualFindByIdsResult = organisationalUnitService.findByIds(1L);

    // Assert
    verify(organisationalUnitDao).findByIds((Long[]) Mockito.any());
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    when(organisationalUnitSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrganisationalUnit> actualSearchResult =
        organisationalUnitService.search((EntitySearchOptions) null);

    // Assert
    verify(organisationalUnitSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Given {@link OrganisationalUnitSearchDao}.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link OrganisationalUnitService#search(String)}
   */
  @Test
  @DisplayName(
      "Test search(String) with 'query'; given OrganisationalUnitSearchDao; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.search(String)"})
  void testSearchWithQuery_givenOrganisationalUnitSearchDao_whenEmptyString() {
    // Arrange, Act and Assert
    assertTrue(organisationalUnitService.search("").isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link OrganisationalUnitSearchDao#search(EntitySearchOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link OrganisationalUnitService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; then calls search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.search(String)"})
  void testSearchWithQuery_thenCallsSearch() {
    // Arrange
    when(organisationalUnitSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrganisationalUnit> actualSearchResult = organisationalUnitService.search("Query");

    // Assert
    verify(organisationalUnitSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link OrganisationalUnitService#findDescendants(long)}.
   *
   * <p>Method under test: {@link OrganisationalUnitService#findDescendants(long)}
   */
  @Test
  @DisplayName("Test findDescendants(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrganisationalUnitService.findDescendants(long)"})
  void testFindDescendants() {
    // Arrange
    when(organisationalUnitDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OrganisationalUnit> actualFindDescendantsResult =
        organisationalUnitService.findDescendants(1L);

    // Assert
    verify(organisationalUnitDao).findBySelector(isA(Select.class));
    assertTrue(actualFindDescendantsResult.isEmpty());
  }
}
