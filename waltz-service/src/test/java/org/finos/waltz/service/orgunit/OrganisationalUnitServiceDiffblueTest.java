package org.finos.waltz.service.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.orgunit.search.OrganisationalUnitSearchDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.orgunit.OrganisationalUnit;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrganisationalUnitServiceDiffblueTest {
  /**
   * Method under test: {@link OrganisationalUnitService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    when(dao.findAll()).thenReturn(organisationalUnitList);

    // Act
    List<OrganisationalUnit> actualFindAllResult = (new OrganisationalUnitService(dao,
        mock(OrganisationalUnitSearchDao.class))).findAll();

    // Assert
    verify(dao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(organisationalUnitList, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitService#findRelatedByEntityRef(EntityReference)}
   */
  @Test
  void testFindRelatedByEntityRef() {
    // Arrange
    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    when(dao.findRelatedByEntityRef(Mockito.<EntityReference>any())).thenReturn(organisationalUnitList);

    // Act
    List<OrganisationalUnit> actualFindRelatedByEntityRefResult = (new OrganisationalUnitService(dao,
        mock(OrganisationalUnitSearchDao.class))).findRelatedByEntityRef(null);

    // Assert
    verify(dao).findRelatedByEntityRef(isNull());
    assertTrue(actualFindRelatedByEntityRefResult.isEmpty());
    assertSame(organisationalUnitList, actualFindRelatedByEntityRefResult);
  }

  /**
   * Method under test: {@link OrganisationalUnitService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    when(dao.getById(anyLong())).thenReturn(null);

    // Act
    OrganisationalUnit actualById = (new OrganisationalUnitService(dao, mock(OrganisationalUnitSearchDao.class)))
        .getById(1L);

    // Assert
    verify(dao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitService#updateDescription(long, String)}
   */
  @Test
  void testUpdateDescription() {
    // Arrange
    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    when(dao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(1);

    // Act
    Integer actualUpdateDescriptionResult = (new OrganisationalUnitService(dao,
        mock(OrganisationalUnitSearchDao.class))).updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(dao).updateDescription(eq(1L), eq("The characteristics of someone or something"));
    assertEquals(1, actualUpdateDescriptionResult.intValue());
  }

  /**
   * Method under test: {@link OrganisationalUnitService#findByIds(Long[])}
   */
  @Test
  void testFindByIds() {
    // Arrange
    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    when(dao.findByIds((Long[]) any())).thenReturn(organisationalUnitList);

    // Act
    List<OrganisationalUnit> actualFindByIdsResult = (new OrganisationalUnitService(dao,
        mock(OrganisationalUnitSearchDao.class))).findByIds(1L);

    // Assert
    verify(dao).findByIds((Long[]) any());
    assertTrue(actualFindByIdsResult.isEmpty());
    assertSame(organisationalUnitList, actualFindByIdsResult);
  }

  /**
   * Method under test: {@link OrganisationalUnitService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    OrganisationalUnitSearchDao organisationalUnitSearchDao = mock(OrganisationalUnitSearchDao.class);
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    when(organisationalUnitSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(organisationalUnitList);

    // Act
    List<OrganisationalUnit> actualSearchResult = (new OrganisationalUnitService(mock(OrganisationalUnitDao.class),
        organisationalUnitSearchDao)).search("Query");

    // Assert
    verify(organisationalUnitSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
    assertSame(organisationalUnitList, actualSearchResult);
  }

  /**
   * Method under test: {@link OrganisationalUnitService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange, Act and Assert
    assertTrue(
        (new OrganisationalUnitService(mock(OrganisationalUnitDao.class), mock(OrganisationalUnitSearchDao.class)))
            .search("")
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link OrganisationalUnitService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    OrganisationalUnitSearchDao organisationalUnitSearchDao = mock(OrganisationalUnitSearchDao.class);
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    when(organisationalUnitSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(organisationalUnitList);

    // Act
    List<OrganisationalUnit> actualSearchResult = (new OrganisationalUnitService(mock(OrganisationalUnitDao.class),
        organisationalUnitSearchDao)).search((EntitySearchOptions) null);

    // Assert
    verify(organisationalUnitSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(organisationalUnitList, actualSearchResult);
  }

  /**
   * Method under test: {@link OrganisationalUnitService#findDescendants(long)}
   */
  @Test
  void testFindDescendants() {
    // Arrange
    OrganisationalUnitDao dao = mock(OrganisationalUnitDao.class);
    ArrayList<OrganisationalUnit> organisationalUnitList = new ArrayList<>();
    when(dao.findBySelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(organisationalUnitList);

    // Act
    List<OrganisationalUnit> actualFindDescendantsResult = (new OrganisationalUnitService(dao,
        mock(OrganisationalUnitSearchDao.class))).findDescendants(1L);

    // Assert
    verify(dao).findBySelector(isA(Select.class));
    assertTrue(actualFindDescendantsResult.isEmpty());
    assertSame(organisationalUnitList, actualFindDescendantsResult);
  }
}
