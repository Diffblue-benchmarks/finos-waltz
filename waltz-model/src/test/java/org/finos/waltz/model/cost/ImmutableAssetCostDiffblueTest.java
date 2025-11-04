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
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAssetCostDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssetCost#builder()}
   *   <li>{@link ImmutableAssetCost#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAssetCost.Builder actualBuilderResult = ImmutableAssetCost.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.provenance("Provenance"));
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Builder#assetCode(String)}
   */
  @Test
  void testBuilderAssetCode() {
    // Arrange
    ImmutableAssetCost.Builder builderResult = ImmutableAssetCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode("Asset Code"));
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Builder#cost(Cost)}
   */
  @Test
  void testBuilderCost() {
    // Arrange
    ImmutableAssetCost.Builder builderResult = ImmutableAssetCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cost(new ImmutableCost.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssetCost.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssetCost.Builder builderResult = ImmutableAssetCost.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssetCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Builder#from(AssetCost)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssetCost.Builder builderResult = ImmutableAssetCost.builder();
    AssetCost instance = mock(AssetCost.class);
    ImmutableCost.Json json = new ImmutableCost.Json();
    when(instance.cost()).thenReturn(json);
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssetCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assetCode();
    verify(instance).cost();
    verify(instance).provenance();
    ImmutableAssetCost buildResult = builderResult.build();
    assertEquals("Asset Code", buildResult.assetCode());
    assertEquals("Provenance", buildResult.provenance());
    assertSame(json, buildResult.cost());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Builder#from(AssetCost)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssetCost.Builder builderResult = ImmutableAssetCost.builder();
    AssetCost instance = mock(AssetCost.class);
    when(instance.cost()).thenThrow(new IllegalStateException("instance"));
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.provenance()).thenReturn("Provenance");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assetCode();
    verify(instance).cost();
    verify(instance).provenance();
  }

  /**
   * Method under test: {@link ImmutableAssetCost#copyOf(AssetCost)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssetCost instance = mock(AssetCost.class);
    ImmutableCost.Json json = new ImmutableCost.Json();
    when(instance.cost()).thenReturn(json);
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssetCost actualCopyOfResult = ImmutableAssetCost.copyOf(instance);

    // Assert
    verify(instance).assetCode();
    verify(instance).cost();
    verify(instance).provenance();
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertSame(json, actualCopyOfResult.cost());
  }

  /**
   * Method under test:
   * {@link ImmutableAssetCost#fromJson(ImmutableAssetCost.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssetCost.Json json = new ImmutableAssetCost.Json();
    json.setAssetCode("Json");
    ImmutableCost.Json cost = new ImmutableCost.Json();
    json.setCost(cost);
    json.setProvenance(null);

    // Act
    ImmutableAssetCost actualFromJsonResult = ImmutableAssetCost.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.assetCode());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertSame(cost, actualFromJsonResult.cost());
  }

  /**
   * Method under test:
   * {@link ImmutableAssetCost#fromJson(ImmutableAssetCost.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAssetCost.Json json = new ImmutableAssetCost.Json();
    json.setAssetCode("Json");
    ImmutableCost.Json cost = new ImmutableCost.Json();
    json.setCost(cost);
    json.setProvenance("Json");

    // Act
    ImmutableAssetCost actualFromJsonResult = ImmutableAssetCost.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.assetCode());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertSame(cost, actualFromJsonResult.cost());
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Json#assetCode()}
   */
  @Test
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssetCost.Json()).assetCode());
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Json#cost()}
   */
  @Test
  void testJsonCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssetCost.Json()).cost());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableAssetCost.Json}
   *   <li>{@link ImmutableAssetCost.Json#setAssetCode(String)}
   *   <li>{@link ImmutableAssetCost.Json#setCost(Cost)}
   *   <li>{@link ImmutableAssetCost.Json#setProvenance(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssetCost.Json actualJson = new ImmutableAssetCost.Json();
    actualJson.setAssetCode("Asset Code");
    actualJson.setCost(new ImmutableCost.Json());
    actualJson.setProvenance("Provenance");

    // Assert
    Cost cost = actualJson.cost;
    assertTrue(cost instanceof ImmutableCost.Json);
    assertEquals("Asset Code", actualJson.assetCode);
    assertEquals("Provenance", actualJson.provenance);
    assertNull(((ImmutableCost.Json) cost).costKind);
    assertNull(((ImmutableCost.Json) cost).amount);
    assertNull(((ImmutableCost.Json) cost).kind);
    assertEquals(0, ((ImmutableCost.Json) cost).year);
    assertFalse(((ImmutableCost.Json) cost).yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssetCost.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssetCost.Json()).provenance());
  }
}
