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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableSvgDiagramDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableSvgDiagram.Builder actualIdResult = ImmutableSvgDiagram.builder()
        .description("The characteristics of someone or something")
        .displayHeightPercent(1)
        .displayWidthPercent(1)
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableSvgDiagram.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.product("Product"));
  }

  /**
   * Method under test:
   * {@link ImmutableSvgDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSvgDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSvgDiagram.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(SvgDiagram)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
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
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(SvgDiagram)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
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
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(SvgDiagram)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
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
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(SvgDiagram)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
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
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(SvgDiagram)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
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
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSvgDiagram.Builder#from(SvgDiagram)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
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
    ImmutableSvgDiagram.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSvgDiagram.Builder#group(String)}
   */
  @Test
  void testBuilderGroup() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.group("Group"));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#keyProperty(String)}
   */
  @Test
  void testBuilderKeyProperty() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.keyProperty("Key Property"));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#priority(int)}
   */
  @Test
  void testBuilderPriority() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.priority(1));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Builder#svg(String)}
   */
  @Test
  void testBuilderSvg() {
    // Arrange
    ImmutableSvgDiagram.Builder builderResult = ImmutableSvgDiagram.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.svg("Svg"));
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    ImmutableSvgDiagram actualCopyOfResult = ImmutableSvgDiagram.copyOf(instance);

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
   * Method under test: {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    ImmutableSvgDiagram actualCopyOfResult = ImmutableSvgDiagram.copyOf(instance);

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
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Key Property", actualCopyOfResult.keyProperty());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Product", actualCopyOfResult.product());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.displayHeightPercent());
    assertEquals(1, actualCopyOfResult.displayWidthPercent().intValue());
    assertEquals(1, actualCopyOfResult.priority());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
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
    ImmutableSvgDiagram actualCopyOfResult = ImmutableSvgDiagram.copyOf(instance);

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
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Key Property", actualCopyOfResult.keyProperty());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Product", actualCopyOfResult.product());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.displayWidthPercent());
    assertEquals(1, actualCopyOfResult.displayHeightPercent().intValue());
    assertEquals(1, actualCopyOfResult.priority());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
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
    ImmutableSvgDiagram actualCopyOfResult = ImmutableSvgDiagram.copyOf(instance);

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
   * Method under test: {@link ImmutableSvgDiagram#copyOf(SvgDiagram)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
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
    ImmutableSvgDiagram actualCopyOfResult = ImmutableSvgDiagram.copyOf(instance);

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
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Key Property", actualCopyOfResult.keyProperty());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Product", actualCopyOfResult.product());
    assertEquals("Svg", actualCopyOfResult.svg());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.displayHeightPercent().intValue());
    assertEquals(1, actualCopyOfResult.displayWidthPercent().intValue());
    assertEquals(1, actualCopyOfResult.priority());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#displayHeightPercent()}
   */
  @Test
  void testJsonDisplayHeightPercent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).displayHeightPercent());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#displayWidthPercent()}
   */
  @Test
  void testJsonDisplayWidthPercent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).displayWidthPercent());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#group()}
   */
  @Test
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).group());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#keyProperty()}
   */
  @Test
  void testJsonKeyProperty() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).keyProperty());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSvgDiagram.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSvgDiagram.Json actualJson = new ImmutableSvgDiagram.Json();

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
   * Method under test: {@link ImmutableSvgDiagram.Json#priority()}
   */
  @Test
  void testJsonPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).priority());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#product()}
   */
  @Test
  void testJsonProduct() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).product());
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#setPriority(int)}
   */
  @Test
  void testJsonSetPriority() {
    // Arrange
    ImmutableSvgDiagram.Json json = new ImmutableSvgDiagram.Json();

    // Act
    json.setPriority(1);

    // Assert
    assertEquals(1, json.priority);
    assertTrue(json.priorityIsSet);
  }

  /**
   * Method under test: {@link ImmutableSvgDiagram.Json#svg()}
   */
  @Test
  void testJsonSvg() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSvgDiagram.Json()).svg());
  }
}
