package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.logical_flow.ImmutableFlowInfo.Builder;
import org.finos.waltz.model.logical_flow.ImmutableFlowInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#actualDataType(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#actualDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder actualDataType(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.actualDataType(EntityReference)"})
  void testBuilderActualDataType_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.actualDataType(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#classificationId(Long)}.
   * <p>
   * Method under test: {@link Builder#classificationId(Long)}
   */
  @Test
  @DisplayName("Test Builder classificationId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.classificationId(Long)"})
  void testBuilderClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.classificationId(1L));
  }

  /**
   * Test Builder {@link Builder#counterpart(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#counterpart(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder counterpart(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.counterpart(EntityReference)"})
  void testBuilderCounterpart_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.counterpart(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#flowEntityLifecycleStatus(EntityLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#flowEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder flowEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowEntityLifecycleStatus(EntityLifecycleStatus)"})
  void testBuilderFlowEntityLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE));
  }

  /**
   * Test Builder {@link Builder#flowId(Long)}.
   * <p>
   * Method under test: {@link Builder#flowId(Long)}
   */
  @Test
  @DisplayName("Test Builder flowId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowId(Long)"})
  void testBuilderFlowId() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowId(1L));
  }

  /**
   * Test Builder {@link Builder#from(FlowInfo)}.
   * <ul>
   *   <li>Then builder build classificationId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(FlowInfo); then builder build classificationId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowInfo)"})
  void testBuilderFrom_thenBuilderBuildClassificationIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.actualDataType()).thenReturn(mock(EntityReference.class));
    when(instance.rollupDataType()).thenReturn(mock(EntityReference.class));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).actualDataType();
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
    ImmutableFlowInfo buildResult = builderResult.build();
    assertEquals(1L, buildResult.classificationId().longValue());
    assertEquals(1L, buildResult.flowId().longValue());
    assertEquals(EntityLifecycleStatus.ACTIVE, buildResult.flowEntityLifecycleStatus());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowInfo)}.
   * <ul>
   *   <li>When {@link FlowInfo} {@link FlowInfo#actualDataType()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(FlowInfo); when FlowInfo actualDataType() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowInfo)"})
  void testBuilderFrom_whenFlowInfoActualDataTypeThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.actualDataType()).thenThrow(new IllegalStateException("instance"));
    when(instance.rollupDataType()).thenReturn(mock(EntityReference.class));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).actualDataType();
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
  }

  /**
   * Test Builder {@link Builder#from(FlowInfo)}.
   * <ul>
   *   <li>When {@link FlowInfo} {@link FlowInfo#counterpart()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(FlowInfo); when FlowInfo counterpart() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowInfo)"})
  void testBuilderFrom_whenFlowInfoCounterpartThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.counterpart()).thenThrow(new IllegalStateException("instance"));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
  }

  /**
   * Test Builder {@link Builder#from(FlowInfo)}.
   * <ul>
   *   <li>When {@link FlowInfo} {@link FlowInfo#rollupDataType()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(FlowInfo)}
   */
  @Test
  @DisplayName("Test Builder from(FlowInfo); when FlowInfo rollupDataType() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(FlowInfo)"})
  void testBuilderFrom_whenFlowInfoRollupDataTypeThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();
    FlowInfo instance = mock(FlowInfo.class);
    when(instance.rollupDataType()).thenThrow(new IllegalStateException("instance"));
    when(instance.counterpart()).thenReturn(mock(EntityReference.class));
    when(instance.classificationId()).thenReturn(1L);
    when(instance.flowId()).thenReturn(1L);
    when(instance.flowEntityLifecycleStatus()).thenReturn(EntityLifecycleStatus.ACTIVE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).classificationId();
    verify(instance).counterpart();
    verify(instance).flowEntityLifecycleStatus();
    verify(instance).flowId();
    verify(instance).rollupDataType();
  }

  /**
   * Test Builder {@link Builder#rollupDataType(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#rollupDataType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder rollupDataType(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rollupDataType(EntityReference)"})
  void testBuilderRollupDataType_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rollupDataType(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#actualDataType()}.
   * <p>
   * Method under test: {@link Json#actualDataType()}
   */
  @Test
  @DisplayName("Test Json actualDataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.actualDataType()"})
  void testJsonActualDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).actualDataType());
  }

  /**
   * Test Json {@link Json#classificationId()}.
   * <p>
   * Method under test: {@link Json#classificationId()}
   */
  @Test
  @DisplayName("Test Json classificationId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.classificationId()"})
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).classificationId());
  }

  /**
   * Test Json {@link Json#counterpart()}.
   * <p>
   * Method under test: {@link Json#counterpart()}
   */
  @Test
  @DisplayName("Test Json counterpart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.counterpart()"})
  void testJsonCounterpart() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).counterpart());
  }

  /**
   * Test Json {@link Json#flowEntityLifecycleStatus()}.
   * <p>
   * Method under test: {@link Json#flowEntityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json flowEntityLifecycleStatus()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityLifecycleStatus Json.flowEntityLifecycleStatus()"})
  void testJsonFlowEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowEntityLifecycleStatus());
  }

  /**
   * Test Json {@link Json#flowId()}.
   * <p>
   * Method under test: {@link Json#flowId()}
   */
  @Test
  @DisplayName("Test Json flowId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.flowId()"})
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).flowId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setActualDataType(EntityReference)}
   *   <li>{@link Json#setClassificationId(Long)}
   *   <li>{@link Json#setCounterpart(EntityReference)}
   *   <li>{@link Json#setFlowEntityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Json#setFlowId(Long)}
   *   <li>{@link Json#setRollupDataType(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setActualDataType(EntityReference)",
      "void Json.setClassificationId(Long)", "void Json.setCounterpart(EntityReference)",
      "void Json.setFlowEntityLifecycleStatus(EntityLifecycleStatus)", "void Json.setFlowId(Long)",
      "void Json.setRollupDataType(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setActualDataType(null);
    actualJson.setClassificationId(1L);
    actualJson.setCounterpart(null);
    actualJson.setFlowEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);
    actualJson.setFlowId(1L);
    actualJson.setRollupDataType(null);

    // Assert
    assertEquals(1L, actualJson.classificationId.longValue());
    assertEquals(1L, actualJson.flowId.longValue());
  }

  /**
   * Test Json {@link Json#rollupDataType()}.
   * <p>
   * Method under test: {@link Json#rollupDataType()}
   */
  @Test
  @DisplayName("Test Json rollupDataType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.rollupDataType()"})
  void testJsonRollupDataType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rollupDataType());
  }
}
