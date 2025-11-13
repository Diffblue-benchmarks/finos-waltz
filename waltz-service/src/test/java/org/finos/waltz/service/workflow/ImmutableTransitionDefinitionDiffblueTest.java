package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.ImmutableTransitionDefinition.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTransitionDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTransitionDefinition Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableTransitionDefinition actualImmutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Assert
    assertEquals("Initial State", actualImmutableTransitionDefinition.initialState());
    assertEquals("Name", actualImmutableTransitionDefinition.name());
    assertEquals("Predicate", actualImmutableTransitionDefinition.predicate());
    assertEquals("Target State", actualImmutableTransitionDefinition.targetState());
  }

  /**
   * Test Builder {@link Builder#from(TransitionDefinition)}.
   *
   * <p>Method under test: {@link Builder#from(TransitionDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(TransitionDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TransitionDefinition)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableTransitionDefinition.builder();
    ImmutableTransitionDefinition instance =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTransitionDefinition actualImmutableTransitionDefinition = builderResult.build();
    assertEquals(instance, actualImmutableTransitionDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#initialState(String)}.
   *
   * <ul>
   *   <li>When {@code Initial State}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#initialState(String)}
   */
  @Test
  @DisplayName("Test Builder initialState(String); when 'Initial State'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.initialState(String)"})
  void testBuilderInitialState_whenInitialState_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act
    Builder actualInitialStateResult = builderResult.initialState("Initial State");

    // Assert
    assertSame(builderResult, actualInitialStateResult);
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
    Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#predicate(String)}.
   *
   * <ul>
   *   <li>When {@code Predicate}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#predicate(String)}
   */
  @Test
  @DisplayName("Test Builder predicate(String); when 'Predicate'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.predicate(String)"})
  void testBuilderPredicate_whenPredicate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act
    Builder actualPredicateResult = builderResult.predicate("Predicate");

    // Assert
    assertSame(builderResult, actualPredicateResult);
  }

  /**
   * Test Builder {@link Builder#targetState(String)}.
   *
   * <ul>
   *   <li>When {@code Target State}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetState(String)}
   */
  @Test
  @DisplayName("Test Builder targetState(String); when 'Target State'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetState(String)"})
  void testBuilderTargetState_whenTargetState_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableTransitionDefinition.builder();

    // Act
    Builder actualTargetStateResult = builderResult.targetState("Target State");

    // Assert
    assertSame(builderResult, actualTargetStateResult);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#copyOf(TransitionDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Initial State}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#copyOf(TransitionDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(TransitionDefinition); then return 'Initial State'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.copyOf(TransitionDefinition)"
  })
  void testCopyOf_thenReturnInitialState() {
    // Arrange
    ImmutableTransitionDefinition instance =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act
    ImmutableTransitionDefinition actualCopyOfResult =
        ImmutableTransitionDefinition.copyOf(instance);

    // Assert
    assertEquals("Initial State", actualCopyOfResult.initialState());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Predicate", actualCopyOfResult.predicate());
    assertEquals("Target State", actualCopyOfResult.targetState());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}, and {@link
   * ImmutableTransitionDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTransitionDefinition#equals(Object)}
   *   <li>{@link ImmutableTransitionDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();
    ImmutableTransitionDefinition immutableTransitionDefinition2 =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act and Assert
    assertEquals(immutableTransitionDefinition, immutableTransitionDefinition2);
    assertEquals(
        immutableTransitionDefinition.hashCode(), immutableTransitionDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}, and {@link
   * ImmutableTransitionDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTransitionDefinition#equals(Object)}
   *   <li>{@link ImmutableTransitionDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act and Assert
    assertEquals(immutableTransitionDefinition, immutableTransitionDefinition);
    int expectedHashCodeResult = immutableTransitionDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableTransitionDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Name")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTransitionDefinition,
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Predicate")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTransitionDefinition,
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Name")
            .targetState("Target State")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTransitionDefinition,
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTransitionDefinition,
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTransitionDefinition.equals(Object)",
    "int ImmutableTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build(),
        "Different type to ImmutableTransitionDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTransitionDefinition#toString()}
   *   <li>{@link ImmutableTransitionDefinition#initialState()}
   *   <li>{@link ImmutableTransitionDefinition#name()}
   *   <li>{@link ImmutableTransitionDefinition#predicate()}
   *   <li>{@link ImmutableTransitionDefinition#targetState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableTransitionDefinition.initialState()",
    "String ImmutableTransitionDefinition.name()",
    "String ImmutableTransitionDefinition.predicate()",
    "String ImmutableTransitionDefinition.targetState()",
    "String ImmutableTransitionDefinition.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act
    String actualToStringResult = immutableTransitionDefinition.toString();
    String actualInitialStateResult = immutableTransitionDefinition.initialState();
    String actualNameResult = immutableTransitionDefinition.name();
    String actualPredicateResult = immutableTransitionDefinition.predicate();

    // Assert
    assertEquals("Initial State", actualInitialStateResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Predicate", actualPredicateResult);
    assertEquals("Target State", immutableTransitionDefinition.targetState());
    assertEquals(
        "TransitionDefinition{name=Name, predicate=Predicate, initialState=Initial State, targetState=Target"
            + " State}",
        actualToStringResult);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withInitialState(String)}.
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withInitialState(String)}
   */
  @Test
  @DisplayName("Test withInitialState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withInitialState(String)"
  })
  void testWithInitialState() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("42")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act
    ImmutableTransitionDefinition actualWithInitialStateResult =
        immutableTransitionDefinition.withInitialState("42");

    // Assert
    assertSame(immutableTransitionDefinition, actualWithInitialStateResult);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withInitialState(String)}.
   *
   * <ul>
   *   <li>Then return initialState is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withInitialState(String)}
   */
  @Test
  @DisplayName("Test withInitialState(String); then return initialState is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withInitialState(String)"
  })
  void testWithInitialState_thenReturnInitialStateIs42() {
    // Arrange and Act
    ImmutableTransitionDefinition actualWithInitialStateResult =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build()
            .withInitialState("42");

    // Assert
    assertEquals("42", actualWithInitialStateResult.initialState());
    assertEquals("Name", actualWithInitialStateResult.name());
    assertEquals("Predicate", actualWithInitialStateResult.predicate());
    assertEquals("Target State", actualWithInitialStateResult.targetState());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("42")
            .predicate("Predicate")
            .targetState("Target State")
            .build();

    // Act
    ImmutableTransitionDefinition actualWithNameResult =
        immutableTransitionDefinition.withName("42");

    // Assert
    assertSame(immutableTransitionDefinition, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableTransitionDefinition actualWithNameResult =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Initial State", actualWithNameResult.initialState());
    assertEquals("Predicate", actualWithNameResult.predicate());
    assertEquals("Target State", actualWithNameResult.targetState());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withPredicate(String)}.
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withPredicate(String)}
   */
  @Test
  @DisplayName("Test withPredicate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withPredicate(String)"
  })
  void testWithPredicate() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("42")
            .targetState("Target State")
            .build();

    // Act
    ImmutableTransitionDefinition actualWithPredicateResult =
        immutableTransitionDefinition.withPredicate("42");

    // Assert
    assertSame(immutableTransitionDefinition, actualWithPredicateResult);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withPredicate(String)}.
   *
   * <ul>
   *   <li>Then return predicate is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withPredicate(String)}
   */
  @Test
  @DisplayName("Test withPredicate(String); then return predicate is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withPredicate(String)"
  })
  void testWithPredicate_thenReturnPredicateIs42() {
    // Arrange and Act
    ImmutableTransitionDefinition actualWithPredicateResult =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build()
            .withPredicate("42");

    // Assert
    assertEquals("42", actualWithPredicateResult.predicate());
    assertEquals("Initial State", actualWithPredicateResult.initialState());
    assertEquals("Name", actualWithPredicateResult.name());
    assertEquals("Target State", actualWithPredicateResult.targetState());
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withTargetState(String)}.
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withTargetState(String)}
   */
  @Test
  @DisplayName("Test withTargetState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withTargetState(String)"
  })
  void testWithTargetState() {
    // Arrange
    ImmutableTransitionDefinition immutableTransitionDefinition =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("42")
            .build();

    // Act
    ImmutableTransitionDefinition actualWithTargetStateResult =
        immutableTransitionDefinition.withTargetState("42");

    // Assert
    assertSame(immutableTransitionDefinition, actualWithTargetStateResult);
  }

  /**
   * Test {@link ImmutableTransitionDefinition#withTargetState(String)}.
   *
   * <ul>
   *   <li>Then return targetState is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTransitionDefinition#withTargetState(String)}
   */
  @Test
  @DisplayName("Test withTargetState(String); then return targetState is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTransitionDefinition ImmutableTransitionDefinition.withTargetState(String)"
  })
  void testWithTargetState_thenReturnTargetStateIs42() {
    // Arrange and Act
    ImmutableTransitionDefinition actualWithTargetStateResult =
        ImmutableTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate("Predicate")
            .targetState("Target State")
            .build()
            .withTargetState("42");

    // Assert
    assertEquals("42", actualWithTargetStateResult.targetState());
    assertEquals("Initial State", actualWithTargetStateResult.initialState());
    assertEquals("Name", actualWithTargetStateResult.name());
    assertEquals("Predicate", actualWithTargetStateResult.predicate());
  }
}
