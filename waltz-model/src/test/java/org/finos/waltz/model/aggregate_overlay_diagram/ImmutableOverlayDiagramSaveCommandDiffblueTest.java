package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramSaveCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableOverlayDiagramSaveCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOverlayDiagramSaveCommandDiffblueTest {
  /**
   * Test {@link ImmutableOverlayDiagramSaveCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#builder()}
   *   <li>{@link ImmutableOverlayDiagramSaveCommand#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableOverlayDiagramSaveCommand Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableOverlayDiagramSaveCommand.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#addAllBackingEntities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllBackingEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllBackingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllBackingEntities(Iterable)"})
  void testBuilderAddAllBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllBackingEntities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBackingEntities(BackingEntity)}
   */
  @Test
  @DisplayName("Test Builder addBackingEntities(BackingEntity) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity)"})
  void testBuilderAddBackingEntitiesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#addBackingEntities(BackingEntity[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableBackingEntity.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addBackingEntities(BackingEntity[])}
   */
  @Test
  @DisplayName("Test Builder addBackingEntities(BackingEntity[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addBackingEntities(BackingEntity[])"})
  void testBuilderAddBackingEntitiesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addBackingEntities(new ImmutableBackingEntity.Json()));
  }

  /**
   * Test Builder {@link Builder#aggregatedEntityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#aggregatedEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder aggregatedEntityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.aggregatedEntityKind(EntityKind)"})
  void testBuilderAggregatedEntityKind() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aggregatedEntityKind(EntityKind.ALL));
  }

  /**
   * Test Builder {@link Builder#backingEntities(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#backingEntities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder backingEntities(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.backingEntities(Iterable)"})
  void testBuilderBackingEntities_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.backingEntities(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#diagramKind(OverlayDiagramKind)}.
   * <p>
   * Method under test: {@link Builder#diagramKind(OverlayDiagramKind)}
   */
  @Test
  @DisplayName("Test Builder diagramKind(OverlayDiagramKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.diagramKind(OverlayDiagramKind)"})
  void testBuilderDiagramKind() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
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
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code OverlayDiagramSaveCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = actualFromResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertTrue(buildResult.backingEntities().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code OverlayDiagramSaveCommand}.
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand2() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    HashSet<BackingEntity> backingEntitySet = new HashSet<>();
    backingEntitySet.add(new ImmutableBackingEntity.Json());
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(backingEntitySet);
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = builderResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals(1, buildResult.backingEntities().size());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code OverlayDiagramSaveCommand}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = actualFromResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertTrue(buildResult.backingEntities().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code OverlayDiagramSaveCommand}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenReturn(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
    ImmutableOverlayDiagramSaveCommand buildResult = actualFromResult.build();
    assertEquals("Layout Data", buildResult.layoutData());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertNull(builderResult.build().description());
    assertEquals(EntityKind.ALL, buildResult.aggregatedEntityKind());
    assertEquals(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY, buildResult.diagramKind());
    assertTrue(buildResult.backingEntities().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(OverlayDiagramSaveCommand)} with {@code OverlayDiagramSaveCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(OverlayDiagramSaveCommand)}
   */
  @Test
  @DisplayName("Test Builder from(OverlayDiagramSaveCommand) with 'OverlayDiagramSaveCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(OverlayDiagramSaveCommand)"})
  void testBuilderFromWithOverlayDiagramSaveCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    OverlayDiagramSaveCommand instance = mock(OverlayDiagramSaveCommand.class);
    when(instance.diagramKind()).thenThrow(new IllegalStateException("instance"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.backingEntities()).thenReturn(new HashSet<>());
    when(instance.aggregatedEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.layoutData()).thenReturn("Layout Data");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).aggregatedEntityKind();
    verify(instance).backingEntities();
    verify(instance).diagramKind();
    verify(instance).layoutData();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#layoutData(String)}.
   * <p>
   * Method under test: {@link Builder#layoutData(String)}
   */
  @Test
  @DisplayName("Test Builder layoutData(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.layoutData(String)"})
  void testBuilderLayoutData() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.layoutData("Layout Data"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableOverlayDiagramSaveCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Json {@link Json#aggregatedEntityKind()}.
   * <p>
   * Method under test: {@link Json#aggregatedEntityKind()}
   */
  @Test
  @DisplayName("Test Json aggregatedEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.aggregatedEntityKind()"})
  void testJsonAggregatedEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).aggregatedEntityKind());
  }

  /**
   * Test Json {@link Json#backingEntities()}.
   * <p>
   * Method under test: {@link Json#backingEntities()}
   */
  @Test
  @DisplayName("Test Json backingEntities()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.backingEntities()"})
  void testJsonBackingEntities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).backingEntities());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#diagramKind()}.
   * <p>
   * Method under test: {@link Json#diagramKind()}
   */
  @Test
  @DisplayName("Test Json diagramKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OverlayDiagramKind Json.diagramKind()"})
  void testJsonDiagramKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).diagramKind());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#layoutData()}.
   * <p>
   * Method under test: {@link Json#layoutData()}
   */
  @Test
  @DisplayName("Test Json layoutData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.layoutData()"})
  void testJsonLayoutData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).layoutData());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
}
