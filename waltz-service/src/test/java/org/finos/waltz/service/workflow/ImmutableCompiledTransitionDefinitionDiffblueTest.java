package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.jexl3.JexlExpression;
import org.finos.waltz.service.workflow.ImmutableCompiledTransitionDefinition.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCompiledTransitionDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCompiledTransitionDefinition Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    JexlExpression predicate = mock(JexlExpression.class);

    // Act
    ImmutableCompiledTransitionDefinition actualImmutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(predicate)
            .targetState("Target State")
            .build();

    // Assert
    assertEquals("Initial State", actualImmutableCompiledTransitionDefinition.initialState());
    assertEquals("Name", actualImmutableCompiledTransitionDefinition.name());
    assertEquals("Target State", actualImmutableCompiledTransitionDefinition.targetState());
    assertSame(predicate, actualImmutableCompiledTransitionDefinition.predicate());
  }

  /**
   * Test Builder {@link Builder#from(CompiledTransitionDefinition)}.
   *
   * <p>Method under test: {@link Builder#from(CompiledTransitionDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(CompiledTransitionDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CompiledTransitionDefinition)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();
    ImmutableCompiledTransitionDefinition instance =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCompiledTransitionDefinition actualImmutableCompiledTransitionDefinition =
        builderResult.build();
    assertEquals(instance, actualImmutableCompiledTransitionDefinition);
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
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

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
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#predicate(JexlExpression)}.
   *
   * <p>Method under test: {@link Builder#predicate(JexlExpression)}
   */
  @Test
  @DisplayName("Test Builder predicate(JexlExpression)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.predicate(JexlExpression)"})
  void testBuilderPredicate() {
    // Arrange
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act
    Builder actualPredicateResult = builderResult.predicate(mock(JexlExpression.class));

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
    Builder builderResult = ImmutableCompiledTransitionDefinition.builder();

    // Act
    Builder actualTargetStateResult = builderResult.targetState("Target State");

    // Assert
    assertSame(builderResult, actualTargetStateResult);
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#copyOf(CompiledTransitionDefinition)}.
   *
   * <ul>
   *   <li>Then return {@code Initial State}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableCompiledTransitionDefinition#copyOf(CompiledTransitionDefinition)}
   */
  @Test
  @DisplayName("Test copyOf(CompiledTransitionDefinition); then return 'Initial State'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.copyOf(CompiledTransitionDefinition)"
  })
  void testCopyOf_thenReturnInitialState() {
    // Arrange
    ImmutableCompiledTransitionDefinition instance =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act
    ImmutableCompiledTransitionDefinition actualCopyOfResult =
        ImmutableCompiledTransitionDefinition.copyOf(instance);

    // Assert
    assertEquals("Initial State", actualCopyOfResult.initialState());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Target State", actualCopyOfResult.targetState());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#equals(Object)}, and {@link
   * ImmutableCompiledTransitionDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCompiledTransitionDefinition#equals(Object)}
   *   <li>{@link ImmutableCompiledTransitionDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledTransitionDefinition.equals(Object)",
    "int ImmutableCompiledTransitionDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act and Assert
    assertEquals(immutableCompiledTransitionDefinition, immutableCompiledTransitionDefinition);
    int expectedHashCodeResult = immutableCompiledTransitionDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableCompiledTransitionDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledTransitionDefinition.equals(Object)",
    "int ImmutableCompiledTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCompiledTransitionDefinition,
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledTransitionDefinition.equals(Object)",
    "int ImmutableCompiledTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("initialState")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableCompiledTransitionDefinition,
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledTransitionDefinition.equals(Object)",
    "int ImmutableCompiledTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCompiledTransitionDefinition.equals(Object)",
    "int ImmutableCompiledTransitionDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build(),
        "Different type to ImmutableCompiledTransitionDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCompiledTransitionDefinition#toString()}
   *   <li>{@link ImmutableCompiledTransitionDefinition#initialState()}
   *   <li>{@link ImmutableCompiledTransitionDefinition#name()}
   *   <li>{@link ImmutableCompiledTransitionDefinition#predicate()}
   *   <li>{@link ImmutableCompiledTransitionDefinition#targetState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableCompiledTransitionDefinition.initialState()",
    "String ImmutableCompiledTransitionDefinition.name()",
    "JexlExpression ImmutableCompiledTransitionDefinition.predicate()",
    "String ImmutableCompiledTransitionDefinition.targetState()",
    "String ImmutableCompiledTransitionDefinition.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act
    immutableCompiledTransitionDefinition.toString();
    String actualInitialStateResult = immutableCompiledTransitionDefinition.initialState();
    String actualNameResult = immutableCompiledTransitionDefinition.name();
    immutableCompiledTransitionDefinition.predicate();

    // Assert
    assertEquals("Initial State", actualInitialStateResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Target State", immutableCompiledTransitionDefinition.targetState());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withInitialState(String)}.
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#withInitialState(String)}
   */
  @Test
  @DisplayName("Test withInitialState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withInitialState(String)"
  })
  void testWithInitialState() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("42")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act
    ImmutableCompiledTransitionDefinition actualWithInitialStateResult =
        immutableCompiledTransitionDefinition.withInitialState("42");

    // Assert
    assertSame(immutableCompiledTransitionDefinition, actualWithInitialStateResult);
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withInitialState(String)}.
   *
   * <ul>
   *   <li>Then return initialState is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#withInitialState(String)}
   */
  @Test
  @DisplayName("Test withInitialState(String); then return initialState is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withInitialState(String)"
  })
  void testWithInitialState_thenReturnInitialStateIs42() {
    // Arrange and Act
    ImmutableCompiledTransitionDefinition actualWithInitialStateResult =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build()
            .withInitialState("42");

    // Assert
    assertEquals("42", actualWithInitialStateResult.initialState());
    assertEquals("Name", actualWithInitialStateResult.name());
    assertEquals("Target State", actualWithInitialStateResult.targetState());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("42")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build();

    // Act
    ImmutableCompiledTransitionDefinition actualWithNameResult =
        immutableCompiledTransitionDefinition.withName("42");

    // Assert
    assertSame(immutableCompiledTransitionDefinition, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableCompiledTransitionDefinition actualWithNameResult =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Initial State", actualWithNameResult.initialState());
    assertEquals("Target State", actualWithNameResult.targetState());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withPredicate(JexlExpression)}.
   *
   * <p>Method under test: {@link
   * ImmutableCompiledTransitionDefinition#withPredicate(JexlExpression)}
   */
  @Test
  @DisplayName("Test withPredicate(JexlExpression)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withPredicate(JexlExpression)"
  })
  void testWithPredicate() {
    // Arrange
    JexlExpression value = mock(JexlExpression.class);

    // Act
    ImmutableCompiledTransitionDefinition actualWithPredicateResult =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build()
            .withPredicate(value);

    // Assert
    assertEquals("Initial State", actualWithPredicateResult.initialState());
    assertEquals("Name", actualWithPredicateResult.name());
    assertEquals("Target State", actualWithPredicateResult.targetState());
    assertSame(value, actualWithPredicateResult.predicate());
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withTargetState(String)}.
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#withTargetState(String)}
   */
  @Test
  @DisplayName("Test withTargetState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withTargetState(String)"
  })
  void testWithTargetState() {
    // Arrange
    ImmutableCompiledTransitionDefinition immutableCompiledTransitionDefinition =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("42")
            .build();

    // Act
    ImmutableCompiledTransitionDefinition actualWithTargetStateResult =
        immutableCompiledTransitionDefinition.withTargetState("42");

    // Assert
    assertSame(immutableCompiledTransitionDefinition, actualWithTargetStateResult);
  }

  /**
   * Test {@link ImmutableCompiledTransitionDefinition#withTargetState(String)}.
   *
   * <ul>
   *   <li>Then return targetState is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCompiledTransitionDefinition#withTargetState(String)}
   */
  @Test
  @DisplayName("Test withTargetState(String); then return targetState is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCompiledTransitionDefinition ImmutableCompiledTransitionDefinition.withTargetState(String)"
  })
  void testWithTargetState_thenReturnTargetStateIs42() {
    // Arrange and Act
    ImmutableCompiledTransitionDefinition actualWithTargetStateResult =
        ImmutableCompiledTransitionDefinition.builder()
            .initialState("Initial State")
            .name("Name")
            .predicate(mock(JexlExpression.class))
            .targetState("Target State")
            .build()
            .withTargetState("42");

    // Assert
    assertEquals("42", actualWithTargetStateResult.targetState());
    assertEquals("Initial State", actualWithTargetStateResult.initialState());
    assertEquals("Name", actualWithTargetStateResult.name());
  }
}
