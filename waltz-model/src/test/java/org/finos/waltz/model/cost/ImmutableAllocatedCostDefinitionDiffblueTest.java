package org.finos.waltz.model.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.cost.ImmutableAllocatedCostDefinition.Builder;
import org.finos.waltz.model.cost.ImmutableAllocatedCostDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAllocatedCostDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#allocationScheme(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#allocationScheme(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder allocationScheme(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allocationScheme(EntityReference)"})
  void testBuilderAllocationScheme_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act
    Builder actualAllocationSchemeResult =
        builderResult.allocationScheme(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAllocationSchemeResult);
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
  @MethodsUnderTest({"ImmutableAllocatedCostDefinition Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAllocatedCostDefinition.builder();
    ImmutableEntityReference allocationScheme =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIdResult = actualBuilderResult.allocationScheme(allocationScheme).id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableEntityReference sourceCostKind =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceCostKindResult = actualIdResult2.sourceCostKind(sourceCostKind);
    ImmutableEntityReference targetCostKind =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAllocatedCostDefinition actualImmutableAllocatedCostDefinition =
        actualSourceCostKindResult.targetCostKind(targetCostKind).build();

    // Assert
    assertSame(allocationScheme, actualImmutableAllocatedCostDefinition.allocationScheme());
    assertSame(sourceCostKind, actualImmutableAllocatedCostDefinition.sourceCostKind());
    assertSame(targetCostKind, actualImmutableAllocatedCostDefinition.targetCostKind());
  }

  /**
   * Test Builder {@link Builder#from(AllocatedCostDefinition)} with {@code
   * AllocatedCostDefinition}.
   *
   * <p>Method under test: {@link Builder#from(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(AllocatedCostDefinition) with 'AllocatedCostDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AllocatedCostDefinition)"})
  void testBuilderFromWithAllocatedCostDefinition() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition instance =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualImmutableAllocatedCostDefinition = builderResult.build();
    assertEquals(instance, actualImmutableAllocatedCostDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition instance =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualImmutableAllocatedCostDefinition =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAllocatedCostDefinition);
    ImmutableAllocatedCostDefinition actualImmutableAllocatedCostDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableAllocatedCostDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#sourceCostKind(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceCostKind(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder sourceCostKind(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceCostKind(EntityReference)"})
  void testBuilderSourceCostKind_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act
    Builder actualSourceCostKindResult = builderResult.sourceCostKind(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSourceCostKindResult);
  }

  /**
   * Test Builder {@link Builder#targetCostKind(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetCostKind(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder targetCostKind(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetCostKind(EntityReference)"})
  void testBuilderTargetCostKind_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    // Act
    Builder actualTargetCostKindResult = builderResult.targetCostKind(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualTargetCostKindResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#copyOf(AllocatedCostDefinition)}.
   *
   * <ul>
   *   <li>Then allocationScheme return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#copyOf(AllocatedCostDefinition)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AllocatedCostDefinition); then allocationScheme return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.copyOf(AllocatedCostDefinition)"
  })
  void testCopyOf_thenAllocationSchemeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition instance =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualCopyOfResult =
        ImmutableAllocatedCostDefinition.copyOf(instance);

    // Assert
    EntityReference allocationSchemeResult = actualCopyOfResult.allocationScheme();
    assertTrue(allocationSchemeResult instanceof ImmutableEntityReference);
    EntityReference sourceCostKindResult2 = actualCopyOfResult.sourceCostKind();
    assertTrue(sourceCostKindResult2 instanceof ImmutableEntityReference);
    EntityReference targetCostKindResult = actualCopyOfResult.targetCostKind();
    assertTrue(targetCostKindResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", allocationSchemeResult.description());
    assertEquals(1L, allocationSchemeResult.id());
    assertEquals(EntityKind.ALL, allocationSchemeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, allocationSchemeResult.entityLifecycleStatus());
    assertEquals(allocationSchemeResult, sourceCostKindResult2);
    assertEquals(allocationSchemeResult, targetCostKindResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}, and {@link
   * ImmutableAllocatedCostDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocatedCostDefinition#equals(Object)}
   *   <li>{@link ImmutableAllocatedCostDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult2 =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult2 =
        idResult2.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition2 =
        sourceCostKindResult2
            .targetCostKind(
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
    assertEquals(immutableAllocatedCostDefinition, immutableAllocatedCostDefinition2);
    assertEquals(
        immutableAllocatedCostDefinition.hashCode(), immutableAllocatedCostDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}, and {@link
   * ImmutableAllocatedCostDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocatedCostDefinition#equals(Object)}
   *   <li>{@link ImmutableAllocatedCostDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
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
    assertEquals(immutableAllocatedCostDefinition, immutableAllocatedCostDefinition);
    int expectedHashCodeResult = immutableAllocatedCostDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableAllocatedCostDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult2 =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult2 =
        idResult2.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAllocatedCostDefinition,
        sourceCostKindResult2
            .targetCostKind(
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
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult2 =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult2 =
        idResult2.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAllocatedCostDefinition,
        sourceCostKindResult2
            .targetCostKind(
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
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult2 =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult2 =
        idResult2.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAllocatedCostDefinition,
        sourceCostKindResult2
            .targetCostKind(
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
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableAllocatedCostDefinition.builder();

    Builder idResult2 =
        builderResult2
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult2 =
        idResult2.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableAllocatedCostDefinition,
        sourceCostKindResult2
            .targetCostKind(
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
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        sourceCostKindResult
            .targetCostKind(
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
   * Test {@link ImmutableAllocatedCostDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAllocatedCostDefinition.equals(Object)",
    "int ImmutableAllocatedCostDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableAllocatedCostDefinition");
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) Id is of one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of one; when Json (default constructor) Id is of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.fromJson(Json)"
  })
  void testFromJson_givenOfOne_whenJsonIdIsOfOne() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(1L);
    json.setId(id);
    json.setAllocationScheme(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSourceCostKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTargetCostKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAllocatedCostDefinition actualFromJsonResult =
        ImmutableAllocatedCostDefinition.fromJson(json);

    // Assert
    EntityReference expectedAllocationSchemeResult = json.allocationScheme;
    assertSame(expectedAllocationSchemeResult, actualFromJsonResult.allocationScheme());
    EntityReference expectedSourceCostKindResult = json.sourceCostKind;
    assertSame(expectedSourceCostKindResult, actualFromJsonResult.sourceCostKind());
    EntityReference expectedTargetCostKindResult = json.targetCostKind;
    assertSame(expectedTargetCostKindResult, actualFromJsonResult.targetCostKind());
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return allocationScheme is {@link Json} (default constructor) {@link
   *       Json#allocationScheme}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return allocationScheme is Json (default constructor) allocationScheme")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.fromJson(Json)"
  })
  void testFromJson_thenReturnAllocationSchemeIsJsonAllocationScheme() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setAllocationScheme(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSourceCostKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTargetCostKind(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableAllocatedCostDefinition actualFromJsonResult =
        ImmutableAllocatedCostDefinition.fromJson(json);

    // Assert
    EntityReference expectedAllocationSchemeResult = json.allocationScheme;
    assertSame(expectedAllocationSchemeResult, actualFromJsonResult.allocationScheme());
    EntityReference expectedSourceCostKindResult = json.sourceCostKind;
    assertSame(expectedSourceCostKindResult, actualFromJsonResult.sourceCostKind());
    EntityReference expectedTargetCostKindResult = json.targetCostKind;
    assertSame(expectedTargetCostKindResult, actualFromJsonResult.targetCostKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAllocatedCostDefinition#allocationScheme()}
   *   <li>{@link ImmutableAllocatedCostDefinition#sourceCostKind()}
   *   <li>{@link ImmutableAllocatedCostDefinition#targetCostKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableAllocatedCostDefinition.allocationScheme()",
    "EntityReference ImmutableAllocatedCostDefinition.sourceCostKind()",
    "EntityReference ImmutableAllocatedCostDefinition.targetCostKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
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
    EntityReference actualAllocationSchemeResult =
        immutableAllocatedCostDefinition.allocationScheme();
    EntityReference actualSourceCostKindResult = immutableAllocatedCostDefinition.sourceCostKind();
    EntityReference actualTargetCostKindResult = immutableAllocatedCostDefinition.targetCostKind();

    // Assert
    assertTrue(actualAllocationSchemeResult instanceof ImmutableEntityReference);
    assertTrue(actualSourceCostKindResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetCostKindResult instanceof ImmutableEntityReference);
    assertEquals(actualAllocationSchemeResult, actualSourceCostKindResult);
    assertEquals(actualAllocationSchemeResult, actualTargetCostKindResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAllocatedCostDefinition.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Optional<Long> actualIdResult =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#allocationScheme()}.
   *
   * <p>Method under test: {@link Json#allocationScheme()}
   */
  @Test
  @DisplayName("Test Json allocationScheme()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.allocationScheme()"})
  void testJsonAllocationScheme() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allocationScheme());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertNull(actualJson.allocationScheme);
    assertNull(actualJson.sourceCostKind);
    assertNull(actualJson.targetCostKind);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#sourceCostKind()}.
   *
   * <p>Method under test: {@link Json#sourceCostKind()}
   */
  @Test
  @DisplayName("Test Json sourceCostKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.sourceCostKind()"})
  void testJsonSourceCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sourceCostKind());
  }

  /**
   * Test Json {@link Json#targetCostKind()}.
   *
   * <p>Method under test: {@link Json#targetCostKind()}
   */
  @Test
  @DisplayName("Test Json targetCostKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.targetCostKind()"})
  void testJsonTargetCostKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetCostKind());
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableAllocatedCostDefinition.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertEquals(
        "AllocatedCostDefinition{id=1, allocationScheme=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " sourceCostKind=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, targetCostKind"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withAllocationScheme(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableAllocatedCostDefinition#withAllocationScheme(EntityReference)}
   */
  @Test
  @DisplayName("Test withAllocationScheme(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withAllocationScheme(EntityReference)"
  })
  void testWithAllocationScheme() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualWithAllocationSchemeResult =
        immutableAllocatedCostDefinition.withAllocationScheme(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAllocatedCostDefinition, actualWithAllocationSchemeResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAllocatedCostDefinition actualWithIdResult =
        immutableAllocatedCostDefinition.withId(optional);

    // Assert
    assertSame(immutableAllocatedCostDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then allocationScheme return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then allocationScheme return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_thenAllocationSchemeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAllocatedCostDefinition actualWithIdResult =
        immutableAllocatedCostDefinition.withId(optional);

    // Assert
    EntityReference allocationSchemeResult = actualWithIdResult.allocationScheme();
    assertTrue(allocationSchemeResult instanceof ImmutableEntityReference);
    EntityReference sourceCostKindResult2 = actualWithIdResult.sourceCostKind();
    assertTrue(sourceCostKindResult2 instanceof ImmutableEntityReference);
    EntityReference targetCostKindResult = actualWithIdResult.targetCostKind();
    assertTrue(targetCostKindResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", allocationSchemeResult.description());
    assertEquals(1L, allocationSchemeResult.id());
    assertEquals(EntityKind.ALL, allocationSchemeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, allocationSchemeResult.entityLifecycleStatus());
    assertEquals(allocationSchemeResult, sourceCostKindResult2);
    assertEquals(allocationSchemeResult, targetCostKindResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualWithIdResult =
        immutableAllocatedCostDefinition.withId(1L);

    // Assert
    assertSame(immutableAllocatedCostDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then allocationScheme return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAllocatedCostDefinition#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then allocationScheme return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withId(long)"
  })
  void testWithIdWithValue_thenAllocationSchemeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableAllocatedCostDefinition actualWithIdResult =
        sourceCostKindResult
            .targetCostKind(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withId(42L);

    // Assert
    EntityReference allocationSchemeResult = actualWithIdResult.allocationScheme();
    assertTrue(allocationSchemeResult instanceof ImmutableEntityReference);
    EntityReference sourceCostKindResult2 = actualWithIdResult.sourceCostKind();
    assertTrue(sourceCostKindResult2 instanceof ImmutableEntityReference);
    EntityReference targetCostKindResult = actualWithIdResult.targetCostKind();
    assertTrue(targetCostKindResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", allocationSchemeResult.description());
    assertEquals(1L, allocationSchemeResult.id());
    assertEquals(EntityKind.ALL, allocationSchemeResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, allocationSchemeResult.entityLifecycleStatus());
    assertEquals(allocationSchemeResult, sourceCostKindResult2);
    assertEquals(allocationSchemeResult, targetCostKindResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withSourceCostKind(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableAllocatedCostDefinition#withSourceCostKind(EntityReference)}
   */
  @Test
  @DisplayName("Test withSourceCostKind(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withSourceCostKind(EntityReference)"
  })
  void testWithSourceCostKind() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualWithSourceCostKindResult =
        immutableAllocatedCostDefinition.withSourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAllocatedCostDefinition, actualWithSourceCostKindResult);
  }

  /**
   * Test {@link ImmutableAllocatedCostDefinition#withTargetCostKind(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableAllocatedCostDefinition#withTargetCostKind(EntityReference)}
   */
  @Test
  @DisplayName("Test withTargetCostKind(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAllocatedCostDefinition ImmutableAllocatedCostDefinition.withTargetCostKind(EntityReference)"
  })
  void testWithTargetCostKind() {
    // Arrange
    Builder builderResult = ImmutableAllocatedCostDefinition.builder();

    Builder idResult =
        builderResult
            .allocationScheme(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L);

    Builder sourceCostKindResult =
        idResult.sourceCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableAllocatedCostDefinition immutableAllocatedCostDefinition =
        sourceCostKindResult
            .targetCostKind(
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
    ImmutableAllocatedCostDefinition actualWithTargetCostKindResult =
        immutableAllocatedCostDefinition.withTargetCostKind(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAllocatedCostDefinition, actualWithTargetCostKindResult);
  }
}
