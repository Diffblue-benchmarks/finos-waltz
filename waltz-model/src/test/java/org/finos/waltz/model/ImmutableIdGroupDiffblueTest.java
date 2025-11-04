package org.finos.waltz.model;

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

class ImmutableIdGroupDiffblueTest {
  /**
   * Method under test: {@link ImmutableIdGroup.Builder#addAllValues(Iterable)}
   */
  @Test
  void testBuilderAddAllValues() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValues(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#addAllValues(Iterable)}
   */
  @Test
  void testBuilderAddAllValues2() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValues(elements));
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#addValues(long)}
   */
  @Test
  void testBuilderAddValues() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(1L));
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#addValues(long[])}
   */
  @Test
  void testBuilderAddValues2() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#from(IdGroup)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(new ArrayList<>());
    when(instance.key()).thenReturn(1L);

    // Act
    ImmutableIdGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertEquals(1L, builderResult.build().key().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#from(IdGroup)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn(1L);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).values();
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#from(IdGroup)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-2L);
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(resultLongList);
    when(instance.key()).thenReturn(1L);

    // Act
    ImmutableIdGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    ImmutableIdGroup buildResult = builderResult.build();
    List<Long> valuesResult = buildResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals(-2L, valuesResult.get(0).longValue());
    assertEquals(1L, buildResult.key().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#key(Long)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    // Act
    ImmutableIdGroup.Builder actualKeyResult = builderResult.key(1L);

    // Assert
    assertEquals(1L, builderResult.build().key().longValue());
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#values(Iterable)}
   */
  @Test
  void testBuilderValues() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.values(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Builder#values(Iterable)}
   */
  @Test
  void testBuilderValues2() {
    // Arrange
    ImmutableIdGroup.Builder builderResult = ImmutableIdGroup.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.values(elements));
  }

  /**
   * Method under test: {@link ImmutableIdGroup#copyOf(IdGroup)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(new ArrayList<>());
    when(instance.key()).thenReturn(1L);

    // Act
    ImmutableIdGroup actualCopyOfResult = ImmutableIdGroup.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertEquals(1L, actualCopyOfResult.key().longValue());
    assertTrue(actualCopyOfResult.values().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableIdGroup#copyOf(IdGroup)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(resultLongList);
    when(instance.key()).thenReturn(1L);

    // Act
    ImmutableIdGroup actualCopyOfResult = ImmutableIdGroup.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    List<Long> valuesResult = actualCopyOfResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals(1L, valuesResult.get(0).longValue());
    assertEquals(1L, actualCopyOfResult.key().longValue());
  }

  /**
   * Method under test: {@link ImmutableIdGroup#copyOf(IdGroup)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(-2L);
    resultLongList.add(1L);
    IdGroup instance = mock(IdGroup.class);
    when(instance.values()).thenReturn(resultLongList);
    when(instance.key()).thenReturn(1L);

    // Act
    ImmutableIdGroup actualCopyOfResult = ImmutableIdGroup.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertEquals(1L, actualCopyOfResult.key().longValue());
    assertEquals(resultLongList, actualCopyOfResult.values());
  }

  /**
   * Method under test: {@link ImmutableIdGroup#fromJson(ImmutableIdGroup.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableIdGroup.Json json = new ImmutableIdGroup.Json();
    json.setKey(1L);
    json.setValues(null);

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.key().longValue());
    assertTrue(actualFromJsonResult.values().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableIdGroup#fromJson(ImmutableIdGroup.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<Long> values = new ArrayList<>();
    values.add(1L);

    ImmutableIdGroup.Json json = new ImmutableIdGroup.Json();
    json.setKey(1L);
    json.setValues(values);

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    List<Long> valuesResult = actualFromJsonResult.values();
    assertEquals(1, valuesResult.size());
    assertEquals(1L, valuesResult.get(0).longValue());
    assertEquals(1L, actualFromJsonResult.key().longValue());
  }

  /**
   * Method under test: {@link ImmutableIdGroup#fromJson(ImmutableIdGroup.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<Long> values = new ArrayList<>();
    values.add(1L);
    values.add(1L);

    ImmutableIdGroup.Json json = new ImmutableIdGroup.Json();
    json.setKey(1L);
    json.setValues(values);

    // Act
    ImmutableIdGroup actualFromJsonResult = ImmutableIdGroup.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.key().longValue());
    assertEquals(values, actualFromJsonResult.values());
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableIdGroup.Json()).key());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableIdGroup.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableIdGroup.Json actualJson = new ImmutableIdGroup.Json();

    // Assert
    assertNull(actualJson.key);
    assertTrue(actualJson.values.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableIdGroup.Json#values()}
   */
  @Test
  void testJsonValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableIdGroup.Json()).values());
  }
}
