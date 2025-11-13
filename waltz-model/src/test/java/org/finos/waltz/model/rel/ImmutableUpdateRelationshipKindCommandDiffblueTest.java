package org.finos.waltz.model.rel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.rel.ImmutableUpdateRelationshipKindCommand.Builder;
import org.finos.waltz.model.rel.ImmutableUpdateRelationshipKindCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRelationshipKindCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Assert
    assertEquals("Name", actualImmutableUpdateRelationshipKindCommand.name());
    assertEquals("Reverse Name", actualImmutableUpdateRelationshipKindCommand.reverseName());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableUpdateRelationshipKindCommand.description());
    assertEquals(1, actualImmutableUpdateRelationshipKindCommand.position());
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateRelationshipKindCommand);
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

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
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider3() {
    // Arrange
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description(null)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateRelationshipKindCommand);
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateRelationshipKindCommand);
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description(null)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateRelationshipKindCommand);
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateRelationshipKindCommand)} with {@code
   * UpdateRelationshipKindCommand}.
   *
   * <p>Method under test: {@link Builder#from(UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateRelationshipKindCommand) with 'UpdateRelationshipKindCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateRelationshipKindCommand)"})
  void testBuilderFromWithUpdateRelationshipKindCommand() {
    // Arrange
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateRelationshipKindCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateRelationshipKindCommand)} with {@code
   * UpdateRelationshipKindCommand}.
   *
   * <p>Method under test: {@link Builder#from(UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UpdateRelationshipKindCommand) with 'UpdateRelationshipKindCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UpdateRelationshipKindCommand)"})
  void testBuilderFromWithUpdateRelationshipKindCommand2() {
    // Arrange
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description(null)
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUpdateRelationshipKindCommand actualImmutableUpdateRelationshipKindCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableUpdateRelationshipKindCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#reverseName(String)}.
   *
   * <ul>
   *   <li>When {@code Reverse Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#reverseName(String)}
   */
  @Test
  @DisplayName("Test Builder reverseName(String); when 'Reverse Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.reverseName(String)"})
  void testBuilderReverseName_whenReverseName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateRelationshipKindCommand.builder();

    // Act
    Builder actualReverseNameResult = builderResult.reverseName("Reverse Name");

    // Assert
    assertSame(builderResult, actualReverseNameResult);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#copyOf(UpdateRelationshipKindCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableUpdateRelationshipKindCommand#copyOf(UpdateRelationshipKindCommand)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateRelationshipKindCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.copyOf(UpdateRelationshipKindCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand instance =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableUpdateRelationshipKindCommand actualCopyOfResult =
        ImmutableUpdateRelationshipKindCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Reverse Name", actualCopyOfResult.reverseName());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}, and {@link
   * ImmutableUpdateRelationshipKindCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand2 =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertEquals(immutableUpdateRelationshipKindCommand, immutableUpdateRelationshipKindCommand2);
    assertEquals(
        immutableUpdateRelationshipKindCommand.hashCode(),
        immutableUpdateRelationshipKindCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}, and {@link
   * ImmutableUpdateRelationshipKindCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertEquals(immutableUpdateRelationshipKindCommand, immutableUpdateRelationshipKindCommand);
    int expectedHashCodeResult = immutableUpdateRelationshipKindCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableUpdateRelationshipKindCommand.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Reverse Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateRelationshipKindCommand,
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(0)
            .reverseName("Reverse Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateRelationshipKindCommand,
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUpdateRelationshipKindCommand,
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUpdateRelationshipKindCommand.equals(Object)",
    "int ImmutableUpdateRelationshipKindCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build(),
        "Different type to ImmutableUpdateRelationshipKindCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#toString()}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#description()}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#name()}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#position()}
   *   <li>{@link ImmutableUpdateRelationshipKindCommand#reverseName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUpdateRelationshipKindCommand.description()",
    "String ImmutableUpdateRelationshipKindCommand.name()",
    "int ImmutableUpdateRelationshipKindCommand.position()",
    "String ImmutableUpdateRelationshipKindCommand.reverseName()",
    "String ImmutableUpdateRelationshipKindCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    String actualToStringResult = immutableUpdateRelationshipKindCommand.toString();
    String actualDescriptionResult = immutableUpdateRelationshipKindCommand.description();
    String actualNameResult = immutableUpdateRelationshipKindCommand.name();
    int actualPositionResult = immutableUpdateRelationshipKindCommand.position();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("Reverse Name", immutableUpdateRelationshipKindCommand.reverseName());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(
        "UpdateRelationshipKindCommand{name=Name, reverseName=Reverse Name, position=1}",
        actualToStringResult);
    assertEquals(1, actualPositionResult);
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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setReverseName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setName(String)",
    "void Json.setReverseName(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setName("Name");
    actualJson.setReverseName("Reverse Name");

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("Reverse Name", actualJson.reverseName);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.positionIsSet);
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
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#reverseName()}.
   *
   * <p>Method under test: {@link Json#reverseName()}
   */
  @Test
  @DisplayName("Test Json reverseName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.reverseName()"})
  void testJsonReverseName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().reverseName());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableUpdateRelationshipKindCommand actualWithDescriptionResult =
        immutableUpdateRelationshipKindCommand.withDescription("42");

    // Assert
    assertEquals(immutableUpdateRelationshipKindCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("42")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableUpdateRelationshipKindCommand actualWithDescriptionResult =
        immutableUpdateRelationshipKindCommand.withDescription("42");

    // Assert
    assertSame(immutableUpdateRelationshipKindCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("42")
            .position(1)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableUpdateRelationshipKindCommand actualWithNameResult =
        immutableUpdateRelationshipKindCommand.withName("42");

    // Assert
    assertSame(immutableUpdateRelationshipKindCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableUpdateRelationshipKindCommand actualWithNameResult =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Reverse Name", actualWithNameResult.reverseName());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(42)
            .reverseName("Reverse Name")
            .build();

    // Act
    ImmutableUpdateRelationshipKindCommand actualWithPositionResult =
        immutableUpdateRelationshipKindCommand.withPosition(42);

    // Assert
    assertSame(immutableUpdateRelationshipKindCommand, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withPosition(int)"
  })
  void testWithPosition_thenReturnName() {
    // Arrange and Act
    ImmutableUpdateRelationshipKindCommand actualWithPositionResult =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals("Reverse Name", actualWithPositionResult.reverseName());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(42, actualWithPositionResult.position());
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withReverseName(String)}.
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withReverseName(String)}
   */
  @Test
  @DisplayName("Test withReverseName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withReverseName(String)"
  })
  void testWithReverseName() {
    // Arrange
    ImmutableUpdateRelationshipKindCommand immutableUpdateRelationshipKindCommand =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("42")
            .build();

    // Act
    ImmutableUpdateRelationshipKindCommand actualWithReverseNameResult =
        immutableUpdateRelationshipKindCommand.withReverseName("42");

    // Assert
    assertSame(immutableUpdateRelationshipKindCommand, actualWithReverseNameResult);
  }

  /**
   * Test {@link ImmutableUpdateRelationshipKindCommand#withReverseName(String)}.
   *
   * <ul>
   *   <li>Then return reverseName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUpdateRelationshipKindCommand#withReverseName(String)}
   */
  @Test
  @DisplayName("Test withReverseName(String); then return reverseName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUpdateRelationshipKindCommand ImmutableUpdateRelationshipKindCommand.withReverseName(String)"
  })
  void testWithReverseName_thenReturnReverseNameIs42() {
    // Arrange and Act
    ImmutableUpdateRelationshipKindCommand actualWithReverseNameResult =
        ImmutableUpdateRelationshipKindCommand.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .position(1)
            .reverseName("Reverse Name")
            .build()
            .withReverseName("42");

    // Assert
    assertEquals("42", actualWithReverseNameResult.reverseName());
    assertEquals("Name", actualWithReverseNameResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithReverseNameResult.description());
    assertEquals(1, actualWithReverseNameResult.position());
  }
}
