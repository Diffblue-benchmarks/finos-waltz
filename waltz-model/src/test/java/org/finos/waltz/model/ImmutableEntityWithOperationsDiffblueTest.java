package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOperations(Iterable); given 'ADD'; when LinkedHashSet() add 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOperations(Iterable)"})
  void testBuilderAddAllOperations_givenAdd_whenLinkedHashSetAddAdd() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    Builder<Object> actualAddAllOperationsResult = builderResult.addAllOperations(elements);

    // Assert
    assertSame(builderResult, actualAddAllOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOperations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOperations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOperations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOperations(Iterable)"})
  void testBuilderAddAllOperations_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    Builder<Object> actualAddAllOperationsResult =
        builderResult.addAllOperations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(Operation)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addOperations(Operation)}
   */
  @Test
  @DisplayName("Test Builder addOperations(Operation) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Operation)"})
  void testBuilderAddOperationsWithElement() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    Builder<Object> actualAddOperationsResult = builderResult.addOperations(Operation.ADD);

    // Assert
    assertSame(builderResult, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(Operation[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addOperations(Operation[])}
   */
  @Test
  @DisplayName("Test Builder addOperations(Operation[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Operation[])"})
  void testBuilderAddOperationsWithElements() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    Builder<Object> actualAddOperationsResult = builderResult.addOperations(Operation.ADD);

    // Assert
    assertSame(builderResult, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityWithOperations Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> actualImmutableEntityWithOperations =
        actualBuilderResult.entity("Entity").build();

    // Assert
    assertEquals("Entity", actualImmutableEntityWithOperations.entity());
    assertTrue(actualImmutableEntityWithOperations.operations().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entity(Object)}.
   *
   * <ul>
   *   <li>When {@code Entity}.
   *   <li>Then builder build entity is {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entity(Object)}
   */
  @Test
  @DisplayName("Test Builder entity(Object); when 'Entity'; then builder build entity is 'Entity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(Object)"})
  void testBuilderEntity_whenEntity_thenBuilderBuildEntityIsEntity() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    Builder<Object> actualEntityResult = builderResult.entity("Entity");

    // Assert
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations = builderResult.build();
    assertEquals("Entity", immutableEntityWithOperations.entity());
    assertTrue(immutableEntityWithOperations.operations().isEmpty());
    assertSame(builderResult, actualEntityResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWithOperations)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When builder addOperations {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityWithOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityWithOperations); given 'ADD'; when builder addOperations 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWithOperations)"})
  void testBuilderFrom_givenAdd_whenBuilderAddOperationsAdd() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    Builder<Object> builderResult2 = ImmutableEntityWithOperations.builder();
    builderResult2.addOperations(Operation.ADD);
    ImmutableEntityWithOperations<Object> instance = builderResult2.entity("Entity").build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityWithOperations<Object> actualImmutableEntityWithOperations =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWithOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityWithOperations)}.
   *
   * <ul>
   *   <li>Then builder build is builder entity {@code Entity} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityWithOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityWithOperations); then builder build is builder entity 'Entity' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityWithOperations)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderEntityEntityBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    Builder<Object> builderResult2 = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> instance = builderResult2.entity("Entity").build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityWithOperations<Object> actualImmutableEntityWithOperations =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityWithOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#operations(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder operations(Iterable); given 'ADD'; when LinkedHashSet() add 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Iterable)"})
  void testBuilderOperations_givenAdd_whenLinkedHashSetAddAdd() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    Builder<Object> actualOperationsResult = builderResult.operations(elements);

    // Assert
    assertSame(builderResult, actualOperationsResult);
  }

  /**
   * Test Builder {@link Builder#operations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder operations(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Iterable)"})
  void testBuilderOperations_whenArrayList() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    Builder<Object> actualOperationsResult = builderResult.operations(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOperationsResult);
  }

  /**
   * Test {@link ImmutableEntityWithOperations#copyOf(EntityWithOperations)}.
   *
   * <ul>
   *   <li>When builder entity {@code Entity} build.
   *   <li>Then return {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#copyOf(EntityWithOperations)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityWithOperations); when builder entity 'Entity' build; then return 'Entity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWithOperations ImmutableEntityWithOperations.copyOf(EntityWithOperations)"
  })
  void testCopyOf_whenBuilderEntityEntityBuild_thenReturnEntity() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> instance = builderResult.entity("Entity").build();

    // Act
    ImmutableEntityWithOperations<Object> actualCopyOfResult =
        ImmutableEntityWithOperations.copyOf(instance);

    // Assert
    assertEquals("Entity", actualCopyOfResult.entity());
    assertTrue(actualCopyOfResult.operations().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}, and {@link
   * ImmutableEntityWithOperations#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWithOperations#equals(Object)}
   *   <li>{@link ImmutableEntityWithOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity("Entity").build();

    Builder<Object> builderResult2 = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations2 =
        builderResult2.entity("Entity").build();

    // Act and Assert
    assertEquals(immutableEntityWithOperations, immutableEntityWithOperations2);
    assertEquals(
        immutableEntityWithOperations.hashCode(), immutableEntityWithOperations2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}, and {@link
   * ImmutableEntityWithOperations#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWithOperations#equals(Object)}
   *   <li>{@link ImmutableEntityWithOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity("Entity").build();

    // Act and Assert
    assertEquals(immutableEntityWithOperations, immutableEntityWithOperations);
    int expectedHashCodeResult = immutableEntityWithOperations.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityWithOperations.hashCode());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    builderResult.addOperations(Operation.ADD);
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity("Entity").build();

    Builder<Object> builderResult2 = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertNotEquals(immutableEntityWithOperations, builderResult2.entity("Entity").build());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity(1).build();

    Builder<Object> builderResult2 = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertNotEquals(immutableEntityWithOperations, builderResult2.entity("Entity").build());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    Builder<Object> builderResult2 = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity(builderResult2.entity("Entity").build()).build();

    Builder<Object> builderResult3 = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertNotEquals(immutableEntityWithOperations, builderResult3.entity("Entity").build());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertNotEquals(builderResult.entity("Entity").build(), null);
  }

  /**
   * Test {@link ImmutableEntityWithOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityWithOperations.equals(Object)",
    "int ImmutableEntityWithOperations.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.entity("Entity").build(), "Different type to ImmutableEntityWithOperations");
  }

  /**
   * Test {@link ImmutableEntityWithOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.
   *   <li>Then return operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'ADD'; then return operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityWithOperations ImmutableEntityWithOperations.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddAdd_thenReturnOperationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Operation> operations = new LinkedHashSet<>();
    operations.add(Operation.ADD);

    Json<Object> json = new Json<>();
    json.setEntity("Json");
    json.setOperations(operations);

    // Act
    ImmutableEntityWithOperations<Object> actualFromJsonResult =
        ImmutableEntityWithOperations.fromJson(json);

    // Assert
    Set<Operation> operationsResult = actualFromJsonResult.operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
  }

  /**
   * Test {@link ImmutableEntityWithOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Operations is {@code null}.
   *   <li>Then return entity is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Operations is 'null'; then return entity is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityWithOperations ImmutableEntityWithOperations.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonOperationsIsNull_thenReturnEntityIsJson() {
    // Arrange
    Json<Object> json = new Json<>();
    json.setEntity("Json");
    json.setOperations(null);

    // Act
    ImmutableEntityWithOperations<Object> actualFromJsonResult =
        ImmutableEntityWithOperations.fromJson(json);

    // Assert
    Object entityResult = actualFromJsonResult.entity();
    assertEquals("Json", entityResult);
    assertTrue(actualFromJsonResult.operations().isEmpty());
    assertSame(json.entity, entityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityWithOperations#toString()}
   *   <li>{@link ImmutableEntityWithOperations#entity()}
   *   <li>{@link ImmutableEntityWithOperations#operations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ImmutableEntityWithOperations.entity()",
    "Set ImmutableEntityWithOperations.operations()",
    "String ImmutableEntityWithOperations.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity("Entity").build();

    // Act
    String actualToStringResult = immutableEntityWithOperations.toString();
    Object actualEntityResult = immutableEntityWithOperations.entity();

    // Assert
    assertEquals("Entity", actualEntityResult);
    assertEquals("EntityWithOperations{entity=Entity, operations=[]}", actualToStringResult);
    assertTrue(immutableEntityWithOperations.operations().isEmpty());
  }

  /**
   * Test Json {@link Json#entity()}.
   *
   * <p>Method under test: {@link Json#entity()}
   */
  @Test
  @DisplayName("Test Json entity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Json.entity()"})
  void testJsonEntity() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.entity());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#operations()}
   */
  @Test
  @DisplayName("Test Json operations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.operations()"})
  void testJsonOperations() {
    // Arrange
    Json<Object> json = new Json<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> json.operations());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#withEntity(Object)}.
   *
   * <ul>
   *   <li>Given builder entity {@code Entity} build.
   *   <li>When {@code Value}.
   *   <li>Then return entity is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#withEntity(Object)}
   */
  @Test
  @DisplayName(
      "Test withEntity(Object); given builder entity 'Entity' build; when 'Value'; then return entity is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWithOperations ImmutableEntityWithOperations.withEntity(Object)"
  })
  void testWithEntity_givenBuilderEntityEntityBuild_whenValue_thenReturnEntityIsValue() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    ImmutableEntityWithOperations<Object> actualWithEntityResult =
        builderResult.entity("Entity").build().withEntity("Value");

    // Assert
    assertEquals("Value", actualWithEntityResult.entity());
    assertTrue(actualWithEntityResult.operations().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#withEntity(Object)}.
   *
   * <ul>
   *   <li>Then return builder entity forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#withEntity(Object)}
   */
  @Test
  @DisplayName("Test withEntity(Object); then return builder entity forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWithOperations ImmutableEntityWithOperations.withEntity(Object)"
  })
  void testWithEntity_thenReturnBuilderEntityFortyTwoBuild() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity(42).build();

    // Act
    ImmutableEntityWithOperations<Object> actualWithEntityResult =
        immutableEntityWithOperations.withEntity(42);

    // Assert
    assertSame(immutableEntityWithOperations, actualWithEntityResult);
  }

  /**
   * Test {@link ImmutableEntityWithOperations#withOperations(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.
   *   <li>Then return {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#withOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withOperations(Iterable) with 'Iterable'; given 'ADD'; when LinkedHashSet() add 'ADD'; then return 'Entity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWithOperations ImmutableEntityWithOperations.withOperations(Iterable)"
  })
  void testWithOperationsWithIterable_givenAdd_whenLinkedHashSetAddAdd_thenReturnEntity() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();
    ImmutableEntityWithOperations<Object> immutableEntityWithOperations =
        builderResult.entity("Entity").build();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    ImmutableEntityWithOperations<Object> actualWithOperationsResult =
        immutableEntityWithOperations.withOperations(elements);

    // Assert
    assertEquals("Entity", actualWithOperationsResult.entity());
    assertEquals(elements, actualWithOperationsResult.operations());
  }

  /**
   * Test {@link ImmutableEntityWithOperations#withOperations(Operation[])} with {@code
   * Operation[]}.
   *
   * <p>Method under test: {@link ImmutableEntityWithOperations#withOperations(Operation[])}
   */
  @Test
  @DisplayName("Test withOperations(Operation[]) with 'Operation[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityWithOperations ImmutableEntityWithOperations.withOperations(Operation[])"
  })
  void testWithOperationsWithOperation() {
    // Arrange
    Builder<Object> builderResult = ImmutableEntityWithOperations.builder();

    // Act
    ImmutableEntityWithOperations<Object> actualWithOperationsResult =
        builderResult.entity("Entity").build().withOperations(Operation.ADD);

    // Assert
    assertEquals("Entity", actualWithOperationsResult.entity());
    Set<Operation> operationsResult = actualWithOperationsResult.operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
  }
}
