package org.finos.waltz.model.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipChangeCommand.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityRelationshipChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityRelationshipChangeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityRelationshipChangeCommand actualImmutableEntityRelationshipChangeCommand =
        actualBuilderResult
            .entityReference(entityReference)
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Assert
    assertEquals(Operation.ADD, actualImmutableEntityRelationshipChangeCommand.operation());
    assertEquals(
        RelationshipKind.HAS, actualImmutableEntityRelationshipChangeCommand.relationship());
    assertSame(entityReference, actualImmutableEntityRelationshipChangeCommand.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityRelationshipChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(EntityRelationshipChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityRelationshipChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityRelationshipChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    Builder builderResult2 = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityRelationshipChangeCommand actualImmutableEntityRelationshipChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityRelationshipChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
  }

  /**
   * Test Builder {@link Builder#relationship(RelationshipKind)}.
   *
   * <p>Method under test: {@link Builder#relationship(RelationshipKind)}
   */
  @Test
  @DisplayName("Test Builder relationship(RelationshipKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationship(RelationshipKind)"})
  void testBuilderRelationship() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    Builder actualRelationshipResult = builderResult.relationship(RelationshipKind.HAS);

    // Assert
    assertSame(builderResult, actualRelationshipResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#copyOf(EntityRelationshipChangeCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityRelationshipChangeCommand#copyOf(EntityRelationshipChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityRelationshipChangeCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.copyOf(EntityRelationshipChangeCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand instance =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act
    ImmutableEntityRelationshipChangeCommand actualCopyOfResult =
        ImmutableEntityRelationshipChangeCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
    assertEquals(RelationshipKind.HAS, actualCopyOfResult.relationship());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}, and {@link
   * ImmutableEntityRelationshipChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act and Assert
    assertEquals(
        immutableEntityRelationshipChangeCommand, immutableEntityRelationshipChangeCommand2);
    assertEquals(
        immutableEntityRelationshipChangeCommand.hashCode(),
        immutableEntityRelationshipChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}, and {@link
   * ImmutableEntityRelationshipChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act and Assert
    assertEquals(
        immutableEntityRelationshipChangeCommand, immutableEntityRelationshipChangeCommand);
    int expectedHashCodeResult = immutableEntityRelationshipChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityRelationshipChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityRelationshipChangeCommand,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ATTEST)
            .relationship(RelationshipKind.HAS)
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityRelationshipChangeCommand,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.DEPRECATES)
            .build();

    Builder builderResult2 = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityRelationshipChangeCommand,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityRelationshipChangeCommand.equals(Object)",
    "int ImmutableEntityRelationshipChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build(),
        "Different type to ImmutableEntityRelationshipChangeCommand");
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When {@link Json} (default constructor) Operation is {@code ADD}.
   *   <li>Then return operation is {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ADD'; when Json (default constructor) Operation is 'ADD'; then return operation is 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenAdd_whenJsonOperationIsAdd_thenReturnOperationIsAdd() {
    // Arrange
    Json json = new Json();
    json.setOperation(Operation.ADD);
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setRelationship(RelationshipKind.HAS);

    // Act
    ImmutableEntityRelationshipChangeCommand actualFromJsonResult =
        ImmutableEntityRelationshipChangeCommand.fromJson(json);

    // Assert
    assertEquals(Operation.ADD, actualFromJsonResult.operation());
    assertEquals(RelationshipKind.HAS, actualFromJsonResult.relationship());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#toString()}
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#entityReference()}
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#operation()}
   *   <li>{@link ImmutableEntityRelationshipChangeCommand#relationship()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableEntityRelationshipChangeCommand.entityReference()",
    "Operation ImmutableEntityRelationshipChangeCommand.operation()",
    "RelationshipKind ImmutableEntityRelationshipChangeCommand.relationship()",
    "String ImmutableEntityRelationshipChangeCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act
    String actualToStringResult = immutableEntityRelationshipChangeCommand.toString();
    EntityReference actualEntityReferenceResult =
        immutableEntityRelationshipChangeCommand.entityReference();
    Operation actualOperationResult = immutableEntityRelationshipChangeCommand.operation();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "EntityRelationshipChangeCommand{operation=ADD, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, relationship=HAS}",
        actualToStringResult);
    assertEquals(Operation.ADD, actualOperationResult);
    assertEquals(RelationshipKind.HAS, immutableEntityRelationshipChangeCommand.relationship());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setOperation(Operation)}
   *   <li>{@link Json#setRelationship(RelationshipKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setOperation(Operation)",
    "void Json.setRelationship(RelationshipKind)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setOperation(Operation.ADD);
    actualJson.setRelationship(RelationshipKind.HAS);

    // Assert
    EntityReference entityReference = actualJson.entityReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualJson.operation);
    assertEquals(RelationshipKind.HAS, actualJson.relationship);
  }

  /**
   * Test Json {@link Json#operation()}.
   *
   * <p>Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operation());
  }

  /**
   * Test Json {@link Json#relationship()}.
   *
   * <p>Method under test: {@link Json#relationship()}
   */
  @Test
  @DisplayName("Test Json relationship()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RelationshipKind Json.relationship()"})
  void testJsonRelationship() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relationship());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityRelationshipChangeCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act
    ImmutableEntityRelationshipChangeCommand actualWithEntityReferenceResult =
        immutableEntityRelationshipChangeCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityRelationshipChangeCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.withOperation(Operation)"
  })
  void testWithOperation() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act
    ImmutableEntityRelationshipChangeCommand actualWithOperationResult =
        immutableEntityRelationshipChangeCommand.withOperation(Operation.ADD);

    // Assert
    assertSame(immutableEntityRelationshipChangeCommand, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#withOperation(Operation)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityRelationshipChangeCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test withOperation(Operation); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.withOperation(Operation)"
  })
  void testWithOperation_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    ImmutableEntityRelationshipChangeCommand actualWithOperationResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ATTEST)
            .relationship(RelationshipKind.HAS)
            .build()
            .withOperation(Operation.ADD);

    // Assert
    EntityReference entityReferenceResult = actualWithOperationResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
    assertEquals(RelationshipKind.HAS, actualWithOperationResult.relationship());
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#withRelationship(RelationshipKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityRelationshipChangeCommand#withRelationship(RelationshipKind)}
   */
  @Test
  @DisplayName("Test withRelationship(RelationshipKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.withRelationship(RelationshipKind)"
  })
  void testWithRelationship() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();
    ImmutableEntityRelationshipChangeCommand immutableEntityRelationshipChangeCommand =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.HAS)
            .build();

    // Act
    ImmutableEntityRelationshipChangeCommand actualWithRelationshipResult =
        immutableEntityRelationshipChangeCommand.withRelationship(RelationshipKind.HAS);

    // Assert
    assertSame(immutableEntityRelationshipChangeCommand, actualWithRelationshipResult);
  }

  /**
   * Test {@link ImmutableEntityRelationshipChangeCommand#withRelationship(RelationshipKind)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityRelationshipChangeCommand#withRelationship(RelationshipKind)}
   */
  @Test
  @DisplayName(
      "Test withRelationship(RelationshipKind); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityRelationshipChangeCommand ImmutableEntityRelationshipChangeCommand.withRelationship(RelationshipKind)"
  })
  void testWithRelationship_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityRelationshipChangeCommand.builder();

    // Act
    ImmutableEntityRelationshipChangeCommand actualWithRelationshipResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .relationship(RelationshipKind.DEPRECATES)
            .build()
            .withRelationship(RelationshipKind.HAS);

    // Assert
    EntityReference entityReferenceResult = actualWithRelationshipResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithRelationshipResult.operation());
    assertEquals(RelationshipKind.HAS, actualWithRelationshipResult.relationship());
  }
}
