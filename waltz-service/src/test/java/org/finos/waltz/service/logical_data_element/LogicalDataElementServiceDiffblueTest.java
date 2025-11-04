package org.finos.waltz.service.logical_data_element;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.logical_data_element.LogicalDataElementDao;
import org.finos.waltz.data.logical_data_element.search.LogicalDataElementSearchDao;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.logical_data_element.LogicalDataElement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalDataElementServiceDiffblueTest {
  /**
   * Method under test: {@link LogicalDataElementService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    LogicalDataElementDao logicalDataElementDao = mock(LogicalDataElementDao.class);
    when(logicalDataElementDao.getById(anyLong())).thenReturn(null);

    // Act
    LogicalDataElement actualById = (new LogicalDataElementService(logicalDataElementDao,
        mock(LogicalDataElementSearchDao.class))).getById(1L);

    // Assert
    verify(logicalDataElementDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link LogicalDataElementService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    LogicalDataElementDao logicalDataElementDao = mock(LogicalDataElementDao.class);
    when(logicalDataElementDao.getByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    LogicalDataElement actualByExternalId = (new LogicalDataElementService(logicalDataElementDao,
        mock(LogicalDataElementSearchDao.class))).getByExternalId("42");

    // Assert
    verify(logicalDataElementDao).getByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test: {@link LogicalDataElementService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    LogicalDataElementDao logicalDataElementDao = mock(LogicalDataElementDao.class);
    ArrayList<LogicalDataElement> logicalDataElementList = new ArrayList<>();
    when(logicalDataElementDao.findAll()).thenReturn(logicalDataElementList);

    // Act
    List<LogicalDataElement> actualFindAllResult = (new LogicalDataElementService(logicalDataElementDao,
        mock(LogicalDataElementSearchDao.class))).findAll();

    // Assert
    verify(logicalDataElementDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(logicalDataElementList, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link LogicalDataElementService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    LogicalDataElementSearchDao logicalDataElementSearchDao = mock(LogicalDataElementSearchDao.class);
    ArrayList<LogicalDataElement> logicalDataElementList = new ArrayList<>();
    when(logicalDataElementSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(logicalDataElementList);

    // Act
    List<LogicalDataElement> actualSearchResult = (new LogicalDataElementService(mock(LogicalDataElementDao.class),
        logicalDataElementSearchDao)).search(null);

    // Assert
    verify(logicalDataElementSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(logicalDataElementList, actualSearchResult);
  }
}
