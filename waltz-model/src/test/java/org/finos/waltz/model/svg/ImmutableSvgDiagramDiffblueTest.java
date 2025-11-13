package org.finos.waltz.model.svg;

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
import org.finos.waltz.model.svg.ImmutableSvgDiagram.Builder;
import org.finos.waltz.model.svg.ImmutableSvgDiagram.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSvgDiagramDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#displayHeightPercent(Integer)}
   *   <li>{@link Builder#displayWidthPercent(Integer)}
   *   <li>{@link Builder#product(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSvgDiagram Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.displayHeightPercent(Integer)",
    "Builder Builder.displayWidthPercent(Integer)",
    "Builder Builder.product(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableSvgDiagram actualImmutableSvgDiagram =
        actualIdResult
            .id(id)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Assert
    assertEquals("Group", actualImmutableSvgDiagram.group());
    assertEquals("Key Property", actualImmutableSvgDiagram.keyProperty());
    assertEquals("Name", actualImmutableSvgDiagram.name());
    assertEquals("Product", actualImmutableSvgDiagram.product());
    assertEquals("Svg", actualImmutableSvgDiagram.svg());
    assertEquals(
        "The characteristics of someone or something", actualImmutableSvgDiagram.description());
    assertEquals(1, actualImmutableSvgDiagram.displayHeightPercent().intValue());
    assertEquals(1, actualImmutableSvgDiagram.displayWidthPercent().intValue());
    assertEquals(1, actualImmutableSvgDiagram.priority());
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
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
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
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description(null)
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(null)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
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
  void testBuilderFromWithNameProvider4() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(null)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
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
    Builder builderResult = ImmutableSvgDiagram.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   *
   * <p>Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   *
   * <p>Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram2() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description(null)
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   *
   * <p>Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram3() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(null)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   *
   * <p>Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram4() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(null)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSvgDiagram actualImmutableSvgDiagram = builderResult.build();
    assertEquals(instance, actualImmutableSvgDiagram);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#group(String)}.
   *
   * <ul>
   *   <li>When {@code Group}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#group(String)}
   */
  @Test
  @DisplayName("Test Builder group(String); when 'Group'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.group(String)"})
  void testBuilderGroup_whenGroup_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act
    Builder actualGroupResult = builderResult.group("Group");

    // Assert
    assertSame(builderResult, actualGroupResult);
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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#keyProperty(String)}.
   *
   * <ul>
   *   <li>When {@code Key Property}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#keyProperty(String)}
   */
  @Test
  @DisplayName("Test Builder keyProperty(String); when 'Key Property'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.keyProperty(String)"})
  void testBuilderKeyProperty_whenKeyProperty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act
    Builder actualKeyPropertyResult = builderResult.keyProperty("Key Property");

    // Assert
    assertSame(builderResult, actualKeyPropertyResult);
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
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#priority(int)}.
   *
   * <p>Method under test: {@link Builder#priority(int)}
   */
  @Test
  @DisplayName("Test Builder priority(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.priority(int)"})
  void testBuilderPriority() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act
    Builder actualPriorityResult = builderResult.priority(1);

    // Assert
    assertSame(builderResult, actualPriorityResult);
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
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act
    Builder actualSvgResult = builderResult.svg("Svg");

    // Assert
    assertSame(builderResult, actualSvgResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}
   */
  @Test
  @DisplayName("Test copyOf(SvgDiagram); then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.copyOf(SvgDiagram)"})
  void testCopyOf_thenReturnGroup() {
    // Arrange
    ImmutableSvgDiagram instance =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualCopyOfResult = ImmutableSvgDiagram.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Key Property", actualCopyOfResult.keyProperty());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Product", actualCopyOfResult.product());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.displayHeightPercent().intValue());
    assertEquals(1, actualCopyOfResult.displayWidthPercent().intValue());
    assertEquals(1, actualCopyOfResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}, and {@link ImmutableSvgDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSvgDiagram#equals(Object)}
   *   <li>{@link ImmutableSvgDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();
    ImmutableSvgDiagram immutableSvgDiagram2 =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(immutableSvgDiagram, immutableSvgDiagram2);
    assertEquals(immutableSvgDiagram.hashCode(), immutableSvgDiagram2.hashCode());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}, and {@link ImmutableSvgDiagram#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSvgDiagram#equals(Object)}
   *   <li>{@link ImmutableSvgDiagram#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertEquals(immutableSvgDiagram, immutableSvgDiagram);
    int expectedHashCodeResult = immutableSvgDiagram.hashCode();
    assertEquals(expectedHashCodeResult, immutableSvgDiagram.hashCode());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(0)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(2)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Name")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(2L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Name")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Group")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(0)
            .product("Product")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Name")
            .svg("Svg")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSvgDiagram,
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build());
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSvgDiagram#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSvgDiagram.equals(Object)",
    "int ImmutableSvgDiagram.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build(),
        "Different type to ImmutableSvgDiagram");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSvgDiagram#description()}
   *   <li>{@link ImmutableSvgDiagram#displayHeightPercent()}
   *   <li>{@link ImmutableSvgDiagram#displayWidthPercent()}
   *   <li>{@link ImmutableSvgDiagram#group()}
   *   <li>{@link ImmutableSvgDiagram#keyProperty()}
   *   <li>{@link ImmutableSvgDiagram#name()}
   *   <li>{@link ImmutableSvgDiagram#priority()}
   *   <li>{@link ImmutableSvgDiagram#product()}
   *   <li>{@link ImmutableSvgDiagram#svg()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSvgDiagram.description()",
    "Integer ImmutableSvgDiagram.displayHeightPercent()",
    "Integer ImmutableSvgDiagram.displayWidthPercent()",
    "String ImmutableSvgDiagram.group()",
    "String ImmutableSvgDiagram.keyProperty()",
    "String ImmutableSvgDiagram.name()",
    "int ImmutableSvgDiagram.priority()",
    "String ImmutableSvgDiagram.product()",
    "String ImmutableSvgDiagram.svg()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    String actualDescriptionResult = immutableSvgDiagram.description();
    Integer actualDisplayHeightPercentResult = immutableSvgDiagram.displayHeightPercent();
    Integer actualDisplayWidthPercentResult = immutableSvgDiagram.displayWidthPercent();
    String actualGroupResult = immutableSvgDiagram.group();
    String actualKeyPropertyResult = immutableSvgDiagram.keyProperty();
    String actualNameResult = immutableSvgDiagram.name();
    int actualPriorityResult = immutableSvgDiagram.priority();
    String actualProductResult = immutableSvgDiagram.product();

    // Assert
    assertEquals("Group", actualGroupResult);
    assertEquals("Key Property", actualKeyPropertyResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Product", actualProductResult);
    assertEquals("Svg", immutableSvgDiagram.svg());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, actualDisplayHeightPercentResult.intValue());
    assertEquals(1, actualDisplayWidthPercentResult.intValue());
    assertEquals(1, actualPriorityResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#id()}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSvgDiagram.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
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
   * Test Json {@link Json#displayHeightPercent()}.
   *
   * <p>Method under test: {@link Json#displayHeightPercent()}
   */
  @Test
  @DisplayName("Test Json displayHeightPercent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.displayHeightPercent()"})
  void testJsonDisplayHeightPercent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().displayHeightPercent());
  }

  /**
   * Test Json {@link Json#displayWidthPercent()}.
   *
   * <p>Method under test: {@link Json#displayWidthPercent()}
   */
  @Test
  @DisplayName("Test Json displayWidthPercent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.displayWidthPercent()"})
  void testJsonDisplayWidthPercent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().displayWidthPercent());
  }

  /**
   * Test Json {@link Json#group()}.
   *
   * <p>Method under test: {@link Json#group()}
   */
  @Test
  @DisplayName("Test Json group()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.group()"})
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().group());
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
   * Test Json {@link Json#keyProperty()}.
   *
   * <p>Method under test: {@link Json#keyProperty()}
   */
  @Test
  @DisplayName("Test Json keyProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.keyProperty()"})
  void testJsonKeyProperty() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().keyProperty());
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
    assertNull(actualJson.displayHeightPercent);
    assertNull(actualJson.displayWidthPercent);
    assertNull(actualJson.description);
    assertNull(actualJson.group);
    assertNull(actualJson.keyProperty);
    assertNull(actualJson.name);
    assertNull(actualJson.product);
    assertNull(actualJson.svg);
    assertEquals(0, actualJson.priority);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.priorityIsSet);
  }

  /**
   * Test Json {@link Json#priority()}.
   *
   * <p>Method under test: {@link Json#priority()}
   */
  @Test
  @DisplayName("Test Json priority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.priority()"})
  void testJsonPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().priority());
  }

  /**
   * Test Json {@link Json#product()}.
   *
   * <p>Method under test: {@link Json#product()}
   */
  @Test
  @DisplayName("Test Json product()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.product()"})
  void testJsonProduct() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().product());
  }

  /**
   * Test Json {@link Json#setPriority(int)}.
   *
   * <p>Method under test: {@link Json#setPriority(int)}
   */
  @Test
  @DisplayName("Test Json setPriority(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPriority(int)"})
  void testJsonSetPriority() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPriority(1);

    // Assert
    assertEquals(1, json.priority);
    assertTrue(json.priorityIsSet);
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
   * Test {@link ImmutableSvgDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSvgDiagram.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SvgDiagram{id=1, name=Name, group=Group, svg=Svg, priority=1, keyProperty=Key Property, product=Product,"
            + " displayWidthPercent=1, displayHeightPercent=1}",
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSvgDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSvgDiagram.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "SvgDiagram{id=1, name=Name, group=Group, svg=Svg, priority=1, keyProperty=Key Property, product=Product,"
            + " displayWidthPercent=1}",
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(null)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSvgDiagram#toString()}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSvgDiagram.toString()"})
  void testToString3() {
    // Arrange, Act and Assert
    assertEquals(
        "SvgDiagram{id=1, name=Name, group=Group, svg=Svg, priority=1, keyProperty=Key Property, product=Product,"
            + " displayHeightPercent=1}",
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(null)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithDescriptionResult = immutableSvgDiagram.withDescription("42");

    // Assert
    assertEquals(immutableSvgDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("42")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithDescriptionResult = immutableSvgDiagram.withDescription("42");

    // Assert
    assertSame(immutableSvgDiagram, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withDisplayHeightPercent(Integer)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withDisplayHeightPercent(Integer)}
   */
  @Test
  @DisplayName("Test withDisplayHeightPercent(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withDisplayHeightPercent(Integer)"})
  void testWithDisplayHeightPercent() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithDisplayHeightPercentResult =
        immutableSvgDiagram.withDisplayHeightPercent(1);

    // Assert
    assertSame(immutableSvgDiagram, actualWithDisplayHeightPercentResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withDisplayHeightPercent(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withDisplayHeightPercent(Integer)}
   */
  @Test
  @DisplayName("Test withDisplayHeightPercent(Integer); when forty-two; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withDisplayHeightPercent(Integer)"})
  void testWithDisplayHeightPercent_whenFortyTwo_thenReturnGroup() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithDisplayHeightPercentResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withDisplayHeightPercent(42);

    // Assert
    assertEquals("Group", actualWithDisplayHeightPercentResult.group());
    assertEquals("Key Property", actualWithDisplayHeightPercentResult.keyProperty());
    assertEquals("Name", actualWithDisplayHeightPercentResult.name());
    assertEquals("Product", actualWithDisplayHeightPercentResult.product());
    assertEquals("Svg", actualWithDisplayHeightPercentResult.svg());
    assertEquals(
        "The characteristics of someone or something",
        actualWithDisplayHeightPercentResult.description());
    assertEquals(1, actualWithDisplayHeightPercentResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithDisplayHeightPercentResult.priority());
    assertEquals(42, actualWithDisplayHeightPercentResult.displayHeightPercent().intValue());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withDisplayWidthPercent(Integer)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withDisplayWidthPercent(Integer)}
   */
  @Test
  @DisplayName("Test withDisplayWidthPercent(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withDisplayWidthPercent(Integer)"})
  void testWithDisplayWidthPercent() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithDisplayWidthPercentResult =
        immutableSvgDiagram.withDisplayWidthPercent(1);

    // Assert
    assertSame(immutableSvgDiagram, actualWithDisplayWidthPercentResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withDisplayWidthPercent(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withDisplayWidthPercent(Integer)}
   */
  @Test
  @DisplayName("Test withDisplayWidthPercent(Integer); when forty-two; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withDisplayWidthPercent(Integer)"})
  void testWithDisplayWidthPercent_whenFortyTwo_thenReturnGroup() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithDisplayWidthPercentResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withDisplayWidthPercent(42);

    // Assert
    assertEquals("Group", actualWithDisplayWidthPercentResult.group());
    assertEquals("Key Property", actualWithDisplayWidthPercentResult.keyProperty());
    assertEquals("Name", actualWithDisplayWidthPercentResult.name());
    assertEquals("Product", actualWithDisplayWidthPercentResult.product());
    assertEquals("Svg", actualWithDisplayWidthPercentResult.svg());
    assertEquals(
        "The characteristics of someone or something",
        actualWithDisplayWidthPercentResult.description());
    assertEquals(1, actualWithDisplayWidthPercentResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithDisplayWidthPercentResult.priority());
    assertEquals(42, actualWithDisplayWidthPercentResult.displayWidthPercent().intValue());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withGroup(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withGroup(String)"})
  void testWithGroup() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("42")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithGroupResult = immutableSvgDiagram.withGroup("42");

    // Assert
    assertSame(immutableSvgDiagram, actualWithGroupResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withGroup(String)}.
   *
   * <ul>
   *   <li>Then return group is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String); then return group is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withGroup(String)"})
  void testWithGroup_thenReturnGroupIs42() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithGroupResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withGroup("42");

    // Assert
    assertEquals("42", actualWithGroupResult.group());
    assertEquals("Key Property", actualWithGroupResult.keyProperty());
    assertEquals("Name", actualWithGroupResult.name());
    assertEquals("Product", actualWithGroupResult.product());
    assertEquals("Svg", actualWithGroupResult.svg());
    assertEquals(
        "The characteristics of someone or something", actualWithGroupResult.description());
    assertEquals(1, actualWithGroupResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithGroupResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithGroupResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSvgDiagram actualWithIdResult = immutableSvgDiagram.withId(optional);

    // Assert
    assertSame(immutableSvgDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnGroup() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableSvgDiagram actualWithIdResult = immutableSvgDiagram.withId(optional);

    // Assert
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Key Property", actualWithIdResult.keyProperty());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Product", actualWithIdResult.product());
    assertEquals("Svg", actualWithIdResult.svg());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithIdResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithIdResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithIdResult = immutableSvgDiagram.withId(1L);

    // Assert
    assertSame(immutableSvgDiagram, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnGroup() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithIdResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Key Property", actualWithIdResult.keyProperty());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Product", actualWithIdResult.product());
    assertEquals("Svg", actualWithIdResult.svg());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithIdResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithIdResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withKeyProperty(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withKeyProperty(String)}
   */
  @Test
  @DisplayName("Test withKeyProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withKeyProperty(String)"})
  void testWithKeyProperty() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("42")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithKeyPropertyResult = immutableSvgDiagram.withKeyProperty("42");

    // Assert
    assertSame(immutableSvgDiagram, actualWithKeyPropertyResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withKeyProperty(String)}.
   *
   * <ul>
   *   <li>Then return keyProperty is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withKeyProperty(String)}
   */
  @Test
  @DisplayName("Test withKeyProperty(String); then return keyProperty is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withKeyProperty(String)"})
  void testWithKeyProperty_thenReturnKeyPropertyIs42() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithKeyPropertyResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withKeyProperty("42");

    // Assert
    assertEquals("42", actualWithKeyPropertyResult.keyProperty());
    assertEquals("Group", actualWithKeyPropertyResult.group());
    assertEquals("Name", actualWithKeyPropertyResult.name());
    assertEquals("Product", actualWithKeyPropertyResult.product());
    assertEquals("Svg", actualWithKeyPropertyResult.svg());
    assertEquals(
        "The characteristics of someone or something", actualWithKeyPropertyResult.description());
    assertEquals(1, actualWithKeyPropertyResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithKeyPropertyResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithKeyPropertyResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("42")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithNameResult = immutableSvgDiagram.withName("42");

    // Assert
    assertSame(immutableSvgDiagram, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithNameResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Group", actualWithNameResult.group());
    assertEquals("Key Property", actualWithNameResult.keyProperty());
    assertEquals("Product", actualWithNameResult.product());
    assertEquals("Svg", actualWithNameResult.svg());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithNameResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithNameResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withPriority(int)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withPriority(int)}
   */
  @Test
  @DisplayName("Test withPriority(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withPriority(int)"})
  void testWithPriority() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(42)
            .product("Product")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithPriorityResult = immutableSvgDiagram.withPriority(42);

    // Assert
    assertSame(immutableSvgDiagram, actualWithPriorityResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withPriority(int)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withPriority(int)}
   */
  @Test
  @DisplayName("Test withPriority(int); then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withPriority(int)"})
  void testWithPriority_thenReturnGroup() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithPriorityResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withPriority(42);

    // Assert
    assertEquals("Group", actualWithPriorityResult.group());
    assertEquals("Key Property", actualWithPriorityResult.keyProperty());
    assertEquals("Name", actualWithPriorityResult.name());
    assertEquals("Product", actualWithPriorityResult.product());
    assertEquals("Svg", actualWithPriorityResult.svg());
    assertEquals(
        "The characteristics of someone or something", actualWithPriorityResult.description());
    assertEquals(1, actualWithPriorityResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithPriorityResult.displayWidthPercent().intValue());
    assertEquals(42, actualWithPriorityResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withProduct(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withProduct(String)}
   */
  @Test
  @DisplayName("Test withProduct(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withProduct(String)"})
  void testWithProduct() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("42")
            .svg("Svg")
            .build();

    // Act
    ImmutableSvgDiagram actualWithProductResult = immutableSvgDiagram.withProduct("42");

    // Assert
    assertSame(immutableSvgDiagram, actualWithProductResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withProduct(String)}.
   *
   * <ul>
   *   <li>Then return product is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withProduct(String)}
   */
  @Test
  @DisplayName("Test withProduct(String); then return product is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withProduct(String)"})
  void testWithProduct_thenReturnProductIs42() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithProductResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withProduct("42");

    // Assert
    assertEquals("42", actualWithProductResult.product());
    assertEquals("Group", actualWithProductResult.group());
    assertEquals("Key Property", actualWithProductResult.keyProperty());
    assertEquals("Name", actualWithProductResult.name());
    assertEquals("Svg", actualWithProductResult.svg());
    assertEquals(
        "The characteristics of someone or something", actualWithProductResult.description());
    assertEquals(1, actualWithProductResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithProductResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithProductResult.priority());
  }

  /**
   * Test {@link ImmutableSvgDiagram#withSvg(String)}.
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withSvg(String)"})
  void testWithSvg() {
    // Arrange
    ImmutableSvgDiagram immutableSvgDiagram =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("42")
            .build();

    // Act
    ImmutableSvgDiagram actualWithSvgResult = immutableSvgDiagram.withSvg("42");

    // Assert
    assertSame(immutableSvgDiagram, actualWithSvgResult);
  }

  /**
   * Test {@link ImmutableSvgDiagram#withSvg(String)}.
   *
   * <ul>
   *   <li>Then return svg is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSvgDiagram#withSvg(String)}
   */
  @Test
  @DisplayName("Test withSvg(String); then return svg is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSvgDiagram ImmutableSvgDiagram.withSvg(String)"})
  void testWithSvg_thenReturnSvgIs42() {
    // Arrange and Act
    ImmutableSvgDiagram actualWithSvgResult =
        ImmutableSvgDiagram.builder()
            .description("The characteristics of someone or something")
            .displayHeightPercent(1)
            .displayWidthPercent(1)
            .group("Group")
            .id(1L)
            .keyProperty("Key Property")
            .name("Name")
            .priority(1)
            .product("Product")
            .svg("Svg")
            .build()
            .withSvg("42");

    // Assert
    assertEquals("42", actualWithSvgResult.svg());
    assertEquals("Group", actualWithSvgResult.group());
    assertEquals("Key Property", actualWithSvgResult.keyProperty());
    assertEquals("Name", actualWithSvgResult.name());
    assertEquals("Product", actualWithSvgResult.product());
    assertEquals("The characteristics of someone or something", actualWithSvgResult.description());
    assertEquals(1, actualWithSvgResult.displayHeightPercent().intValue());
    assertEquals(1, actualWithSvgResult.displayWidthPercent().intValue());
    assertEquals(1, actualWithSvgResult.priority());
  }
}
