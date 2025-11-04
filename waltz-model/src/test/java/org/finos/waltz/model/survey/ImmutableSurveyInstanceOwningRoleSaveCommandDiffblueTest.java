package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceOwningRoleSaveCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceOwningRoleSaveCommand.Builder#build()}
   *   <li>
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand.Builder#owningRole(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals("Owning Role",
        ImmutableSurveyInstanceOwningRoleSaveCommand.builder().owningRole("Owning Role").build().owningRole());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand.Builder#from(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand.Builder builderResult = ImmutableSurveyInstanceOwningRoleSaveCommand
        .builder();
    SurveyInstanceOwningRoleSaveCommand instance = mock(SurveyInstanceOwningRoleSaveCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");

    // Act
    ImmutableSurveyInstanceOwningRoleSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).owningRole();
    assertEquals("Owning Role", actualFromResult.build().owningRole());
    assertEquals("Owning Role", builderResult.build().owningRole());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand.Builder#from(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand.Builder builderResult = ImmutableSurveyInstanceOwningRoleSaveCommand
        .builder();
    SurveyInstanceOwningRoleSaveCommand instance = mock(SurveyInstanceOwningRoleSaveCommand.class);
    when(instance.owningRole()).thenReturn(null);

    // Act
    ImmutableSurveyInstanceOwningRoleSaveCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).owningRole();
    assertNull(actualFromResult.build().owningRole());
    assertNull(builderResult.build().owningRole());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand#copyOf(SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceOwningRoleSaveCommand instance = mock(SurveyInstanceOwningRoleSaveCommand.class);
    when(instance.owningRole()).thenReturn("Owning Role");

    // Act
    ImmutableSurveyInstanceOwningRoleSaveCommand actualCopyOfResult = ImmutableSurveyInstanceOwningRoleSaveCommand
        .copyOf(instance);

    // Assert
    verify(instance).owningRole();
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(ImmutableSurveyInstanceOwningRoleSaveCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange, Act and Assert
    assertNull(
        ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(new ImmutableSurveyInstanceOwningRoleSaveCommand.Json())
            .owningRole());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand#fromJson(ImmutableSurveyInstanceOwningRoleSaveCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSurveyInstanceOwningRoleSaveCommand.Json json = new ImmutableSurveyInstanceOwningRoleSaveCommand.Json();
    json.setOwningRole("Json");

    // Act and Assert
    assertEquals("Json", ImmutableSurveyInstanceOwningRoleSaveCommand.fromJson(json).owningRole());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand.Json}
   *   <li>
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand.Json#setOwningRole(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSurveyInstanceOwningRoleSaveCommand.Json actualJson = new ImmutableSurveyInstanceOwningRoleSaveCommand.Json();
    actualJson.setOwningRole("Owning Role");

    // Assert
    assertEquals("Owning Role", actualJson.owningRole);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceOwningRoleSaveCommand.Json#owningRole()}
   */
  @Test
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceOwningRoleSaveCommand.Json()).owningRole());
  }
}
