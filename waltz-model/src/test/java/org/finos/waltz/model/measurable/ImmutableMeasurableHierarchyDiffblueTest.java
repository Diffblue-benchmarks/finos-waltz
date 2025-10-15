package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchy.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchy.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableHierarchyDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllParents(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllParents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllParents(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllParents(Iterable)"})
  void testBuilderAddAllParents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    Builder actualAddAllParentsResult = builderResult.addAllParents(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllParentsResult);
  }

  /**
   * Test Builder {@link Builder#addParents(MeasurableHierarchyAlignment)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableHierarchyAlignment.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParents(MeasurableHierarchyAlignment)}
   */
  @Test
  @DisplayName(
      "Test Builder addParents(MeasurableHierarchyAlignment) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParents(MeasurableHierarchyAlignment)"})
  void testBuilderAddParentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    Builder actualAddParentsResult =
        builderResult.addParents(new ImmutableMeasurableHierarchyAlignment.Json());

    // Assert
    assertSame(builderResult, actualAddParentsResult);
  }

  /**
   * Test Builder {@link Builder#addParents(MeasurableHierarchyAlignment[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableHierarchyAlignment.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addParents(MeasurableHierarchyAlignment[])}
   */
  @Test
  @DisplayName(
      "Test Builder addParents(MeasurableHierarchyAlignment[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addParents(MeasurableHierarchyAlignment[])"})
  void testBuilderAddParentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    Builder actualAddParentsResult =
        builderResult.addParents(new ImmutableMeasurableHierarchyAlignment.Json());

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
  @MethodsUnderTest({"ImmutableMeasurableHierarchy Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableHierarchy actualImmutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Assert
    assertEquals(1, actualImmutableMeasurableHierarchy.maxDepth().intValue());
    assertEquals(1L, actualImmutableMeasurableHierarchy.measurableId().longValue());
    assertTrue(actualImmutableMeasurableHierarchy.parents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableHierarchy)}.
   *
   * <ul>
   *   <li>Then builder build is builder measurableId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableHierarchy)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableHierarchy); then builder build is builder measurableId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchy)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderMeasurableIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    Builder builderResult2 = ImmutableMeasurableHierarchy.builder();

    ImmutableMeasurableHierarchyAlignment.Builder levelResult =
        ImmutableMeasurableHierarchyAlignment.builder().level(1);
    builderResult2.addParents(
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableMeasurableHierarchy instance = builderResult2.measurableId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableHierarchy actualImmutableMeasurableHierarchy = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableHierarchy);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableHierarchy)}.
   *
   * <ul>
   *   <li>Then return build is builder measurableId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableHierarchy)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableHierarchy); then return build is builder measurableId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchy)"})
  void testBuilderFrom_thenReturnBuildIsBuilderMeasurableIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();
    ImmutableMeasurableHierarchy instance =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Act and Assert
    ImmutableMeasurableHierarchy actualImmutableMeasurableHierarchy =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableHierarchy);
  }

  /**
   * Test Builder {@link Builder#measurableId(Long)}.
   *
   * <p>Method under test: {@link Builder#measurableId(Long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableId(Long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    Builder actualMeasurableIdResult = builderResult.measurableId(1L);

    // Assert
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy = builderResult.build();
    assertEquals(1, immutableMeasurableHierarchy.maxDepth().intValue());
    assertEquals(1L, immutableMeasurableHierarchy.measurableId().longValue());
    assertSame(builderResult, actualMeasurableIdResult);
  }

  /**
   * Test Builder {@link Builder#parents(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parents(Iterable)}
   */
  @Test
  @DisplayName("Test Builder parents(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parents(Iterable)"})
  void testBuilderParents_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    Builder actualParentsResult = builderResult.parents(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualParentsResult);
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#copyOf(MeasurableHierarchy)}.
   *
   * <ul>
   *   <li>When builder measurableId one build.
   *   <li>Then return maxDepth intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#copyOf(MeasurableHierarchy)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableHierarchy); when builder measurableId one build; then return maxDepth intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.copyOf(MeasurableHierarchy)"
  })
  void testCopyOf_whenBuilderMeasurableIdOneBuild_thenReturnMaxDepthIntValueIsOne() {
    // Arrange
    ImmutableMeasurableHierarchy instance =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Act
    ImmutableMeasurableHierarchy actualCopyOfResult = ImmutableMeasurableHierarchy.copyOf(instance);

    // Assert
    assertEquals(1, actualCopyOfResult.maxDepth().intValue());
    assertEquals(1L, actualCopyOfResult.measurableId().longValue());
    assertTrue(actualCopyOfResult.parents().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#equals(Object)}, and {@link
   * ImmutableMeasurableHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableHierarchy#equals(Object)}
   *   <li>{@link ImmutableMeasurableHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchy.equals(Object)",
    "int ImmutableMeasurableHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy2 =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Act and Assert
    assertEquals(immutableMeasurableHierarchy, immutableMeasurableHierarchy2);
    assertEquals(immutableMeasurableHierarchy.hashCode(), immutableMeasurableHierarchy2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#equals(Object)}, and {@link
   * ImmutableMeasurableHierarchy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableHierarchy#equals(Object)}
   *   <li>{@link ImmutableMeasurableHierarchy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchy.equals(Object)",
    "int ImmutableMeasurableHierarchy.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Act and Assert
    assertEquals(immutableMeasurableHierarchy, immutableMeasurableHierarchy);
    int expectedHashCodeResult = immutableMeasurableHierarchy.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableHierarchy.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchy.equals(Object)",
    "int ImmutableMeasurableHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchy.builder();

    ImmutableMeasurableHierarchyAlignment.Builder levelResult =
        ImmutableMeasurableHierarchyAlignment.builder().level(1);
    builderResult.addParents(
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        builderResult.measurableId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableHierarchy,
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchy.equals(Object)",
    "int ImmutableMeasurableHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableHierarchy,
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchy.equals(Object)",
    "int ImmutableMeasurableHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableMeasurableHierarchy.builder().measurableId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchy.equals(Object)",
    "int ImmutableMeasurableHierarchy.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build(),
        "Different type to ImmutableMeasurableHierarchy");
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Parents is {@link HashSet#HashSet()}.
   *   <li>Then return parents Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Parents is HashSet(); then return parents Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonParentsIsHashSet_thenReturnParentsEmpty() {
    // Arrange
    Json json = new Json();
    json.setMeasurableId(1L);
    json.setParents(new HashSet<>());

    // Act
    ImmutableMeasurableHierarchy actualFromJsonResult = ImmutableMeasurableHierarchy.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.maxDepth().intValue());
    assertEquals(1L, actualFromJsonResult.measurableId().longValue());
    assertTrue(actualFromJsonResult.parents().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Parents is {@code null}.
   *   <li>Then return parents Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Parents is 'null'; then return parents Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonParentsIsNull_thenReturnParentsEmpty() {
    // Arrange
    Json json = new Json();
    json.setMeasurableId(1L);
    json.setParents(null);

    // Act
    ImmutableMeasurableHierarchy actualFromJsonResult = ImmutableMeasurableHierarchy.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.maxDepth().intValue());
    assertEquals(1L, actualFromJsonResult.measurableId().longValue());
    assertTrue(actualFromJsonResult.parents().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parents is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parents is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.fromJson(Json)"})
  void testFromJson_thenReturnParentsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<MeasurableHierarchyAlignment> parents = new LinkedHashSet<>();

    ImmutableMeasurableHierarchyAlignment.Builder levelResult =
        ImmutableMeasurableHierarchyAlignment.builder().level(-1);
    parents.add(
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    ImmutableMeasurableHierarchyAlignment.Builder levelResult2 =
        ImmutableMeasurableHierarchyAlignment.builder().level(1);
    parents.add(
        levelResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Json json = new Json();
    json.setMeasurableId(1L);
    json.setParents(parents);

    // Act
    ImmutableMeasurableHierarchy actualFromJsonResult = ImmutableMeasurableHierarchy.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.maxDepth().intValue());
    assertEquals(1L, actualFromJsonResult.measurableId().longValue());
    assertEquals(parents, actualFromJsonResult.parents());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return parents size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return parents size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.fromJson(Json)"})
  void testFromJson_thenReturnParentsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableHierarchyAlignment> parents = new LinkedHashSet<>();

    ImmutableMeasurableHierarchyAlignment.Builder levelResult =
        ImmutableMeasurableHierarchyAlignment.builder().level(1);
    parents.add(
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    Json json = new Json();
    json.setMeasurableId(1L);
    json.setParents(parents);

    // Act
    ImmutableMeasurableHierarchy actualFromJsonResult = ImmutableMeasurableHierarchy.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.maxDepth().intValue());
    assertEquals(1, actualFromJsonResult.parents().size());
    assertEquals(1L, actualFromJsonResult.measurableId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableHierarchy#toString()}
   *   <li>{@link ImmutableMeasurableHierarchy#maxDepth()}
   *   <li>{@link ImmutableMeasurableHierarchy#measurableId()}
   *   <li>{@link ImmutableMeasurableHierarchy#parents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableMeasurableHierarchy.maxDepth()",
    "Long ImmutableMeasurableHierarchy.measurableId()",
    "Set ImmutableMeasurableHierarchy.parents()",
    "String ImmutableMeasurableHierarchy.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Act
    String actualToStringResult = immutableMeasurableHierarchy.toString();
    Integer actualMaxDepthResult = immutableMeasurableHierarchy.maxDepth();
    Long actualMeasurableIdResult = immutableMeasurableHierarchy.measurableId();
    Set<MeasurableHierarchyAlignment> actualParentsResult = immutableMeasurableHierarchy.parents();

    // Assert
    assertEquals(
        "MeasurableHierarchy{measurableId=1, parents=[], maxDepth=1}", actualToStringResult);
    assertEquals(1, actualMaxDepthResult.intValue());
    assertEquals(1L, actualMeasurableIdResult.longValue());
    assertTrue(actualParentsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#maxDepth()}.
   *
   * <p>Method under test: {@link Json#maxDepth()}
   */
  @Test
  @DisplayName("Test Json maxDepth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.maxDepth()"})
  void testJsonMaxDepth() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().maxDepth());
  }

  /**
   * Test Json {@link Json#measurableId()}.
   *
   * <p>Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableId());
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
    assertNull(actualJson.measurableId);
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
  @MethodsUnderTest({"Set Json.parents()"})
  void testJsonParents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parents());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#withMeasurableId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return maxDepth intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#withMeasurableId(Long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(Long); when forty-two; then return maxDepth intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.withMeasurableId(Long)"
  })
  void testWithMeasurableId_whenFortyTwo_thenReturnMaxDepthIntValueIsOne() {
    // Arrange and Act
    ImmutableMeasurableHierarchy actualWithMeasurableIdResult =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build().withMeasurableId(42L);

    // Assert
    assertEquals(1, actualWithMeasurableIdResult.maxDepth().intValue());
    assertEquals(42L, actualWithMeasurableIdResult.measurableId().longValue());
    assertTrue(actualWithMeasurableIdResult.parents().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#withMeasurableId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder measurableId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchy#withMeasurableId(Long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(Long); when one; then return builder measurableId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.withMeasurableId(Long)"
  })
  void testWithMeasurableId_whenOne_thenReturnBuilderMeasurableIdOneBuild() {
    // Arrange
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    // Act
    ImmutableMeasurableHierarchy actualWithMeasurableIdResult =
        immutableMeasurableHierarchy.withMeasurableId(1L);

    // Assert
    assertSame(immutableMeasurableHierarchy, actualWithMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableHierarchy#withParents(MeasurableHierarchyAlignment[])} with
   * {@code MeasurableHierarchyAlignment[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableHierarchy#withParents(MeasurableHierarchyAlignment[])}
   */
  @Test
  @DisplayName(
      "Test withParents(MeasurableHierarchyAlignment[]) with 'MeasurableHierarchyAlignment[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchy ImmutableMeasurableHierarchy.withParents(MeasurableHierarchyAlignment[])"
  })
  void testWithParentsWithMeasurableHierarchyAlignment() {
    // Arrange
    ImmutableMeasurableHierarchy immutableMeasurableHierarchy =
        ImmutableMeasurableHierarchy.builder().measurableId(1L).build();

    ImmutableMeasurableHierarchyAlignment.Builder levelResult =
        ImmutableMeasurableHierarchyAlignment.builder().level(1);

    // Act
    ImmutableMeasurableHierarchy actualWithParentsResult =
        immutableMeasurableHierarchy.withParents(
            levelResult
                .parentReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Assert
    assertEquals(1, actualWithParentsResult.maxDepth().intValue());
    assertEquals(1, actualWithParentsResult.parents().size());
    assertEquals(1L, actualWithParentsResult.measurableId().longValue());
  }
}
