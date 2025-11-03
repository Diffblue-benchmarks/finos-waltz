package org.finos.waltz.test_common.helpers;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class ChangeLogHelperDiffblueTest {
  @InjectMocks
  private ChangeLogHelper changeLogHelper;

  @Mock
  private ChangeLogService changeLogService;

  /**
   * Test {@link ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)}.
   * <p>
   * Method under test: {@link ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)}
   */
  @Test
  @DisplayName("Test assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void ChangeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)"})
  void testAssertChangeLogContainsAtLeastOneMatchingOperation() {
    // Arrange
    ChangeLog changeLog = mock(ChangeLog.class);
    when(changeLog.operation()).thenReturn(Operation.ADD);

    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    changeLogList.add(changeLog);
    when(changeLogService.findByParentReference(Mockito.<EntityReference>any(), Mockito.<Optional<Date>>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);

    // Act
    changeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(null, Operation.ADD);

    // Assert
    verify(changeLog).operation();
    verify(changeLogService).findByParentReference(isNull(), isA(Optional.class), isA(Optional.class));
  }

  /**
   * Test {@link ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)}.
   * <p>
   * Method under test: {@link ChangeLogHelper#assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)}
   */
  @Test
  @DisplayName("Test assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void ChangeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(EntityReference, Operation)"})
  void testAssertChangeLogContainsAtLeastOneMatchingOperation2() {
    // Arrange
    ChangeLog changeLog = mock(ChangeLog.class);
    when(changeLog.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog2 = mock(ChangeLog.class);
    when(changeLog2.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog3 = mock(ChangeLog.class);
    when(changeLog3.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog4 = mock(ChangeLog.class);
    when(changeLog4.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog5 = mock(ChangeLog.class);
    when(changeLog5.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog6 = mock(ChangeLog.class);
    when(changeLog6.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog7 = mock(ChangeLog.class);
    when(changeLog7.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog8 = mock(ChangeLog.class);
    when(changeLog8.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog9 = mock(ChangeLog.class);
    when(changeLog9.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog10 = mock(ChangeLog.class);
    when(changeLog10.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog11 = mock(ChangeLog.class);
    when(changeLog11.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog12 = mock(ChangeLog.class);
    when(changeLog12.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog13 = mock(ChangeLog.class);
    when(changeLog13.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog14 = mock(ChangeLog.class);
    when(changeLog14.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog15 = mock(ChangeLog.class);
    when(changeLog15.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog16 = mock(ChangeLog.class);
    when(changeLog16.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog17 = mock(ChangeLog.class);
    when(changeLog17.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog18 = mock(ChangeLog.class);
    when(changeLog18.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog19 = mock(ChangeLog.class);
    when(changeLog19.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog20 = mock(ChangeLog.class);
    when(changeLog20.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog21 = mock(ChangeLog.class);
    when(changeLog21.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog22 = mock(ChangeLog.class);
    when(changeLog22.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog23 = mock(ChangeLog.class);
    when(changeLog23.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog24 = mock(ChangeLog.class);
    when(changeLog24.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog25 = mock(ChangeLog.class);
    when(changeLog25.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog26 = mock(ChangeLog.class);
    when(changeLog26.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog27 = mock(ChangeLog.class);
    when(changeLog27.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog28 = mock(ChangeLog.class);
    when(changeLog28.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog29 = mock(ChangeLog.class);
    when(changeLog29.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog30 = mock(ChangeLog.class);
    when(changeLog30.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog31 = mock(ChangeLog.class);
    when(changeLog31.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog32 = mock(ChangeLog.class);
    when(changeLog32.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog33 = mock(ChangeLog.class);
    when(changeLog33.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog34 = mock(ChangeLog.class);
    when(changeLog34.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog35 = mock(ChangeLog.class);
    when(changeLog35.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog36 = mock(ChangeLog.class);
    when(changeLog36.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog37 = mock(ChangeLog.class);
    when(changeLog37.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog38 = mock(ChangeLog.class);
    when(changeLog38.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog39 = mock(ChangeLog.class);
    when(changeLog39.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog40 = mock(ChangeLog.class);
    when(changeLog40.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog41 = mock(ChangeLog.class);
    when(changeLog41.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog42 = mock(ChangeLog.class);
    when(changeLog42.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog43 = mock(ChangeLog.class);
    when(changeLog43.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog44 = mock(ChangeLog.class);
    when(changeLog44.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog45 = mock(ChangeLog.class);
    when(changeLog45.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog46 = mock(ChangeLog.class);
    when(changeLog46.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog47 = mock(ChangeLog.class);
    when(changeLog47.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog48 = mock(ChangeLog.class);
    when(changeLog48.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog49 = mock(ChangeLog.class);
    when(changeLog49.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog50 = mock(ChangeLog.class);
    when(changeLog50.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog51 = mock(ChangeLog.class);
    when(changeLog51.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog52 = mock(ChangeLog.class);
    when(changeLog52.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog53 = mock(ChangeLog.class);
    when(changeLog53.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog54 = mock(ChangeLog.class);
    when(changeLog54.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog55 = mock(ChangeLog.class);
    when(changeLog55.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog56 = mock(ChangeLog.class);
    when(changeLog56.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog57 = mock(ChangeLog.class);
    when(changeLog57.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog58 = mock(ChangeLog.class);
    when(changeLog58.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog59 = mock(ChangeLog.class);
    when(changeLog59.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog60 = mock(ChangeLog.class);
    when(changeLog60.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog61 = mock(ChangeLog.class);
    when(changeLog61.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog62 = mock(ChangeLog.class);
    when(changeLog62.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog63 = mock(ChangeLog.class);
    when(changeLog63.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog64 = mock(ChangeLog.class);
    when(changeLog64.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog65 = mock(ChangeLog.class);
    when(changeLog65.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog66 = mock(ChangeLog.class);
    when(changeLog66.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog67 = mock(ChangeLog.class);
    when(changeLog67.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog68 = mock(ChangeLog.class);
    when(changeLog68.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog69 = mock(ChangeLog.class);
    when(changeLog69.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog70 = mock(ChangeLog.class);
    when(changeLog70.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog71 = mock(ChangeLog.class);
    when(changeLog71.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog72 = mock(ChangeLog.class);
    when(changeLog72.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog73 = mock(ChangeLog.class);
    when(changeLog73.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog74 = mock(ChangeLog.class);
    when(changeLog74.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog75 = mock(ChangeLog.class);
    when(changeLog75.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog76 = mock(ChangeLog.class);
    when(changeLog76.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog77 = mock(ChangeLog.class);
    when(changeLog77.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog78 = mock(ChangeLog.class);
    when(changeLog78.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog79 = mock(ChangeLog.class);
    when(changeLog79.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog80 = mock(ChangeLog.class);
    when(changeLog80.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog81 = mock(ChangeLog.class);
    when(changeLog81.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog82 = mock(ChangeLog.class);
    when(changeLog82.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog83 = mock(ChangeLog.class);
    when(changeLog83.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog84 = mock(ChangeLog.class);
    when(changeLog84.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog85 = mock(ChangeLog.class);
    when(changeLog85.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog86 = mock(ChangeLog.class);
    when(changeLog86.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog87 = mock(ChangeLog.class);
    when(changeLog87.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog88 = mock(ChangeLog.class);
    when(changeLog88.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog89 = mock(ChangeLog.class);
    when(changeLog89.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog90 = mock(ChangeLog.class);
    when(changeLog90.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog91 = mock(ChangeLog.class);
    when(changeLog91.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog92 = mock(ChangeLog.class);
    when(changeLog92.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog93 = mock(ChangeLog.class);
    when(changeLog93.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog94 = mock(ChangeLog.class);
    when(changeLog94.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog95 = mock(ChangeLog.class);
    when(changeLog95.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog96 = mock(ChangeLog.class);
    when(changeLog96.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog97 = mock(ChangeLog.class);
    when(changeLog97.operation()).thenReturn(Operation.ADD);
    ChangeLog changeLog98 = mock(ChangeLog.class);
    when(changeLog98.operation()).thenReturn(Operation.ATTEST);

    ArrayList<ChangeLog> changeLogList = new ArrayList<>();
    changeLogList.add(changeLog98);
    changeLogList.add(changeLog97);
    changeLogList.add(changeLog96);
    changeLogList.add(changeLog95);
    changeLogList.add(changeLog94);
    changeLogList.add(changeLog93);
    changeLogList.add(changeLog92);
    changeLogList.add(changeLog91);
    changeLogList.add(changeLog90);
    changeLogList.add(changeLog89);
    changeLogList.add(changeLog88);
    changeLogList.add(changeLog87);
    changeLogList.add(changeLog86);
    changeLogList.add(changeLog85);
    changeLogList.add(changeLog84);
    changeLogList.add(changeLog83);
    changeLogList.add(changeLog82);
    changeLogList.add(changeLog81);
    changeLogList.add(changeLog80);
    changeLogList.add(changeLog79);
    changeLogList.add(changeLog78);
    changeLogList.add(changeLog77);
    changeLogList.add(changeLog76);
    changeLogList.add(changeLog75);
    changeLogList.add(changeLog74);
    changeLogList.add(changeLog73);
    changeLogList.add(changeLog72);
    changeLogList.add(changeLog71);
    changeLogList.add(changeLog70);
    changeLogList.add(changeLog69);
    changeLogList.add(changeLog68);
    changeLogList.add(changeLog67);
    changeLogList.add(changeLog66);
    changeLogList.add(changeLog65);
    changeLogList.add(changeLog64);
    changeLogList.add(changeLog63);
    changeLogList.add(changeLog62);
    changeLogList.add(changeLog61);
    changeLogList.add(changeLog60);
    changeLogList.add(changeLog59);
    changeLogList.add(changeLog58);
    changeLogList.add(changeLog57);
    changeLogList.add(changeLog56);
    changeLogList.add(changeLog55);
    changeLogList.add(changeLog54);
    changeLogList.add(changeLog53);
    changeLogList.add(changeLog52);
    changeLogList.add(changeLog51);
    changeLogList.add(changeLog50);
    changeLogList.add(changeLog49);
    changeLogList.add(changeLog48);
    changeLogList.add(changeLog47);
    changeLogList.add(changeLog46);
    changeLogList.add(changeLog45);
    changeLogList.add(changeLog44);
    changeLogList.add(changeLog43);
    changeLogList.add(changeLog42);
    changeLogList.add(changeLog41);
    changeLogList.add(changeLog40);
    changeLogList.add(changeLog39);
    changeLogList.add(changeLog38);
    changeLogList.add(changeLog37);
    changeLogList.add(changeLog36);
    changeLogList.add(changeLog35);
    changeLogList.add(changeLog34);
    changeLogList.add(changeLog33);
    changeLogList.add(changeLog32);
    changeLogList.add(changeLog31);
    changeLogList.add(changeLog30);
    changeLogList.add(changeLog29);
    changeLogList.add(changeLog28);
    changeLogList.add(changeLog27);
    changeLogList.add(changeLog26);
    changeLogList.add(changeLog25);
    changeLogList.add(changeLog24);
    changeLogList.add(changeLog23);
    changeLogList.add(changeLog22);
    changeLogList.add(changeLog21);
    changeLogList.add(changeLog20);
    changeLogList.add(changeLog19);
    changeLogList.add(changeLog18);
    changeLogList.add(changeLog17);
    changeLogList.add(changeLog16);
    changeLogList.add(changeLog15);
    changeLogList.add(changeLog14);
    changeLogList.add(changeLog13);
    changeLogList.add(changeLog12);
    changeLogList.add(changeLog11);
    changeLogList.add(changeLog10);
    changeLogList.add(changeLog9);
    changeLogList.add(changeLog8);
    changeLogList.add(changeLog7);
    changeLogList.add(changeLog6);
    changeLogList.add(changeLog5);
    changeLogList.add(changeLog4);
    changeLogList.add(changeLog3);
    changeLogList.add(changeLog2);
    changeLogList.add(changeLog);
    when(changeLogService.findByParentReference(Mockito.<EntityReference>any(), Mockito.<Optional<Date>>any(),
        Mockito.<Optional<Integer>>any())).thenReturn(changeLogList);

    // Act
    changeLogHelper.assertChangeLogContainsAtLeastOneMatchingOperation(null, Operation.ADD);

    // Assert
    verify(changeLog98).operation();
    verify(changeLog97).operation();
    verify(changeLogService).findByParentReference(isNull(), isA(Optional.class), isA(Optional.class));
  }
}
