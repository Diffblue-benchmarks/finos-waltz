package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableAssetCostQueryOptionsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssetCostQueryOptions.Builder#from(AssetCostQueryOptions)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();
    AssetCostQueryOptions instance = mock(AssetCostQueryOptions.class);
    when(instance.year()).thenReturn(1);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableAssetCostQueryOptions.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).year();
    assertEquals(1, actualFromResult.build().year());
    assertEquals(1, builderResult.build().year());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssetCostQueryOptions.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Method under test: {@link ImmutableAssetCostQueryOptions.Builder#year(int)}
   */
  @Test
  void testBuilderYear() {
    // Arrange
    ImmutableAssetCostQueryOptions.Builder builderResult = ImmutableAssetCostQueryOptions.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test:
   * {@link ImmutableAssetCostQueryOptions#copyOf(AssetCostQueryOptions)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssetCostQueryOptions instance = mock(AssetCostQueryOptions.class);
    when(instance.year()).thenReturn(1);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableAssetCostQueryOptions actualCopyOfResult = ImmutableAssetCostQueryOptions.copyOf(instance);

    // Assert
    verify(instance).idSelectionOptions();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAssetCostQueryOptions.Json}
   *   <li>
   * {@link ImmutableAssetCostQueryOptions.Json#setIdSelectionOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssetCostQueryOptions.Json actualJson = new ImmutableAssetCostQueryOptions.Json();
    actualJson.setIdSelectionOptions(null);

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.yearIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssetCostQueryOptions.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssetCostQueryOptions.Json()).idSelectionOptions());
  }

  /**
   * Method under test: {@link ImmutableAssetCostQueryOptions.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear() {
    // Arrange
    ImmutableAssetCostQueryOptions.Json json = new ImmutableAssetCostQueryOptions.Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssetCostQueryOptions.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear2() {
    // Arrange
    ImmutableAssetCostQueryOptions.Json json = new ImmutableAssetCostQueryOptions.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssetCostQueryOptions.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssetCostQueryOptions.Json()).year());
  }
}
