package org.finos.waltz.jobs.tools.flows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.flows.ImmutableFlowUpdateCommand.Builder;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowUpdateCommandDiffblueTest {
  /**
   * Test {@link ImmutableFlowUpdateCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFlowUpdateCommand#builder()}
   *   <li>{@link ImmutableFlowUpdateCommand#logicalFlowId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableFlowUpdateCommand Builder.build()", "Builder Builder.logicalFlowId(Long)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableFlowUpdateCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.logicalFlowId(1L));
  }

  /**
   * Test Builder {@link Builder#action(FlowUpdateCommandType)}.
   * <p>
   * Method under test: {@link Builder#action(FlowUpdateCommandType)}
   */
  @Test
  @DisplayName("Test Builder action(FlowUpdateCommandType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.action(FlowUpdateCommandType)"})
  void testBuilderAction() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.action(FlowUpdateCommandType.ADD));
  }

  /**
   * Test Builder {@link Builder#dataTypeRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dataTypeRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeRef(EntityReference)"})
  void testBuilderDataTypeRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dataTypeRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.sourceEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).sourceEntityRef();
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.targetEntityRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.dataTypeRef()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   * <p>
   * Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenThrow(new IllegalStateException("instance"));
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build logicalFlowId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand); given one; then builder build logicalFlowId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom_givenOne_thenBuilderBuildLogicalFlowIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenReturn(1L);
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    ImmutableFlowUpdateCommand buildResult = builderResult.build();
    assertEquals(1L, buildResult.logicalFlowId().longValue());
    assertEquals(FlowUpdateCommandType.ADD, buildResult.action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowUpdateCommand)}.
   * <ul>
   *   <li>Then builder build logicalFlowId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowUpdateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(FlowUpdateCommand); then builder build logicalFlowId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowUpdateCommand)"})
  void testBuilderFrom_thenBuilderBuildLogicalFlowIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();
    FlowUpdateCommand instance = mock(FlowUpdateCommand.class);
    when(instance.logicalFlowId()).thenReturn(null);
    when(instance.dataTypeRef()).thenReturn(mock(EntityReference.class));
    when(instance.targetEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.sourceEntityRef()).thenReturn(mock(EntityReference.class));
    when(instance.action()).thenReturn(FlowUpdateCommandType.ADD);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).action();
    verify(instance).dataTypeRef();
    verify(instance).logicalFlowId();
    verify(instance).sourceEntityRef();
    verify(instance).targetEntityRef();
    ImmutableFlowUpdateCommand buildResult = builderResult.build();
    assertNull(buildResult.logicalFlowId());
    assertEquals(FlowUpdateCommandType.ADD, buildResult.action());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#sourceEntityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#sourceEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder sourceEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceEntityRef(EntityReference)"})
  void testBuilderSourceEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceEntityRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#targetEntityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#targetEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder targetEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetEntityRef(EntityReference)"})
  void testBuilderTargetEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowUpdateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityRef(mock(EntityReference.class)));
  }
}
