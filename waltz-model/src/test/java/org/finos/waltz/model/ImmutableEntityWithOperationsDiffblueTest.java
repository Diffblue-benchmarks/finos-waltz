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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ImmutableEntityWithOperationsDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#addAllOperations(Iterable)}
   */
  @Test
  void testBuilderAddAllOperations() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#addAllOperations(Iterable)}
   */
  @Test
  void testBuilderAddAllOperations2() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperations(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#addOperations(Operation)}
   */
  @Test
  void testBuilderAddOperations() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperations(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#addOperations(Operation[])}
   */
  @Test
  void testBuilderAddOperations2() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperations(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#entity(Object)}
   */
  @Test
  void testBuilderEntity() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    ImmutableEntityWithOperations.Builder<Object> actualEntityResult = builderResult.entity("Entity");

    // Assert
    ImmutableEntityWithOperations<Object> buildResult = builderResult.build();
    assertEquals("Entity", buildResult.entity());
    assertTrue(buildResult.operations().isEmpty());
    assertSame(builderResult, actualEntityResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#from(EntityWithOperations)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenReturn(new HashSet<>());
    when(instance.entity()).thenReturn("Entity");

    // Act
    ImmutableEntityWithOperations.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entity();
    verify(instance).operations();
    ImmutableEntityWithOperations<Object> buildResult = builderResult.build();
    assertEquals("Entity", buildResult.entity());
    assertTrue(buildResult.operations().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#from(EntityWithOperations)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenThrow(new IllegalStateException("instance"));
    when(instance.entity()).thenReturn("Entity");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entity();
    verify(instance).operations();
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#from(EntityWithOperations)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenReturn(operationSet);
    when(instance.entity()).thenReturn("Entity");

    // Act
    ImmutableEntityWithOperations.Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entity();
    verify(instance).operations();
    ImmutableEntityWithOperations<Object> buildResult = builderResult.build();
    assertEquals("Entity", buildResult.entity());
    Set<Operation> operationsResult = buildResult.operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#operations(Iterable)}
   */
  @Test
  void testBuilderOperations() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operations(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations.Builder#operations(Iterable)}
   */
  @Test
  void testBuilderOperations2() {
    // Arrange
    ImmutableEntityWithOperations.Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act and Assert
    assertSame(builderResult, builderResult.operations(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations#copyOf(EntityWithOperations)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenReturn(new HashSet<>());
    when(instance.entity()).thenReturn("Entity");

    // Act
    ImmutableEntityWithOperations<Object> actualCopyOfResult = ImmutableEntityWithOperations.copyOf(instance);

    // Assert
    verify(instance).entity();
    verify(instance).operations();
    assertEquals("Entity", actualCopyOfResult.entity());
    assertTrue(actualCopyOfResult.operations().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations#copyOf(EntityWithOperations)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenReturn(operationSet);
    when(instance.entity()).thenReturn("Entity");

    // Act
    ImmutableEntityWithOperations<Object> actualCopyOfResult = ImmutableEntityWithOperations.copyOf(instance);

    // Assert
    verify(instance).entity();
    verify(instance).operations();
    assertEquals("Entity", actualCopyOfResult.entity());
    Set<Operation> operationsResult = actualCopyOfResult.operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
  }

  /**
   * Method under test:
   * {@link ImmutableEntityWithOperations#fromJson(ImmutableEntityWithOperations.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableEntityWithOperations.Json<Object> json = new ImmutableEntityWithOperations.Json<>();
    json.setEntity("Json");
    json.setOperations(null);

    // Act
    ImmutableEntityWithOperations<Object> actualFromJsonResult = ImmutableEntityWithOperations.fromJson(json);

    // Assert
    Object entityResult = actualFromJsonResult.entity();
    assertEquals("Json", entityResult);
    assertTrue(actualFromJsonResult.operations().isEmpty());
    assertSame(json.entity, entityResult);
  }

  /**
   * Method under test: {@link ImmutableEntityWithOperations.Json#entity()}
   */
  @Test
  void testJsonEntity() {
    // Arrange
    ImmutableEntityWithOperations.Json<Object> json = new ImmutableEntityWithOperations.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entity());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEntityWithOperations.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEntityWithOperations.Json<Object> actualJson = new ImmutableEntityWithOperations.Json<>();

    // Assert
    assertNull(actualJson.entity);
    assertTrue(actualJson.operations.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableEntityWithOperations.Json#operations()}
   */
  @Test
  void testJsonOperations() {
    // Arrange
    ImmutableEntityWithOperations.Json<Object> json = new ImmutableEntityWithOperations.Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.operations());
  }
}
