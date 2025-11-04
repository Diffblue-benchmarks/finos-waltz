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
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableEntityReferenceKeyedGroupDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#addAllValues(Iterable)}
   */
  @Test
  void testBuilderAddAllValues() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#addValues(EntityReference)}
   */
  @Test
  void testBuilderAddValues() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(new ImmutableEntityReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#addValues(EntityReference[])}
   */
  @Test
  void testBuilderAddValues2() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addValues(new ImmutableEntityReference.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(new ArrayList<>());
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.key()).thenReturn(json);

    // Act
    ImmutableEntityReferenceKeyedGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertSame(json, builderResult.build().key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenThrow(new IllegalStateException("instance"));
    when(instance.key()).thenReturn(new ImmutableEntityReference.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).key();
    verify(instance).values();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    entityReferenceList.add(json);
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(entityReferenceList);
    ImmutableEntityReference.Json json2 = new ImmutableEntityReference.Json();
    when(instance.key()).thenReturn(json2);

    // Act
    ImmutableEntityReferenceKeyedGroup.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    ImmutableEntityReferenceKeyedGroup buildResult = builderResult.build();
    List<EntityReference> valuesResult = buildResult.values();
    assertEquals(1, valuesResult.size());
    assertSame(json, valuesResult.get(0));
    assertSame(json2, buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#key(EntityReference)}
   */
  @Test
  void testBuilderKey() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();

    // Act
    ImmutableEntityReferenceKeyedGroup.Builder actualKeyResult = builderResult.key(key);

    // Assert
    assertSame(key, builderResult.build().key());
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup.Builder#values(Iterable)}
   */
  @Test
  void testBuilderValues() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.values(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup#copyOf(EntityReferenceKeyedGroup)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(new ArrayList<>());
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.key()).thenReturn(json);

    // Act
    ImmutableEntityReferenceKeyedGroup actualCopyOfResult = ImmutableEntityReferenceKeyedGroup.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertTrue(actualCopyOfResult.values().isEmpty());
    assertSame(json, actualCopyOfResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup#copyOf(EntityReferenceKeyedGroup)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(new ImmutableEntityReference.Json());
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(entityReferenceList);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.key()).thenReturn(json);

    // Act
    ImmutableEntityReferenceKeyedGroup actualCopyOfResult = ImmutableEntityReferenceKeyedGroup.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertEquals(entityReferenceList, actualCopyOfResult.values());
    assertSame(json, actualCopyOfResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup#copyOf(EntityReferenceKeyedGroup)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(new ImmutableEntityReference.Json());
    entityReferenceList.add(new ImmutableEntityReference.Json());
    EntityReferenceKeyedGroup instance = mock(EntityReferenceKeyedGroup.class);
    when(instance.values()).thenReturn(entityReferenceList);
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    when(instance.key()).thenReturn(json);

    // Act
    ImmutableEntityReferenceKeyedGroup actualCopyOfResult = ImmutableEntityReferenceKeyedGroup.copyOf(instance);

    // Assert
    verify(instance).key();
    verify(instance).values();
    assertEquals(entityReferenceList, actualCopyOfResult.values());
    assertSame(json, actualCopyOfResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup#fromJson(ImmutableEntityReferenceKeyedGroup.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityReferenceKeyedGroup.Json json = new ImmutableEntityReferenceKeyedGroup.Json();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();
    json.setKey(key);
    json.setValues(null);

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult = ImmutableEntityReferenceKeyedGroup.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.values().isEmpty());
    assertSame(key, actualFromJsonResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup#fromJson(ImmutableEntityReferenceKeyedGroup.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<EntityReference> values = new ArrayList<>();
    values.add(new ImmutableEntityReference.Json());

    ImmutableEntityReferenceKeyedGroup.Json json = new ImmutableEntityReferenceKeyedGroup.Json();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();
    json.setKey(key);
    json.setValues(values);

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult = ImmutableEntityReferenceKeyedGroup.fromJson(json);

    // Assert
    assertEquals(values, actualFromJsonResult.values());
    assertSame(key, actualFromJsonResult.key());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityReferenceKeyedGroup#fromJson(ImmutableEntityReferenceKeyedGroup.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<EntityReference> values = new ArrayList<>();
    values.add(new ImmutableEntityReference.Json());
    values.add(new ImmutableEntityReference.Json());

    ImmutableEntityReferenceKeyedGroup.Json json = new ImmutableEntityReferenceKeyedGroup.Json();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();
    json.setKey(key);
    json.setValues(values);

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult = ImmutableEntityReferenceKeyedGroup.fromJson(json);

    // Assert
    assertEquals(values, actualFromJsonResult.values());
    assertSame(key, actualFromJsonResult.key());
  }

  /**
   * Method under test: {@link ImmutableEntityReferenceKeyedGroup.Json#key()}
   */
  @Test
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReferenceKeyedGroup.Json()).key());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityReferenceKeyedGroup.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityReferenceKeyedGroup.Json actualJson = new ImmutableEntityReferenceKeyedGroup.Json();

    // Assert
    assertNull(actualJson.key);
    assertTrue(actualJson.values.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableEntityReferenceKeyedGroup.Json#values()}
   */
  @Test
  void testJsonValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEntityReferenceKeyedGroup.Json()).values());
  }
}
