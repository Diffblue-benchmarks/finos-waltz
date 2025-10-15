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
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramSaveCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramSaveCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramSaveCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBackingEntities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllBackingEntities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllBackingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllBackingEntities(Iterable)"})
  void testBuilderAddAllBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualAddAllBackingEntitiesResult =
        builderResult.addAllBackingEntities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllBackingEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  @DisplayName(
      "Test Builder addBackingEntities(BackingEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity)"})
  void testBuilderAddBackingEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualAddBackingEntitiesResult =
        builderResult.addBackingEntities(new ImmutableBackingEntity.Json());

    // Assert
    assertSame(builderResult, actualAddBackingEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  @DisplayName(
      "Test Builder addBackingEntities(BackingEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity[])"})
  void testBuilderAddBackingEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualAddBackingEntitiesResult =
        builderResult.addBackingEntities(new ImmutableBackingEntity.Json());

    // Assert
    assertSame(builderResult, actualAddBackingEntitiesResult);
  }

  /**
   * Test Builder {@link Builder#aggregatedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#aggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder aggregatedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.aggregatedEntityKind(EntityKind)"})
  void testBuilderAggregatedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualAggregatedEntityKindResult = builderResult.aggregatedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAggregatedEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#backingEntities(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#backingEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder backingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.backingEntities(Iterable)"})
  void testBuilderBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualBackingEntitiesResult = builderResult.backingEntities(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualBackingEntitiesResult);
  }

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
    "ImmutableOverlayDiagramSaveCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        actualIdResult.id(id).layoutData("Layout Data").name("Name").build();

    // Assert
    assertEquals("Layout Data", actualImmutableOverlayDiagramSaveCommand.layoutData());
    assertEquals("Name", actualImmutableOverlayDiagramSaveCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableOverlayDiagramSaveCommand.description());
    assertEquals(EntityKind.ALL, actualImmutableOverlayDiagramSaveCommand.aggregatedEntityKind());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY,
        actualImmutableOverlayDiagramSaveCommand.diagramKind());
    assertTrue(actualImmutableOverlayDiagramSaveCommand.backingEntities().isEmpty());
  }

  /**
   * Test Builder {@link Builder#diagramKind(OverlayDiagramKind)}.
   *
   * <p>Method under test: {@link Builder#diagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test Builder diagramKind(OverlayDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramKind(OverlayDiagramKind)"})
  void testBuilderDiagramKind() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualDiagramKindResult =
        builderResult.diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    assertSame(builderResult, actualDiagramKindResult);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    ImmutableOverlayDiagramSaveCommand instance =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand);
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand2);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    ImmutableOverlayDiagramSaveCommand instance =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand);
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand2);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    ImmutableOverlayDiagramSaveCommand instance =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand);
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand2);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code
   * OverlayDiagramSaveCommand}.
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    ImmutableOverlayDiagramSaveCommand instance =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand);
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand2);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code
   * OverlayDiagramSaveCommand}.
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    ImmutableOverlayDiagramSaveCommand instance =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description(null)
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand);
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand2);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code
   * OverlayDiagramSaveCommand}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    Builder builderResult2 = ImmutableOverlayDiagramSaveCommand.builder();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    builderResult2.addBackingEntities(
        cellIdResult
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
    ImmutableOverlayDiagramSaveCommand instance =
        builderResult2
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOverlayDiagramSaveCommand actualImmutableOverlayDiagramSaveCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableOverlayDiagramSaveCommand);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#layoutData(String)}.
   *
   * <ul>
   *   <li>When {@code Layout Data}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#layoutData(String)}
   */
  @Test
  @DisplayName("Test Builder layoutData(String); when 'Layout Data'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.layoutData(String)"})
  void testBuilderLayoutData_whenLayoutData_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualLayoutDataResult = builderResult.layoutData("Layout Data");

    // Assert
    assertSame(builderResult, actualLayoutDataResult);
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
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#copyOf(OverlayDiagramSaveCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Layout Data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramSaveCommand#copyOf(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test copyOf(OverlayDiagramSaveCommand); then return 'Layout Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.copyOf(OverlayDiagramSaveCommand)"
  })
  void testCopyOf_thenReturnLayoutData() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand instance =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualCopyOfResult =
        ImmutableOverlayDiagramSaveCommand.copyOf(instance);

    // Assert
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualCopyOfResult.diagramKind());
    assertTrue(actualCopyOfResult.backingEntities().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}, and {@link
   * ImmutableOverlayDiagramSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand2 =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableOverlayDiagramSaveCommand, immutableOverlayDiagramSaveCommand2);
    assertEquals(
        immutableOverlayDiagramSaveCommand.hashCode(),
        immutableOverlayDiagramSaveCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}, and {@link
   * ImmutableOverlayDiagramSaveCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableOverlayDiagramSaveCommand, immutableOverlayDiagramSaveCommand);
    int expectedHashCodeResult = immutableOverlayDiagramSaveCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableOverlayDiagramSaveCommand.hashCode());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    builderResult.addBackingEntities(
        cellIdResult
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
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        builderResult
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramSaveCommand,
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ACTOR)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramSaveCommand,
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_STATIC_SVG_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramSaveCommand,
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(2L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramSaveCommand,
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Name")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramSaveCommand,
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Layout Data")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOverlayDiagramSaveCommand,
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOverlayDiagramSaveCommand.equals(Object)",
    "int ImmutableOverlayDiagramSaveCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build(),
        "Different type to ImmutableOverlayDiagramSaveCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#aggregatedEntityKind()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#backingEntities()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#description()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#diagramKind()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#layoutData()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityKind ImmutableOverlayDiagramSaveCommand.aggregatedEntityKind()",
    "Set ImmutableOverlayDiagramSaveCommand.backingEntities()",
    "String ImmutableOverlayDiagramSaveCommand.description()",
    "OverlayDiagramKind ImmutableOverlayDiagramSaveCommand.diagramKind()",
    "String ImmutableOverlayDiagramSaveCommand.layoutData()",
    "String ImmutableOverlayDiagramSaveCommand.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    EntityKind actualAggregatedEntityKindResult =
        immutableOverlayDiagramSaveCommand.aggregatedEntityKind();
    Set<BackingEntity> actualBackingEntitiesResult =
        immutableOverlayDiagramSaveCommand.backingEntities();
    String actualDescriptionResult = immutableOverlayDiagramSaveCommand.description();
    OverlayDiagramKind actualDiagramKindResult = immutableOverlayDiagramSaveCommand.diagramKind();
    String actualLayoutDataResult = immutableOverlayDiagramSaveCommand.layoutData();

    // Assert
    assertEquals("Layout Data", actualLayoutDataResult);
    assertEquals("Name", immutableOverlayDiagramSaveCommand.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualAggregatedEntityKindResult);
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualDiagramKindResult);
    assertTrue(actualBackingEntitiesResult.isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#id()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableOverlayDiagramSaveCommand.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#aggregatedEntityKind()}.
   *
   * <p>Method under test: {@link Json#aggregatedEntityKind()}
   */
  @Test
  @DisplayName("Test Json aggregatedEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.aggregatedEntityKind()"})
  void testJsonAggregatedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().aggregatedEntityKind());
  }

  /**
   * Test Json {@link Json#backingEntities()}.
   *
   * <p>Method under test: {@link Json#backingEntities()}
   */
  @Test
  @DisplayName("Test Json backingEntities()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.backingEntities()"})
  void testJsonBackingEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().backingEntities());
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
   * Test Json {@link Json#diagramKind()}.
   *
   * <p>Method under test: {@link Json#diagramKind()}
   */
  @Test
  @DisplayName("Test Json diagramKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OverlayDiagramKind Json.diagramKind()"})
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramKind());
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
   * Test Json {@link Json#layoutData()}.
   *
   * <p>Method under test: {@link Json#layoutData()}
   */
  @Test
  @DisplayName("Test Json layoutData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.layoutData()"})
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().layoutData());
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
    assertNull(actualJson.description);
    assertNull(actualJson.layoutData);
    assertNull(actualJson.name);
    assertNull(actualJson.aggregatedEntityKind);
    assertNull(actualJson.diagramKind);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.backingEntities.isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableOverlayDiagramSaveCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "OverlayDiagramSaveCommand{id=1, name=Name, layoutData=Layout Data, aggregatedEntityKind=ALL,"
            + " diagramKind=WALTZ_ENTITY_OVERLAY, backingEntities=[]}",
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withAggregatedEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramSaveCommand#withAggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAggregatedEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withAggregatedEntityKind(EntityKind)"
  })
  void testWithAggregatedEntityKind() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithAggregatedEntityKindResult =
        immutableOverlayDiagramSaveCommand.withAggregatedEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithAggregatedEntityKindResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withAggregatedEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Layout Data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramSaveCommand#withAggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withAggregatedEntityKind(EntityKind); then return 'Layout Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withAggregatedEntityKind(EntityKind)"
  })
  void testWithAggregatedEntityKind_thenReturnLayoutData() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand actualWithAggregatedEntityKindResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ACTOR)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withAggregatedEntityKind(EntityKind.ALL);

    // Assert
    assertEquals("Layout Data", actualWithAggregatedEntityKindResult.layoutData());
    assertEquals("Name", actualWithAggregatedEntityKindResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithAggregatedEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithAggregatedEntityKindResult.aggregatedEntityKind());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY,
        actualWithAggregatedEntityKindResult.diagramKind());
    assertTrue(actualWithAggregatedEntityKindResult.backingEntities().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withBackingEntities(BackingEntity[])} with
   * {@code BackingEntity[]}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramSaveCommand#withBackingEntities(BackingEntity[])}
   */
  @Test
  @DisplayName("Test withBackingEntities(BackingEntity[]) with 'BackingEntity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withBackingEntities(BackingEntity[])"
  })
  void testWithBackingEntitiesWithBackingEntity() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    ImmutableBackingEntity.Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithBackingEntitiesResult =
        immutableOverlayDiagramSaveCommand.withBackingEntities(
            cellIdResult
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

    // Assert
    assertEquals("Layout Data", actualWithBackingEntitiesResult.layoutData());
    assertEquals("Name", actualWithBackingEntitiesResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithBackingEntitiesResult.description());
    assertEquals(1, actualWithBackingEntitiesResult.backingEntities().size());
    assertEquals(EntityKind.ALL, actualWithBackingEntitiesResult.aggregatedEntityKind());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithBackingEntitiesResult.diagramKind());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithDescriptionResult =
        immutableOverlayDiagramSaveCommand.withDescription("42");

    // Assert
    assertEquals(immutableOverlayDiagramSaveCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("42")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithDescriptionResult =
        immutableOverlayDiagramSaveCommand.withDescription("42");

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withDiagramKind(OverlayDiagramKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramSaveCommand#withDiagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test withDiagramKind(OverlayDiagramKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withDiagramKind(OverlayDiagramKind)"
  })
  void testWithDiagramKind() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithDiagramKindResult =
        immutableOverlayDiagramSaveCommand.withDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithDiagramKindResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withDiagramKind(OverlayDiagramKind)}.
   *
   * <ul>
   *   <li>Then return {@code Layout Data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableOverlayDiagramSaveCommand#withDiagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test withDiagramKind(OverlayDiagramKind); then return 'Layout Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withDiagramKind(OverlayDiagramKind)"
  })
  void testWithDiagramKind_thenReturnLayoutData() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand actualWithDiagramKindResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_STATIC_SVG_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withDiagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);

    // Assert
    assertEquals("Layout Data", actualWithDiagramKindResult.layoutData());
    assertEquals("Name", actualWithDiagramKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithDiagramKindResult.description());
    assertEquals(EntityKind.ALL, actualWithDiagramKindResult.aggregatedEntityKind());
    assertEquals(
        OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithDiagramKindResult.diagramKind());
    assertTrue(actualWithDiagramKindResult.backingEntities().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithIdResult =
        immutableOverlayDiagramSaveCommand.withId(optional);

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Layout Data}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Layout Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnLayoutData() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(2L)
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithIdResult =
        immutableOverlayDiagramSaveCommand.withId(optional);

    // Assert
    assertEquals("Layout Data", actualWithIdResult.layoutData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithIdResult.diagramKind());
    assertTrue(actualWithIdResult.backingEntities().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithIdResult =
        immutableOverlayDiagramSaveCommand.withId(1L);

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Layout Data}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Layout Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnLayoutData() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand actualWithIdResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Layout Data", actualWithIdResult.layoutData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithIdResult.diagramKind());
    assertTrue(actualWithIdResult.backingEntities().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withLayoutData(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withLayoutData(String)}
   */
  @Test
  @DisplayName("Test withLayoutData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withLayoutData(String)"
  })
  void testWithLayoutData() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("42")
            .name("Name")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithLayoutDataResult =
        immutableOverlayDiagramSaveCommand.withLayoutData("42");

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithLayoutDataResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withLayoutData(String)}.
   *
   * <ul>
   *   <li>Then return layoutData is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withLayoutData(String)}
   */
  @Test
  @DisplayName("Test withLayoutData(String); then return layoutData is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withLayoutData(String)"
  })
  void testWithLayoutData_thenReturnLayoutDataIs42() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand actualWithLayoutDataResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withLayoutData("42");

    // Assert
    assertEquals("42", actualWithLayoutDataResult.layoutData());
    assertEquals("Name", actualWithLayoutDataResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithLayoutDataResult.description());
    assertEquals(EntityKind.ALL, actualWithLayoutDataResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithLayoutDataResult.diagramKind());
    assertTrue(actualWithLayoutDataResult.backingEntities().isEmpty());
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableOverlayDiagramSaveCommand immutableOverlayDiagramSaveCommand =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("42")
            .build();

    // Act
    ImmutableOverlayDiagramSaveCommand actualWithNameResult =
        immutableOverlayDiagramSaveCommand.withName("42");

    // Assert
    assertSame(immutableOverlayDiagramSaveCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOverlayDiagramSaveCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOverlayDiagramSaveCommand ImmutableOverlayDiagramSaveCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableOverlayDiagramSaveCommand actualWithNameResult =
        ImmutableOverlayDiagramSaveCommand.builder()
            .aggregatedEntityKind(EntityKind.ALL)
            .description("The characteristics of someone or something")
            .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
            .id(1L)
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Layout Data", actualWithNameResult.layoutData());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, actualWithNameResult.diagramKind());
    assertTrue(actualWithNameResult.backingEntities().isEmpty());
  }
}
