package org.finos.waltz.model.actor;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.actor.ImmutableActorCreateCommand.Builder;
import org.finos.waltz.model.actor.ImmutableActorCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableActorCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableActorCreateCommand actualImmutableActorCreateCommand =
        actualExternalIdResult.externalId(externalId).isExternal(true).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableActorCreateCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableActorCreateCommand.description());
    assertTrue(actualImmutableActorCreateCommand.isExternal());
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ActorCreateCommand)} with {@code ActorCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(ActorCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ActorCreateCommand) with 'ActorCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ActorCreateCommand)"})
  void testBuilderFromWithActorCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ActorCreateCommand)} with {@code ActorCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(ActorCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ActorCreateCommand) with 'ActorCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ActorCreateCommand)"})
  void testBuilderFromWithActorCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description(null)
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
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
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
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
    Builder builderResult = ImmutableActorCreateCommand.builder();

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
    Builder builderResult = ImmutableActorCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider2() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description(null)
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
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
    Builder builderResult = ImmutableActorCreateCommand.builder();
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description(null)
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableActorCreateCommand actualImmutableActorCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableActorCreateCommand);
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
    Builder builderResult = ImmutableActorCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isExternal(boolean)}.
   *
   * <p>Method under test: {@link Builder#isExternal(boolean)}
   */
  @Test
  @DisplayName("Test Builder isExternal(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isExternal(boolean)"})
  void testBuilderIsExternal() {
    // Arrange
    Builder builderResult = ImmutableActorCreateCommand.builder();

    // Act
    Builder actualIsExternalResult = builderResult.isExternal(true);

    // Assert
    assertSame(builderResult, actualIsExternalResult);
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
    Builder builderResult = ImmutableActorCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#copyOf(ActorCreateCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#copyOf(ActorCreateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(ActorCreateCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.copyOf(ActorCreateCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableActorCreateCommand instance =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    ImmutableActorCreateCommand actualCopyOfResult = ImmutableActorCreateCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isExternal());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}, and {@link
   * ImmutableActorCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableActorCreateCommand#equals(Object)}
   *   <li>{@link ImmutableActorCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();
    ImmutableActorCreateCommand immutableActorCreateCommand2 =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableActorCreateCommand, immutableActorCreateCommand2);
    assertEquals(immutableActorCreateCommand.hashCode(), immutableActorCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}, and {@link
   * ImmutableActorCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableActorCreateCommand#equals(Object)}
   *   <li>{@link ImmutableActorCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableActorCreateCommand, immutableActorCreateCommand);
    int expectedHashCodeResult = immutableActorCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableActorCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .isExternal(true)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActorCreateCommand,
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(false)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActorCreateCommand,
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("externalId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableActorCreateCommand,
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableActorCreateCommand.equals(Object)",
    "int ImmutableActorCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build(),
        "Different type to ImmutableActorCreateCommand");
  }

  /**
   * Test {@link ImmutableActorCreateCommand#externalId()}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableActorCreateCommand.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableActorCreateCommand#description()}
   *   <li>{@link ImmutableActorCreateCommand#isExternal()}
   *   <li>{@link ImmutableActorCreateCommand#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableActorCreateCommand.description()",
    "boolean ImmutableActorCreateCommand.isExternal()",
    "String ImmutableActorCreateCommand.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableActorCreateCommand.description();
    boolean actualIsExternalResult = immutableActorCreateCommand.isExternal();

    // Assert
    assertEquals("Name", immutableActorCreateCommand.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(actualIsExternalResult);
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#isExternal()}.
   *
   * <p>Method under test: {@link Json#isExternal()}
   */
  @Test
  @DisplayName("Test Json isExternal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isExternal()"})
  void testJsonIsExternal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isExternal());
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
    assertNull(actualJson.name);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.isExternal);
    assertFalse(actualJson.isExternalIsSet);
  }

  /**
   * Test Json {@link Json#setIsExternal(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsExternal(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsExternal(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsExternal(boolean)"})
  void testJsonSetIsExternal() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsExternal(true);

    // Assert
    assertTrue(json.isExternal);
    assertTrue(json.isExternalIsSet);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableActorCreateCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ActorCreateCommand{name=Name, externalId=42, isExternal=true}",
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    ImmutableActorCreateCommand actualWithDescriptionResult =
        immutableActorCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableActorCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("42")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    ImmutableActorCreateCommand actualWithDescriptionResult =
        immutableActorCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableActorCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableActorCreateCommand actualWithExternalIdResult =
        immutableActorCreateCommand.withExternalId(optional);

    // Assert
    assertSame(immutableActorCreateCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableActorCreateCommand actualWithExternalIdResult =
        immutableActorCreateCommand.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertTrue(actualWithExternalIdResult.isExternal());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    ImmutableActorCreateCommand actualWithExternalIdResult =
        immutableActorCreateCommand.withExternalId("42");

    // Assert
    assertSame(immutableActorCreateCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableActorCreateCommand actualWithExternalIdResult =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertTrue(actualWithExternalIdResult.isExternal());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withIsExternal(boolean)}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withIsExternal(boolean)}
   */
  @Test
  @DisplayName("Test withIsExternal(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withIsExternal(boolean)"
  })
  void testWithIsExternal() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build();

    // Act
    ImmutableActorCreateCommand actualWithIsExternalResult =
        immutableActorCreateCommand.withIsExternal(true);

    // Assert
    assertSame(immutableActorCreateCommand, actualWithIsExternalResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withIsExternal(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withIsExternal(boolean)}
   */
  @Test
  @DisplayName("Test withIsExternal(boolean); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableActorCreateCommand ImmutableActorCreateCommand.withIsExternal(boolean)"
  })
  void testWithIsExternal_thenReturnName() {
    // Arrange and Act
    ImmutableActorCreateCommand actualWithIsExternalResult =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(false)
            .name("Name")
            .build()
            .withIsExternal(true);

    // Assert
    assertEquals("Name", actualWithIsExternalResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsExternalResult.description());
    assertTrue(actualWithIsExternalResult.isExternal());
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActorCreateCommand ImmutableActorCreateCommand.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableActorCreateCommand immutableActorCreateCommand =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("42")
            .build();

    // Act
    ImmutableActorCreateCommand actualWithNameResult = immutableActorCreateCommand.withName("42");

    // Assert
    assertSame(immutableActorCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableActorCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableActorCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableActorCreateCommand ImmutableActorCreateCommand.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableActorCreateCommand actualWithNameResult =
        ImmutableActorCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .isExternal(true)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertTrue(actualWithNameResult.isExternal());
  }
}
