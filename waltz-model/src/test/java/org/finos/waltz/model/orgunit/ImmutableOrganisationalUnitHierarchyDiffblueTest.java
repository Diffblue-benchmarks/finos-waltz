package org.finos.waltz.model.orgunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnitHierarchy.Builder;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnitHierarchy.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOrganisationalUnitHierarchyDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllChildren(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChildren(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChildren(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChildren(Iterable)"})
  void testBuilderAddAllChildren_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualAddAllChildrenResult = builderResult.addAllChildren(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChildrenResult);
  }

  /**
   * Test Builder {@link Builder#addAllParents(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllParents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParents(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllParents(Iterable)"})
  void testBuilderAddAllParents_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualAddAllParentsResult = builderResult.addAllParents(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllParentsResult);
  }

  /**
   * Test Builder {@link Builder#addChildren(OrganisationalUnit)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrganisationalUnit.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChildren(OrganisationalUnit)}
   */
  @Test
  @DisplayName(
      "Test Builder addChildren(OrganisationalUnit) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChildren(OrganisationalUnit)"})
  void testBuilderAddChildrenWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualAddChildrenResult =
        builderResult.addChildren(new ImmutableOrganisationalUnit.Json());

    // Assert
    assertSame(builderResult, actualAddChildrenResult);
  }

  /**
   * Test Builder {@link Builder#addChildren(OrganisationalUnit[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrganisationalUnit.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addChildren(OrganisationalUnit[])}
   */
  @Test
  @DisplayName(
      "Test Builder addChildren(OrganisationalUnit[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChildren(OrganisationalUnit[])"})
  void testBuilderAddChildrenWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualAddChildrenResult =
        builderResult.addChildren(new ImmutableOrganisationalUnit.Json());

    // Assert
    assertSame(builderResult, actualAddChildrenResult);
  }

  /**
   * Test Builder {@link Builder#addParents(OrganisationalUnit)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrganisationalUnit.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParents(OrganisationalUnit)}
   */
  @Test
  @DisplayName(
      "Test Builder addParents(OrganisationalUnit) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParents(OrganisationalUnit)"})
  void testBuilderAddParentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualAddParentsResult =
        builderResult.addParents(new ImmutableOrganisationalUnit.Json());

    // Assert
    assertSame(builderResult, actualAddParentsResult);
  }

  /**
   * Test Builder {@link Builder#addParents(OrganisationalUnit[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrganisationalUnit.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParents(OrganisationalUnit[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParents(OrganisationalUnit[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParents(OrganisationalUnit[])"})
  void testBuilderAddParentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualAddParentsResult =
        builderResult.addParents(new ImmutableOrganisationalUnit.Json());

    // Assert
    assertSame(builderResult, actualAddParentsResult);
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
  @MethodsUnderTest({"ImmutableOrganisationalUnitHierarchy Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnit unit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    ImmutableOrganisationalUnitHierarchy actualImmutableOrganisationalUnitHierarchy =
        actualBuilderResult.unit(unit).build();

    // Assert
    assertTrue(actualImmutableOrganisationalUnitHierarchy.children().isEmpty());
    assertSame(unit, actualImmutableOrganisationalUnitHierarchy.unit());
  }

  /**
   * Test Builder {@link Builder#children(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#children(Iterable)}
   */
  @Test
  @DisplayName("Test Builder children(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.children(Iterable)"})
  void testBuilderChildren_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualChildrenResult = builderResult.children(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChildrenResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitHierarchy)}.
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnitHierarchy)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitHierarchy)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    Builder builderResult2 = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy instance =
        builderResult2
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOrganisationalUnitHierarchy actualImmutableOrganisationalUnitHierarchy =
        builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnitHierarchy);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitHierarchy)}.
   *
   * <ul>
   *   <li>Then return build children size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitHierarchy); then return build children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitHierarchy)"})
  void testBuilderFrom_thenReturnBuildChildrenSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    Builder builderResult2 = ImmutableOrganisationalUnitHierarchy.builder();
    builderResult2.addChildren(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    builderResult2.addParents(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    // Act and Assert
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .from(
                builderResult2
                    .unit(
                        ImmutableOrganisationalUnit.builder()
                            .description("The characteristics of someone or something")
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .parentId(1L)
                            .build())
                    .build())
            .build();
    List<OrganisationalUnit> childrenResult = immutableOrganisationalUnitHierarchy.children();
    assertEquals(1, childrenResult.size());
    assertTrue(childrenResult.get(0) instanceof ImmutableOrganisationalUnit);
    assertEquals(childrenResult, immutableOrganisationalUnitHierarchy.parents());
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnitHierarchy)}.
   *
   * <ul>
   *   <li>Then return build parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OrganisationalUnitHierarchy); then return build parents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnitHierarchy)"})
  void testBuilderFrom_thenReturnBuildParentsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    Builder builderResult2 = ImmutableOrganisationalUnitHierarchy.builder();
    builderResult2.addParents(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    // Act and Assert
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .from(
                builderResult2
                    .unit(
                        ImmutableOrganisationalUnit.builder()
                            .description("The characteristics of someone or something")
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .parentId(1L)
                            .build())
                    .build())
            .build();
    List<OrganisationalUnit> parentsResult = immutableOrganisationalUnitHierarchy.parents();
    assertEquals(1, parentsResult.size());
    assertTrue(parentsResult.get(0) instanceof ImmutableOrganisationalUnit);
    assertTrue(immutableOrganisationalUnitHierarchy.children().isEmpty());
  }

  /**
   * Test Builder {@link Builder#parents(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parents(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parents(Iterable)"})
  void testBuilderParents_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act
    Builder actualParentsResult = builderResult.parents(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualParentsResult);
  }

  /**
   * Test Builder {@link Builder#unit(OrganisationalUnit)}.
   *
   * <ul>
   *   <li>When {@link ImmutableOrganisationalUnit.Json} (default constructor).
   *   <li>Then builder build unit is {@link ImmutableOrganisationalUnit.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#unit(OrganisationalUnit)}
   */
  @Test
  @DisplayName(
      "Test Builder unit(OrganisationalUnit); when Json (default constructor); then builder build unit is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.unit(OrganisationalUnit)"})
  void testBuilderUnit_whenJson_thenBuilderBuildUnitIsJson() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnit.Json unit = new ImmutableOrganisationalUnit.Json();

    // Act
    Builder actualUnitResult = builderResult.unit(unit);

    // Assert
    assertSame(unit, builderResult.build().unit());
    assertSame(builderResult, actualUnitResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#copyOf(OrganisationalUnitHierarchy)}.
   *
   * <ul>
   *   <li>Then unit return {@link ImmutableOrganisationalUnit}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOrganisationalUnitHierarchy#copyOf(OrganisationalUnitHierarchy)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OrganisationalUnitHierarchy); then unit return ImmutableOrganisationalUnit")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.copyOf(OrganisationalUnitHierarchy)"
  })
  void testCopyOf_thenUnitReturnImmutableOrganisationalUnit() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy instance =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableOrganisationalUnitHierarchy actualCopyOfResult =
        ImmutableOrganisationalUnitHierarchy.copyOf(instance);

    // Assert
    OrganisationalUnit unitResult = actualCopyOfResult.unit();
    assertTrue(unitResult instanceof ImmutableOrganisationalUnit);
    assertEquals("Name", unitResult.name());
    assertEquals("The characteristics of someone or something", unitResult.description());
    assertEquals(EntityKind.ALL, unitResult.kind());
    List<OrganisationalUnit> childrenResult = actualCopyOfResult.children();
    assertTrue(childrenResult.isEmpty());
    assertSame(childrenResult, actualCopyOfResult.parents());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}, and {@link
   * ImmutableOrganisationalUnitHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#equals(Object)}
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnitHierarchy.equals(Object)",
    "int ImmutableOrganisationalUnitHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy2 =
        builderResult2
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableOrganisationalUnitHierarchy, immutableOrganisationalUnitHierarchy2);
    assertEquals(
        immutableOrganisationalUnitHierarchy.hashCode(),
        immutableOrganisationalUnitHierarchy2.hashCode());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}, and {@link
   * ImmutableOrganisationalUnitHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#equals(Object)}
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnitHierarchy.equals(Object)",
    "int ImmutableOrganisationalUnitHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableOrganisationalUnitHierarchy, immutableOrganisationalUnitHierarchy);
    int expectedHashCodeResult = immutableOrganisationalUnitHierarchy.hashCode();
    assertEquals(expectedHashCodeResult, immutableOrganisationalUnitHierarchy.hashCode());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnitHierarchy.equals(Object)",
    "int ImmutableOrganisationalUnitHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    builderResult.addParents(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnitHierarchy,
        builderResult2
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnitHierarchy.equals(Object)",
    "int ImmutableOrganisationalUnitHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    builderResult.addChildren(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    Builder builderResult2 = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnitHierarchy,
        builderResult2
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnitHierarchy.equals(Object)",
    "int ImmutableOrganisationalUnitHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnitHierarchy.equals(Object)",
    "int ImmutableOrganisationalUnitHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build(),
        "Different type to ImmutableOrganisationalUnitHierarchy");
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return parents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.fromJson(Json)"
  })
  void testFromJson_givenArrayList_thenReturnParentsSizeIsOne() {
    // Arrange
    ArrayList<OrganisationalUnit> parents = new ArrayList<>();
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    parents.add(json);

    Json json2 = new Json();
    json2.setParents(parents);
    json2.setChildren(new ArrayList<>());
    json2.setUnit(new ImmutableOrganisationalUnit.Json());

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult =
        ImmutableOrganisationalUnitHierarchy.fromJson(json2);

    // Assert
    List<OrganisationalUnit> parentsResult = actualFromJsonResult.parents();
    assertEquals(1, parentsResult.size());
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertSame(json, parentsResult.get(0));
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Children is {@code null}.
   *   <li>Then return parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Children is 'null'; then return parents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonChildrenIsNull_thenReturnParentsSizeIsOne() {
    // Arrange
    ArrayList<OrganisationalUnit> parents = new ArrayList<>();
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    parents.add(json);

    Json json2 = new Json();
    json2.setParents(parents);
    json2.setChildren(null);
    json2.setUnit(new ImmutableOrganisationalUnit.Json());

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult =
        ImmutableOrganisationalUnitHierarchy.fromJson(json2);

    // Assert
    List<OrganisationalUnit> parentsResult = actualFromJsonResult.parents();
    assertEquals(1, parentsResult.size());
    assertTrue(actualFromJsonResult.children().isEmpty());
    assertSame(json, parentsResult.get(0));
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Parents is {@code null}.
   *   <li>Then return parents Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Parents is 'null'; then return parents Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonParentsIsNull_thenReturnParentsEmpty() {
    // Arrange
    ArrayList<OrganisationalUnit> children = new ArrayList<>();
    children.add(new ImmutableOrganisationalUnit.Json());

    Json json = new Json();
    json.setParents(null);
    json.setChildren(children);
    json.setUnit(new ImmutableOrganisationalUnit.Json());

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult =
        ImmutableOrganisationalUnitHierarchy.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.parents().isEmpty());
    assertEquals(children, actualFromJsonResult.children());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parents size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parents size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.fromJson(Json)"
  })
  void testFromJson_thenReturnParentsSizeIsTwo() {
    // Arrange
    ArrayList<OrganisationalUnit> parents = new ArrayList<>();
    parents.add(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    ImmutableOrganisationalUnit.Json json = new ImmutableOrganisationalUnit.Json();
    parents.add(json);

    ArrayList<OrganisationalUnit> children = new ArrayList<>();
    children.add(new ImmutableOrganisationalUnit.Json());

    Json json2 = new Json();
    json2.setParents(parents);
    json2.setChildren(children);
    json2.setUnit(new ImmutableOrganisationalUnit.Json());

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult =
        ImmutableOrganisationalUnitHierarchy.fromJson(json2);

    // Assert
    List<OrganisationalUnit> parentsResult = actualFromJsonResult.parents();
    assertEquals(2, parentsResult.size());
    OrganisationalUnit getResult = parentsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertSame(json, parentsResult.get(1));
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Parents is {@link ArrayList#ArrayList()}.
   *   <li>Then return children is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Parents is ArrayList(); then return children is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.fromJson(Json)"
  })
  void testFromJson_whenJsonParentsIsArrayList_thenReturnChildrenIsArrayList() {
    // Arrange
    ArrayList<OrganisationalUnit> parents = new ArrayList<>();
    parents.add(new ImmutableOrganisationalUnit.Json());

    ArrayList<OrganisationalUnit> children = new ArrayList<>();
    children.add(new ImmutableOrganisationalUnit.Json());

    Json json = new Json();
    json.setParents(parents);
    json.setChildren(children);
    json.setUnit(new ImmutableOrganisationalUnit.Json());

    // Act
    ImmutableOrganisationalUnitHierarchy actualFromJsonResult =
        ImmutableOrganisationalUnitHierarchy.fromJson(json);

    // Assert
    assertEquals(children, actualFromJsonResult.children());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#toString()}
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#children()}
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#parents()}
   *   <li>{@link ImmutableOrganisationalUnitHierarchy#unit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableOrganisationalUnitHierarchy.children()",
    "List ImmutableOrganisationalUnitHierarchy.parents()",
    "String ImmutableOrganisationalUnitHierarchy.toString()",
    "OrganisationalUnit ImmutableOrganisationalUnitHierarchy.unit()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableOrganisationalUnitHierarchy.toString();
    List<OrganisationalUnit> actualChildrenResult = immutableOrganisationalUnitHierarchy.children();
    List<OrganisationalUnit> actualParentsResult = immutableOrganisationalUnitHierarchy.parents();

    // Assert
    assertTrue(immutableOrganisationalUnitHierarchy.unit() instanceof ImmutableOrganisationalUnit);
    assertEquals(
        "OrganisationalUnitHierarchy{parents=[], children=[], unit=OrganisationalUnit{id=1, parentId=1, name=Name,"
            + " externalId=42, kind=ALL}}",
        actualToStringResult);
    assertTrue(actualChildrenResult.isEmpty());
    assertSame(actualChildrenResult, actualParentsResult);
  }

  /**
   * Test Json {@link Json#children()}.
   *
   * <p>Method under test: {@link Json#children()}
   */
  @Test
  @DisplayName("Test Json children()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.children()"})
  void testJsonChildren() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().children());
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
    assertNull(actualJson.unit);
    assertTrue(actualJson.children.isEmpty());
    assertTrue(actualJson.parents.isEmpty());
  }

  /**
   * Test Json {@link Json#parents()}.
   *
   * <p>Method under test: {@link Json#parents()}
   */
  @Test
  @DisplayName("Test Json parents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.parents()"})
  void testJsonParents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parents());
  }

  /**
   * Test Json {@link Json#unit()}.
   *
   * <p>Method under test: {@link Json#unit()}
   */
  @Test
  @DisplayName("Test Json unit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrganisationalUnit Json.unit()"})
  void testJsonUnit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().unit());
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#withChildren(OrganisationalUnit[])} with
   * {@code OrganisationalUnit[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOrganisationalUnitHierarchy#withChildren(OrganisationalUnit[])}
   */
  @Test
  @DisplayName("Test withChildren(OrganisationalUnit[]) with 'OrganisationalUnit[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.withChildren(OrganisationalUnit[])"
  })
  void testWithChildrenWithOrganisationalUnit() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableOrganisationalUnitHierarchy actualWithChildrenResult =
        immutableOrganisationalUnitHierarchy.withChildren(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    List<OrganisationalUnit> childrenResult = actualWithChildrenResult.children();
    assertEquals(1, childrenResult.size());
    OrganisationalUnit getResult = childrenResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    OrganisationalUnit unitResult = actualWithChildrenResult.unit();
    assertTrue(unitResult instanceof ImmutableOrganisationalUnit);
    assertEquals("Name", unitResult.name());
    assertEquals("The characteristics of someone or something", unitResult.description());
    assertEquals(EntityKind.ALL, unitResult.kind());
    assertTrue(actualWithChildrenResult.parents().isEmpty());
    assertEquals(unitResult, getResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#withParents(OrganisationalUnit[])} with {@code
   * OrganisationalUnit[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOrganisationalUnitHierarchy#withParents(OrganisationalUnit[])}
   */
  @Test
  @DisplayName("Test withParents(OrganisationalUnit[]) with 'OrganisationalUnit[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.withParents(OrganisationalUnit[])"
  })
  void testWithParentsWithOrganisationalUnit() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableOrganisationalUnitHierarchy actualWithParentsResult =
        immutableOrganisationalUnitHierarchy.withParents(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    List<OrganisationalUnit> parentsResult = actualWithParentsResult.parents();
    assertEquals(1, parentsResult.size());
    OrganisationalUnit getResult = parentsResult.get(0);
    assertTrue(getResult instanceof ImmutableOrganisationalUnit);
    OrganisationalUnit unitResult = actualWithParentsResult.unit();
    assertTrue(unitResult instanceof ImmutableOrganisationalUnit);
    assertEquals("Name", unitResult.name());
    assertEquals("The characteristics of someone or something", unitResult.description());
    assertEquals(EntityKind.ALL, unitResult.kind());
    assertTrue(actualWithParentsResult.children().isEmpty());
    assertEquals(unitResult, getResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnitHierarchy#withUnit(OrganisationalUnit)}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnitHierarchy#withUnit(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test withUnit(OrganisationalUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnitHierarchy ImmutableOrganisationalUnitHierarchy.withUnit(OrganisationalUnit)"
  })
  void testWithUnit() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnitHierarchy.builder();
    ImmutableOrganisationalUnitHierarchy immutableOrganisationalUnitHierarchy =
        builderResult
            .unit(
                ImmutableOrganisationalUnit.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .parentId(1L)
                    .build())
            .build();

    // Act
    ImmutableOrganisationalUnitHierarchy actualWithUnitResult =
        immutableOrganisationalUnitHierarchy.withUnit(
            ImmutableOrganisationalUnit.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());

    // Assert
    assertEquals(immutableOrganisationalUnitHierarchy, actualWithUnitResult);
  }
}
