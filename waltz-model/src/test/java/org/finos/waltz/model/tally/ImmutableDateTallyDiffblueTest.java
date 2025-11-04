package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Date;
import org.junit.jupiter.api.Test;

class ImmutableDateTallyDiffblueTest {
  /**
   * Method under test: {@link ImmutableDateTally.Builder#count(long)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableDateTally.Builder builderResult = ImmutableDateTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Method under test: {@link ImmutableDateTally.Builder#date(Date)}
   */
  @Test
  void testBuilderDate() {
    // Arrange
    ImmutableDateTally.Builder builderResult = ImmutableDateTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.date(mock(Date.class)));
  }

  /**
   * Method under test: {@link ImmutableDateTally.Builder#from(DateTally)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDateTally.Builder builderResult = ImmutableDateTally.builder();
    DateTally instance = mock(DateTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.date()).thenReturn(mock(Date.class));

    // Act
    ImmutableDateTally.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).date();
    assertEquals(3L, actualFromResult.build().count());
    assertEquals(3L, builderResult.build().count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDateTally.Builder#from(DateTally)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDateTally.Builder builderResult = ImmutableDateTally.builder();
    DateTally instance = mock(DateTally.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.date()).thenReturn(mock(Date.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).date();
  }

  /**
   * Method under test: {@link ImmutableDateTally#copyOf(DateTally)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DateTally instance = mock(DateTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.date()).thenReturn(mock(Date.class));

    // Act
    ImmutableDateTally actualCopyOfResult = ImmutableDateTally.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).date();
    assertEquals(3L, actualCopyOfResult.count());
  }

  /**
   * Method under test: {@link ImmutableDateTally.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateTally.Json()).count());
  }

  /**
   * Method under test: {@link ImmutableDateTally.Json#date()}
   */
  @Test
  void testJsonDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateTally.Json()).date());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableDateTally.Json}
   *   <li>{@link ImmutableDateTally.Json#setDate(Date)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDateTally.Json actualJson = new ImmutableDateTally.Json();
    actualJson.setDate(mock(Date.class));

    // Assert
    assertEquals(0L, actualJson.count);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableDateTally.Json#setCount(long)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableDateTally.Json json = new ImmutableDateTally.Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableDateTally.Json#setCount(long)}
   */
  @Test
  void testJsonSetCount2() {
    // Arrange
    ImmutableDateTally.Json json = new ImmutableDateTally.Json();
    json.setDate(mock(Date.class));

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }
}
