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

class ImmutableTallyDiffblueTest {
  /**
   * Method under test: {@link ImmutableTally.Builder#count(double)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableTally.Builder<Object> builderResult = ImmutableTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(10.0d));
  }

  /**
   * Method under test: {@link ImmutableTally.Builder#from(Tally)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTally.Builder<Object> builderResult = ImmutableTally.builder();
    Tally<Object> instance = mock(Tally.class);
    when(instance.count()).thenReturn(10.0d);
    when(instance.id()).thenReturn("Id");

    // Act
    ImmutableTally.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    ImmutableTally<Object> buildResult = builderResult.build();
    assertEquals("Id", buildResult.id());
    assertEquals(10.0d, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableTally.Builder#from(Tally)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTally.Builder<Object> builderResult = ImmutableTally.builder();
    Tally<Object> instance = mock(Tally.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.id()).thenReturn("Id");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableTally.Builder#id(Object)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableTally.Builder<Object> builderResult = ImmutableTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id("Id"));
  }

  /**
   * Method under test: {@link ImmutableTally#copyOf(Tally)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    Tally<Object> instance = mock(Tally.class);
    when(instance.count()).thenReturn(10.0d);
    when(instance.id()).thenReturn("Id");

    // Act
    ImmutableTally<Object> actualCopyOfResult = ImmutableTally.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).id();
    assertEquals("Id", actualCopyOfResult.id());
    assertEquals(10.0d, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableTally.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange
    ImmutableTally.Json<Object> json = new ImmutableTally.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableTally.Json}
   *   <li>{@link ImmutableTally.Json#setId(Object)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableTally.Json<Object> actualJson = new ImmutableTally.Json<>();
    actualJson.setId("Id");

    // Assert
    assertEquals("Id", actualJson.id);
    assertEquals(0.0d, actualJson.count);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableTally.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange
    ImmutableTally.Json<Object> json = new ImmutableTally.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.id());
  }

  /**
   * Method under test: {@link ImmutableTally.Json#setCount(double)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableTally.Json<Object> json = new ImmutableTally.Json<>();

    // Act
    json.setCount(10.0d);

    // Assert
    assertEquals(10.0d, json.count);
    assertTrue(json.countIsSet);
  }
}
