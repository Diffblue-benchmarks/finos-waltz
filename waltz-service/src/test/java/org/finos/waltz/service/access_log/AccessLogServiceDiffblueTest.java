package org.finos.waltz.service.access_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.access_log.AccessLogDao;
import org.finos.waltz.model.accesslog.AccessLog;
import org.finos.waltz.model.accesslog.AccessTime;
import org.finos.waltz.model.accesslog.ImmutableAccessLog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccessLogServiceDiffblueTest {
  /**
   * Test {@link AccessLogService#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@link AccessLogDao} {@link AccessLogDao#write(AccessLog)} return {@code 19088743}.
   *   <li>Then return {@code 19088743}.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogService#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given AccessLogDao write(AccessLog) return '19088743'; then return '19088743'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogService.write(AccessLog)"})
  void testWrite_givenAccessLogDaoWriteReturn19088743_thenReturn19088743() {
    // Arrange
    AccessLogDao accessLogDao = mock(AccessLogDao.class);
    when(accessLogDao.write(Mockito.<AccessLog>any())).thenReturn(19088743);
    AccessLogService accessLogService = new AccessLogService(accessLogDao);

    // Act
    int actualWriteResult =
        accessLogService.write(
            ImmutableAccessLog.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .params("Params")
                .state("MD")
                .userId("42")
                .build());

    // Assert
    verify(accessLogDao).write(isA(AccessLog.class));
    assertEquals(19088743, actualWriteResult);
  }

  /**
   * Test {@link AccessLogService#findForUserId(String, Optional)}.
   *
   * <ul>
   *   <li>Given {@link AccessLogDao} {@link AccessLogDao#findForUserId(String, Optional)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogService#findForUserId(String, Optional)}
   */
  @Test
  @DisplayName(
      "Test findForUserId(String, Optional); given AccessLogDao findForUserId(String, Optional) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AccessLogService.findForUserId(String, Optional)"})
  void testFindForUserId_givenAccessLogDaoFindForUserIdReturnArrayList_thenReturnEmpty() {
    // Arrange
    AccessLogDao accessLogDao = mock(AccessLogDao.class);
    when(accessLogDao.findForUserId(Mockito.<String>any(), Mockito.<Optional<Integer>>any()))
        .thenReturn(new ArrayList<>());
    AccessLogService accessLogService = new AccessLogService(accessLogDao);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<AccessLog> actualFindForUserIdResult = accessLogService.findForUserId("42", limit);

    // Assert
    verify(accessLogDao).findForUserId(eq("42"), isA(Optional.class));
    assertTrue(actualFindForUserIdResult.isEmpty());
  }

  /**
   * Test {@link AccessLogService#findActiveUsersSince(Duration)}.
   *
   * <ul>
   *   <li>Given {@link AccessLogService#AccessLogService(AccessLogDao)} with {@link AccessLogDao}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogService#findActiveUsersSince(Duration)}
   */
  @Test
  @DisplayName(
      "Test findActiveUsersSince(Duration); given AccessLogService(AccessLogDao) with AccessLogDao; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AccessLogService.findActiveUsersSince(Duration)"})
  void testFindActiveUsersSince_givenAccessLogServiceWithAccessLogDao_thenReturnEmpty() {
    // Arrange
    AccessLogDao accessLogDao = mock(AccessLogDao.class);
    when(accessLogDao.findActiveUsersSince(Mockito.<LocalDateTime>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<AccessTime> actualFindActiveUsersSinceResult =
        new AccessLogService(accessLogDao).findActiveUsersSince(Duration.ofSeconds(1L));

    // Assert
    verify(accessLogDao).findActiveUsersSince(isA(LocalDateTime.class));
    assertTrue(actualFindActiveUsersSinceResult.isEmpty());
  }
}
