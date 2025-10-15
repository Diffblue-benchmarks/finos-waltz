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
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackage.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackage.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwarePackageDiffblueTest {
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
   *   <li>{@link Builder#group(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#provenance(String)}
   *   <li>{@link Builder#vendor(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackage Builder.build()",
    "Builder Builder.created(UserTimestamp)",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.group(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.provenance(String)",
    "Builder Builder.vendor(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSoftwarePackage.builder();
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
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).group("Group").id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableSoftwarePackage actualImmutableSoftwarePackage =
        actualIdResult
            .id(id)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Assert
    assertEquals("Group", actualImmutableSoftwarePackage.group());
    assertEquals("Name", actualImmutableSoftwarePackage.name());
    assertEquals("Provenance", actualImmutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSoftwarePackage.description());
    assertEquals("Vendor", actualImmutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, actualImmutableSoftwarePackage.kind());
    assertTrue(actualImmutableSoftwarePackage.isNotable());
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
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
  void testBuilderFromWithNameProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group(null)
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
  void testBuilderFromWithNameProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
  void testBuilderFromWithNameProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .vendor(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
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
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
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
                .version("1.0.2")
                .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
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
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .releaseDate(LocalDate.of(1970, 1, 1))
                    .softwarePackageId(1L)
                    .version("1.0.2")
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
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
                .version("1.0.2")
                .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwareVersion.Builder builderResult2 = ImmutableSoftwareVersion.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
   * <ul>
   *   <li>Then builder build description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then builder build description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
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
                .version("1.0.2")
                .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertNull(immutableSoftwarePackage.description());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then builder build group is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then builder build group is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenBuilderBuildGroupIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    builderResult.from(
        (ProvenanceProvider)
            builderResult2
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .group(null)
                .id(1L)
                .isNotable(true)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .vendor("Vendor")
                .version("1.0.2")
                .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertNull(immutableSoftwarePackage.group());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then builder build vendor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then builder build vendor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenBuilderBuildVendorIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
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
                .vendor(null)
                .version("1.0.2")
                .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertNull(immutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackage) with 'SoftwarePackage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackage actualImmutableSoftwarePackage = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackage);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackage) with 'SoftwarePackage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    builderResult.from(
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
            .version("1.0.2")
            .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackage) with 'SoftwarePackage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    builderResult.from(
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
            .version("1.0.2")
            .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <ul>
   *   <li>Then builder build description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwarePackage) with 'SoftwarePackage'; then builder build description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    builderResult.from(
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
            .version("1.0.2")
            .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertNull(immutableSoftwarePackage.description());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <ul>
   *   <li>Then builder build group is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwarePackage) with 'SoftwarePackage'; then builder build group is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage_thenBuilderBuildGroupIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    builderResult.from(
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group(null)
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .version("1.0.2")
            .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertNull(immutableSoftwarePackage.group());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <ul>
   *   <li>Then builder build vendor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SoftwarePackage) with 'SoftwarePackage'; then builder build vendor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage_thenBuilderBuildVendorIsNull() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    ImmutableSoftwarePackageView.Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    builderResult.from(
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
            .vendor(null)
            .version("1.0.2")
            .build());

    // Assert
    ImmutableSoftwarePackage immutableSoftwarePackage = builderResult.build();
    assertEquals("Group", immutableSoftwarePackage.group());
    assertEquals("Name", immutableSoftwarePackage.name());
    assertEquals("Provenance", immutableSoftwarePackage.provenance());
    assertEquals(
        "The characteristics of someone or something", immutableSoftwarePackage.description());
    assertNull(immutableSoftwarePackage.vendor());
    assertEquals(EntityKind.ALL, immutableSoftwarePackage.kind());
    assertTrue(immutableSoftwarePackage.isNotable());
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

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
    Builder builderResult = ImmutableSoftwarePackage.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isNotable(boolean)}.
   *
   * <p>Method under test: {@link Builder#isNotable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isNotable(boolean)"})
  void testBuilderIsNotable() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();

    // Act
    Builder actualIsNotableResult = builderResult.isNotable(true);

    // Assert
    assertSame(builderResult, actualIsNotableResult);
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
    Builder builderResult = ImmutableSoftwarePackage.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage instance =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf2() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
        builderResult
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf3() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
        builderResult
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <ul>
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf_thenReturnDescriptionIsNull() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
        builderResult
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertNull(actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <ul>
   *   <li>Then return group is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage); then return group is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf_thenReturnGroupIsNull() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group(null)
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertNull(actualCopyOfResult.group());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <ul>
   *   <li>Then return not Notable.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage); then return not Notable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf_thenReturnNotNotable() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}.
   *
   * <ul>
   *   <li>Then return vendor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#copyOf(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackage); then return vendor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.copyOf(SoftwarePackage)"})
  void testCopyOf_thenReturnVendorIsNull() {
    // Arrange
    ImmutableSoftwarePackageView.Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor(null)
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackage actualCopyOfResult = ImmutableSoftwarePackage.copyOf(instance);

    // Assert
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.vendor());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#created()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#created()}
   */
  @Test
  @DisplayName("Test created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwarePackage.created()"})
  void testCreated() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build()
            .created());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}, and {@link
   * ImmutableSoftwarePackage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwarePackage#equals(Object)}
   *   <li>{@link ImmutableSoftwarePackage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    ImmutableSoftwarePackage immutableSoftwarePackage2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Act and Assert
    assertEquals(immutableSoftwarePackage, immutableSoftwarePackage2);
    assertEquals(immutableSoftwarePackage.hashCode(), immutableSoftwarePackage2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}, and {@link
   * ImmutableSoftwarePackage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwarePackage#equals(Object)}
   *   <li>{@link ImmutableSoftwarePackage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act and Assert
    assertEquals(immutableSoftwarePackage, immutableSoftwarePackage);
    int expectedHashCodeResult = immutableSoftwarePackage.hashCode();
    assertEquals(expectedHashCodeResult, immutableSoftwarePackage.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("Name")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Name")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(2L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Provenance")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Name")
            .vendor("Vendor")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Name")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackage,
        builderResult2
            .created(created2)
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
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackage.equals(Object)",
    "int ImmutableSoftwarePackage.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build(),
        "Different type to ImmutableSoftwarePackage");
  }

  /**
   * Test {@link ImmutableSoftwarePackage#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwarePackage.externalId()"})
  void testExternalId() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
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
   *   <li>{@link ImmutableSoftwarePackage#description()}
   *   <li>{@link ImmutableSoftwarePackage#group()}
   *   <li>{@link ImmutableSoftwarePackage#isNotable()}
   *   <li>{@link ImmutableSoftwarePackage#name()}
   *   <li>{@link ImmutableSoftwarePackage#vendor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSoftwarePackage.description()",
    "String ImmutableSoftwarePackage.group()",
    "boolean ImmutableSoftwarePackage.isNotable()",
    "String ImmutableSoftwarePackage.name()",
    "String ImmutableSoftwarePackage.vendor()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    String actualDescriptionResult = immutableSoftwarePackage.description();
    String actualGroupResult = immutableSoftwarePackage.group();
    boolean actualIsNotableResult = immutableSoftwarePackage.isNotable();
    String actualNameResult = immutableSoftwarePackage.name();

    // Assert
    assertEquals("Group", actualGroupResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals("Vendor", immutableSoftwarePackage.vendor());
    assertTrue(actualIsNotableResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#id()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwarePackage.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
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
   * Test Json {@link Json#group()}.
   *
   * <p>Method under test: {@link Json#group()}
   */
  @Test
  @DisplayName("Test Json group()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.group()"})
  void testJsonGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().group());
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
   * Test Json {@link Json#isNotable()}.
   *
   * <p>Method under test: {@link Json#isNotable()}
   */
  @Test
  @DisplayName("Test Json isNotable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isNotable()"})
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isNotable());
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
    assertNull(actualJson.group);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.vendor);
    assertNull(actualJson.kind);
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isNotable);
    assertFalse(actualJson.isNotableIsSet);
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
   * Test Json {@link Json#setIsNotable(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsNotable(boolean)"})
  void testJsonSetIsNotable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Test Json {@link Json#vendor()}.
   *
   * <p>Method under test: {@link Json#vendor()}
   */
  @Test
  @DisplayName("Test Json vendor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.vendor()"})
  void testJsonVendor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().vendor());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#kind()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableSoftwarePackage.kind()"})
  void testKind() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#provenance()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackage.provenance()"})
  void testProvenance() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
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
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackage.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwarePackage{id=1, name=Name, externalId=42, provenance=Provenance, created=UserTimestamp{at=1970"
            + "-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, vendor=Vendor, group=Group, isNotable=true,"
            + " kind=ALL}",
        builderResult
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackage.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act and Assert
    assertEquals(
        "SoftwarePackage{id=1, name=Name, externalId=42, provenance=Provenance, vendor=Vendor, group=Group,"
            + " isNotable=true, kind=ALL}",
        builderResult
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackage.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwarePackage{id=1, name=Name, externalId=42, provenance=Provenance, created=UserTimestamp{at=1970"
            + "-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, vendor=Vendor, isNotable=true, kind=ALL}",
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group(null)
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackage.toString()"})
  void testToString4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwarePackage{id=1, name=Name, externalId=42, provenance=Provenance, created=UserTimestamp{at=1970"
            + "-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, group=Group, isNotable=true, kind=ALL}",
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor(null)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withCreated(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withCreated(Optional)}
   */
  @Test
  @DisplayName("Test withCreated(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withCreated(Optional)"})
  void testWithCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> optional = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableSoftwarePackage actualWithCreatedResult =
        immutableSoftwarePackage.withCreated(optional);

    // Assert
    assertEquals(immutableSoftwarePackage, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withCreated(UserTimestamp)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withCreated(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withCreated(UserTimestamp) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackage ImmutableSoftwarePackage.withCreated(UserTimestamp)"
  })
  void testWithCreatedWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualWithCreatedResult =
        immutableSoftwarePackage.withCreated(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableSoftwarePackage, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualWithDescriptionResult =
        immutableSoftwarePackage.withDescription("42");

    // Assert
    assertEquals(immutableSoftwarePackage, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("42")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Act
    ImmutableSoftwarePackage actualWithDescriptionResult =
        immutableSoftwarePackage.withDescription("42");

    // Assert
    assertSame(immutableSoftwarePackage, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSoftwarePackage actualWithExternalIdResult =
        immutableSoftwarePackage.withExternalId(optional);

    // Assert
    assertSame(immutableSoftwarePackage, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSoftwarePackage actualWithExternalIdResult =
        immutableSoftwarePackage.withExternalId(optional);

    // Assert
    assertEquals("Group", actualWithExternalIdResult.group());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals("Vendor", actualWithExternalIdResult.vendor());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertTrue(actualWithExternalIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualWithExternalIdResult =
        immutableSoftwarePackage.withExternalId("42");

    // Assert
    assertSame(immutableSoftwarePackage, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithExternalIdResult =
        builderResult
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
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Group", actualWithExternalIdResult.group());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals("Vendor", actualWithExternalIdResult.vendor());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertTrue(actualWithExternalIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withGroup(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withGroup(String)"})
  void testWithGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("42")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Act
    ImmutableSoftwarePackage actualWithGroupResult = immutableSoftwarePackage.withGroup("42");

    // Assert
    assertSame(immutableSoftwarePackage, actualWithGroupResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withGroup(String)}.
   *
   * <ul>
   *   <li>Then return group is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String); then return group is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withGroup(String)"})
  void testWithGroup_thenReturnGroupIs42() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithGroupResult =
        builderResult
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
            .build()
            .withGroup("42");

    // Assert
    assertEquals("42", actualWithGroupResult.group());
    assertEquals("Name", actualWithGroupResult.name());
    assertEquals("Provenance", actualWithGroupResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithGroupResult.description());
    assertEquals("Vendor", actualWithGroupResult.vendor());
    assertEquals(EntityKind.ALL, actualWithGroupResult.kind());
    assertTrue(actualWithGroupResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSoftwarePackage actualWithIdResult = immutableSoftwarePackage.withId(optional);

    // Assert
    assertSame(immutableSoftwarePackage, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withId(Optional)"})
  void testWithIdWithOptional_thenReturnGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(2L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSoftwarePackage actualWithIdResult = immutableSoftwarePackage.withId(optional);

    // Assert
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals("Vendor", actualWithIdResult.vendor());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualWithIdResult = immutableSoftwarePackage.withId(1L);

    // Assert
    assertSame(immutableSoftwarePackage, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithIdResult =
        builderResult
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
            .build()
            .withId(42L);

    // Assert
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals("Vendor", actualWithIdResult.vendor());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withIsNotable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test withIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withIsNotable(boolean)"})
  void testWithIsNotable() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualWithIsNotableResult =
        immutableSoftwarePackage.withIsNotable(true);

    // Assert
    assertSame(immutableSoftwarePackage, actualWithIsNotableResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withIsNotable(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test withIsNotable(boolean); then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withIsNotable(boolean)"})
  void testWithIsNotable_thenReturnGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithIsNotableResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(false)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build()
            .withIsNotable(true);

    // Assert
    assertEquals("Group", actualWithIsNotableResult.group());
    assertEquals("Name", actualWithIsNotableResult.name());
    assertEquals("Provenance", actualWithIsNotableResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithIsNotableResult.description());
    assertEquals("Vendor", actualWithIsNotableResult.vendor());
    assertEquals(EntityKind.ALL, actualWithIsNotableResult.kind());
    assertTrue(actualWithIsNotableResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
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
            .build();

    // Act
    ImmutableSoftwarePackage actualWithKindResult =
        immutableSoftwarePackage.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSoftwarePackage, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withKind(EntityKind)"})
  void testWithKind_thenReturnGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithKindResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Group", actualWithKindResult.group());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals("Vendor", actualWithKindResult.vendor());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertTrue(actualWithKindResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withName(String)"})
  void testWithName() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("42")
            .provenance("Provenance")
            .vendor("Vendor")
            .build();

    // Act
    ImmutableSoftwarePackage actualWithNameResult = immutableSoftwarePackage.withName("42");

    // Assert
    assertSame(immutableSoftwarePackage, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithNameResult =
        builderResult
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
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Group", actualWithNameResult.group());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals("Vendor", actualWithNameResult.vendor());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertTrue(actualWithNameResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("42")
            .vendor("Vendor")
            .build();

    // Act
    ImmutableSoftwarePackage actualWithProvenanceResult =
        immutableSoftwarePackage.withProvenance("42");

    // Assert
    assertSame(immutableSoftwarePackage, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withProvenance(String)"})
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithProvenanceResult =
        builderResult
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
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Group", actualWithProvenanceResult.group());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals("Vendor", actualWithProvenanceResult.vendor());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertTrue(actualWithProvenanceResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withVendor(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withVendor(String)}
   */
  @Test
  @DisplayName("Test withVendor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withVendor(String)"})
  void testWithVendor() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackage immutableSoftwarePackage =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .group("Group")
            .id(1L)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("42")
            .build();

    // Act
    ImmutableSoftwarePackage actualWithVendorResult = immutableSoftwarePackage.withVendor("42");

    // Assert
    assertSame(immutableSoftwarePackage, actualWithVendorResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackage#withVendor(String)}.
   *
   * <ul>
   *   <li>Then return vendor is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackage#withVendor(String)}
   */
  @Test
  @DisplayName("Test withVendor(String); then return vendor is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackage ImmutableSoftwarePackage.withVendor(String)"})
  void testWithVendor_thenReturnVendorIs42() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackage.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackage actualWithVendorResult =
        builderResult
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
            .build()
            .withVendor("42");

    // Assert
    assertEquals("42", actualWithVendorResult.vendor());
    assertEquals("Group", actualWithVendorResult.group());
    assertEquals("Name", actualWithVendorResult.name());
    assertEquals("Provenance", actualWithVendorResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithVendorResult.description());
    assertEquals(EntityKind.ALL, actualWithVendorResult.kind());
    assertTrue(actualWithVendorResult.isNotable());
  }
}
