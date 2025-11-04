package org.finos.waltz.model.staticpanel;

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
import org.finos.waltz.model.IdProvider;
import org.junit.jupiter.api.Test;

class ImmutableStaticPanelDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableStaticPanel#builder()}
   *   <li>{@link ImmutableStaticPanel#encoding(ContentKind)}
   *   <li>{@link ImmutableStaticPanel#icon(String)}
   *   <li>{@link ImmutableStaticPanel#title(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableStaticPanel.Builder actualIdResult = ImmutableStaticPanel.builder()
        .encoding(ContentKind.HTML)
        .icon("Icon")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableStaticPanel.Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.title("Dr"));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#content(String)}
   */
  @Test
  void testBuilderContent() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.content("Not all who wander are lost"));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableStaticPanel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableStaticPanel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(StaticPanel)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    ImmutableStaticPanel buildResult = builderResult.build();
    assertEquals("Dr", buildResult.title());
    assertEquals("Group", buildResult.group());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals(1, buildResult.priority());
    assertEquals(1, buildResult.width());
    assertEquals(ContentKind.HTML, buildResult.encoding());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(StaticPanel)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    StaticPanel instance = mock(StaticPanel.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(StaticPanel)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    ImmutableStaticPanel buildResult = builderResult.build();
    assertEquals("Dr", buildResult.title());
    assertEquals("Group", buildResult.group());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertEquals(1, buildResult.priority());
    assertEquals(1, buildResult.width());
    assertEquals(ContentKind.HTML, buildResult.encoding());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(StaticPanel)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn(null);
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    ImmutableStaticPanel buildResult = builderResult.build();
    assertEquals("Dr", buildResult.title());
    assertEquals("Group", buildResult.group());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertNull(buildResult.icon());
    assertEquals(1, buildResult.priority());
    assertEquals(1, buildResult.width());
    assertEquals(ContentKind.HTML, buildResult.encoding());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#from(StaticPanel)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn(null);
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    ImmutableStaticPanel buildResult = builderResult.build();
    assertEquals("Group", buildResult.group());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Not all who wander are lost", buildResult.content());
    assertNull(buildResult.title());
    assertEquals(1, buildResult.priority());
    assertEquals(1, buildResult.width());
    assertEquals(ContentKind.HTML, buildResult.encoding());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#group(String)}
   */
  @Test
  void testBuilderGroup() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.group("Group"));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#priority(int)}
   */
  @Test
  void testBuilderPriority() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.priority(1));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Builder#width(int)}
   */
  @Test
  void testBuilderWidth() {
    // Arrange
    ImmutableStaticPanel.Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.width(1));
  }

  /**
   * Method under test: {@link ImmutableStaticPanel#copyOf(StaticPanel)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel actualCopyOfResult = ImmutableStaticPanel.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals(1, actualCopyOfResult.priority());
    assertEquals(1, actualCopyOfResult.width());
    assertEquals(ContentKind.HTML, actualCopyOfResult.encoding());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel#copyOf(StaticPanel)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel actualCopyOfResult = ImmutableStaticPanel.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals(1, actualCopyOfResult.priority());
    assertEquals(1, actualCopyOfResult.width());
    assertEquals(ContentKind.HTML, actualCopyOfResult.encoding());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel#copyOf(StaticPanel)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn(null);
    when(instance.title()).thenReturn("Dr");
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel actualCopyOfResult = ImmutableStaticPanel.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertNull(actualCopyOfResult.icon());
    assertEquals(1, actualCopyOfResult.priority());
    assertEquals(1, actualCopyOfResult.width());
    assertEquals(ContentKind.HTML, actualCopyOfResult.encoding());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel#copyOf(StaticPanel)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    StaticPanel instance = mock(StaticPanel.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.group()).thenReturn("Group");
    when(instance.content()).thenReturn("Not all who wander are lost");
    when(instance.priority()).thenReturn(1);
    when(instance.icon()).thenReturn("Icon");
    when(instance.title()).thenReturn(null);
    when(instance.width()).thenReturn(1);
    when(instance.encoding()).thenReturn(ContentKind.HTML);

    // Act
    ImmutableStaticPanel actualCopyOfResult = ImmutableStaticPanel.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).content();
    verify(instance).encoding();
    verify(instance).group();
    verify(instance).icon();
    verify(instance).priority();
    verify(instance).title();
    verify(instance).width();
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertNull(actualCopyOfResult.title());
    assertEquals(1, actualCopyOfResult.priority());
    assertEquals(1, actualCopyOfResult.width());
    assertEquals(ContentKind.HTML, actualCopyOfResult.encoding());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#content()}
   */
  @Test
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).content());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#encoding()}
   */
  @Test
  void testJsonEncoding() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).encoding());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#group()}
   */
  @Test
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).group());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#icon()}
   */
  @Test
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).icon());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableStaticPanel.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableStaticPanel.Json actualJson = new ImmutableStaticPanel.Json();

    // Assert
    assertNull(actualJson.content);
    assertNull(actualJson.group);
    assertNull(actualJson.icon);
    assertNull(actualJson.title);
    assertNull(actualJson.encoding);
    assertEquals(0, actualJson.priority);
    assertEquals(0, actualJson.width);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.priorityIsSet);
    assertFalse(actualJson.widthIsSet);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#priority()}
   */
  @Test
  void testJsonPriority() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).priority());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#setPriority(int)}
   */
  @Test
  void testJsonSetPriority() {
    // Arrange
    ImmutableStaticPanel.Json json = new ImmutableStaticPanel.Json();

    // Act
    json.setPriority(1);

    // Assert
    assertEquals(1, json.priority);
    assertTrue(json.priorityIsSet);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#setWidth(int)}
   */
  @Test
  void testJsonSetWidth() {
    // Arrange
    ImmutableStaticPanel.Json json = new ImmutableStaticPanel.Json();

    // Act
    json.setWidth(1);

    // Assert
    assertEquals(1, json.width);
    assertTrue(json.widthIsSet);
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#title()}
   */
  @Test
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).title());
  }

  /**
   * Method under test: {@link ImmutableStaticPanel.Json#width()}
   */
  @Test
  void testJsonWidth() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableStaticPanel.Json()).width());
  }
}
