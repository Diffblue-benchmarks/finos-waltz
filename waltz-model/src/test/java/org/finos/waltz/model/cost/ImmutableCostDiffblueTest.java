package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.junit.jupiter.api.Test;

class ImmutableCostDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCost#builder()}
   *   <li>{@link ImmutableCost#kind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableCost.Builder actualBuilderResult = ImmutableCost.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableCost.Builder#amount(BigDecimal)}
   */
  @Test
  void testBuilderAmount() {
    // Arrange
    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.amount(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableCost.Builder#costKind(String)}
   */
  @Test
  void testBuilderCostKind() {
    // Arrange
    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKind("Cost Kind"));
  }

  /**
   * Method under test: {@link ImmutableCost.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableCost.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCost.Builder#from(Cost)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
    Cost instance = mock(Cost.class);
    when(instance.costKind()).thenReturn("Cost Kind");
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableCost.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableCost.Builder#from(Cost)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCost.Builder builderResult = ImmutableCost.builder();
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
   * Method under test: {@link ImmutableCost.Builder#year(int)}
   */
  @Test
  void testBuilderYear() {
    // Arrange
    ImmutableCost.Builder builderResult = ImmutableCost.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test: {@link ImmutableCost#copyOf(Cost)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Cost instance = mock(Cost.class);
    when(instance.costKind()).thenReturn("Cost Kind");
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.amount()).thenReturn(bigDecimal);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableCost actualCopyOfResult = ImmutableCost.copyOf(instance);

    // Assert
    verify(instance).amount();
    verify(instance).costKind();
    verify(instance).kind();
    verify(instance).year();
    assertEquals("Cost Kind", actualCopyOfResult.costKind());
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    BigDecimal expectedAmountResult = new BigDecimal("2.3");
    BigDecimal amountResult = actualCopyOfResult.amount();
    assertEquals(expectedAmountResult, amountResult);
    assertSame(bigDecimal, amountResult);
  }

  /**
   * Method under test: {@link ImmutableCost.Json#amount()}
   */
  @Test
  void testJsonAmount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCost.Json()).amount());
  }

  /**
   * Method under test: {@link ImmutableCost.Json#costKind()}
   */
  @Test
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCost.Json()).costKind());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableCost.Json}
   *   <li>{@link ImmutableCost.Json#setAmount(BigDecimal)}
   *   <li>{@link ImmutableCost.Json#setCostKind(String)}
   *   <li>{@link ImmutableCost.Json#setKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableCost.Json actualJson = new ImmutableCost.Json();
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
   * Method under test: {@link ImmutableCost.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCost.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableCost.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear() {
    // Arrange
    ImmutableCost.Json json = new ImmutableCost.Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableCost.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCost.Json()).year());
  }
}
