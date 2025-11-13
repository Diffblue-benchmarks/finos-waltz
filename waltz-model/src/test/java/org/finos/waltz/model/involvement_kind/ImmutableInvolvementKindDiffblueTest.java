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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind.Builder;
import org.finos.waltz.model.involvement_kind.ImmutableInvolvementKind.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindDiffblueTest {
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
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#permittedRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKind Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.permittedRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableInvolvementKind.lastUpdatedBy());
    assertEquals("Name", actualImmutableInvolvementKind.name());
    assertEquals("Permitted Role", actualImmutableInvolvementKind.permittedRole());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableInvolvementKind.description());
    assertEquals(EntityKind.ALL, actualImmutableInvolvementKind.kind());
    assertEquals(EntityKind.ALL, actualImmutableInvolvementKind.subjectKind());
    assertTrue(actualImmutableInvolvementKind.transitive());
    assertTrue(actualImmutableInvolvementKind.userSelectable());
    assertSame(lastUpdatedAt, actualImmutableInvolvementKind.lastUpdatedAt());
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
    Builder builderResult = ImmutableInvolvementKind.builder();
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
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKind)} with {@code InvolvementKind}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKind) with 'InvolvementKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKind)"})
  void testBuilderFromWithInvolvementKind() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKind)} with {@code InvolvementKind}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKind) with 'InvolvementKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKind)"})
  void testBuilderFromWithInvolvementKind2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
  }

  /**
   * Test Builder {@link Builder#from(InvolvementKind)} with {@code InvolvementKind}.
   *
   * <p>Method under test: {@link Builder#from(InvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder from(InvolvementKind) with 'InvolvementKind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(InvolvementKind)"})
  void testBuilderFromWithInvolvementKind3() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole(null)
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
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
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
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
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
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
    Builder builderResult = ImmutableInvolvementKind.builder();
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole(null)
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableInvolvementKind actualImmutableInvolvementKind =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvementKind);
    ImmutableInvolvementKind actualImmutableInvolvementKind2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvementKind2);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

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
    Builder builderResult = ImmutableInvolvementKind.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test Builder {@link Builder#transitive(boolean)}.
   *
   * <p>Method under test: {@link Builder#transitive(boolean)}
   */
  @Test
  @DisplayName("Test Builder transitive(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.transitive(boolean)"})
  void testBuilderTransitive() {
    // Arrange
    Builder builderResult = ImmutableInvolvementKind.builder();

    // Act
    Builder actualTransitiveResult = builderResult.transitive(true);

    // Assert
    assertSame(builderResult, actualTransitiveResult);
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
    Builder builderResult = ImmutableInvolvementKind.builder();

    // Act
    Builder actualUserSelectableResult = builderResult.userSelectable(true);

    // Assert
    assertSame(builderResult, actualUserSelectableResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  @DisplayName(
      "Test copyOf(InvolvementKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.copyOf(InvolvementKind)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableInvolvementKind instance =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}, and {@link
   * ImmutableInvolvementKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKind#equals(Object)}
   *   <li>{@link ImmutableInvolvementKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableInvolvementKind immutableInvolvementKind2 =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementKind, immutableInvolvementKind2);
    assertEquals(immutableInvolvementKind.hashCode(), immutableInvolvementKind2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}, and {@link
   * ImmutableInvolvementKind#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKind#equals(Object)}
   *   <li>{@link ImmutableInvolvementKind#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableInvolvementKind, immutableInvolvementKind);
    int expectedHashCodeResult = immutableInvolvementKind.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvementKind.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableInvolvementKind,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInvolvementKind#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvementKind.equals(Object)",
    "int ImmutableInvolvementKind.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableInvolvementKind");
  }

  /**
   * Test {@link ImmutableInvolvementKind#externalId()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableInvolvementKind.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvementKind#description()}
   *   <li>{@link ImmutableInvolvementKind#lastUpdatedBy()}
   *   <li>{@link ImmutableInvolvementKind#name()}
   *   <li>{@link ImmutableInvolvementKind#permittedRole()}
   *   <li>{@link ImmutableInvolvementKind#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableInvolvementKind.description()",
    "String ImmutableInvolvementKind.lastUpdatedBy()",
    "String ImmutableInvolvementKind.name()",
    "String ImmutableInvolvementKind.permittedRole()",
    "EntityKind ImmutableInvolvementKind.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    String actualDescriptionResult = immutableInvolvementKind.description();
    String actualLastUpdatedByResult = immutableInvolvementKind.lastUpdatedBy();
    String actualNameResult = immutableInvolvementKind.name();
    String actualPermittedRoleResult = immutableInvolvementKind.permittedRole();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Permitted Role", actualPermittedRoleResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableInvolvementKind.subjectKind());
  }

  /**
   * Test {@link ImmutableInvolvementKind#id()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableInvolvementKind.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
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
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
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
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.permittedRole);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.transitive);
    assertFalse(actualJson.transitiveIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
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
   * Test Json {@link Json#setTransitive(boolean)}.
   *
   * <p>Method under test: {@link Json#setTransitive(boolean)}
   */
  @Test
  @DisplayName("Test Json setTransitive(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setTransitive(boolean)"})
  void testJsonSetTransitive() {
    // Arrange
    Json json = new Json();

    // Act
    json.setTransitive(true);

    // Assert
    assertTrue(json.transitive);
    assertTrue(json.transitiveIsSet);
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
   * Test Json {@link Json#transitive()}.
   *
   * <p>Method under test: {@link Json#transitive()}
   */
  @Test
  @DisplayName("Test Json transitive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.transitive()"})
  void testJsonTransitive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().transitive());
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
   * Test {@link ImmutableInvolvementKind#kind()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableInvolvementKind.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableInvolvementKind#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableInvolvementKind.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableInvolvementKind.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "InvolvementKind{id=1, name=Name, externalId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy"
            + "=2020-03-01, kind=ALL, subjectKind=ALL, userSelectable=true, permittedRole=Permitted Role,"
            + " transitive=true}",
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableInvolvementKind#toString()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableInvolvementKind.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "InvolvementKind{id=1, name=Name, externalId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " kind=ALL, subjectKind=ALL, userSelectable=true, transitive=true}",
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole(null)
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableInvolvementKind#transitive()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#transitive()}
   */
  @Test
  @DisplayName("Test transitive()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableInvolvementKind.transitive()"})
  void testTransitive() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .transitive());
  }

  /**
   * Test {@link ImmutableInvolvementKind#userSelectable()}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#userSelectable()}
   */
  @Test
  @DisplayName("Test userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableInvolvementKind.userSelectable()"})
  void testUserSelectable() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .userSelectable());
  }

  /**
   * Test {@link ImmutableInvolvementKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithDescriptionResult =
        immutableInvolvementKind.withDescription("42");

    // Assert
    assertEquals(immutableInvolvementKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithDescriptionResult =
        immutableInvolvementKind.withDescription("42");

    // Assert
    assertSame(immutableInvolvementKind, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableInvolvementKind actualWithExternalIdResult =
        immutableInvolvementKind.withExternalId(optional);

    // Assert
    assertSame(immutableInvolvementKind, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableInvolvementKind actualWithExternalIdResult =
        immutableInvolvementKind.withExternalId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Permitted Role", actualWithExternalIdResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertTrue(actualWithExternalIdResult.transitive());
    assertTrue(actualWithExternalIdResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithExternalIdResult =
        immutableInvolvementKind.withExternalId("42");

    // Assert
    assertSame(immutableInvolvementKind, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withExternalId(String)"})
  void testWithExternalIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithExternalIdResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Permitted Role", actualWithExternalIdResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertTrue(actualWithExternalIdResult.transitive());
    assertTrue(actualWithExternalIdResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableInvolvementKind actualWithIdResult = immutableInvolvementKind.withId(optional);

    // Assert
    assertSame(immutableInvolvementKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableInvolvementKind actualWithIdResult = immutableInvolvementKind.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Permitted Role", actualWithIdResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.subjectKind());
    assertTrue(actualWithIdResult.transitive());
    assertTrue(actualWithIdResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithIdResult = immutableInvolvementKind.withId(1L);

    // Assert
    assertSame(immutableInvolvementKind, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withId(long)"})
  void testWithIdWithValue_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithIdResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Permitted Role", actualWithIdResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityKind.ALL, actualWithIdResult.subjectKind());
    assertTrue(actualWithIdResult.transitive());
    assertTrue(actualWithIdResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithKindResult =
        immutableInvolvementKind.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableInvolvementKind, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withKind(EntityKind)"})
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithKindResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Permitted Role", actualWithKindResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityKind.ALL, actualWithKindResult.subjectKind());
    assertTrue(actualWithKindResult.transitive());
    assertTrue(actualWithKindResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKind ImmutableInvolvementKind.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithLastUpdatedAtResult =
        immutableInvolvementKind.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableInvolvementKind, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithLastUpdatedByResult =
        immutableInvolvementKind.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableInvolvementKind, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withLastUpdatedBy(String)"})
  void testWithLastUpdatedBy_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithLastUpdatedByResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Permitted Role", actualWithLastUpdatedByResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.subjectKind());
    assertTrue(actualWithLastUpdatedByResult.transitive());
    assertTrue(actualWithLastUpdatedByResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithNameResult = immutableInvolvementKind.withName("42");

    // Assert
    assertSame(immutableInvolvementKind, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withName(String)"})
  void testWithName_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithNameResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Permitted Role", actualWithNameResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(EntityKind.ALL, actualWithNameResult.subjectKind());
    assertTrue(actualWithNameResult.transitive());
    assertTrue(actualWithNameResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withPermittedRole(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withPermittedRole(String)}
   */
  @Test
  @DisplayName("Test withPermittedRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withPermittedRole(String)"})
  void testWithPermittedRole() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("42")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithPermittedRoleResult =
        immutableInvolvementKind.withPermittedRole("42");

    // Assert
    assertSame(immutableInvolvementKind, actualWithPermittedRoleResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withPermittedRole(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withPermittedRole(String)}
   */
  @Test
  @DisplayName(
      "Test withPermittedRole(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withPermittedRole(String)"})
  void testWithPermittedRole_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithPermittedRoleResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withPermittedRole("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithPermittedRoleResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithPermittedRoleResult.lastUpdatedBy());
    assertEquals("42", actualWithPermittedRoleResult.permittedRole());
    assertEquals("Name", actualWithPermittedRoleResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPermittedRoleResult.description());
    assertEquals(EntityKind.ALL, actualWithPermittedRoleResult.kind());
    assertEquals(EntityKind.ALL, actualWithPermittedRoleResult.subjectKind());
    assertTrue(actualWithPermittedRoleResult.transitive());
    assertTrue(actualWithPermittedRoleResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKind ImmutableInvolvementKind.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithSubjectKindResult =
        immutableInvolvementKind.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableInvolvementKind, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withSubjectKind(EntityKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKind ImmutableInvolvementKind.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithSubjectKindResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithSubjectKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithSubjectKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithSubjectKindResult.name());
    assertEquals("Permitted Role", actualWithSubjectKindResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithSubjectKindResult.description());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.kind());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertTrue(actualWithSubjectKindResult.transitive());
    assertTrue(actualWithSubjectKindResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withTransitive(boolean)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withTransitive(boolean)}
   */
  @Test
  @DisplayName("Test withTransitive(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withTransitive(boolean)"})
  void testWithTransitive() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithTransitiveResult =
        immutableInvolvementKind.withTransitive(true);

    // Assert
    assertSame(immutableInvolvementKind, actualWithTransitiveResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withTransitive(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withTransitive(boolean)}
   */
  @Test
  @DisplayName(
      "Test withTransitive(boolean); when 'false'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvementKind ImmutableInvolvementKind.withTransitive(boolean)"})
  void testWithTransitive_whenFalse_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithTransitiveResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withTransitive(false);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithTransitiveResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithTransitiveResult.lastUpdatedBy());
    assertEquals("Name", actualWithTransitiveResult.name());
    assertEquals("Permitted Role", actualWithTransitiveResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something", actualWithTransitiveResult.description());
    assertEquals(EntityKind.ALL, actualWithTransitiveResult.kind());
    assertEquals(EntityKind.ALL, actualWithTransitiveResult.subjectKind());
    assertFalse(actualWithTransitiveResult.transitive());
    assertTrue(actualWithTransitiveResult.userSelectable());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withUserSelectable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKind ImmutableInvolvementKind.withUserSelectable(boolean)"
  })
  void testWithUserSelectable() {
    // Arrange
    ImmutableInvolvementKind immutableInvolvementKind =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableInvolvementKind actualWithUserSelectableResult =
        immutableInvolvementKind.withUserSelectable(true);

    // Assert
    assertSame(immutableInvolvementKind, actualWithUserSelectableResult);
  }

  /**
   * Test {@link ImmutableInvolvementKind#withUserSelectable(boolean)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvementKind#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName(
      "Test withUserSelectable(boolean); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvementKind ImmutableInvolvementKind.withUserSelectable(boolean)"
  })
  void testWithUserSelectable_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableInvolvementKind actualWithUserSelectableResult =
        ImmutableInvolvementKind.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .subjectKind(EntityKind.ALL)
            .build()
            .withUserSelectable(false);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithUserSelectableResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithUserSelectableResult.lastUpdatedBy());
    assertEquals("Name", actualWithUserSelectableResult.name());
    assertEquals("Permitted Role", actualWithUserSelectableResult.permittedRole());
    assertEquals(
        "The characteristics of someone or something",
        actualWithUserSelectableResult.description());
    assertEquals(EntityKind.ALL, actualWithUserSelectableResult.kind());
    assertEquals(EntityKind.ALL, actualWithUserSelectableResult.subjectKind());
    assertFalse(actualWithUserSelectableResult.userSelectable());
    assertTrue(actualWithUserSelectableResult.transitive());
    assertSame(ofResult, toLocalDateResult);
  }
}
