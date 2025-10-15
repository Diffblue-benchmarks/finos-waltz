package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.cost.ImmutableCost.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CostDiffblueTest {
  /**
   * Test {@link Cost#kind()}.
   *
   * <p>Method under test: {@link Cost#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Cost.kind()"})
  void testKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build()
            .kind());
  }
}
