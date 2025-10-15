package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MeasurableRatingDiffblueTest {
  /**
   * Test {@link MeasurableRating#isReadOnly()}.
   *
   * <p>Method under test: {@link MeasurableRating#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRating.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertFalse(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build()
            .isReadOnly());
  }

  /**
   * Test {@link MeasurableRating#isPrimary()}.
   *
   * <p>Method under test: {@link MeasurableRating#isPrimary()}
   */
  @Test
  @DisplayName("Test isPrimary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRating.isPrimary()"})
  void testIsPrimary() {
    // Arrange
    Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertFalse(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build()
            .isPrimary());
  }
}
