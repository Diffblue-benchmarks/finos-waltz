package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedItem.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingParsedItemDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedItem#builder()}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentRatingParsedItem Builder.build()", "Builder Builder.comment(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.comment("Comment"));
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   * <p>
   * Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.externalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedItem)}.
   * <ul>
   *   <li>Given {@code Comment}.</li>
   *   <li>Then builder build comment is {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedItem); given 'Comment'; then builder build comment is 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedItem)"})
  void testBuilderFrom_givenComment_thenBuilderBuildCommentIsComment() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();
    AssessmentRatingParsedItem instance = mock(AssessmentRatingParsedItem.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.ratingCode()).thenReturn("Rating Code");
    when(instance.externalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).ratingCode();
    ImmutableAssessmentRatingParsedItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Rating Code", buildResult.ratingCode());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedItem)}.
   * <ul>
   *   <li>When {@link AssessmentRatingParsedItem} {@link AssessmentRatingParsedItem#comment()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedItem); when AssessmentRatingParsedItem comment() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedItem)"})
  void testBuilderFrom_whenAssessmentRatingParsedItemCommentReturnNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();
    AssessmentRatingParsedItem instance = mock(AssessmentRatingParsedItem.class);
    when(instance.comment()).thenReturn(null);
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.ratingCode()).thenReturn("Rating Code");
    when(instance.externalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).externalId();
    verify(instance).isReadOnly();
    verify(instance).ratingCode();
    ImmutableAssessmentRatingParsedItem buildResult = builderResult.build();
    assertEquals("42", buildResult.externalId());
    assertEquals("Rating Code", buildResult.ratingCode());
    assertNull(buildResult.comment());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Test Builder {@link Builder#ratingCode(String)}.
   * <p>
   * Method under test: {@link Builder#ratingCode(String)}
   */
  @Test
  @DisplayName("Test Builder ratingCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingCode(String)"})
  void testBuilderRatingCode() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCode("Rating Code"));
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setRatingCode(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComment(String)", "void Json.setExternalId(String)",
      "void Json.setRatingCode(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setExternalId("42");
    actualJson.setRatingCode("Rating Code");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("Comment", actualJson.comment);
    assertEquals("Rating Code", actualJson.ratingCode);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#isReadOnly()}.
   * <p>
   * Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isReadOnly());
  }

  /**
   * Test Json {@link Json#ratingCode()}.
   * <p>
   * Method under test: {@link Json#ratingCode()}
   */
  @Test
  @DisplayName("Test Json ratingCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ratingCode()"})
  void testJsonRatingCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingCode());
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }
}
