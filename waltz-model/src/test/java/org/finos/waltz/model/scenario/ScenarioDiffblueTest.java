package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ScenarioDiffblueTest {
  /**
   * Test {@link Scenario#entityReference()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link Scenario#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Scenario.entityReference()"})
  void testEntityReference_thenReturnImmutableEntityReference() {
    // Arrange and Act
    EntityReference actualEntityReferenceResult =
        ImmutableScenario.builder()
            .description("The characteristics of someone or something")
            .effectiveDate(LocalDate.of(1970, 1, 1))
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .releaseStatus(ReleaseLifecycleStatus.DRAFT)
            .roadmapId(1L)
            .scenarioType(ScenarioType.TARGET)
            .build()
            .entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.SCENARIO, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
