package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkMeasurableRatingItemDiffblueTest {
  /**
   * Test {@link BulkMeasurableRatingItem#isPrimary()}.
   *
   * <p>Method under test: {@link BulkMeasurableRatingItem#isPrimary()}
   */
  @Test
  @DisplayName("Test isPrimary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BulkMeasurableRatingItem.isPrimary()"})
  void testIsPrimary() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableBulkMeasurableRatingItem.builder()
            .allocation(1)
            .assetCode("Asset Code")
            .comment("Comment")
            .ratingCode('A')
            .scheme("Scheme")
            .taxonomyExternalId("42")
            .build()
            .isPrimary());
  }
}
