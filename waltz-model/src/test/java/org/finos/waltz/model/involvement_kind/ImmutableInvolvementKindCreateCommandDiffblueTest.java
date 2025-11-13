package org.finos.waltz.model.involvement_kind;

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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindCreateCommand.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKindCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#permittedRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.permittedRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        actualExternalIdResult
            .externalId(externalId)
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("Name", actualImmutableInvolvementKindCreateCommand.name());
    assertEquals("Permitted Role", actualImmutableInvolvementKindCreateCommand.permittedRole());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableInvolvementKindCreateCommand.description());
    assertEquals(EntityKind.ALL, actualImmutableInvolvementKindCreateCommand.subjectKind());
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

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
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalId()).thenReturn(ofResult);

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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindCreateCommand)} with {@code
   * InvolvementKindCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(InvolvementKindCreateCommand) with 'InvolvementKindCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindCreateCommand)"})
  void testBuilderFromWithInvolvementKindCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindCreateCommand)} with {@code
   * InvolvementKindCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(InvolvementKindCreateCommand) with 'InvolvementKindCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindCreateCommand)"})
  void testBuilderFromWithInvolvementKindCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description(null)
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKindCreateCommand)} with {@code
   * InvolvementKindCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKindCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(InvolvementKindCreateCommand) with 'InvolvementKindCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKindCreateCommand)"})
  void testBuilderFromWithInvolvementKindCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole(null)
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description(null)
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole(null)
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableInvolvementKindCreateCommand actualImmutableInvolvementKindCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKindCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link NameProvider} {@link NameProvider#name()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; when NameProvider name() return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_whenNameProviderNameReturnName() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
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
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKindCreateCommand.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#copyOf(InvolvementKindCreateCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableInvolvementKindCreateCommand#copyOf(InvolvementKindCreateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(InvolvementKindCreateCommand); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.copyOf(InvolvementKindCreateCommand)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableInvolvementKindCreateCommand instance =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualCopyOfResult =
        ImmutableInvolvementKindCreateCommand.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}, and {@link
   * ImmutableInvolvementKindCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand2 =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementKindCreateCommand, immutableInvolvementKindCreateCommand2);
    assertEquals(
        immutableInvolvementKindCreateCommand.hashCode(),
        immutableInvolvementKindCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}, and {@link
   * ImmutableInvolvementKindCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementKindCreateCommand, immutableInvolvementKindCreateCommand);
    int expectedHashCodeResult = immutableInvolvementKindCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementKindCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKindCreateCommand,
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("externalId")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKindCreateCommand,
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKindCreateCommand,
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKindCreateCommand,
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKindCreateCommand.equals(Object)",
    "int ImmutableInvolvementKindCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableInvolvementKindCreateCommand");
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#externalId()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableInvolvementKindCreateCommand.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Description is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Description is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonDescriptionIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription(null);
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setSubjectKind(EntityKind.ALL);
    json.setPermittedRole("Json");

    // Act
    ImmutableInvolvementKindCreateCommand actualFromJsonResult =
        ImmutableInvolvementKindCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.permittedRole());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) ExternalId is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) ExternalId is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonExternalIdIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setPermittedRole("Json");

    // Act
    ImmutableInvolvementKindCreateCommand actualFromJsonResult =
        ImmutableInvolvementKindCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.permittedRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) Name is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenOf42_whenJsonNameIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setSubjectKind(EntityKind.ALL);
    json.setPermittedRole("Json");

    // Act
    ImmutableInvolvementKindCreateCommand actualFromJsonResult =
        ImmutableInvolvementKindCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.permittedRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   *   <li>When {@link Json} (default constructor) PermittedRole is {@code null}.
   *   <li>Then return permittedRole is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of '42'; when Json (default constructor) PermittedRole is 'null'; then return permittedRole is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenOf42_whenJsonPermittedRoleIsNull_thenReturnPermittedRoleIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setDescription("Json");
    Optional<String> externalId = Optional.of("42");
    json.setExternalId(externalId);
    json.setSubjectKind(EntityKind.ALL);
    json.setPermittedRole(null);

    // Act
    ImmutableInvolvementKindCreateCommand actualFromJsonResult =
        ImmutableInvolvementKindCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.permittedRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKindCreateCommand#description()}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#name()}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#permittedRole()}
   *   <li>{@link ImmutableInvolvementKindCreateCommand#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableInvolvementKindCreateCommand.description()",
    "String ImmutableInvolvementKindCreateCommand.name()",
    "String ImmutableInvolvementKindCreateCommand.permittedRole()",
    "EntityKind ImmutableInvolvementKindCreateCommand.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableInvolvementKindCreateCommand.description();
    String actualNameResult = immutableInvolvementKindCreateCommand.name();
    String actualPermittedRoleResult = immutableInvolvementKindCreateCommand.permittedRole();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("Permitted Role", actualPermittedRoleResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableInvolvementKindCreateCommand.subjectKind());
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
    assertNull(actualJson.permittedRole);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
  }

  /**
   * Test Json {@link Json#permittedRole()}.
   *
   * <p>Method under test: {@link Json#permittedRole()}
   */
  @Test
  @DisplayName("Test Json permittedRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.permittedRole()"})
  void testJsonPermittedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().permittedRole());
  }

  /**
   * Test Json {@link Json#subjectKind()}.
   *
   * <p>Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableInvolvementKindCreateCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "InvolvementKindCreateCommand{name=Name, externalId=42, subjectKind=ALL}",
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole(null)
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableInvolvementKindCreateCommand.toString()"})
  void testToString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "InvolvementKindCreateCommand{name=Name, externalId=42, subjectKind=ALL, permittedRole=Permitted"
            + " Role}",
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualWithDescriptionResult =
        immutableInvolvementKindCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableInvolvementKindCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("42")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualWithDescriptionResult =
        immutableInvolvementKindCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableInvolvementKindCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableInvolvementKindCreateCommand actualWithExternalIdResult =
        immutableInvolvementKindCreateCommand.withExternalId(optional);

    // Assert
    assertSame(immutableInvolvementKindCreateCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableInvolvementKindCreateCommand actualWithExternalIdResult =
        immutableInvolvementKindCreateCommand.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Permitted Role", actualWithExternalIdResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualWithExternalIdResult =
        immutableInvolvementKindCreateCommand.withExternalId("42");

    // Assert
    assertSame(immutableInvolvementKindCreateCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableInvolvementKindCreateCommand actualWithExternalIdResult =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Permitted Role", actualWithExternalIdResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("42")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualWithNameResult =
        immutableInvolvementKindCreateCommand.withName("42");

    // Assert
    assertSame(immutableInvolvementKindCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableInvolvementKindCreateCommand actualWithNameResult =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Permitted Role", actualWithNameResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withPermittedRole(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withPermittedRole(String)}
   */
  @Test
  @DisplayName("Test withPermittedRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withPermittedRole(String)"
  })
  void testWithPermittedRole() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("42")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualWithPermittedRoleResult =
        immutableInvolvementKindCreateCommand.withPermittedRole("42");

    // Assert
    assertSame(immutableInvolvementKindCreateCommand, actualWithPermittedRoleResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withPermittedRole(String)}.
   *
   * <ul>
   *   <li>Then return permittedRole is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withPermittedRole(String)}
   */
  @Test
  @DisplayName("Test withPermittedRole(String); then return permittedRole is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withPermittedRole(String)"
  })
  void testWithPermittedRole_thenReturnPermittedRoleIs42() {
    // Arrange and Act
    ImmutableInvolvementKindCreateCommand actualWithPermittedRoleResult =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withPermittedRole("42");

    // Assert
    assertEquals("42", actualWithPermittedRoleResult.permittedRole());
    assertEquals("Name", actualWithPermittedRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPermittedRoleResult.description());
    assertEquals(EntityKind.ALL, actualWithPermittedRoleResult.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    ImmutableInvolvementKindCreateCommand immutableInvolvementKindCreateCommand =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKindCreateCommand actualWithSubjectKindResult =
        immutableInvolvementKindCreateCommand.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableInvolvementKindCreateCommand, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableInvolvementKindCreateCommand#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKindCreateCommand#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKindCreateCommand ImmutableInvolvementKindCreateCommand.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenReturnName() {
    // Arrange and Act
    ImmutableInvolvementKindCreateCommand actualWithSubjectKindResult =
        ImmutableInvolvementKindCreateCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithSubjectKindResult.name());
    assertEquals("Permitted Role", actualWithSubjectKindResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithSubjectKindResult.description());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
  }
}
