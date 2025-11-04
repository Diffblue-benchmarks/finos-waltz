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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableEntityCostsSummaryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#addAllTopCosts(Iterable)}
   */
  @Test
  void testBuilderAddAllTopCosts() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTopCosts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#addTopCosts(EntityCost)}
   */
  @Test
  void testBuilderAddTopCosts() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopCosts(new ImmutableEntityCost.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#addTopCosts(EntityCost)}
   */
  @Test
  void testBuilderAddTopCosts2() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    ImmutableEntityCost.Json element = new ImmutableEntityCost.Json();
    element.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addTopCosts(element));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#addTopCosts(EntityCost[])}
   */
  @Test
  void testBuilderAddTopCosts3() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTopCosts(new ImmutableEntityCost.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#addTopCosts(EntityCost[])}
   */
  @Test
  void testBuilderAddTopCosts4() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    ImmutableEntityCost.Json json = new ImmutableEntityCost.Json();
    json.setEntityReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addTopCosts(json));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#costKind(EntityCostKind)}
   */
  @Test
  void testBuilderCostKind() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKind(new ImmutableEntityCostKind.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#costKind(EntityCostKind)}
   */
  @Test
  void testBuilderCostKind2() {
    // Arrange
    ImmutableEntityCost.Json element = new ImmutableEntityCost.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    builderResult.addTopCosts(element);

    // Act and Assert
    assertSame(builderResult, builderResult.costKind(new ImmutableEntityCostKind.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#from(EntityCostsSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(new ArrayList<>());
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);

    // Act
    ImmutableEntityCostsSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    ImmutableEntityCostsSummary buildResult = builderResult.build();
    assertEquals(1, buildResult.year());
    assertEquals(3, buildResult.mappedCount());
    assertEquals(3, buildResult.missingCount());
    assertSame(bigDecimal, buildResult.total());
    assertSame(json, buildResult.costKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#from(EntityCostsSummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenThrow(new IllegalStateException("instance"));
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    when(instance.total()).thenReturn(new BigDecimal("2.3"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#from(EntityCostsSummary)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    ArrayList<EntityCost> entityCostList = new ArrayList<>();
    ImmutableEntityCost.Json json = new ImmutableEntityCost.Json();
    entityCostList.add(json);
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(entityCostList);
    ImmutableEntityCostKind.Json json2 = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json2);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);

    // Act
    ImmutableEntityCostsSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    ImmutableEntityCostsSummary buildResult = builderResult.build();
    List<EntityCost> topCostsResult = buildResult.topCosts();
    assertEquals(1, topCostsResult.size());
    assertEquals(1, buildResult.year());
    assertEquals(3, buildResult.mappedCount());
    assertEquals(3, buildResult.missingCount());
    assertSame(bigDecimal, buildResult.total());
    assertSame(json, topCostsResult.get(0));
    assertSame(json2, buildResult.costKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#mappedCount(int)}
   */
  @Test
  void testBuilderMappedCount() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.mappedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#mappedCount(int)}
   */
  @Test
  void testBuilderMappedCount2() {
    // Arrange
    ImmutableEntityCost.Json element = new ImmutableEntityCost.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    builderResult.addTopCosts(element);

    // Act and Assert
    assertSame(builderResult, builderResult.mappedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#missingCount(int)}
   */
  @Test
  void testBuilderMissingCount() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.missingCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#missingCount(int)}
   */
  @Test
  void testBuilderMissingCount2() {
    // Arrange
    ImmutableEntityCost.Json element = new ImmutableEntityCost.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    builderResult.addTopCosts(element);

    // Act and Assert
    assertSame(builderResult, builderResult.missingCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#topCosts(Iterable)}
   */
  @Test
  void testBuilderTopCosts() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.topCosts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#total(BigDecimal)}
   */
  @Test
  void testBuilderTotal() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Builder#total(BigDecimal)}
   */
  @Test
  void testBuilderTotal2() {
    // Arrange
    ImmutableEntityCost.Json element = new ImmutableEntityCost.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    builderResult.addTopCosts(element);

    // Act and Assert
    assertSame(builderResult, builderResult.total(new BigDecimal("2.3")));
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Builder#year(int)}
   */
  @Test
  void testBuilderYear() {
    // Arrange
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Builder#year(int)}
   */
  @Test
  void testBuilderYear2() {
    // Arrange
    ImmutableEntityCost.Json element = new ImmutableEntityCost.Json();
    element.setEntityReference(mock(EntityReference.class));
    ImmutableEntityCostsSummary.Builder builderResult = ImmutableEntityCostsSummary.builder();
    builderResult.addTopCosts(element);

    // Act and Assert
    assertSame(builderResult, builderResult.year(1));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary#copyOf(EntityCostsSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(new ArrayList<>());
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);

    // Act
    ImmutableEntityCostsSummary actualCopyOfResult = ImmutableEntityCostsSummary.copyOf(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    assertTrue(actualCopyOfResult.topCosts().isEmpty());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertSame(bigDecimal, totalResult);
    assertSame(json, actualCopyOfResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary#copyOf(EntityCostsSummary)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<EntityCost> entityCostList = new ArrayList<>();
    entityCostList.add(new ImmutableEntityCost.Json());
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(entityCostList);
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);

    // Act
    ImmutableEntityCostsSummary actualCopyOfResult = ImmutableEntityCostsSummary.copyOf(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertEquals(entityCostList, actualCopyOfResult.topCosts());
    assertSame(bigDecimal, totalResult);
    assertSame(json, actualCopyOfResult.costKind());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary#copyOf(EntityCostsSummary)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<EntityCost> entityCostList = new ArrayList<>();
    entityCostList.add(new ImmutableEntityCost.Json());
    entityCostList.add(new ImmutableEntityCost.Json());
    EntityCostsSummary instance = mock(EntityCostsSummary.class);
    when(instance.topCosts()).thenReturn(entityCostList);
    ImmutableEntityCostKind.Json json = new ImmutableEntityCostKind.Json();
    when(instance.costKind()).thenReturn(json);
    when(instance.mappedCount()).thenReturn(3);
    when(instance.missingCount()).thenReturn(3);
    when(instance.year()).thenReturn(1);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.total()).thenReturn(bigDecimal);

    // Act
    ImmutableEntityCostsSummary actualCopyOfResult = ImmutableEntityCostsSummary.copyOf(instance);

    // Assert
    verify(instance).costKind();
    verify(instance).mappedCount();
    verify(instance).missingCount();
    verify(instance).topCosts();
    verify(instance).total();
    verify(instance).year();
    assertEquals(1, actualCopyOfResult.year());
    assertEquals(3, actualCopyOfResult.mappedCount());
    assertEquals(3, actualCopyOfResult.missingCount());
    BigDecimal expectedTotalResult = new BigDecimal("2.3");
    BigDecimal totalResult = actualCopyOfResult.total();
    assertEquals(expectedTotalResult, totalResult);
    assertEquals(entityCostList, actualCopyOfResult.topCosts());
    assertSame(bigDecimal, totalResult);
    assertSame(json, actualCopyOfResult.costKind());
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#costKind()}
   */
  @Test
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostsSummary.Json()).costKind());
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#mappedCount()}
   */
  @Test
  void testJsonMappedCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostsSummary.Json()).mappedCount());
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#missingCount()}
   */
  @Test
  void testJsonMissingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostsSummary.Json()).missingCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityCostsSummary.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityCostsSummary.Json actualJson = new ImmutableEntityCostsSummary.Json();

    // Assert
    assertNull(actualJson.total);
    assertNull(actualJson.costKind);
    assertEquals(0, actualJson.mappedCount);
    assertEquals(0, actualJson.missingCount);
    assertEquals(0, actualJson.year);
    assertFalse(actualJson.mappedCountIsSet);
    assertFalse(actualJson.missingCountIsSet);
    assertFalse(actualJson.yearIsSet);
    assertTrue(actualJson.topCosts.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Json#setMappedCount(int)}
   */
  @Test
  void testJsonSetMappedCount() {
    // Arrange
    ImmutableEntityCostsSummary.Json json = new ImmutableEntityCostsSummary.Json();

    // Act
    json.setMappedCount(3);

    // Assert
    assertEquals(3, json.mappedCount);
    assertTrue(json.mappedCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityCostsSummary.Json#setMissingCount(int)}
   */
  @Test
  void testJsonSetMissingCount() {
    // Arrange
    ImmutableEntityCostsSummary.Json json = new ImmutableEntityCostsSummary.Json();

    // Act
    json.setMissingCount(3);

    // Assert
    assertEquals(3, json.missingCount);
    assertTrue(json.missingCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#setYear(int)}
   */
  @Test
  void testJsonSetYear() {
    // Arrange
    ImmutableEntityCostsSummary.Json json = new ImmutableEntityCostsSummary.Json();

    // Act
    json.setYear(1);

    // Assert
    assertEquals(1, json.year);
    assertTrue(json.yearIsSet);
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#topCosts()}
   */
  @Test
  void testJsonTopCosts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostsSummary.Json()).topCosts());
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#total()}
   */
  @Test
  void testJsonTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostsSummary.Json()).total());
  }

  /**
   * Method under test: {@link ImmutableEntityCostsSummary.Json#year()}
   */
  @Test
  void testJsonYear() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityCostsSummary.Json()).year());
  }
}
