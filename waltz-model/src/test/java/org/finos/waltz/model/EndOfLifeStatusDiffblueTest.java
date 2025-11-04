package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

class EndOfLifeStatusDiffblueTest {
  /**
   * Method under test: {@link EndOfLifeStatus#calculateEndOfLifeStatus(Date)}
   */
  @Test
  void testCalculateEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, EndOfLifeStatus.calculateEndOfLifeStatus(null));
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, EndOfLifeStatus
        .calculateEndOfLifeStatus(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link EndOfLifeStatus#calculateEndOfLifeStatus(java.util.Date)}
   */
  @Test
  void testCalculateEndOfLifeStatus2() {
    // Arrange
    java.sql.Date eolDate = mock(java.sql.Date.class);
    when(eolDate.getTime()).thenReturn(10L);

    // Act
    EndOfLifeStatus.calculateEndOfLifeStatus(eolDate);

    // Assert
    verify(eolDate).getTime();
  }
}
