package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentContextValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentContextValue#builder()}
   *   <li>{@link ImmutableAssessmentContextValue#ratingComment(String)}
   *   <li>{@link ImmutableAssessmentContextValue#ratingExternalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssessmentContextValue.Builder actualRatingCommentResult = ImmutableAssessmentContextValue.builder()
        .ratingComment("Rating Comment");

    // Assert
    assertSame(actualRatingCommentResult, actualRatingCommentResult.ratingExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentContextValue.Builder#from(AssessmentContextValue)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentContextValue.Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn("Rating Comment");
    when(instance.getRatingExternalId()).thenReturn("42");
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    ImmutableAssessmentContextValue.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableAssessmentContextValue.Builder#from(AssessmentContextValue)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentContextValue.Builder builderResult = ImmutableAssessmentContextValue.builder();
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
   * Method under test:
   * {@link ImmutableAssessmentContextValue.Builder#from(AssessmentContextValue)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentContextValue.Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn(null);
    when(instance.getRatingExternalId()).thenReturn("42");
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    ImmutableAssessmentContextValue.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableAssessmentContextValue.Builder#from(AssessmentContextValue)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentContextValue.Builder builderResult = ImmutableAssessmentContextValue.builder();
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn("Rating Comment");
    when(instance.getRatingExternalId()).thenReturn(null);
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    ImmutableAssessmentContextValue.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableAssessmentContextValue.Builder#ratingCode(String)}
   */
  @Test
  void testBuilderRatingCode() {
    // Arrange
    ImmutableAssessmentContextValue.Builder builderResult = ImmutableAssessmentContextValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCode("Rating Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentContextValue.Builder#ratingName(String)}
   */
  @Test
  void testBuilderRatingName() {
    // Arrange
    ImmutableAssessmentContextValue.Builder builderResult = ImmutableAssessmentContextValue.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingName("Rating Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentContextValue#copyOf(AssessmentContextValue)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentContextValue instance = mock(AssessmentContextValue.class);
    when(instance.getRatingComment()).thenReturn("Rating Comment");
    when(instance.getRatingExternalId()).thenReturn("42");
    when(instance.getRatingName()).thenReturn("Rating Name");
    when(instance.getRatingCode()).thenReturn("Rating Code");

    // Act
    ImmutableAssessmentContextValue actualCopyOfResult = ImmutableAssessmentContextValue.copyOf(instance);

    // Assert
    verify(instance).getRatingCode();
    verify(instance).getRatingComment();
    verify(instance).getRatingExternalId();
    verify(instance).getRatingName();
    assertEquals("42", actualCopyOfResult.getRatingExternalId());
    assertEquals("Rating Code", actualCopyOfResult.getRatingCode());
    assertEquals("Rating Comment", actualCopyOfResult.getRatingComment());
    assertEquals("Rating Name", actualCopyOfResult.getRatingName());
  }
}
