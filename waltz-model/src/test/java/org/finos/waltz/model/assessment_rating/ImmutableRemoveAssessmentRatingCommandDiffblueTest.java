package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableRemoveAssessmentRatingCommandDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#builder()}
   *   <li>
   * {@link ImmutableRemoveAssessmentRatingCommand#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableRemoveAssessmentRatingCommand.Builder actualBuilderResult = ImmutableRemoveAssessmentRatingCommand
        .builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#assessmentDefinitionId(long)}
   */
  @Test
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableRemoveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
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
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(AssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
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
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(AssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
    AssessmentRatingCommand instance = mock(AssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableRemoveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableRemoveAssessmentRatingCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(AssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
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
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
    RemoveAssessmentRatingCommand instance = mock(RemoveAssessmentRatingCommand.class);
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
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
    RemoveAssessmentRatingCommand instance = mock(RemoveAssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableRemoveAssessmentRatingCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    ImmutableRemoveAssessmentRatingCommand buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals(1L, buildResult.assessmentDefinitionId());
    assertEquals(1L, buildResult.ratingId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#from(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();
    RemoveAssessmentRatingCommand instance = mock(RemoveAssessmentRatingCommand.class);
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
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Builder#ratingId(long)}
   */
  @Test
  void testBuilderRatingId() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand#copyOf(RemoveAssessmentRatingCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RemoveAssessmentRatingCommand instance = mock(RemoveAssessmentRatingCommand.class);
    when(instance.ratingId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableRemoveAssessmentRatingCommand actualCopyOfResult = ImmutableRemoveAssessmentRatingCommand.copyOf(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).assessmentDefinitionId();
    verify(instance).entityReference();
    verify(instance).ratingId();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#assessmentDefinitionId()}
   */
  @Test
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveAssessmentRatingCommand.Json()).assessmentDefinitionId());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveAssessmentRatingCommand.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableRemoveAssessmentRatingCommand.Json}
   *   <li>
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setEntityReference(EntityReference)}
   *   <li>
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setLastUpdatedBy(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableRemoveAssessmentRatingCommand.Json actualJson = new ImmutableRemoveAssessmentRatingCommand.Json();
    actualJson.setEntityReference(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveAssessmentRatingCommand.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveAssessmentRatingCommand.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#ratingId()}
   */
  @Test
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableRemoveAssessmentRatingCommand.Json()).ratingId());
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setAssessmentDefinitionId(long)}
   */
  @Test
  void testJsonSetAssessmentDefinitionId() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Json json = new ImmutableRemoveAssessmentRatingCommand.Json();

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setAssessmentDefinitionId(long)}
   */
  @Test
  void testJsonSetAssessmentDefinitionId2() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Json json = new ImmutableRemoveAssessmentRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Json json = new ImmutableRemoveAssessmentRatingCommand.Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableRemoveAssessmentRatingCommand.Json#setRatingId(long)}
   */
  @Test
  void testJsonSetRatingId2() {
    // Arrange
    ImmutableRemoveAssessmentRatingCommand.Json json = new ImmutableRemoveAssessmentRatingCommand.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }
}
