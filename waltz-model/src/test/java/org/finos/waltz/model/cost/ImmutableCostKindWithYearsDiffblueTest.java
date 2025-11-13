package org.finos.waltz.model.cost;

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
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.cost.ImmutableCostKindWithYears.Builder;
import org.finos.waltz.model.cost.ImmutableCostKindWithYears.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostKindWithYearsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllYears(Iterable)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllYears(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllYears(Iterable); given two; when LinkedHashSet() add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllYears(Iterable)"})
  void testBuilderAddAllYears_givenTwo_whenLinkedHashSetAddTwo() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(2);

    // Act
    Builder actualAddAllYearsResult = builderResult.addAllYears(elements);

    // Assert
    assertSame(builderResult, actualAddAllYearsResult);
  }

  /**
   * Test Builder {@link Builder#addAllYears(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllYears(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllYears(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllYears(Iterable)"})
  void testBuilderAddAllYears_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act
    Builder actualAddAllYearsResult = builderResult.addAllYears(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllYearsResult);
  }

  /**
   * Test Builder {@link Builder#addYears(int)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addYears(int)}
   */
  @Test
  @DisplayName("Test Builder addYears(int) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addYears(int)"})
  void testBuilderAddYearsWithElement() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act
    Builder actualAddYearsResult = builderResult.addYears(2);

    // Assert
    assertSame(builderResult, actualAddYearsResult);
  }

  /**
   * Test Builder {@link Builder#addYears(int[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addYears(int[])}
   */
  @Test
  @DisplayName("Test Builder addYears(int[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addYears(int[])"})
  void testBuilderAddYearsWithElements() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act
    Builder actualAddYearsResult = builderResult.addYears(2, 1, 2, 1);

    // Assert
    assertSame(builderResult, actualAddYearsResult);
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
  @MethodsUnderTest({"ImmutableCostKindWithYears Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableCostKindWithYears.builder();
    ImmutableEntityCostKind costKind =
        ImmutableEntityCostKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableCostKindWithYears actualImmutableCostKindWithYears =
        actualBuilderResult.costKind(costKind).build();

    // Assert
    assertTrue(actualImmutableCostKindWithYears.years().isEmpty());
    assertSame(costKind, actualImmutableCostKindWithYears.costKind());
  }

  /**
   * Test Builder {@link Builder#costKind(EntityCostKind)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityCostKind.Json} (default constructor).
   *   <li>Then builder build costKind is {@link ImmutableEntityCostKind.Json} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#costKind(EntityCostKind)}
   */
  @Test
  @DisplayName(
      "Test Builder costKind(EntityCostKind); when Json (default constructor); then builder build costKind is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.costKind(EntityCostKind)"})
  void testBuilderCostKind_whenJson_thenBuilderBuildCostKindIsJson() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();

    // Act
    Builder actualCostKindResult = builderResult.costKind(costKind);

    // Assert
    assertSame(costKind, builderResult.build().costKind());
    assertSame(builderResult, actualCostKindResult);
  }

  /**
   * Test Builder {@link Builder#from(CostKindWithYears)}.
   *
   * <p>Method under test: {@link Builder#from(CostKindWithYears)}
   */
  @Test
  @DisplayName("Test Builder from(CostKindWithYears)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CostKindWithYears)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    Builder builderResult2 = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears instance =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCostKindWithYears actualImmutableCostKindWithYears = builderResult.build();
    assertEquals(instance, actualImmutableCostKindWithYears);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CostKindWithYears)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When builder addYears two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CostKindWithYears)}
   */
  @Test
  @DisplayName("Test Builder from(CostKindWithYears); given two; when builder addYears two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CostKindWithYears)"})
  void testBuilderFrom_givenTwo_whenBuilderAddYearsTwo() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    Builder builderResult2 = ImmutableCostKindWithYears.builder();
    builderResult2.addYears(2);
    ImmutableCostKindWithYears instance =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableCostKindWithYears actualImmutableCostKindWithYears = builderResult.build();
    assertEquals(instance, actualImmutableCostKindWithYears);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#years(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#years(Iterable)}
   */
  @Test
  @DisplayName("Test Builder years(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.years(Iterable)"})
  void testBuilderYears_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(1);

    // Act
    Builder actualYearsResult = builderResult.years(elements);

    // Assert
    assertSame(builderResult, actualYearsResult);
  }

  /**
   * Test Builder {@link Builder#years(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#years(Iterable)}
   */
  @Test
  @DisplayName("Test Builder years(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.years(Iterable)"})
  void testBuilderYears_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act
    Builder actualYearsResult = builderResult.years(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualYearsResult);
  }

  /**
   * Test {@link ImmutableCostKindWithYears#copyOf(CostKindWithYears)}.
   *
   * <ul>
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#copyOf(CostKindWithYears)}
   */
  @Test
  @DisplayName("Test copyOf(CostKindWithYears); then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostKindWithYears ImmutableCostKindWithYears.copyOf(CostKindWithYears)"
  })
  void testCopyOf_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears instance =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableCostKindWithYears actualCopyOfResult = ImmutableCostKindWithYears.copyOf(instance);

    // Assert
    EntityCostKind costKindResult = actualCopyOfResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(actualCopyOfResult.years().isEmpty());
    assertTrue(costKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#equals(Object)}, and {@link
   * ImmutableCostKindWithYears#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostKindWithYears#equals(Object)}
   *   <li>{@link ImmutableCostKindWithYears#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostKindWithYears.equals(Object)",
    "int ImmutableCostKindWithYears.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears2 =
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableCostKindWithYears, immutableCostKindWithYears2);
    assertEquals(immutableCostKindWithYears.hashCode(), immutableCostKindWithYears2.hashCode());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#equals(Object)}, and {@link
   * ImmutableCostKindWithYears#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostKindWithYears#equals(Object)}
   *   <li>{@link ImmutableCostKindWithYears#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostKindWithYears.equals(Object)",
    "int ImmutableCostKindWithYears.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableCostKindWithYears, immutableCostKindWithYears);
    int expectedHashCodeResult = immutableCostKindWithYears.hashCode();
    assertEquals(expectedHashCodeResult, immutableCostKindWithYears.hashCode());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostKindWithYears.equals(Object)",
    "int ImmutableCostKindWithYears.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    builderResult.addYears(2);
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertNotEquals(
        immutableCostKindWithYears,
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostKindWithYears.equals(Object)",
    "int ImmutableCostKindWithYears.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("Name")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    Builder builderResult2 = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertNotEquals(
        immutableCostKindWithYears,
        builderResult2
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostKindWithYears.equals(Object)",
    "int ImmutableCostKindWithYears.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableCostKindWithYears#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCostKindWithYears.equals(Object)",
    "int ImmutableCostKindWithYears.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build(),
        "Different type to ImmutableCostKindWithYears");
  }

  /**
   * Test {@link ImmutableCostKindWithYears#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.
   *   <li>Then return years size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add one; then return years size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostKindWithYears ImmutableCostKindWithYears.fromJson(Json)"})
  void testFromJson_givenArrayListAddOne_thenReturnYearsSizeIsOne() {
    // Arrange
    ArrayList<Integer> years = new ArrayList<>();
    years.add(1);

    Json json = new Json();
    json.setCostKind(new ImmutableEntityCostKind.Json());
    json.setYears(years);

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    List<Integer> yearsResult = actualFromJsonResult.years();
    assertEquals(1, yearsResult.size());
    assertEquals(1, yearsResult.get(0).intValue());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then return years is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add two; then return years is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostKindWithYears ImmutableCostKindWithYears.fromJson(Json)"})
  void testFromJson_givenArrayListAddTwo_thenReturnYearsIsArrayList() {
    // Arrange
    ArrayList<Integer> years = new ArrayList<>();
    years.add(2);
    years.add(1);

    Json json = new Json();
    json.setCostKind(new ImmutableEntityCostKind.Json());
    json.setYears(years);

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    assertEquals(years, actualFromJsonResult.years());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) Years is {@link ArrayList#ArrayList()}.
   *   <li>Then return years Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) Years is ArrayList(); then return years Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostKindWithYears ImmutableCostKindWithYears.fromJson(Json)"})
  void testFromJson_givenArrayList_whenJsonYearsIsArrayList_thenReturnYearsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();
    json.setCostKind(costKind);
    json.setYears(new ArrayList<>());

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.years().isEmpty());
    assertSame(costKind, actualFromJsonResult.costKind());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Years is {@code null}.
   *   <li>Then return years Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Years is 'null'; then return years Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostKindWithYears ImmutableCostKindWithYears.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonYearsIsNull_thenReturnYearsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableEntityCostKind.Json costKind = new ImmutableEntityCostKind.Json();
    json.setCostKind(costKind);
    json.setYears(null);

    // Act
    ImmutableCostKindWithYears actualFromJsonResult = ImmutableCostKindWithYears.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.years().isEmpty());
    assertSame(costKind, actualFromJsonResult.costKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCostKindWithYears#toString()}
   *   <li>{@link ImmutableCostKindWithYears#costKind()}
   *   <li>{@link ImmutableCostKindWithYears#years()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityCostKind ImmutableCostKindWithYears.costKind()",
    "String ImmutableCostKindWithYears.toString()",
    "List ImmutableCostKindWithYears.years()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableCostKindWithYears.toString();
    EntityCostKind actualCostKindResult = immutableCostKindWithYears.costKind();

    // Assert
    assertTrue(actualCostKindResult instanceof ImmutableEntityCostKind);
    assertEquals(
        "CostKindWithYears{costKind=EntityCostKind{id=1, name=Name, externalId=42, isDefault=true, subjectKind=ALL,"
            + " kind=ALL}, years=[]}",
        actualToStringResult);
    assertTrue(immutableCostKindWithYears.years().isEmpty());
  }

  /**
   * Test Json {@link Json#costKind()}.
   *
   * <p>Method under test: {@link Json#costKind()}
   */
  @Test
  @DisplayName("Test Json costKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityCostKind Json.costKind()"})
  void testJsonCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().costKind());
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
    assertNull(actualJson.costKind);
    assertTrue(actualJson.years.isEmpty());
  }

  /**
   * Test Json {@link Json#years()}.
   *
   * <p>Method under test: {@link Json#years()}
   */
  @Test
  @DisplayName("Test Json years()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.years()"})
  void testJsonYears() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().years());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#withCostKind(EntityCostKind)}.
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#withCostKind(EntityCostKind)}
   */
  @Test
  @DisplayName("Test withCostKind(EntityCostKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCostKindWithYears ImmutableCostKindWithYears.withCostKind(EntityCostKind)"
  })
  void testWithCostKind() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    // Act
    ImmutableCostKindWithYears actualWithCostKindResult =
        immutableCostKindWithYears.withCostKind(
            ImmutableEntityCostKind.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isDefault(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .subjectKind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableCostKindWithYears, actualWithCostKindResult);
  }

  /**
   * Test {@link ImmutableCostKindWithYears#withYears(int[])} with {@code int[]}.
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#withYears(int[])}
   */
  @Test
  @DisplayName("Test withYears(int[]) with 'int[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostKindWithYears ImmutableCostKindWithYears.withYears(int[])"})
  void testWithYearsWithInt() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();

    // Act
    ImmutableCostKindWithYears actualWithYearsResult =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build()
            .withYears(1, 0, 1, 0);

    // Assert
    EntityCostKind costKindResult = actualWithYearsResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    List<Integer> yearsResult = actualWithYearsResult.years();
    assertEquals(4, yearsResult.size());
    assertEquals(0, yearsResult.get(1).intValue());
    assertEquals(0, yearsResult.get(3).intValue());
    assertEquals(1, yearsResult.get(0).intValue());
    assertEquals(1, yearsResult.get(2).intValue());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(costKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableCostKindWithYears#withYears(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then costKind return {@link ImmutableEntityCostKind}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCostKindWithYears#withYears(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withYears(Iterable) with 'Iterable'; given one; then costKind return ImmutableEntityCostKind")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCostKindWithYears ImmutableCostKindWithYears.withYears(Iterable)"})
  void testWithYearsWithIterable_givenOne_thenCostKindReturnImmutableEntityCostKind() {
    // Arrange
    Builder builderResult = ImmutableCostKindWithYears.builder();
    ImmutableCostKindWithYears immutableCostKindWithYears =
        builderResult
            .costKind(
                ImmutableEntityCostKind.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isDefault(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build();

    LinkedHashSet<Integer> elements = new LinkedHashSet<>();
    elements.add(1);

    // Act
    ImmutableCostKindWithYears actualWithYearsResult =
        immutableCostKindWithYears.withYears(elements);

    // Assert
    EntityCostKind costKindResult = actualWithYearsResult.costKind();
    assertTrue(costKindResult instanceof ImmutableEntityCostKind);
    assertEquals("Name", costKindResult.name());
    assertEquals("The characteristics of someone or something", costKindResult.description());
    List<Integer> yearsResult = actualWithYearsResult.years();
    assertEquals(1, yearsResult.size());
    assertEquals(1, yearsResult.get(0).intValue());
    assertEquals(EntityKind.ALL, costKindResult.kind());
    assertEquals(EntityKind.ALL, costKindResult.subjectKind());
    assertTrue(costKindResult.isDefault());
  }
}
