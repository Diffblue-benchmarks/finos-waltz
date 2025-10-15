package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DBExecutorPoolDiffblueTest {
  /**
   * Test {@link DBExecutorPool#DBExecutorPool(int, int)}.
   *
   * <p>Method under test: {@link DBExecutorPool#DBExecutorPool(int, int)}
   */
  @Test
  @DisplayName("Test new DBExecutorPool(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DBExecutorPool.<init>(int, int)"})
  void testNewDBExecutorPool() throws InterruptedException, ExecutionException {
    // Arrange, Act and Assert
    assertNull(new DBExecutorPool(1, 1).submit(mock(Callable.class)).get());
  }

  /**
   * Test {@link DBExecutorPool#submit(Callable)}.
   *
   * <p>Method under test: {@link DBExecutorPool#submit(Callable)}
   */
  @Test
  @DisplayName("Test submit(Callable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.concurrent.Future DBExecutorPool.submit(Callable)"})
  void testSubmit() throws Exception {
    // Arrange
    DBExecutorPool dbExecutorPool = new DBExecutorPool(1, 1);

    Callable<Object> task = mock(Callable.class);
    when(task.call()).thenReturn("Call");

    // Act and Assert
    assertEquals("Call", dbExecutorPool.submit(task).get());
  }
}
