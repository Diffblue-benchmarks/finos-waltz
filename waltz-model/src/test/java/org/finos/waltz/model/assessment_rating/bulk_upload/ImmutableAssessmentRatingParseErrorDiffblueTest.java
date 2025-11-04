package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingParseErrorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParseError#builder()}
   *   <li>{@link ImmutableAssessmentRatingParseError#column(Integer)}
   *   <li>{@link ImmutableAssessmentRatingParseError#line(Integer)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssessmentRatingParseError.Builder actualColumnResult = ImmutableAssessmentRatingParseError.builder()
        .column(1);

    // Assert
    assertSame(actualColumnResult, actualColumnResult.line(2));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParseError.Builder#from(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingParseError.Builder builderResult = ImmutableAssessmentRatingParseError.builder();
    AssessmentRatingParsedResult.AssessmentRatingParseError instance = mock(
        AssessmentRatingParsedResult.AssessmentRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableAssessmentRatingParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableAssessmentRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertEquals(1, buildResult.column().intValue());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParseError.Builder#from(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingParseError.Builder builderResult = ImmutableAssessmentRatingParseError.builder();
    AssessmentRatingParsedResult.AssessmentRatingParseError instance = mock(
        AssessmentRatingParsedResult.AssessmentRatingParseError.class);
    when(instance.line()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).line();
    verify(instance).message();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParseError.Builder#from(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingParseError.Builder builderResult = ImmutableAssessmentRatingParseError.builder();
    AssessmentRatingParsedResult.AssessmentRatingParseError instance = mock(
        AssessmentRatingParsedResult.AssessmentRatingParseError.class);
    when(instance.column()).thenReturn(null);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableAssessmentRatingParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableAssessmentRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertEquals(2, buildResult.line().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParseError.Builder#from(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRatingParseError.Builder builderResult = ImmutableAssessmentRatingParseError.builder();
    AssessmentRatingParsedResult.AssessmentRatingParseError instance = mock(
        AssessmentRatingParsedResult.AssessmentRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableAssessmentRatingParseError.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).column();
    verify(instance).line();
    verify(instance).message();
    ImmutableAssessmentRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.line());
    assertEquals(1, buildResult.column().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParseError.Builder#message(String)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableAssessmentRatingParseError.Builder builderResult = ImmutableAssessmentRatingParseError.builder();

    // Act
    ImmutableAssessmentRatingParseError.Builder actualMessageResult = builderResult
        .message("Not all who wander are lost");

    // Assert
    ImmutableAssessmentRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertNull(buildResult.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingParseError#copyOf(AssessmentRatingParsedResult.AssessmentRatingParseError)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingParsedResult.AssessmentRatingParseError instance = mock(
        AssessmentRatingParsedResult.AssessmentRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    ImmutableAssessmentRatingParseError actualCopyOfResult = ImmutableAssessmentRatingParseError.copyOf(instance);

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
   * {@link ImmutableAssessmentRatingParseError#fromJson(ImmutableAssessmentRatingParseError.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingParseError.Json json = new ImmutableAssessmentRatingParseError.Json();
    json.setMessage("Json");
    json.setLine(null);
    json.setColumn(null);

    // Act
    ImmutableAssessmentRatingParseError actualFromJsonResult = ImmutableAssessmentRatingParseError.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.message());
    assertNull(actualFromJsonResult.column());
    assertNull(actualFromJsonResult.line());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingParseError.Json#column()}
   */
  @Test
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParseError.Json()).column());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAssessmentRatingParseError.Json}
   *   <li>{@link ImmutableAssessmentRatingParseError.Json#setColumn(Integer)}
   *   <li>{@link ImmutableAssessmentRatingParseError.Json#setLine(Integer)}
   *   <li>{@link ImmutableAssessmentRatingParseError.Json#setMessage(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssessmentRatingParseError.Json actualJson = new ImmutableAssessmentRatingParseError.Json();
    actualJson.setColumn(1);
    actualJson.setLine(2);
    actualJson.setMessage("Not all who wander are lost");

    // Assert
    assertEquals(1, actualJson.column.intValue());
    assertEquals(2, actualJson.line.intValue());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingParseError.Json#line()}
   */
  @Test
  void testJsonLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParseError.Json()).line());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRatingParseError.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRatingParseError.Json()).message());
  }
}
