package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRule.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowClassificationRuleDiffblueTest {
  /**
   * Test {@link FlowClassificationRule#provenance()}.
   *
   * <p>Method under test: {@link FlowClassificationRule#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FlowClassificationRule.provenance()"})
  void testProvenance() {
    // Arrange
    Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        "Provenance",
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .provenance());
  }

  /**
   * Test {@link FlowClassificationRule#kind()}.
   *
   * <p>Method under test: {@link FlowClassificationRule#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind FlowClassificationRule.kind()"})
  void testKind() {
    // Arrange
    Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .kind());
  }

  /**
   * Test {@link FlowClassificationRule#isReadonly()}.
   *
   * <p>Method under test: {@link FlowClassificationRule#isReadonly()}
   */
  @Test
  @DisplayName("Test isReadonly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FlowClassificationRule.isReadonly()"})
  void testIsReadonly() {
    // Arrange
    Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertFalse(
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .isReadonly());
  }

  /**
   * Test {@link FlowClassificationRule#messageSeverity()}.
   *
   * <p>Method under test: {@link FlowClassificationRule#messageSeverity()}
   */
  @Test
  @DisplayName("Test messageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity FlowClassificationRule.messageSeverity()"})
  void testMessageSeverity() {
    // Arrange
    Builder provenanceResult =
        ImmutableFlowClassificationRule.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .provenance("Provenance");

    Builder subjectOrgUnitReferenceResult =
        provenanceResult.subjectOrgUnitReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder subjectReferenceResult =
        subjectOrgUnitReferenceResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        MessageSeverity.NONE,
        subjectReferenceResult
            .vantagePointReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .messageSeverity());
  }
}
