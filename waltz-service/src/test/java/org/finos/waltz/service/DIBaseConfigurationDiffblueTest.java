package org.finos.waltz.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.finos.waltz.data.DBExecutorPool;
import org.finos.waltz.data.DBExecutorPoolInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DIBaseConfigurationDiffblueTest {
  @InjectMocks private DIBaseConfiguration dIBaseConfiguration;

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
  void testDbExecutorPool() throws InterruptedException, ExecutionException {
    // Arrange and Act
    DBExecutorPoolInterface actualDbExecutorPoolResult = dIBaseConfiguration.dbExecutorPool();
    Future<Object> actualSubmitResult = actualDbExecutorPoolResult.submit(mock(Callable.class));

    // Assert
    assertTrue(actualDbExecutorPoolResult instanceof DBExecutorPool);
    assertNull(actualSubmitResult.get());
  }
}
