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
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackageView.Builder;
import org.finos.waltz.model.software_catalog.ImmutableSoftwarePackageView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSoftwarePackageViewDiffblueTest {
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
    "ImmutableSoftwarePackageView Builder.build()",
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
    Builder actualBuilderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView =
        actualIdResult
            .id(id)
            .isNotable(true)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .vendor("Vendor")
            .version("1.0.2")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableSoftwarePackageView.version());
    assertEquals("Group", actualImmutableSoftwarePackageView.group());
    assertEquals("Name", actualImmutableSoftwarePackageView.name());
    assertEquals("Provenance", actualImmutableSoftwarePackageView.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSoftwarePackageView.description());
    assertEquals("Vendor", actualImmutableSoftwarePackageView.vendor());
    assertEquals(EntityKind.ALL, actualImmutableSoftwarePackageView.kind());
    assertTrue(actualImmutableSoftwarePackageView.isNotable());
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (CreatedUserTimestampProvider)
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
  void testBuilderFromWithCreatedUserTimestampProvider3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
   * <p>Method under test: {@link Builder#from(CreatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedUserTimestampProvider) with 'CreatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedUserTimestampProvider)"})
  void testBuilderFromWithCreatedUserTimestampProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithCreatedUserTimestampProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithCreatedUserTimestampProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithCreatedUserTimestampProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithCreatedUserTimestampProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithCreatedUserTimestampProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (CreatedUserTimestampProvider)
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (DescriptionProvider)
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithDescriptionProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithDescriptionProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithDescriptionProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithDescriptionProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (DescriptionProvider)
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
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (DescriptionProvider)
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
                    .build());

    // Assert
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
  void testBuilderFromWithDescriptionProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (DescriptionProvider)
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
                    .build());

    // Assert
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (EntityKindProvider)
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithEntityKindProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithEntityKindProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithEntityKindProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithEntityKindProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithEntityKindProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityKindProvider)
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
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (EntityKindProvider)
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
                    .build());

    // Assert
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (ExternalIdProvider)
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithExternalIdProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithExternalIdProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithExternalIdProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithExternalIdProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithExternalIdProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ExternalIdProvider)
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
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (ExternalIdProvider)
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
                    .build());

    // Assert
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (IdProvider)
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
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithIdProvider4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithIdProvider5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithIdProvider6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithIdProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithIdProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IdProvider)
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
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (IdProvider)
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
                    .build());

    // Assert
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (NameProvider)
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithNameProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithNameProvider8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (NameProvider)
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
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (NameProvider)
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
                    .build());

    // Assert
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
  void testBuilderFromWithNameProvider10() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
            (NameProvider)
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
                    .build());

    // Assert
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAggregateOverlayDiagram.builder()
                    .aggregatedEntityKind(EntityKind.ALL)
                    .description(null)
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
  void testBuilderFromWithProvenanceProvider7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
  void testBuilderFromWithProvenanceProvider9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithProvenanceProvider10() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithProvenanceProvider11() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithSoftwarePackage() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((SoftwarePackage) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithSoftwarePackage3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    ImmutableSoftwarePackage.Builder builderResult2 = ImmutableSoftwarePackage.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act
    Builder actualFromResult =
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
                .build());

    // Assert
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
  void testBuilderFromWithSoftwarePackage4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
   * Test Builder {@link Builder#from(SoftwarePackage)} with {@code SoftwarePackage}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackage)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackage) with 'SoftwarePackage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackage)"})
  void testBuilderFromWithSoftwarePackage5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
                .build());

    // Assert
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
  void testBuilderFromWithSoftwarePackage6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
                .build());

    // Assert
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
  void testBuilderFromWithSoftwarePackage7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((SoftwarePackage) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithSoftwarePackage8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((SoftwarePackage) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithSoftwarePackage9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((SoftwarePackage) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
  void testBuilderFromWithSoftwarePackage10() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((SoftwarePackage) instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackageView)} with {@code SoftwarePackageView}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackageView) with 'SoftwarePackageView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackageView)"})
  void testBuilderFromWithSoftwarePackageView() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackageView)} with {@code SoftwarePackageView}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackageView) with 'SoftwarePackageView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackageView)"})
  void testBuilderFromWithSoftwarePackageView2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackageView)} with {@code SoftwarePackageView}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackageView) with 'SoftwarePackageView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackageView)"})
  void testBuilderFromWithSoftwarePackageView3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackageView)} with {@code SoftwarePackageView}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackageView) with 'SoftwarePackageView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackageView)"})
  void testBuilderFromWithSoftwarePackageView4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackageView)} with {@code SoftwarePackageView}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackageView) with 'SoftwarePackageView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackageView)"})
  void testBuilderFromWithSoftwarePackageView5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .version("1.0.2")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SoftwarePackageView)} with {@code SoftwarePackageView}.
   *
   * <p>Method under test: {@link Builder#from(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test Builder from(SoftwarePackageView) with 'SoftwarePackageView'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SoftwarePackageView)"})
  void testBuilderFromWithSoftwarePackageView6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSoftwarePackageView actualImmutableSoftwarePackageView = builderResult.build();
    assertEquals(instance, actualImmutableSoftwarePackageView);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
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
    Builder builderResult = ImmutableSoftwarePackageView.builder();

    // Act
    Builder actualVersionResult = builderResult.version("1.0.2");

    // Assert
    assertSame(builderResult, actualVersionResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#copyOf(SoftwarePackageView)}
   */
  @Test
  @DisplayName("Test copyOf(SoftwarePackageView); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.copyOf(SoftwarePackageView)"
  })
  void testCopyOf_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    ImmutableSoftwarePackageView actualCopyOfResult = ImmutableSoftwarePackageView.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.version());
    assertEquals("Group", actualCopyOfResult.group());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("Vendor", actualCopyOfResult.vendor());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#created()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#created()}
   */
  @Test
  @DisplayName("Test created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwarePackageView.created()"})
  void testCreated() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
            .version("1.0.2")
            .build()
            .created());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}, and {@link
   * ImmutableSoftwarePackageView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwarePackageView#equals(Object)}
   *   <li>{@link ImmutableSoftwarePackageView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);
    ImmutableSoftwarePackageView immutableSoftwarePackageView2 =
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
            .version("1.0.2")
            .build();

    // Act and Assert
    assertEquals(immutableSoftwarePackageView, immutableSoftwarePackageView2);
    assertEquals(immutableSoftwarePackageView.hashCode(), immutableSoftwarePackageView2.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}, and {@link
   * ImmutableSoftwarePackageView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSoftwarePackageView#equals(Object)}
   *   <li>{@link ImmutableSoftwarePackageView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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

    // Act and Assert
    assertEquals(immutableSoftwarePackageView, immutableSoftwarePackageView);
    int expectedHashCodeResult = immutableSoftwarePackageView.hashCode();
    assertEquals(expectedHashCodeResult, immutableSoftwarePackageView.hashCode());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("Name")
            .build();

    Builder builderResult2 = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        immutableSoftwarePackageView,
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
            .version("1.0.2")
            .build());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
            .version("1.0.2")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSoftwarePackageView.equals(Object)",
    "int ImmutableSoftwarePackageView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
            .version("1.0.2")
            .build(),
        "Different type to ImmutableSoftwarePackageView");
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#externalId()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwarePackageView.externalId()"})
  void testExternalId() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
   *   <li>{@link ImmutableSoftwarePackageView#description()}
   *   <li>{@link ImmutableSoftwarePackageView#group()}
   *   <li>{@link ImmutableSoftwarePackageView#isNotable()}
   *   <li>{@link ImmutableSoftwarePackageView#name()}
   *   <li>{@link ImmutableSoftwarePackageView#vendor()}
   *   <li>{@link ImmutableSoftwarePackageView#version()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSoftwarePackageView.description()",
    "String ImmutableSoftwarePackageView.group()",
    "boolean ImmutableSoftwarePackageView.isNotable()",
    "String ImmutableSoftwarePackageView.name()",
    "String ImmutableSoftwarePackageView.vendor()",
    "String ImmutableSoftwarePackageView.version()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    String actualDescriptionResult = immutableSoftwarePackageView.description();
    String actualGroupResult = immutableSoftwarePackageView.group();
    boolean actualIsNotableResult = immutableSoftwarePackageView.isNotable();
    String actualNameResult = immutableSoftwarePackageView.name();
    String actualVendorResult = immutableSoftwarePackageView.vendor();

    // Assert
    assertEquals("1.0.2", immutableSoftwarePackageView.version());
    assertEquals("Group", actualGroupResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals("Vendor", actualVendorResult);
    assertTrue(actualIsNotableResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#id()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSoftwarePackageView.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
    assertNull(actualJson.version);
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
   * Test {@link ImmutableSoftwarePackageView#kind()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableSoftwarePackageView.kind()"})
  void testKind() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
            .version("1.0.2")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#provenance()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackageView.provenance()"})
  void testProvenance() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
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
            .version("1.0.2")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackageView.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwarePackageView{id=1, name=Name, externalId=42, provenance=Provenance, created=UserTimestamp{at"
            + "=1970-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, vendor=Vendor, group=Group, isNotable=true,"
            + " kind=ALL, version=1.0.2}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackageView.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    // Act and Assert
    assertEquals(
        "SoftwarePackageView{id=1, name=Name, externalId=42, provenance=Provenance, vendor=Vendor, group=Group,"
            + " isNotable=true, kind=ALL, version=1.0.2}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackageView.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwarePackageView{id=1, name=Name, externalId=42, provenance=Provenance, created=UserTimestamp{at"
            + "=1970-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, vendor=Vendor, isNotable=true, kind=ALL,"
            + " version=1.0.2}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#toString()}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSoftwarePackageView.toString()"})
  void testToString4() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "SoftwarePackageView{id=1, name=Name, externalId=42, provenance=Provenance, created=UserTimestamp{at"
            + "=1970-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}, group=Group, isNotable=true, kind=ALL,"
            + " version=1.0.2}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withCreated(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withCreated(Optional)}
   */
  @Test
  @DisplayName("Test withCreated(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withCreated(Optional)"
  })
  void testWithCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> optional = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableSoftwarePackageView actualWithCreatedResult =
        immutableSoftwarePackageView.withCreated(optional);

    // Assert
    assertEquals(immutableSoftwarePackageView, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withCreated(UserTimestamp)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withCreated(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withCreated(UserTimestamp) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withCreated(UserTimestamp)"
  })
  void testWithCreatedWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableSoftwarePackageView actualWithCreatedResult =
        immutableSoftwarePackageView.withCreated(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableSoftwarePackageView, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableSoftwarePackageView actualWithDescriptionResult =
        immutableSoftwarePackageView.withDescription("42");

    // Assert
    assertEquals(immutableSoftwarePackageView, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackageView actualWithDescriptionResult =
        immutableSoftwarePackageView.withDescription("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSoftwarePackageView actualWithExternalIdResult =
        immutableSoftwarePackageView.withExternalId(optional);

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableSoftwarePackageView actualWithExternalIdResult =
        immutableSoftwarePackageView.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.version());
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
   * Test {@link ImmutableSoftwarePackageView#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableSoftwarePackageView actualWithExternalIdResult =
        immutableSoftwarePackageView.withExternalId("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithExternalIdResult =
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
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.version());
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
   * Test {@link ImmutableSoftwarePackageView#withGroup(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withGroup(String)"})
  void testWithGroup() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackageView actualWithGroupResult =
        immutableSoftwarePackageView.withGroup("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithGroupResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withGroup(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withGroup(String)}
   */
  @Test
  @DisplayName("Test withGroup(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withGroup(String)"})
  void testWithGroup_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithGroupResult =
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
            .build()
            .withGroup("42");

    // Assert
    assertEquals("1.0.2", actualWithGroupResult.version());
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
   * Test {@link ImmutableSoftwarePackageView#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSoftwarePackageView actualWithIdResult = immutableSoftwarePackageView.withId(optional);

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withId(Optional)"})
  void testWithIdWithOptional_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableSoftwarePackageView actualWithIdResult = immutableSoftwarePackageView.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.version());
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals("Vendor", actualWithIdResult.vendor());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableSoftwarePackageView actualWithIdResult = immutableSoftwarePackageView.withId(1L);

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithIdResult =
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
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.version());
    assertEquals("Group", actualWithIdResult.group());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals("Vendor", actualWithIdResult.vendor());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertTrue(actualWithIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withIsNotable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test withIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withIsNotable(boolean)"
  })
  void testWithIsNotable() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableSoftwarePackageView actualWithIsNotableResult =
        immutableSoftwarePackageView.withIsNotable(true);

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithIsNotableResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withIsNotable(boolean)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test withIsNotable(boolean); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withIsNotable(boolean)"
  })
  void testWithIsNotable_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithIsNotableResult =
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
            .build()
            .withIsNotable(true);

    // Assert
    assertEquals("1.0.2", actualWithIsNotableResult.version());
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
   * Test {@link ImmutableSoftwarePackageView#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
    ImmutableSoftwarePackageView actualWithKindResult =
        immutableSoftwarePackageView.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withKind(EntityKind)"
  })
  void testWithKind_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithKindResult =
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
            .version("1.0.2")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.version());
    assertEquals("Group", actualWithKindResult.group());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals("Vendor", actualWithKindResult.vendor());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertTrue(actualWithKindResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withName(String)"})
  void testWithName() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackageView actualWithNameResult = immutableSoftwarePackageView.withName("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withName(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withName(String)"})
  void testWithName_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithNameResult =
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
            .build()
            .withName("42");

    // Assert
    assertEquals("1.0.2", actualWithNameResult.version());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Group", actualWithNameResult.group());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals("Vendor", actualWithNameResult.vendor());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertTrue(actualWithNameResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackageView actualWithProvenanceResult =
        immutableSoftwarePackageView.withProvenance("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withProvenance(String)"
  })
  void testWithProvenance_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithProvenanceResult =
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
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.version());
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
   * Test {@link ImmutableSoftwarePackageView#withVendor(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withVendor(String)}
   */
  @Test
  @DisplayName("Test withVendor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withVendor(String)"
  })
  void testWithVendor() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("1.0.2")
            .build();

    // Act
    ImmutableSoftwarePackageView actualWithVendorResult =
        immutableSoftwarePackageView.withVendor("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithVendorResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withVendor(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withVendor(String)}
   */
  @Test
  @DisplayName("Test withVendor(String); then return version is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withVendor(String)"
  })
  void testWithVendor_thenReturnVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithVendorResult =
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
            .build()
            .withVendor("42");

    // Assert
    assertEquals("1.0.2", actualWithVendorResult.version());
    assertEquals("42", actualWithVendorResult.vendor());
    assertEquals("Group", actualWithVendorResult.group());
    assertEquals("Name", actualWithVendorResult.name());
    assertEquals("Provenance", actualWithVendorResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithVendorResult.description());
    assertEquals(EntityKind.ALL, actualWithVendorResult.kind());
    assertTrue(actualWithVendorResult.isNotable());
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withVersion(String)"
  })
  void testWithVersion() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    ImmutableSoftwarePackageView immutableSoftwarePackageView =
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
            .version("42")
            .build();

    // Act
    ImmutableSoftwarePackageView actualWithVersionResult =
        immutableSoftwarePackageView.withVersion("42");

    // Assert
    assertSame(immutableSoftwarePackageView, actualWithVersionResult);
  }

  /**
   * Test {@link ImmutableSoftwarePackageView#withVersion(String)}.
   *
   * <ul>
   *   <li>Then return version is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSoftwarePackageView#withVersion(String)}
   */
  @Test
  @DisplayName("Test withVersion(String); then return version is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSoftwarePackageView ImmutableSoftwarePackageView.withVersion(String)"
  })
  void testWithVersion_thenReturnVersionIs42() {
    // Arrange
    Builder builderResult = ImmutableSoftwarePackageView.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    // Act
    ImmutableSoftwarePackageView actualWithVersionResult =
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
            .build()
            .withVersion("42");

    // Assert
    assertEquals("42", actualWithVersionResult.version());
    assertEquals("Group", actualWithVersionResult.group());
    assertEquals("Name", actualWithVersionResult.name());
    assertEquals("Provenance", actualWithVersionResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithVersionResult.description());
    assertEquals("Vendor", actualWithVersionResult.vendor());
    assertEquals(EntityKind.ALL, actualWithVersionResult.kind());
    assertTrue(actualWithVersionResult.isNotable());
  }
}
