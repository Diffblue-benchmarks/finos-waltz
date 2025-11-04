package org.finos.waltz.model.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareSummaryStatisticsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addAllGroupCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllGroupCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllGroupCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addAllNameCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllNameCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllNameCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addAllVendorCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllVendorCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllVendorCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addGroupCounts(Tally)}
   */
  @Test
  void testBuilderAddGroupCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualAddGroupCountsResult = builderResult.addGroupCounts(element);

    // Assert
    List<Tally<String>> groupCountsResult = builderResult.build().groupCounts();
    assertEquals(1, groupCountsResult.size());
    assertSame(builderResult, actualAddGroupCountsResult);
    assertSame(element, groupCountsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addGroupCounts(Tally[])}
   */
  @Test
  void testBuilderAddGroupCounts2() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualAddGroupCountsResult = builderResult
        .addGroupCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().groupCounts().size());
    assertSame(builderResult, actualAddGroupCountsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addNameCounts(Tally)}
   */
  @Test
  void testBuilderAddNameCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualAddNameCountsResult = builderResult.addNameCounts(element);

    // Assert
    List<Tally<String>> nameCountsResult = builderResult.build().nameCounts();
    assertEquals(1, nameCountsResult.size());
    assertSame(builderResult, actualAddNameCountsResult);
    assertSame(element, nameCountsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addNameCounts(Tally[])}
   */
  @Test
  void testBuilderAddNameCounts2() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualAddNameCountsResult = builderResult
        .addNameCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().nameCounts().size());
    assertSame(builderResult, actualAddNameCountsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addVendorCounts(Tally)}
   */
  @Test
  void testBuilderAddVendorCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualAddVendorCountsResult = builderResult.addVendorCounts(element);

    // Assert
    List<Tally<String>> vendorCountsResult = builderResult.build().vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    assertSame(builderResult, actualAddVendorCountsResult);
    assertSame(element, vendorCountsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#addVendorCounts(Tally[])}
   */
  @Test
  void testBuilderAddVendorCounts2() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualAddVendorCountsResult = builderResult
        .addVendorCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().vendorCounts().size());
    assertSame(builderResult, actualAddVendorCountsResult);
  }

  /**
   * Method under test: {@link ImmutableSoftwareSummaryStatistics.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSoftwareSummaryStatistics.builder().build().groupCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(new ArrayList<>());
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(tallyList);
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertEquals(1, builderResult.build().groupCounts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(new ArrayList<>());
    when(instance.nameCounts()).thenReturn(tallyList);
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertEquals(1, builderResult.build().nameCounts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#from(SoftwareSummaryStatistics)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(new ArrayList<>());
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(tallyList);

    // Act
    ImmutableSoftwareSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertEquals(1, builderResult.build().vendorCounts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#groupCounts(Iterable)}
   */
  @Test
  void testBuilderGroupCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.groupCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#nameCounts(Iterable)}
   */
  @Test
  void testBuilderNameCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.nameCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Builder#vendorCounts(Iterable)}
   */
  @Test
  void testBuilderVendorCounts() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Builder builderResult = ImmutableSoftwareSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vendorCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(new ArrayList<>());
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult = ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    List<Tally<String>> groupCountsResult = actualCopyOfResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCopyOfResult.nameCounts());
    assertSame(groupCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(tallyList);
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult = ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertEquals(1, actualCopyOfResult.groupCounts().size());
    List<Tally<String>> nameCountsResult = actualCopyOfResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertSame(nameCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(tallyList);
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult = ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    List<Tally<String>> nameCountsResult = actualCopyOfResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertEquals(tallyList, actualCopyOfResult.groupCounts());
    assertSame(nameCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(new ArrayList<>());
    when(instance.nameCounts()).thenReturn(tallyList);
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult = ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertEquals(1, actualCopyOfResult.nameCounts().size());
    List<Tally<String>> groupCountsResult = actualCopyOfResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#copyOf(SoftwareSummaryStatistics)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    SoftwareSummaryStatistics instance = mock(SoftwareSummaryStatistics.class);
    when(instance.groupCounts()).thenReturn(new ArrayList<>());
    when(instance.nameCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(tallyList);

    // Act
    ImmutableSoftwareSummaryStatistics actualCopyOfResult = ImmutableSoftwareSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).groupCounts();
    verify(instance).nameCounts();
    verify(instance).vendorCounts();
    assertEquals(1, actualCopyOfResult.vendorCounts().size());
    List<Tally<String>> groupCountsResult = actualCopyOfResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualCopyOfResult.nameCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#fromJson(ImmutableSoftwareSummaryStatistics.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Json json = new ImmutableSoftwareSummaryStatistics.Json();

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> groupCountsResult = actualFromJsonResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    List<Tally<String>> tallyList = json.vendorCounts;
    assertSame(tallyList, groupCountsResult);
    assertSame(tallyList, actualFromJsonResult.nameCounts());
    assertSame(tallyList, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#fromJson(ImmutableSoftwareSummaryStatistics.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSoftwareSummaryStatistics.Json json = new ImmutableSoftwareSummaryStatistics.Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> groupCountsResult = actualFromJsonResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualFromJsonResult.nameCounts());
    assertSame(groupCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#fromJson(ImmutableSoftwareSummaryStatistics.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Tally<String>> nameCounts = new ArrayList<>();
    nameCounts.add(mock(Tally.class));

    ImmutableSoftwareSummaryStatistics.Json json = new ImmutableSoftwareSummaryStatistics.Json();
    json.setVendorCounts(null);
    json.setGroupCounts(null);
    json.setNameCounts(nameCounts);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.nameCounts().size());
    List<Tally<String>> groupCountsResult = actualFromJsonResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#fromJson(ImmutableSoftwareSummaryStatistics.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<Tally<String>> groupCounts = new ArrayList<>();
    groupCounts.add(mock(Tally.class));

    ImmutableSoftwareSummaryStatistics.Json json = new ImmutableSoftwareSummaryStatistics.Json();
    json.setVendorCounts(null);
    json.setGroupCounts(groupCounts);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.groupCounts().size());
    List<Tally<String>> nameCountsResult = actualFromJsonResult.nameCounts();
    assertTrue(nameCountsResult.isEmpty());
    assertSame(nameCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics#fromJson(ImmutableSoftwareSummaryStatistics.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<Tally<String>> vendorCounts = new ArrayList<>();
    vendorCounts.add(mock(Tally.class));

    ImmutableSoftwareSummaryStatistics.Json json = new ImmutableSoftwareSummaryStatistics.Json();
    json.setVendorCounts(vendorCounts);
    json.setGroupCounts(null);
    json.setNameCounts(null);

    // Act
    ImmutableSoftwareSummaryStatistics actualFromJsonResult = ImmutableSoftwareSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.vendorCounts().size());
    List<Tally<String>> groupCountsResult = actualFromJsonResult.groupCounts();
    assertTrue(groupCountsResult.isEmpty());
    assertSame(groupCountsResult, actualFromJsonResult.nameCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Json#groupCounts()}
   */
  @Test
  void testJsonGroupCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSoftwareSummaryStatistics.Json()).groupCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Json#nameCounts()}
   */
  @Test
  void testJsonNameCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSoftwareSummaryStatistics.Json()).nameCounts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSoftwareSummaryStatistics.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSoftwareSummaryStatistics.Json actualJson = new ImmutableSoftwareSummaryStatistics.Json();

    // Assert
    assertTrue(actualJson.groupCounts.isEmpty());
    assertTrue(actualJson.nameCounts.isEmpty());
    assertTrue(actualJson.vendorCounts.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSoftwareSummaryStatistics.Json#vendorCounts()}
   */
  @Test
  void testJsonVendorCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSoftwareSummaryStatistics.Json()).vendorCounts());
  }
}
