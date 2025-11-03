package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.ImmutableContextVariableDeclaration.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableDeclarationDiffblueTest {
  /**
   * Test Builder {@link Builder#from(ContextVariableDeclaration)}.
   * <p>
   * Method under test: {@link Builder#from(ContextVariableDeclaration)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableDeclaration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableDeclaration)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableContextVariableDeclaration.builder();
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.ref()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).ref();
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableDeclaration)}.
   * <p>
   * Method under test: {@link Builder#from(ContextVariableDeclaration)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableDeclaration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableDeclaration)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableContextVariableDeclaration.builder();
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableDeclaration)}.
   * <ul>
   *   <li>Given {@link ContextVariableReference}.</li>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ContextVariableDeclaration)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableDeclaration); given ContextVariableReference; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableDeclaration)"})
  void testBuilderFrom_givenContextVariableReference_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableContextVariableDeclaration.builder();
    ContextVariableDeclaration instance = mock(ContextVariableDeclaration.class);
    when(instance.ref()).thenReturn(mock(ContextVariableReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).ref();
    assertEquals("Name", builderResult.build().name());
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableContextVariableDeclaration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#ref(ContextVariableReference)}.
   * <ul>
   *   <li>When {@link ContextVariableReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ref(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder ref(ContextVariableReference); when ContextVariableReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ref(ContextVariableReference)"})
  void testBuilderRef_whenContextVariableReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableContextVariableDeclaration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ref(mock(ContextVariableReference.class)));
  }
}
