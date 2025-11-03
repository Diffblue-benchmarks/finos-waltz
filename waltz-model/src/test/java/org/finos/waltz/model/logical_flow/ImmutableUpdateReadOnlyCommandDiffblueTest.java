package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.logical_flow.ImmutableUpdateReadOnlyCommand.Builder;
import org.finos.waltz.model.logical_flow.ImmutableUpdateReadOnlyCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateReadOnlyCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UpdateReadOnlyCommand)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build readOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateReadOnlyCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateReadOnlyCommand); given 'true'; then builder build readOnly")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateReadOnlyCommand)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildReadOnly() {
    // Arrange
    Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();
    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).readOnly();
    assertTrue(builderResult.build().readOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateReadOnlyCommand)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateReadOnlyCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateReadOnlyCommand); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateReadOnlyCommand)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();
    UpdateReadOnlyCommand instance = mock(UpdateReadOnlyCommand.class);
    when(instance.readOnly()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).readOnly();
  }

  /**
   * Test Builder {@link Builder#readOnly(boolean)}.
   * <p>
   * Method under test: {@link Builder#readOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder readOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.readOnly(boolean)"})
  void testBuilderReadOnly() {
    // Arrange
    Builder builderResult = ImmutableUpdateReadOnlyCommand.builder();

    // Act
    Builder actualReadOnlyResult = builderResult.readOnly(true);

    // Assert
    assertTrue(builderResult.build().readOnly());
    assertSame(builderResult, actualReadOnlyResult);
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertFalse(actualJson.readOnly);
    assertFalse(actualJson.readOnlyIsSet);
  }

  /**
   * Test Json {@link Json#readOnly()}.
   * <p>
   * Method under test: {@link Json#readOnly()}
   */
  @Test
  @DisplayName("Test Json readOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.readOnly()"})
  void testJsonReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).readOnly());
  }

  /**
   * Test Json {@link Json#setReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Json#setReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setReadOnly(boolean)"})
  void testJsonSetReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setReadOnly(true);

    // Assert
    assertTrue(json.readOnly);
    assertTrue(json.readOnlyIsSet);
  }
}
