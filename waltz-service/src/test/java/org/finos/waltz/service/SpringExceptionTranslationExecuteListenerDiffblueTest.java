package org.finos.waltz.service;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import org.jooq.ExecuteContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;

class SpringExceptionTranslationExecuteListenerDiffblueTest {
  /**
   * Test {@link SpringExceptionTranslationExecuteListener#exception(ExecuteContext)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link ExecuteContext#exception()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpringExceptionTranslationExecuteListener#exception(ExecuteContext)}
   */
  @Test
  @DisplayName("Test exception(ExecuteContext); given 'null'; then calls exception()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SpringExceptionTranslationExecuteListener.exception(ExecuteContext)"})
  void testException_givenNull_thenCallsException() {
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

  /**
   * Test {@link SpringExceptionTranslationExecuteListener#exception(ExecuteContext)}.
   * <ul>
   *   <li>Then calls {@link ExecuteContext#exception(RuntimeException)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SpringExceptionTranslationExecuteListener#exception(ExecuteContext)}
   */
  @Test
  @DisplayName("Test exception(ExecuteContext); then calls exception(RuntimeException)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SpringExceptionTranslationExecuteListener.exception(ExecuteContext)"})
  void testException_thenCallsException() {
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
}
