package org.finos.waltz.test_common.helpers;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class ChangeLogHelperDiffblueTest {
  /**
   * Method under test:
   * {@link ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)}
   */
  @Test
  void testAssertChangeLogContainsAtLeastOneMatchingOperation() {
    // Arrange
    ChangeLog changeLog = mock(ChangeLog.class);
    when(changeLog.operation()).thenReturn(Operation.ADD);

    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    changeLogList.add(changeLog);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.findByParentReference(Mockito.<EntityReference>any(), Mockito.<Optional<Date>>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);
    ChangeLogHelper changeLogHelper = new ChangeLogHelper();
    ReflectionTestUtils.setField(changeLogHelper, "changeLogService", changeLogService);

    // Act
    changeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(null, Operation.ADD);

    // Assert
    verify(changeLog).operation();
    verify(changeLogService).findByParentReference(isNull(), isA(Optional.class), isA(Optional.class));
  }
}
