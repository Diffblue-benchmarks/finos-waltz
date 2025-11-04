package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.finos.waltz.data.DBExecutorPool;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.junit.jupiter.api.Test;

class DIBaseConfigurationDiffblueTest {
  /**
   * Method under test: {@link DIBaseConfiguration#dbExecutorPool()}
   */
  @Test
  void testDbExecutorPool() throws InterruptedException, ExecutionException {
    // Arrange and Act
    DBExecutorPoolInterface actualDbExecutorPoolResult = (new DIBaseConfiguration()).dbExecutorPool();

    // Assert
    assertTrue(actualDbExecutorPoolResult instanceof DBExecutorPool);
    assertNull(actualDbExecutorPoolResult.<Object>submit(mock(Callable.class)).get());
  }
}
