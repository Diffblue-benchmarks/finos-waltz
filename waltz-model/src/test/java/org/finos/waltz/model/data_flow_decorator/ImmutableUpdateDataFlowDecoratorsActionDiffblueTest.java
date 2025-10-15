package org.finos.waltz.model.data_flow_decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.data_flow_decorator.ImmutableUpdateDataFlowDecoratorsAction.Builder;
import org.finos.waltz.model.data_flow_decorator.ImmutableUpdateDataFlowDecoratorsAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDataFlowDecoratorsActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAddedDecorators(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAddedDecorators(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addAddedDecorators(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAddedDecorators(EntityReference)"})
  void testBuilderAddAddedDecoratorsWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddAddedDecoratorsResult =
        builderResult.addAddedDecorators(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddAddedDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addAddedDecorators(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAddedDecorators(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAddedDecorators(EntityReference[]) with 'elements'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAddedDecorators(EntityReference[])"})
  void testBuilderAddAddedDecoratorsWithElements_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddAddedDecoratorsResult =
        builderResult.addAddedDecorators(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddAddedDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAddedDecorators(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAddedDecorators(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAddedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAddedDecorators(Iterable)"})
  void testBuilderAddAllAddedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddAllAddedDecoratorsResult =
        builderResult.addAllAddedDecorators(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAddedDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRemovedDecorators(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRemovedDecorators(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRemovedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRemovedDecorators(Iterable)"})
  void testBuilderAddAllRemovedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddAllRemovedDecoratorsResult =
        builderResult.addAllRemovedDecorators(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRemovedDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovedDecorators(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRemovedDecorators(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addRemovedDecorators(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovedDecorators(EntityReference)"})
  void testBuilderAddRemovedDecoratorsWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddRemovedDecoratorsResult =
        builderResult.addRemovedDecorators(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddRemovedDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovedDecorators(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRemovedDecorators(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRemovedDecorators(EntityReference[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovedDecorators(EntityReference[])"})
  void testBuilderAddRemovedDecoratorsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddRemovedDecoratorsResult =
        builderResult.addRemovedDecorators(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddRemovedDecoratorsResult);
  }

  /**
   * Test Builder {@link Builder#addedDecorators(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addedDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addedDecorators(Iterable)"})
  void testBuilderAddedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualAddedDecoratorsResult = builderResult.addedDecorators(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddedDecoratorsResult);
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
  @MethodsUnderTest({"ImmutableUpdateDataFlowDecoratorsAction Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUpdateDataFlowDecoratorsAction actualImmutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableUpdateDataFlowDecoratorsAction.flowId().longValue());
    assertTrue(actualImmutableUpdateDataFlowDecoratorsAction.addedDecorators().isEmpty());
  }

  /**
   * Test Builder {@link Builder#flowId(Long)}.
   *
   * <p>Method under test: {@link Builder#flowId(Long)}
   */
  @Test
  @DisplayName("Test Builder flowId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowId(Long)"})
  void testBuilderFlowId() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualFlowIdResult = builderResult.flowId(1L);

    // Assert
    assertEquals(1L, builderResult.build().flowId().longValue());
    assertSame(builderResult, actualFlowIdResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataFlowDecoratorsAction)}.
   *
   * <p>Method under test: {@link Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataFlowDecoratorsAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateDataFlowDecoratorsAction)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    Builder builderResult2 = ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult2.addAddedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction instance = builderResult2.flowId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateDataFlowDecoratorsAction actualImmutableUpdateDataFlowDecoratorsAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateDataFlowDecoratorsAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataFlowDecoratorsAction)}.
   *
   * <p>Method under test: {@link Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataFlowDecoratorsAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateDataFlowDecoratorsAction)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    Builder builderResult2 = ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult2.addRemovedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    builderResult2.addAddedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction instance = builderResult2.flowId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateDataFlowDecoratorsAction actualImmutableUpdateDataFlowDecoratorsAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateDataFlowDecoratorsAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataFlowDecoratorsAction)}.
   *
   * <ul>
   *   <li>Then builder build is builder flowId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateDataFlowDecoratorsAction); then builder build is builder flowId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateDataFlowDecoratorsAction)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderFlowIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();
    ImmutableUpdateDataFlowDecoratorsAction instance =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateDataFlowDecoratorsAction actualImmutableUpdateDataFlowDecoratorsAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateDataFlowDecoratorsAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#removedDecorators(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#removedDecorators(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removedDecorators(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.removedDecorators(Iterable)"})
  void testBuilderRemovedDecorators_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();

    // Act
    Builder actualRemovedDecoratorsResult = builderResult.removedDecorators(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRemovedDecoratorsResult);
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#copyOf(UpdateDataFlowDecoratorsAction)}.
   *
   * <ul>
   *   <li>When builder flowId one build.
   *   <li>Then return flowId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataFlowDecoratorsAction#copyOf(UpdateDataFlowDecoratorsAction)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateDataFlowDecoratorsAction); when builder flowId one build; then return flowId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.copyOf(UpdateDataFlowDecoratorsAction)"
  })
  void testCopyOf_whenBuilderFlowIdOneBuild_thenReturnFlowIdLongValueIsOne() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction instance =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualCopyOfResult =
        ImmutableUpdateDataFlowDecoratorsAction.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualCopyOfResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualCopyOfResult.removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}, and {@link
   * ImmutableUpdateDataFlowDecoratorsAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataFlowDecoratorsAction.equals(Object)",
    "int ImmutableUpdateDataFlowDecoratorsAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction2 =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act and Assert
    assertEquals(immutableUpdateDataFlowDecoratorsAction, immutableUpdateDataFlowDecoratorsAction2);
    assertEquals(
        immutableUpdateDataFlowDecoratorsAction.hashCode(),
        immutableUpdateDataFlowDecoratorsAction2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}, and {@link
   * ImmutableUpdateDataFlowDecoratorsAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataFlowDecoratorsAction.equals(Object)",
    "int ImmutableUpdateDataFlowDecoratorsAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act and Assert
    assertEquals(immutableUpdateDataFlowDecoratorsAction, immutableUpdateDataFlowDecoratorsAction);
    int expectedHashCodeResult = immutableUpdateDataFlowDecoratorsAction.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateDataFlowDecoratorsAction.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataFlowDecoratorsAction.equals(Object)",
    "int ImmutableUpdateDataFlowDecoratorsAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult.addAddedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        builderResult.flowId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateDataFlowDecoratorsAction,
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataFlowDecoratorsAction.equals(Object)",
    "int ImmutableUpdateDataFlowDecoratorsAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataFlowDecoratorsAction.builder();
    builderResult.addRemovedDecorators(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        builderResult.flowId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateDataFlowDecoratorsAction,
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataFlowDecoratorsAction.equals(Object)",
    "int ImmutableUpdateDataFlowDecoratorsAction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataFlowDecoratorsAction.equals(Object)",
    "int ImmutableUpdateDataFlowDecoratorsAction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build(),
        "Different type to ImmutableUpdateDataFlowDecoratorsAction");
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AddedDecorators is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AddedDecorators is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAddedDecoratorsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setAddedDecorators(new HashSet<>());
    json.setRemovedDecorators(null);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult =
        ImmutableUpdateDataFlowDecoratorsAction.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualFromJsonResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualFromJsonResult.removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) RemovedDecorators is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) RemovedDecorators is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonRemovedDecoratorsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setAddedDecorators(null);
    json.setRemovedDecorators(new HashSet<>());
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult =
        ImmutableUpdateDataFlowDecoratorsAction.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualFromJsonResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualFromJsonResult.removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return flowId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given one; then return flowId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.fromJson(Json)"
  })
  void testFromJson_givenOne_thenReturnFlowIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setAddedDecorators(null);
    json.setRemovedDecorators(null);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult =
        ImmutableUpdateDataFlowDecoratorsAction.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualFromJsonResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualFromJsonResult.removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return addedDecorators size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return addedDecorators size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.fromJson(Json)"
  })
  void testFromJson_thenReturnAddedDecoratorsSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityReference> addedDecorators = new LinkedHashSet<>();
    addedDecorators.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAddedDecorators(addedDecorators);
    json.setRemovedDecorators(null);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult =
        ImmutableUpdateDataFlowDecoratorsAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.addedDecorators().size());
    assertTrue(actualFromJsonResult.removedDecorators().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removedDecorators is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removedDecorators is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.fromJson(Json)"
  })
  void testFromJson_thenReturnRemovedDecoratorsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<EntityReference> removedDecorators = new LinkedHashSet<>();
    removedDecorators.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    removedDecorators.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAddedDecorators(null);
    json.setRemovedDecorators(removedDecorators);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult =
        ImmutableUpdateDataFlowDecoratorsAction.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.addedDecorators().isEmpty());
    assertEquals(removedDecorators, actualFromJsonResult.removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removedDecorators size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removedDecorators size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.fromJson(Json)"
  })
  void testFromJson_thenReturnRemovedDecoratorsSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityReference> removedDecorators = new LinkedHashSet<>();
    removedDecorators.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAddedDecorators(null);
    json.setRemovedDecorators(removedDecorators);
    json.setFlowId(1L);

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualFromJsonResult =
        ImmutableUpdateDataFlowDecoratorsAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removedDecorators().size());
    assertTrue(actualFromJsonResult.addedDecorators().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#toString()}
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#addedDecorators()}
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#flowId()}
   *   <li>{@link ImmutableUpdateDataFlowDecoratorsAction#removedDecorators()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableUpdateDataFlowDecoratorsAction.addedDecorators()",
    "Long ImmutableUpdateDataFlowDecoratorsAction.flowId()",
    "Set ImmutableUpdateDataFlowDecoratorsAction.removedDecorators()",
    "String ImmutableUpdateDataFlowDecoratorsAction.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act
    String actualToStringResult = immutableUpdateDataFlowDecoratorsAction.toString();
    Set<EntityReference> actualAddedDecoratorsResult =
        immutableUpdateDataFlowDecoratorsAction.addedDecorators();
    Long actualFlowIdResult = immutableUpdateDataFlowDecoratorsAction.flowId();
    Set<EntityReference> actualRemovedDecoratorsResult =
        immutableUpdateDataFlowDecoratorsAction.removedDecorators();

    // Assert
    assertEquals(
        "UpdateDataFlowDecoratorsAction{addedDecorators=[], removedDecorators=[], flowId=1}",
        actualToStringResult);
    assertEquals(1L, actualFlowIdResult.longValue());
    assertTrue(actualAddedDecoratorsResult.isEmpty());
    assertSame(actualAddedDecoratorsResult, actualRemovedDecoratorsResult);
  }

  /**
   * Test Json {@link Json#addedDecorators()}.
   *
   * <p>Method under test: {@link Json#addedDecorators()}
   */
  @Test
  @DisplayName("Test Json addedDecorators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.addedDecorators()"})
  void testJsonAddedDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().addedDecorators());
  }

  /**
   * Test Json {@link Json#flowId()}.
   *
   * <p>Method under test: {@link Json#flowId()}
   */
  @Test
  @DisplayName("Test Json flowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.flowId()"})
  void testJsonFlowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowId());
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
    assertNull(actualJson.flowId);
    assertTrue(actualJson.addedDecorators.isEmpty());
    assertTrue(actualJson.removedDecorators.isEmpty());
  }

  /**
   * Test Json {@link Json#removedDecorators()}.
   *
   * <p>Method under test: {@link Json#removedDecorators()}
   */
  @Test
  @DisplayName("Test Json removedDecorators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.removedDecorators()"})
  void testJsonRemovedDecorators() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#withAddedDecorators(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataFlowDecoratorsAction#withAddedDecorators(EntityReference[])}
   */
  @Test
  @DisplayName("Test withAddedDecorators(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.withAddedDecorators(EntityReference[])"
  })
  void testWithAddedDecoratorsWithEntityReference() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualWithAddedDecoratorsResult =
        immutableUpdateDataFlowDecoratorsAction.withAddedDecorators(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(1, actualWithAddedDecoratorsResult.addedDecorators().size());
    assertEquals(1L, actualWithAddedDecoratorsResult.flowId().longValue());
    assertTrue(actualWithAddedDecoratorsResult.removedDecorators().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#withFlowId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return flowId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#withFlowId(Long)}
   */
  @Test
  @DisplayName("Test withFlowId(Long); when forty-two; then return flowId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.withFlowId(Long)"
  })
  void testWithFlowId_whenFortyTwo_thenReturnFlowIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableUpdateDataFlowDecoratorsAction actualWithFlowIdResult =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build().withFlowId(42L);

    // Assert
    assertEquals(42L, actualWithFlowIdResult.flowId().longValue());
    Set<EntityReference> addedDecoratorsResult = actualWithFlowIdResult.addedDecorators();
    assertTrue(addedDecoratorsResult.isEmpty());
    assertSame(addedDecoratorsResult, actualWithFlowIdResult.removedDecorators());
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#withFlowId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder flowId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataFlowDecoratorsAction#withFlowId(Long)}
   */
  @Test
  @DisplayName("Test withFlowId(Long); when one; then return builder flowId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.withFlowId(Long)"
  })
  void testWithFlowId_whenOne_thenReturnBuilderFlowIdOneBuild() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualWithFlowIdResult =
        immutableUpdateDataFlowDecoratorsAction.withFlowId(1L);

    // Assert
    assertSame(immutableUpdateDataFlowDecoratorsAction, actualWithFlowIdResult);
  }

  /**
   * Test {@link ImmutableUpdateDataFlowDecoratorsAction#withRemovedDecorators(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataFlowDecoratorsAction#withRemovedDecorators(EntityReference[])}
   */
  @Test
  @DisplayName("Test withRemovedDecorators(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataFlowDecoratorsAction ImmutableUpdateDataFlowDecoratorsAction.withRemovedDecorators(EntityReference[])"
  })
  void testWithRemovedDecoratorsWithEntityReference() {
    // Arrange
    ImmutableUpdateDataFlowDecoratorsAction immutableUpdateDataFlowDecoratorsAction =
        ImmutableUpdateDataFlowDecoratorsAction.builder().flowId(1L).build();

    // Act
    ImmutableUpdateDataFlowDecoratorsAction actualWithRemovedDecoratorsResult =
        immutableUpdateDataFlowDecoratorsAction.withRemovedDecorators(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(1, actualWithRemovedDecoratorsResult.removedDecorators().size());
    assertEquals(1L, actualWithRemovedDecoratorsResult.flowId().longValue());
    assertTrue(actualWithRemovedDecoratorsResult.addedDecorators().isEmpty());
  }
}
