package org.finos.waltz.service.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.client_cache_key.ClientCacheKeyDao;
import org.finos.waltz.model.client_cache_key.ClientCacheKey;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientCacheKeyServiceDiffblueTest {
  /**
   * Method under test: {@link ClientCacheKeyService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    ClientCacheKeyDao clientCacheKeyDao = mock(ClientCacheKeyDao.class);
    ArrayList<ClientCacheKey> clientCacheKeyList = new ArrayList<>();
    when(clientCacheKeyDao.findAll()).thenReturn(clientCacheKeyList);

    // Act
    List<ClientCacheKey> actualFindAllResult = (new ClientCacheKeyService(clientCacheKeyDao)).findAll();

    // Assert
    verify(clientCacheKeyDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(clientCacheKeyList, actualFindAllResult);
  }

  /**
   * Method under test: {@link ClientCacheKeyService#getByKey(String)}
   */
  @Test
  void testGetByKey() {
    // Arrange
    ClientCacheKeyDao clientCacheKeyDao = mock(ClientCacheKeyDao.class);
    when(clientCacheKeyDao.getByKey(Mockito.<String>any())).thenReturn(null);

    // Act
    ClientCacheKey actualByKey = (new ClientCacheKeyService(clientCacheKeyDao)).getByKey("Key");

    // Assert
    verify(clientCacheKeyDao).getByKey(eq("Key"));
    assertNull(actualByKey);
  }
}
