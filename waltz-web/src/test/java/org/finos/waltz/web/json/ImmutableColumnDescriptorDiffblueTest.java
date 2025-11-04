package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableColumnDescriptorDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableColumnDescriptor.Builder#from(ColumnDescriptor)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableColumnDescriptor.Builder builderResult = ImmutableColumnDescriptor.builder();
    ColumnDescriptor instance = mock(ColumnDescriptor.class);
    when(instance.name()).thenReturn("Name");
    when(instance.id()).thenReturn("42");

    // Act
    ImmutableColumnDescriptor.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    ImmutableColumnDescriptor buildResult = builderResult.build();
    assertEquals("42", buildResult.id());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableColumnDescriptor.Builder#from(ColumnDescriptor)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableColumnDescriptor.Builder builderResult = ImmutableColumnDescriptor.builder();
    ColumnDescriptor instance = mock(ColumnDescriptor.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));
    when(instance.id()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableColumnDescriptor.Builder#id(String)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableColumnDescriptor.Builder builderResult = ImmutableColumnDescriptor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("42"));
  }

  /**
   * Method under test: {@link ImmutableColumnDescriptor.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableColumnDescriptor.Builder builderResult = ImmutableColumnDescriptor.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableColumnDescriptor#copyOf(ColumnDescriptor)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ColumnDescriptor instance = mock(ColumnDescriptor.class);
    when(instance.name()).thenReturn("Name");
    when(instance.id()).thenReturn("42");

    // Act
    ImmutableColumnDescriptor actualCopyOfResult = ImmutableColumnDescriptor.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    assertEquals("42", actualCopyOfResult.id());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Method under test:
   * {@link ImmutableColumnDescriptor#fromJson(ImmutableColumnDescriptor.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableColumnDescriptor.Json json = new ImmutableColumnDescriptor.Json();
    json.setId("Json");
    json.setName("Json");

    // Act
    ImmutableColumnDescriptor actualFromJsonResult = ImmutableColumnDescriptor.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.id());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableColumnDescriptor.Json}
   *   <li>{@link ImmutableColumnDescriptor.Json#setId(String)}
   *   <li>{@link ImmutableColumnDescriptor.Json#setName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableColumnDescriptor.Json actualJson = new ImmutableColumnDescriptor.Json();
    actualJson.setId("42");
    actualJson.setName("Name");

    // Assert
    assertEquals("42", actualJson.id);
    assertEquals("Name", actualJson.name);
  }

  /**
   * Method under test: {@link ImmutableColumnDescriptor.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableColumnDescriptor.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableColumnDescriptor.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableColumnDescriptor.Json()).name());
  }
}
