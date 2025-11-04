package org.finos.waltz.service.server_usage;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.server_usage.ServerUsageDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.server_usage.ServerUsage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServerUsageServiceDiffblueTest {
  /**
   * Method under test: {@link ServerUsageService#findByServerId(long)}
   */
  @Test
  void testFindByServerId() {
    // Arrange
    ServerUsageDao serverUsageDao = mock(ServerUsageDao.class);
    ArrayList<ServerUsage> serverUsageList = new ArrayList<>();
    when(serverUsageDao.findByServerId(anyLong())).thenReturn(serverUsageList);

    // Act
    Collection<ServerUsage> actualFindByServerIdResult = (new ServerUsageService(serverUsageDao)).findByServerId(1L);

    // Assert
    verify(serverUsageDao).findByServerId(eq(1L));
    assertTrue(actualFindByServerIdResult instanceof List);
    assertTrue(actualFindByServerIdResult.isEmpty());
    assertSame(serverUsageList, actualFindByServerIdResult);
  }

  /**
   * Method under test:
   * {@link ServerUsageService#findByReferencedEntity(EntityReference)}
   */
  @Test
  void testFindByReferencedEntity() {
    // Arrange
    ServerUsageDao serverUsageDao = mock(ServerUsageDao.class);
    ArrayList<ServerUsage> serverUsageList = new ArrayList<>();
    when(serverUsageDao.findByReferencedEntity(Mockito.<EntityReference>any())).thenReturn(serverUsageList);

    // Act
    Collection<ServerUsage> actualFindByReferencedEntityResult = (new ServerUsageService(serverUsageDao))
        .findByReferencedEntity(null);

    // Assert
    verify(serverUsageDao).findByReferencedEntity(isNull());
    assertTrue(actualFindByReferencedEntityResult instanceof List);
    assertTrue(actualFindByReferencedEntityResult.isEmpty());
    assertSame(serverUsageList, actualFindByReferencedEntityResult);
  }
}
