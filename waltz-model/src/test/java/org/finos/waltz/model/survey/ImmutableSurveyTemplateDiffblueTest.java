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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.survey.ImmutableSurveyTemplate.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyTemplate.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#issuanceRole(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#status(ReleaseLifecycleStatus)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplate Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.issuanceRole(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.status(ReleaseLifecycleStatus)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    Builder actualExternalIdResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(createdAt)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        actualIdResult
            .id(id)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("Issuance Role", actualImmutableSurveyTemplate.issuanceRole());
    assertEquals("Name", actualImmutableSurveyTemplate.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableSurveyTemplate.description());
    assertEquals(1L, actualImmutableSurveyTemplate.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualImmutableSurveyTemplate.kind());
    assertEquals(EntityKind.ALL, actualImmutableSurveyTemplate.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualImmutableSurveyTemplate.status());
    assertSame(createdAt, actualImmutableSurveyTemplate.createdAt());
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
    Builder builderResult = ImmutableSurveyTemplate.builder();
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
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

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
    Builder builderResult = ImmutableSurveyTemplate.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

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
    Builder builderResult = ImmutableSurveyTemplate.builder();

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
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

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
    Builder builderResult = ImmutableSurveyTemplate.builder();

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
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
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
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description(null)
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
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
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole(null)
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplate)} with {@code SurveyTemplate}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplate)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplate) with 'SurveyTemplate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplate)"})
  void testBuilderFromWithSurveyTemplate() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplate)} with {@code SurveyTemplate}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplate)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplate) with 'SurveyTemplate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplate)"})
  void testBuilderFromWithSurveyTemplate2() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description(null)
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
  }

  /**
   * Test Builder {@link Builder#from(SurveyTemplate)} with {@code SurveyTemplate}.
   *
   * <p>Method under test: {@link Builder#from(SurveyTemplate)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyTemplate) with 'SurveyTemplate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyTemplate)"})
  void testBuilderFromWithSurveyTemplate3() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole(null)
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableSurveyTemplate actualImmutableSurveyTemplate = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyTemplate);
    ImmutableSurveyTemplate actualImmutableSurveyTemplate2 = builderResult.build();
    assertEquals(instance, actualImmutableSurveyTemplate2);
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
    Builder builderResult = ImmutableSurveyTemplate.builder();

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
    Builder builderResult = ImmutableSurveyTemplate.builder();
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
    Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ownerId(Long)}.
   *
   * <p>Method under test: {@link Builder#ownerId(Long)}
   */
  @Test
  @DisplayName("Test Builder ownerId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ownerId(Long)"})
  void testBuilderOwnerId() {
    // Arrange
    Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act
    Builder actualOwnerIdResult = builderResult.ownerId(1L);

    // Assert
    assertSame(builderResult, actualOwnerIdResult);
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
    Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act
    Builder actualTargetEntityKindResult = builderResult.targetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyTemplate); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.copyOf(SurveyTemplate)"})
  void testCopyOf_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableSurveyTemplate instance =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualCopyOfResult = ImmutableSurveyTemplate.copyOf(instance);

    // Assert
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableSurveyTemplate.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualCreatedAtResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}, and {@link
   * ImmutableSurveyTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplate#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    ImmutableSurveyTemplate immutableSurveyTemplate2 =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplate, immutableSurveyTemplate2);
    assertEquals(immutableSurveyTemplate.hashCode(), immutableSurveyTemplate2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}, and {@link
   * ImmutableSurveyTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyTemplate#equals(Object)}
   *   <li>{@link ImmutableSurveyTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyTemplate, immutableSurveyTemplate);
    int expectedHashCodeResult = immutableSurveyTemplate.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyTemplate.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Name")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ACTOR)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("createdAt")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(2L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.ACTIVE)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyTemplate,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyTemplate.equals(Object)",
    "int ImmutableSurveyTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableSurveyTemplate");
  }

  /**
   * Test {@link ImmutableSurveyTemplate#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyTemplate.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
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
   *   <li>{@link ImmutableSurveyTemplate#description()}
   *   <li>{@link ImmutableSurveyTemplate#issuanceRole()}
   *   <li>{@link ImmutableSurveyTemplate#name()}
   *   <li>{@link ImmutableSurveyTemplate#ownerId()}
   *   <li>{@link ImmutableSurveyTemplate#targetEntityKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyTemplate.description()",
    "String ImmutableSurveyTemplate.issuanceRole()",
    "String ImmutableSurveyTemplate.name()",
    "Long ImmutableSurveyTemplate.ownerId()",
    "EntityKind ImmutableSurveyTemplate.targetEntityKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableSurveyTemplate.description();
    String actualIssuanceRoleResult = immutableSurveyTemplate.issuanceRole();
    String actualNameResult = immutableSurveyTemplate.name();
    Long actualOwnerIdResult = immutableSurveyTemplate.ownerId();
    EntityKind actualTargetEntityKindResult = immutableSurveyTemplate.targetEntityKind();

    // Assert
    assertEquals("Issuance Role", actualIssuanceRoleResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualOwnerIdResult.longValue());
    assertEquals(EntityKind.ALL, actualTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#id()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyTemplate.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
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
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
    assertNull(actualJson.ownerId);
    assertNull(actualJson.description);
    assertNull(actualJson.issuanceRole);
    assertNull(actualJson.name);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#ownerId()}.
   *
   * <p>Method under test: {@link Json#ownerId()}
   */
  @Test
  @DisplayName("Test Json ownerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.ownerId()"})
  void testJsonOwnerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ownerId());
  }

  /**
   * Test Json {@link Json#status()}.
   *
   * <p>Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().status());
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
   * Test {@link ImmutableSurveyTemplate#kind()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableSurveyTemplate.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#status()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#status()}
   */
  @Test
  @DisplayName("Test status()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReleaseLifecycleStatus ImmutableSurveyTemplate.status()"})
  void testStatus() {
    // Arrange, Act and Assert
    assertEquals(
        ReleaseLifecycleStatus.DRAFT,
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .status());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyTemplate.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyTemplate{id=1, name=Name, externalId=42, targetEntityKind=ALL, ownerId=1, createdAt=1970-01-01T00:00,"
            + " status=DRAFT, kind=ALL, issuanceRole=Issuance Role}",
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyTemplate.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "SurveyTemplate{id=1, name=Name, externalId=42, targetEntityKind=ALL, ownerId=1, createdAt=1970-01-01T00:00,"
            + " status=DRAFT, kind=ALL}",
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole(null)
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplate ImmutableSurveyTemplate.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithCreatedAtResult =
        immutableSurveyTemplate.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSurveyTemplate, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithDescriptionResult =
        immutableSurveyTemplate.withDescription("42");

    // Assert
    assertEquals(immutableSurveyTemplate, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("42")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithDescriptionResult =
        immutableSurveyTemplate.withDescription("42");

    // Assert
    assertSame(immutableSurveyTemplate, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyTemplate actualWithExternalIdResult =
        immutableSurveyTemplate.withExternalId(optional);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSurveyTemplate actualWithExternalIdResult =
        immutableSurveyTemplate.withExternalId(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithExternalIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithExternalIdResult.issuanceRole());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithExternalIdResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithExternalIdResult =
        immutableSurveyTemplate.withExternalId("42");

    // Assert
    assertSame(immutableSurveyTemplate, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithExternalIdResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime createdAtResult = actualWithExternalIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithExternalIdResult.issuanceRole());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithExternalIdResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyTemplate actualWithIdResult = immutableSurveyTemplate.withId(optional);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withId(Optional)"})
  void testWithIdWithOptional_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSurveyTemplate actualWithIdResult = immutableSurveyTemplate.withId(optional);

    // Assert
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithIdResult.issuanceRole());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithIdResult = immutableSurveyTemplate.withId(1L);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithIdResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime createdAtResult = actualWithIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithIdResult.issuanceRole());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIdResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withIssuanceRole(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withIssuanceRole(String)}
   */
  @Test
  @DisplayName("Test withIssuanceRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withIssuanceRole(String)"})
  void testWithIssuanceRole() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("42")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithIssuanceRoleResult =
        immutableSurveyTemplate.withIssuanceRole("42");

    // Assert
    assertSame(immutableSurveyTemplate, actualWithIssuanceRoleResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withIssuanceRole(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withIssuanceRole(String)}
   */
  @Test
  @DisplayName(
      "Test withIssuanceRole(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withIssuanceRole(String)"})
  void testWithIssuanceRole_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithIssuanceRoleResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withIssuanceRole("42");

    // Assert
    LocalDateTime createdAtResult = actualWithIssuanceRoleResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithIssuanceRoleResult.issuanceRole());
    assertEquals("Name", actualWithIssuanceRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIssuanceRoleResult.description());
    assertEquals(1L, actualWithIssuanceRoleResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithIssuanceRoleResult.kind());
    assertEquals(EntityKind.ALL, actualWithIssuanceRoleResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithIssuanceRoleResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithKindResult = immutableSurveyTemplate.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withKind(EntityKind)"})
  void testWithKind_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithKindResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ACTOR)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime createdAtResult = actualWithKindResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithKindResult.issuanceRole());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityKind.ALL, actualWithKindResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithKindResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("42")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithNameResult = immutableSurveyTemplate.withName("42");

    // Assert
    assertSame(immutableSurveyTemplate, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withName(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withName(String)"})
  void testWithName_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithNameResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    LocalDateTime createdAtResult = actualWithNameResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Issuance Role", actualWithNameResult.issuanceRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityKind.ALL, actualWithNameResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithNameResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withOwnerId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withOwnerId(Long)}
   */
  @Test
  @DisplayName("Test withOwnerId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withOwnerId(Long)"})
  void testWithOwnerId() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithOwnerIdResult = immutableSurveyTemplate.withOwnerId(1L);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithOwnerIdResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withOwnerId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withOwnerId(Long)}
   */
  @Test
  @DisplayName(
      "Test withOwnerId(Long); when forty-two; then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyTemplate ImmutableSurveyTemplate.withOwnerId(Long)"})
  void testWithOwnerId_whenFortyTwo_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithOwnerIdResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withOwnerId(42L);

    // Assert
    LocalDateTime createdAtResult = actualWithOwnerIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithOwnerIdResult.issuanceRole());
    assertEquals("Name", actualWithOwnerIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithOwnerIdResult.description());
    assertEquals(42L, actualWithOwnerIdResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithOwnerIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithOwnerIdResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithOwnerIdResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withStatus(ReleaseLifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withStatus(ReleaseLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplate ImmutableSurveyTemplate.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithStatusResult =
        immutableSurveyTemplate.withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithStatusResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withStatus(ReleaseLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withStatus(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withStatus(ReleaseLifecycleStatus); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplate ImmutableSurveyTemplate.withStatus(ReleaseLifecycleStatus)"
  })
  void testWithStatus_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithStatusResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.ACTIVE)
            .targetEntityKind(EntityKind.ALL)
            .build()
            .withStatus(ReleaseLifecycleStatus.DRAFT);

    // Assert
    LocalDateTime createdAtResult = actualWithStatusResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithStatusResult.issuanceRole());
    assertEquals("Name", actualWithStatusResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithStatusResult.description());
    assertEquals(1L, actualWithStatusResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithStatusResult.kind());
    assertEquals(EntityKind.ALL, actualWithStatusResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithStatusResult.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withTargetEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withTargetEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplate ImmutableSurveyTemplate.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind() {
    // Arrange
    ImmutableSurveyTemplate immutableSurveyTemplate =
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableSurveyTemplate actualWithTargetEntityKindResult =
        immutableSurveyTemplate.withTargetEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSurveyTemplate, actualWithTargetEntityKindResult);
  }

  /**
   * Test {@link ImmutableSurveyTemplate#withTargetEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyTemplate#withTargetEntityKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withTargetEntityKind(EntityKind); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyTemplate ImmutableSurveyTemplate.withTargetEntityKind(EntityKind)"
  })
  void testWithTargetEntityKind_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSurveyTemplate actualWithTargetEntityKindResult =
        ImmutableSurveyTemplate.builder()
            .createdAt(ofResult.atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ACTOR)
            .build()
            .withTargetEntityKind(EntityKind.ALL);

    // Assert
    LocalDateTime createdAtResult = actualWithTargetEntityKindResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualWithTargetEntityKindResult.issuanceRole());
    assertEquals("Name", actualWithTargetEntityKindResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithTargetEntityKindResult.description());
    assertEquals(1L, actualWithTargetEntityKindResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualWithTargetEntityKindResult.kind());
    assertEquals(EntityKind.ALL, actualWithTargetEntityKindResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualWithTargetEntityKindResult.status());
    assertSame(ofResult, toLocalDateResult);
  }
}
