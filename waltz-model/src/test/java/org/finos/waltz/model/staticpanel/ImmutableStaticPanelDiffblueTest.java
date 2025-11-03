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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.staticpanel.ImmutableStaticPanel.Builder;
import org.finos.waltz.model.staticpanel.ImmutableStaticPanel.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableStaticPanelDiffblueTest {
  /**
   * Test {@link ImmutableStaticPanel#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableStaticPanel#builder()}
   *   <li>{@link ImmutableStaticPanel#encoding(ContentKind)}
   *   <li>{@link ImmutableStaticPanel#icon(String)}
   *   <li>{@link ImmutableStaticPanel#title(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableStaticPanel Builder.build()", "Builder Builder.encoding(ContentKind)",
      "Builder Builder.icon(String)", "Builder Builder.title(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableStaticPanel.builder().encoding(ContentKind.HTML).icon("Icon").id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.title("Dr"));
  }

  /**
   * Test Builder {@link Builder#content(String)}.
   * <p>
   * Method under test: {@link Builder#content(String)}
   */
  @Test
  @DisplayName("Test Builder content(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.content(String)"})
  void testBuilderContent() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.content("Not all who wander are lost"));
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
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder builderResult = ImmutableStaticPanel.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link StaticPanel} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'; given empty; when StaticPanel id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel_givenEmpty_whenStaticPanelIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   *   <li>Then builder build title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'; given Optional with one; then builder build title is 'Dr'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel_givenOptionalWithOne_thenBuilderBuildTitleIsDr() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   * <ul>
   *   <li>Then builder build icon is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'; then builder build icon is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel_thenBuilderBuildIconIsNull() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   * <ul>
   *   <li>Then builder build title is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'; then builder build title is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel_thenBuilderBuildTitleIsNull() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(StaticPanel)} with {@code StaticPanel}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(StaticPanel)}
   */
  @Test
  @DisplayName("Test Builder from(StaticPanel) with 'StaticPanel'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(StaticPanel)"})
  void testBuilderFromWithStaticPanel_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();
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
    Builder builderResult = ImmutableStaticPanel.builder();

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
    Builder builderResult = ImmutableStaticPanel.builder();

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
    Builder builderResult = ImmutableStaticPanel.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
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
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.priority(1));
  }

  /**
   * Test Builder {@link Builder#width(int)}.
   * <p>
   * Method under test: {@link Builder#width(int)}
   */
  @Test
  @DisplayName("Test Builder width(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.width(int)"})
  void testBuilderWidth() {
    // Arrange
    Builder builderResult = ImmutableStaticPanel.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.width(1));
  }

  /**
   * Test Json {@link Json#content()}.
   * <p>
   * Method under test: {@link Json#content()}
   */
  @Test
  @DisplayName("Test Json content()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.content()"})
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).content());
  }

  /**
   * Test Json {@link Json#encoding()}.
   * <p>
   * Method under test: {@link Json#encoding()}
   */
  @Test
  @DisplayName("Test Json encoding()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ContentKind Json.encoding()"})
  void testJsonEncoding() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).encoding());
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
   * Test Json {@link Json#icon()}.
   * <p>
   * Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).icon());
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
   * Test Json {@link Json#setWidth(int)}.
   * <p>
   * Method under test: {@link Json#setWidth(int)}
   */
  @Test
  @DisplayName("Test Json setWidth(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setWidth(int)"})
  void testJsonSetWidth() {
    // Arrange
    Json json = new Json();

    // Act
    json.setWidth(1);

    // Assert
    assertEquals(1, json.width);
    assertTrue(json.widthIsSet);
  }

  /**
   * Test Json {@link Json#title()}.
   * <p>
   * Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).title());
  }

  /**
   * Test Json {@link Json#width()}.
   * <p>
   * Method under test: {@link Json#width()}
   */
  @Test
  @DisplayName("Test Json width()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.width()"})
  void testJsonWidth() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).width());
  }
}
