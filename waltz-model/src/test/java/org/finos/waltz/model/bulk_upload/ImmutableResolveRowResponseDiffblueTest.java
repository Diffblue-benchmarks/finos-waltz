package org.finos.waltz.model.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableResolveRowResponseDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableResolveRowResponse#builder()}
   *   <li>{@link ImmutableResolveRowResponse#errorMessage(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableResolveRowResponse.Builder actualErrorMessageResult = ImmutableResolveRowResponse.builder()
        .errorMessage("An error occurred");
    Optional<String> errorMessage = Optional.of("foo");

    // Assert
    assertSame(actualErrorMessageResult, actualErrorMessageResult.errorMessage(errorMessage));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#addAllInputRow(Iterable)}
   */
  @Test
  void testBuilderAddAllInputRow() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInputRow(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#addAllInputRow(Iterable)}
   */
  @Test
  void testBuilderAddAllInputRow2() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllInputRow(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#addInputRow(String)}
   */
  @Test
  void testBuilderAddInputRow() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInputRow("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#addInputRow(String[])}
   */
  @Test
  void testBuilderAddInputRow2() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addInputRow("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#errorMessage(Optional)}
   */
  @Test
  void testBuilderErrorMessage() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();
    Optional<String> errorMessage = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.errorMessage(errorMessage));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#from(ResolveRowResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#from(ResolveRowResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    when(instance.errorMessage()).thenThrow(new IllegalStateException("instance"));
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#from(ResolveRowResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.errorMessage()).thenReturn(emptyResult);
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#from(ResolveRowResponse)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(stringList);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    ImmutableResolveRowResponse buildResult = builderResult.build();
    List<String> inputRowResult = buildResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("instance", inputRowResult.get(0));
    assertEquals(ResolutionStatus.NEW, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#inputRow(Iterable)}
   */
  @Test
  void testBuilderInputRow() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.inputRow(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#inputRow(Iterable)}
   */
  @Test
  void testBuilderInputRow2() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.inputRow(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse.Builder#status(ResolutionStatus)}
   */
  @Test
  void testBuilderStatus() {
    // Arrange
    ImmutableResolveRowResponse.Builder builderResult = ImmutableResolveRowResponse.builder();

    // Act
    ImmutableResolveRowResponse.Builder actualStatusResult = builderResult.status(ResolutionStatus.NEW);

    // Assert
    assertEquals(ResolutionStatus.NEW, builderResult.build().status());
    assertSame(builderResult, actualStatusResult);
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#copyOf(ResolveRowResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse actualCopyOfResult = ImmutableResolveRowResponse.copyOf(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.inputRow().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#copyOf(ResolveRowResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.errorMessage()).thenReturn(emptyResult);
    when(instance.inputRow()).thenReturn(new ArrayList<>());
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse actualCopyOfResult = ImmutableResolveRowResponse.copyOf(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertTrue(actualCopyOfResult.inputRow().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#copyOf(ResolveRowResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(stringList);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse actualCopyOfResult = ImmutableResolveRowResponse.copyOf(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    List<String> inputRowResult = actualCopyOfResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("instance", inputRowResult.get(0));
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#copyOf(ResolveRowResponse)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("inputRow element");
    stringList.add("instance");
    ResolveRowResponse instance = mock(ResolveRowResponse.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.errorMessage()).thenReturn(ofResult);
    when(instance.inputRow()).thenReturn(stringList);
    when(instance.status()).thenReturn(ResolutionStatus.NEW);

    // Act
    ImmutableResolveRowResponse actualCopyOfResult = ImmutableResolveRowResponse.copyOf(instance);

    // Assert
    verify(instance).errorMessage();
    verify(instance).inputRow();
    verify(instance).status();
    assertEquals(ResolutionStatus.NEW, actualCopyOfResult.status());
    assertEquals(stringList, actualCopyOfResult.inputRow());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#fromJson(ImmutableResolveRowResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableResolveRowResponse.Json json = new ImmutableResolveRowResponse.Json();
    json.setInputRow(null);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertTrue(actualFromJsonResult.inputRow().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#fromJson(ImmutableResolveRowResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<String> inputRow = new ArrayList<>();
    inputRow.add("Json");

    ImmutableResolveRowResponse.Json json = new ImmutableResolveRowResponse.Json();
    json.setInputRow(inputRow);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    List<String> inputRowResult = actualFromJsonResult.inputRow();
    assertEquals(1, inputRowResult.size());
    assertEquals("Json", inputRowResult.get(0));
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
  }

  /**
   * Method under test:
   * {@link ImmutableResolveRowResponse#fromJson(ImmutableResolveRowResponse.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<String> inputRow = new ArrayList<>();
    inputRow.add("inputRow element");
    inputRow.add("Json");

    ImmutableResolveRowResponse.Json json = new ImmutableResolveRowResponse.Json();
    json.setInputRow(inputRow);
    json.setStatus(ResolutionStatus.NEW);
    json.setErrorMessage(null);

    // Act
    ImmutableResolveRowResponse actualFromJsonResult = ImmutableResolveRowResponse.fromJson(json);

    // Assert
    assertEquals(ResolutionStatus.NEW, actualFromJsonResult.status());
    assertEquals(inputRow, actualFromJsonResult.inputRow());
  }

  /**
   * Method under test: {@link ImmutableResolveRowResponse.Json#errorMessage()}
   */
  @Test
  void testJsonErrorMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableResolveRowResponse.Json()).errorMessage());
  }

  /**
   * Method under test: {@link ImmutableResolveRowResponse.Json#inputRow()}
   */
  @Test
  void testJsonInputRow() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableResolveRowResponse.Json()).inputRow());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableResolveRowResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableResolveRowResponse.Json actualJson = new ImmutableResolveRowResponse.Json();

    // Assert
    assertNull(actualJson.status);
    assertFalse(actualJson.errorMessage.isPresent());
    assertTrue(actualJson.inputRow.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableResolveRowResponse.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableResolveRowResponse.Json()).status());
  }
}
