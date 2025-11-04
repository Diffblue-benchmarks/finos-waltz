package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupBulkAddRequestDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationIds() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationIds2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddAllApplicationIdsResult = builderResult
        .addAllApplicationIds(elements);

    // Assert
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddAllApplicationIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addAllChangeInitiativeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllChangeInitiativeIds() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiativeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addAllChangeInitiativeIds(Iterable)}
   */
  @Test
  void testBuilderAddAllChangeInitiativeIds2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddAllChangeInitiativeIdsResult = builderResult
        .addAllChangeInitiativeIds(elements);

    // Assert
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddAllChangeInitiativeIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addAllUnknownIdentifiers(Iterable)}
   */
  @Test
  void testBuilderAddAllUnknownIdentifiers() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUnknownIdentifiers(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addAllUnknownIdentifiers(Iterable)}
   */
  @Test
  void testBuilderAddAllUnknownIdentifiers2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddAllUnknownIdentifiersResult = builderResult
        .addAllUnknownIdentifiers(elements);

    // Assert
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualAddAllUnknownIdentifiersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addApplicationIds(long)}
   */
  @Test
  void testBuilderAddApplicationIds() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddApplicationIdsResult = builderResult.addApplicationIds(1L);

    // Assert
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddApplicationIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addApplicationIds(long[])}
   */
  @Test
  void testBuilderAddApplicationIds2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddApplicationIdsResult = builderResult.addApplicationIds(1L, -1L, 1L,
        -1L);

    // Assert
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(4, applicationIdsResult.size());
    assertEquals(-1L, applicationIdsResult.get(1).longValue());
    assertEquals(-1L, applicationIdsResult.get(3).longValue());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult.get(2).longValue());
    assertSame(builderResult, actualAddApplicationIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addChangeInitiativeIds(long)}
   */
  @Test
  void testBuilderAddChangeInitiativeIds() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddChangeInitiativeIdsResult = builderResult
        .addChangeInitiativeIds(1L);

    // Assert
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddChangeInitiativeIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addChangeInitiativeIds(long[])}
   */
  @Test
  void testBuilderAddChangeInitiativeIds2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddChangeInitiativeIdsResult = builderResult
        .addChangeInitiativeIds(1L, -1L, 1L, -1L);

    // Assert
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(4, changeInitiativeIdsResult.size());
    assertEquals(-1L, changeInitiativeIdsResult.get(1).longValue());
    assertEquals(-1L, changeInitiativeIdsResult.get(3).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(2).longValue());
    assertSame(builderResult, actualAddChangeInitiativeIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addUnknownIdentifiers(String)}
   */
  @Test
  void testBuilderAddUnknownIdentifiers() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddUnknownIdentifiersResult = builderResult
        .addUnknownIdentifiers("Element");

    // Assert
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Element", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualAddUnknownIdentifiersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#addUnknownIdentifiers(String[])}
   */
  @Test
  void testBuilderAddUnknownIdentifiers2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualAddUnknownIdentifiersResult = builderResult
        .addUnknownIdentifiers("Elements");

    // Assert
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualAddUnknownIdentifiersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#applicationIds(Iterable)}
   */
  @Test
  void testBuilderApplicationIds() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#applicationIds(Iterable)}
   */
  @Test
  void testBuilderApplicationIds2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualApplicationIdsResult = builderResult.applicationIds(elements);

    // Assert
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertSame(builderResult, actualApplicationIdsResult);
  }

  /**
   * Method under test: {@link ImmutableAppGroupBulkAddRequest.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAppGroupBulkAddRequest.builder().build().applicationIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#changeInitiativeIds(Iterable)}
   */
  @Test
  void testBuilderChangeInitiativeIds() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiativeIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#changeInitiativeIds(Iterable)}
   */
  @Test
  void testBuilderChangeInitiativeIds2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualChangeInitiativeIdsResult = builderResult
        .changeInitiativeIds(elements);

    // Assert
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertSame(builderResult, actualChangeInitiativeIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(new ArrayList<>());
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(resultLongList);
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(new ArrayList<>());
    when(instance.changeInitiativeIds()).thenReturn(resultLongList);
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(new ArrayList<>());
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(stringList);

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("instance", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#unknownIdentifiers(Iterable)}
   */
  @Test
  void testBuilderUnknownIdentifiers() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.unknownIdentifiers(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Builder#unknownIdentifiers(Iterable)}
   */
  @Test
  void testBuilderUnknownIdentifiers2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableAppGroupBulkAddRequest.Builder actualUnknownIdentifiersResult = builderResult.unknownIdentifiers(elements);

    // Assert
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualUnknownIdentifiersResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(new ArrayList<>());
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult = ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualCopyOfResult.changeInitiativeIds());
    assertSame(applicationIdsResult, actualCopyOfResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(resultLongList);
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult = ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    List<Long> changeInitiativeIdsResult = actualCopyOfResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, actualCopyOfResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(0L);
    resultLongList.add(1L);
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(resultLongList);
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult = ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<Long> changeInitiativeIdsResult = actualCopyOfResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertEquals(resultLongList, actualCopyOfResult.applicationIds());
    assertSame(changeInitiativeIdsResult, actualCopyOfResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(new ArrayList<>());
    when(instance.changeInitiativeIds()).thenReturn(resultLongList);
    when(instance.unknownIdentifiers()).thenReturn(new ArrayList<>());

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult = ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<Long> changeInitiativeIdsResult = actualCopyOfResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    List<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualCopyOfResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("instance");
    AppGroupBulkAddRequest instance = mock(AppGroupBulkAddRequest.class);
    when(instance.applicationIds()).thenReturn(new ArrayList<>());
    when(instance.changeInitiativeIds()).thenReturn(new ArrayList<>());
    when(instance.unknownIdentifiers()).thenReturn(stringList);

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult = ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).changeInitiativeIds();
    verify(instance).unknownIdentifiers();
    List<String> unknownIdentifiersResult = actualCopyOfResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("instance", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualCopyOfResult.changeInitiativeIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    List<String> stringList = json.unknownIdentifiers;
    assertSame(stringList, applicationIdsResult);
    assertSame(stringList, actualFromJsonResult.changeInitiativeIds());
    assertSame(stringList, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualFromJsonResult.changeInitiativeIds());
    assertSame(applicationIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("Json");

    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> unknownIdentifiersResult = actualFromJsonResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Json", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualFromJsonResult.changeInitiativeIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    COWArrayList<Long> applicationIds = mock(COWArrayList.class);

    ArrayList<Long> resultLongList = new ArrayList<>();
    when(applicationIds.iterator()).thenReturn(resultLongList.iterator());

    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    verify(applicationIds).iterator();
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualFromJsonResult.changeInitiativeIds());
    assertSame(applicationIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest#fromJson(ImmutableAppGroupBulkAddRequest.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-1L);
    resultLongList.add(1L);
    COWArrayList<Long> applicationIds = mock(COWArrayList.class);
    when(applicationIds.iterator()).thenReturn(resultLongList.iterator());
    COWArrayList<Long> changeInitiativeIds = mock(COWArrayList.class);

    ArrayList<Long> resultLongList2 = new ArrayList<>();
    when(changeInitiativeIds.iterator()).thenReturn(resultLongList2.iterator());
    COWArrayList<String> unknownIdentifiers = mock(COWArrayList.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(unknownIdentifiers.iterator()).thenReturn(stringList.iterator());

    ImmutableAppGroupBulkAddRequest.Json json = new ImmutableAppGroupBulkAddRequest.Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    verify(applicationIds).iterator();
    verify(changeInitiativeIds).iterator();
    verify(unknownIdentifiers).iterator();
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertEquals(resultLongList, actualFromJsonResult.applicationIds());
    assertSame(changeInitiativeIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Json#applicationIds()}
   */
  @Test
  void testJsonApplicationIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppGroupBulkAddRequest.Json()).applicationIds());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Json#changeInitiativeIds()}
   */
  @Test
  void testJsonChangeInitiativeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppGroupBulkAddRequest.Json()).changeInitiativeIds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppGroupBulkAddRequest.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppGroupBulkAddRequest.Json actualJson = new ImmutableAppGroupBulkAddRequest.Json();

    // Assert
    assertTrue(actualJson.applicationIds.isEmpty());
    assertTrue(actualJson.changeInitiativeIds.isEmpty());
    assertTrue(actualJson.unknownIdentifiers.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppGroupBulkAddRequest.Json#unknownIdentifiers()}
   */
  @Test
  void testJsonUnknownIdentifiers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppGroupBulkAddRequest.Json()).unknownIdentifiers());
  }
}
