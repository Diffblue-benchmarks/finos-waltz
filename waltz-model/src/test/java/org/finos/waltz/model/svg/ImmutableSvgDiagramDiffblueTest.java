package org.finos.waltz.model.svg;

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
   * Test {@link ImmutableSvgDiagram#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSvgDiagram#builder()}
   *   <li>{@link ImmutableSvgDiagram#description(String)}
   *   <li>{@link ImmutableSvgDiagram#displayHeightPercent(Integer)}
   *   <li>{@link ImmutableSvgDiagram#displayWidthPercent(Integer)}
   *   <li>{@link ImmutableSvgDiagram#product(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableSvgDiagram Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.displayHeightPercent(Integer)", "Builder Builder.displayWidthPercent(Integer)",
      "Builder Builder.product(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableSvgDiagram.builder()
        .description("The characteristics of someone or something")
        .displayHeightPercent(1)
        .displayWidthPercent(1)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.product("Product"));
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
    Builder builderResult = ImmutableSvgDiagram.builder();
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
    Builder builderResult = ImmutableSvgDiagram.builder();
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
    Builder builderResult = ImmutableSvgDiagram.builder();
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
   * <p>
   * Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    SvgDiagram instance = mock(SvgDiagram.class);
    when(instance.priority()).thenReturn(1);
    when(instance.displayHeightPercent()).thenReturn(1);
    when(instance.displayWidthPercent()).thenReturn(1);
    when(instance.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.keyProperty()).thenReturn("Key Property");
    when(instance.svg()).thenReturn("Svg");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.product()).thenReturn("Product");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).displayHeightPercent();
    verify(instance).displayWidthPercent();
    verify(instance).group();
    verify(instance).keyProperty();
    verify(instance).priority();
    verify(instance).product();
    verify(instance).svg();
    ImmutableSvgDiagram buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Key Property", buildResult.keyProperty());
    assertEquals("Name", buildResult.name());
    assertEquals("Product", buildResult.product());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.displayHeightPercent().intValue());
    assertEquals(1, buildResult.displayWidthPercent().intValue());
    assertEquals(1, buildResult.priority());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link SvgDiagram} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'; given empty; when SvgDiagram id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram_givenEmpty_whenSvgDiagramIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    SvgDiagram instance = mock(SvgDiagram.class);
    when(instance.priority()).thenReturn(1);
    when(instance.displayHeightPercent()).thenReturn(1);
    when(instance.displayWidthPercent()).thenReturn(1);
    when(instance.group()).thenReturn("Group");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.keyProperty()).thenReturn("Key Property");
    when(instance.svg()).thenReturn("Svg");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.product()).thenReturn("Product");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).displayHeightPercent();
    verify(instance).displayWidthPercent();
    verify(instance).group();
    verify(instance).keyProperty();
    verify(instance).priority();
    verify(instance).product();
    verify(instance).svg();
    ImmutableSvgDiagram buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Key Property", buildResult.keyProperty());
    assertEquals("Name", buildResult.name());
    assertEquals("Product", buildResult.product());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.displayHeightPercent().intValue());
    assertEquals(1, buildResult.displayWidthPercent().intValue());
    assertEquals(1, buildResult.priority());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    SvgDiagram instance = mock(SvgDiagram.class);
    when(instance.priority()).thenReturn(1);
    when(instance.displayHeightPercent()).thenReturn(1);
    when(instance.displayWidthPercent()).thenReturn(1);
    when(instance.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.keyProperty()).thenReturn("Key Property");
    when(instance.svg()).thenReturn("Svg");
    when(instance.description()).thenReturn(null);
    when(instance.product()).thenReturn("Product");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).displayHeightPercent();
    verify(instance).displayWidthPercent();
    verify(instance).group();
    verify(instance).keyProperty();
    verify(instance).priority();
    verify(instance).product();
    verify(instance).svg();
    ImmutableSvgDiagram buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Key Property", buildResult.keyProperty());
    assertEquals("Name", buildResult.name());
    assertEquals("Product", buildResult.product());
    assertEquals("Svg", buildResult.svg());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.displayHeightPercent().intValue());
    assertEquals(1, buildResult.displayWidthPercent().intValue());
    assertEquals(1, buildResult.priority());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   * <ul>
   *   <li>Then builder build displayHeightPercent is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'; then builder build displayHeightPercent is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram_thenBuilderBuildDisplayHeightPercentIsNull() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    SvgDiagram instance = mock(SvgDiagram.class);
    when(instance.priority()).thenReturn(1);
    when(instance.displayHeightPercent()).thenReturn(null);
    when(instance.displayWidthPercent()).thenReturn(1);
    when(instance.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.keyProperty()).thenReturn("Key Property");
    when(instance.svg()).thenReturn("Svg");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.product()).thenReturn("Product");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).displayHeightPercent();
    verify(instance).displayWidthPercent();
    verify(instance).group();
    verify(instance).keyProperty();
    verify(instance).priority();
    verify(instance).product();
    verify(instance).svg();
    ImmutableSvgDiagram buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Key Property", buildResult.keyProperty());
    assertEquals("Name", buildResult.name());
    assertEquals("Product", buildResult.product());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.displayHeightPercent());
    assertEquals(1, buildResult.displayWidthPercent().intValue());
    assertEquals(1, buildResult.priority());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   * <ul>
   *   <li>Then builder build displayWidthPercent is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'; then builder build displayWidthPercent is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram_thenBuilderBuildDisplayWidthPercentIsNull() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    SvgDiagram instance = mock(SvgDiagram.class);
    when(instance.priority()).thenReturn(1);
    when(instance.displayHeightPercent()).thenReturn(1);
    when(instance.displayWidthPercent()).thenReturn(null);
    when(instance.group()).thenReturn("Group");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.keyProperty()).thenReturn("Key Property");
    when(instance.svg()).thenReturn("Svg");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.product()).thenReturn("Product");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).displayHeightPercent();
    verify(instance).displayWidthPercent();
    verify(instance).group();
    verify(instance).keyProperty();
    verify(instance).priority();
    verify(instance).product();
    verify(instance).svg();
    ImmutableSvgDiagram buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Key Property", buildResult.keyProperty());
    assertEquals("Name", buildResult.name());
    assertEquals("Product", buildResult.product());
    assertEquals("Svg", buildResult.svg());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.displayWidthPercent());
    assertEquals(1, buildResult.displayHeightPercent().intValue());
    assertEquals(1, buildResult.priority());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SvgDiagram)} with {@code SvgDiagram}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SvgDiagram)}
   */
  @Test
  @DisplayName("Test Builder from(SvgDiagram) with 'SvgDiagram'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SvgDiagram)"})
  void testBuilderFromWithSvgDiagram_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();
    SvgDiagram instance = mock(SvgDiagram.class);
    when(instance.displayWidthPercent()).thenThrow(new IllegalStateException("instance"));
    when(instance.keyProperty()).thenReturn("Key Property");
    when(instance.svg()).thenReturn("Svg");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.product()).thenReturn("Product");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).displayWidthPercent();
    verify(instance).keyProperty();
    verify(instance).product();
    verify(instance).svg();
  }

  /**
   * Test Builder {@link Builder#group(String)}.
   * <p>
   * Method under test: {@link Builder#group(String)}
   */
  @Test
  @DisplayName("Test Builder group(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.group(String)"})
  void testBuilderGroup() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.group("Group"));
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
    Builder builderResult = ImmutableSvgDiagram.builder();

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
    Builder builderResult = ImmutableSvgDiagram.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#keyProperty(String)}.
   * <p>
   * Method under test: {@link Builder#keyProperty(String)}
   */
  @Test
  @DisplayName("Test Builder keyProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.keyProperty(String)"})
  void testBuilderKeyProperty() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.keyProperty("Key Property"));
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
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#priority(int)}.
   * <p>
   * Method under test: {@link Builder#priority(int)}
   */
  @Test
  @DisplayName("Test Builder priority(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.priority(int)"})
  void testBuilderPriority() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.priority(1));
  }

  /**
   * Test Builder {@link Builder#svg(String)}.
   * <p>
   * Method under test: {@link Builder#svg(String)}
   */
  @Test
  @DisplayName("Test Builder svg(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.svg(String)"})
  void testBuilderSvg() {
    // Arrange
    Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.svg("Svg"));
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
   * Test Json {@link Json#displayHeightPercent()}.
   * <p>
   * Method under test: {@link Json#displayHeightPercent()}
   */
  @Test
  @DisplayName("Test Json displayHeightPercent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.displayHeightPercent()"})
  void testJsonDisplayHeightPercent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).displayHeightPercent());
  }

  /**
   * Test Json {@link Json#displayWidthPercent()}.
   * <p>
   * Method under test: {@link Json#displayWidthPercent()}
   */
  @Test
  @DisplayName("Test Json displayWidthPercent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.displayWidthPercent()"})
  void testJsonDisplayWidthPercent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).displayWidthPercent());
  }

  /**
   * Test Json {@link Json#group()}.
   * <p>
   * Method under test: {@link Json#group()}
   */
  @Test
  @DisplayName("Test Json group()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.group()"})
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).group());
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
   * Test Json {@link Json#keyProperty()}.
   * <p>
   * Method under test: {@link Json#keyProperty()}
   */
  @Test
  @DisplayName("Test Json keyProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.keyProperty()"})
  void testJsonKeyProperty() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).keyProperty());
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
   * <p>
   * Method under test: {@link Json#priority()}
   */
  @Test
  @DisplayName("Test Json priority()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.priority()"})
  void testJsonPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).priority());
  }

  /**
   * Test Json {@link Json#product()}.
   * <p>
   * Method under test: {@link Json#product()}
   */
  @Test
  @DisplayName("Test Json product()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.product()"})
  void testJsonProduct() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).product());
  }

  /**
   * Test Json {@link Json#setPriority(int)}.
   * <p>
   * Method under test: {@link Json#setPriority(int)}
   */
  @Test
  @DisplayName("Test Json setPriority(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#svg()}
   */
  @Test
  @DisplayName("Test Json svg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.svg()"})
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).svg());
  }
}
