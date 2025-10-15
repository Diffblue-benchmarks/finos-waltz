package org.finos.waltz.model.accesslog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccessLogDiffblueTest {
  /**
   * Test {@link AccessLog#createdAt()}.
   *
   * <p>Method under test: {@link AccessLog#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime AccessLog.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualCreatedAtResult =
        ImmutableAccessLog.builder()
            .createdAt(ofResult.atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }
}
