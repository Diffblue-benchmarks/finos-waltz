package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableRatingEntityListDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#addAllEntityReferences(Iterable)}
   */
  @Test
  void testBuilderAddAllEntityReferences() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEntityReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#addEntityReferences(EntityReference)}
   */
  @Test
  void testBuilderAddEntityReferences() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#addEntityReferences(EntityReference[])}
   */
  @Test
  void testBuilderAddEntityReferences2() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addEntityReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#entityReferences(Iterable)}
   */
  @Test
  void testBuilderEntityReferences() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#from(RatingEntityList)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(new HashSet<>());
    when(instance.rating()).thenReturn("Rating");

    // Act
    ImmutableRatingEntityList.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    assertEquals("Rating", builderResult.build().rating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#from(RatingEntityList)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn("Rating");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReferences();
    verify(instance).rating();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList.Builder#from(RatingEntityList)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();

    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(entityReferenceSet);
    when(instance.rating()).thenReturn("Rating");

    // Act
    ImmutableRatingEntityList.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    ImmutableRatingEntityList buildResult = builderResult.build();
    assertEquals("Rating", buildResult.rating());
    assertEquals(1, buildResult.entityReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList.Builder#rating(String)}
   */
  @Test
  void testBuilderRating() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    ImmutableRatingEntityList.Builder actualRatingResult = builderResult.rating("Rating");

    // Assert
    assertEquals("Rating", builderResult.build().rating());
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList.Builder#rating(String)}
   */
  @Test
  void testBuilderRating2() {
    // Arrange
    ImmutableRatingEntityList.Builder builderResult = ImmutableRatingEntityList.builder();
    builderResult.addEntityReferences(mock(EntityReference.class));

    // Act
    ImmutableRatingEntityList.Builder actualRatingResult = builderResult.rating("Rating");

    // Assert
    ImmutableRatingEntityList buildResult = builderResult.build();
    assertEquals("Rating", buildResult.rating());
    assertEquals(1, buildResult.entityReferences().size());
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList#copyOf(RatingEntityList)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(new HashSet<>());
    when(instance.rating()).thenReturn("Rating");

    // Act
    ImmutableRatingEntityList actualCopyOfResult = ImmutableRatingEntityList.copyOf(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    assertEquals("Rating", actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.entityReferences().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList#copyOf(RatingEntityList)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(entityReferenceSet);
    when(instance.rating()).thenReturn("Rating");

    // Act
    ImmutableRatingEntityList actualCopyOfResult = ImmutableRatingEntityList.copyOf(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals(1, actualCopyOfResult.entityReferences().size());
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList#copyOf(RatingEntityList)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<EntityReference> entityReferenceSet = new HashSet<>();
    entityReferenceSet.add(mock(EntityReference.class));
    entityReferenceSet.add(mock(EntityReference.class));
    RatingEntityList instance = mock(RatingEntityList.class);
    when(instance.entityReferences()).thenReturn(entityReferenceSet);
    when(instance.rating()).thenReturn("Rating");

    // Act
    ImmutableRatingEntityList actualCopyOfResult = ImmutableRatingEntityList.copyOf(instance);

    // Assert
    verify(instance).entityReferences();
    verify(instance).rating();
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals(entityReferenceSet, actualCopyOfResult.entityReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList#fromJson(ImmutableRatingEntityList.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRatingEntityList.Json json = new ImmutableRatingEntityList.Json();
    json.setRating("Json");
    json.setEntityReferences(null);

    // Act
    ImmutableRatingEntityList actualFromJsonResult = ImmutableRatingEntityList.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.rating());
    assertTrue(actualFromJsonResult.entityReferences().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingEntityList#fromJson(ImmutableRatingEntityList.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<EntityReference> entityReferences = new LinkedHashSet<>();
    entityReferences.add(mock(EntityReference.class));

    ImmutableRatingEntityList.Json json = new ImmutableRatingEntityList.Json();
    json.setRating("Json");
    json.setEntityReferences(entityReferences);

    // Act
    ImmutableRatingEntityList actualFromJsonResult = ImmutableRatingEntityList.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.rating());
    assertEquals(1, actualFromJsonResult.entityReferences().size());
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList.Json#entityReferences()}
   */
  @Test
  void testJsonEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingEntityList.Json()).entityReferences());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRatingEntityList.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRatingEntityList.Json actualJson = new ImmutableRatingEntityList.Json();

    // Assert
    assertNull(actualJson.rating);
    assertTrue(actualJson.entityReferences.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRatingEntityList.Json#rating()}
   */
  @Test
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingEntityList.Json()).rating());
  }
}
