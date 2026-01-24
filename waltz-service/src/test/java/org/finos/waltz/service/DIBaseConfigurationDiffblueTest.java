package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.finos.waltz.data.DBExecutorPool;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DIBaseConfigurationDiffblueTest {
  /**
   * Test {@link DIBaseConfiguration#dbExecutorPool()}.
   *
   * <p>Method under test: {@link DIBaseConfiguration#dbExecutorPool()}
   */
  @Test
  @DisplayName("Test dbExecutorPool()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DBExecutorPoolInterface DIBaseConfiguration.dbExecutorPool()"})
  void testDbExecutorPool() {
    // Arrange, Act and Assert
    assertTrue(new DIBaseConfiguration().dbExecutorPool() instanceof DBExecutorPool);
  }

  /**
   * Test {@link DIBaseConfiguration#dbExecutorPool()}.
   *
   * <ul>
   *   <li>Then return submit {@link Callable} is {@code Call}.
   * </ul>
   *
   * <p>Method under test: {@link DIBaseConfiguration#dbExecutorPool()}
   */
  @Test
  @DisplayName("Test dbExecutorPool(); then return submit Callable is 'Call'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DBExecutorPoolInterface DIBaseConfiguration.dbExecutorPool()"})
  void testDbExecutorPool_thenReturnSubmitCallableIsCall() throws Exception {
    // Arrange and Act
    DBExecutorPoolInterface actualDbExecutorPoolResult = new DIBaseConfiguration().dbExecutorPool();
    Callable<Object> callable = mock(Callable.class);
    when(callable.call()).thenReturn("Call");
    Future<Object> actualSubmitResult = actualDbExecutorPoolResult.submit(callable);

    // Assert
    assertTrue(actualDbExecutorPoolResult instanceof DBExecutorPool);
    assertEquals("Call", actualSubmitResult.get());
  }
}
