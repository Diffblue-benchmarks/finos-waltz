package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableOrderedTallyDiffblueTest {
  /**
   * Method under test: {@link ImmutableOrderedTally.Builder#count(double)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(10.0d));
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Builder#from(OrderedTally)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();
    OrderedTally<Object> instance = mock(OrderedTally.class);
    when(instance.count()).thenReturn(10.0d);
    when(instance.index()).thenReturn(1);
    when(instance.id()).thenReturn("Id");

    // Act
    ImmutableOrderedTally.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).index();
    verify(instance).count();
    verify(instance).id();
    ImmutableOrderedTally<Object> buildResult = builderResult.build();
    assertEquals("Id", buildResult.id());
    assertEquals(1, buildResult.index());
    assertEquals(10.0d, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Builder#from(Tally)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();
    Tally<Object> instance = mock(Tally.class);
    when(instance.count()).thenReturn(10.0d);
    when(instance.id()).thenReturn("Id");

    // Act
    ImmutableOrderedTally.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Builder#id(Object)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("Id"));
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Builder#index(int)}
   */
  @Test
  void testBuilderIndex() {
    // Arrange
    ImmutableOrderedTally.Builder<Object> builderResult = ImmutableOrderedTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.index(1));
  }

  /**
   * Method under test: {@link ImmutableOrderedTally#copyOf(OrderedTally)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    OrderedTally<Object> instance = mock(OrderedTally.class);
    when(instance.count()).thenReturn(10.0d);
    when(instance.index()).thenReturn(1);
    when(instance.id()).thenReturn("Id");

    // Act
    ImmutableOrderedTally<Object> actualCopyOfResult = ImmutableOrderedTally.copyOf(instance);

    // Assert
    verify(instance).index();
    verify(instance).count();
    verify(instance).id();
    assertEquals("Id", actualCopyOfResult.id());
    assertEquals(1, actualCopyOfResult.index());
    assertEquals(10.0d, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableOrderedTally.Json}
   *   <li>{@link ImmutableOrderedTally.Json#setId(Object)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableOrderedTally.Json<Object> actualJson = new ImmutableOrderedTally.Json<>();
    actualJson.setId("Id");

    // Assert
    assertEquals("Id", actualJson.id);
    assertEquals(0, actualJson.index);
    assertEquals(0.0d, actualJson.count);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.indexIsSet);
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.id());
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Json#index()}
   */
  @Test
  void testJsonIndex() {
    // Arrange
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.index());
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Json#setCount(double)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();

    // Act
    json.setCount(10.0d);

    // Assert
    assertEquals(10.0d, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableOrderedTally.Json#setIndex(int)}
   */
  @Test
  void testJsonSetIndex() {
    // Arrange
    ImmutableOrderedTally.Json<Object> json = new ImmutableOrderedTally.Json<>();

    // Act
    json.setIndex(1);

    // Assert
    assertEquals(1, json.index);
    assertTrue(json.indexIsSet);
  }
}
