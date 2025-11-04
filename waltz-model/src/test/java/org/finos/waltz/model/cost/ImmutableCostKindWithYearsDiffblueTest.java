package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableCostKindWithYearsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears.Builder#addAllYears(Iterable)}
   */
  @Test
  void testBuilderAddAllYears() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllYears(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears.Builder#addAllYears(Iterable)}
   */
  @Test
  void testBuilderAddAllYears2() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(2);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllYears(elements));
  }

  /**
   * Method under test: {@link ImmutableCostKindWithYears.Builder#addYears(int)}
   */
  @Test
  void testBuilderAddYears() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addYears(2));
  }

  /**
   * Method under test: {@link ImmutableCostKindWithYears.Builder#addYears(int[])}
   */
  @Test
  void testBuilderAddYears2() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addYears(2, 1, 2, 1));
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears.Builder#costKind(EntityCostKind)}
   */
  @Test
  void testBuilderCostKind() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();

    // Act
    ImmutableCostKindWithYears.Builder actualCostKindResult = builderResult.costKind(costKind);

    // Assert
    assertSame(costKind, builderResult.build().costKind());
    assertSame(builderResult, actualCostKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears.Builder#from(CostKindWithYears)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(new ArrayList<>());
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);

    // Act
    ImmutableCostKindWithYears.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    assertSame(json, builderResult.build().costKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears.Builder#from(CostKindWithYears)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenThrow(new IllegalStateException("instance"));
    when(instance.costKind()).thenReturn(new ImmutableEntityCostKind.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).costKind();
    verify(instance).years();
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears.Builder#from(CostKindWithYears)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(integerList);
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);

    // Act
    ImmutableCostKindWithYears.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    ImmutableCostKindWithYears buildResult = builderResult.build();
    List<Integer> yearsResult = buildResult.years();
    assertEquals(1, yearsResult.size());
    assertEquals(2, yearsResult.get(0).intValue());
    assertSame(json, buildResult.costKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCostKindWithYears.Builder#years(Iterable)}
   */
  @Test
  void testBuilderYears() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.years(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCostKindWithYears.Builder#years(Iterable)}
   */
  @Test
  void testBuilderYears2() {
    // Arrange
    ImmutableCostKindWithYears.Builder builderResult = ImmutableCostKindWithYears.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(1);

    // Act and Assert
    assertSame(builderResult, builderResult.years(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears#copyOf(CostKindWithYears)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(new ArrayList<>());
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);

    // Act
    ImmutableCostKindWithYears actualCopyOfResult = ImmutableCostKindWithYears.copyOf(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    assertTrue(actualCopyOfResult.years().isEmpty());
    assertSame(json, actualCopyOfResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears#copyOf(CostKindWithYears)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(integerList);
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);

    // Act
    ImmutableCostKindWithYears actualCopyOfResult = ImmutableCostKindWithYears.copyOf(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    List<Integer> yearsResult = actualCopyOfResult.years();
    assertEquals(1, yearsResult.size());
    assertEquals(2, yearsResult.get(0).intValue());
    assertSame(json, actualCopyOfResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears#copyOf(CostKindWithYears)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(2);
    CostKindWithYears instance = mock(CostKindWithYears.class);
    when(instance.years()).thenReturn(integerList);
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);

    // Act
    ImmutableCostKindWithYears actualCopyOfResult = ImmutableCostKindWithYears.copyOf(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).years();
    assertEquals(integerList, actualCopyOfResult.years());
    assertSame(json, actualCopyOfResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears#fromJson(ImmutableCostKindWithYears.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableCostKindWithYears.Json json = new ImmutableCostKindWithYears.Json();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();
    json.setCostKind(costKind);
    json.setYears(null);

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.years().isEmpty());
    assertSame(costKind, actualFromJsonResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears#fromJson(ImmutableCostKindWithYears.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<Integer> years = new ArrayList<>();
    years.add(1);

    ImmutableCostKindWithYears.Json json = new ImmutableCostKindWithYears.Json();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();
    json.setCostKind(costKind);
    json.setYears(years);

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    List<Integer> yearsResult = actualFromJsonResult.years();
    assertEquals(1, yearsResult.size());
    assertEquals(1, yearsResult.get(0).intValue());
    assertSame(costKind, actualFromJsonResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableCostKindWithYears#fromJson(ImmutableCostKindWithYears.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Integer> years = new ArrayList<>();
    years.add(2);
    years.add(1);

    ImmutableCostKindWithYears.Json json = new ImmutableCostKindWithYears.Json();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();
    json.setCostKind(costKind);
    json.setYears(years);

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    assertEquals(years, actualFromJsonResult.years());
    assertSame(costKind, actualFromJsonResult.costKind());
  }

  /**
   * Method under test: {@link ImmutableCostKindWithYears.Json#costKind()}
   */
  @Test
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostKindWithYears.Json()).costKind());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableCostKindWithYears.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableCostKindWithYears.Json actualJson = new ImmutableCostKindWithYears.Json();

    // Assert
    assertNull(actualJson.costKind);
    assertTrue(actualJson.years.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableCostKindWithYears.Json#years()}
   */
  @Test
  void testJsonYears() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableCostKindWithYears.Json()).years());
  }
}
