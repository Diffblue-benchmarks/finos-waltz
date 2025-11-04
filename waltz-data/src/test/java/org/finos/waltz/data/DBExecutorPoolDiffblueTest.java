package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;

class DBExecutorPoolDiffblueTest {
  /**
   * Method under test: {@link DBExecutorPool#DBExecutorPool(int, int)}
   */
  @Test
  void testNewDBExecutorPool() throws InterruptedException, ExecutionException {
    // Arrange, Act and Assert
    assertNull((new DBExecutorPool(1, 1)).<Object>submit(mock(Callable.class)).get());
  }

  /**
   * Method under test: {@link DBExecutorPool#submit(Callable)}
   */
  @Test
  void testSubmit() throws InterruptedException, ExecutionException {
    // Arrange, Act and Assert
    assertNull((new DBExecutorPool(1, 1)).<Object>submit(mock(Callable.class)).get());
  }
}
