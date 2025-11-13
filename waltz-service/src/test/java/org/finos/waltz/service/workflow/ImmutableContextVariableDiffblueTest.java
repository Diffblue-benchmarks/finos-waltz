package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.service.workflow.ImmutableContextVariable.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableContextVariableDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariable Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder<Object> actualBuilderResult = ImmutableContextVariable.builder();
    ImmutableEntityReference entityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableContextVariable<Object> actualImmutableContextVariable =
        actualBuilderResult.entityRef(entityRef).name("Name").value("Value").build();

    // Assert
    assertEquals("Name", actualImmutableContextVariable.name());
    assertEquals("Value", actualImmutableContextVariable.value());
    assertSame(entityRef, actualImmutableContextVariable.entityRef());
  }

  /**
   * Test Builder {@link Builder#entityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityRef(EntityReference)"})
  void testBuilderEntityRef_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act
    Builder<Object> actualEntityRefResult =
        builderResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityRefResult);
  }

  /**
   * Test Builder {@link Builder#from(ContextVariable)}.
   *
   * <p>Method under test: {@link Builder#from(ContextVariable)}
   */
  @Test
  @DisplayName("Test Builder from(ContextVariable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ContextVariable)"})
  void testBuilderFrom() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    Builder<Object> builderResult2 = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> instance =
        builderResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act
    Builder<Object> actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableContextVariable<Object> actualImmutableContextVariable = builderResult.build();
    assertEquals(instance, actualImmutableContextVariable);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act
    Builder<Object> actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#value(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(Object)}
   */
  @Test
  @DisplayName("Test Builder value(Object); when 'Value'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(Object)"})
  void testBuilderValue_whenValue_thenReturnBuilder() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act
    Builder<Object> actualValueResult = builderResult.value("Value");

    // Assert
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link ImmutableContextVariable#copyOf(ContextVariable)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#copyOf(ContextVariable)}
   */
  @Test
  @DisplayName("Test copyOf(ContextVariable); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariable ImmutableContextVariable.copyOf(ContextVariable)"})
  void testCopyOf_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> instance =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act
    ImmutableContextVariable<Object> actualCopyOfResult = ImmutableContextVariable.copyOf(instance);

    // Assert
    EntityReference entityRefResult = actualCopyOfResult.entityRef();
    assertTrue(entityRefResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", entityRefResult.description());
    assertEquals("Value", actualCopyOfResult.value());
    assertEquals(1L, entityRefResult.id());
    assertEquals(EntityKind.ALL, entityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}, and {@link
   * ImmutableContextVariable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariable#equals(Object)}
   *   <li>{@link ImmutableContextVariable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    Builder<Object> builderResult2 = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable2 =
        builderResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act and Assert
    assertEquals(immutableContextVariable, immutableContextVariable2);
    assertEquals(immutableContextVariable.hashCode(), immutableContextVariable2.hashCode());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}, and {@link
   * ImmutableContextVariable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariable#equals(Object)}
   *   <li>{@link ImmutableContextVariable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act and Assert
    assertEquals(immutableContextVariable, immutableContextVariable);
    int expectedHashCodeResult = immutableContextVariable.hashCode();
    assertEquals(expectedHashCodeResult, immutableContextVariable.hashCode());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    Builder<Object> builderResult2 = ImmutableContextVariable.builder();

    // Act and Assert
    assertNotEquals(
        immutableContextVariable,
        builderResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Value")
            .value("Value")
            .build();

    Builder<Object> builderResult2 = ImmutableContextVariable.builder();

    // Act and Assert
    assertNotEquals(
        immutableContextVariable,
        builderResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value(42)
            .build();

    Builder<Object> builderResult2 = ImmutableContextVariable.builder();

    // Act and Assert
    assertNotEquals(
        immutableContextVariable,
        builderResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    Builder<Object> nameResult =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name");

    Builder<Object> builderResult2 = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        nameResult
            .value(
                builderResult2
                    .entityRef(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .name("Name")
                    .value("Value")
                    .build())
            .build();

    Builder<Object> builderResult3 = ImmutableContextVariable.builder();

    // Act and Assert
    assertNotEquals(
        immutableContextVariable,
        builderResult3
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build());
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableContextVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableContextVariable.equals(Object)",
    "int ImmutableContextVariable.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build(),
        "Different type to ImmutableContextVariable");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableContextVariable#toString()}
   *   <li>{@link ImmutableContextVariable#entityRef()}
   *   <li>{@link ImmutableContextVariable#name()}
   *   <li>{@link ImmutableContextVariable#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableContextVariable.entityRef()",
    "String ImmutableContextVariable.name()",
    "String ImmutableContextVariable.toString()",
    "Object ImmutableContextVariable.value()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act
    String actualToStringResult = immutableContextVariable.toString();
    EntityReference actualEntityRefResult = immutableContextVariable.entityRef();
    String actualNameResult = immutableContextVariable.name();

    // Assert
    assertTrue(actualEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "ContextVariable{entityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, name=Name,"
            + " value=Value}",
        actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Value", immutableContextVariable.value());
  }

  /**
   * Test {@link ImmutableContextVariable#withEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableContextVariable#withEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableContextVariable ImmutableContextVariable.withEntityRef(EntityReference)"
  })
  void testWithEntityRef() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act
    ImmutableContextVariable<Object> actualWithEntityRefResult =
        immutableContextVariable.withEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableContextVariable, actualWithEntityRefResult);
  }

  /**
   * Test {@link ImmutableContextVariable#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableContextVariable#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariable ImmutableContextVariable.withName(String)"})
  void testWithName() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("42")
            .value("Value")
            .build();

    // Act
    ImmutableContextVariable<Object> actualWithNameResult = immutableContextVariable.withName("42");

    // Assert
    assertSame(immutableContextVariable, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableContextVariable#withName(String)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariable ImmutableContextVariable.withName(String)"})
  void testWithName_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act
    ImmutableContextVariable<Object> actualWithNameResult =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build()
            .withName("42");

    // Assert
    EntityReference entityRefResult = actualWithNameResult.entityRef();
    assertTrue(entityRefResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", entityRefResult.description());
    assertEquals("Value", actualWithNameResult.value());
    assertEquals(1L, entityRefResult.id());
    assertEquals(EntityKind.ALL, entityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableContextVariable#withValue(Object)}.
   *
   * <p>Method under test: {@link ImmutableContextVariable#withValue(Object)}
   */
  @Test
  @DisplayName("Test withValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariable ImmutableContextVariable.withValue(Object)"})
  void testWithValue() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();
    ImmutableContextVariable<Object> immutableContextVariable =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value("Value")
            .build();

    // Act
    ImmutableContextVariable<Object> actualWithValueResult =
        immutableContextVariable.withValue("Value");

    // Assert
    assertSame(immutableContextVariable, actualWithValueResult);
  }

  /**
   * Test {@link ImmutableContextVariable#withValue(Object)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableContextVariable#withValue(Object)}
   */
  @Test
  @DisplayName("Test withValue(Object); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableContextVariable ImmutableContextVariable.withValue(Object)"})
  void testWithValue_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder<Object> builderResult = ImmutableContextVariable.builder();

    // Act
    ImmutableContextVariable<Object> actualWithValueResult =
        builderResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .value(42)
            .build()
            .withValue("Value");

    // Assert
    EntityReference entityRefResult = actualWithValueResult.entityRef();
    assertTrue(entityRefResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithValueResult.name());
    assertEquals("The characteristics of someone or something", entityRefResult.description());
    assertEquals("Value", actualWithValueResult.value());
    assertEquals(1L, entityRefResult.id());
    assertEquals(EntityKind.ALL, entityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult.entityLifecycleStatus());
  }
}
