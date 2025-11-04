package org.finos.waltz.service.allocation_schemes;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.data.allocation_scheme.AllocationSchemeDao;
import org.finos.waltz.model.allocation_scheme.AllocationScheme;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AllocationSchemeServiceDiffblueTest {
  /**
   * Method under test: {@link AllocationSchemeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    when(allocationSchemeDao.findAll()).thenReturn(allocationSchemeList);

    // Act
    List<AllocationScheme> actualFindAllResult = (new AllocationSchemeService(allocationSchemeDao)).findAll();

    // Assert
    verify(allocationSchemeDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(allocationSchemeList, actualFindAllResult);
  }

  /**
   * Method under test: {@link AllocationSchemeService#findByCategoryId(long)}
   */
  @Test
  void testFindByCategoryId() {
    // Arrange
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    ArrayList<AllocationScheme> allocationSchemeList = new ArrayList<>();
    when(allocationSchemeDao.findByCategoryId(anyLong())).thenReturn(allocationSchemeList);

    // Act
    List<AllocationScheme> actualFindByCategoryIdResult = (new AllocationSchemeService(allocationSchemeDao))
        .findByCategoryId(1L);

    // Assert
    verify(allocationSchemeDao).findByCategoryId(eq(1L));
    assertTrue(actualFindByCategoryIdResult.isEmpty());
    assertSame(allocationSchemeList, actualFindByCategoryIdResult);
  }

  /**
   * Method under test: {@link AllocationSchemeService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    when(allocationSchemeDao.getById(anyLong())).thenReturn(null);

    // Act
    AllocationScheme actualById = (new AllocationSchemeService(allocationSchemeDao)).getById(1L);

    // Assert
    verify(allocationSchemeDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AllocationSchemeService#create(AllocationScheme)}
   */
  @Test
  void testCreate() {
    // Arrange
    AllocationSchemeDao allocationSchemeDao = mock(AllocationSchemeDao.class);
    when(allocationSchemeDao.create(Mockito.<AllocationScheme>any())).thenReturn(1L);

    // Act
    long actualCreateResult = (new AllocationSchemeService(allocationSchemeDao)).create(null);

    // Assert
    verify(allocationSchemeDao).create(isNull());
    assertEquals(1L, actualCreateResult);
  }
}
