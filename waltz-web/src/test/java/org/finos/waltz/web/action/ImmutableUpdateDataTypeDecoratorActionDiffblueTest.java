package org.finos.waltz.web.action;

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
import org.finos.waltz.web.action.ImmutableUpdateDataTypeDecoratorAction.Builder;
import org.finos.waltz.web.action.ImmutableUpdateDataTypeDecoratorAction.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateDataTypeDecoratorActionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAddedDataTypeIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addAddedDataTypeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addAddedDataTypeIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAddedDataTypeIds(long)"})
  void testBuilderAddAddedDataTypeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddAddedDataTypeIdsResult = builderResult.addAddedDataTypeIds(1L);

    // Assert
    assertSame(builderResult, actualAddAddedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAddedDataTypeIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addAddedDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addAddedDataTypeIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAddedDataTypeIds(long[])"})
  void testBuilderAddAddedDataTypeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddAddedDataTypeIdsResult = builderResult.addAddedDataTypeIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddAddedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAddedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAddedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllAddedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAddedDataTypeIds(Iterable)"})
  void testBuilderAddAllAddedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllAddedDataTypeIdsResult = builderResult.addAllAddedDataTypeIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllAddedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAddedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAddedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAddedDataTypeIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAddedDataTypeIds(Iterable)"})
  void testBuilderAddAllAddedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddAllAddedDataTypeIdsResult =
        builderResult.addAllAddedDataTypeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAddedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRemovedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRemovedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRemovedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRemovedDataTypeIds(Iterable)"})
  void testBuilderAddAllRemovedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllRemovedDataTypeIdsResult = builderResult.addAllRemovedDataTypeIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllRemovedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRemovedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRemovedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRemovedDataTypeIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRemovedDataTypeIds(Iterable)"})
  void testBuilderAddAllRemovedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddAllRemovedDataTypeIdsResult =
        builderResult.addAllRemovedDataTypeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRemovedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovedDataTypeIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRemovedDataTypeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRemovedDataTypeIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovedDataTypeIds(long)"})
  void testBuilderAddRemovedDataTypeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddRemovedDataTypeIdsResult = builderResult.addRemovedDataTypeIds(1L);

    // Assert
    assertSame(builderResult, actualAddRemovedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRemovedDataTypeIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRemovedDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRemovedDataTypeIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRemovedDataTypeIds(long[])"})
  void testBuilderAddRemovedDataTypeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddRemovedDataTypeIdsResult =
        builderResult.addRemovedDataTypeIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddRemovedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addedDataTypeIds(Iterable)"})
  void testBuilderAddedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddedDataTypeIdsResult = builderResult.addedDataTypeIds(elements);

    // Assert
    assertSame(builderResult, actualAddedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addedDataTypeIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addedDataTypeIds(Iterable)"})
  void testBuilderAddedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualAddedDataTypeIdsResult = builderResult.addedDataTypeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddedDataTypeIdsResult);
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
  @MethodsUnderTest({"ImmutableUpdateDataTypeDecoratorAction Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableUpdateDataTypeDecoratorAction actualImmutableUpdateDataTypeDecoratorAction =
        actualBuilderResult.entityReference(entityReference).build();

    // Assert
    assertTrue(actualImmutableUpdateDataTypeDecoratorAction.addedDataTypeIds().isEmpty());
    assertSame(entityReference, actualImmutableUpdateDataTypeDecoratorAction.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act
    Builder actualEntityReferenceResult = builderResult.entityReference(entityReference);

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
    assertSame(entityReference, builderResult.build().entityReference());
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   *
   * <p>Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataTypeDecoratorAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateDataTypeDecoratorAction actualImmutableUpdateDataTypeDecoratorAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateDataTypeDecoratorAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   *
   * <p>Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateDataTypeDecoratorAction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();
    builderResult2.addAddedDataTypeIds(-2L);
    ImmutableUpdateDataTypeDecoratorAction instance =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateDataTypeDecoratorAction actualImmutableUpdateDataTypeDecoratorAction =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateDataTypeDecoratorAction);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateDataTypeDecoratorAction)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return build addedDataTypeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateDataTypeDecoratorAction); given one; then return build addedDataTypeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateDataTypeDecoratorAction)"})
  void testBuilderFrom_givenOne_thenReturnBuildAddedDataTypeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();
    builderResult2.addRemovedDataTypeIds(1L);
    builderResult2.addAddedDataTypeIds(-2L);

    // Act and Assert
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .from(
                builderResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .build())
            .build();
    Set<Long> addedDataTypeIdsResult = immutableUpdateDataTypeDecoratorAction.addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult.size());
    Set<Long> removedDataTypeIdsResult =
        immutableUpdateDataTypeDecoratorAction.removedDataTypeIds();
    assertEquals(1, removedDataTypeIdsResult.size());
    assertTrue(addedDataTypeIdsResult.contains(-2L));
    assertTrue(removedDataTypeIdsResult.contains(1L));
  }

  /**
   * Test Builder {@link Builder#removedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#removedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removedDataTypeIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.removedDataTypeIds(Iterable)"})
  void testBuilderRemovedDataTypeIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualRemovedDataTypeIdsResult = builderResult.removedDataTypeIds(elements);

    // Assert
    assertSame(builderResult, actualRemovedDataTypeIdsResult);
  }

  /**
   * Test Builder {@link Builder#removedDataTypeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#removedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder removedDataTypeIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.removedDataTypeIds(Iterable)"})
  void testBuilderRemovedDataTypeIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    Builder actualRemovedDataTypeIdsResult = builderResult.removedDataTypeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRemovedDataTypeIdsResult);
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#copyOf(UpdateDataTypeDecoratorAction)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataTypeDecoratorAction#copyOf(UpdateDataTypeDecoratorAction)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UpdateDataTypeDecoratorAction); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.copyOf(UpdateDataTypeDecoratorAction)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction instance =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualCopyOfResult =
        ImmutableUpdateDataTypeDecoratorAction.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    Set<Long> addedDataTypeIdsResult = actualCopyOfResult.addedDataTypeIds();
    assertTrue(addedDataTypeIdsResult.isEmpty());
    assertSame(addedDataTypeIdsResult, actualCopyOfResult.removedDataTypeIds());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}, and {@link
   * ImmutableUpdateDataTypeDecoratorAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableUpdateDataTypeDecoratorAction, immutableUpdateDataTypeDecoratorAction2);
    assertEquals(
        immutableUpdateDataTypeDecoratorAction.hashCode(),
        immutableUpdateDataTypeDecoratorAction2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}, and {@link
   * ImmutableUpdateDataTypeDecoratorAction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableUpdateDataTypeDecoratorAction, immutableUpdateDataTypeDecoratorAction);
    int expectedHashCodeResult = immutableUpdateDataTypeDecoratorAction.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateDataTypeDecoratorAction.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    builderResult.addAddedDataTypeIds(1L);
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertNotEquals(
        immutableUpdateDataTypeDecoratorAction,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    builderResult.addRemovedDataTypeIds(1L);
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertNotEquals(
        immutableUpdateDataTypeDecoratorAction,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertNotEquals(
        immutableUpdateDataTypeDecoratorAction,
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateDataTypeDecoratorAction.equals(Object)",
    "int ImmutableUpdateDataTypeDecoratorAction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableUpdateDataTypeDecoratorAction");
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) AddedDataTypeIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) AddedDataTypeIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAddedDataTypeIdsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAddedDataTypeIds(new HashSet<>());
    json.setRemovedDataTypeIds(null);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult =
        ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertTrue(addedDataTypeIdsResult.isEmpty());
    assertSame(addedDataTypeIdsResult, actualFromJsonResult.removedDataTypeIds());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) RemovedDataTypeIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) RemovedDataTypeIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonRemovedDataTypeIdsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAddedDataTypeIds(null);
    json.setRemovedDataTypeIds(new HashSet<>());

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult =
        ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertTrue(addedDataTypeIdsResult.isEmpty());
    assertSame(addedDataTypeIdsResult, actualFromJsonResult.removedDataTypeIds());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return addedDataTypeIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return addedDataTypeIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.fromJson(Json)"
  })
  void testFromJson_thenReturnAddedDataTypeIdsEmpty() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAddedDataTypeIds(null);
    json.setRemovedDataTypeIds(null);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult =
        ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertTrue(addedDataTypeIdsResult.isEmpty());
    assertSame(addedDataTypeIdsResult, actualFromJsonResult.removedDataTypeIds());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return addedDataTypeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return addedDataTypeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.fromJson(Json)"
  })
  void testFromJson_thenReturnAddedDataTypeIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> addedDataTypeIds = new LinkedHashSet<>();
    addedDataTypeIds.add(1L);

    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAddedDataTypeIds(addedDataTypeIds);
    json.setRemovedDataTypeIds(null);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult =
        ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    Set<Long> addedDataTypeIdsResult = actualFromJsonResult.addedDataTypeIds();
    assertEquals(1, addedDataTypeIdsResult.size());
    assertTrue(addedDataTypeIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.removedDataTypeIds().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removedDataTypeIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removedDataTypeIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.fromJson(Json)"
  })
  void testFromJson_thenReturnRemovedDataTypeIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> removedDataTypeIds = new LinkedHashSet<>();
    removedDataTypeIds.add(-1L);
    removedDataTypeIds.add(1L);

    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAddedDataTypeIds(null);
    json.setRemovedDataTypeIds(removedDataTypeIds);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult =
        ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    assertEquals(removedDataTypeIds, actualFromJsonResult.removedDataTypeIds());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return removedDataTypeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateDataTypeDecoratorAction#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return removedDataTypeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.fromJson(Json)"
  })
  void testFromJson_thenReturnRemovedDataTypeIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> removedDataTypeIds = new LinkedHashSet<>();
    removedDataTypeIds.add(1L);

    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAddedDataTypeIds(null);
    json.setRemovedDataTypeIds(removedDataTypeIds);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualFromJsonResult =
        ImmutableUpdateDataTypeDecoratorAction.fromJson(json);

    // Assert
    Set<Long> removedDataTypeIdsResult = actualFromJsonResult.removedDataTypeIds();
    assertEquals(1, removedDataTypeIdsResult.size());
    assertTrue(removedDataTypeIdsResult.contains(1L));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#toString()}
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#addedDataTypeIds()}
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#entityReference()}
   *   <li>{@link ImmutableUpdateDataTypeDecoratorAction#removedDataTypeIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableUpdateDataTypeDecoratorAction.addedDataTypeIds()",
    "EntityReference ImmutableUpdateDataTypeDecoratorAction.entityReference()",
    "Set ImmutableUpdateDataTypeDecoratorAction.removedDataTypeIds()",
    "String ImmutableUpdateDataTypeDecoratorAction.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableUpdateDataTypeDecoratorAction.toString();
    Set<Long> actualAddedDataTypeIdsResult =
        immutableUpdateDataTypeDecoratorAction.addedDataTypeIds();
    EntityReference actualEntityReferenceResult =
        immutableUpdateDataTypeDecoratorAction.entityReference();
    Set<Long> actualRemovedDataTypeIdsResult =
        immutableUpdateDataTypeDecoratorAction.removedDataTypeIds();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "UpdateDataTypeDecoratorAction{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " addedDataTypeIds=[], removedDataTypeIds=[]}",
        actualToStringResult);
    assertTrue(actualAddedDataTypeIdsResult.isEmpty());
    assertSame(actualAddedDataTypeIdsResult, actualRemovedDataTypeIdsResult);
  }

  /**
   * Test Json {@link Json#addedDataTypeIds()}.
   *
   * <p>Method under test: {@link Json#addedDataTypeIds()}
   */
  @Test
  @DisplayName("Test Json addedDataTypeIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.addedDataTypeIds()"})
  void testJsonAddedDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().addedDataTypeIds());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
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
    assertNull(actualJson.entityReference);
    assertTrue(actualJson.addedDataTypeIds.isEmpty());
    assertTrue(actualJson.removedDataTypeIds.isEmpty());
  }

  /**
   * Test Json {@link Json#removedDataTypeIds()}.
   *
   * <p>Method under test: {@link Json#removedDataTypeIds()}
   */
  @Test
  @DisplayName("Test Json removedDataTypeIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.removedDataTypeIds()"})
  void testJsonRemovedDataTypeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().removedDataTypeIds());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#withAddedDataTypeIds(Iterable)} with {@code
   * Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataTypeDecoratorAction#withAddedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test withAddedDataTypeIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.withAddedDataTypeIds(Iterable)"
  })
  void testWithAddedDataTypeIdsWithIterable() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualWithAddedDataTypeIdsResult =
        immutableUpdateDataTypeDecoratorAction.withAddedDataTypeIds(elements);

    // Assert
    EntityReference entityReferenceResult = actualWithAddedDataTypeIdsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithAddedDataTypeIdsResult.removedDataTypeIds().isEmpty());
    assertEquals(elements, actualWithAddedDataTypeIdsResult.addedDataTypeIds());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#withAddedDataTypeIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataTypeDecoratorAction#withAddedDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test withAddedDataTypeIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.withAddedDataTypeIds(long[])"
  })
  void testWithAddedDataTypeIdsWithLong() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualWithAddedDataTypeIdsResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withAddedDataTypeIds(1L, -1L, 1L, -1L);

    // Assert
    EntityReference entityReferenceResult = actualWithAddedDataTypeIdsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    Set<Long> addedDataTypeIdsResult = actualWithAddedDataTypeIdsResult.addedDataTypeIds();
    assertEquals(2, addedDataTypeIdsResult.size());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(addedDataTypeIdsResult.contains(-1L));
    assertTrue(addedDataTypeIdsResult.contains(1L));
    assertTrue(actualWithAddedDataTypeIdsResult.removedDataTypeIds().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataTypeDecoratorAction#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualWithEntityReferenceResult =
        immutableUpdateDataTypeDecoratorAction.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableUpdateDataTypeDecoratorAction, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#withRemovedDataTypeIds(Iterable)} with
   * {@code Iterable}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataTypeDecoratorAction#withRemovedDataTypeIds(Iterable)}
   */
  @Test
  @DisplayName("Test withRemovedDataTypeIds(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.withRemovedDataTypeIds(Iterable)"
  })
  void testWithRemovedDataTypeIdsWithIterable() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();
    ImmutableUpdateDataTypeDecoratorAction immutableUpdateDataTypeDecoratorAction =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualWithRemovedDataTypeIdsResult =
        immutableUpdateDataTypeDecoratorAction.withRemovedDataTypeIds(elements);

    // Assert
    EntityReference entityReferenceResult = actualWithRemovedDataTypeIdsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithRemovedDataTypeIdsResult.addedDataTypeIds().isEmpty());
    assertEquals(elements, actualWithRemovedDataTypeIdsResult.removedDataTypeIds());
  }

  /**
   * Test {@link ImmutableUpdateDataTypeDecoratorAction#withRemovedDataTypeIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableUpdateDataTypeDecoratorAction#withRemovedDataTypeIds(long[])}
   */
  @Test
  @DisplayName("Test withRemovedDataTypeIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateDataTypeDecoratorAction ImmutableUpdateDataTypeDecoratorAction.withRemovedDataTypeIds(long[])"
  })
  void testWithRemovedDataTypeIdsWithLong() {
    // Arrange
    Builder builderResult = ImmutableUpdateDataTypeDecoratorAction.builder();

    // Act
    ImmutableUpdateDataTypeDecoratorAction actualWithRemovedDataTypeIdsResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withRemovedDataTypeIds(1L, -1L, 1L, -1L);

    // Assert
    EntityReference entityReferenceResult = actualWithRemovedDataTypeIdsResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    Set<Long> removedDataTypeIdsResult = actualWithRemovedDataTypeIdsResult.removedDataTypeIds();
    assertEquals(2, removedDataTypeIdsResult.size());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(removedDataTypeIdsResult.contains(-1L));
    assertTrue(removedDataTypeIdsResult.contains(1L));
    assertTrue(actualWithRemovedDataTypeIdsResult.addedDataTypeIds().isEmpty());
  }
}
