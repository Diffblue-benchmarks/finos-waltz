package org.finos.waltz.model.bulk_upload.taxonomy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkTaxonomyParseErrorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkTaxonomyParseError#builder()}
   *   <li>{@link ImmutableBulkTaxonomyParseError#column(Integer)}
   *   <li>{@link ImmutableBulkTaxonomyParseError#line(Integer)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseError.Builder actualColumnResult = ImmutableBulkTaxonomyParseError.builder().column(1);

    // Assert
    assertSame(actualColumnResult, actualColumnResult.line(2));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseError.Builder#from(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkTaxonomyParseError.Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    BulkTaxonomyParseResult.BulkTaxonomyParseError instance = mock(
        BulkTaxonomyParseResult.BulkTaxonomyParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkTaxonomyParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkTaxonomyParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(1, buildResult.column().intValue());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseError.Builder#from(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkTaxonomyParseError.Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    BulkTaxonomyParseResult.BulkTaxonomyParseError instance = mock(
        BulkTaxonomyParseResult.BulkTaxonomyParseError.class);
    when(instance.line()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).line();
    verify(instance).message();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseError.Builder#from(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkTaxonomyParseError.Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    BulkTaxonomyParseResult.BulkTaxonomyParseError instance = mock(
        BulkTaxonomyParseResult.BulkTaxonomyParseError.class);
    when(instance.column()).thenReturn(null);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkTaxonomyParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkTaxonomyParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseError.Builder#from(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkTaxonomyParseError.Builder builderResult = ImmutableBulkTaxonomyParseError.builder();
    BulkTaxonomyParseResult.BulkTaxonomyParseError instance = mock(
        BulkTaxonomyParseResult.BulkTaxonomyParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkTaxonomyParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableBulkTaxonomyParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.line());
    assertEquals(1, buildResult.column().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseError.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableBulkTaxonomyParseError.Builder builderResult = ImmutableBulkTaxonomyParseError.builder();

    // Act
    ImmutableBulkTaxonomyParseError.Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    ImmutableBulkTaxonomyParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertNull(buildResult.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkTaxonomyParseError#copyOf(BulkTaxonomyParseResult.BulkTaxonomyParseError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkTaxonomyParseResult.BulkTaxonomyParseError instance = mock(
        BulkTaxonomyParseResult.BulkTaxonomyParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableBulkTaxonomyParseError actualCopyOfResult = ImmutableBulkTaxonomyParseError.copyOf(instance);

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
   * {@link ImmutableBulkTaxonomyParseError#fromJson(ImmutableBulkTaxonomyParseError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBulkTaxonomyParseError.Json json = new ImmutableBulkTaxonomyParseError.Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(null);

    // Act
    ImmutableBulkTaxonomyParseError actualFromJsonResult = ImmutableBulkTaxonomyParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertNull(actualFromJsonResult.line());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyParseError.Json#column()}
   */
  @Test
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseError.Json()).column());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkTaxonomyParseError.Json}
   *   <li>{@link ImmutableBulkTaxonomyParseError.Json#setColumn(Integer)}
   *   <li>{@link ImmutableBulkTaxonomyParseError.Json#setLine(Integer)}
   *   <li>{@link ImmutableBulkTaxonomyParseError.Json#setMessage(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkTaxonomyParseError.Json actualJson = new ImmutableBulkTaxonomyParseError.Json();
    actualJson.setColumn(1);
    actualJson.setLine(2);
    actualJson.setMessage("Not all who wander are lost");

    // Assert
    assertEquals(1, actualJson.column.intValue());
    assertEquals(2, actualJson.line.intValue());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyParseError.Json#line()}
   */
  @Test
  void testJsonLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseError.Json()).line());
  }

  /**
   * Method under test: {@link ImmutableBulkTaxonomyParseError.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkTaxonomyParseError.Json()).message());
  }
}
