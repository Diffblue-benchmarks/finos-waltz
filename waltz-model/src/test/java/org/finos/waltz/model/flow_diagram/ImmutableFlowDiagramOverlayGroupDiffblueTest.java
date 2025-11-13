package org.finos.waltz.model.flow_diagram;

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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroup.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramOverlayGroup.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramOverlayGroupDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup =
        actualIdResult.id(id).name("Name").build();

    // Assert
    assertEquals("42", actualImmutableFlowDiagramOverlayGroup.externalId());
    assertEquals("Name", actualImmutableFlowDiagramOverlayGroup.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableFlowDiagramOverlayGroup.description());
    assertEquals(1L, actualImmutableFlowDiagramOverlayGroup.diagramId().longValue());
    assertFalse(actualImmutableFlowDiagramOverlayGroup.isDefault());
  }

  /**
   * Test Builder {@link Builder#diagramId(Long)}.
   *
   * <p>Method under test: {@link Builder#diagramId(Long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Long)"})
  void testBuilderDiagramId() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramOverlayGroup)} with {@code
   * FlowDiagramOverlayGroup}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagramOverlayGroup)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramOverlayGroup) with 'FlowDiagramOverlayGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramOverlayGroup)"})
  void testBuilderFromWithFlowDiagramOverlayGroup() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramOverlayGroup)} with {@code
   * FlowDiagramOverlayGroup}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagramOverlayGroup)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramOverlayGroup) with 'FlowDiagramOverlayGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramOverlayGroup)"})
  void testBuilderFromWithFlowDiagramOverlayGroup2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description(null)
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroup);
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
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroup);
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
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

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
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description(null)
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableFlowDiagramOverlayGroup actualImmutableFlowDiagramOverlayGroup = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramOverlayGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

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
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isDefault(boolean)}.
   *
   * <p>Method under test: {@link Builder#isDefault(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isDefault(boolean)"})
  void testBuilderIsDefault() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act
    Builder actualIsDefaultResult = builderResult.isDefault(true);

    // Assert
    assertSame(builderResult, actualIsDefaultResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramOverlayGroup.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#copyOf(FlowDiagramOverlayGroup)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#copyOf(FlowDiagramOverlayGroup)}
   */
  @Test
  @DisplayName("Test copyOf(FlowDiagramOverlayGroup); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.copyOf(FlowDiagramOverlayGroup)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup instance =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualCopyOfResult =
        ImmutableFlowDiagramOverlayGroup.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertFalse(actualCopyOfResult.isDefault());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}, and {@link
   * ImmutableFlowDiagramOverlayGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup2 =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagramOverlayGroup, immutableFlowDiagramOverlayGroup2);
    assertEquals(
        immutableFlowDiagramOverlayGroup.hashCode(), immutableFlowDiagramOverlayGroup2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}, and {@link
   * ImmutableFlowDiagramOverlayGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagramOverlayGroup, immutableFlowDiagramOverlayGroup);
    int expectedHashCodeResult = immutableFlowDiagramOverlayGroup.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowDiagramOverlayGroup.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(2L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroup,
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("Name")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroup,
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(2L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroup,
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramOverlayGroup,
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramOverlayGroup.equals(Object)",
    "int ImmutableFlowDiagramOverlayGroup.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build(),
        "Different type to ImmutableFlowDiagramOverlayGroup");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#description()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#diagramId()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#externalId()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#isDefault()}
   *   <li>{@link ImmutableFlowDiagramOverlayGroup#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFlowDiagramOverlayGroup.description()",
    "Long ImmutableFlowDiagramOverlayGroup.diagramId()",
    "String ImmutableFlowDiagramOverlayGroup.externalId()",
    "boolean ImmutableFlowDiagramOverlayGroup.isDefault()",
    "String ImmutableFlowDiagramOverlayGroup.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableFlowDiagramOverlayGroup.description();
    Long actualDiagramIdResult = immutableFlowDiagramOverlayGroup.diagramId();
    String actualExternalIdResult = immutableFlowDiagramOverlayGroup.externalId();
    boolean actualIsDefaultResult = immutableFlowDiagramOverlayGroup.isDefault();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals("Name", immutableFlowDiagramOverlayGroup.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualDiagramIdResult.longValue());
    assertFalse(actualIsDefaultResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#id()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowDiagramOverlayGroup.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
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
   * Test Json {@link Json#isDefault()}.
   *
   * <p>Method under test: {@link Json#isDefault()}
   */
  @Test
  @DisplayName("Test Json isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isDefault()"})
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isDefault());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.diagramId);
    assertNull(actualJson.description);
    assertNull(actualJson.externalId);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
  }

  /**
   * Test Json {@link Json#setIsDefault(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsDefault(boolean)"})
  void testJsonSetIsDefault() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowDiagramOverlayGroup.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowDiagramOverlayGroup{id=1, name=Name, diagramId=1, externalId=42, isDefault=false}",
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithDescriptionResult =
        immutableFlowDiagramOverlayGroup.withDescription("42");

    // Assert
    assertEquals(immutableFlowDiagramOverlayGroup, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("42")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithDescriptionResult =
        immutableFlowDiagramOverlayGroup.withDescription("42");

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withDiagramId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withDiagramId(Long)"
  })
  void testWithDiagramId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithDiagramIdResult =
        immutableFlowDiagramOverlayGroup.withDiagramId(1L);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withDiagramId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long); when forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withDiagramId(Long)"
  })
  void testWithDiagramId_whenFortyTwo_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup actualWithDiagramIdResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withDiagramId(42L);

    // Assert
    assertEquals("42", actualWithDiagramIdResult.externalId());
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    assertEquals(42L, actualWithDiagramIdResult.diagramId().longValue());
    assertFalse(actualWithDiagramIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("0123456789ABCDEF")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithExternalIdResult =
        immutableFlowDiagramOverlayGroup.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withExternalId(String)"
  })
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup actualWithExternalIdResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.diagramId().longValue());
    assertFalse(actualWithExternalIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithIdResult =
        immutableFlowDiagramOverlayGroup.withId(optional);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithIdResult =
        immutableFlowDiagramOverlayGroup.withId(optional);

    // Assert
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.diagramId().longValue());
    assertFalse(actualWithIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithIdResult =
        immutableFlowDiagramOverlayGroup.withId(1L);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup actualWithIdResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("42", actualWithIdResult.externalId());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.diagramId().longValue());
    assertFalse(actualWithIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withIsDefault(boolean)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test withIsDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withIsDefault(boolean)"
  })
  void testWithIsDefault() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithIsDefaultResult =
        immutableFlowDiagramOverlayGroup.withIsDefault(false);

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithIsDefaultResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withIsDefault(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test withIsDefault(boolean); when 'true'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withIsDefault(boolean)"
  })
  void testWithIsDefault_whenTrue_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup actualWithIsDefaultResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withIsDefault(true);

    // Assert
    assertEquals("42", actualWithIsDefaultResult.externalId());
    assertEquals("Name", actualWithIsDefaultResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsDefaultResult.description());
    assertEquals(1L, actualWithIsDefaultResult.diagramId().longValue());
    assertTrue(actualWithIsDefaultResult.isDefault());
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableFlowDiagramOverlayGroup immutableFlowDiagramOverlayGroup =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("42")
            .build();

    // Act
    ImmutableFlowDiagramOverlayGroup actualWithNameResult =
        immutableFlowDiagramOverlayGroup.withName("42");

    // Assert
    assertSame(immutableFlowDiagramOverlayGroup, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramOverlayGroup#withName(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramOverlayGroup#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramOverlayGroup ImmutableFlowDiagramOverlayGroup.withName(String)"
  })
  void testWithName_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableFlowDiagramOverlayGroup actualWithNameResult =
        ImmutableFlowDiagramOverlayGroup.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .externalId("42")
            .id(1L)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.externalId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.diagramId().longValue());
    assertFalse(actualWithNameResult.isDefault());
  }
}
