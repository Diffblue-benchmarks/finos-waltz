package org.finos.waltz.model.bulk_upload.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadRelationshipParseErrorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#builder()}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#column(Integer)}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError#line(Integer)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParseError.Builder actualColumnResult = ImmutableBulkUploadRelationshipParseError
        .builder()
        .column(1);

    // Assert
    assertSame(actualColumnResult, actualColumnResult.line(2));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Builder#from(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError.Builder builderResult = ImmutableBulkUploadRelationshipParseError
        .builder();
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError instance = mock(
        BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkUploadRelationshipParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkUploadRelationshipParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(1, buildResult.column().intValue());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Builder#from(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError.Builder builderResult = ImmutableBulkUploadRelationshipParseError
        .builder();
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError instance = mock(
        BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError.class);
    when(instance.line()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).line();
    verify(instance).message();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Builder#from(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError.Builder builderResult = ImmutableBulkUploadRelationshipParseError
        .builder();
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError instance = mock(
        BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError.class);
    when(instance.column()).thenReturn(null);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkUploadRelationshipParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkUploadRelationshipParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Builder#from(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError.Builder builderResult = ImmutableBulkUploadRelationshipParseError
        .builder();
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError instance = mock(
        BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkUploadRelationshipParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkUploadRelationshipParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.line());
    assertEquals(1, buildResult.column().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError.Builder builderResult = ImmutableBulkUploadRelationshipParseError
        .builder();

    // Act
    ImmutableBulkUploadRelationshipParseError.Builder actualMessageResult = builderResult
        .message("Not all who wander are lost");

    // Assert
    ImmutableBulkUploadRelationshipParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertNull(buildResult.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError#copyOf(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError instance = mock(
        BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkUploadRelationshipParseError actualCopyOfResult = ImmutableBulkUploadRelationshipParseError
        .copyOf(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(1, actualCopyOfResult.column().intValue());
    assertEquals(2, actualCopyOfResult.line().intValue());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError#fromJson(ImmutableBulkUploadRelationshipParseError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkUploadRelationshipParseError.Json json = new ImmutableBulkUploadRelationshipParseError.Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(null);

    // Act
    ImmutableBulkUploadRelationshipParseError actualFromJsonResult = ImmutableBulkUploadRelationshipParseError
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertNull(actualFromJsonResult.line());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Json#column()}
   */
  @Test
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipParseError.Json()).column());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkUploadRelationshipParseError.Json}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError.Json#setColumn(Integer)}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError.Json#setLine(Integer)}
   *   <li>{@link ImmutableBulkUploadRelationshipParseError.Json#setMessage(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkUploadRelationshipParseError.Json actualJson = new ImmutableBulkUploadRelationshipParseError.Json();
    actualJson.setColumn(1);
    actualJson.setLine(2);
    actualJson.setMessage("Not all who wander are lost");

    // Assert
    assertEquals(1, actualJson.column.intValue());
    assertEquals(2, actualJson.line.intValue());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Json#line()}
   */
  @Test
  void testJsonLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipParseError.Json()).line());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkUploadRelationshipParseError.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkUploadRelationshipParseError.Json()).message());
  }
}
