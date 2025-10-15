package org.finos.waltz.model.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.roadmap.ImmutableRoadmap.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoadmapDiffblueTest {
  /**
   * Test {@link Roadmap#entityReference()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link Roadmap#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Roadmap.entityReference()"})
  void testEntityReference_thenReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRoadmap.builder();

    Builder ratingSchemeIdResult =
        builderResult
            .columnType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    EntityReference actualEntityReferenceResult =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.ROADMAP, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
