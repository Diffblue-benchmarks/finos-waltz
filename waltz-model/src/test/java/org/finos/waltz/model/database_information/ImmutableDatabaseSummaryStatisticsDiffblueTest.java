package org.finos.waltz.model.database_information;

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

class ImmutableDatabaseSummaryStatisticsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addAllEndOfLifeStatusCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllEndOfLifeStatusCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEndOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addAllEnvironmentCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllEnvironmentCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllEnvironmentCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addAllVendorCounts(Iterable)}
   */
  @Test
  void testBuilderAddAllVendorCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllVendorCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addEndOfLifeStatusCounts(Tally)}
   */
  @Test
  void testBuilderAddEndOfLifeStatusCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualAddEndOfLifeStatusCountsResult = builderResult
        .addEndOfLifeStatusCounts(element);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = builderResult.build().endOfLifeStatusCounts();
    assertEquals(1, endOfLifeStatusCountsResult.size());
    assertSame(builderResult, actualAddEndOfLifeStatusCountsResult);
    assertSame(element, endOfLifeStatusCountsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addEndOfLifeStatusCounts(Tally[])}
   */
  @Test
  void testBuilderAddEndOfLifeStatusCounts2() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualAddEndOfLifeStatusCountsResult = builderResult
        .addEndOfLifeStatusCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().endOfLifeStatusCounts().size());
    assertSame(builderResult, actualAddEndOfLifeStatusCountsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addEnvironmentCounts(Tally)}
   */
  @Test
  void testBuilderAddEnvironmentCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualAddEnvironmentCountsResult = builderResult
        .addEnvironmentCounts(element);

    // Assert
    List<Tally<String>> environmentCountsResult = builderResult.build().environmentCounts();
    assertEquals(1, environmentCountsResult.size());
    assertSame(builderResult, actualAddEnvironmentCountsResult);
    assertSame(element, environmentCountsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addEnvironmentCounts(Tally[])}
   */
  @Test
  void testBuilderAddEnvironmentCounts2() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualAddEnvironmentCountsResult = builderResult
        .addEnvironmentCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().environmentCounts().size());
    assertSame(builderResult, actualAddEnvironmentCountsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addVendorCounts(Tally)}
   */
  @Test
  void testBuilderAddVendorCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
    Tally<String> element = mock(Tally.class);

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualAddVendorCountsResult = builderResult.addVendorCounts(element);

    // Assert
    List<Tally<String>> vendorCountsResult = builderResult.build().vendorCounts();
    assertEquals(1, vendorCountsResult.size());
    assertSame(builderResult, actualAddVendorCountsResult);
    assertSame(element, vendorCountsResult.get(0));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#addVendorCounts(Tally[])}
   */
  @Test
  void testBuilderAddVendorCounts2() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualAddVendorCountsResult = builderResult
        .addVendorCounts(mock(Tally.class));

    // Assert
    assertEquals(1, builderResult.build().vendorCounts().size());
    assertSame(builderResult, actualAddVendorCountsResult);
  }

  /**
   * Method under test: {@link ImmutableDatabaseSummaryStatistics.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableDatabaseSummaryStatistics.builder().build().endOfLifeStatusCounts().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#endOfLifeStatusCounts(Iterable)}
   */
  @Test
  void testBuilderEndOfLifeStatusCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endOfLifeStatusCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#environmentCounts(Iterable)}
   */
  @Test
  void testBuilderEnvironmentCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.environmentCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertEquals(1, builderResult.build().endOfLifeStatusCounts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.environmentCounts()).thenReturn(tallyList);
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertEquals(1, builderResult.build().environmentCounts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#from(DatabaseSummaryStatistics)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(tallyList);

    // Act
    ImmutableDatabaseSummaryStatistics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertEquals(1, builderResult.build().vendorCounts().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Builder#vendorCounts(Iterable)}
   */
  @Test
  void testBuilderVendorCounts() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Builder builderResult = ImmutableDatabaseSummaryStatistics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.vendorCounts(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics actualCopyOfResult = ImmutableDatabaseSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    List<Tally<String>> endOfLifeStatusCountsResult = actualCopyOfResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualCopyOfResult.environmentCounts());
    assertSame(endOfLifeStatusCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics actualCopyOfResult = ImmutableDatabaseSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertEquals(1, actualCopyOfResult.endOfLifeStatusCounts().size());
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(tallyList);
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics actualCopyOfResult = ImmutableDatabaseSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    List<Tally<String>> environmentCountsResult = actualCopyOfResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertEquals(tallyList, actualCopyOfResult.endOfLifeStatusCounts());
    assertSame(environmentCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.environmentCounts()).thenReturn(tallyList);
    when(instance.vendorCounts()).thenReturn(new ArrayList<>());

    // Act
    ImmutableDatabaseSummaryStatistics actualCopyOfResult = ImmutableDatabaseSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertEquals(1, actualCopyOfResult.environmentCounts().size());
    List<Tally<String>> endOfLifeStatusCountsResult = actualCopyOfResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualCopyOfResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#copyOf(DatabaseSummaryStatistics)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(mock(Tally.class));
    DatabaseSummaryStatistics instance = mock(DatabaseSummaryStatistics.class);
    when(instance.endOfLifeStatusCounts()).thenReturn(new ArrayList<>());
    when(instance.environmentCounts()).thenReturn(new ArrayList<>());
    when(instance.vendorCounts()).thenReturn(tallyList);

    // Act
    ImmutableDatabaseSummaryStatistics actualCopyOfResult = ImmutableDatabaseSummaryStatistics.copyOf(instance);

    // Assert
    verify(instance).endOfLifeStatusCounts();
    verify(instance).environmentCounts();
    verify(instance).vendorCounts();
    assertEquals(1, actualCopyOfResult.vendorCounts().size());
    List<Tally<String>> endOfLifeStatusCountsResult = actualCopyOfResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualCopyOfResult.environmentCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#fromJson(ImmutableDatabaseSummaryStatistics.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Json json = new ImmutableDatabaseSummaryStatistics.Json();

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult = ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = actualFromJsonResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    List<Tally<String>> tallyList = json.vendorCounts;
    assertSame(tallyList, endOfLifeStatusCountsResult);
    assertSame(tallyList, actualFromJsonResult.environmentCounts());
    assertSame(tallyList, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#fromJson(ImmutableDatabaseSummaryStatistics.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableDatabaseSummaryStatistics.Json json = new ImmutableDatabaseSummaryStatistics.Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(null);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult = ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    List<Tally<String>> endOfLifeStatusCountsResult = actualFromJsonResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualFromJsonResult.environmentCounts());
    assertSame(endOfLifeStatusCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#fromJson(ImmutableDatabaseSummaryStatistics.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Tally<String>> endOfLifeStatusCounts = new ArrayList<>();
    endOfLifeStatusCounts.add(mock(Tally.class));

    ImmutableDatabaseSummaryStatistics.Json json = new ImmutableDatabaseSummaryStatistics.Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(endOfLifeStatusCounts);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult = ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.endOfLifeStatusCounts().size());
    List<Tally<String>> environmentCountsResult = actualFromJsonResult.environmentCounts();
    assertTrue(environmentCountsResult.isEmpty());
    assertSame(environmentCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#fromJson(ImmutableDatabaseSummaryStatistics.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<Tally<String>> vendorCounts = new ArrayList<>();
    vendorCounts.add(mock(Tally.class));

    ImmutableDatabaseSummaryStatistics.Json json = new ImmutableDatabaseSummaryStatistics.Json();
    json.setEnvironmentCounts(null);
    json.setVendorCounts(vendorCounts);
    json.setEndOfLifeStatusCounts(null);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult = ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.vendorCounts().size());
    List<Tally<String>> endOfLifeStatusCountsResult = actualFromJsonResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualFromJsonResult.environmentCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics#fromJson(ImmutableDatabaseSummaryStatistics.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<Tally<String>> environmentCounts = new ArrayList<>();
    environmentCounts.add(mock(Tally.class));

    ImmutableDatabaseSummaryStatistics.Json json = new ImmutableDatabaseSummaryStatistics.Json();
    json.setEnvironmentCounts(environmentCounts);
    json.setVendorCounts(null);
    json.setEndOfLifeStatusCounts(null);

    // Act
    ImmutableDatabaseSummaryStatistics actualFromJsonResult = ImmutableDatabaseSummaryStatistics.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.environmentCounts().size());
    List<Tally<String>> endOfLifeStatusCountsResult = actualFromJsonResult.endOfLifeStatusCounts();
    assertTrue(endOfLifeStatusCountsResult.isEmpty());
    assertSame(endOfLifeStatusCountsResult, actualFromJsonResult.vendorCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Json#endOfLifeStatusCounts()}
   */
  @Test
  void testJsonEndOfLifeStatusCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDatabaseSummaryStatistics.Json()).endOfLifeStatusCounts());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Json#environmentCounts()}
   */
  @Test
  void testJsonEnvironmentCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDatabaseSummaryStatistics.Json()).environmentCounts());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableDatabaseSummaryStatistics.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableDatabaseSummaryStatistics.Json actualJson = new ImmutableDatabaseSummaryStatistics.Json();

    // Assert
    assertTrue(actualJson.endOfLifeStatusCounts.isEmpty());
    assertTrue(actualJson.environmentCounts.isEmpty());
    assertTrue(actualJson.vendorCounts.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableDatabaseSummaryStatistics.Json#vendorCounts()}
   */
  @Test
  void testJsonVendorCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDatabaseSummaryStatistics.Json()).vendorCounts());
  }
}
