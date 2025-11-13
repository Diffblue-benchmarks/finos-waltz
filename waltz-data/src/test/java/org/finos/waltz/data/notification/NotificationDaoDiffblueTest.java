package org.finos.waltz.data.notification;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.notification.NotificationSummary;
import org.jooq.DSLContext;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.ResultQuery;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificationDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private NotificationDao notificationDao;

  /**
   * Test {@link NotificationDao#findNotificationsByUserId(String)}.
   *
   * <p>Method under test: {@link NotificationDao#findNotificationsByUserId(String)}
   */
  @Test
  @DisplayName("Test findNotificationsByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List NotificationDao.findNotificationsByUserId(String)"})
  void testFindNotificationsByUserId() throws DataAccessException {
    // Arrange
    ResultQuery<Record> resultQuery = mock(ResultQuery.class);
    when(resultQuery.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.resultQuery(Mockito.<String>any())).thenReturn(resultQuery);

    // Act
    List<NotificationSummary> actualFindNotificationsByUserIdResult =
        notificationDao.findNotificationsByUserId("42");

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).resultQuery("Render Inlined");
    verify(resultQuery).fetch(isA(RecordMapper.class));
    assertTrue(actualFindNotificationsByUserIdResult.isEmpty());
  }
}
