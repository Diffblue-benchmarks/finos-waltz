package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.cost.ImmutableAssetCost.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssetCostDiffblueTest {
  /**
   * Test {@link AssetCost#provenance()}.
   *
   * <ul>
   *   <li>Then return {@code Provenance}.
   * </ul>
   *
   * <p>Method under test: {@link AssetCost#provenance()}
   */
  @Test
  @DisplayName("Test provenance(); then return 'Provenance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AssetCost.provenance()"})
  void testProvenance_thenReturnProvenance() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertEquals(
        "Provenance",
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build()
            .provenance());
  }
}
