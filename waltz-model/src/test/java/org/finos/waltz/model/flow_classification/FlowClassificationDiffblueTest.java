package org.finos.waltz.model.flow_classification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.MessageSeverity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowClassificationDiffblueTest {
  /**
   * Test {@link FlowClassification#direction()}.
   *
   * <ul>
   *   <li>Then return {@code INBOUND}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassification#direction()}
   */
  @Test
  @DisplayName("Test direction(); then return 'INBOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowDirection FlowClassification.direction()"})
  void testDirection_thenReturnInbound() {
    // Arrange, Act and Assert
    assertEquals(
        FlowDirection.INBOUND,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .direction());
  }

  /**
   * Test {@link FlowClassification#messageSeverity()}.
   *
   * <ul>
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassification#messageSeverity()}
   */
  @Test
  @DisplayName("Test messageSeverity(); then return 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity FlowClassification.messageSeverity()"})
  void testMessageSeverity_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals(
        MessageSeverity.NONE,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .messageSeverity());
  }

  /**
   * Test {@link FlowClassification#kind()}.
   *
   * <ul>
   *   <li>Then return {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassification#kind()}
   */
  @Test
  @DisplayName("Test kind(); then return 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind FlowClassification.kind()"})
  void testKind_thenReturnAll() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build()
            .kind());
  }
}
