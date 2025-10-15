package org.finos.waltz.model.software_catalog;

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
import java.util.Optional;
import org.finos.waltz.model.CreatedUserTimestampProvider;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareVersion.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareVersion.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwareVersionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#created(UserTimestamp)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#name(String)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareVersion Builder.build()",
    "Builder Builder.created(UserTimestamp)",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.name(String)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    Builder actualCreatedResult = actualBuilderResult.created(created);
    Builder actualExternalIdResult =
        actualCreatedResult
            .created(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableSoftwareVersion.version());
    LocalDate releaseDateResult = actualImmutableSoftwareVersion.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualImmutableSoftwareVersion.name());
    assertEquals("Provenance", actualImmutableSoftwareVersion.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSoftwareVersion.description());
    assertEquals(1L, actualImmutableSoftwareVersion.softwarePackageId());
    assertEquals(EntityKind.ALL, actualImmutableSoftwareVersion.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test Builder {@link Builder#created(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#created(Optional)}
   */
  @Test
  @DisplayName("Test Builder created(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.created(Optional)"})
  void testBuilderCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualCreatedResult = builderResult.created(created);

    // Assert
    assertSame(builderResult, actualCreatedResult);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((CreatedUserTimestampProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(instance.created()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.created()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).created();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedUserTimestampProvider)} with {@code
   * CreatedUserTimestampProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    CreatedUserTimestampProvider instance = mock(CreatedUserTimestampProvider.class);
    when(instance.created()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).created();
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                builderResult2
                    .created(created)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .group("Group")
                    .id(1L)
                    .isNotable(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .vendor("Vendor")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description("The characteristics of someone or something")
                    .diagramKind(OverlayDiagramKind.WALTZ_ENTITY_OVERLAY)
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .provenance("Provenance")
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                builderResult2
                    .created(created)
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .group("Group")
                    .id(1L)
                    .isNotable(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .vendor("Vendor")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                builderResult2
                    .created(created)
                    .description(null)
                    .externalId("42")
                    .group("Group")
                    .id(1L)
                    .isNotable(true)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .vendor("Vendor")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableSoftwareUsage.builder()
                .applicationId(1L)
                .licenceId(1L)
                .provenance("Provenance")
                .softwarePackageId(1L)
                .softwareVersionId(1L)
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    ImmutableSoftwareVersion actualImmutableSoftwareVersion2 = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion2);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareVersion)} with {@code SoftwareVersion}.
   *
   * <p>Method under test: {@link Builder#from(SoftwareVersion)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareVersion) with 'SoftwareVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareVersion)"})
  void testBuilderFromWithSoftwareVersion() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareVersion)} with {@code SoftwareVersion}.
   *
   * <p>Method under test: {@link Builder#from(SoftwareVersion)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareVersion) with 'SoftwareVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareVersion)"})
  void testBuilderFromWithSoftwareVersion2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwareVersion)} with {@code SoftwareVersion}.
   *
   * <p>Method under test: {@link Builder#from(SoftwareVersion)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwareVersion) with 'SoftwareVersion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwareVersion)"})
  void testBuilderFromWithSoftwareVersion3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion instance =
        builderResult2
            .created(created)
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwareVersion actualImmutableSoftwareVersion = builderResult.build();
    assertEquals(instance, actualImmutableSoftwareVersion);
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
    Builder builderResult = ImmutableSoftwareVersion.builder();

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
    Builder builderResult = ImmutableSoftwareVersion.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#releaseDate(LocalDate)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#releaseDate(LocalDate)}
   */
  @Test
  @DisplayName(
      "Test Builder releaseDate(LocalDate); when LocalDate with '1970' and one and one; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.releaseDate(LocalDate)"})
  void testBuilderReleaseDate_whenLocalDateWith1970AndOneAndOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act
    Builder actualReleaseDateResult = builderResult.releaseDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualReleaseDateResult);
  }

  /**
   * Test Builder {@link Builder#softwarePackageId(long)}.
   *
   * <p>Method under test: {@link Builder#softwarePackageId(long)}
   */
  @Test
  @DisplayName("Test Builder softwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.softwarePackageId(long)"})
  void testBuilderSoftwarePackageId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act
    Builder actualSoftwarePackageIdResult = builderResult.softwarePackageId(1L);

    // Assert
    assertSame(builderResult, actualSoftwarePackageIdResult);
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();

    // Act
    Builder actualVersionResult = builderResult.version("1.0.2");

    // Assert
    assertSame(builderResult, actualVersionResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#copyOf(SoftwareVersion)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwareVersion); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.copyOf(SoftwareVersion)"})
  void testCopyOf_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);
    ImmutableSoftwareVersion instance =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualCopyOfResult = ImmutableSoftwareVersion.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.version());
    LocalDate releaseDateResult = actualCopyOfResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#created()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#created()}
   */
  @Test
  @DisplayName("Test created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwareVersion.created()"})
  void testCreated() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        created,
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .created());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}, and {@link
   * ImmutableSoftwareVersion#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareVersion#equals(Object)}
   *   <li>{@link ImmutableSoftwareVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    ImmutableSoftwareVersion immutableSoftwareVersion2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableSoftwareVersion, immutableSoftwareVersion2);
    assertEquals(immutableSoftwareVersion.hashCode(), immutableSoftwareVersion2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}, and {@link
   * ImmutableSoftwareVersion#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwareVersion#equals(Object)}
   *   <li>{@link ImmutableSoftwareVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableSoftwareVersion, immutableSoftwareVersion);
    int expectedHashCodeResult = immutableSoftwareVersion.hashCode();
    assertEquals(expectedHashCodeResult, immutableSoftwareVersion.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("Provenance")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Provenance")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("By")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.now())
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(2L)
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("Provenance")
            .build();

    Builder builderResult2 = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwareVersion,
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertNotEquals(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwareVersion.equals(Object)",
    "int ImmutableSoftwareVersion.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertNotEquals(
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build(),
        "Different type to ImmutableSoftwareVersion");
  }

  /**
   * Test {@link ImmutableSoftwareVersion#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwareVersion.externalId()"})
  void testExternalId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    Optional<String> actualExternalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
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
   *   <li>{@link ImmutableSoftwareVersion#description()}
   *   <li>{@link ImmutableSoftwareVersion#releaseDate()}
   *   <li>{@link ImmutableSoftwareVersion#softwarePackageId()}
   *   <li>{@link ImmutableSoftwareVersion#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSoftwareVersion.description()",
    "LocalDate ImmutableSoftwareVersion.releaseDate()",
    "long ImmutableSoftwareVersion.softwarePackageId()",
    "String ImmutableSoftwareVersion.version()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    String actualDescriptionResult = immutableSoftwareVersion.description();
    LocalDate actualReleaseDateResult = immutableSoftwareVersion.releaseDate();
    long actualSoftwarePackageIdResult = immutableSoftwareVersion.softwarePackageId();

    // Assert
    assertEquals("1.0.2", immutableSoftwareVersion.version());
    assertEquals("1970-01-01", actualReleaseDateResult.toString());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualSoftwarePackageIdResult);
    assertSame(releaseDate, actualReleaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#id()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwareVersion.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    Optional<Long> actualIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#created()}.
   *
   * <p>Method under test: {@link Json#created()}
   */
  @Test
  @DisplayName("Test Json created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.created()"})
  void testJsonCreated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().created());
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
    assertNull(actualJson.provenance);
    assertNull(actualJson.version);
    assertNull(actualJson.releaseDate);
    assertNull(actualJson.kind);
    assertEquals(0L, actualJson.softwarePackageId);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.softwarePackageIdIsSet);
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#releaseDate()}.
   *
   * <p>Method under test: {@link Json#releaseDate()}
   */
  @Test
  @DisplayName("Test Json releaseDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.releaseDate()"})
  void testJsonReleaseDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().releaseDate());
  }

  /**
   * Test Json {@link Json#setSoftwarePackageId(long)}.
   *
   * <p>Method under test: {@link Json#setSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test Json setSoftwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSoftwarePackageId(long)"})
  void testJsonSetSoftwarePackageId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSoftwarePackageId(1L);

    // Assert
    assertEquals(1L, json.softwarePackageId);
    assertTrue(json.softwarePackageIdIsSet);
  }

  /**
   * Test Json {@link Json#softwarePackageId()}.
   *
   * <p>Method under test: {@link Json#softwarePackageId()}
   */
  @Test
  @DisplayName("Test Json softwarePackageId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.softwarePackageId()"})
  void testJsonSoftwarePackageId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().softwarePackageId());
  }

  /**
   * Test Json {@link Json#version()}.
   *
   * <p>Method under test: {@link Json#version()}
   */
  @Test
  @DisplayName("Test Json version()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.version()"})
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().version());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#kind()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableSoftwareVersion.kind()"})
  void testKind() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#name()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwareVersion.name()"})
  void testName() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "Name",
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .name());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#provenance()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwareVersion.provenance()"})
  void testProvenance() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "Provenance",
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwareVersion.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwareVersion{id=1, externalId=42, provenance=Provenance, created=UserTimestamp{at=1970-01-01T00:00,"
            + " by=By, atTimestamp=1970-01-01 00:00:00.0}, softwarePackageId=1, version=1.0.2, releaseDate=1970-01-01,"
            + " name=Name, kind=ALL}",
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwareVersion.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act and Assert
    assertEquals(
        "SoftwareVersion{id=1, externalId=42, provenance=Provenance, softwarePackageId=1, version=1.0.2,"
            + " releaseDate=1970-01-01, name=Name, kind=ALL}",
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withCreated(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withCreated(Optional)}
   */
  @Test
  @DisplayName("Test withCreated(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withCreated(Optional)"})
  void testWithCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> optional = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableSoftwareVersion actualWithCreatedResult =
        immutableSoftwareVersion.withCreated(optional);

    // Assert
    assertEquals(immutableSoftwareVersion, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withCreated(UserTimestamp)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withCreated(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withCreated(UserTimestamp) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareVersion ImmutableSoftwareVersion.withCreated(UserTimestamp)"
  })
  void testWithCreatedWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithCreatedResult =
        immutableSoftwareVersion.withCreated(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableSoftwareVersion, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithDescriptionResult =
        immutableSoftwareVersion.withDescription("42");

    // Assert
    assertEquals(immutableSoftwareVersion, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithDescriptionResult =
        immutableSoftwareVersion.withDescription("42");

    // Assert
    assertSame(immutableSoftwareVersion, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSoftwareVersion actualWithExternalIdResult =
        immutableSoftwareVersion.withExternalId(optional);

    // Assert
    assertSame(immutableSoftwareVersion, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSoftwareVersion actualWithExternalIdResult =
        immutableSoftwareVersion.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.version());
    LocalDate releaseDateResult = actualWithExternalIdResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithExternalIdResult =
        immutableSoftwareVersion.withExternalId("42");

    // Assert
    assertSame(immutableSoftwareVersion, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithExternalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.version());
    LocalDate releaseDateResult = actualWithExternalIdResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1L, actualWithExternalIdResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSoftwareVersion actualWithIdResult = immutableSoftwareVersion.withId(optional);

    // Assert
    assertSame(immutableSoftwareVersion, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withId(Optional)"})
  void testWithIdWithOptional_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSoftwareVersion actualWithIdResult = immutableSoftwareVersion.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.version());
    LocalDate releaseDateResult = actualWithIdResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithIdResult = immutableSoftwareVersion.withId(1L);

    // Assert
    assertSame(immutableSoftwareVersion, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.version());
    LocalDate releaseDateResult = actualWithIdResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1L, actualWithIdResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithKindResult =
        immutableSoftwareVersion.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSoftwareVersion, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withKind(EntityKind)"})
  void testWithKind_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithKindResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.version());
    LocalDate releaseDateResult = actualWithKindResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withName(String)"})
  void testWithName() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithNameResult = immutableSoftwareVersion.withName("42");

    // Assert
    assertSame(immutableSoftwareVersion, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withName(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withName(String)"})
  void testWithName_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithNameResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withName("42");

    // Assert
    assertEquals("1.0.2", actualWithNameResult.version());
    LocalDate releaseDateResult = actualWithNameResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1L, actualWithNameResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("42")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithProvenanceResult =
        immutableSoftwareVersion.withProvenance("42");

    // Assert
    assertSame(immutableSoftwareVersion, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withProvenance(String)"})
  void testWithProvenance_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithProvenanceResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.version());
    LocalDate releaseDateResult = actualWithProvenanceResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(1L, actualWithProvenanceResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withReleaseDate(LocalDate)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withReleaseDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withReleaseDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareVersion ImmutableSoftwareVersion.withReleaseDate(LocalDate)"
  })
  void testWithReleaseDate() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithReleaseDateResult =
        immutableSoftwareVersion.withReleaseDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSoftwareVersion, actualWithReleaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withSoftwarePackageId(long)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test withSoftwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareVersion ImmutableSoftwareVersion.withSoftwarePackageId(long)"
  })
  void testWithSoftwarePackageId() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(42L)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithSoftwarePackageIdResult =
        immutableSoftwareVersion.withSoftwarePackageId(42L);

    // Assert
    assertSame(immutableSoftwareVersion, actualWithSoftwarePackageIdResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withSoftwarePackageId(long)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withSoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test withSoftwarePackageId(long); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwareVersion ImmutableSoftwareVersion.withSoftwarePackageId(long)"
  })
  void testWithSoftwarePackageId_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithSoftwarePackageIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withSoftwarePackageId(42L);

    // Assert
    assertEquals("1.0.2", actualWithSoftwarePackageIdResult.version());
    LocalDate releaseDateResult = actualWithSoftwarePackageIdResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualWithSoftwarePackageIdResult.name());
    assertEquals("Provenance", actualWithSoftwarePackageIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithSoftwarePackageIdResult.description());
    assertEquals(42L, actualWithSoftwarePackageIdResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithSoftwarePackageIdResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withVersion(String)"})
  void testWithVersion() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwareVersion immutableSoftwareVersion =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(LocalDate.of(1970, 1, 1))
            .softwarePackageId(1L)
            .version("42")
            .build();

    // Act
    ImmutableSoftwareVersion actualWithVersionResult = immutableSoftwareVersion.withVersion("42");

    // Assert
    assertSame(immutableSoftwareVersion, actualWithVersionResult);
  }

  /**
   * Test {@link ImmutableSoftwareVersion#withVersion(String)}.
   *
   * <ul>
   *   <li>Then return releaseDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwareVersion#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String); then return releaseDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwareVersion ImmutableSoftwareVersion.withVersion(String)"})
  void testWithVersion_thenReturnReleaseDateToStringIs19700101() {
    // Arrange
    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSoftwareVersion actualWithVersionResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .releaseDate(releaseDate)
            .softwarePackageId(1L)
            .version("1.0.2")
            .build()
            .withVersion("42");

    // Assert
    LocalDate releaseDateResult = actualWithVersionResult.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("42", actualWithVersionResult.version());
    assertEquals("Name", actualWithVersionResult.name());
    assertEquals("Provenance", actualWithVersionResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithVersionResult.description());
    assertEquals(1L, actualWithVersionResult.softwarePackageId());
    assertEquals(EntityKind.ALL, actualWithVersionResult.kind());
    assertSame(releaseDate, releaseDateResult);
  }
}
