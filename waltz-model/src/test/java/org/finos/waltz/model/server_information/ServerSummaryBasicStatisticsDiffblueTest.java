package org.finos.waltz.model.server_information;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServerSummaryBasicStatisticsDiffblueTest {
  /**
   * Test {@link ServerSummaryBasicStatistics#totalCount()}.
   *
   * <p>Method under test: {@link ServerSummaryBasicStatistics#totalCount()}
   */
  @Test
  @DisplayName("Test totalCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ServerSummaryBasicStatistics.totalCount()"})
  void testTotalCount() {
    // Arrange, Act and Assert
    assertEquals(
        6L,
        ImmutableServerSummaryBasicStatistics.builder()
            .physicalCount(3L)
            .virtualCount(3L)
            .build()
            .totalCount());
  }
}
