package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramInstanceCreateCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramInstanceCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramInstanceCreateCommandDiffblueTest {
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
    "ImmutableOverlayDiagramInstanceCreateCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualNameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableEntityReference parentEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand =
            actualNameResult.parentEntityReference(parentEntityReference).svg("Svg").build();

    // Assert
    assertEquals("Name", actualImmutableOverlayDiagramInstanceCreateCommand.name());
    assertEquals("Svg", actualImmutableOverlayDiagramInstanceCreateCommand.svg());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableOverlayDiagramInstanceCreateCommand.description());
    assertEquals(1L, actualImmutableOverlayDiagramInstanceCreateCommand.diagramId().longValue());
    assertSame(
        parentEntityReference,
        actualImmutableOverlayDiagramInstanceCreateCommand.parentEntityReference());
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
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
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
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand =
            builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand);
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

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
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand =
            builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand);
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand2);
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
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description(null)
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand =
            builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand);
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramInstanceCreateCommand)} with {@code
   * OverlayDiagramInstanceCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramInstanceCreateCommand) with 'OverlayDiagramInstanceCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramInstanceCreateCommand)"})
  void testBuilderFromWithOverlayDiagramInstanceCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramInstanceCreateCommand)} with {@code
   * OverlayDiagramInstanceCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramInstanceCreateCommand) with 'OverlayDiagramInstanceCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramInstanceCreateCommand)"})
  void testBuilderFromWithOverlayDiagramInstanceCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description(null)
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramInstanceCreateCommand
        actualImmutableOverlayDiagramInstanceCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramInstanceCreateCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder parentEntityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentEntityReference(EntityReference)"})
  void testBuilderParentEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act
    Builder actualParentEntityReferenceResult =
        builderResult.parentEntityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualParentEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#svg(String)}.
   *
   * <ul>
   *   <li>When {@code Svg}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#svg(String)}
   */
  @Test
  @DisplayName("Test Builder svg(String); when 'Svg'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.svg(String)"})
  void testBuilderSvg_whenSvg_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramInstanceCreateCommand.builder();

    // Act
    Builder actualSvgResult = builderResult.svg("Svg");

    // Assert
    assertSame(builderResult, actualSvgResult);
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#copyOf(OverlayDiagramInstanceCreateCommand)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#copyOf(OverlayDiagramInstanceCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(OverlayDiagramInstanceCreateCommand); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.copyOf(OverlayDiagramInstanceCreateCommand)"
  })
  void testCopyOf_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand instance =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualCopyOfResult =
        ImmutableOverlayDiagramInstanceCreateCommand.copyOf(instance);

    // Assert
    EntityReference parentEntityReferenceResult = actualCopyOfResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}, and {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand2 =
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramInstanceCreateCommand,
        immutableOverlayDiagramInstanceCreateCommand2);
    assertEquals(
        immutableOverlayDiagramInstanceCreateCommand.hashCode(),
        immutableOverlayDiagramInstanceCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}, and {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(
        immutableOverlayDiagramInstanceCreateCommand, immutableOverlayDiagramInstanceCreateCommand);
    int expectedHashCodeResult = immutableOverlayDiagramInstanceCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramInstanceCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(2L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramInstanceCreateCommand,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Svg");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramInstanceCreateCommand,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    Builder nameResult2 =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramInstanceCreateCommand,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Name")
            .build();

    Builder nameResult2 =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramInstanceCreateCommand,
        nameResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramInstanceCreateCommand.equals(Object)",
    "int ImmutableOverlayDiagramInstanceCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build(),
        "Different type to ImmutableOverlayDiagramInstanceCreateCommand");
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenOne_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualFromJsonResult =
        ImmutableOverlayDiagramInstanceCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenOne_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    json.setDiagramId(1L);
    json.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setSvg("Json");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualFromJsonResult =
        ImmutableOverlayDiagramInstanceCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.svg());
    assertNull(actualFromJsonResult.description());
    assertEquals(1L, actualFromJsonResult.diagramId().longValue());
    EntityReference expectedParentEntityReferenceResult = json.parentEntityReference;
    assertSame(expectedParentEntityReferenceResult, actualFromJsonResult.parentEntityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#toString()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#description()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#diagramId()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#name()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#parentEntityReference()}
   *   <li>{@link ImmutableOverlayDiagramInstanceCreateCommand#svg()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableOverlayDiagramInstanceCreateCommand.description()",
    "Long ImmutableOverlayDiagramInstanceCreateCommand.diagramId()",
    "String ImmutableOverlayDiagramInstanceCreateCommand.name()",
    "EntityReference ImmutableOverlayDiagramInstanceCreateCommand.parentEntityReference()",
    "String ImmutableOverlayDiagramInstanceCreateCommand.svg()",
    "String ImmutableOverlayDiagramInstanceCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    String actualToStringResult = immutableOverlayDiagramInstanceCreateCommand.toString();
    String actualDescriptionResult = immutableOverlayDiagramInstanceCreateCommand.description();
    Long actualDiagramIdResult = immutableOverlayDiagramInstanceCreateCommand.diagramId();
    String actualNameResult = immutableOverlayDiagramInstanceCreateCommand.name();
    EntityReference actualParentEntityReferenceResult =
        immutableOverlayDiagramInstanceCreateCommand.parentEntityReference();

    // Assert
    assertTrue(actualParentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualNameResult);
    assertEquals(
        "OverlayDiagramInstanceCreateCommand{name=Name, diagramId=1, parentEntityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, svg=Svg}",
        actualToStringResult);
    assertEquals("Svg", immutableOverlayDiagramInstanceCreateCommand.svg());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualDiagramIdResult.longValue());
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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setDiagramId(Long)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setParentEntityReference(EntityReference)}
   *   <li>{@link Json#setSvg(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setDiagramId(Long)",
    "void Json.setName(String)",
    "void Json.setParentEntityReference(EntityReference)",
    "void Json.setSvg(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setDiagramId(1L);
    actualJson.setName("Name");
    actualJson.setParentEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setSvg("Svg");

    // Assert
    assertEquals(1L, actualJson.diagramId.longValue());
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
   * Test Json {@link Json#parentEntityReference()}.
   *
   * <p>Method under test: {@link Json#parentEntityReference()}
   */
  @Test
  @DisplayName("Test Json parentEntityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parentEntityReference()"})
  void testJsonParentEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentEntityReference());
  }

  /**
   * Test Json {@link Json#svg()}.
   *
   * <p>Method under test: {@link Json#svg()}
   */
  @Test
  @DisplayName("Test Json svg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.svg()"})
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().svg());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithDescriptionResult =
        immutableOverlayDiagramInstanceCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableOverlayDiagramInstanceCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("42")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithDescriptionResult =
        immutableOverlayDiagramInstanceCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableOverlayDiagramInstanceCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withDiagramId(Long)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#withDiagramId(Long)}
   */
  @Test
  @DisplayName("Test withDiagramId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withDiagramId(Long)"
  })
  void testWithDiagramId() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithDiagramIdResult =
        immutableOverlayDiagramInstanceCreateCommand.withDiagramId(1L);

    // Assert
    assertSame(immutableOverlayDiagramInstanceCreateCommand, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withDiagramId(Long)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#withDiagramId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(Long); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withDiagramId(Long)"
  })
  void testWithDiagramId_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithDiagramIdResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build()
            .withDiagramId(42L);

    // Assert
    EntityReference parentEntityReferenceResult = actualWithDiagramIdResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithDiagramIdResult.name());
    assertEquals("Svg", actualWithDiagramIdResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramIdResult.description());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(42L, actualWithDiagramIdResult.diagramId().longValue());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("42");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithNameResult =
        immutableOverlayDiagramInstanceCreateCommand.withName("42");

    // Assert
    assertSame(immutableOverlayDiagramInstanceCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withName(String)"
  })
  void testWithName_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithNameResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build()
            .withName("42");

    // Assert
    EntityReference parentEntityReferenceResult = actualWithNameResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Svg", actualWithNameResult.svg());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#withParentEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramInstanceCreateCommand#withParentEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withParentEntityReference(EntityReference)"
  })
  void testWithParentEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithParentEntityReferenceResult =
        immutableOverlayDiagramInstanceCreateCommand.withParentEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(
        immutableOverlayDiagramInstanceCreateCommand, actualWithParentEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withSvg(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withSvg(String)"
  })
  void testWithSvg() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");
    ImmutableOverlayDiagramInstanceCreateCommand immutableOverlayDiagramInstanceCreateCommand =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("42")
            .build();

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithSvgResult =
        immutableOverlayDiagramInstanceCreateCommand.withSvg("42");

    // Assert
    assertSame(immutableOverlayDiagramInstanceCreateCommand, actualWithSvgResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramInstanceCreateCommand#withSvg(String)}.
   *
   * <ul>
   *   <li>Then parentEntityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramInstanceCreateCommand#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String); then parentEntityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramInstanceCreateCommand ImmutableOverlayDiagramInstanceCreateCommand.withSvg(String)"
  })
  void testWithSvg_thenParentEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder nameResult =
        ImmutableOverlayDiagramInstanceCreateCommand.builder()
            .description("The characteristics of someone or something")
            .diagramId(1L)
            .name("Name");

    // Act
    ImmutableOverlayDiagramInstanceCreateCommand actualWithSvgResult =
        nameResult
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .svg("Svg")
            .build()
            .withSvg("42");

    // Assert
    EntityReference parentEntityReferenceResult = actualWithSvgResult.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithSvgResult.svg());
    assertEquals("Name", actualWithSvgResult.name());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualWithSvgResult.description());
    assertEquals(1L, actualWithSvgResult.diagramId().longValue());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
  }
}
