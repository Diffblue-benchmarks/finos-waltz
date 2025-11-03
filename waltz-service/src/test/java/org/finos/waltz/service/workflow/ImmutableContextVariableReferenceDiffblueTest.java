package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.service.workflow.ImmutableContextVariableReference.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then builder build externalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference); given '42'; then builder build externalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFrom_given42_thenBuilderBuildExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenReturn("42");
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).kind();
    ImmutableContextVariableReference buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariableReference)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ContextVariableReference)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariableReference); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ContextVariableReference)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();
    ContextVariableReference instance = mock(ContextVariableReference.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableContextVariableReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }
}
