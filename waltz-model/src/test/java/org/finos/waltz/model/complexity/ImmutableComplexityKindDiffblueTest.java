package org.finos.waltz.model.complexity;

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
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.complexity.ImmutableComplexityKind.Builder;
import org.finos.waltz.model.complexity.ImmutableComplexityKind.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityKindDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityKind Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableComplexityKind actualImmutableComplexityKind =
        actualIdResult.id(id).isDefault(true).kind(EntityKind.ALL).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableComplexityKind.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableComplexityKind.description());
    assertEquals(EntityKind.ALL, actualImmutableComplexityKind.kind());
    assertTrue(actualImmutableComplexityKind.isDefault());
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
    Builder builderResult = ImmutableComplexityKind.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityKind)} with {@code ComplexityKind}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityKind)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityKind) with 'ComplexityKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityKind)"})
  void testBuilderFromWithComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityKind)} with {@code ComplexityKind}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityKind)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityKind) with 'ComplexityKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityKind)"})
  void testBuilderFromWithComplexityKind2() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityKind)} with {@code ComplexityKind}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityKind)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityKind) with 'ComplexityKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityKind)"})
  void testBuilderFromWithComplexityKind3() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithEntityKindProvider2() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithEntityKindProvider3() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
  void testBuilderFromWithExternalIdProvider3() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableComplexityKind actualImmutableComplexityKind = builderResult.build();
    assertEquals(instance, actualImmutableComplexityKind);
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
    Builder builderResult = ImmutableComplexityKind.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
    Builder builderResult = ImmutableComplexityKind.builder();

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
    Builder builderResult = ImmutableComplexityKind.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isDefault(boolean)}.
   *
   * <p>Method under test: {@link Builder#isDefault(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isDefault(boolean)"})
  void testBuilderIsDefault() {
    // Arrange
    Builder builderResult = ImmutableComplexityKind.builder();

    // Act
    Builder actualIsDefaultResult = builderResult.isDefault(true);

    // Assert
    assertSame(builderResult, actualIsDefaultResult);
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
    Builder builderResult = ImmutableComplexityKind.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#copyOf(ComplexityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#copyOf(ComplexityKind)}
   */
  @Test
  @DisplayName("Test copyOf(ComplexityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.copyOf(ComplexityKind)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableComplexityKind instance =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualCopyOfResult = ImmutableComplexityKind.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}, and {@link
   * ImmutableComplexityKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityKind#equals(Object)}
   *   <li>{@link ImmutableComplexityKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableComplexityKind immutableComplexityKind2 =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableComplexityKind, immutableComplexityKind2);
    assertEquals(immutableComplexityKind.hashCode(), immutableComplexityKind2.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}, and {@link
   * ImmutableComplexityKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityKind#equals(Object)}
   *   <li>{@link ImmutableComplexityKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableComplexityKind, immutableComplexityKind);
    int expectedHashCodeResult = immutableComplexityKind.hashCode();
    assertEquals(expectedHashCodeResult, immutableComplexityKind.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityKind,
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityKind,
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityKind,
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityKind,
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("externalId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplexityKind,
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableComplexityKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityKind.equals(Object)",
    "int ImmutableComplexityKind.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Different type to ImmutableComplexityKind");
  }

  /**
   * Test {@link ImmutableComplexityKind#externalId()}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableComplexityKind.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
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
   *   <li>{@link ImmutableComplexityKind#description()}
   *   <li>{@link ImmutableComplexityKind#isDefault()}
   *   <li>{@link ImmutableComplexityKind#kind()}
   *   <li>{@link ImmutableComplexityKind#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableComplexityKind.description()",
    "boolean ImmutableComplexityKind.isDefault()",
    "EntityKind ImmutableComplexityKind.kind()",
    "String ImmutableComplexityKind.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    String actualDescriptionResult = immutableComplexityKind.description();
    boolean actualIsDefaultResult = immutableComplexityKind.isDefault();
    EntityKind actualKindResult = immutableComplexityKind.kind();

    // Assert
    assertEquals("Name", immutableComplexityKind.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualKindResult);
    assertTrue(actualIsDefaultResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#id()}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableComplexityKind.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
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
   * Test Json {@link Json#isDefault()}.
   *
   * <p>Method under test: {@link Json#isDefault()}
   */
  @Test
  @DisplayName("Test Json isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isDefault()"})
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isDefault());
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
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isDefault);
    assertFalse(actualJson.isDefaultIsSet);
  }

  /**
   * Test Json {@link Json#setIsDefault(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsDefault(boolean)"})
  void testJsonSetIsDefault() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsDefault(true);

    // Assert
    assertTrue(json.isDefault);
    assertTrue(json.isDefaultIsSet);
  }

  /**
   * Test {@link ImmutableComplexityKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableComplexityKind.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ComplexityKind{id=1, name=Name, externalId=42, isDefault=true, kind=ALL}",
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableComplexityKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualWithDescriptionResult =
        immutableComplexityKind.withDescription("42");

    // Assert
    assertEquals(immutableComplexityKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualWithDescriptionResult =
        immutableComplexityKind.withDescription("42");

    // Assert
    assertSame(immutableComplexityKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableComplexityKind actualWithExternalIdResult =
        immutableComplexityKind.withExternalId(optional);

    // Assert
    assertSame(immutableComplexityKind, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableComplexityKind actualWithExternalIdResult =
        immutableComplexityKind.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertTrue(actualWithExternalIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualWithExternalIdResult =
        immutableComplexityKind.withExternalId("42");

    // Assert
    assertSame(immutableComplexityKind, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableComplexityKind actualWithExternalIdResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertTrue(actualWithExternalIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableComplexityKind actualWithIdResult = immutableComplexityKind.withId(optional);

    // Assert
    assertSame(immutableComplexityKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableComplexityKind actualWithIdResult = immutableComplexityKind.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualWithIdResult = immutableComplexityKind.withId(1L);

    // Assert
    assertSame(immutableComplexityKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableComplexityKind actualWithIdResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#withIsDefault(boolean)}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test withIsDefault(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withIsDefault(boolean)"})
  void testWithIsDefault() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualWithIsDefaultResult = immutableComplexityKind.withIsDefault(true);

    // Assert
    assertSame(immutableComplexityKind, actualWithIsDefaultResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withIsDefault(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withIsDefault(boolean)}
   */
  @Test
  @DisplayName("Test withIsDefault(boolean); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withIsDefault(boolean)"})
  void testWithIsDefault_thenReturnName() {
    // Arrange and Act
    ImmutableComplexityKind actualWithIsDefaultResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withIsDefault(true);

    // Assert
    assertEquals("Name", actualWithIsDefaultResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsDefaultResult.description());
    assertEquals(EntityKind.ALL, actualWithIsDefaultResult.kind());
    assertTrue(actualWithIsDefaultResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableComplexityKind actualWithKindResult = immutableComplexityKind.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableComplexityKind, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withKind(EntityKind)"})
  void testWithKind_thenReturnName() {
    // Arrange and Act
    ImmutableComplexityKind actualWithKindResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertTrue(actualWithKindResult.isDefault());
  }

  /**
   * Test {@link ImmutableComplexityKind#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableComplexityKind immutableComplexityKind =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("42")
            .build();

    // Act
    ImmutableComplexityKind actualWithNameResult = immutableComplexityKind.withName("42");

    // Assert
    assertSame(immutableComplexityKind, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableComplexityKind#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityKind ImmutableComplexityKind.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableComplexityKind actualWithNameResult =
        ImmutableComplexityKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isDefault(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertTrue(actualWithNameResult.isDefault());
  }
}
