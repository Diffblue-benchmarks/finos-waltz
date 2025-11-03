package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableAssessmentRatingEntry.Builder;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#entity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entity(EntityReference)"})
  void testBuilderEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entity(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingEntry)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.entity()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entity();
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingEntry)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingEntry)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.entity()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).entity();
    verify(instance).ratingId();
    ImmutableAssessmentRatingEntry buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingEntry)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingEntry)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();
    AssessmentRatingEntry instance = mock(AssessmentRatingEntry.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entity()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entity();
    verify(instance).ratingId();
  }

  /**
   * Test Builder {@link Builder#ratingId(Long)}.
   * <p>
   * Method under test: {@link Builder#ratingId(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingId(Long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }
}
