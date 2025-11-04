package org.finos.waltz.service.permission;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.permission.PermissionViewDao;
import org.finos.waltz.model.permission.PermissionViewItem;
import org.junit.jupiter.api.Test;

class PermissionViewServiceDiffblueTest {
  /**
   * Method under test: {@link PermissionViewService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    PermissionViewDao permissionViewDao = mock(PermissionViewDao.class);
    HashSet<PermissionViewItem> permissionViewItemSet = new HashSet<>();
    when(permissionViewDao.findAll()).thenReturn(permissionViewItemSet);

    // Act
    Set<PermissionViewItem> actualFindAllResult = (new PermissionViewService(permissionViewDao)).findAll();

    // Assert
    verify(permissionViewDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(permissionViewItemSet, actualFindAllResult);
  }
}
