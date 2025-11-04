package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorRatingCharacteristicsRequestDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        .builder();
    DataTypeDecoratorRatingCharacteristicsRequest instance = mock(DataTypeDecoratorRatingCharacteristicsRequest.class);
    when(instance.target()).thenThrow(new IllegalStateException("instance"));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        .builder();
    DataTypeDecoratorRatingCharacteristicsRequest instance = mock(DataTypeDecoratorRatingCharacteristicsRequest.class);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).source();
    verify(instance).target();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder#source(EntityReference)}
   */
  @Test
  void testBuilderSource() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder#target(EntityReference)}
   */
  @Test
  void testBuilderTarget() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#copyOf(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeDecoratorRatingCharacteristicsRequest instance = mock(DataTypeDecoratorRatingCharacteristicsRequest.class);
    when(instance.target()).thenReturn(mock(EntityReference.class));
    when(instance.source()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.copyOf(instance);

    // Assert
    verify(instance).source();
    verify(instance).target();
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#fromJson(ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json json = new ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json();
    json.setTarget(mock(EntityReference.class));
    json.setSource(mock(EntityReference.class));

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest actualFromJsonResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        .fromJson(json);

    // Assert
    EntityReference expectedSourceResult = json.source;
    assertSame(expectedSourceResult, actualFromJsonResult.source());
    EntityReference expectedTargetResult = json.target;
    assertSame(expectedTargetResult, actualFromJsonResult.target());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json#setSource(EntityReference)}
   *   <li>
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json#setTarget(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json actualJson = new ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json();
    actualJson.setSource(null);
    actualJson.setTarget(null);

    // Assert
    assertNull(actualJson.source);
    assertNull(actualJson.target);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json#source()}
   */
  @Test
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json()).source());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json#target()}
   */
  @Test
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json()).target());
  }
}
