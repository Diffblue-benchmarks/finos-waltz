package org.finos.waltz.service;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import org.jooq.ExecuteContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

class SpringExceptionTranslationExecuteListenerDiffblueTest {
  /**
   * Method under test:
   * {@link SpringExceptionTranslationExecuteListener#exception(ExecuteContext)}
   */
  @Test
  void testException() {
    // Arrange
    SpringExceptionTranslationExecuteListener springExceptionTranslationExecuteListener = new SpringExceptionTranslationExecuteListener(
        new SQLStateSQLExceptionTranslator());
    ExecuteContext ctx = mock(ExecuteContext.class);
    when(ctx.sql()).thenReturn("Sql");
    doNothing().when(ctx).exception(Mockito.<RuntimeException>any());
    when(ctx.sqlException()).thenReturn(new SQLException());

    // Act
    springExceptionTranslationExecuteListener.exception(ctx);

    // Assert
    verify(ctx).exception(isNull());
    verify(ctx).sql();
    verify(ctx).sqlException();
  }

  /**
   * Method under test:
   * {@link SpringExceptionTranslationExecuteListener#exception(ExecuteContext)}
   */
  @Test
  void testException2() {
    // Arrange
    SpringExceptionTranslationExecuteListener springExceptionTranslationExecuteListener = new SpringExceptionTranslationExecuteListener(
        new SQLStateSQLExceptionTranslator());
    ExecuteContext ctx = mock(ExecuteContext.class);
    when(ctx.exception()).thenReturn(new RuntimeException("foo"));
    when(ctx.sqlException()).thenReturn(null);

    // Act
    springExceptionTranslationExecuteListener.exception(ctx);

    // Assert
    verify(ctx).exception();
    verify(ctx).sqlException();
  }
}
