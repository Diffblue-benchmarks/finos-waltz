package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.ImmutableAssessmentContextValue.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentContextValueDiffblueTest {
  /**
   * Test {@link ImmutableAssessmentContextValue#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentContextValue#builder()}
   *   <li>{@link ImmutableAssessmentContextValue#ratingComment(String)}
   *   <li>{@link ImmutableAssessmentContextValue#ratingExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentContextValue Builder.build()", "Builder Builder.ratingComment(String)",
      "Builder Builder.ratingExternalId(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualRatingCommentResult = ImmutableAssessmentContextValue.builder().ratingComment("Rating Comment");

    // Assert
    assertSame(actualRatingCommentResult, actualRatingCommentResult.ratingExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   * <ul>
   *   <li>Given {@code Rating Comment}.</li>
   *   <li>Then builder build RatingExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue); given 'Rating Comment'; then builder build RatingExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom_givenRatingComment_thenBuilderBuildRatingExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn("Rating Comment");
    when(instance.getRatingExternalId()).thenReturn("42");
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getRatingCode();
    verify(instance).getRatingComment();
    verify(instance).getRatingExternalId();
    verify(instance).getRatingName();
    ImmutableAssessmentContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getRatingExternalId());
    assertEquals("Rating Code", buildResult.getRatingCode());
    assertEquals("Rating Comment", buildResult.getRatingComment());
    assertEquals("Rating Name", buildResult.getRatingName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   * <ul>
   *   <li>Then builder build RatingComment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue); then builder build RatingComment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom_thenBuilderBuildRatingCommentIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn(null);
    when(instance.getRatingExternalId()).thenReturn("42");
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getRatingCode();
    verify(instance).getRatingComment();
    verify(instance).getRatingExternalId();
    verify(instance).getRatingName();
    ImmutableAssessmentContextValue buildResult = builderResult.build();
    assertEquals("42", buildResult.getRatingExternalId());
    assertEquals("Rating Code", buildResult.getRatingCode());
    assertEquals("Rating Name", buildResult.getRatingName());
    assertNull(buildResult.getRatingComment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   * <ul>
   *   <li>Then builder build RatingExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue); then builder build RatingExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom_thenBuilderBuildRatingExternalIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn("Rating Comment");
    when(instance.getRatingExternalId()).thenReturn(null);
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).getRatingCode();
    verify(instance).getRatingComment();
    verify(instance).getRatingExternalId();
    verify(instance).getRatingName();
    ImmutableAssessmentContextValue buildResult = builderResult.build();
    assertEquals("Rating Code", buildResult.getRatingCode());
    assertEquals("Rating Comment", buildResult.getRatingComment());
    assertEquals("Rating Name", buildResult.getRatingName());
    assertNull(buildResult.getRatingExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingExternalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).getRatingCode();
    verify(instance).getRatingExternalId();
    verify(instance).getRatingName();
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
    Builder builderResult = ImmutableAssessmentContextValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCode("Rating Code"));
  }

  /**
   * Test Builder {@link Builder#ratingName(String)}.
   * <p>
   * Method under test: {@link Builder#ratingName(String)}
   */
  @Test
  @DisplayName("Test Builder ratingName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingName(String)"})
  void testBuilderRatingName() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingName("Rating Name"));
  }
}
