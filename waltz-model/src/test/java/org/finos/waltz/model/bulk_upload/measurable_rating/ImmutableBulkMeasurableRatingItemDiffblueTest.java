package org.finos.waltz.model.bulk_upload.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBulkMeasurableRatingItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableBulkMeasurableRatingItem#builder()}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#allocation(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem#comment(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem.Builder actualAllocationResult = ImmutableBulkMeasurableRatingItem.builder()
        .allocation(1);

    // Assert
    assertSame(actualAllocationResult, actualAllocationResult.comment("Comment"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#assetCode(String)}
   */
  @Test
  void testBuilderAssetCode() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode("Asset Code"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(1);
    when(instance.comment()).thenReturn("Comment");
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    ImmutableBulkMeasurableRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    ImmutableBulkMeasurableRatingItem buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Scheme", buildResult.scheme());
    assertEquals('A', buildResult.ratingCode());
    assertEquals(1, buildResult.allocation().intValue());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenThrow(new IllegalStateException("instance"));
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assetCode();
    verify(instance).ratingCode();
    verify(instance).taxonomyExternalId();
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(null);
    when(instance.comment()).thenReturn("Comment");
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    ImmutableBulkMeasurableRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    ImmutableBulkMeasurableRatingItem buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Scheme", buildResult.scheme());
    assertEquals('A', buildResult.ratingCode());
    assertNull(buildResult.allocation());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#from(BulkMeasurableRatingItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(1);
    when(instance.comment()).thenReturn(null);
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    ImmutableBulkMeasurableRatingItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    ImmutableBulkMeasurableRatingItem buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Scheme", buildResult.scheme());
    assertEquals('A', buildResult.ratingCode());
    assertNull(buildResult.comment());
    assertEquals(1, buildResult.allocation().intValue());
    assertTrue(buildResult.isPrimary());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#isPrimary(boolean)}
   */
  @Test
  void testBuilderIsPrimary() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isPrimary(true));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#ratingCode(char)}
   */
  @Test
  void testBuilderRatingCode() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCode('A'));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#scheme(String)}
   */
  @Test
  void testBuilderScheme() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.scheme("Scheme"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Builder#taxonomyExternalId(String)}
   */
  @Test
  void testBuilderTaxonomyExternalId() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Builder builderResult = ImmutableBulkMeasurableRatingItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem#copyOf(BulkMeasurableRatingItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(1);
    when(instance.comment()).thenReturn("Comment");
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(true);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    ImmutableBulkMeasurableRatingItem actualCopyOfResult = ImmutableBulkMeasurableRatingItem.copyOf(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    assertEquals("42", actualCopyOfResult.taxonomyExternalId());
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Scheme", actualCopyOfResult.scheme());
    assertEquals('A', actualCopyOfResult.ratingCode());
    assertEquals(1, actualCopyOfResult.allocation().intValue());
    assertTrue(actualCopyOfResult.isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem#copyOf(BulkMeasurableRatingItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    BulkMeasurableRatingItem instance = mock(BulkMeasurableRatingItem.class);
    when(instance.ratingCode()).thenReturn('A');
    when(instance.allocation()).thenReturn(1);
    when(instance.comment()).thenReturn("Comment");
    when(instance.scheme()).thenReturn("Scheme");
    when(instance.isPrimary()).thenReturn(false);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.assetCode()).thenReturn("Asset Code");

    // Act
    ImmutableBulkMeasurableRatingItem actualCopyOfResult = ImmutableBulkMeasurableRatingItem.copyOf(instance);

    // Assert
    verify(instance).allocation();
    verify(instance).assetCode();
    verify(instance).comment();
    verify(instance).isPrimary();
    verify(instance).ratingCode();
    verify(instance).scheme();
    verify(instance).taxonomyExternalId();
    assertEquals("42", actualCopyOfResult.taxonomyExternalId());
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Scheme", actualCopyOfResult.scheme());
    assertEquals('A', actualCopyOfResult.ratingCode());
    assertEquals(1, actualCopyOfResult.allocation().intValue());
    assertFalse(actualCopyOfResult.isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Json#allocation()}
   */
  @Test
  void testJsonAllocation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingItem.Json()).allocation());
  }

  /**
   * Method under test: {@link ImmutableBulkMeasurableRatingItem.Json#assetCode()}
   */
  @Test
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkMeasurableRatingItem.Json()).assetCode());
  }

  /**
   * Method under test: {@link ImmutableBulkMeasurableRatingItem.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkMeasurableRatingItem.Json()).comment());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableBulkMeasurableRatingItem.Json}
   *   <li>{@link ImmutableBulkMeasurableRatingItem.Json#setAllocation(Integer)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem.Json#setAssetCode(String)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem.Json#setComment(String)}
   *   <li>{@link ImmutableBulkMeasurableRatingItem.Json#setScheme(String)}
   *   <li>
   * {@link ImmutableBulkMeasurableRatingItem.Json#setTaxonomyExternalId(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBulkMeasurableRatingItem.Json actualJson = new ImmutableBulkMeasurableRatingItem.Json();
    actualJson.setAllocation(1);
    actualJson.setAssetCode("Asset Code");
    actualJson.setComment("Comment");
    actualJson.setScheme("Scheme");
    actualJson.setTaxonomyExternalId("42");

    // Assert
    assertEquals(1, actualJson.allocation.intValue());
  }

  /**
   * Method under test: {@link ImmutableBulkMeasurableRatingItem.Json#isPrimary()}
   */
  @Test
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkMeasurableRatingItem.Json()).isPrimary());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Json#ratingCode()}
   */
  @Test
  void testJsonRatingCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingItem.Json()).ratingCode());
  }

  /**
   * Method under test: {@link ImmutableBulkMeasurableRatingItem.Json#scheme()}
   */
  @Test
  void testJsonScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBulkMeasurableRatingItem.Json()).scheme());
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Json#setIsPrimary(boolean)}
   */
  @Test
  void testJsonSetIsPrimary() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    json.setIsPrimary(true);

    // Assert
    assertTrue(json.isPrimary);
    assertTrue(json.isPrimaryIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Json#setRatingCode(char)}
   */
  @Test
  void testJsonSetRatingCode() {
    // Arrange
    ImmutableBulkMeasurableRatingItem.Json json = new ImmutableBulkMeasurableRatingItem.Json();

    // Act
    json.setRatingCode('A');

    // Assert
    assertEquals('A', json.ratingCode);
    assertTrue(json.ratingCodeIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableBulkMeasurableRatingItem.Json#taxonomyExternalId()}
   */
  @Test
  void testJsonTaxonomyExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableBulkMeasurableRatingItem.Json()).taxonomyExternalId());
  }
}
