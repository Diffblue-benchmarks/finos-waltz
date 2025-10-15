package org.finos.waltz.service.server_usage;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.server_usage.ServerUsageDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.server_usage.ServerUsage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServerUsageServiceDiffblueTest {
  @Mock private ServerUsageDao serverUsageDao;

  @InjectMocks private ServerUsageService serverUsageService;

  /**
   * Test {@link ServerUsageService#findByServerId(long)}.
   *
   * <p>Method under test: {@link ServerUsageService#findByServerId(long)}
   */
  @Test
  @DisplayName("Test findByServerId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ServerUsageService.findByServerId(long)"})
  void testFindByServerId() {
    // Arrange
    ArrayList<ServerUsage> serverUsageList = new ArrayList<>();
    when(serverUsageDao.findByServerId(anyLong())).thenReturn(serverUsageList);

    // Act
    Collection<ServerUsage> actualFindByServerIdResult = serverUsageService.findByServerId(1L);

    // Assert
    verify(serverUsageDao).findByServerId(1L);
    assertTrue(actualFindByServerIdResult instanceof List);
    assertTrue(actualFindByServerIdResult.isEmpty());
    assertSame(serverUsageList, actualFindByServerIdResult);
  }

  /**
   * Test {@link ServerUsageService#findByReferencedEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ServerUsageService#findByReferencedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test findByReferencedEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection ServerUsageService.findByReferencedEntity(EntityReference)"})
  void testFindByReferencedEntity() {
    // Arrange
    ArrayList<ServerUsage> serverUsageList = new ArrayList<>();
    when(serverUsageDao.findByReferencedEntity(Mockito.<EntityReference>any()))
        .thenReturn(serverUsageList);

    // Act
    Collection<ServerUsage> actualFindByReferencedEntityResult =
        serverUsageService.findByReferencedEntity(null);

    // Assert
    verify(serverUsageDao).findByReferencedEntity(isNull());
    assertTrue(actualFindByReferencedEntityResult instanceof List);
    assertTrue(actualFindByReferencedEntityResult.isEmpty());
    assertSame(serverUsageList, actualFindByReferencedEntityResult);
  }
}
