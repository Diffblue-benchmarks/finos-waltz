package org.finos.waltz.model.role;

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
import org.finos.waltz.model.role.ImmutableRole.Builder;
import org.finos.waltz.model.role.ImmutableRole.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoleDiffblueTest {
  /**
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
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
    Builder builderResult = ImmutableRole.builder();
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
    Builder builderResult = ImmutableRole.builder();
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
   * Test Builder {@link Builder#from(Role)} with {@code Role}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Role} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Role)}
   */
  @Test
  @DisplayName("Test Builder from(Role) with 'Role'; given empty; when Role id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Role)"})
  void testBuilderFromWithRole_givenEmpty_whenRoleIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(true);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    ImmutableRole buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Role)} with {@code Role}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link Role} {@link Role#key()} return {@code Key}.</li>
   *   <li>Then builder build key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Role)}
   */
  @Test
  @DisplayName("Test Builder from(Role) with 'Role'; given 'Key'; when Role key() return 'Key'; then builder build key is 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Role)"})
  void testBuilderFromWithRole_givenKey_whenRoleKeyReturnKey_thenBuilderBuildKeyIsKey() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();
    Role instance = mock(Role.class);
    when(instance.key()).thenReturn("Key");
    when(instance.userSelectable()).thenReturn(true);
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).key();
    verify(instance).name();
    verify(instance).userSelectable();
    ImmutableRole buildResult = builderResult.build();
    assertEquals("Key", buildResult.key());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertTrue(buildResult.isCustom());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Role)} with {@code Role}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Role)}
   */
  @Test
  @DisplayName("Test Builder from(Role) with 'Role'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Role)"})
  void testBuilderFromWithRole_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();
    Role instance = mock(Role.class);
    when(instance.userSelectable()).thenThrow(new IllegalStateException("instance"));
    when(instance.isCustom()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).description();
    verify(instance).isCustom();
    verify(instance).name();
    verify(instance).userSelectable();
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
    Builder builderResult = ImmutableRole.builder();

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
    Builder builderResult = ImmutableRole.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isCustom(boolean)}.
   * <p>
   * Method under test: {@link Builder#isCustom(boolean)}
   */
  @Test
  @DisplayName("Test Builder isCustom(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isCustom(boolean)"})
  void testBuilderIsCustom() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isCustom(true));
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   * <p>
   * Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
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
    Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#userSelectable(boolean)}.
   * <p>
   * Method under test: {@link Builder#userSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userSelectable(boolean)"})
  void testBuilderUserSelectable() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
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
   * Test Json {@link Json#isCustom()}.
   * <p>
   * Method under test: {@link Json#isCustom()}
   */
  @Test
  @DisplayName("Test Json isCustom()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isCustom()"})
  void testJsonIsCustom() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isCustom());
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).key());
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
    assertNull(actualJson.key);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isCustom);
    assertFalse(actualJson.isCustomIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
  }

  /**
   * Test Json {@link Json#setIsCustom(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsCustom(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsCustom(boolean)"})
  void testJsonSetIsCustom() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsCustom(true);

    // Assert
    assertTrue(json.isCustom);
    assertTrue(json.isCustomIsSet);
  }

  /**
   * Test Json {@link Json#setUserSelectable(boolean)}.
   * <p>
   * Method under test: {@link Json#setUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Json setUserSelectable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setUserSelectable(boolean)"})
  void testJsonSetUserSelectable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Test Json {@link Json#userSelectable()}.
   * <p>
   * Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userSelectable());
  }
}
