package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ImmutableCost#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCost#builder()}
   *   <li>{@link ImmutableCost#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCost Builder.build()", "Builder Builder.kind(EntityKind)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableCost.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#amount(BigDecimal)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#amount(BigDecimal)}
   */
  @Test
  @DisplayName("Test Builder amount(BigDecimal); when BigDecimal(String) with '2.3'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.amount(BigDecimal)"})
  void testBuilderAmount_whenBigDecimalWith23_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.amount(new BigDecimal("2.3")));
  }

  /**
   * Test Builder {@link Builder#costKind(String)}.
   * <p>
   * Method under test: {@link Builder#costKind(String)}
   */
  @Test
  @DisplayName("Test Builder costKind(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.costKind(String)"})
  void testBuilderCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKind("Cost Kind"));
  }

  /**
   * Test Builder {@link Builder#from(Cost)} with {@code Cost}.
   * <ul>
   *   <li>Given {@code Cost Kind}.</li>
   *   <li>Then builder build costKind is {@code Cost Kind}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Cost)}
   */
  @Test
  @DisplayName("Test Builder from(Cost) with 'Cost'; given 'Cost Kind'; then builder build costKind is 'Cost Kind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Cost)"})
  void testBuilderFromWithCost_givenCostKind_thenBuilderBuildCostKindIsCostKind() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    Cost instance = mock(Cost.class);
    when(instance.costKind()).thenReturn("Cost Kind");
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).amount();
    verify(instance).costKind();
    verify(instance).kind();
    verify(instance).year();
    ImmutableCost buildResult = builderResult.build();
    assertEquals("Cost Kind", buildResult.costKind());
    assertEquals(1, buildResult.year());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(bigDecimal, buildResult.amount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Cost)} with {@code Cost}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Cost)}
   */
  @Test
  @DisplayName("Test Builder from(Cost) with 'Cost'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Cost)"})
  void testBuilderFromWithCost_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();
    Cost instance = mock(Cost.class);
    when(instance.costKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.year()).thenReturn(1);
    when(instance.amount()).thenReturn(new BigDecimal("2.3"));
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).amount();
    verify(instance).costKind();
    verify(instance).kind();
    verify(instance).year();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#year(int)}
   */
  @Test
  @DisplayName("Test Builder year(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.year(int)"})
  void testBuilderYear() {
    // Arrange
    Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Test Json {@link Json#amount()}.
   * <p>
   * Method under test: {@link Json#amount()}
   */
  @Test
  @DisplayName("Test Json amount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.amount()"})
  void testJsonAmount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).amount());
  }

  /**
   * Test Json {@link Json#costKind()}.
   * <p>
   * Method under test: {@link Json#costKind()}
   */
  @Test
  @DisplayName("Test Json costKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.costKind()"})
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).costKind());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAmount(BigDecimal)}
   *   <li>{@link Json#setCostKind(String)}
   *   <li>{@link Json#setKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAmount(BigDecimal)", "void Json.setCostKind(String)",
      "void Json.setKind(EntityKind)"})
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
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#setYear(int)}.
   * <p>
   * Method under test: {@link Json#setYear(int)}
   */
  @Test
  @DisplayName("Test Json setYear(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#year()}
   */
  @Test
  @DisplayName("Test Json year()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.year()"})
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).year());
  }
}
