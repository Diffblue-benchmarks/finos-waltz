package org.finos.waltz.model.survey;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.survey.ImmutableSurveyTemplateChangeCommand.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyTemplateChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateChangeCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#issuanceRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.issuanceRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        actualIdResult
            .id(id)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("Issuance Role", actualImmutableSurveyTemplateChangeCommand.issuanceRole());
    assertEquals("Name", actualImmutableSurveyTemplateChangeCommand.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSurveyTemplateChangeCommand.description());
    assertEquals(EntityKind.ALL, actualImmutableSurveyTemplateChangeCommand.targetEntityKind());
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    Optional<String> externalId = Optional.of("foo");

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
   *   <li>Given of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOfFoo() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole(null)
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateChangeCommand)} with {@code
   * SurveyTemplateChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateChangeCommand) with 'SurveyTemplateChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateChangeCommand)"})
  void testBuilderFromWithSurveyTemplateChangeCommand() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateChangeCommand)} with {@code
   * SurveyTemplateChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateChangeCommand) with 'SurveyTemplateChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateChangeCommand)"})
  void testBuilderFromWithSurveyTemplateChangeCommand2() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplateChangeCommand)} with {@code
   * SurveyTemplateChangeCommand}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplateChangeCommand) with 'SurveyTemplateChangeCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplateChangeCommand)"})
  void testBuilderFromWithSurveyTemplateChangeCommand3() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole(null)
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyTemplateChangeCommand actualImmutableSurveyTemplateChangeCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplateChangeCommand);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
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
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#targetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#targetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder targetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetEntityKind(EntityKind)"})
  void testBuilderTargetEntityKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplateChangeCommand.builder();

    // Act
    Builder actualTargetEntityKindResult = builderResult.targetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#copyOf(SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Issuance Role}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyTemplateChangeCommand#copyOf(SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyTemplateChangeCommand); then return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.copyOf(SurveyTemplateChangeCommand)"
  })
  void testCopyOf_thenReturnIssuanceRole() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand instance =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualCopyOfResult =
        ImmutableSurveyTemplateChangeCommand.copyOf(instance);

    // Assert
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyTemplateChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand2 =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplateChangeCommand, immutableSurveyTemplateChangeCommand2);
    assertEquals(
        immutableSurveyTemplateChangeCommand.hashCode(),
        immutableSurveyTemplateChangeCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}, and {@link
   * ImmutableSurveyTemplateChangeCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplateChangeCommand, immutableSurveyTemplateChangeCommand);
    int expectedHashCodeResult = immutableSurveyTemplateChangeCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyTemplateChangeCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateChangeCommand,
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateChangeCommand,
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Name")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateChangeCommand,
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("externalId")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateChangeCommand,
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplateChangeCommand,
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplateChangeCommand.equals(Object)",
    "int ImmutableSurveyTemplateChangeCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableSurveyTemplateChangeCommand");
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyTemplateChangeCommand.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);

    // Act
    ImmutableSurveyTemplateChangeCommand actualFromJsonResult =
        ImmutableSurveyTemplateChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) IssuanceRole is {@code Json}.
   *   <li>Then return issuanceRole is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) IssuanceRole is 'Json'; then return issuanceRole is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonIssuanceRoleIsJson_thenReturnIssuanceRoleIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole("Json");

    // Act
    ImmutableSurveyTemplateChangeCommand actualFromJsonResult =
        ImmutableSurveyTemplateChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.issuanceRole());
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);

    // Act
    ImmutableSurveyTemplateChangeCommand actualFromJsonResult =
        ImmutableSurveyTemplateChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);

    // Act
    ImmutableSurveyTemplateChangeCommand actualFromJsonResult =
        ImmutableSurveyTemplateChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of three.
   *   <li>When {@link Json} (default constructor) Id is of three.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of three; when Json (default constructor) Id is of three; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.fromJson(Json)"
  })
  void testFromJson_givenOfThree_whenJsonIdIsOfThree_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(3L);
    json.setId(id);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setTargetEntityKind(EntityKind.ALL);
    json.setIssuanceRole(null);

    // Act
    ImmutableSurveyTemplateChangeCommand actualFromJsonResult =
        ImmutableSurveyTemplateChangeCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.issuanceRole());
    assertEquals(EntityKind.ALL, actualFromJsonResult.targetEntityKind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#description()}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#issuanceRole()}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#name()}
   *   <li>{@link ImmutableSurveyTemplateChangeCommand#targetEntityKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyTemplateChangeCommand.description()",
    "String ImmutableSurveyTemplateChangeCommand.issuanceRole()",
    "String ImmutableSurveyTemplateChangeCommand.name()",
    "EntityKind ImmutableSurveyTemplateChangeCommand.targetEntityKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableSurveyTemplateChangeCommand.description();
    String actualIssuanceRoleResult = immutableSurveyTemplateChangeCommand.issuanceRole();
    String actualNameResult = immutableSurveyTemplateChangeCommand.name();

    // Assert
    assertEquals("Issuance Role", actualIssuanceRoleResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableSurveyTemplateChangeCommand.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyTemplateChangeCommand.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
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
   * Test Json {@link Json#issuanceRole()}.
   *
   * <p>Method under test: {@link Json#issuanceRole()}
   */
  @Test
  @DisplayName("Test Json issuanceRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.issuanceRole()"})
  void testJsonIssuanceRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().issuanceRole());
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
    assertNull(actualJson.issuanceRole);
    assertNull(actualJson.name);
    assertNull(actualJson.targetEntityKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#targetEntityKind()}.
   *
   * <p>Method under test: {@link Json#targetEntityKind()}
   */
  @Test
  @DisplayName("Test Json targetEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.targetEntityKind()"})
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyTemplateChangeCommand.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyTemplateChangeCommand{id=1, name=Name, externalId=42, targetEntityKind=ALL}",
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole(null)
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyTemplateChangeCommand.toString()"})
  void testToString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyTemplateChangeCommand{id=1, name=Name, externalId=42, targetEntityKind=ALL, issuanceRole=Issuance"
            + " Role}",
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithDescriptionResult =
        immutableSurveyTemplateChangeCommand.withDescription("42");

    // Assert
    assertEquals(immutableSurveyTemplateChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithDescriptionResult =
        immutableSurveyTemplateChangeCommand.withDescription("42");

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithExternalIdResult =
        immutableSurveyTemplateChangeCommand.withExternalId(optional);

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Issuance Role}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnIssuanceRole() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithExternalIdResult =
        immutableSurveyTemplateChangeCommand.withExternalId(optional);

    // Assert
    assertEquals("Issuance Role", actualWithExternalIdResult.issuanceRole());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithExternalIdResult =
        immutableSurveyTemplateChangeCommand.withExternalId("42");

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Issuance Role}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnIssuanceRole() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand actualWithExternalIdResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Issuance Role", actualWithExternalIdResult.issuanceRole());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithIdResult =
        immutableSurveyTemplateChangeCommand.withId(optional);

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Issuance Role}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnIssuanceRole() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithIdResult =
        immutableSurveyTemplateChangeCommand.withId(optional);

    // Assert
    assertEquals("Issuance Role", actualWithIdResult.issuanceRole());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithIdResult =
        immutableSurveyTemplateChangeCommand.withId(1L);

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Issuance Role}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnIssuanceRole() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand actualWithIdResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Issuance Role", actualWithIdResult.issuanceRole());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withIssuanceRole(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withIssuanceRole(String)}
   */
  @Test
  @DisplayName("Test withIssuanceRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withIssuanceRole(String)"
  })
  void testWithIssuanceRole() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("42")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithIssuanceRoleResult =
        immutableSurveyTemplateChangeCommand.withIssuanceRole("42");

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithIssuanceRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withIssuanceRole(String)}.
   *
   * <ul>
   *   <li>Then return issuanceRole is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withIssuanceRole(String)}
   */
  @Test
  @DisplayName("Test withIssuanceRole(String); then return issuanceRole is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withIssuanceRole(String)"
  })
  void testWithIssuanceRole_thenReturnIssuanceRoleIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand actualWithIssuanceRoleResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withIssuanceRole("42");

    // Assert
    assertEquals("42", actualWithIssuanceRoleResult.issuanceRole());
    assertEquals("Name", actualWithIssuanceRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIssuanceRoleResult.description());
    assertEquals(EntityKind.ALL, actualWithIssuanceRoleResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("42")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithNameResult =
        immutableSurveyTemplateChangeCommand.withName("42");

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplateChangeCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand actualWithNameResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Issuance Role", actualWithNameResult.issuanceRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.targetEntityKind());
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withTargetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyTemplateChangeCommand#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind() {
    // Arrange
    ImmutableSurveyTemplateChangeCommand immutableSurveyTemplateChangeCommand =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplateChangeCommand actualWithTargetEntityKindResult =
        immutableSurveyTemplateChangeCommand.withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyTemplateChangeCommand, actualWithTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplateChangeCommand#withTargetEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Issuance Role}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyTemplateChangeCommand#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind); then return 'Issuance Role'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplateChangeCommand ImmutableSurveyTemplateChangeCommand.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind_thenReturnIssuanceRole() {
    // Arrange and Act
    ImmutableSurveyTemplateChangeCommand actualWithTargetEntityKindResult =
        ImmutableSurveyTemplateChangeCommand.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .name("Name")
            .targetEntityKind(EntityKind.ACTOR)
            .build()
            .withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertEquals("Issuance Role", actualWithTargetEntityKindResult.issuanceRole());
    assertEquals("Name", actualWithTargetEntityKindResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithTargetEntityKindResult.description());
    assertEquals(EntityKind.ALL, actualWithTargetEntityKindResult.targetEntityKind());
  }
}
