package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableDateChangeInformationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#addAllChanges(Iterable)}
   */
  @Test
  void testBuilderAddAllChanges() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChanges(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#addChanges(AppChangeEntry)}
   */
  @Test
  void testBuilderAddChanges() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#addChanges(AppChangeEntry)}
   */
  @Test
  void testBuilderAddChanges2() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    ImmutableAppChangeEntry.Json element = new ImmutableAppChangeEntry.Json();
    element.setAppRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(element));
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#addChanges(AppChangeEntry[])}
   */
  @Test
  void testBuilderAddChanges3() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(new ImmutableAppChangeEntry.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#addChanges(AppChangeEntry[])}
   */
  @Test
  void testBuilderAddChanges4() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    ImmutableAppChangeEntry.Json json = new ImmutableAppChangeEntry.Json();
    json.setAppRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addChanges(json));
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#changes(Iterable)}
   */
  @Test
  void testBuilderChanges() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changes(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#from(DateChangeInformation)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(new HashSet<>());
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();
    when(instance.quarter()).thenReturn(json);

    // Act
    ImmutableDateChangeInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    ImmutableDateChangeInformation buildResult = builderResult.build();
    assertEquals(0, buildResult.count());
    assertSame(json, buildResult.quarter());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#from(DateChangeInformation)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenThrow(new IllegalStateException("instance"));
    when(instance.quarter()).thenReturn(new ImmutableQuarterDetail.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).changes();
    verify(instance).quarter();
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#from(DateChangeInformation)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();

    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(appChangeEntrySet);
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();
    when(instance.quarter()).thenReturn(json);

    // Act
    ImmutableDateChangeInformation.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    ImmutableDateChangeInformation buildResult = builderResult.build();
    assertEquals(1, buildResult.changes().size());
    assertEquals(1, buildResult.count());
    assertSame(json, buildResult.quarter());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#quarter(QuarterDetail)}
   */
  @Test
  void testBuilderQuarter() {
    // Arrange
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();

    // Act
    ImmutableDateChangeInformation.Builder actualQuarterResult = builderResult.quarter(quarter);

    // Assert
    ImmutableDateChangeInformation buildResult = builderResult.build();
    assertEquals(0, buildResult.count());
    assertSame(quarter, buildResult.quarter());
    assertSame(builderResult, actualQuarterResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation.Builder#quarter(QuarterDetail)}
   */
  @Test
  void testBuilderQuarter2() {
    // Arrange
    ImmutableAppChangeEntry.Json element = new ImmutableAppChangeEntry.Json();
    element.setAppRef(mock(EntityReference.class));
    ImmutableDateChangeInformation.Builder builderResult = ImmutableDateChangeInformation.builder();
    builderResult.addChanges(element);
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();

    // Act
    ImmutableDateChangeInformation.Builder actualQuarterResult = builderResult.quarter(quarter);

    // Assert
    ImmutableDateChangeInformation buildResult = builderResult.build();
    assertEquals(1, buildResult.changes().size());
    assertEquals(1, buildResult.count());
    assertSame(quarter, buildResult.quarter());
    assertSame(builderResult, actualQuarterResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation#copyOf(DateChangeInformation)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(new HashSet<>());
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();
    when(instance.quarter()).thenReturn(json);

    // Act
    ImmutableDateChangeInformation actualCopyOfResult = ImmutableDateChangeInformation.copyOf(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    assertEquals(0, actualCopyOfResult.count());
    assertTrue(actualCopyOfResult.changes().isEmpty());
    assertSame(json, actualCopyOfResult.quarter());
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation#copyOf(DateChangeInformation)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(appChangeEntrySet);
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();
    when(instance.quarter()).thenReturn(json);

    // Act
    ImmutableDateChangeInformation actualCopyOfResult = ImmutableDateChangeInformation.copyOf(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    assertEquals(1, actualCopyOfResult.changes().size());
    assertEquals(1, actualCopyOfResult.count());
    assertSame(json, actualCopyOfResult.quarter());
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation#copyOf(DateChangeInformation)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<AppChangeEntry> appChangeEntrySet = new HashSet<>();
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    appChangeEntrySet.add(new ImmutableAppChangeEntry.Json());
    DateChangeInformation instance = mock(DateChangeInformation.class);
    when(instance.changes()).thenReturn(appChangeEntrySet);
    ImmutableQuarterDetail.Json json = new ImmutableQuarterDetail.Json();
    when(instance.quarter()).thenReturn(json);

    // Act
    ImmutableDateChangeInformation actualCopyOfResult = ImmutableDateChangeInformation.copyOf(instance);

    // Assert
    verify(instance).changes();
    verify(instance).quarter();
    assertEquals(2, actualCopyOfResult.count());
    assertEquals(appChangeEntrySet, actualCopyOfResult.changes());
    assertSame(json, actualCopyOfResult.quarter());
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation#fromJson(ImmutableDateChangeInformation.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDateChangeInformation.Json json = new ImmutableDateChangeInformation.Json();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();
    json.setQuarter(quarter);
    json.setChanges(null);

    // Act
    ImmutableDateChangeInformation actualFromJsonResult = ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(0, actualFromJsonResult.count());
    assertTrue(actualFromJsonResult.changes().isEmpty());
    assertSame(quarter, actualFromJsonResult.quarter());
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation#fromJson(ImmutableDateChangeInformation.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<AppChangeEntry> changes = new LinkedHashSet<>();
    changes.add(new ImmutableAppChangeEntry.Json());

    ImmutableDateChangeInformation.Json json = new ImmutableDateChangeInformation.Json();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();
    json.setQuarter(quarter);
    json.setChanges(changes);

    // Act
    ImmutableDateChangeInformation actualFromJsonResult = ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.changes().size());
    assertEquals(1, actualFromJsonResult.count());
    assertSame(quarter, actualFromJsonResult.quarter());
  }

  /**
   * Method under test:
   * {@link ImmutableDateChangeInformation#fromJson(ImmutableDateChangeInformation.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<AppChangeEntry> changes = new LinkedHashSet<>();
    changes.add(new ImmutableAppChangeEntry.Json());
    changes.add(new ImmutableAppChangeEntry.Json());

    ImmutableDateChangeInformation.Json json = new ImmutableDateChangeInformation.Json();
    ImmutableQuarterDetail.Json quarter = new ImmutableQuarterDetail.Json();
    json.setQuarter(quarter);
    json.setChanges(changes);

    // Act
    ImmutableDateChangeInformation actualFromJsonResult = ImmutableDateChangeInformation.fromJson(json);

    // Assert
    assertEquals(2, actualFromJsonResult.count());
    assertEquals(changes, actualFromJsonResult.changes());
    assertSame(quarter, actualFromJsonResult.quarter());
  }

  /**
   * Method under test: {@link ImmutableDateChangeInformation.Json#changes()}
   */
  @Test
  void testJsonChanges() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateChangeInformation.Json()).changes());
  }

  /**
   * Method under test: {@link ImmutableDateChangeInformation.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateChangeInformation.Json()).count());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDateChangeInformation.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDateChangeInformation.Json actualJson = new ImmutableDateChangeInformation.Json();

    // Assert
    assertNull(actualJson.quarter);
    assertTrue(actualJson.changes.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableDateChangeInformation.Json#quarter()}
   */
  @Test
  void testJsonQuarter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateChangeInformation.Json()).quarter());
  }
}
