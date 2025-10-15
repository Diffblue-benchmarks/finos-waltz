package org.finos.waltz.web.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.web.action.ImmutableUpdateAppCapabilitiesAction.Builder;
import org.finos.waltz.web.action.ImmutableUpdateAppCapabilitiesAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateAppCapabilitiesActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAdditions(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build additions size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAdditions(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addAdditions(EntityReference) with 'element'; then builder build additions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAdditions(EntityReference)"})
  void testBuilderAddAdditionsWithElement_thenBuilderBuildAdditionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    EntityReference element = mock(EntityReference.class);

    // Act
    Builder actualAddAdditionsResult = builderResult.addAdditions(element);

    // Assert
    List<EntityReference> additionsResult = builderResult.build().additions();
    assertEquals(1, additionsResult.size());
    assertSame(builderResult, actualAddAdditionsResult);
    assertSame(element, additionsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addAdditions(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build additions size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAdditions(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAdditions(EntityReference[]) with 'elements'; then builder build additions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAdditions(EntityReference[])"})
  void testBuilderAddAdditionsWithElements_thenBuilderBuildAdditionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAddAdditionsResult = builderResult.addAdditions(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().additions().size());
    assertSame(builderResult, actualAddAdditionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAdditions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAdditions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAdditions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAdditions(Iterable)"})
  void testBuilderAddAllAdditions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAddAllAdditionsResult = builderResult.addAllAdditions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAdditionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRemovals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRemovals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovals(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRemovals(Iterable)"})
  void testBuilderAddAllRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAddAllRemovalsResult = builderResult.addAllRemovals(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovals(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>Then builder build removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRemovals(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addRemovals(EntityReference) with 'element'; then builder build removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovals(EntityReference)"})
  void testBuilderAddRemovalsWithElement_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    EntityReference element = mock(EntityReference.class);

    // Act
    Builder actualAddRemovalsResult = builderResult.addRemovals(element);

    // Assert
    List<EntityReference> removalsResult = builderResult.build().removals();
    assertEquals(1, removalsResult.size());
    assertSame(builderResult, actualAddRemovalsResult);
    assertSame(element, removalsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#addRemovals(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then builder build removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRemovals(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRemovals(EntityReference[]) with 'elements'; then builder build removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovals(EntityReference[])"})
  void testBuilderAddRemovalsWithElements_thenBuilderBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAddRemovalsResult = builderResult.addRemovals(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().removals().size());
    assertSame(builderResult, actualAddRemovalsResult);
  }

  /**
   * Test Builder {@link Builder#additions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#additions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder additions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.additions(Iterable)"})
  void testBuilderAdditions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualAdditionsResult = builderResult.additions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAdditionsResult);
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
  @MethodsUnderTest({"ImmutableUpdateAppCapabilitiesAction Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableUpdateAppCapabilitiesAction.builder().build().additions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(UpdateAppCapabilitiesAction)}.
   *
   * <ul>
   *   <li>Then return build removals Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateAppCapabilitiesAction); then return build removals Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateAppCapabilitiesAction)"})
  void testBuilderFrom_thenReturnBuildRemovalsEmpty() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    Builder builderResult2 = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult2.addAdditions(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateAppCapabilitiesAction instance = builderResult2.build();

    // Act and Assert
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        builderResult.from(instance).build();
    List<EntityReference> additionsResult = immutableUpdateAppCapabilitiesAction.additions();
    assertEquals(1, additionsResult.size());
    EntityReference getResult = additionsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(immutableUpdateAppCapabilitiesAction.removals().isEmpty());
    ImmutableUpdateAppCapabilitiesAction actualImmutableUpdateAppCapabilitiesAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateAppCapabilitiesAction);
  }

  /**
   * Test Builder {@link Builder#from(UpdateAppCapabilitiesAction)}.
   *
   * <ul>
   *   <li>Then return build removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateAppCapabilitiesAction); then return build removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateAppCapabilitiesAction)"})
  void testBuilderFrom_thenReturnBuildRemovalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    Builder builderResult2 = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult2.addRemovals(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    builderResult2.addAdditions(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableUpdateAppCapabilitiesAction instance = builderResult2.build();

    // Act and Assert
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        builderResult.from(instance).build();
    List<EntityReference> additionsResult = immutableUpdateAppCapabilitiesAction.additions();
    assertEquals(1, additionsResult.size());
    EntityReference getResult = additionsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    List<EntityReference> removalsResult = immutableUpdateAppCapabilitiesAction.removals();
    assertEquals(1, removalsResult.size());
    assertTrue(removalsResult.get(0) instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    ImmutableUpdateAppCapabilitiesAction actualImmutableUpdateAppCapabilitiesAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateAppCapabilitiesAction);
  }

  /**
   * Test Builder {@link Builder#from(UpdateAppCapabilitiesAction)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateAppCapabilitiesAction); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateAppCapabilitiesAction)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    ImmutableUpdateAppCapabilitiesAction instance =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateAppCapabilitiesAction actualImmutableUpdateAppCapabilitiesAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateAppCapabilitiesAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#removals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#removals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removals(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.removals(Iterable)"})
  void testBuilderRemovals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();

    // Act
    Builder actualRemovalsResult = builderResult.removals(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRemovalsResult);
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return additions Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUpdateAppCapabilitiesAction#copyOf(UpdateAppCapabilitiesAction)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateAppCapabilitiesAction); when builder build; then return additions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.copyOf(UpdateAppCapabilitiesAction)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnAdditionsEmpty() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction instance =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualCopyOfResult =
        ImmutableUpdateAppCapabilitiesAction.copyOf(instance);

    // Assert
    List<EntityReference> additionsResult = actualCopyOfResult.additions();
    assertTrue(additionsResult.isEmpty());
    assertSame(additionsResult, actualCopyOfResult.removals());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}, and {@link
   * ImmutableUpdateAppCapabilitiesAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
    "int ImmutableUpdateAppCapabilitiesAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        ImmutableUpdateAppCapabilitiesAction.builder().build();
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction2 =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertEquals(immutableUpdateAppCapabilitiesAction, immutableUpdateAppCapabilitiesAction2);
    assertEquals(
        immutableUpdateAppCapabilitiesAction.hashCode(),
        immutableUpdateAppCapabilitiesAction2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}, and {@link
   * ImmutableUpdateAppCapabilitiesAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
    "int ImmutableUpdateAppCapabilitiesAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act and Assert
    assertEquals(immutableUpdateAppCapabilitiesAction, immutableUpdateAppCapabilitiesAction);
    int expectedHashCodeResult = immutableUpdateAppCapabilitiesAction.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateAppCapabilitiesAction.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
    "int ImmutableUpdateAppCapabilitiesAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult.addAdditions(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableUpdateAppCapabilitiesAction.builder().build());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
    "int ImmutableUpdateAppCapabilitiesAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableUpdateAppCapabilitiesAction.builder();
    builderResult.addRemovals(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableUpdateAppCapabilitiesAction.builder().build());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
    "int ImmutableUpdateAppCapabilitiesAction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUpdateAppCapabilitiesAction.builder().build(), null);
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateAppCapabilitiesAction.equals(Object)",
    "int ImmutableUpdateAppCapabilitiesAction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateAppCapabilitiesAction.builder().build(),
        "Different type to ImmutableUpdateAppCapabilitiesAction");
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityReference}.
   *   <li>Then return removals size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add EntityReference; then return removals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddEntityReference_thenReturnRemovalsSizeIsOne() {
    // Arrange
    ArrayList<EntityReference> removals = new ArrayList<>();
    removals.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAdditions(null);
    json.setRemovals(removals);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult =
        ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.removals().size());
    assertTrue(actualFromJsonResult.additions().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Removals is {@code null}.
   *   <li>Then return removals is additions.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Removals is 'null'; then return removals is additions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonRemovalsIsNull_thenReturnRemovalsIsAdditions() {
    // Arrange
    Json json = new Json();
    json.setAdditions(null);
    json.setRemovals(null);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult =
        ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    List<EntityReference> additionsResult = actualFromJsonResult.additions();
    assertTrue(additionsResult.isEmpty());
    assertSame(additionsResult, actualFromJsonResult.removals());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removals size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removals size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"
  })
  void testFromJson_thenReturnRemovalsSizeIsTwo() {
    // Arrange
    ArrayList<EntityReference> removals = new ArrayList<>();
    removals.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    removals.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAdditions(null);
    json.setRemovals(removals);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult =
        ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    List<EntityReference> removalsResult = actualFromJsonResult.removals();
    assertEquals(2, removalsResult.size());
    EntityReference getResult = removalsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Additions is {@link ArrayList#ArrayList()}.
   *   <li>Then return additions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Additions is ArrayList(); then return additions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"
  })
  void testFromJson_whenJsonAdditionsIsArrayList_thenReturnAdditionsSizeIsOne() {
    // Arrange
    ArrayList<EntityReference> additions = new ArrayList<>();
    additions.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAdditions(additions);
    json.setRemovals(null);

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult =
        ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.additions().size());
    assertTrue(actualFromJsonResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return removals is {@link Json} (default constructor) {@link Json#removals}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateAppCapabilitiesAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return removals is Json (default constructor) removals")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnRemovalsIsJsonRemovals() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualFromJsonResult =
        ImmutableUpdateAppCapabilitiesAction.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.additions().isEmpty());
    List<EntityReference> expectedRemovalsResult = json.removals;
    assertSame(expectedRemovalsResult, actualFromJsonResult.removals());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#toString()}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#additions()}
   *   <li>{@link ImmutableUpdateAppCapabilitiesAction#removals()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableUpdateAppCapabilitiesAction.additions()",
    "List ImmutableUpdateAppCapabilitiesAction.removals()",
    "String ImmutableUpdateAppCapabilitiesAction.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    String actualToStringResult = immutableUpdateAppCapabilitiesAction.toString();
    List<EntityReference> actualAdditionsResult = immutableUpdateAppCapabilitiesAction.additions();
    List<EntityReference> actualRemovalsResult = immutableUpdateAppCapabilitiesAction.removals();

    // Assert
    assertEquals("UpdateAppCapabilitiesAction{additions=[], removals=[]}", actualToStringResult);
    assertTrue(actualAdditionsResult.isEmpty());
    assertSame(actualAdditionsResult, actualRemovalsResult);
  }

  /**
   * Test Json {@link Json#additions()}.
   *
   * <p>Method under test: {@link Json#additions()}
   */
  @Test
  @DisplayName("Test Json additions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.additions()"})
  void testJsonAdditions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().additions());
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
    assertTrue(actualJson.additions.isEmpty());
    assertTrue(actualJson.removals.isEmpty());
  }

  /**
   * Test Json {@link Json#removals()}.
   *
   * <p>Method under test: {@link Json#removals()}
   */
  @Test
  @DisplayName("Test Json removals()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.removals()"})
  void testJsonRemovals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().removals());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#withAdditions(EntityReference[])} with {@code
   * EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateAppCapabilitiesAction#withAdditions(EntityReference[])}
   */
  @Test
  @DisplayName("Test withAdditions(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.withAdditions(EntityReference[])"
  })
  void testWithAdditionsWithEntityReference() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualWithAdditionsResult =
        immutableUpdateAppCapabilitiesAction.withAdditions(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    List<EntityReference> additionsResult = actualWithAdditionsResult.additions();
    assertEquals(1, additionsResult.size());
    EntityReference getResult = additionsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(actualWithAdditionsResult.removals().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateAppCapabilitiesAction#withRemovals(EntityReference[])} with {@code
   * EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateAppCapabilitiesAction#withRemovals(EntityReference[])}
   */
  @Test
  @DisplayName("Test withRemovals(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateAppCapabilitiesAction ImmutableUpdateAppCapabilitiesAction.withRemovals(EntityReference[])"
  })
  void testWithRemovalsWithEntityReference() {
    // Arrange
    ImmutableUpdateAppCapabilitiesAction immutableUpdateAppCapabilitiesAction =
        ImmutableUpdateAppCapabilitiesAction.builder().build();

    // Act
    ImmutableUpdateAppCapabilitiesAction actualWithRemovalsResult =
        immutableUpdateAppCapabilitiesAction.withRemovals(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    List<EntityReference> removalsResult = actualWithRemovalsResult.removals();
    assertEquals(1, removalsResult.size());
    EntityReference getResult = removalsResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertTrue(actualWithRemovalsResult.additions().isEmpty());
  }
}
