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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.app_group.AppGroupKind;
import org.finos.waltz.model.app_group.ImmutableAppGroup;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#editorRole(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagram Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.editorRole(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualEditorRoleResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role");
    Optional<String> editorRole = Optional.of("42");
    Builder actualIdResult = actualEditorRoleResult.editorRole(editorRole).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableFlowDiagram.lastUpdatedBy());
    assertEquals("Layout Data", actualImmutableFlowDiagram.layoutData());
    assertEquals("Name", actualImmutableFlowDiagram.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableFlowDiagram.description());
    assertEquals(EntityKind.ALL, actualImmutableFlowDiagram.kind());
    assertFalse(actualImmutableFlowDiagram.isRemoved());
    assertSame(lastUpdatedAt, actualImmutableFlowDiagram.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#editorRole(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#editorRole(Optional)}
   */
  @Test
  @DisplayName("Test Builder editorRole(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.editorRole(Optional)"})
  void testBuilderEditorRoleWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    Optional<String> editorRole = Optional.of("42");

    // Act
    Builder actualEditorRoleResult = builderResult.editorRole(editorRole);

    // Assert
    assertSame(builderResult, actualEditorRoleResult);
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
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description(null)
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagram)} with {@code FlowDiagram}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagram) with 'FlowDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagram)"})
  void testBuilderFromWithFlowDiagram() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagram)} with {@code FlowDiagram}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagram) with 'FlowDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagram)"})
  void testBuilderFromWithFlowDiagram2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description(null)
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram);
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
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((IsRemovedProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider3() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableAppGroup.builder()
                    .appGroupKind(AppGroupKind.PUBLIC)
                    .description(null)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
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
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
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
    Builder builderResult = ImmutableFlowDiagram.builder();
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description(null)
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    ImmutableFlowDiagram actualImmutableFlowDiagram =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableFlowDiagram);
    ImmutableFlowDiagram actualImmutableFlowDiagram2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagram2);
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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    // Act
    Builder actualIsRemovedResult = builderResult.isRemoved(true);

    // Assert
    assertSame(builderResult, actualIsRemovedResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagram.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
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
    Builder builderResult = ImmutableFlowDiagram.builder();

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
    Builder builderResult = ImmutableFlowDiagram.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#copyOf(FlowDiagram)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowDiagram); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.copyOf(FlowDiagram)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableFlowDiagram instance =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualCopyOfResult = ImmutableFlowDiagram.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Layout Data", actualCopyOfResult.layoutData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#editorRole()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#editorRole()}
   */
  @Test
  @DisplayName("Test editorRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowDiagram.editorRole()"})
  void testEditorRole() {
    // Arrange and Act
    Optional<String> actualEditorRoleResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .editorRole();

    // Assert
    assertEquals("Editor Role", actualEditorRoleResult.get());
    assertTrue(actualEditorRoleResult.isPresent());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}, and {@link ImmutableFlowDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagram#equals(Object)}
   *   <li>{@link ImmutableFlowDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();
    ImmutableFlowDiagram immutableFlowDiagram2 =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagram, immutableFlowDiagram2);
    assertEquals(immutableFlowDiagram.hashCode(), immutableFlowDiagram2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}, and {@link ImmutableFlowDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagram#equals(Object)}
   *   <li>{@link ImmutableFlowDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableFlowDiagram, immutableFlowDiagram);
    int expectedHashCodeResult = immutableFlowDiagram.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowDiagram.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Name")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("2020-03-01")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagram,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagram.equals(Object)",
    "int ImmutableFlowDiagram.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build(),
        "Different type to ImmutableFlowDiagram");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagram#description()}
   *   <li>{@link ImmutableFlowDiagram#lastUpdatedBy()}
   *   <li>{@link ImmutableFlowDiagram#layoutData()}
   *   <li>{@link ImmutableFlowDiagram#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFlowDiagram.description()",
    "String ImmutableFlowDiagram.lastUpdatedBy()",
    "String ImmutableFlowDiagram.layoutData()",
    "String ImmutableFlowDiagram.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableFlowDiagram.description();
    String actualLastUpdatedByResult = immutableFlowDiagram.lastUpdatedBy();
    String actualLayoutDataResult = immutableFlowDiagram.layoutData();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Layout Data", actualLayoutDataResult);
    assertEquals("Name", immutableFlowDiagram.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#id()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowDiagram.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableFlowDiagram#isRemoved()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#isRemoved()}
   */
  @Test
  @DisplayName("Test isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableFlowDiagram.isRemoved()"})
  void testIsRemoved() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .isRemoved());
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
   * Test Json {@link Json#editorRole()}.
   *
   * <p>Method under test: {@link Json#editorRole()}
   */
  @Test
  @DisplayName("Test Json editorRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.editorRole()"})
  void testJsonEditorRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().editorRole());
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
   * Test Json {@link Json#isRemoved()}.
   *
   * <p>Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRemoved());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.layoutData);
    assertNull(actualJson.name);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertFalse(actualJson.editorRole.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Test {@link ImmutableFlowDiagram#kind()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableFlowDiagram.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableFlowDiagram#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableFlowDiagram.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableFlowDiagram.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "FlowDiagram{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, isRemoved=false,"
            + " layoutData=Layout Data, editorRole=Editor Role, kind=ALL}",
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithDescriptionResult = immutableFlowDiagram.withDescription("42");

    // Assert
    assertEquals(immutableFlowDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("42")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithDescriptionResult = immutableFlowDiagram.withDescription("42");

    // Assert
    assertSame(immutableFlowDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withEditorRole(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withEditorRole(Optional)}
   */
  @Test
  @DisplayName("Test withEditorRole(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withEditorRole(Optional)"})
  void testWithEditorRoleWithOptional() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableFlowDiagram actualWithEditorRoleResult = immutableFlowDiagram.withEditorRole(optional);

    // Assert
    assertSame(immutableFlowDiagram, actualWithEditorRoleResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withEditorRole(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withEditorRole(Optional)}
   */
  @Test
  @DisplayName(
      "Test withEditorRole(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withEditorRole(Optional)"})
  void testWithEditorRoleWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableFlowDiagram actualWithEditorRoleResult = immutableFlowDiagram.withEditorRole(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithEditorRoleResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithEditorRoleResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithEditorRoleResult.layoutData());
    assertEquals("Name", actualWithEditorRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithEditorRoleResult.description());
    assertEquals(EntityKind.ALL, actualWithEditorRoleResult.kind());
    assertFalse(actualWithEditorRoleResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withEditorRole(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withEditorRole(String)}
   */
  @Test
  @DisplayName("Test withEditorRole(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withEditorRole(String)"})
  void testWithEditorRoleWithValue() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithEditorRoleResult = immutableFlowDiagram.withEditorRole("42");

    // Assert
    assertSame(immutableFlowDiagram, actualWithEditorRoleResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withEditorRole(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withEditorRole(String)}
   */
  @Test
  @DisplayName(
      "Test withEditorRole(String) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withEditorRole(String)"})
  void testWithEditorRoleWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithEditorRoleResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withEditorRole("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithEditorRoleResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithEditorRoleResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithEditorRoleResult.layoutData());
    assertEquals("Name", actualWithEditorRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithEditorRoleResult.description());
    assertEquals(EntityKind.ALL, actualWithEditorRoleResult.kind());
    assertFalse(actualWithEditorRoleResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowDiagram actualWithIdResult = immutableFlowDiagram.withId(optional);

    // Assert
    assertSame(immutableFlowDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableFlowDiagram actualWithIdResult = immutableFlowDiagram.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithIdResult.layoutData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertFalse(actualWithIdResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithIdResult = immutableFlowDiagram.withId(1L);

    // Assert
    assertSame(immutableFlowDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withId(long)"})
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithIdResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithIdResult.layoutData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertFalse(actualWithIdResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withIsRemoved(boolean)"})
  void testWithIsRemoved() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithIsRemovedResult = immutableFlowDiagram.withIsRemoved(false);

    // Assert
    assertSame(immutableFlowDiagram, actualWithIsRemovedResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withIsRemoved(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsRemoved(boolean); when 'true'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withIsRemoved(boolean)"})
  void testWithIsRemoved_whenTrue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithIsRemovedResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withIsRemoved(true);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIsRemovedResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIsRemovedResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithIsRemovedResult.layoutData());
    assertEquals("Name", actualWithIsRemovedResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsRemovedResult.description());
    assertEquals(EntityKind.ALL, actualWithIsRemovedResult.kind());
    assertTrue(actualWithIsRemovedResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithKindResult = immutableFlowDiagram.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableFlowDiagram, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withKind(EntityKind)"})
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithKindResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithKindResult.layoutData());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertFalse(actualWithKindResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withLastUpdatedAt(LocalDateTime)"})
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithLastUpdatedAtResult =
        immutableFlowDiagram.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableFlowDiagram, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .layoutData("Layout Data")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithLastUpdatedByResult =
        immutableFlowDiagram.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableFlowDiagram, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithLastUpdatedByResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Layout Data", actualWithLastUpdatedByResult.layoutData());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertFalse(actualWithLastUpdatedByResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withLayoutData(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withLayoutData(String)}
   */
  @Test
  @DisplayName("Test withLayoutData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withLayoutData(String)"})
  void testWithLayoutData() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("42")
            .name("Name")
            .build();

    // Act
    ImmutableFlowDiagram actualWithLayoutDataResult = immutableFlowDiagram.withLayoutData("42");

    // Assert
    assertSame(immutableFlowDiagram, actualWithLayoutDataResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withLayoutData(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withLayoutData(String)}
   */
  @Test
  @DisplayName(
      "Test withLayoutData(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withLayoutData(String)"})
  void testWithLayoutData_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithLayoutDataResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withLayoutData("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLayoutDataResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithLayoutDataResult.lastUpdatedBy());
    assertEquals("42", actualWithLayoutDataResult.layoutData());
    assertEquals("Name", actualWithLayoutDataResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithLayoutDataResult.description());
    assertEquals(EntityKind.ALL, actualWithLayoutDataResult.kind());
    assertFalse(actualWithLayoutDataResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableFlowDiagram immutableFlowDiagram =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("42")
            .build();

    // Act
    ImmutableFlowDiagram actualWithNameResult = immutableFlowDiagram.withName("42");

    // Assert
    assertSame(immutableFlowDiagram, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableFlowDiagram#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagram ImmutableFlowDiagram.withName(String)"})
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableFlowDiagram actualWithNameResult =
        ImmutableFlowDiagram.builder()
            .description("The characteristics of someone or something")
            .editorRole("Editor Role")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .layoutData("Layout Data")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Layout Data", actualWithNameResult.layoutData());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertFalse(actualWithNameResult.isRemoved());
    assertSame(ofResult, toLocalDateResult);
  }
}
