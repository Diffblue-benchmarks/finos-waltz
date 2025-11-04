package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableSetAttributeCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSetAttributeCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(new ImmutableEntityReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSetAttributeCommand.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetAttributeCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSetAttributeCommand.Builder#from(SetAttributeCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();
    SetAttributeCommand instance = mock(SetAttributeCommand.class);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetAttributeCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSetAttributeCommand.Builder#from(SetAttributeCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();
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
   * Method under test: {@link ImmutableSetAttributeCommand.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSetAttributeCommand.Builder#value(String)}
   */
  @Test
  void testBuilderValue() {
    // Arrange
    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.value("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSetAttributeCommand#copyOf(SetAttributeCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SetAttributeCommand instance = mock(SetAttributeCommand.class);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.entityReference()).thenReturn(json);
    when(instance.value()).thenReturn("42");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSetAttributeCommand actualCopyOfResult = ImmutableSetAttributeCommand.copyOf(instance);

    // Assert
    verify(instance).name();
    verify(instance).entityReference();
    verify(instance).value();
    assertEquals("42", actualCopyOfResult.value());
    assertEquals("Name", actualCopyOfResult.name());
    assertSame(json, actualCopyOfResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableSetAttributeCommand#fromJson(ImmutableSetAttributeCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSetAttributeCommand.Json json = new ImmutableSetAttributeCommand.Json();
    json.setName("Json");
    ImmutableEntityReference.Json entityReference = new ImmutableEntityReference.Json();
    json.setEntityReference(entityReference);
    json.setValue("Json");

    // Act
    ImmutableSetAttributeCommand actualFromJsonResult = ImmutableSetAttributeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.value());
    assertSame(entityReference, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test:
   * {@link ImmutableSetAttributeCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSetAttributeCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSetAttributeCommand.Json}
   *   <li>
   * {@link ImmutableSetAttributeCommand.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableSetAttributeCommand.Json#setName(String)}
   *   <li>{@link ImmutableSetAttributeCommand.Json#setValue(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSetAttributeCommand.Json actualJson = new ImmutableSetAttributeCommand.Json();
    actualJson.setEntityReference(new ImmutableEntityReference.Json());
    actualJson.setName("Name");
    actualJson.setValue("42");

    // Assert
    assertFalse(((ImmutableEntityReference.Json) actualJson.entityReference).externalId.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSetAttributeCommand.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSetAttributeCommand.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableSetAttributeCommand.Json#value()}
   */
  @Test
  void testJsonValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSetAttributeCommand.Json()).value());
  }
}
