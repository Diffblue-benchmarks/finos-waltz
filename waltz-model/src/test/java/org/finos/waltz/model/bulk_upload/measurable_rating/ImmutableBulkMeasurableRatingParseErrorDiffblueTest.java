package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingParseErrorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseError#builder()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError#column(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError#line(Integer)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingParseError.Builder actualColumnResult = ImmutableBulkMeasurableRatingParseError
        .builder()
        .column(1);

    // Assert
    assertSame(actualColumnResult, actualColumnResult.line(2));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Builder#from(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkMeasurableRatingParseError.Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError instance = mock(
        BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkMeasurableRatingParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkMeasurableRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(1, buildResult.column().intValue());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Builder#from(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkMeasurableRatingParseError.Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError instance = mock(
        BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError.class);
    when(instance.line()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).line();
    verify(instance).message();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Builder#from(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkMeasurableRatingParseError.Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError instance = mock(
        BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(null);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkMeasurableRatingParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkMeasurableRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Builder#from(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkMeasurableRatingParseError.Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError instance = mock(
        BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkMeasurableRatingParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkMeasurableRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.line());
    assertEquals(1, buildResult.column().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableBulkMeasurableRatingParseError.Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();

    // Act
    ImmutableBulkMeasurableRatingParseError.Builder actualMessageResult = builderResult
        .message("Not all who wander are lost");

    // Assert
    ImmutableBulkMeasurableRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertNull(buildResult.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError#copyOf(BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError instance = mock(
        BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkMeasurableRatingParseError actualCopyOfResult = ImmutableBulkMeasurableRatingParseError
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
   * {@link ImmutableBulkMeasurableRatingParseError#fromJson(ImmutableBulkMeasurableRatingParseError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkMeasurableRatingParseError.Json json = new ImmutableBulkMeasurableRatingParseError.Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(null);

    // Act
    ImmutableBulkMeasurableRatingParseError actualFromJsonResult = ImmutableBulkMeasurableRatingParseError
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertNull(actualFromJsonResult.line());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Json#column()}
   */
  @Test
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseError.Json()).column());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkMeasurableRatingParseError.Json}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError.Json#setColumn(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError.Json#setLine(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError.Json#setMessage(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingParseError.Json actualJson = new ImmutableBulkMeasurableRatingParseError.Json();
    actualJson.setColumn(1);
    actualJson.setLine(2);
    actualJson.setMessage("Not all who wander are lost");

    // Assert
    assertEquals(1, actualJson.column.intValue());
    assertEquals(2, actualJson.line.intValue());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Json#line()}
   */
  @Test
  void testJsonLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseError.Json()).line());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingParseError.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingParseError.Json()).message());
  }
}
