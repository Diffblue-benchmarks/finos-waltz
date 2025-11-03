package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableSetAttributeCommand.Builder;
import org.finos.waltz.model.ImmutableSetAttributeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSetAttributeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(new ImmutableEntityReference.Json()));
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SetAttributeCommand)} with {@code SetAttributeCommand}.
   * <ul>
   *   <li>Given {@link ImmutableEntityReference.Json} (default constructor).</li>
   *   <li>Then builder build value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SetAttributeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SetAttributeCommand) with 'SetAttributeCommand'; given Json (default constructor); then builder build value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SetAttributeCommand)"})
  void testBuilderFromWithSetAttributeCommand_givenJson_thenBuilderBuildValueIs42() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    SetAttributeCommand instance = mock(SetAttributeCommand.class);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).entityReference();
    verify(instance).value();
    ImmutableSetAttributeCommand buildResult = builderResult.build();
    assertEquals("42", buildResult.value());
    assertEquals("Name", buildResult.name());
    assertSame(json, buildResult.entityReference());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SetAttributeCommand)} with {@code SetAttributeCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SetAttributeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SetAttributeCommand) with 'SetAttributeCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SetAttributeCommand)"})
  void testBuilderFromWithSetAttributeCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();
    SetAttributeCommand instance = mock(SetAttributeCommand.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).entityReference();
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
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   * <p>
   * Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue() {
    // Arrange
    Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityReference(EntityReference)", "void Json.setName(String)",
      "void Json.setValue(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(new ImmutableEntityReference.Json());
    actualJson.setName("Name");
    actualJson.setValue("42");

    // Assert
    assertFalse(((ImmutableEntityReference.Json) actualJson.entityReference).externalId.isPresent());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json {@link Json#value()}.
   * <p>
   * Method under test: {@link Json#value()}
   */
  @Test
  @DisplayName("Test Json value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.value()"})
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).value());
  }
}
