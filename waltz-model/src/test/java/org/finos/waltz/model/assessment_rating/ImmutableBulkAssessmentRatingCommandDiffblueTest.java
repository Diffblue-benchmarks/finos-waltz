package org.finos.waltz.model.assessment_rating;

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
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.assessment_rating.ImmutableBulkAssessmentRatingCommand.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableBulkAssessmentRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkAssessmentRatingCommandDiffblueTest {
  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#builder()}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableBulkAssessmentRatingCommand Builder.build()", "Builder Builder.comment(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.comment("Comment"));
  }

  /**
   * Test Builder {@link Builder#entityRef(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityRef(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityRef(EntityReference)"})
  void testBuilderEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityRef(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(BulkAssessmentRatingCommand)} with {@code BulkAssessmentRatingCommand}.
   * <ul>
   *   <li>Then builder build comment is {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkAssessmentRatingCommand) with 'BulkAssessmentRatingCommand'; then builder build comment is 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkAssessmentRatingCommand)"})
  void testBuilderFromWithBulkAssessmentRatingCommand_thenBuilderBuildCommentIsComment() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    BulkAssessmentRatingCommand instance = mock(BulkAssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.comment()).thenReturn("Comment");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).entityRef();
    verify(instance).operation();
    verify(instance).ratingId();
    ImmutableBulkAssessmentRatingCommand buildResult = builderResult.build();
    assertEquals("Comment", buildResult.comment());
    assertEquals(1L, buildResult.ratingId());
    assertEquals(Operation.ADD, buildResult.operation());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkAssessmentRatingCommand)} with {@code BulkAssessmentRatingCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BulkAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkAssessmentRatingCommand) with 'BulkAssessmentRatingCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BulkAssessmentRatingCommand)"})
  void testBuilderFromWithBulkAssessmentRatingCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    BulkAssessmentRatingCommand instance = mock(BulkAssessmentRatingCommand.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.comment()).thenReturn("Comment");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
    verify(instance).entityRef();
    verify(instance).operation();
    verify(instance).ratingId();
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   * <ul>
   *   <li>Given {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenComment() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   * <p>
   * Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#ratingId(long)}.
   * <p>
   * Method under test: {@link Builder#ratingId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingId(long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
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
   * Test Json {@link Json#entityRef()}.
   * <p>
   * Method under test: {@link Json#entityRef()}
   */
  @Test
  @DisplayName("Test Json entityRef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityRef()"})
  void testJsonEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityRef());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setEntityRef(EntityReference)}
   *   <li>{@link Json#setOperation(Operation)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComment(String)", "void Json.setEntityRef(EntityReference)",
      "void Json.setOperation(Operation)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setEntityRef(null);
    actualJson.setOperation(Operation.ADD);

    // Assert
    assertEquals("Comment", actualJson.comment);
    assertNull(actualJson.entityRef);
    assertEquals(0L, actualJson.ratingId);
    assertEquals(Operation.ADD, actualJson.operation);
    assertFalse(actualJson.ratingIdIsSet);
  }

  /**
   * Test Json {@link Json#operation()}.
   * <p>
   * Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operation());
  }

  /**
   * Test Json {@link Json#ratingId()}.
   * <p>
   * Method under test: {@link Json#ratingId()}
   */
  @Test
  @DisplayName("Test Json ratingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.ratingId()"})
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingId());
  }

  /**
   * Test Json {@link Json#setRatingId(long)}.
   * <p>
   * Method under test: {@link Json#setRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatingId(long)"})
  void testJsonSetRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }
}
