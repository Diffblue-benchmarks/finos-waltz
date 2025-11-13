package org.finos.waltz.model.permission_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Builder;
import org.finos.waltz.model.permission_group.ImmutableRequiredInvolvementsResult.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRequiredInvolvementsResultDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRequiredInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRequiredInvolvementKindIds(Iterable)"})
  void testBuilderAddAllRequiredInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllRequiredInvolvementKindIdsResult =
        builderResult.addAllRequiredInvolvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllRequiredInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRequiredInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRequiredInvolvementKindIds(Iterable)"})
  void testBuilderAddAllRequiredInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    Builder actualAddAllRequiredInvolvementKindIdsResult =
        builderResult.addAllRequiredInvolvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRequiredInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRequiredInvolvementKindIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRequiredInvolvementKindIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRequiredInvolvementKindIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRequiredInvolvementKindIds(long)"})
  void testBuilderAddRequiredInvolvementKindIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    Builder actualAddRequiredInvolvementKindIdsResult =
        builderResult.addRequiredInvolvementKindIds(1L);

    // Assert
    assertSame(builderResult, actualAddRequiredInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRequiredInvolvementKindIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRequiredInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRequiredInvolvementKindIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRequiredInvolvementKindIds(long[])"})
  void testBuilderAddRequiredInvolvementKindIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    Builder actualAddRequiredInvolvementKindIdsResult =
        builderResult.addRequiredInvolvementKindIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddRequiredInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#areAllUsersAllowed(boolean)}.
   *
   * <p>Method under test: {@link Builder#areAllUsersAllowed(boolean)}
   */
  @Test
  @DisplayName("Test Builder areAllUsersAllowed(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.areAllUsersAllowed(boolean)"})
  void testBuilderAreAllUsersAllowed() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    Builder actualAreAllUsersAllowedResult = builderResult.areAllUsersAllowed(true);

    // Assert
    assertTrue(builderResult.build().areAllUsersAllowed());
    assertSame(builderResult, actualAreAllUsersAllowedResult);
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
  @MethodsUnderTest({"ImmutableRequiredInvolvementsResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableRequiredInvolvementsResult actualImmutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Assert
    assertTrue(actualImmutableRequiredInvolvementsResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(actualImmutableRequiredInvolvementsResult.areAllUsersAllowed());
  }

  /**
   * Test Builder {@link Builder#from(RequiredInvolvementsResult)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName("Test Builder from(RequiredInvolvementsResult); given three; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RequiredInvolvementsResult)"})
  void testBuilderFrom_givenThree_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    Builder builderResult2 = ImmutableRequiredInvolvementsResult.builder();
    builderResult2.addRequiredInvolvementKindIds(3L);
    ImmutableRequiredInvolvementsResult instance = builderResult2.areAllUsersAllowed(true).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRequiredInvolvementsResult actualImmutableRequiredInvolvementsResult =
        builderResult.build();
    assertEquals(instance, actualImmutableRequiredInvolvementsResult);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RequiredInvolvementsResult)}.
   *
   * <ul>
   *   <li>Then return build is builder areAllUsersAllowed {@code false} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RequiredInvolvementsResult); then return build is builder areAllUsersAllowed 'false' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RequiredInvolvementsResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderAreAllUsersAllowedFalseBuild() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    ImmutableRequiredInvolvementsResult instance =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build();

    // Act and Assert
    ImmutableRequiredInvolvementsResult actualImmutableRequiredInvolvementsResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableRequiredInvolvementsResult);
    ImmutableRequiredInvolvementsResult actualImmutableRequiredInvolvementsResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableRequiredInvolvementsResult2);
  }

  /**
   * Test Builder {@link Builder#from(RequiredInvolvementsResult)}.
   *
   * <ul>
   *   <li>Then return build is builder areAllUsersAllowed {@code true} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RequiredInvolvementsResult); then return build is builder areAllUsersAllowed 'true' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RequiredInvolvementsResult)"})
  void testBuilderFrom_thenReturnBuildIsBuilderAreAllUsersAllowedTrueBuild() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    ImmutableRequiredInvolvementsResult instance =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act and Assert
    ImmutableRequiredInvolvementsResult actualImmutableRequiredInvolvementsResult =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableRequiredInvolvementsResult);
    ImmutableRequiredInvolvementsResult actualImmutableRequiredInvolvementsResult2 =
        builderResult.build();
    assertEquals(instance, actualImmutableRequiredInvolvementsResult2);
  }

  /**
   * Test Builder {@link Builder#requiredInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#requiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder requiredInvolvementKindIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.requiredInvolvementKindIds(Iterable)"})
  void testBuilderRequiredInvolvementKindIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualRequiredInvolvementKindIdsResult =
        builderResult.requiredInvolvementKindIds(elements);

    // Assert
    assertSame(builderResult, actualRequiredInvolvementKindIdsResult);
  }

  /**
   * Test Builder {@link Builder#requiredInvolvementKindIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#requiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder requiredInvolvementKindIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.requiredInvolvementKindIds(Iterable)"})
  void testBuilderRequiredInvolvementKindIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();

    // Act
    Builder actualRequiredInvolvementKindIdsResult =
        builderResult.requiredInvolvementKindIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRequiredInvolvementKindIdsResult);
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#copyOf(RequiredInvolvementsResult)}.
   *
   * <ul>
   *   <li>Then return requiredInvolvementKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRequiredInvolvementsResult#copyOf(RequiredInvolvementsResult)}
   */
  @Test
  @DisplayName(
      "Test copyOf(RequiredInvolvementsResult); then return requiredInvolvementKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRequiredInvolvementsResult ImmutableRequiredInvolvementsResult.copyOf(RequiredInvolvementsResult)"
  })
  void testCopyOf_thenReturnRequiredInvolvementKindIdsEmpty() {
    // Arrange
    ImmutableRequiredInvolvementsResult instance =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act
    ImmutableRequiredInvolvementsResult actualCopyOfResult =
        ImmutableRequiredInvolvementsResult.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(actualCopyOfResult.areAllUsersAllowed());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#equals(Object)}, and {@link
   * ImmutableRequiredInvolvementsResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRequiredInvolvementsResult#equals(Object)}
   *   <li>{@link ImmutableRequiredInvolvementsResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.equals(Object)",
    "int ImmutableRequiredInvolvementsResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult2 =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act and Assert
    assertEquals(immutableRequiredInvolvementsResult, immutableRequiredInvolvementsResult2);
    assertEquals(
        immutableRequiredInvolvementsResult.hashCode(),
        immutableRequiredInvolvementsResult2.hashCode());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#equals(Object)}, and {@link
   * ImmutableRequiredInvolvementsResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRequiredInvolvementsResult#equals(Object)}
   *   <li>{@link ImmutableRequiredInvolvementsResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.equals(Object)",
    "int ImmutableRequiredInvolvementsResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act and Assert
    assertEquals(immutableRequiredInvolvementsResult, immutableRequiredInvolvementsResult);
    int expectedHashCodeResult = immutableRequiredInvolvementsResult.hashCode();
    assertEquals(expectedHashCodeResult, immutableRequiredInvolvementsResult.hashCode());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRequiredInvolvementsResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.equals(Object)",
    "int ImmutableRequiredInvolvementsResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRequiredInvolvementsResult.builder();
    builderResult.addRequiredInvolvementKindIds(1L);
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        builderResult.areAllUsersAllowed(true).build();

    // Act and Assert
    assertNotEquals(
        immutableRequiredInvolvementsResult,
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRequiredInvolvementsResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.equals(Object)",
    "int ImmutableRequiredInvolvementsResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(false).build();

    // Act and Assert
    assertNotEquals(
        immutableRequiredInvolvementsResult,
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRequiredInvolvementsResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.equals(Object)",
    "int ImmutableRequiredInvolvementsResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build(), null);
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRequiredInvolvementsResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.equals(Object)",
    "int ImmutableRequiredInvolvementsResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build(),
        "Different type to ImmutableRequiredInvolvementsResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRequiredInvolvementsResult#toString()}
   *   <li>{@link ImmutableRequiredInvolvementsResult#areAllUsersAllowed()}
   *   <li>{@link ImmutableRequiredInvolvementsResult#requiredInvolvementKindIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRequiredInvolvementsResult.areAllUsersAllowed()",
    "Set ImmutableRequiredInvolvementsResult.requiredInvolvementKindIds()",
    "String ImmutableRequiredInvolvementsResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act
    String actualToStringResult = immutableRequiredInvolvementsResult.toString();
    boolean actualAreAllUsersAllowedResult =
        immutableRequiredInvolvementsResult.areAllUsersAllowed();

    // Assert
    assertEquals(
        "RequiredInvolvementsResult{areAllUsersAllowed=true, requiredInvolvementKindIds=[]}",
        actualToStringResult);
    assertTrue(immutableRequiredInvolvementsResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(actualAreAllUsersAllowedResult);
  }

  /**
   * Test Json {@link Json#areAllUsersAllowed()}.
   *
   * <p>Method under test: {@link Json#areAllUsersAllowed()}
   */
  @Test
  @DisplayName("Test Json areAllUsersAllowed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.areAllUsersAllowed()"})
  void testJsonAreAllUsersAllowed() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().areAllUsersAllowed());
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
    Json actualJson = new Json();

    // Assert
    assertFalse(actualJson.areAllUsersAllowed);
    assertFalse(actualJson.areAllUsersAllowedIsSet);
    assertTrue(actualJson.requiredInvolvementKindIds.isEmpty());
  }

  /**
   * Test Json {@link Json#requiredInvolvementKindIds()}.
   *
   * <p>Method under test: {@link Json#requiredInvolvementKindIds()}
   */
  @Test
  @DisplayName("Test Json requiredInvolvementKindIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.requiredInvolvementKindIds()"})
  void testJsonRequiredInvolvementKindIds() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().requiredInvolvementKindIds());
  }

  /**
   * Test Json {@link Json#setAreAllUsersAllowed(boolean)}.
   *
   * <p>Method under test: {@link Json#setAreAllUsersAllowed(boolean)}
   */
  @Test
  @DisplayName("Test Json setAreAllUsersAllowed(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAreAllUsersAllowed(boolean)"})
  void testJsonSetAreAllUsersAllowed() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAreAllUsersAllowed(true);

    // Assert
    assertTrue(json.areAllUsersAllowed);
    assertTrue(json.areAllUsersAllowedIsSet);
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#withAreAllUsersAllowed(boolean)}.
   *
   * <ul>
   *   <li>Then return builder areAllUsersAllowed {@code true} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRequiredInvolvementsResult#withAreAllUsersAllowed(boolean)}
   */
  @Test
  @DisplayName(
      "Test withAreAllUsersAllowed(boolean); then return builder areAllUsersAllowed 'true' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRequiredInvolvementsResult ImmutableRequiredInvolvementsResult.withAreAllUsersAllowed(boolean)"
  })
  void testWithAreAllUsersAllowed_thenReturnBuilderAreAllUsersAllowedTrueBuild() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    // Act
    ImmutableRequiredInvolvementsResult actualWithAreAllUsersAllowedResult =
        immutableRequiredInvolvementsResult.withAreAllUsersAllowed(true);

    // Assert
    assertSame(immutableRequiredInvolvementsResult, actualWithAreAllUsersAllowedResult);
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#withAreAllUsersAllowed(boolean)}.
   *
   * <ul>
   *   <li>Then return requiredInvolvementKindIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRequiredInvolvementsResult#withAreAllUsersAllowed(boolean)}
   */
  @Test
  @DisplayName("Test withAreAllUsersAllowed(boolean); then return requiredInvolvementKindIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRequiredInvolvementsResult ImmutableRequiredInvolvementsResult.withAreAllUsersAllowed(boolean)"
  })
  void testWithAreAllUsersAllowed_thenReturnRequiredInvolvementKindIdsEmpty() {
    // Arrange and Act
    ImmutableRequiredInvolvementsResult actualWithAreAllUsersAllowedResult =
        ImmutableRequiredInvolvementsResult.builder()
            .areAllUsersAllowed(false)
            .build()
            .withAreAllUsersAllowed(true);

    // Assert
    assertTrue(actualWithAreAllUsersAllowedResult.requiredInvolvementKindIds().isEmpty());
    assertTrue(actualWithAreAllUsersAllowedResult.areAllUsersAllowed());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#withRequiredInvolvementKindIds(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>Then return areAllUsersAllowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRequiredInvolvementsResult#withRequiredInvolvementKindIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRequiredInvolvementKindIds(Iterable) with 'Iterable'; then return areAllUsersAllowed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRequiredInvolvementsResult ImmutableRequiredInvolvementsResult.withRequiredInvolvementKindIds(Iterable)"
  })
  void testWithRequiredInvolvementKindIdsWithIterable_thenReturnAreAllUsersAllowed() {
    // Arrange
    ImmutableRequiredInvolvementsResult immutableRequiredInvolvementsResult =
        ImmutableRequiredInvolvementsResult.builder().areAllUsersAllowed(true).build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableRequiredInvolvementsResult actualWithRequiredInvolvementKindIdsResult =
        immutableRequiredInvolvementsResult.withRequiredInvolvementKindIds(elements);

    // Assert
    assertTrue(actualWithRequiredInvolvementKindIdsResult.areAllUsersAllowed());
    assertEquals(elements, actualWithRequiredInvolvementKindIdsResult.requiredInvolvementKindIds());
  }

  /**
   * Test {@link ImmutableRequiredInvolvementsResult#withRequiredInvolvementKindIds(long[])} with
   * {@code long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableRequiredInvolvementsResult#withRequiredInvolvementKindIds(long[])}
   */
  @Test
  @DisplayName("Test withRequiredInvolvementKindIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRequiredInvolvementsResult ImmutableRequiredInvolvementsResult.withRequiredInvolvementKindIds(long[])"
  })
  void testWithRequiredInvolvementKindIdsWithLong() {
    // Arrange and Act
    ImmutableRequiredInvolvementsResult actualWithRequiredInvolvementKindIdsResult =
        ImmutableRequiredInvolvementsResult.builder()
            .areAllUsersAllowed(true)
            .build()
            .withRequiredInvolvementKindIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> requiredInvolvementKindIdsResult =
        actualWithRequiredInvolvementKindIdsResult.requiredInvolvementKindIds();
    assertEquals(2, requiredInvolvementKindIdsResult.size());
    assertTrue(requiredInvolvementKindIdsResult.contains(-1L));
    assertTrue(requiredInvolvementKindIdsResult.contains(1L));
    assertTrue(actualWithRequiredInvolvementKindIdsResult.areAllUsersAllowed());
  }
}
