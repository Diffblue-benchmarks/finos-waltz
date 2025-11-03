package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.service.workflow.ImmutableContextVariable.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableDiffblueTest {
  /**
   * Test Builder {@link Builder#entityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityRef(EntityReference)"})
  void testBuilderEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(ContextVariable)}.
   * <p>
   * Method under test: {@link Builder#from(ContextVariable)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariable)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ContextVariable<Object> instance = mock(ContextVariable.class);
    when(instance.entityRef()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
  }

  /**
   * Test Builder {@link Builder#from(ContextVariable)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ContextVariable)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariable); given 'Value'; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariable)"})
  void testBuilderFrom_givenValue_thenBuilderBuildNameIsName() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ContextVariable<Object> instance = mock(ContextVariable.class);
    when(instance.value()).thenReturn("Value");
    when(instance.name()).thenReturn("Name");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityRef();
    verify(instance).name();
    verify(instance).value();
    ImmutableContextVariable<Object> buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Value", buildResult.value());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariable)}.
   * <ul>
   *   <li>When {@link ContextVariable} {@link ContextVariable#value()} throw {@link IllegalStateException#IllegalStateException(String)} with {@code instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ContextVariable)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariable); when ContextVariable value() throw IllegalStateException(String) with 'instance'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariable)"})
  void testBuilderFrom_whenContextVariableValueThrowIllegalStateExceptionWithInstance() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ContextVariable<Object> instance = mock(ContextVariable.class);
    when(instance.value()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
    verify(instance).name();
    verify(instance).value();
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#value(Object)}.
   * <p>
   * Method under test: {@link Builder#value(Object)}
   */
  @Test
  @DisplayName("Test Builder value(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(Object)"})
  void testBuilderValue() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("Value"));
  }
}
