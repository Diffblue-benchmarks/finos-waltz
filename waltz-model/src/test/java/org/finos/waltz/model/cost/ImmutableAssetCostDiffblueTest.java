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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.cost.ImmutableAssetCost.Builder;
import org.finos.waltz.model.cost.ImmutableAssetCost.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssetCostDiffblueTest {
  /**
   * Test {@link ImmutableAssetCost#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssetCost#builder()}
   *   <li>{@link ImmutableAssetCost#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssetCost Builder.build()", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssetCost.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#assetCode(String)}.
   * <p>
   * Method under test: {@link Builder#assetCode(String)}
   */
  @Test
  @DisplayName("Test Builder assetCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assetCode(String)"})
  void testBuilderAssetCode() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode("Asset Code"));
  }

  /**
   * Test Builder {@link Builder#cost(Cost)}.
   * <ul>
   *   <li>When {@link ImmutableCost.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#cost(Cost)}
   */
  @Test
  @DisplayName("Test Builder cost(Cost); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cost(Cost)"})
  void testBuilderCost_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cost(new ImmutableCost.Json()));
  }

  /**
   * Test Builder {@link Builder#from(AssetCost)} with {@code AssetCost}.
   * <ul>
   *   <li>Given {@link ImmutableCost.Json} (default constructor).</li>
   *   <li>Then builder build assetCode is {@code Asset Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssetCost)}
   */
  @Test
  @DisplayName("Test Builder from(AssetCost) with 'AssetCost'; given Json (default constructor); then builder build assetCode is 'Asset Code'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssetCost)"})
  void testBuilderFromWithAssetCost_givenJson_thenBuilderBuildAssetCodeIsAssetCode() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();
    AssetCost instance = mock(AssetCost.class);
    ImmutableCost.Json json = new ImmutableCost.Json();
    when(instance.cost()).thenReturn(json);
    when(instance.assetCode()).thenReturn("Asset Code");
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(AssetCost)} with {@code AssetCost}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssetCost)}
   */
  @Test
  @DisplayName("Test Builder from(AssetCost) with 'AssetCost'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssetCost)"})
  void testBuilderFromWithAssetCost_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();
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
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Json {@link Json#assetCode()}.
   * <p>
   * Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assetCode());
  }

  /**
   * Test Json {@link Json#cost()}.
   * <p>
   * Method under test: {@link Json#cost()}
   */
  @Test
  @DisplayName("Test Json cost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Cost Json.cost()"})
  void testJsonCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cost());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAssetCode(String)}
   *   <li>{@link Json#setCost(Cost)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAssetCode(String)", "void Json.setCost(Cost)",
      "void Json.setProvenance(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#provenance()}.
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }
}
