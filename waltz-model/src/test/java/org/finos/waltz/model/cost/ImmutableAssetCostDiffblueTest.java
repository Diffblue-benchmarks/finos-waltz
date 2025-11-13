package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.cost.ImmutableAssetCost.Builder;
import org.finos.waltz.model.cost.ImmutableAssetCost.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssetCostDiffblueTest {
  /**
   * Test Builder {@link Builder#assetCode(String)}.
   *
   * <ul>
   *   <li>When {@code Asset Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assetCode(String)}
   */
  @Test
  @DisplayName("Test Builder assetCode(String); when 'Asset Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assetCode(String)"})
  void testBuilderAssetCode_whenAssetCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    // Act
    Builder actualAssetCodeResult = builderResult.assetCode("Asset Code");

    // Assert
    assertSame(builderResult, actualAssetCodeResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost Builder.build()", "Builder Builder.provenance(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAssetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableCost cost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();
    ImmutableAssetCost actualImmutableAssetCost =
        actualAssetCodeResult.cost(cost).provenance("Provenance").build();

    // Assert
    assertEquals("Asset Code", actualImmutableAssetCost.assetCode());
    assertEquals("Provenance", actualImmutableAssetCost.provenance());
    assertSame(cost, actualImmutableAssetCost.cost());
  }

  /**
   * Test Builder {@link Builder#cost(Cost)}.
   *
   * <ul>
   *   <li>When {@link ImmutableCost.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cost(Cost)}
   */
  @Test
  @DisplayName("Test Builder cost(Cost); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cost(Cost)"})
  void testBuilderCost_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    // Act
    Builder actualCostResult = builderResult.cost(new ImmutableCost.Json());

    // Assert
    assertSame(builderResult, actualCostResult);
  }

  /**
   * Test Builder {@link Builder#from(AssetCost)} with {@code AssetCost}.
   *
   * <p>Method under test: {@link Builder#from(AssetCost)}
   */
  @Test
  @DisplayName("Test Builder from(AssetCost) with 'AssetCost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssetCost)"})
  void testBuilderFromWithAssetCost() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableAssetCost instance =
        assetCodeResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssetCost actualImmutableAssetCost = builderResult.build();
    assertEquals(instance, actualImmutableAssetCost);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableAssetCost instance =
        assetCodeResult
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableAssetCost actualImmutableAssetCost =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAssetCost);
    ImmutableAssetCost actualImmutableAssetCost2 = builderResult.build();
    assertEquals(instance, actualImmutableAssetCost2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssetCost.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAssetCost#copyOf(AssetCost)}.
   *
   * <ul>
   *   <li>Then cost return {@link ImmutableCost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#copyOf(AssetCost)}
   */
  @Test
  @DisplayName("Test copyOf(AssetCost); then cost return ImmutableCost")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.copyOf(AssetCost)"})
  void testCopyOf_thenCostReturnImmutableCost() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost instance =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAssetCost actualCopyOfResult = ImmutableAssetCost.copyOf(instance);

    // Assert
    Cost costResult = actualCopyOfResult.cost();
    assertTrue(costResult instanceof ImmutableCost);
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Cost Kind", costResult.costKind());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(1, costResult.year());
    assertEquals(EntityKind.ALL, costResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, costResult.amount());
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}, and {@link ImmutableAssetCost#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssetCost#equals(Object)}
   *   <li>{@link ImmutableAssetCost#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    Builder assetCodeResult2 = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost2 =
        assetCodeResult2
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAssetCost, immutableAssetCost2);
    assertEquals(immutableAssetCost.hashCode(), immutableAssetCost2.hashCode());
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}, and {@link ImmutableAssetCost#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssetCost#equals(Object)}
   *   <li>{@link ImmutableAssetCost#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableAssetCost, immutableAssetCost);
    int expectedHashCodeResult = immutableAssetCost.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssetCost.hashCode());
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Cost Kind");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    Builder assetCodeResult2 = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssetCost,
        assetCodeResult2
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("4.5"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    Builder assetCodeResult2 = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssetCost,
        assetCodeResult2
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Asset Code")
            .build();

    Builder assetCodeResult2 = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssetCost,
        assetCodeResult2
            .cost(
                builderResult2
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssetCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssetCost.equals(Object)",
    "int ImmutableAssetCost.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableAssetCost");
  }

  /**
   * Test {@link ImmutableAssetCost#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableCost.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) AssetCode is {@code Json}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) AssetCode is 'Json'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonAssetCodeIsJson_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
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
   * Test {@link ImmutableAssetCost#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableCost.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Provenance is {@code null}.
   *   <li>Then return provenance is {@code waltz}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Provenance is 'null'; then return provenance is 'waltz'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonProvenanceIsNull_thenReturnProvenanceIsWaltz() {
    // Arrange
    Json json = new Json();
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssetCost#toString()}
   *   <li>{@link ImmutableAssetCost#assetCode()}
   *   <li>{@link ImmutableAssetCost#cost()}
   *   <li>{@link ImmutableAssetCost#provenance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssetCost.assetCode()",
    "Cost ImmutableAssetCost.cost()",
    "String ImmutableAssetCost.provenance()",
    "String ImmutableAssetCost.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    String actualToStringResult = immutableAssetCost.toString();
    String actualAssetCodeResult = immutableAssetCost.assetCode();
    Cost actualCostResult = immutableAssetCost.cost();

    // Assert
    assertTrue(actualCostResult instanceof ImmutableCost);
    assertEquals("Asset Code", actualAssetCodeResult);
    assertEquals(
        "AssetCost{assetCode=Asset Code, cost=Cost{amount=2.3, costKind=Cost Kind, year=1, kind=ALL},"
            + " provenance=Provenance}",
        actualToStringResult);
    assertEquals("Provenance", immutableAssetCost.provenance());
  }

  /**
   * Test Json {@link Json#assetCode()}.
   *
   * <p>Method under test: {@link Json#assetCode()}
   */
  @Test
  @DisplayName("Test Json assetCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.assetCode()"})
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assetCode());
  }

  /**
   * Test Json {@link Json#cost()}.
   *
   * <p>Method under test: {@link Json#cost()}
   */
  @Test
  @DisplayName("Test Json cost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Cost Json.cost()"})
  void testJsonCost() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cost());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAssetCode(String)}
   *   <li>{@link Json#setCost(Cost)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAssetCode(String)",
    "void Json.setCost(Cost)",
    "void Json.setProvenance(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAssetCode("Asset Code");
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    BigDecimal amount = new BigDecimal("2.3");
    actualJson.setCost(
        builderResult.amount(amount).costKind("Cost Kind").kind(EntityKind.ALL).year(1).build());
    actualJson.setProvenance("Provenance");

    // Assert
    Cost cost = actualJson.cost;
    assertTrue(cost instanceof ImmutableCost);
    assertEquals("Asset Code", actualJson.assetCode);
    assertEquals("Cost Kind", cost.costKind());
    assertEquals("Provenance", actualJson.provenance);
    assertEquals(1, cost.year());
    assertEquals(EntityKind.ALL, cost.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    BigDecimal amountResult = cost.amount();
    assertEquals(expectedAmountResult, amountResult);
    assertSame(amount, amountResult);
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test {@link ImmutableAssetCost#withAssetCode(String)}.
   *
   * <p>Method under test: {@link ImmutableAssetCost#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.withAssetCode(String)"})
  void testWithAssetCode() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("42");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    // Act
    ImmutableAssetCost actualWithAssetCodeResult = immutableAssetCost.withAssetCode("42");

    // Assert
    assertSame(immutableAssetCost, actualWithAssetCodeResult);
  }

  /**
   * Test {@link ImmutableAssetCost#withAssetCode(String)}.
   *
   * <ul>
   *   <li>Then cost return {@link ImmutableCost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String); then cost return ImmutableCost")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.withAssetCode(String)"})
  void testWithAssetCode_thenCostReturnImmutableCost() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act
    ImmutableAssetCost actualWithAssetCodeResult =
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
            .withAssetCode("42");

    // Assert
    Cost costResult = actualWithAssetCodeResult.cost();
    assertTrue(costResult instanceof ImmutableCost);
    assertEquals("42", actualWithAssetCodeResult.assetCode());
    assertEquals("Cost Kind", costResult.costKind());
    assertEquals("Provenance", actualWithAssetCodeResult.provenance());
    assertEquals(1, costResult.year());
    assertEquals(EntityKind.ALL, costResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, costResult.amount());
  }

  /**
   * Test {@link ImmutableAssetCost#withCost(Cost)}.
   *
   * <p>Method under test: {@link ImmutableAssetCost#withCost(Cost)}
   */
  @Test
  @DisplayName("Test withCost(Cost)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.withCost(Cost)"})
  void testWithCost() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("Provenance")
            .build();

    ImmutableCost.Builder builderResult2 = ImmutableCost.builder();

    // Act
    ImmutableAssetCost actualWithCostResult =
        immutableAssetCost.withCost(
            builderResult2
                .amount(new BigDecimal("2.3"))
                .costKind("Cost Kind")
                .kind(EntityKind.ALL)
                .year(1)
                .build());

    // Assert
    assertEquals(immutableAssetCost, actualWithCostResult);
  }

  /**
   * Test {@link ImmutableAssetCost#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAssetCost#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    ImmutableAssetCost immutableAssetCost =
        assetCodeResult
            .cost(
                builderResult
                    .amount(new BigDecimal("2.3"))
                    .costKind("Cost Kind")
                    .kind(EntityKind.ALL)
                    .year(1)
                    .build())
            .provenance("42")
            .build();

    // Act
    ImmutableAssetCost actualWithProvenanceResult = immutableAssetCost.withProvenance("42");

    // Assert
    assertSame(immutableAssetCost, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAssetCost#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then cost return {@link ImmutableCost}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssetCost#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then cost return ImmutableCost")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssetCost ImmutableAssetCost.withProvenance(String)"})
  void testWithProvenance_thenCostReturnImmutableCost() {
    // Arrange
    Builder assetCodeResult = ImmutableAssetCost.builder().assetCode("Asset Code");

    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act
    ImmutableAssetCost actualWithProvenanceResult =
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
            .withProvenance("42");

    // Assert
    Cost costResult = actualWithProvenanceResult.cost();
    assertTrue(costResult instanceof ImmutableCost);
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Asset Code", actualWithProvenanceResult.assetCode());
    assertEquals("Cost Kind", costResult.costKind());
    assertEquals(1, costResult.year());
    assertEquals(EntityKind.ALL, costResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, costResult.amount());
  }
}
