package org.finos.waltz.service.permission;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.permission.PermissionViewDao;
import org.finos.waltz.model.permission.PermissionViewItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PermissionViewServiceDiffblueTest {
  @Mock private PermissionViewDao permissionViewDao;

  @InjectMocks private PermissionViewService permissionViewService;

  /**
   * Test {@link PermissionViewService#findAll()}.
   *
   * <p>Method under test: {@link PermissionViewService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PermissionViewService.findAll()"})
  void testFindAll() {
    // Arrange
    when(permissionViewDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<PermissionViewItem> actualFindAllResult = permissionViewService.findAll();

    // Assert
    verify(permissionViewDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
