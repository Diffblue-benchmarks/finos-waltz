package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.ImmutableEntityWithOperations.Builder;
import org.finos.waltz.model.ImmutableEntityWithOperations.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityWithOperationsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllOperations(Iterable)}.
   * <ul>
   *   <li>Given {@code ADD}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOperations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOperations(Iterable); given 'ADD'; when LinkedHashSet() add 'ADD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOperations(Iterable)"})
  void testBuilderAddAllOperations_givenAdd_whenLinkedHashSetAddAdd() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperations(elements));
  }

  /**
   * Test Builder {@link Builder#addAllOperations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOperations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOperations(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOperations(Iterable)"})
  void testBuilderAddAllOperations_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOperations(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addOperations(Operation)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addOperations(Operation)}
   */
  @Test
  @DisplayName("Test Builder addOperations(Operation) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOperations(Operation)"})
  void testBuilderAddOperationsWithElement() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperations(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#addOperations(Operation[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addOperations(Operation[])}
   */
  @Test
  @DisplayName("Test Builder addOperations(Operation[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOperations(Operation[])"})
  void testBuilderAddOperationsWithElements() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOperations(Operation.ADD));
  }

  /**
   * Test Builder {@link Builder#entity(Object)}.
   * <p>
   * Method under test: {@link Builder#entity(Object)}
   */
  @Test
  @DisplayName("Test Builder entity(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entity(Object)"})
  void testBuilderEntity() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    Builder<Object> actualEntityResult = builderResult.entity("Entity");

    // Assert
    ImmutableEntityWithOperations<Object> buildResult = builderResult.build();
    assertEquals("Entity", buildResult.entity());
    assertTrue(buildResult.operations().isEmpty());
    assertSame(builderResult, actualEntityResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWithOperations)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ADD}.</li>
   *   <li>Then builder build operations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityWithOperations)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWithOperations); given HashSet() add 'ADD'; then builder build operations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWithOperations)"})
  void testBuilderFrom_givenHashSetAddAdd_thenBuilderBuildOperationsSizeIsOne() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    HashSet<Operation> operationSet = new HashSet<>();
    operationSet.add(Operation.ADD);
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenReturn(operationSet);
    when(instance.entity()).thenReturn("Entity");

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(EntityWithOperations)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build operations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityWithOperations)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWithOperations); given HashSet(); then builder build operations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWithOperations)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildOperationsEmpty() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenReturn(new HashSet<>());
    when(instance.entity()).thenReturn("Entity");

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entity();
    verify(instance).operations();
    ImmutableEntityWithOperations<Object> buildResult = builderResult.build();
    assertEquals("Entity", buildResult.entity());
    assertTrue(buildResult.operations().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWithOperations)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityWithOperations)}
   */
  @Test
  @DisplayName("Test Builder from(EntityWithOperations); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityWithOperations)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    EntityWithOperations<Object> instance = mock(EntityWithOperations.class);
    when(instance.operations()).thenThrow(new IllegalStateException("instance"));
    when(instance.entity()).thenReturn("Entity");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entity();
    verify(instance).operations();
  }

  /**
   * Test Builder {@link Builder#operations(Iterable)}.
   * <ul>
   *   <li>Given {@code ADD}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#operations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder operations(Iterable); given 'ADD'; when LinkedHashSet() add 'ADD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operations(Iterable)"})
  void testBuilderOperations_givenAdd_whenLinkedHashSetAddAdd() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act and Assert
    assertSame(builderResult, builderResult.operations(elements));
  }

  /**
   * Test Builder {@link Builder#operations(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#operations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder operations(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operations(Iterable)"})
  void testBuilderOperations_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operations(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#entity()}.
   * <p>
   * Method under test: {@link Json#entity()}
   */
  @Test
  @DisplayName("Test Json entity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Json.entity()"})
  void testJsonEntity() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entity());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json<Object> actualJson = new Json<>();

    // Assert
    assertNull(actualJson.entity);
    assertTrue(actualJson.operations.isEmpty());
  }

  /**
   * Test Json {@link Json#operations()}.
   * <p>
   * Method under test: {@link Json#operations()}
   */
  @Test
  @DisplayName("Test Json operations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.operations()"})
  void testJsonOperations() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.operations());
  }
}
