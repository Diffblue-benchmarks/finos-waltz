package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowClassificationRuleVantagePointDiffblueTest {
  /**
   * Test {@link FlowClassificationRuleVantagePoint#messageSeverity()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleVantagePoint#messageSeverity()}
   */
  @Test
  @DisplayName("Test messageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity FlowClassificationRuleVantagePoint.messageSeverity()"})
  void testMessageSeverity() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
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
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .messageSeverity());
  }
}
