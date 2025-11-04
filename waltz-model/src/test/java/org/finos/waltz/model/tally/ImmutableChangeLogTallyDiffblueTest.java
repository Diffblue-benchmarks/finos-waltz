package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogTallyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableChangeLogTally#builder()}
   *   <li>{@link ImmutableChangeLogTally#childKind(EntityKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableChangeLogTally.Builder actualBuilderResult = ImmutableChangeLogTally.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.childKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally.Builder#count(long)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableChangeLogTally.Builder builderResult = ImmutableChangeLogTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogTally.Builder#from(ChangeLogTally)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeLogTally.Builder builderResult = ImmutableChangeLogTally.builder();
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.childKind()).thenReturn(EntityKind.ALL);
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLogTally.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childKind();
    verify(instance).count();
    verify(instance).ref();
    ImmutableChangeLogTally buildResult = builderResult.build();
    assertEquals(3L, buildResult.count());
    assertEquals(EntityKind.ALL, buildResult.childKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogTally.Builder#from(ChangeLogTally)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeLogTally.Builder builderResult = ImmutableChangeLogTally.builder();
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.childKind()).thenReturn(null);
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLogTally.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).childKind();
    verify(instance).count();
    verify(instance).ref();
    ImmutableChangeLogTally buildResult = builderResult.build();
    assertNull(buildResult.childKind());
    assertEquals(3L, buildResult.count());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogTally.Builder#from(ChangeLogTally)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeLogTally.Builder builderResult = ImmutableChangeLogTally.builder();
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.childKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).childKind();
    verify(instance).ref();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeLogTally.Builder#ref(EntityReference)}
   */
  @Test
  void testBuilderRef() {
    // Arrange
    ImmutableChangeLogTally.Builder builderResult = ImmutableChangeLogTally.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ref(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally#copyOf(ChangeLogTally)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeLogTally instance = mock(ChangeLogTally.class);
    when(instance.count()).thenReturn(3L);
    when(instance.childKind()).thenReturn(EntityKind.ALL);
    when(instance.ref()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableChangeLogTally actualCopyOfResult = ImmutableChangeLogTally.copyOf(instance);

    // Assert
    verify(instance).childKind();
    verify(instance).count();
    verify(instance).ref();
    assertEquals(3L, actualCopyOfResult.count());
    assertEquals(EntityKind.ALL, actualCopyOfResult.childKind());
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally.Json#childKind()}
   */
  @Test
  void testJsonChildKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLogTally.Json()).childKind());
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLogTally.Json()).count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableChangeLogTally.Json}
   *   <li>{@link ImmutableChangeLogTally.Json#setChildKind(EntityKind)}
   *   <li>{@link ImmutableChangeLogTally.Json#setRef(EntityReference)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableChangeLogTally.Json actualJson = new ImmutableChangeLogTally.Json();
    actualJson.setChildKind(EntityKind.ALL);
    actualJson.setRef(null);

    // Assert
    assertNull(actualJson.ref);
    assertEquals(0L, actualJson.count);
    assertEquals(EntityKind.ALL, actualJson.childKind);
    assertFalse(actualJson.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally.Json#ref()}
   */
  @Test
  void testJsonRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeLogTally.Json()).ref());
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally.Json#setCount(long)}
   */
  @Test
  void testJsonSetCount() {
    // Arrange
    ImmutableChangeLogTally.Json json = new ImmutableChangeLogTally.Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Method under test: {@link ImmutableChangeLogTally.Json#setCount(long)}
   */
  @Test
  void testJsonSetCount2() {
    // Arrange
    ImmutableChangeLogTally.Json json = new ImmutableChangeLogTally.Json();
    json.setRef(mock(EntityReference.class));

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }
}
