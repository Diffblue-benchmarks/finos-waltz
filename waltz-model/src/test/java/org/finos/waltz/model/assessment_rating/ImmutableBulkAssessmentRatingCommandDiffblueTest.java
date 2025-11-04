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
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.Operation;
import org.junit.jupiter.api.Test;

class ImmutableBulkAssessmentRatingCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#builder()}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#comment(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingCommand.Builder actualBuilderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.comment("Comment"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#entityRef(EntityReference)}
   */
  @Test
  void testBuilderEntityRef() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityRef(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableBulkAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    ImmutableBulkAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#from(BulkAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
    BulkAssessmentRatingCommand instance = mock(BulkAssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.comment()).thenReturn("Comment");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBulkAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#from(BulkAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();
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
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#operation(Operation)}
   */
  @Test
  void testBuilderOperation() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operation(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Builder#ratingId(long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand#copyOf(BulkAssessmentRatingCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkAssessmentRatingCommand instance = mock(BulkAssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.operation()).thenReturn(Operation.ADD);
    when(instance.comment()).thenReturn("Comment");
    when(instance.entityRef()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableBulkAssessmentRatingCommand actualCopyOfResult = ImmutableBulkAssessmentRatingCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).entityRef();
    verify(instance).operation();
    verify(instance).ratingId();
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingCommand.Json()).comment());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Json#entityRef()}
   */
  @Test
  void testJsonEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingCommand.Json()).entityRef());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkAssessmentRatingCommand.Json}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand.Json#setComment(String)}
   *   <li>
   * {@link ImmutableBulkAssessmentRatingCommand.Json#setEntityRef(EntityReference)}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand.Json#setOperation(Operation)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkAssessmentRatingCommand.Json actualJson = new ImmutableBulkAssessmentRatingCommand.Json();
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
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Json#operation()}
   */
  @Test
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingCommand.Json()).operation());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkAssessmentRatingCommand.Json()).ratingId());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Json json = new ImmutableBulkAssessmentRatingCommand.Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkAssessmentRatingCommand.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId2() {
    // Arrange
    ImmutableBulkAssessmentRatingCommand.Json json = new ImmutableBulkAssessmentRatingCommand.Json();
    json.setEntityRef(mock(EntityReference.class));

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }
}
