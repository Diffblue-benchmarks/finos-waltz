package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableFieldChangeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableFieldChange.Builder#build()}
   *   <li>{@link ImmutableFieldChange.Builder#description(String)}
   *   <li>{@link ImmutableFieldChange.Builder#newVal(Object)}
   *   <li>{@link ImmutableFieldChange.Builder#oldVal(Object)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableFieldChange.Builder<Object> builderResult = ImmutableFieldChange.builder();

    // Act
    ImmutableFieldChange<Object> actualBuildResult = builderResult
        .description("The characteristics of someone or something")
        .newVal("New Val")
        .oldVal("Old Val")
        .build();

    // Assert
    assertEquals("New Val", actualBuildResult.newVal());
    assertEquals("Old Val", actualBuildResult.oldVal());
    assertEquals("The characteristics of someone or something", actualBuildResult.description());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableFieldChange.Builder<Object> builderResult = ImmutableFieldChange.builder();
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn("New Val");
    when(instance.oldVal()).thenReturn("Old Val");
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFieldChange.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableFieldChange<Object> buildResult = builderResult.build();
    assertEquals("New Val", buildResult.newVal());
    assertEquals("Old Val", buildResult.oldVal());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableFieldChange.Builder<Object> builderResult = ImmutableFieldChange.builder();
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn(null);
    when(instance.oldVal()).thenReturn("Old Val");
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFieldChange.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableFieldChange<Object> buildResult = builderResult.build();
    assertEquals("Old Val", buildResult.oldVal());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.newVal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableFieldChange.Builder<Object> builderResult = ImmutableFieldChange.builder();
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn("New Val");
    when(instance.oldVal()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFieldChange.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableFieldChange<Object> buildResult = builderResult.build();
    assertEquals("New Val", buildResult.newVal());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.oldVal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Builder#from(FieldChange)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableFieldChange.Builder<Object> builderResult = ImmutableFieldChange.builder();
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn("New Val");
    when(instance.oldVal()).thenReturn("Old Val");
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableFieldChange.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableFieldChange<Object> buildResult = builderResult.build();
    assertEquals("New Val", buildResult.newVal());
    assertEquals("Old Val", buildResult.oldVal());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn("New Val");
    when(instance.oldVal()).thenReturn("Old Val");
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFieldChange<Object> actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    assertEquals("New Val", actualCopyOfResult.newVal());
    assertEquals("Old Val", actualCopyOfResult.oldVal());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn(null);
    when(instance.oldVal()).thenReturn("Old Val");
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFieldChange<Object> actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    assertEquals("Old Val", actualCopyOfResult.oldVal());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.newVal());
  }

  /**
   * Method under test: {@link ImmutableFieldChange#copyOf(FieldChange)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    FieldChange<Object> instance = mock(FieldChange.class);
    when(instance.newVal()).thenReturn("New Val");
    when(instance.oldVal()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableFieldChange<Object> actualCopyOfResult = ImmutableFieldChange.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    assertEquals("New Val", actualCopyOfResult.newVal());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.oldVal());
  }

  /**
   * Method under test:
   * {@link ImmutableFieldChange#fromJson(ImmutableFieldChange.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange and Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange
        .fromJson(new ImmutableFieldChange.Json<>());

    // Assert
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Method under test:
   * {@link ImmutableFieldChange#fromJson(ImmutableFieldChange.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableFieldChange.Json<Object> json = new ImmutableFieldChange.Json<>();
    json.setNewVal(null);
    json.setOldVal(null);
    json.setDescription("Json");

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
  }

  /**
   * Method under test:
   * {@link ImmutableFieldChange#fromJson(ImmutableFieldChange.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableFieldChange.Json<Object> json = new ImmutableFieldChange.Json<>();
    json.setNewVal(null);
    json.setOldVal("Json");
    json.setDescription(null);

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    Object oldValResult = actualFromJsonResult.oldVal();
    assertEquals("Json", oldValResult);
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.description());
    assertSame(json.oldVal, oldValResult);
  }

  /**
   * Method under test:
   * {@link ImmutableFieldChange#fromJson(ImmutableFieldChange.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableFieldChange.Json<Object> json = new ImmutableFieldChange.Json<>();
    json.setNewVal("Json");
    json.setOldVal(null);
    json.setDescription(null);

    // Act
    ImmutableFieldChange<Object> actualFromJsonResult = ImmutableFieldChange.fromJson(json);

    // Assert
    Object newValResult = actualFromJsonResult.newVal();
    assertEquals("Json", newValResult);
    assertNull(actualFromJsonResult.oldVal());
    assertNull(actualFromJsonResult.description());
    assertSame(json.newVal, newValResult);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange
    ImmutableFieldChange.Json<Object> json = new ImmutableFieldChange.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableFieldChange.Json}
   *   <li>{@link ImmutableFieldChange.Json#setDescription(String)}
   *   <li>{@link ImmutableFieldChange.Json#setNewVal(Object)}
   *   <li>{@link ImmutableFieldChange.Json#setOldVal(Object)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableFieldChange.Json<Object> actualJson = new ImmutableFieldChange.Json<>();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setNewVal("New Val");
    actualJson.setOldVal("Old Val");

    // Assert
    assertEquals("New Val", actualJson.newVal);
    assertEquals("Old Val", actualJson.oldVal);
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#newVal()}
   */
  @Test
  void testJsonNewVal() {
    // Arrange
    ImmutableFieldChange.Json<Object> json = new ImmutableFieldChange.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.newVal());
  }

  /**
   * Method under test: {@link ImmutableFieldChange.Json#oldVal()}
   */
  @Test
  void testJsonOldVal() {
    // Arrange
    ImmutableFieldChange.Json<Object> json = new ImmutableFieldChange.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.oldVal());
  }
}
