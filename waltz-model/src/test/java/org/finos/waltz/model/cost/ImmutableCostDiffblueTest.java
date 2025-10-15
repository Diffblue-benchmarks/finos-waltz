package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.cost.ImmutableCost.Builder;
import org.finos.waltz.model.cost.ImmutableCost.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostDiffblueTest {
  /**
   * Test Builder {@link Builder#amount(BigDecimal)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#amount(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test Builder amount(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.amount(BigDecimal)"})
  void testBuilderAmount_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act
    Builder actualAmountResult = builderResult.amount(new BigDecimal("2.3"));

    // Assert
    assertSame(builderResult, actualAmountResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost Builder.build()", "Builder Builder.kind(EntityKind)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableCost.builder();
    BigDecimal amount = new BigDecimal("2.3");
    ImmutableCost actualImmutableCost =
        actualBuilderResult
            .amount(amount)
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Assert
    assertEquals("Cost Kind", actualImmutableCost.costKind());
    assertEquals(1, actualImmutableCost.year());
    assertEquals(EntityKind.ALL, actualImmutableCost.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    BigDecimal amountResult = actualImmutableCost.amount();
    assertEquals(expectedAmountResult, amountResult);
    assertSame(amount, amountResult);
  }

  /**
   * Test Builder {@link Builder#costKind(String)}.
   *
   * <ul>
   *   <li>When {@code Cost Kind}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKind(String)}
   */
  @Test
  @DisplayName("Test Builder costKind(String); when 'Cost Kind'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKind(String)"})
  void testBuilderCostKind_whenCostKind_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act
    Builder actualCostKindResult = builderResult.costKind("Cost Kind");

    // Assert
    assertSame(builderResult, actualCostKindResult);
  }

  /**
   * Test Builder {@link Builder#from(Cost)} with {@code Cost}.
   *
   * <p>Method under test: {@link Builder#from(Cost)}
   */
  @Test
  @DisplayName("Test Builder from(Cost) with 'Cost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Cost)"})
  void testBuilderFromWithCost() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    Builder builderResult2 = ImmutableCost.builder();
    ImmutableCost instance =
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCost actualImmutableCost = builderResult.build();
    assertEquals(instance, actualImmutableCost);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    Builder builderResult2 = ImmutableCost.builder();
    ImmutableCost instance =
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act and Assert
    ImmutableCost actualImmutableCost = builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableCost);
    ImmutableCost actualImmutableCost2 = builderResult.build();
    assertEquals(instance, actualImmutableCost2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#year(int)}.
   *
   * <p>Method under test: {@link Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.year(int)"})
  void testBuilderYear() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act
    Builder actualYearResult = builderResult.year(1);

    // Assert
    assertSame(builderResult, actualYearResult);
  }

  /**
   * Test {@link ImmutableCost#copyOf(Cost)}.
   *
   * <ul>
   *   <li>Then return {@code Cost Kind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#copyOf(Cost)}
   */
  @Test
  @DisplayName("Test copyOf(Cost); then return 'Cost Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.copyOf(Cost)"})
  void testCopyOf_thenReturnCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost instance =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act
    ImmutableCost actualCopyOfResult = ImmutableCost.copyOf(instance);

    // Assert
    assertEquals("Cost Kind", actualCopyOfResult.costKind());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, actualCopyOfResult.amount());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}, and {@link ImmutableCost#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCost#equals(Object)}
   *   <li>{@link ImmutableCost#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    Builder builderResult2 = ImmutableCost.builder();
    ImmutableCost immutableCost2 =
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act and Assert
    assertEquals(immutableCost, immutableCost2);
    assertEquals(immutableCost.hashCode(), immutableCost2.hashCode());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}, and {@link ImmutableCost#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCost#equals(Object)}
   *   <li>{@link ImmutableCost#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act and Assert
    assertEquals(immutableCost, immutableCost);
    int expectedHashCodeResult = immutableCost.hashCode();
    assertEquals(expectedHashCodeResult, immutableCost.hashCode());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("4.5"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableCost,
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("amount")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableCost,
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ACTOR)
            .year(1)
            .build();

    Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableCost,
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(0)
            .build();

    Builder builderResult2 = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        immutableCost,
        builderResult2
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build());
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCost#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableCost.equals(Object)", "int ImmutableCost.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build(),
        "Different type to ImmutableCost");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCost#toString()}
   *   <li>{@link ImmutableCost#amount()}
   *   <li>{@link ImmutableCost#costKind()}
   *   <li>{@link ImmutableCost#kind()}
   *   <li>{@link ImmutableCost#year()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BigDecimal ImmutableCost.amount()",
    "String ImmutableCost.costKind()",
    "EntityKind ImmutableCost.kind()",
    "String ImmutableCost.toString()",
    "int ImmutableCost.year()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    BigDecimal amount = new BigDecimal("2.3");
    ImmutableCost immutableCost =
        builderResult.amount(amount).costKind("Cost Kind").kind(EntityKind.ALL).year(1).build();

    // Act
    String actualToStringResult = immutableCost.toString();
    BigDecimal actualAmountResult = immutableCost.amount();
    String actualCostKindResult = immutableCost.costKind();
    EntityKind actualKindResult = immutableCost.kind();

    // Assert
    assertEquals("Cost Kind", actualCostKindResult);
    assertEquals("Cost{amount=2.3, costKind=Cost Kind, year=1, kind=ALL}", actualToStringResult);
    assertEquals(1, immutableCost.year());
    assertEquals(EntityKind.ALL, actualKindResult);
    assertEquals(new BigDecimal("2.3"), actualAmountResult);
    assertSame(amount, actualAmountResult);
  }

  /**
   * Test Json {@link Json#amount()}.
   *
   * <p>Method under test: {@link Json#amount()}
   */
  @Test
  @DisplayName("Test Json amount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.amount()"})
  void testJsonAmount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().amount());
  }

  /**
   * Test Json {@link Json#costKind()}.
   *
   * <p>Method under test: {@link Json#costKind()}
   */
  @Test
  @DisplayName("Test Json costKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.costKind()"})
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().costKind());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAmount(BigDecimal)}
   *   <li>{@link Json#setCostKind(String)}
   *   <li>{@link Json#setKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAmount(BigDecimal)",
    "void Json.setCostKind(String)",
    "void Json.setKind(EntityKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setAmount(new BigDecimal("2.3"));
    actualJson.setCostKind("Cost Kind");
    actualJson.setKind(EntityKind.ALL);

    // Assert
    assertEquals("Cost Kind", actualJson.costKind);
    assertEquals(0, actualJson.year);
    assertEquals(EntityKind.ALL, actualJson.kind);
    assertFalse(actualJson.yearIsSet);
    assertEquals(new BigDecimal("2.3"), actualJson.amount);
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#setYear(int)}.
   *
   * <p>Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setYear(int)"})
  void testJsonSetYear() {
    // Arrange
    Json json = new Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Test Json {@link Json#year()}.
   *
   * <p>Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().year());
  }

  /**
   * Test {@link ImmutableCost#withAmount(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableCost#withAmount(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAmount(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withAmount(BigDecimal)"})
  void testWithAmount() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act
    ImmutableCost actualWithAmountResult = immutableCost.withAmount(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableCost, actualWithAmountResult);
  }

  /**
   * Test {@link ImmutableCost#withAmount(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return {@code Cost Kind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#withAmount(BigDecimal)}
   */
  @Test
  @DisplayName("Test withAmount(BigDecimal); then return 'Cost Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withAmount(BigDecimal)"})
  void testWithAmount_thenReturnCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("4.5"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act
    ImmutableCost actualWithAmountResult = immutableCost.withAmount(new BigDecimal("2.3"));

    // Assert
    assertEquals("Cost Kind", actualWithAmountResult.costKind());
    assertEquals(1, actualWithAmountResult.year());
    assertEquals(EntityKind.ALL, actualWithAmountResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, actualWithAmountResult.amount());
  }

  /**
   * Test {@link ImmutableCost#withCostKind(String)}.
   *
   * <p>Method under test: {@link ImmutableCost#withCostKind(String)}
   */
  @Test
  @DisplayName("Test withCostKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withCostKind(String)"})
  void testWithCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("42")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act
    ImmutableCost actualWithCostKindResult = immutableCost.withCostKind("42");

    // Assert
    assertSame(immutableCost, actualWithCostKindResult);
  }

  /**
   * Test {@link ImmutableCost#withCostKind(String)}.
   *
   * <ul>
   *   <li>Then return costKind is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#withCostKind(String)}
   */
  @Test
  @DisplayName("Test withCostKind(String); then return costKind is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withCostKind(String)"})
  void testWithCostKind_thenReturnCostKindIs42() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act
    ImmutableCost actualWithCostKindResult =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build()
            .withCostKind("42");

    // Assert
    assertEquals("42", actualWithCostKindResult.costKind());
    assertEquals(1, actualWithCostKindResult.year());
    assertEquals(EntityKind.ALL, actualWithCostKindResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, actualWithCostKindResult.amount());
  }

  /**
   * Test {@link ImmutableCost#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableCost#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build();

    // Act
    ImmutableCost actualWithKindResult = immutableCost.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableCost, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableCost#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Cost Kind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Cost Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withKind(EntityKind)"})
  void testWithKind_thenReturnCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act
    ImmutableCost actualWithKindResult =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ACTOR)
            .year(1)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Cost Kind", actualWithKindResult.costKind());
    assertEquals(1, actualWithKindResult.year());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, actualWithKindResult.amount());
  }

  /**
   * Test {@link ImmutableCost#withYear(int)}.
   *
   * <p>Method under test: {@link ImmutableCost#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withYear(int)"})
  void testWithYear() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    ImmutableCost immutableCost =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(42)
            .build();

    // Act
    ImmutableCost actualWithYearResult = immutableCost.withYear(42);

    // Assert
    assertSame(immutableCost, actualWithYearResult);
  }

  /**
   * Test {@link ImmutableCost#withYear(int)}.
   *
   * <ul>
   *   <li>Then return {@code Cost Kind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCost#withYear(int)}
   */
  @Test
  @DisplayName("Test withYear(int); then return 'Cost Kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCost ImmutableCost.withYear(int)"})
  void testWithYear_thenReturnCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act
    ImmutableCost actualWithYearResult =
        builderResult
            .amount(new BigDecimal("2.3"))
            .costKind("Cost Kind")
            .kind(EntityKind.ALL)
            .year(1)
            .build()
            .withYear(42);

    // Assert
    assertEquals("Cost Kind", actualWithYearResult.costKind());
    assertEquals(42, actualWithYearResult.year());
    assertEquals(EntityKind.ALL, actualWithYearResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    assertEquals(expectedAmountResult, actualWithYearResult.amount());
  }
}
