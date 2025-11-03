package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableUpdateNameCommand.Builder;
import org.finos.waltz.model.ImmutableUpdateNameCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateNameCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UpdateNameCommand)}.
   * <ul>
   *   <li>Given {@code New Name}.</li>
   *   <li>Then builder build newName is {@code New Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateNameCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateNameCommand); given 'New Name'; then builder build newName is 'New Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateNameCommand)"})
  void testBuilderFrom_givenNewName_thenBuilderBuildNewNameIsNewName() {
    // Arrange
    Builder builderResult = ImmutableUpdateNameCommand.builder();
    UpdateNameCommand instance = mock(UpdateNameCommand.class);
    when(instance.newName()).thenReturn("New Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).newName();
    assertEquals("New Name", builderResult.build().newName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#newName(String)}.
   * <p>
   * Method under test: {@link Builder#newName(String)}
   */
  @Test
  @DisplayName("Test Builder newName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.newName(String)"})
  void testBuilderNewName() {
    // Arrange
    Builder builderResult = ImmutableUpdateNameCommand.builder();

    // Act
    Builder actualNewNameResult = builderResult.newName("New Name");

    // Assert
    assertEquals("New Name", builderResult.build().newName());
    assertSame(builderResult, actualNewNameResult);
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setNewName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setNewName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setNewName("New Name");

    // Assert
    assertEquals("New Name", actualJson.newName);
  }

  /**
   * Test Json {@link Json#newName()}.
   * <p>
   * Method under test: {@link Json#newName()}
   */
  @Test
  @DisplayName("Test Json newName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.newName()"})
  void testJsonNewName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).newName());
  }
}
