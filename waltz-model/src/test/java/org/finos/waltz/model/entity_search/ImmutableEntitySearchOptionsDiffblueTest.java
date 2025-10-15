package org.finos.waltz.model.entity_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntitySearchOptionsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEntityKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityKinds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntityKinds(Iterable)"})
  void testBuilderAddAllEntityKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualAddAllEntityKindsResult = builderResult.addAllEntityKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addAllEntityLifecycleStatuses(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllEntityLifecycleStatuses(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntityLifecycleStatuses(Iterable)"})
  void testBuilderAddAllEntityLifecycleStatuses_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualAddAllEntityLifecycleStatusesResult =
        builderResult.addAllEntityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#addEntityKinds(EntityKind)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addEntityKinds(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder addEntityKinds(EntityKind) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityKinds(EntityKind)"})
  void testBuilderAddEntityKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualAddEntityKindsResult = builderResult.addEntityKinds(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAddEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addEntityKinds(EntityKind[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addEntityKinds(EntityKind[])}
   */
  @Test
  @DisplayName("Test Builder addEntityKinds(EntityKind[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityKinds(EntityKind[])"})
  void testBuilderAddEntityKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualAddEntityKindsResult = builderResult.addEntityKinds(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAddEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder addEntityLifecycleStatuses(EntityLifecycleStatus) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityLifecycleStatuses(EntityLifecycleStatus)"})
  void testBuilderAddEntityLifecycleStatusesWithElement() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualAddEntityLifecycleStatusesResult =
        builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualAddEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  @DisplayName("Test Builder addEntityLifecycleStatuses(EntityLifecycleStatus[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityLifecycleStatuses(EntityLifecycleStatus[])"})
  void testBuilderAddEntityLifecycleStatusesWithElements() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualAddEntityLifecycleStatusesResult =
        builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualAddEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#userId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions Builder.build()",
    "Builder Builder.userId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions actualImmutableEntitySearchOptions =
        actualBuilderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE)
            .addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE)
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableEntitySearchOptions.userId());
    assertEquals("Search Query", actualImmutableEntitySearchOptions.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualImmutableEntitySearchOptions.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(1));
    assertTrue(actualImmutableEntitySearchOptions.entityKinds().isEmpty());
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT,
        actualImmutableEntitySearchOptions.limit());
  }

  /**
   * Test Builder {@link Builder#entityKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityKinds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityKinds(Iterable)"})
  void testBuilderEntityKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualEntityKindsResult = builderResult.entityKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#entityLifecycleStatuses(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityLifecycleStatuses(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityLifecycleStatuses(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityLifecycleStatuses(Iterable)"})
  void testBuilderEntityLifecycleStatuses_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualEntityLifecycleStatusesResult =
        builderResult.entityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEntityLifecycleStatusesResult);
  }

  /**
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions instance =
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act and Assert
    ImmutableEntitySearchOptions actualImmutableEntitySearchOptions =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntitySearchOptions);
  }

  /**
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();
    builderResult2.addEntityKinds(EntityKind.ALL);
    ImmutableEntitySearchOptions instance =
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act and Assert
    ImmutableEntitySearchOptions actualImmutableEntitySearchOptions =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableEntitySearchOptions);
  }

  /**
   * Test Builder {@link Builder#from(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link Builder#from(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test Builder from(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntitySearchOptions)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();
    builderResult2.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult2.addEntityKinds(EntityKind.ALL);
    ImmutableEntitySearchOptions instance =
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntitySearchOptions actualImmutableEntitySearchOptions = builderResult.build();
    assertEquals(instance, actualImmutableEntitySearchOptions);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#limit(int)}.
   *
   * <p>Method under test: {@link Builder#limit(int)}
   */
  @Test
  @DisplayName("Test Builder limit(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.limit(int)"})
  void testBuilderLimit() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualLimitResult = builderResult.limit(1);

    // Assert
    assertSame(builderResult, actualLimitResult);
  }

  /**
   * Test Builder {@link Builder#searchQuery(String)}.
   *
   * <ul>
   *   <li>When {@code Search Query}.
   *   <li>Then builder build searchQuery is {@code Search Query}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#searchQuery(String)}
   */
  @Test
  @DisplayName(
      "Test Builder searchQuery(String); when 'Search Query'; then builder build searchQuery is 'Search Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.searchQuery(String)"})
  void testBuilderSearchQuery_whenSearchQuery_thenBuilderBuildSearchQueryIsSearchQuery() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    Builder actualSearchQueryResult = builderResult.searchQuery("Search Query");

    // Assert
    ImmutableEntitySearchOptions immutableEntitySearchOptions = builderResult.build();
    assertEquals("Search Query", immutableEntitySearchOptions.searchQuery());
    assertEquals("UNKNOWN", immutableEntitySearchOptions.userId());
    assertEquals(2, immutableEntitySearchOptions.entityLifecycleStatuses().size());
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, immutableEntitySearchOptions.limit());
    assertSame(builderResult, actualSearchQueryResult);
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#copyOf(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#copyOf(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test copyOf(EntitySearchOptions); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.copyOf(EntitySearchOptions)"
  })
  void testCopyOf_thenReturnUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions instance =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act
    ImmutableEntitySearchOptions actualCopyOfResult = ImmutableEntitySearchOptions.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("Search Query", actualCopyOfResult.searchQuery());
    List<EntityKind> entityKindsResult = actualCopyOfResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualCopyOfResult.limit());
    assertSame(entityKindsResult, actualCopyOfResult.entityLifecycleStatuses());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#entityLifecycleStatuses()}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ImmutableEntitySearchOptions.entityLifecycleStatuses()"})
  void testEntityLifecycleStatuses() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .entityLifecycleStatuses()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}, and {@link
   * ImmutableEntitySearchOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntitySearchOptions#equals(Object)}
   *   <li>{@link ImmutableEntitySearchOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions2 =
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableEntitySearchOptions, immutableEntitySearchOptions2);
    assertEquals(immutableEntitySearchOptions.hashCode(), immutableEntitySearchOptions2.hashCode());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}, and {@link
   * ImmutableEntitySearchOptions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntitySearchOptions#equals(Object)}
   *   <li>{@link ImmutableEntitySearchOptions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableEntitySearchOptions, immutableEntitySearchOptions);
    int expectedHashCodeResult = immutableEntitySearchOptions.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntitySearchOptions.hashCode());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityKinds(EntityKind.ALL);
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntitySearchOptions,
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntitySearchOptions,
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("42")
            .userId("42")
            .build();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntitySearchOptions,
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("Search Query")
            .build();

    Builder builderResult2 = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntitySearchOptions,
        builderResult2
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntitySearchOptions.equals(Object)",
    "int ImmutableEntitySearchOptions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build(),
        "Different type to ImmutableEntitySearchOptions");
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Json} (default constructor) UserId is {@code 42}.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given '42'; when Json (default constructor) UserId is '42'; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySearchOptions ImmutableEntitySearchOptions.fromJson(Json)"})
  void testFromJson_given42_whenJsonUserIdIs42_thenReturnUserIdIs42() {
    // Arrange
    Json json = new Json();
    json.setUserId("42");
    json.setSearchQuery("searchQuery");

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.userId());
    assertEquals("searchQuery", actualFromJsonResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertTrue(actualFromJsonResult.entityKinds().isEmpty());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualFromJsonResult.limit());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code entityKinds element}.
   *   <li>Then return entityKinds is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'entityKinds element'; then return entityKinds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySearchOptions ImmutableEntitySearchOptions.fromJson(Json)"})
  void testFromJson_givenEntityKindsElement_thenReturnEntityKindsIsArrayList() {
    // Arrange
    ArrayList<EntityKind> entityKinds = new ArrayList<>();
    entityKinds.add(EntityKind.ALL);
    entityKinds.add(EntityKind.ALL);

    Json json = new Json();
    json.setSearchQuery("entityKinds element");
    json.setEntityKinds(entityKinds);

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("entityKinds element", actualFromJsonResult.searchQuery());
    assertEquals(entityKinds, actualFromJsonResult.entityKinds());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code entityKinds element}.
   *   <li>Then return entityKinds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'entityKinds element'; then return entityKinds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySearchOptions ImmutableEntitySearchOptions.fromJson(Json)"})
  void testFromJson_givenEntityKindsElement_thenReturnEntityKindsSizeIsOne() {
    // Arrange
    ArrayList<EntityKind> entityKinds = new ArrayList<>();
    entityKinds.add(EntityKind.ALL);

    Json json = new Json();
    json.setSearchQuery("entityKinds element");
    json.setEntityKinds(entityKinds);

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("entityKinds element", actualFromJsonResult.searchQuery());
    List<EntityKind> entityKindsResult = actualFromJsonResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code searchQuery}.
   *   <li>Then return userId is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'searchQuery'; then return userId is 'UNKNOWN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySearchOptions ImmutableEntitySearchOptions.fromJson(Json)"})
  void testFromJson_givenSearchQuery_thenReturnUserIdIsUnknown() {
    // Arrange
    Json json = new Json();
    json.setSearchQuery("searchQuery");

    // Act
    ImmutableEntitySearchOptions actualFromJsonResult = ImmutableEntitySearchOptions.fromJson(json);

    // Assert
    assertEquals("UNKNOWN", actualFromJsonResult.userId());
    assertEquals("searchQuery", actualFromJsonResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualFromJsonResult.entityLifecycleStatuses();
    assertEquals(2, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusesResult.get(1));
    assertTrue(actualFromJsonResult.entityKinds().isEmpty());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualFromJsonResult.limit());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntitySearchOptions#toString()}
   *   <li>{@link ImmutableEntitySearchOptions#entityKinds()}
   *   <li>{@link ImmutableEntitySearchOptions#searchQuery()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableEntitySearchOptions.entityKinds()",
    "String ImmutableEntitySearchOptions.searchQuery()",
    "String ImmutableEntitySearchOptions.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act
    String actualToStringResult = immutableEntitySearchOptions.toString();
    List<EntityKind> actualEntityKindsResult = immutableEntitySearchOptions.entityKinds();

    // Assert
    assertEquals(
        "EntitySearchOptions{entityKinds=[], searchQuery=Search Query, entityLifecycleStatuses=[], limit=40,"
            + " userId=42}",
        actualToStringResult);
    assertEquals("Search Query", immutableEntitySearchOptions.searchQuery());
    assertTrue(actualEntityKindsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#entityKinds()}.
   *
   * <p>Method under test: {@link Json#entityKinds()}
   */
  @Test
  @DisplayName("Test Json entityKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.entityKinds()"})
  void testJsonEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityKinds());
  }

  /**
   * Test Json {@link Json#entityLifecycleStatuses()}.
   *
   * <p>Method under test: {@link Json#entityLifecycleStatuses()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.entityLifecycleStatuses()"})
  void testJsonEntityLifecycleStatuses() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityLifecycleStatuses());
  }

  /**
   * Test Json {@link Json#limit()}.
   *
   * <p>Method under test: {@link Json#limit()}
   */
  @Test
  @DisplayName("Test Json limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.limit()"})
  void testJsonLimit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().limit());
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
    assertNull(actualJson.searchQuery);
    assertNull(actualJson.userId);
    assertEquals(0, actualJson.limit);
    assertFalse(actualJson.entityLifecycleStatusesIsSet);
    assertFalse(actualJson.limitIsSet);
    assertTrue(actualJson.entityKinds.isEmpty());
    assertTrue(actualJson.entityLifecycleStatuses.isEmpty());
  }

  /**
   * Test Json {@link Json#searchQuery()}.
   *
   * <p>Method under test: {@link Json#searchQuery()}
   */
  @Test
  @DisplayName("Test Json searchQuery()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.searchQuery()"})
  void testJsonSearchQuery() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().searchQuery());
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(new ArrayList<>());

    // Assert
    assertTrue(json.entityLifecycleStatuses.isEmpty());
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEntityLifecycleStatuses(null);

    // Assert
    assertNull(json.entityLifecycleStatuses);
    assertFalse(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsOne() {
    // Arrange
    Json json = new Json();

    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    List<EntityLifecycleStatus> entityLifecycleStatusList = json.entityLifecycleStatuses;
    assertEquals(1, entityLifecycleStatusList.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusList.get(0));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setEntityLifecycleStatuses(List)}.
   *
   * <ul>
   *   <li>Then {@link Json} (default constructor) {@link Json#entityLifecycleStatuses} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Json#setEntityLifecycleStatuses(List)}
   */
  @Test
  @DisplayName(
      "Test Json setEntityLifecycleStatuses(List); then Json (default constructor) entityLifecycleStatuses size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEntityLifecycleStatuses(List)"})
  void testJsonSetEntityLifecycleStatuses_thenJsonEntityLifecycleStatusesSizeIsTwo() {
    // Arrange
    Json json = new Json();

    ArrayList<EntityLifecycleStatus> entityLifecycleStatuses = new ArrayList<>();
    entityLifecycleStatuses.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatuses.add(EntityLifecycleStatus.ACTIVE);

    // Act
    json.setEntityLifecycleStatuses(entityLifecycleStatuses);

    // Assert
    List<EntityLifecycleStatus> entityLifecycleStatusList = json.entityLifecycleStatuses;
    assertEquals(2, entityLifecycleStatusList.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusList.get(1));
    assertEquals(EntityLifecycleStatus.PENDING, entityLifecycleStatusList.get(0));
    assertTrue(json.entityLifecycleStatusesIsSet);
  }

  /**
   * Test Json {@link Json#setLimit(int)}.
   *
   * <p>Method under test: {@link Json#setLimit(int)}
   */
  @Test
  @DisplayName("Test Json setLimit(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setLimit(int)"})
  void testJsonSetLimit() {
    // Arrange
    Json json = new Json();

    // Act
    json.setLimit(1);

    // Assert
    assertEquals(1, json.limit);
    assertTrue(json.limitIsSet);
  }

  /**
   * Test Json {@link Json#userId()}.
   *
   * <p>Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userId());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#limit()}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#limit()}
   */
  @Test
  @DisplayName("Test limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableEntitySearchOptions.limit()"})
  void testLimit() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT,
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .limit());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#userId()}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#userId()}
   */
  @Test
  @DisplayName("Test userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntitySearchOptions.userId()"})
  void testUserId() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act and Assert
    assertEquals(
        "42",
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .userId());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withEntityKinds(EntityKind[])} with {@code
   * EntityKind[]}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withEntityKinds(EntityKind[])}
   */
  @Test
  @DisplayName("Test withEntityKinds(EntityKind[]) with 'EntityKind[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withEntityKinds(EntityKind[])"
  })
  void testWithEntityKindsWithEntityKind() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    ImmutableEntitySearchOptions actualWithEntityKindsResult =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .withEntityKinds(EntityKind.ALL);

    // Assert
    assertEquals("42", actualWithEntityKindsResult.userId());
    assertEquals("Search Query", actualWithEntityKindsResult.searchQuery());
    List<EntityKind> entityKindsResult = actualWithEntityKindsResult.entityKinds();
    assertEquals(1, entityKindsResult.size());
    assertEquals(EntityKind.ALL, entityKindsResult.get(0));
    assertTrue(actualWithEntityKindsResult.entityLifecycleStatuses().isEmpty());
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualWithEntityKindsResult.limit());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withEntityLifecycleStatuses(EntityLifecycleStatus[])}
   * with {@code EntityLifecycleStatus[]}.
   *
   * <p>Method under test: {@link
   * ImmutableEntitySearchOptions#withEntityLifecycleStatuses(EntityLifecycleStatus[])}
   */
  @Test
  @DisplayName(
      "Test withEntityLifecycleStatuses(EntityLifecycleStatus[]) with 'EntityLifecycleStatus[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withEntityLifecycleStatuses(EntityLifecycleStatus[])"
  })
  void testWithEntityLifecycleStatusesWithEntityLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    ImmutableEntitySearchOptions actualWithEntityLifecycleStatusesResult =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .withEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals("42", actualWithEntityLifecycleStatusesResult.userId());
    assertEquals("Search Query", actualWithEntityLifecycleStatusesResult.searchQuery());
    List<EntityLifecycleStatus> entityLifecycleStatusesResult =
        actualWithEntityLifecycleStatusesResult.entityLifecycleStatuses();
    assertEquals(1, entityLifecycleStatusesResult.size());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityLifecycleStatusesResult.get(0));
    assertTrue(actualWithEntityLifecycleStatusesResult.entityKinds().isEmpty());
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT,
        actualWithEntityLifecycleStatusesResult.limit());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withLimit(int)}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withLimit(int)}
   */
  @Test
  @DisplayName("Test withLimit(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withLimit(int)"})
  void testWithLimit() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act
    ImmutableEntitySearchOptions actualWithLimitResult =
        immutableEntitySearchOptions.withLimit(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT);

    // Assert
    assertSame(immutableEntitySearchOptions, actualWithLimitResult);
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withLimit(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withLimit(int)}
   */
  @Test
  @DisplayName("Test withLimit(int); when forty-two; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withLimit(int)"})
  void testWithLimit_whenFortyTwo_thenReturnUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    ImmutableEntitySearchOptions actualWithLimitResult =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .withLimit(42);

    // Assert
    assertEquals("42", actualWithLimitResult.userId());
    assertEquals("Search Query", actualWithLimitResult.searchQuery());
    assertEquals(42, actualWithLimitResult.limit());
    List<EntityKind> entityKindsResult = actualWithLimitResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertSame(entityKindsResult, actualWithLimitResult.entityLifecycleStatuses());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withSearchQuery(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withSearchQuery(String)}
   */
  @Test
  @DisplayName("Test withSearchQuery(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withSearchQuery(String)"
  })
  void testWithSearchQuery() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("42")
            .userId("42")
            .build();

    // Act
    ImmutableEntitySearchOptions actualWithSearchQueryResult =
        immutableEntitySearchOptions.withSearchQuery("42");

    // Assert
    assertSame(immutableEntitySearchOptions, actualWithSearchQueryResult);
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withSearchQuery(String)}.
   *
   * <ul>
   *   <li>Then return searchQuery is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withSearchQuery(String)}
   */
  @Test
  @DisplayName("Test withSearchQuery(String); then return searchQuery is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withSearchQuery(String)"
  })
  void testWithSearchQuery_thenReturnSearchQueryIs42() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    ImmutableEntitySearchOptions actualWithSearchQueryResult =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build()
            .withSearchQuery("42");

    // Assert
    assertEquals("42", actualWithSearchQueryResult.searchQuery());
    assertEquals("42", actualWithSearchQueryResult.userId());
    List<EntityKind> entityKindsResult = actualWithSearchQueryResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertEquals(
        EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualWithSearchQueryResult.limit());
    assertSame(entityKindsResult, actualWithSearchQueryResult.entityLifecycleStatuses());
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withUserId(String)"
  })
  void testWithUserId() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();
    ImmutableEntitySearchOptions immutableEntitySearchOptions =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("42")
            .build();

    // Act
    ImmutableEntitySearchOptions actualWithUserIdResult =
        immutableEntitySearchOptions.withUserId("42");

    // Assert
    assertSame(immutableEntitySearchOptions, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableEntitySearchOptions#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntitySearchOptions#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntitySearchOptions ImmutableEntitySearchOptions.withUserId(String)"
  })
  void testWithUserId_thenReturnUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    ImmutableEntitySearchOptions actualWithUserIdResult =
        builderResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .searchQuery("Search Query")
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals("Search Query", actualWithUserIdResult.searchQuery());
    List<EntityKind> entityKindsResult = actualWithUserIdResult.entityKinds();
    assertTrue(entityKindsResult.isEmpty());
    assertEquals(EntitySearchOptions.DEFAULT_SEARCH_RESULTS_LIMIT, actualWithUserIdResult.limit());
    assertSame(entityKindsResult, actualWithUserIdResult.entityLifecycleStatuses());
  }
}
