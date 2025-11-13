package org.finos.waltz.model.enduserapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.enduserapp.ImmutableEndUserApplication.Builder;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EndUserApplicationDiffblueTest {
  /**
   * Test {@link EndUserApplication#kind()}.
   *
   * <ul>
   *   <li>Then return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserApplication#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind EndUserApplication.kind()"})
  void testKind_thenReturnAll() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act and Assert
    assertEquals(
        EntityKind.ALL, provenanceResult.riskRating(CriticalityValue.of("42")).build().kind());
  }

  /**
   * Test {@link EndUserApplication#entityReference()}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link EndUserApplication#entityReference()}
   */
  @Test
  @DisplayName("Test entityReference(); then return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference EndUserApplication.entityReference()"})
  void testEntityReference_thenReturnImmutableEntityReference() {
    // Arrange
    Builder provenanceResult =
        ImmutableEndUserApplication.builder()
            .applicationKind("Application Kind")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isPromoted(true)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .provenance("Provenance");

    // Act
    EntityReference actualEntityReferenceResult =
        provenanceResult.riskRating(CriticalityValue.of("42")).build().entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualEntityReferenceResult.description());
    assertEquals(1L, actualEntityReferenceResult.id());
    assertEquals(EntityKind.END_USER_APPLICATION, actualEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityReferenceResult.entityLifecycleStatus());
  }
}
