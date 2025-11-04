package org.finos.waltz.service.access_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.access_log.AccessLogDao;
import org.finos.waltz.model.accesslog.AccessLog;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccessLogServiceDiffblueTest {
  /**
   * Method under test: {@link AccessLogService#write(AccessLog)}
   */
  @Test
  void testWrite() {
    // Arrange
    AccessLogDao accessLogDao = mock(AccessLogDao.class);
    when(accessLogDao.write(Mockito.<AccessLog>any())).thenReturn(19088743);

    // Act
    int actualWriteResult = (new AccessLogService(accessLogDao)).write(mock(AccessLog.class));

    // Assert
    verify(accessLogDao).write(isA(AccessLog.class));
    assertEquals(19088743, actualWriteResult);
  }

  /**
   * Method under test: {@link AccessLogService#findForUserId(String, Optional)}
   */
  @Test
  void testFindForUserId() {
    // Arrange
    AccessLogDao accessLogDao = mock(AccessLogDao.class);
    ArrayList<AccessLog> accessLogList = new ArrayList<>();
    when(accessLogDao.findForUserId(Mockito.<String>any(), Mockito.<Optional<Integer>>any())).thenReturn(accessLogList);
    AccessLogService accessLogService = new AccessLogService(accessLogDao);
    Optional<Integer> limit = Optional.<Integer>of(1);

    // Act
    List<AccessLog> actualFindForUserIdResult = accessLogService.findForUserId("42", limit);

    // Assert
    verify(accessLogDao).findForUserId(eq("42"), isA(Optional.class));
    assertTrue(actualFindForUserIdResult.isEmpty());
    assertSame(accessLogList, actualFindForUserIdResult);
  }
}
