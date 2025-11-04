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
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableSaveAssessmentRatingCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#builder()}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#comment(String)}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSaveAssessmentRatingCommand.Builder actualCommentResult = ImmutableSaveAssessmentRatingCommand.builder()
        .comment("Comment");
    ImmutableSaveAssessmentRatingCommand.Builder actualLastUpdatedAtResult = actualCommentResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#assessmentDefinitionId(long)}
   */
  @Test
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(IsReadOnlyProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    IsReadOnlyProvider instance = mock(IsReadOnlyProvider.class);
    when(instance.isReadOnly()).thenReturn(true);

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isReadOnly();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(AssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    AssessmentRatingCommand instance = mock(AssessmentRatingCommand.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(AssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    AssessmentRatingCommand instance = mock(AssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableSaveAssessmentRatingCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("waltz", buildResult.provenance());
    assertNull(buildResult.comment());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertFalse(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(AssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    AssessmentRatingCommand instance = mock(AssessmentRatingCommand.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(SaveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(SaveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableSaveAssessmentRatingCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(SaveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.comment()).thenReturn(null);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableSaveAssessmentRatingCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.comment());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#from(SaveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.ratingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).entityReference();
    verify(instance).ratingId();
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Builder#ratingId(long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand#copyOf(SaveAssessmentRatingCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveAssessmentRatingCommand actualCopyOfResult = ImmutableSaveAssessmentRatingCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand#copyOf(SaveAssessmentRatingCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.comment()).thenReturn(null);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(true);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveAssessmentRatingCommand actualCopyOfResult = ImmutableSaveAssessmentRatingCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.comment());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand#copyOf(SaveAssessmentRatingCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SaveAssessmentRatingCommand instance = mock(SaveAssessmentRatingCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.isReadOnly()).thenReturn(false);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableSaveAssessmentRatingCommand actualCopyOfResult = ImmutableSaveAssessmentRatingCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).isReadOnly();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).provenance();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#assessmentDefinitionId()}
   */
  @Test
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).assessmentDefinitionId());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).comment());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableSaveAssessmentRatingCommand.Json}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand.Json#setComment(String)}
   *   <li>
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setEntityReference(EntityReference)}
   *   <li>
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setLastUpdatedBy(String)}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSaveAssessmentRatingCommand.Json actualJson = new ImmutableSaveAssessmentRatingCommand.Json();
    actualJson.setComment("Comment");
    actualJson.setEntityReference(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).isReadOnly());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSaveAssessmentRatingCommand.Json()).ratingId());
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setAssessmentDefinitionId(long)}
   */
  @Test
  void testJsonSetAssessmentDefinitionId() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Json json = new ImmutableSaveAssessmentRatingCommand.Json();

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setAssessmentDefinitionId(long)}
   */
  @Test
  void testJsonSetAssessmentDefinitionId2() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Json json = new ImmutableSaveAssessmentRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Json json = new ImmutableSaveAssessmentRatingCommand.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Json json = new ImmutableSaveAssessmentRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Json json = new ImmutableSaveAssessmentRatingCommand.Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableSaveAssessmentRatingCommand.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId2() {
    // Arrange
    ImmutableSaveAssessmentRatingCommand.Json json = new ImmutableSaveAssessmentRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }
}
