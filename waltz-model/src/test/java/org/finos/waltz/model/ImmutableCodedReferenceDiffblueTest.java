package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableCodedReferenceDiffblueTest {
  /**
   * Method under test: {@link ImmutableCodedReference.Builder#code(String)}
   */
  @Test
  void testBuilderCode() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Method under test: {@link ImmutableCodedReference.Builder#from(CodeProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenReturn("Code");

    // Act
    ImmutableCodedReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCodedReference.Builder#from(CodeProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();
    CodeProvider instance = mock(CodeProvider.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
  }

  /**
   * Method under test:
   * {@link ImmutableCodedReference.Builder#from(CodedReference)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();
    CodedReference instance = mock(CodedReference.class);
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCodedReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).name();
    ImmutableCodedReference buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCodedReference.Builder#from(CodedReference)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();
    CodedReference instance = mock(CodedReference.class);
    when(instance.code()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableCodedReference.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCodedReference.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCodedReference.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableCodedReference.Builder builderResult = ImmutableCodedReference.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableCodedReference#copyOf(CodedReference)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CodedReference instance = mock(CodedReference.class);
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableCodedReference actualCopyOfResult = ImmutableCodedReference.copyOf(instance);

    // Assert
    verify(instance).code();
    verify(instance).name();
    assertEquals("Code", actualCopyOfResult.code());
    assertEquals("Name", actualCopyOfResult.name());
  }

  /**
   * Method under test:
   * {@link ImmutableCodedReference#fromJson(ImmutableCodedReference.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCodedReference.Json json = new ImmutableCodedReference.Json();
    json.setCode("Json");
    json.setName("Json");

    // Act
    ImmutableCodedReference actualFromJsonResult = ImmutableCodedReference.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.code());
    assertEquals("Json", actualFromJsonResult.name());
  }

  /**
   * Method under test: {@link ImmutableCodedReference.Json#code()}
   */
  @Test
  void testJsonCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCodedReference.Json()).code());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableCodedReference.Json}
   *   <li>{@link ImmutableCodedReference.Json#setCode(String)}
   *   <li>{@link ImmutableCodedReference.Json#setName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCodedReference.Json actualJson = new ImmutableCodedReference.Json();
    actualJson.setCode("Code");
    actualJson.setName("Name");

    // Assert
    assertEquals("Code", actualJson.code);
    assertEquals("Name", actualJson.name);
  }

  /**
   * Method under test: {@link ImmutableCodedReference.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCodedReference.Json()).name());
  }
}
