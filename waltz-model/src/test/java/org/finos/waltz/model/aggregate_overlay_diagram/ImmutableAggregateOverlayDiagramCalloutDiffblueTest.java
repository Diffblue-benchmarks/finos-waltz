package org.finos.waltz.model.aggregate_overlay_diagram;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramCallout.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagramCallout.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAggregateOverlayDiagramCalloutDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAggregateOverlayDiagramCallout Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableAggregateOverlayDiagramCallout actualImmutableAggregateOverlayDiagramCallout =
        actualIdResult.id(id).startColor("Start Color").title("Dr").build();

    // Assert
    assertEquals("42", actualImmutableAggregateOverlayDiagramCallout.cellExternalId());
    assertEquals("Dr", actualImmutableAggregateOverlayDiagramCallout.title());
    assertEquals("End Color", actualImmutableAggregateOverlayDiagramCallout.endColor());
    assertEquals(
        "Not all who wander are lost", actualImmutableAggregateOverlayDiagramCallout.content());
    assertEquals("Start Color", actualImmutableAggregateOverlayDiagramCallout.startColor());
    assertEquals(1L, actualImmutableAggregateOverlayDiagramCallout.diagramInstanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#content(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#content(String)}
   */
  @Test
  @DisplayName(
      "Test Builder content(String); when 'Not all who wander are lost'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.content(String)"})
  void testBuilderContent_whenNotAllWhoWanderAreLost_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act
    Builder actualContentResult = builderResult.content("Not all who wander are lost");

    // Assert
    assertSame(builderResult, actualContentResult);
  }

  /**
   * Test Builder {@link Builder#diagramInstanceId(Long)}.
   *
   * <p>Method under test: {@link Builder#diagramInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramInstanceId(Long)"})
  void testBuilderDiagramInstanceId() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act
    Builder actualDiagramInstanceIdResult = builderResult.diagramInstanceId(1L);

    // Assert
    assertSame(builderResult, actualDiagramInstanceIdResult);
  }

  /**
   * Test Builder {@link Builder#endColor(String)}.
   *
   * <ul>
   *   <li>When {@code End Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#endColor(String)}
   */
  @Test
  @DisplayName("Test Builder endColor(String); when 'End Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.endColor(String)"})
  void testBuilderEndColor_whenEndColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act
    Builder actualEndColorResult = builderResult.endColor("End Color");

    // Assert
    assertSame(builderResult, actualEndColorResult);
  }

  /**
   * Test Builder {@link Builder#from(AggregateOverlayDiagramCallout)} with {@code
   * AggregateOverlayDiagramCallout}.
   *
   * <p>Method under test: {@link Builder#from(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AggregateOverlayDiagramCallout) with 'AggregateOverlayDiagramCallout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AggregateOverlayDiagramCallout)"})
  void testBuilderFromWithAggregateOverlayDiagramCallout() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    ImmutableAggregateOverlayDiagramCallout instance =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAggregateOverlayDiagramCallout actualImmutableAggregateOverlayDiagramCallout =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramCallout);
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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    ImmutableAggregateOverlayDiagramCallout instance =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableAggregateOverlayDiagramCallout actualImmutableAggregateOverlayDiagramCallout =
        builderResult.build();
    assertEquals(instance, actualImmutableAggregateOverlayDiagramCallout);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

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
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#startColor(String)}.
   *
   * <ul>
   *   <li>When {@code Start Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#startColor(String)}
   */
  @Test
  @DisplayName("Test Builder startColor(String); when 'Start Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.startColor(String)"})
  void testBuilderStartColor_whenStartColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act
    Builder actualStartColorResult = builderResult.startColor("Start Color");

    // Assert
    assertSame(builderResult, actualStartColorResult);
  }

  /**
   * Test Builder {@link Builder#title(String)}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#title(String)}
   */
  @Test
  @DisplayName("Test Builder title(String); when 'Dr'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(String)"})
  void testBuilderTitle_whenDr_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAggregateOverlayDiagramCallout.builder();

    // Act
    Builder actualTitleResult = builderResult.title("Dr");

    // Assert
    assertSame(builderResult, actualTitleResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#copyOf(AggregateOverlayDiagramCallout)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramCallout#copyOf(AggregateOverlayDiagramCallout)}
   */
  @Test
  @DisplayName("Test copyOf(AggregateOverlayDiagramCallout); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.copyOf(AggregateOverlayDiagramCallout)"
  })
  void testCopyOf_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout instance =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualCopyOfResult =
        ImmutableAggregateOverlayDiagramCallout.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("End Color", actualCopyOfResult.endColor());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals("Start Color", actualCopyOfResult.startColor());
    assertEquals(1L, actualCopyOfResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramCallout#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout2 =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagramCallout, immutableAggregateOverlayDiagramCallout2);
    assertEquals(
        immutableAggregateOverlayDiagramCallout.hashCode(),
        immutableAggregateOverlayDiagramCallout2.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}, and {@link
   * ImmutableAggregateOverlayDiagramCallout#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(immutableAggregateOverlayDiagramCallout, immutableAggregateOverlayDiagramCallout);
    int expectedHashCodeResult = immutableAggregateOverlayDiagramCallout.hashCode();
    assertEquals(expectedHashCodeResult, immutableAggregateOverlayDiagramCallout.hashCode());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("Dr")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("42")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(2L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("42")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(2L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("42")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Mr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAggregateOverlayDiagramCallout,
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAggregateOverlayDiagramCallout.equals(Object)",
    "int ImmutableAggregateOverlayDiagramCallout.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build(),
        "Different type to ImmutableAggregateOverlayDiagramCallout");
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return cellExternalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Id is 'null'; then return cellExternalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonIdIsNull_thenReturnCellExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setDiagramInstanceId(1L);
    json.setCellExternalId("Json");
    json.setTitle("Json");
    json.setContent("Json");
    json.setStartColor("Json");
    json.setEndColor("Json");

    // Act
    ImmutableAggregateOverlayDiagramCallout actualFromJsonResult =
        ImmutableAggregateOverlayDiagramCallout.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals("Json", actualFromJsonResult.content());
    assertEquals("Json", actualFromJsonResult.endColor());
    assertEquals("Json", actualFromJsonResult.startColor());
    assertEquals("Json", actualFromJsonResult.title());
    assertEquals(1L, actualFromJsonResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>Then return cellExternalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given of forty-two; then return cellExternalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.fromJson(Json)"
  })
  void testFromJson_givenOfFortyTwo_thenReturnCellExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(42L);
    json.setId(id);
    json.setDiagramInstanceId(1L);
    json.setCellExternalId("Json");
    json.setTitle("Json");
    json.setContent("Json");
    json.setStartColor("Json");
    json.setEndColor("Json");

    // Act
    ImmutableAggregateOverlayDiagramCallout actualFromJsonResult =
        ImmutableAggregateOverlayDiagramCallout.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals("Json", actualFromJsonResult.content());
    assertEquals("Json", actualFromJsonResult.endColor());
    assertEquals("Json", actualFromJsonResult.startColor());
    assertEquals("Json", actualFromJsonResult.title());
    assertEquals(1L, actualFromJsonResult.diagramInstanceId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#cellExternalId()}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#content()}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#diagramInstanceId()}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#endColor()}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#startColor()}
   *   <li>{@link ImmutableAggregateOverlayDiagramCallout#title()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAggregateOverlayDiagramCallout.cellExternalId()",
    "String ImmutableAggregateOverlayDiagramCallout.content()",
    "Long ImmutableAggregateOverlayDiagramCallout.diagramInstanceId()",
    "String ImmutableAggregateOverlayDiagramCallout.endColor()",
    "String ImmutableAggregateOverlayDiagramCallout.startColor()",
    "String ImmutableAggregateOverlayDiagramCallout.title()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    String actualCellExternalIdResult = immutableAggregateOverlayDiagramCallout.cellExternalId();
    String actualContentResult = immutableAggregateOverlayDiagramCallout.content();
    Long actualDiagramInstanceIdResult =
        immutableAggregateOverlayDiagramCallout.diagramInstanceId();
    String actualEndColorResult = immutableAggregateOverlayDiagramCallout.endColor();
    String actualStartColorResult = immutableAggregateOverlayDiagramCallout.startColor();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals("Dr", immutableAggregateOverlayDiagramCallout.title());
    assertEquals("End Color", actualEndColorResult);
    assertEquals("Not all who wander are lost", actualContentResult);
    assertEquals("Start Color", actualStartColorResult);
    assertEquals(1L, actualDiagramInstanceIdResult.longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#id()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAggregateOverlayDiagramCallout.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
  }

  /**
   * Test Json {@link Json#content()}.
   *
   * <p>Method under test: {@link Json#content()}
   */
  @Test
  @DisplayName("Test Json content()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.content()"})
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().content());
  }

  /**
   * Test Json {@link Json#diagramInstanceId()}.
   *
   * <p>Method under test: {@link Json#diagramInstanceId()}
   */
  @Test
  @DisplayName("Test Json diagramInstanceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.diagramInstanceId()"})
  void testJsonDiagramInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramInstanceId());
  }

  /**
   * Test Json {@link Json#endColor()}.
   *
   * <p>Method under test: {@link Json#endColor()}
   */
  @Test
  @DisplayName("Test Json endColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.endColor()"})
  void testJsonEndColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().endColor());
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
    assertNull(actualJson.diagramInstanceId);
    assertNull(actualJson.cellExternalId);
    assertNull(actualJson.content);
    assertNull(actualJson.endColor);
    assertNull(actualJson.startColor);
    assertNull(actualJson.title);
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#startColor()}.
   *
   * <p>Method under test: {@link Json#startColor()}
   */
  @Test
  @DisplayName("Test Json startColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.startColor()"})
  void testJsonStartColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().startColor());
  }

  /**
   * Test Json {@link Json#title()}.
   *
   * <p>Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().title());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#toString()}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAggregateOverlayDiagramCallout.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AggregateOverlayDiagramCallout{id=1, diagramInstanceId=1, cellExternalId=42, title=Dr, content=Not all"
            + " who wander are lost, startColor=Start Color, endColor=End Color}",
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withCellExternalId(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramCallout#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withCellExternalId(String)"
  })
  void testWithCellExternalId() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithCellExternalIdResult =
        immutableAggregateOverlayDiagramCallout.withCellExternalId("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramCallout#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithCellExternalIdResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("cellExternalId")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertEquals("Dr", actualWithCellExternalIdResult.title());
    assertEquals("End Color", actualWithCellExternalIdResult.endColor());
    assertEquals("Not all who wander are lost", actualWithCellExternalIdResult.content());
    assertEquals("Start Color", actualWithCellExternalIdResult.startColor());
    assertEquals(1L, actualWithCellExternalIdResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withContent(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withContent(String)}
   */
  @Test
  @DisplayName("Test withContent(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withContent(String)"
  })
  void testWithContent() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("42")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithContentResult =
        immutableAggregateOverlayDiagramCallout.withContent("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithContentResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withContent(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withContent(String)}
   */
  @Test
  @DisplayName("Test withContent(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withContent(String)"
  })
  void testWithContent_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithContentResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withContent("42");

    // Assert
    assertEquals("42", actualWithContentResult.cellExternalId());
    assertEquals("42", actualWithContentResult.content());
    assertEquals("Dr", actualWithContentResult.title());
    assertEquals("End Color", actualWithContentResult.endColor());
    assertEquals("Start Color", actualWithContentResult.startColor());
    assertEquals(1L, actualWithContentResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withDiagramInstanceId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramCallout#withDiagramInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withDiagramInstanceId(Long)"
  })
  void testWithDiagramInstanceId() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithDiagramInstanceIdResult =
        immutableAggregateOverlayDiagramCallout.withDiagramInstanceId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithDiagramInstanceIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withDiagramInstanceId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAggregateOverlayDiagramCallout#withDiagramInstanceId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramInstanceId(Long); when forty-two; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withDiagramInstanceId(Long)"
  })
  void testWithDiagramInstanceId_whenFortyTwo_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithDiagramInstanceIdResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withDiagramInstanceId(42L);

    // Assert
    assertEquals("42", actualWithDiagramInstanceIdResult.cellExternalId());
    assertEquals("Dr", actualWithDiagramInstanceIdResult.title());
    assertEquals("End Color", actualWithDiagramInstanceIdResult.endColor());
    assertEquals("Not all who wander are lost", actualWithDiagramInstanceIdResult.content());
    assertEquals("Start Color", actualWithDiagramInstanceIdResult.startColor());
    assertEquals(42L, actualWithDiagramInstanceIdResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withEndColor(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withEndColor(String)}
   */
  @Test
  @DisplayName("Test withEndColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withEndColor(String)"
  })
  void testWithEndColor() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("42")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithEndColorResult =
        immutableAggregateOverlayDiagramCallout.withEndColor("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithEndColorResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withEndColor(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withEndColor(String)}
   */
  @Test
  @DisplayName("Test withEndColor(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withEndColor(String)"
  })
  void testWithEndColor_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithEndColorResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withEndColor("42");

    // Assert
    assertEquals("42", actualWithEndColorResult.cellExternalId());
    assertEquals("42", actualWithEndColorResult.endColor());
    assertEquals("Dr", actualWithEndColorResult.title());
    assertEquals("Not all who wander are lost", actualWithEndColorResult.content());
    assertEquals("Start Color", actualWithEndColorResult.startColor());
    assertEquals(1L, actualWithEndColorResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithIdResult =
        immutableAggregateOverlayDiagramCallout.withId(optional);

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithIdResult =
        immutableAggregateOverlayDiagramCallout.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.cellExternalId());
    assertEquals("Dr", actualWithIdResult.title());
    assertEquals("End Color", actualWithIdResult.endColor());
    assertEquals("Not all who wander are lost", actualWithIdResult.content());
    assertEquals("Start Color", actualWithIdResult.startColor());
    assertEquals(1L, actualWithIdResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithIdResult =
        immutableAggregateOverlayDiagramCallout.withId(1L);

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithIdResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.cellExternalId());
    assertEquals("Dr", actualWithIdResult.title());
    assertEquals("End Color", actualWithIdResult.endColor());
    assertEquals("Not all who wander are lost", actualWithIdResult.content());
    assertEquals("Start Color", actualWithIdResult.startColor());
    assertEquals(1L, actualWithIdResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withStartColor(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withStartColor(String)}
   */
  @Test
  @DisplayName("Test withStartColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withStartColor(String)"
  })
  void testWithStartColor() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("42")
            .title("Dr")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithStartColorResult =
        immutableAggregateOverlayDiagramCallout.withStartColor("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithStartColorResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withStartColor(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withStartColor(String)}
   */
  @Test
  @DisplayName("Test withStartColor(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withStartColor(String)"
  })
  void testWithStartColor_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithStartColorResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withStartColor("42");

    // Assert
    assertEquals("42", actualWithStartColorResult.cellExternalId());
    assertEquals("42", actualWithStartColorResult.startColor());
    assertEquals("Dr", actualWithStartColorResult.title());
    assertEquals("End Color", actualWithStartColorResult.endColor());
    assertEquals("Not all who wander are lost", actualWithStartColorResult.content());
    assertEquals(1L, actualWithStartColorResult.diagramInstanceId().longValue());
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withTitle(String)}.
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withTitle(String)"
  })
  void testWithTitle() {
    // Arrange
    ImmutableAggregateOverlayDiagramCallout immutableAggregateOverlayDiagramCallout =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("42")
            .build();

    // Act
    ImmutableAggregateOverlayDiagramCallout actualWithTitleResult =
        immutableAggregateOverlayDiagramCallout.withTitle("42");

    // Assert
    assertSame(immutableAggregateOverlayDiagramCallout, actualWithTitleResult);
  }

  /**
   * Test {@link ImmutableAggregateOverlayDiagramCallout#withTitle(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAggregateOverlayDiagramCallout#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAggregateOverlayDiagramCallout ImmutableAggregateOverlayDiagramCallout.withTitle(String)"
  })
  void testWithTitle_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableAggregateOverlayDiagramCallout actualWithTitleResult =
        ImmutableAggregateOverlayDiagramCallout.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .diagramInstanceId(1L)
            .endColor("End Color")
            .id(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withTitle("42");

    // Assert
    assertEquals("42", actualWithTitleResult.cellExternalId());
    assertEquals("42", actualWithTitleResult.title());
    assertEquals("End Color", actualWithTitleResult.endColor());
    assertEquals("Not all who wander are lost", actualWithTitleResult.content());
    assertEquals("Start Color", actualWithTitleResult.startColor());
    assertEquals(1L, actualWithTitleResult.diagramInstanceId().longValue());
  }
}
