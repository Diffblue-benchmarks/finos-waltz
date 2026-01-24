package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RatingSchemeDiffblueTest {
  /**
   * Test {@link RatingScheme#toList()}.
   *
   * <p>Method under test: {@link RatingScheme#toList()}
   */
  @Test
  @DisplayName("Test toList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List RatingScheme.toList()"})
  void testToList() {
    // Arrange and Act
    List<RatingSchemeItem> actualToListResult = RatingScheme.toList();

    // Assert
    assertEquals(6, actualToListResult.size());
    assertTrue(actualToListResult.get(0) instanceof ImmutableRatingSchemeItem);
    assertTrue(actualToListResult.get(1) instanceof ImmutableRatingSchemeItem);
    assertTrue(actualToListResult.get(2) instanceof ImmutableRatingSchemeItem);
    assertTrue(actualToListResult.get(3) instanceof ImmutableRatingSchemeItem);
    assertTrue(actualToListResult.get(4) instanceof ImmutableRatingSchemeItem);
    assertTrue(actualToListResult.get(5) instanceof ImmutableRatingSchemeItem);
  }
}
