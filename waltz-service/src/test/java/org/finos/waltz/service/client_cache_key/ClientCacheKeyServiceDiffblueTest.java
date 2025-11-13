package org.finos.waltz.service.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.client_cache_key.ClientCacheKeyDao;
import org.finos.waltz.model.client_cache_key.ClientCacheKey;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientCacheKeyServiceDiffblueTest {
  /**
   * Test {@link ClientCacheKeyService#findAll()}.
   *
   * <p>Method under test: {@link ClientCacheKeyService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClientCacheKeyService.findAll()"})
  void testFindAll() {
    // Arrange
    ClientCacheKeyDao clientCacheKeyDao = mock(ClientCacheKeyDao.class);
    when(clientCacheKeyDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<ClientCacheKey> actualFindAllResult =
        new ClientCacheKeyService(clientCacheKeyDao).findAll();

    // Assert
    verify(clientCacheKeyDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ClientCacheKeyService#getByKey(String)}.
   *
   * <p>Method under test: {@link ClientCacheKeyService#getByKey(String)}
   */
  @Test
  @DisplayName("Test getByKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientCacheKey ClientCacheKeyService.getByKey(String)"})
  void testGetByKey() {
    // Arrange
    ClientCacheKeyDao clientCacheKeyDao = mock(ClientCacheKeyDao.class);
    when(clientCacheKeyDao.getByKey(Mockito.<String>any()))
        .thenReturn(
            ImmutableClientCacheKey.builder()
                .guid("1234")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .build());

    // Act
    ClientCacheKey actualByKey = new ClientCacheKeyService(clientCacheKeyDao).getByKey("Key");

    // Assert
    verify(clientCacheKeyDao).getByKey("Key");
    assertTrue(actualByKey instanceof ImmutableClientCacheKey);
    assertEquals("1234", actualByKey.guid());
    assertEquals("Key", actualByKey.key());
  }
}
