package org.finos.waltz.model.role;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableRoleDiffblueTest {
  /**
   * Method under test: {@link ImmutableRole.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRole.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRole.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#from(Role)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(true);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRole.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    ImmutableRole buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#from(Role)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();
    Role instance = mock(Role.class);
    when(instance.userSelectable()).thenThrow(new IllegalStateException("instance"));
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).name();
    verify(instance).userSelectable();
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#from(Role)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(true);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRole.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    ImmutableRole buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#isCustom(boolean)}
   */
  @Test
  void testBuilderIsCustom() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isCustom(true));
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#key(String)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableRole.Builder#userSelectable(boolean)}
   */
  @Test
  void testBuilderUserSelectable() {
    // Arrange
    ImmutableRole.Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
  }

  /**
   * Method under test: {@link ImmutableRole#copyOf(Role)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(true);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRole actualCopyOfResult = ImmutableRole.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRole#copyOf(Role)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(false);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRole actualCopyOfResult = ImmutableRole.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertFalse(actualCopyOfResult.userSelectable());
    assertTrue(actualCopyOfResult.isCustom());
  }

  /**
   * Method under test: {@link ImmutableRole#copyOf(Role)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(true);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRole actualCopyOfResult = ImmutableRole.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRole.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRole.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableRole.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRole.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableRole.Json#isCustom()}
   */
  @Test
  void testJsonIsCustom() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRole.Json()).isCustom());
  }

  /**
   * Method under test: {@link ImmutableRole.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRole.Json()).key());
  }

  /**
   * Method under test: {@link ImmutableRole.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRole.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRole.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRole.Json actualJson = new ImmutableRole.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.key);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isCustom);
    assertFalse(actualJson.isCustomIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableRole.Json#setIsCustom(boolean)}
   */
  @Test
  void testJsonSetIsCustom() {
    // Arrange
    ImmutableRole.Json json = new ImmutableRole.Json();

    // Act
    json.setIsCustom(true);

    // Assert
    assertTrue(json.isCustom);
    assertTrue(json.isCustomIsSet);
  }

  /**
   * Method under test: {@link ImmutableRole.Json#setUserSelectable(boolean)}
   */
  @Test
  void testJsonSetUserSelectable() {
    // Arrange
    ImmutableRole.Json json = new ImmutableRole.Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableRole.Json#userSelectable()}
   */
  @Test
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRole.Json()).userSelectable());
  }
}
