package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand.Builder;
import org.finos.waltz.model.involvement.ImmutableEntityInvolvementChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityInvolvementChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityInvolvementChangeCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualOperationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityReference personEntityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityInvolvementChangeCommand actualImmutableEntityInvolvementChangeCommand =
        actualOperationResult.personEntityRef(personEntityRef).build();

    // Assert
    assertEquals(1, actualImmutableEntityInvolvementChangeCommand.involvementKindId());
    assertEquals(Operation.ADD, actualImmutableEntityInvolvementChangeCommand.operation());
    assertSame(personEntityRef, actualImmutableEntityInvolvementChangeCommand.personEntityRef());
  }

  /**
   * Test Builder {@link Builder#from(EntityInvolvementChangeCommand)}.
   *
   * <p>Method under test: {@link Builder#from(EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(EntityInvolvementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityInvolvementChangeCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand instance =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityInvolvementChangeCommand actualImmutableEntityInvolvementChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityInvolvementChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#involvementKindId(int)}.
   *
   * <p>Method under test: {@link Builder#involvementKindId(int)}
   */
  @Test
  @DisplayName("Test Builder involvementKindId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.involvementKindId(int)"})
  void testBuilderInvolvementKindId() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act
    Builder actualInvolvementKindIdResult = builderResult.involvementKindId(1);

    // Assert
    assertSame(builderResult, actualInvolvementKindIdResult);
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
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
  }

  /**
   * Test Builder {@link Builder#personEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#personEntityRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder personEntityRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.personEntityRef(EntityReference)"})
  void testBuilderPersonEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityInvolvementChangeCommand.builder();

    // Act
    Builder actualPersonEntityRefResult =
        builderResult.personEntityRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualPersonEntityRefResult);
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#copyOf(EntityInvolvementChangeCommand)}.
   *
   * <ul>
   *   <li>Then personEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityInvolvementChangeCommand#copyOf(EntityInvolvementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(EntityInvolvementChangeCommand); then personEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityInvolvementChangeCommand ImmutableEntityInvolvementChangeCommand.copyOf(EntityInvolvementChangeCommand)"
  })
  void testCopyOf_thenPersonEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand instance =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityInvolvementChangeCommand actualCopyOfResult =
        ImmutableEntityInvolvementChangeCommand.copyOf(instance);

    // Assert
    EntityReference personEntityRefResult = actualCopyOfResult.personEntityRef();
    assertTrue(personEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", personEntityRefResult.description());
    assertEquals(1, actualCopyOfResult.involvementKindId());
    assertEquals(1L, personEntityRefResult.id());
    assertEquals(EntityKind.ALL, personEntityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, personEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}, and {@link
   * ImmutableEntityInvolvementChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand2 =
        operationResult2
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityInvolvementChangeCommand, immutableEntityInvolvementChangeCommand2);
    assertEquals(
        immutableEntityInvolvementChangeCommand.hashCode(),
        immutableEntityInvolvementChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}, and {@link
   * ImmutableEntityInvolvementChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityInvolvementChangeCommand, immutableEntityInvolvementChangeCommand);
    int expectedHashCodeResult = immutableEntityInvolvementChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityInvolvementChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(2)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableEntityInvolvementChangeCommand,
        operationResult2
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ATTEST);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableEntityInvolvementChangeCommand,
        operationResult2
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder operationResult2 =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        immutableEntityInvolvementChangeCommand,
        operationResult2
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityInvolvementChangeCommand.equals(Object)",
    "int ImmutableEntityInvolvementChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act and Assert
    assertNotEquals(
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableEntityInvolvementChangeCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#toString()}
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#involvementKindId()}
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#operation()}
   *   <li>{@link ImmutableEntityInvolvementChangeCommand#personEntityRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableEntityInvolvementChangeCommand.involvementKindId()",
    "Operation ImmutableEntityInvolvementChangeCommand.operation()",
    "EntityReference ImmutableEntityInvolvementChangeCommand.personEntityRef()",
    "String ImmutableEntityInvolvementChangeCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableEntityInvolvementChangeCommand.toString();
    int actualInvolvementKindIdResult = immutableEntityInvolvementChangeCommand.involvementKindId();
    Operation actualOperationResult = immutableEntityInvolvementChangeCommand.operation();

    // Assert
    assertTrue(
        immutableEntityInvolvementChangeCommand.personEntityRef()
            instanceof ImmutableEntityReference);
    assertEquals(
        "EntityInvolvementChangeCommand{operation=ADD, personEntityRef=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, involvementKindId=1}",
        actualToStringResult);
    assertEquals(1, actualInvolvementKindIdResult);
    assertEquals(Operation.ADD, actualOperationResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOperation(Operation)}
   *   <li>{@link Json#setPersonEntityRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setOperation(Operation)",
    "void Json.setPersonEntityRef(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setOperation(Operation.ADD);
    actualJson.setPersonEntityRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.personEntityRef;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0, actualJson.involvementKindId);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualJson.operation);
    assertFalse(actualJson.involvementKindIdIsSet);
  }

  /**
   * Test Json {@link Json#involvementKindId()}.
   *
   * <p>Method under test: {@link Json#involvementKindId()}
   */
  @Test
  @DisplayName("Test Json involvementKindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.involvementKindId()"})
  void testJsonInvolvementKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().involvementKindId());
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
   * Test Json {@link Json#personEntityRef()}.
   *
   * <p>Method under test: {@link Json#personEntityRef()}
   */
  @Test
  @DisplayName("Test Json personEntityRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.personEntityRef()"})
  void testJsonPersonEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().personEntityRef());
  }

  /**
   * Test Json {@link Json#setInvolvementKindId(int)}.
   *
   * <p>Method under test: {@link Json#setInvolvementKindId(int)}
   */
  @Test
  @DisplayName("Test Json setInvolvementKindId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setInvolvementKindId(int)"})
  void testJsonSetInvolvementKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setInvolvementKindId(1);

    // Assert
    assertEquals(1, json.involvementKindId);
    assertTrue(json.involvementKindIdIsSet);
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#withInvolvementKindId(int)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityInvolvementChangeCommand#withInvolvementKindId(int)}
   */
  @Test
  @DisplayName("Test withInvolvementKindId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityInvolvementChangeCommand ImmutableEntityInvolvementChangeCommand.withInvolvementKindId(int)"
  })
  void testWithInvolvementKindId() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(42)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityInvolvementChangeCommand actualWithInvolvementKindIdResult =
        immutableEntityInvolvementChangeCommand.withInvolvementKindId(42);

    // Assert
    assertSame(immutableEntityInvolvementChangeCommand, actualWithInvolvementKindIdResult);
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#withInvolvementKindId(int)}.
   *
   * <ul>
   *   <li>Then personEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityInvolvementChangeCommand#withInvolvementKindId(int)}
   */
  @Test
  @DisplayName(
      "Test withInvolvementKindId(int); then personEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityInvolvementChangeCommand ImmutableEntityInvolvementChangeCommand.withInvolvementKindId(int)"
  })
  void testWithInvolvementKindId_thenPersonEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);

    // Act
    ImmutableEntityInvolvementChangeCommand actualWithInvolvementKindIdResult =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withInvolvementKindId(42);

    // Assert
    EntityReference personEntityRefResult = actualWithInvolvementKindIdResult.personEntityRef();
    assertTrue(personEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", personEntityRefResult.description());
    assertEquals(1L, personEntityRefResult.id());
    assertEquals(42, actualWithInvolvementKindIdResult.involvementKindId());
    assertEquals(EntityKind.ALL, personEntityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, personEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithInvolvementKindIdResult.operation());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityInvolvementChangeCommand ImmutableEntityInvolvementChangeCommand.withOperation(Operation)"
  })
  void testWithOperation() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityInvolvementChangeCommand actualWithOperationResult =
        immutableEntityInvolvementChangeCommand.withOperation(Operation.ADD);

    // Assert
    assertSame(immutableEntityInvolvementChangeCommand, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#withOperation(Operation)}.
   *
   * <ul>
   *   <li>Then personEntityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityInvolvementChangeCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test withOperation(Operation); then personEntityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityInvolvementChangeCommand ImmutableEntityInvolvementChangeCommand.withOperation(Operation)"
  })
  void testWithOperation_thenPersonEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ATTEST);

    // Act
    ImmutableEntityInvolvementChangeCommand actualWithOperationResult =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withOperation(Operation.ADD);

    // Assert
    EntityReference personEntityRefResult = actualWithOperationResult.personEntityRef();
    assertTrue(personEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", personEntityRefResult.description());
    assertEquals(1, actualWithOperationResult.involvementKindId());
    assertEquals(1L, personEntityRefResult.id());
    assertEquals(EntityKind.ALL, personEntityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, personEntityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
  }

  /**
   * Test {@link ImmutableEntityInvolvementChangeCommand#withPersonEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityInvolvementChangeCommand#withPersonEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withPersonEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityInvolvementChangeCommand ImmutableEntityInvolvementChangeCommand.withPersonEntityRef(EntityReference)"
  })
  void testWithPersonEntityRef() {
    // Arrange
    Builder operationResult =
        ImmutableEntityInvolvementChangeCommand.builder()
            .involvementKindId(1)
            .operation(Operation.ADD);
    ImmutableEntityInvolvementChangeCommand immutableEntityInvolvementChangeCommand =
        operationResult
            .personEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityInvolvementChangeCommand actualWithPersonEntityRefResult =
        immutableEntityInvolvementChangeCommand.withPersonEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityInvolvementChangeCommand, actualWithPersonEntityRefResult);
  }
}
