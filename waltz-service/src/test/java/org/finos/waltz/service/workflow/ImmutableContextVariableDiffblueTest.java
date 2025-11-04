package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableContextVariable.Builder#entityRef(EntityReference)}
   */
  @Test
  void testBuilderEntityRef() {
    // Arrange
    ImmutableContextVariable.Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariable.Builder#from(ContextVariable)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableContextVariable.Builder<Object> builderResult = ImmutableContextVariable.builder();
    ContextVariable<Object> instance = mock(ContextVariable.class);
    when(instance.entityRef()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityRef();
  }

  /**
   * Method under test:
   * {@link ImmutableContextVariable.Builder#from(ContextVariable)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableContextVariable.Builder<Object> builderResult = ImmutableContextVariable.builder();
    ContextVariable<Object> instance = mock(ContextVariable.class);
    when(instance.value()).thenReturn("Value");
    when(instance.name()).thenReturn("Name");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableContextVariable.Builder<Object> actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableContextVariable.Builder#from(ContextVariable)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableContextVariable.Builder<Object> builderResult = ImmutableContextVariable.builder();
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
   * Method under test: {@link ImmutableContextVariable.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableContextVariable.Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableContextVariable.Builder#value(Object)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableContextVariable.Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("Value"));
  }

  /**
   * Method under test: {@link ImmutableContextVariable#copyOf(ContextVariable)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ContextVariable<Object> instance = mock(ContextVariable.class);
    when(instance.value()).thenReturn("Value");
    when(instance.name()).thenReturn("Name");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableContextVariable<Object> actualCopyOfResult = ImmutableContextVariable.copyOf(instance);

    // Assert
    verify(instance).entityRef();
    verify(instance).name();
    verify(instance).value();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Value", actualCopyOfResult.value());
  }
}
