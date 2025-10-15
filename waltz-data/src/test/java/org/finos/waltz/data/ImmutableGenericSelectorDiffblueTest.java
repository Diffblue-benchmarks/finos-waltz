package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.data.ImmutableGenericSelector.Builder;
import org.finos.waltz.model.EntityKind;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGenericSelectorDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGenericSelector Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    Select<Record1<Long>> selector = mock(Select.class);

    // Act
    ImmutableGenericSelector actualImmutableGenericSelector =
        ImmutableGenericSelector.builder().kind(EntityKind.ALL).selector(selector).build();

    // Assert
    assertEquals(EntityKind.ALL, actualImmutableGenericSelector.kind());
    assertSame(selector, actualImmutableGenericSelector.selector());
  }

  /**
   * Test Builder {@link Builder#from(GenericSelector)}.
   *
   * <ul>
   *   <li>Then builder build is builder kind {@code ALL} selector {@link Select} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test Builder from(GenericSelector); then builder build is builder kind 'ALL' selector Select build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(GenericSelector)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderKindAllSelectorSelectBuild() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();
    ImmutableGenericSelector instance =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableGenericSelector actualImmutableGenericSelector = builderResult.build();
    assertEquals(instance, actualImmutableGenericSelector);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#selector(Select)}.
   *
   * <p>Method under test: {@link Builder#selector(Select)}
   */
  @Test
  @DisplayName("Test Builder selector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.selector(Select)"})
  void testBuilderSelector() {
    // Arrange
    Builder builderResult = ImmutableGenericSelector.builder();

    // Act
    Builder actualSelectorResult = builderResult.selector(mock(Select.class));

    // Assert
    assertSame(builderResult, actualSelectorResult);
  }

  /**
   * Test {@link ImmutableGenericSelector#copyOf(GenericSelector)}.
   *
   * <ul>
   *   <li>When builder kind {@code ALL} selector {@link Select} build.
   *   <li>Then return kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericSelector#copyOf(GenericSelector)}
   */
  @Test
  @DisplayName(
      "Test copyOf(GenericSelector); when builder kind 'ALL' selector Select build; then return kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGenericSelector ImmutableGenericSelector.copyOf(GenericSelector)"})
  void testCopyOf_whenBuilderKindAllSelectorSelectBuild_thenReturnKindIsAll() {
    // Arrange
    ImmutableGenericSelector instance =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build();

    // Act and Assert
    assertEquals(EntityKind.ALL, ImmutableGenericSelector.copyOf(instance).kind());
  }

  /**
   * Test {@link ImmutableGenericSelector#equals(Object)}, and {@link
   * ImmutableGenericSelector#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGenericSelector#equals(Object)}
   *   <li>{@link ImmutableGenericSelector#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericSelector.equals(Object)",
    "int ImmutableGenericSelector.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableGenericSelector immutableGenericSelector =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build();

    // Act and Assert
    assertEquals(immutableGenericSelector, immutableGenericSelector);
    int expectedHashCodeResult = immutableGenericSelector.hashCode();
    assertEquals(expectedHashCodeResult, immutableGenericSelector.hashCode());
  }

  /**
   * Test {@link ImmutableGenericSelector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericSelector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericSelector.equals(Object)",
    "int ImmutableGenericSelector.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableGenericSelector immutableGenericSelector =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericSelector,
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build());
  }

  /**
   * Test {@link ImmutableGenericSelector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericSelector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericSelector.equals(Object)",
    "int ImmutableGenericSelector.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableGenericSelector#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericSelector#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericSelector.equals(Object)",
    "int ImmutableGenericSelector.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build(),
        "Different type to ImmutableGenericSelector");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGenericSelector#toString()}
   *   <li>{@link ImmutableGenericSelector#kind()}
   *   <li>{@link ImmutableGenericSelector#selector()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableGenericSelector.kind()",
    "Select ImmutableGenericSelector.selector()",
    "java.lang.String ImmutableGenericSelector.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableGenericSelector immutableGenericSelector =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build();

    // Act
    immutableGenericSelector.toString();
    EntityKind actualKindResult = immutableGenericSelector.kind();
    immutableGenericSelector.selector();

    // Assert
    assertEquals(EntityKind.ALL, actualKindResult);
  }

  /**
   * Test {@link ImmutableGenericSelector#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Given builder kind {@code ACTOR} selector {@link Select} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericSelector#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); given builder kind 'ACTOR' selector Select build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGenericSelector ImmutableGenericSelector.withKind(EntityKind)"})
  void testWithKind_givenBuilderKindActorSelectorSelectBuild() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ACTOR)
            .selector(mock(Select.class))
            .build()
            .withKind(EntityKind.ALL)
            .kind());
  }

  /**
   * Test {@link ImmutableGenericSelector#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return builder kind {@code ALL} selector {@link Select} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericSelector#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return builder kind 'ALL' selector Select build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGenericSelector ImmutableGenericSelector.withKind(EntityKind)"})
  void testWithKind_thenReturnBuilderKindAllSelectorSelectBuild() {
    // Arrange
    ImmutableGenericSelector immutableGenericSelector =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build();

    // Act
    ImmutableGenericSelector actualWithKindResult =
        immutableGenericSelector.withKind(EntityKind.ALL);

    // Assert
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertSame(immutableGenericSelector, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableGenericSelector#withSelector(Select)}.
   *
   * <p>Method under test: {@link ImmutableGenericSelector#withSelector(Select)}
   */
  @Test
  @DisplayName("Test withSelector(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGenericSelector ImmutableGenericSelector.withSelector(Select)"})
  void testWithSelector() {
    // Arrange
    Select<Record1<Long>> value = mock(Select.class);

    // Act
    ImmutableGenericSelector actualWithSelectorResult =
        ImmutableGenericSelector.builder()
            .kind(EntityKind.ALL)
            .selector(mock(Select.class))
            .build()
            .withSelector(value);

    // Assert
    assertEquals(EntityKind.ALL, actualWithSelectorResult.kind());
    assertSame(value, actualWithSelectorResult.selector());
  }
}
