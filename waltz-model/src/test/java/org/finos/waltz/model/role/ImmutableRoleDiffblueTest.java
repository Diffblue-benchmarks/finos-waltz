package org.finos.waltz.model.role;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.role.ImmutableRole.Builder;
import org.finos.waltz.model.role.ImmutableRole.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoleDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableRole.builder().description("The characteristics of someone or something").id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableRole actualImmutableRole =
        actualIdResult.id(id).isCustom(true).key("Key").name("Name").build();

    // Assert
    assertEquals("Key", actualImmutableRole.key());
    assertEquals("Name", actualImmutableRole.name());
    assertEquals("The characteristics of someone or something", actualImmutableRole.description());
    assertTrue(actualImmutableRole.isCustom());
    assertTrue(actualImmutableRole.userSelectable());
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
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
    Builder builderResult = ImmutableRole.builder();
    ImmutableRole instance =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRole actualImmutableRole = builderResult.build();
    assertEquals(instance, actualImmutableRole);
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
  void testBuilderFromWithIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();
    ImmutableRole instance =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(false)
            .key("Key")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRole actualImmutableRole = builderResult.build();
    assertEquals(instance, actualImmutableRole);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   *   <li>Then calls {@link IdProvider#id()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty_thenCallsId() {
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
   * Test Builder {@link Builder#from(Role)} with {@code Role}.
   *
   * <p>Method under test: {@link Builder#from(Role)}
   */
  @Test
  @DisplayName("Test Builder from(Role) with 'Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Role)"})
  void testBuilderFromWithRole() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();
    ImmutableRole instance =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRole actualImmutableRole = builderResult.build();
    assertEquals(instance, actualImmutableRole);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Role)} with {@code Role}.
   *
   * <p>Method under test: {@link Builder#from(Role)}
   */
  @Test
  @DisplayName("Test Builder from(Role) with 'Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Role)"})
  void testBuilderFromWithRole2() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();
    ImmutableRole instance =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(false)
            .key("Key")
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRole actualImmutableRole = builderResult.build();
    assertEquals(instance, actualImmutableRole);
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
    Builder builderResult = ImmutableRole.builder();

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
    Builder builderResult = ImmutableRole.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isCustom(boolean)}.
   *
   * <p>Method under test: {@link Builder#isCustom(boolean)}
   */
  @Test
  @DisplayName("Test Builder isCustom(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isCustom(boolean)"})
  void testBuilderIsCustom() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act
    Builder actualIsCustomResult = builderResult.isCustom(true);

    // Assert
    assertSame(builderResult, actualIsCustomResult);
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String); when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
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
    Builder builderResult = ImmutableRole.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#userSelectable(boolean)}.
   *
   * <p>Method under test: {@link Builder#userSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userSelectable(boolean)"})
  void testBuilderUserSelectable() {
    // Arrange
    Builder builderResult = ImmutableRole.builder();

    // Act
    Builder actualUserSelectableResult = builderResult.userSelectable(true);

    // Assert
    assertSame(builderResult, actualUserSelectableResult);
  }

  /**
   * Test {@link ImmutableRole#copyOf(Role)}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#copyOf(Role)}
   */
  @Test
  @DisplayName("Test copyOf(Role); then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.copyOf(Role)"})
  void testCopyOf_thenReturnKey() {
    // Arrange
    ImmutableRole instance =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    ImmutableRole actualCopyOfResult = ImmutableRole.copyOf(instance);

    // Assert
    assertEquals("Key", actualCopyOfResult.key());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isCustom());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}, and {@link ImmutableRole#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRole#equals(Object)}
   *   <li>{@link ImmutableRole#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();
    ImmutableRole immutableRole2 =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableRole, immutableRole2);
    assertEquals(immutableRole.hashCode(), immutableRole2.hashCode());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}, and {@link ImmutableRole#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRole#equals(Object)}
   *   <li>{@link ImmutableRole#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableRole, immutableRole);
    int expectedHashCodeResult = immutableRole.hashCode();
    assertEquals(expectedHashCodeResult, immutableRole.hashCode());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("Key")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRole,
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRole,
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(false)
            .key("Key")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRole,
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Name")
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRole,
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Key")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRole,
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRole#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRole.equals(Object)", "int ImmutableRole.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build(),
        "Different type to ImmutableRole");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRole#description()}
   *   <li>{@link ImmutableRole#isCustom()}
   *   <li>{@link ImmutableRole#key()}
   *   <li>{@link ImmutableRole#name()}
   *   <li>{@link ImmutableRole#userSelectable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableRole.description()",
    "boolean ImmutableRole.isCustom()",
    "String ImmutableRole.key()",
    "String ImmutableRole.name()",
    "boolean ImmutableRole.userSelectable()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableRole.description();
    boolean actualIsCustomResult = immutableRole.isCustom();
    String actualKeyResult = immutableRole.key();
    String actualNameResult = immutableRole.name();

    // Assert
    assertEquals("Key", actualKeyResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(actualIsCustomResult);
    assertTrue(immutableRole.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#id()}.
   *
   * <p>Method under test: {@link ImmutableRole#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableRole.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
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
   * Test Json {@link Json#isCustom()}.
   *
   * <p>Method under test: {@link Json#isCustom()}
   */
  @Test
  @DisplayName("Test Json isCustom()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isCustom()"})
  void testJsonIsCustom() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isCustom());
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
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
   *
   * <p>Method under test: {@link Json#setIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsCustom(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Json setUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userSelectable());
  }

  /**
   * Test {@link ImmutableRole#toString()}.
   *
   * <p>Method under test: {@link ImmutableRole#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRole.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Role{id=1, key=Key, name=Name, description=The characteristics of someone or something, isCustom=true,"
            + " userSelectable=true}",
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableRole#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRole#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("42")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    ImmutableRole actualWithDescriptionResult = immutableRole.withDescription("42");

    // Assert
    assertSame(immutableRole, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRole#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableRole actualWithDescriptionResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("Key", actualWithDescriptionResult.key());
    assertEquals("Name", actualWithDescriptionResult.name());
    assertTrue(actualWithDescriptionResult.isCustom());
    assertTrue(actualWithDescriptionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableRole#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableRole actualWithIdResult = immutableRole.withId(optional);

    // Assert
    assertSame(immutableRole, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRole#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnKey() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableRole actualWithIdResult = immutableRole.withId(optional);

    // Assert
    assertEquals("Key", actualWithIdResult.key());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertTrue(actualWithIdResult.isCustom());
    assertTrue(actualWithIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableRole#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    ImmutableRole actualWithIdResult = immutableRole.withId(1L);

    // Assert
    assertSame(immutableRole, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRole#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnKey() {
    // Arrange and Act
    ImmutableRole actualWithIdResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Key", actualWithIdResult.key());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertTrue(actualWithIdResult.isCustom());
    assertTrue(actualWithIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#withIsCustom(boolean)}.
   *
   * <p>Method under test: {@link ImmutableRole#withIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test withIsCustom(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withIsCustom(boolean)"})
  void testWithIsCustom() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    ImmutableRole actualWithIsCustomResult = immutableRole.withIsCustom(true);

    // Assert
    assertSame(immutableRole, actualWithIsCustomResult);
  }

  /**
   * Test {@link ImmutableRole#withIsCustom(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withIsCustom(boolean)}
   */
  @Test
  @DisplayName("Test withIsCustom(boolean); then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withIsCustom(boolean)"})
  void testWithIsCustom_thenReturnKey() {
    // Arrange and Act
    ImmutableRole actualWithIsCustomResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(false)
            .key("Key")
            .name("Name")
            .build()
            .withIsCustom(true);

    // Assert
    assertEquals("Key", actualWithIsCustomResult.key());
    assertEquals("Name", actualWithIsCustomResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsCustomResult.description());
    assertTrue(actualWithIsCustomResult.isCustom());
    assertTrue(actualWithIsCustomResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#withKey(String)}.
   *
   * <p>Method under test: {@link ImmutableRole#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withKey(String)"})
  void testWithKey() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("42")
            .name("Name")
            .build();

    // Act
    ImmutableRole actualWithKeyResult = immutableRole.withKey("42");

    // Assert
    assertSame(immutableRole, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableRole#withKey(String)}.
   *
   * <ul>
   *   <li>Then return key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withKey(String)"})
  void testWithKey_thenReturnKeyIs42() {
    // Arrange and Act
    ImmutableRole actualWithKeyResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .withKey("42");

    // Assert
    assertEquals("42", actualWithKeyResult.key());
    assertEquals("Name", actualWithKeyResult.name());
    assertEquals("The characteristics of someone or something", actualWithKeyResult.description());
    assertTrue(actualWithKeyResult.isCustom());
    assertTrue(actualWithKeyResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableRole#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("42")
            .build();

    // Act
    ImmutableRole actualWithNameResult = immutableRole.withName("42");

    // Assert
    assertSame(immutableRole, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableRole#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableRole actualWithNameResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Key", actualWithNameResult.key());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertTrue(actualWithNameResult.isCustom());
    assertTrue(actualWithNameResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRole#withUserSelectable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableRole#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withUserSelectable(boolean)"})
  void testWithUserSelectable() {
    // Arrange
    ImmutableRole immutableRole =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();

    // Act
    ImmutableRole actualWithUserSelectableResult = immutableRole.withUserSelectable(true);

    // Assert
    assertSame(immutableRole, actualWithUserSelectableResult);
  }

  /**
   * Test {@link ImmutableRole#withUserSelectable(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRole#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean); when 'false'; then return 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRole ImmutableRole.withUserSelectable(boolean)"})
  void testWithUserSelectable_whenFalse_thenReturnKey() {
    // Arrange and Act
    ImmutableRole actualWithUserSelectableResult =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build()
            .withUserSelectable(false);

    // Assert
    assertEquals("Key", actualWithUserSelectableResult.key());
    assertEquals("Name", actualWithUserSelectableResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithUserSelectableResult.description());
    assertFalse(actualWithUserSelectableResult.userSelectable());
    assertTrue(actualWithUserSelectableResult.isCustom());
  }
}
