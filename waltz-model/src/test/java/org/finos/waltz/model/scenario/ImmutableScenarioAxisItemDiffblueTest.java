package org.finos.waltz.model.scenario;

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
import org.finos.waltz.model.AxisOrientation;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.scenario.ImmutableScenarioAxisItem.Builder;
import org.finos.waltz.model.scenario.ImmutableScenarioAxisItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioAxisItemDiffblueTest {
  /**
   * Test Builder {@link Builder#axisOrientation(AxisOrientation)}.
   *
   * <p>Method under test: {@link Builder#axisOrientation(AxisOrientation)}
   */
  @Test
  @DisplayName("Test Builder axisOrientation(AxisOrientation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.axisOrientation(AxisOrientation)"})
  void testBuilderAxisOrientation() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act
    Builder actualAxisOrientationResult = builderResult.axisOrientation(AxisOrientation.ROW);

    // Assert
    assertSame(builderResult, actualAxisOrientationResult);
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
  @MethodsUnderTest({"ImmutableScenarioAxisItem Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAxisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableEntityReference domainItem =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIdResult = actualAxisOrientationResult.domainItem(domainItem).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableScenarioAxisItem actualImmutableScenarioAxisItem =
        actualIdResult.id(id).position(1).scenarioId(1L).build();

    // Assert
    assertEquals(1, actualImmutableScenarioAxisItem.position());
    assertEquals(1L, actualImmutableScenarioAxisItem.scenarioId());
    assertEquals(AxisOrientation.ROW, actualImmutableScenarioAxisItem.axisOrientation());
    assertSame(domainItem, actualImmutableScenarioAxisItem.domainItem());
  }

  /**
   * Test Builder {@link Builder#domainItem(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#domainItem(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder domainItem(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.domainItem(EntityReference)"})
  void testBuilderDomainItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act
    Builder actualDomainItemResult =
        builderResult.domainItem(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualDomainItemResult);
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
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem instance =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act and Assert
    ImmutableScenarioAxisItem actualImmutableScenarioAxisItem =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableScenarioAxisItem);
    ImmutableScenarioAxisItem actualImmutableScenarioAxisItem2 = builderResult.build();
    assertEquals(instance, actualImmutableScenarioAxisItem2);
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
    Builder builderResult = ImmutableScenarioAxisItem.builder();

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
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(ScenarioAxisItem)} with {@code ScenarioAxisItem}.
   *
   * <p>Method under test: {@link Builder#from(ScenarioAxisItem)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioAxisItem) with 'ScenarioAxisItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ScenarioAxisItem)"})
  void testBuilderFromWithScenarioAxisItem() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem instance =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableScenarioAxisItem actualImmutableScenarioAxisItem = builderResult.build();
    assertEquals(instance, actualImmutableScenarioAxisItem);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableScenarioAxisItem.builder();

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
    Builder builderResult = ImmutableScenarioAxisItem.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   *
   * <p>Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableScenarioAxisItem.builder();

    // Act
    Builder actualScenarioIdResult = builderResult.scenarioId(1L);

    // Assert
    assertSame(builderResult, actualScenarioIdResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#copyOf(ScenarioAxisItem)}.
   *
   * <ul>
   *   <li>Then domainItem return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#copyOf(ScenarioAxisItem)}
   */
  @Test
  @DisplayName("Test copyOf(ScenarioAxisItem); then domainItem return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioAxisItem ImmutableScenarioAxisItem.copyOf(ScenarioAxisItem)"
  })
  void testCopyOf_thenDomainItemReturnImmutableEntityReference() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem instance =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioAxisItem actualCopyOfResult = ImmutableScenarioAxisItem.copyOf(instance);

    // Assert
    EntityReference domainItemResult = actualCopyOfResult.domainItem();
    assertTrue(domainItemResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", domainItemResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, domainItemResult.id());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualCopyOfResult.axisOrientation());
    assertEquals(EntityKind.ALL, domainItemResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, domainItemResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}, and {@link
   * ImmutableScenarioAxisItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioAxisItem#equals(Object)}
   *   <li>{@link ImmutableScenarioAxisItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem2 =
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableScenarioAxisItem, immutableScenarioAxisItem2);
    assertEquals(immutableScenarioAxisItem.hashCode(), immutableScenarioAxisItem2.hashCode());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}, and {@link
   * ImmutableScenarioAxisItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioAxisItem#equals(Object)}
   *   <li>{@link ImmutableScenarioAxisItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableScenarioAxisItem, immutableScenarioAxisItem);
    int expectedHashCodeResult = immutableScenarioAxisItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableScenarioAxisItem.hashCode());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.COLUMN);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        immutableScenarioAxisItem,
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        immutableScenarioAxisItem,
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .position(1)
            .scenarioId(1L)
            .build();

    Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        immutableScenarioAxisItem,
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(0)
            .scenarioId(1L)
            .build();

    Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        immutableScenarioAxisItem,
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(2L)
            .build();

    Builder axisOrientationResult2 =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        immutableScenarioAxisItem,
        axisOrientationResult2
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioAxisItem.equals(Object)",
    "int ImmutableScenarioAxisItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertNotEquals(
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build(),
        "Different type to ImmutableScenarioAxisItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioAxisItem#axisOrientation()}
   *   <li>{@link ImmutableScenarioAxisItem#domainItem()}
   *   <li>{@link ImmutableScenarioAxisItem#position()}
   *   <li>{@link ImmutableScenarioAxisItem#scenarioId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AxisOrientation ImmutableScenarioAxisItem.axisOrientation()",
    "EntityReference ImmutableScenarioAxisItem.domainItem()",
    "int ImmutableScenarioAxisItem.position()",
    "long ImmutableScenarioAxisItem.scenarioId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act
    AxisOrientation actualAxisOrientationResult = immutableScenarioAxisItem.axisOrientation();
    EntityReference actualDomainItemResult = immutableScenarioAxisItem.domainItem();
    int actualPositionResult = immutableScenarioAxisItem.position();

    // Assert
    assertTrue(actualDomainItemResult instanceof ImmutableEntityReference);
    assertEquals(1, actualPositionResult);
    assertEquals(1L, immutableScenarioAxisItem.scenarioId());
    assertEquals(AxisOrientation.ROW, actualAxisOrientationResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#id()}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableScenarioAxisItem.id()"})
  void testId() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act
    Optional<Long> actualIdResult =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#axisOrientation()}.
   *
   * <p>Method under test: {@link Json#axisOrientation()}
   */
  @Test
  @DisplayName("Test Json axisOrientation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AxisOrientation Json.axisOrientation()"})
  void testJsonAxisOrientation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().axisOrientation());
  }

  /**
   * Test Json {@link Json#domainItem()}.
   *
   * <p>Method under test: {@link Json#domainItem()}
   */
  @Test
  @DisplayName("Test Json domainItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.domainItem()"})
  void testJsonDomainItem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().domainItem());
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
    assertNull(actualJson.axisOrientation);
    assertNull(actualJson.domainItem);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.scenarioId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.scenarioIdIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#scenarioId()}.
   *
   * <p>Method under test: {@link Json#scenarioId()}
   */
  @Test
  @DisplayName("Test Json scenarioId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.scenarioId()"})
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scenarioId());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#setScenarioId(long)}.
   *
   * <p>Method under test: {@link Json#setScenarioId(long)}
   */
  @Test
  @DisplayName("Test Json setScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setScenarioId(long)"})
  void testJsonSetScenarioId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableScenarioAxisItem.toString()"})
  void testToString() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act and Assert
    assertEquals(
        "ScenarioAxisItem{id=1, scenarioId=1, domainItem=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, position=1, axisOrientation=ROW}",
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withAxisOrientation(AxisOrientation)}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withAxisOrientation(AxisOrientation)}
   */
  @Test
  @DisplayName("Test withAxisOrientation(AxisOrientation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withAxisOrientation(AxisOrientation)"
  })
  void testWithAxisOrientation() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioAxisItem actualWithAxisOrientationResult =
        immutableScenarioAxisItem.withAxisOrientation(AxisOrientation.ROW);

    // Assert
    assertSame(immutableScenarioAxisItem, actualWithAxisOrientationResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withAxisOrientation(AxisOrientation)}.
   *
   * <ul>
   *   <li>Then domainItem return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withAxisOrientation(AxisOrientation)}
   */
  @Test
  @DisplayName(
      "Test withAxisOrientation(AxisOrientation); then domainItem return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withAxisOrientation(AxisOrientation)"
  })
  void testWithAxisOrientation_thenDomainItemReturnImmutableEntityReference() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.COLUMN);

    // Act
    ImmutableScenarioAxisItem actualWithAxisOrientationResult =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build()
            .withAxisOrientation(AxisOrientation.ROW);

    // Assert
    EntityReference domainItemResult = actualWithAxisOrientationResult.domainItem();
    assertTrue(domainItemResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", domainItemResult.description());
    assertEquals(1, actualWithAxisOrientationResult.position());
    assertEquals(1L, domainItemResult.id());
    assertEquals(1L, actualWithAxisOrientationResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualWithAxisOrientationResult.axisOrientation());
    assertEquals(EntityKind.ALL, domainItemResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, domainItemResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withDomainItem(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withDomainItem(EntityReference)}
   */
  @Test
  @DisplayName("Test withDomainItem(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withDomainItem(EntityReference)"
  })
  void testWithDomainItem() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioAxisItem actualWithDomainItemResult =
        immutableScenarioAxisItem.withDomainItem(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableScenarioAxisItem, actualWithDomainItemResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableScenarioAxisItem actualWithIdResult = immutableScenarioAxisItem.withId(optional);

    // Assert
    assertSame(immutableScenarioAxisItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then domainItem return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then domainItem return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withId(Optional)"})
  void testWithIdWithOptional_thenDomainItemReturnImmutableEntityReference() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableScenarioAxisItem actualWithIdResult = immutableScenarioAxisItem.withId(optional);

    // Assert
    EntityReference domainItemResult = actualWithIdResult.domainItem();
    assertTrue(domainItemResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", domainItemResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, domainItemResult.id());
    assertEquals(1L, actualWithIdResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualWithIdResult.axisOrientation());
    assertEquals(EntityKind.ALL, domainItemResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, domainItemResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioAxisItem actualWithIdResult = immutableScenarioAxisItem.withId(1L);

    // Assert
    assertSame(immutableScenarioAxisItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then domainItem return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then domainItem return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenDomainItemReturnImmutableEntityReference() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act
    ImmutableScenarioAxisItem actualWithIdResult =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build()
            .withId(42L);

    // Assert
    EntityReference domainItemResult = actualWithIdResult.domainItem();
    assertTrue(domainItemResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", domainItemResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, domainItemResult.id());
    assertEquals(1L, actualWithIdResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualWithIdResult.axisOrientation());
    assertEquals(EntityKind.ALL, domainItemResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, domainItemResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(42)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableScenarioAxisItem actualWithPositionResult = immutableScenarioAxisItem.withPosition(42);

    // Assert
    assertSame(immutableScenarioAxisItem, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withPosition(int)}.
   *
   * <ul>
   *   <li>Then domainItem return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then domainItem return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withPosition(int)"})
  void testWithPosition_thenDomainItemReturnImmutableEntityReference() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act
    ImmutableScenarioAxisItem actualWithPositionResult =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build()
            .withPosition(42);

    // Assert
    EntityReference domainItemResult = actualWithPositionResult.domainItem();
    assertTrue(domainItemResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", domainItemResult.description());
    assertEquals(1L, domainItemResult.id());
    assertEquals(1L, actualWithPositionResult.scenarioId());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(AxisOrientation.ROW, actualWithPositionResult.axisOrientation());
    assertEquals(EntityKind.ALL, domainItemResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, domainItemResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withScenarioId(long)}.
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withScenarioId(long)"})
  void testWithScenarioId() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);
    ImmutableScenarioAxisItem immutableScenarioAxisItem =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(42L)
            .build();

    // Act
    ImmutableScenarioAxisItem actualWithScenarioIdResult =
        immutableScenarioAxisItem.withScenarioId(42L);

    // Assert
    assertSame(immutableScenarioAxisItem, actualWithScenarioIdResult);
  }

  /**
   * Test {@link ImmutableScenarioAxisItem#withScenarioId(long)}.
   *
   * <ul>
   *   <li>Then domainItem return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioAxisItem#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long); then domainItem return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioAxisItem ImmutableScenarioAxisItem.withScenarioId(long)"})
  void testWithScenarioId_thenDomainItemReturnImmutableEntityReference() {
    // Arrange
    Builder axisOrientationResult =
        ImmutableScenarioAxisItem.builder().axisOrientation(AxisOrientation.ROW);

    // Act
    ImmutableScenarioAxisItem actualWithScenarioIdResult =
        axisOrientationResult
            .domainItem(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .position(1)
            .scenarioId(1L)
            .build()
            .withScenarioId(42L);

    // Assert
    EntityReference domainItemResult = actualWithScenarioIdResult.domainItem();
    assertTrue(domainItemResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", domainItemResult.description());
    assertEquals(1, actualWithScenarioIdResult.position());
    assertEquals(1L, domainItemResult.id());
    assertEquals(42L, actualWithScenarioIdResult.scenarioId());
    assertEquals(AxisOrientation.ROW, actualWithScenarioIdResult.axisOrientation());
    assertEquals(EntityKind.ALL, domainItemResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, domainItemResult.entityLifecycleStatus());
  }
}
