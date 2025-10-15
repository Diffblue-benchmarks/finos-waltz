package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlowClassificationServiceDiffblueTest {
  @Mock private FlowClassificationDao flowClassificationDao;

  @InjectMocks private FlowClassificationService flowClassificationService;

  /**
   * Test {@link FlowClassificationService#getById(long)}.
   *
   * <p>Method under test: {@link FlowClassificationService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FlowClassification FlowClassificationService.getById(long)"})
  void testGetById() {
    // Arrange
    when(flowClassificationDao.getById(anyLong()))
        .thenReturn(
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
                .build());

    // Act
    FlowClassification actualById = flowClassificationService.getById(1L);

    // Assert
    verify(flowClassificationDao).getById(1L);
    assertTrue(actualById instanceof ImmutableFlowClassification);
    assertEquals("Code", actualById.code());
    assertEquals("Color", actualById.color());
    assertEquals("Default Message", actualById.defaultMessage());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.position());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(FlowDirection.INBOUND, actualById.direction());
    assertEquals(MessageSeverity.NONE, actualById.messageSeverity());
    assertTrue(actualById.isCustom());
    assertTrue(actualById.userSelectable());
  }

  /**
   * Test {@link FlowClassificationService#findAll()}.
   *
   * <p>Method under test: {@link FlowClassificationService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationService.findAll()"})
  void testFindAll() {
    // Arrange
    when(flowClassificationDao.findAll()).thenReturn(new HashSet<>());

    // Act
    Set<FlowClassification> actualFindAllResult = flowClassificationService.findAll();

    // Assert
    verify(flowClassificationDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }
}
