package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.bulk_upload.measurable_rating.BulkMeasurableRatingParseResult.BulkMeasurableRatingParseError;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError.Builder;
import org.finos.waltz.model.bulk_upload.measurable_rating.ImmutableBulkMeasurableRatingParseError.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingParseErrorDiffblueTest {
  /**
   * Test {@link ImmutableBulkMeasurableRatingParseError#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingParseError#builder()}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError#column(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingParseError#line(Integer)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkMeasurableRatingParseError Builder.build()", "Builder Builder.column(Integer)",
      "Builder Builder.line(Integer)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualColumnResult = ImmutableBulkMeasurableRatingParseError.builder().column(1);

    // Assert
    assertSame(actualColumnResult, actualColumnResult.line(2));
  }

  /**
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseError)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build column intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseError); given one; then builder build column intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseError)"})
  void testBuilderFrom_givenOne_thenBuilderBuildColumnIntValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseError instance = mock(BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseError)}.
   * <ul>
   *   <li>Then builder build column is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseError); then builder build column is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseError)"})
  void testBuilderFrom_thenBuilderBuildColumnIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseError instance = mock(BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(null);
    when(instance.line()).thenReturn(2);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseError)}.
   * <ul>
   *   <li>Then builder build line is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseError); then builder build line is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseError)"})
  void testBuilderFrom_thenBuilderBuildLineIsNull() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseError instance = mock(BulkMeasurableRatingParseError.class);
    when(instance.column()).thenReturn(1);
    when(instance.line()).thenReturn(null);
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(BulkMeasurableRatingParseError)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkMeasurableRatingParseError)}
   */
  @Test
  @DisplayName("Test Builder from(BulkMeasurableRatingParseError); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkMeasurableRatingParseError)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();
    BulkMeasurableRatingParseError instance = mock(BulkMeasurableRatingParseError.class);
    when(instance.line()).thenThrow(new IllegalStateException("instance"));
    when(instance.message()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).line();
    verify(instance).message();
  }

  /**
   * Test Builder {@link Builder#message(String)}.
   * <p>
   * Method under test: {@link Builder#message(String)}
   */
  @Test
  @DisplayName("Test Builder message(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(String)"})
  void testBuilderMessage() {
    // Arrange
    Builder builderResult = ImmutableBulkMeasurableRatingParseError.builder();

    // Act
    Builder actualMessageResult = builderResult.message("Not all who wander are lost");

    // Assert
    ImmutableBulkMeasurableRatingParseError buildResult = builderResult.build();
    assertEquals("Not all who wander are lost", buildResult.message());
    assertNull(buildResult.column());
    assertNull(buildResult.line());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Json {@link Json#column()}.
   * <p>
   * Method under test: {@link Json#column()}
   */
  @Test
  @DisplayName("Test Json column()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.column()"})
  void testJsonColumn() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).column());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setColumn(Integer)}
   *   <li>{@link Json#setLine(Integer)}
   *   <li>{@link Json#setMessage(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setColumn(Integer)", "void Json.setLine(Integer)",
      "void Json.setMessage(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setColumn(1);
    actualJson.setLine(2);
    actualJson.setMessage("Not all who wander are lost");

    // Assert
    assertEquals(1, actualJson.column.intValue());
    assertEquals(2, actualJson.line.intValue());
  }

  /**
   * Test Json {@link Json#line()}.
   * <p>
   * Method under test: {@link Json#line()}
   */
  @Test
  @DisplayName("Test Json line()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.line()"})
  void testJsonLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).line());
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
  }
}
