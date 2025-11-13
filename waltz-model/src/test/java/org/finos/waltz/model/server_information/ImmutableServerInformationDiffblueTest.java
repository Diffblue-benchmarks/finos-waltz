package org.finos.waltz.model.server_information;

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
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.EndOfLifeStatus;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LifecycleStatus;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.server_information.ImmutableServerInformation.Builder;
import org.finos.waltz.model.server_information.ImmutableServerInformation.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableServerInformationDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#hardwareEndOfLifeDate(Date)}
   *   <li>{@link Builder#kind(EntityKind)}
   *   <li>{@link Builder#operatingSystemEndOfLifeDate(Date)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.hardwareEndOfLifeDate(Date)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.operatingSystemEndOfLifeDate(Date)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    Date hardwareEndOfLifeDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Builder actualIdResult =
        actualExternalIdResult2
            .hardwareEndOfLifeDate(hardwareEndOfLifeDate)
            .hostname("localhost")
            .id(1L);
    Optional<Long> id = Optional.of(42L);
    Builder actualOperatingSystemResult =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    Date operatingSystemEndOfLifeDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableServerInformation actualImmutableServerInformation =
        actualOperatingSystemResult
            .operatingSystemEndOfLifeDate(operatingSystemEndOfLifeDate)
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableServerInformation.operatingSystemVersion());
    assertEquals("GB", actualImmutableServerInformation.country());
    assertEquals("Location", actualImmutableServerInformation.location());
    assertEquals("Operating System", actualImmutableServerInformation.operatingSystem());
    assertEquals("Provenance", actualImmutableServerInformation.provenance());
    assertEquals("localhost", actualImmutableServerInformation.hostname());
    assertEquals(EntityKind.ALL, actualImmutableServerInformation.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualImmutableServerInformation.lifecycleStatus());
    assertFalse(actualImmutableServerInformation.virtual());
    assertSame(hardwareEndOfLifeDate, actualImmutableServerInformation.hardwareEndOfLifeDate());
    assertSame(
        operatingSystemEndOfLifeDate,
        actualImmutableServerInformation.operatingSystemEndOfLifeDate());
  }

  /**
   * Test Builder {@link Builder#country(String)}.
   *
   * <ul>
   *   <li>When {@code GB}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#country(String)}
   */
  @Test
  @DisplayName("Test Builder country(String); when 'GB'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.country(String)"})
  void testBuilderCountry_whenGb_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualCountryResult = builderResult.country("GB");

    // Assert
    assertSame(builderResult, actualCountryResult);
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
    Builder builderResult = ImmutableServerInformation.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
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
    Builder builderResult = ImmutableServerInformation.builder();

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
  void testBuilderFromWithProvenanceProvider4() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
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
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");
    ImmutableServerInformation instance =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System")
            .operatingSystemEndOfLifeDate(null)
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
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
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   *
   * <p>Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   *
   * <p>Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation2() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
  }

  /**
   * Test Builder {@link Builder#from(ServerInformation)} with {@code ServerInformation}.
   *
   * <p>Method under test: {@link Builder#from(ServerInformation)}
   */
  @Test
  @DisplayName("Test Builder from(ServerInformation) with 'ServerInformation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ServerInformation)"})
  void testBuilderFromWithServerInformation3() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");
    ImmutableServerInformation instance =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System")
            .operatingSystemEndOfLifeDate(null)
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableServerInformation actualImmutableServerInformation =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableServerInformation);
    ImmutableServerInformation actualImmutableServerInformation2 = builderResult.build();
    assertEquals(instance, actualImmutableServerInformation2);
  }

  /**
   * Test Builder {@link Builder#hostname(String)}.
   *
   * <ul>
   *   <li>When {@code localhost}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#hostname(String)}
   */
  @Test
  @DisplayName("Test Builder hostname(String); when 'localhost'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.hostname(String)"})
  void testBuilderHostname_whenLocalhost_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualHostnameResult = builderResult.hostname("localhost");

    // Assert
    assertSame(builderResult, actualHostnameResult);
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
    Builder builderResult = ImmutableServerInformation.builder();

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
    Builder builderResult = ImmutableServerInformation.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link Builder#lifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder lifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecycleStatus(LifecycleStatus)"})
  void testBuilderLifecycleStatus() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualLifecycleStatusResult = builderResult.lifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertSame(builderResult, actualLifecycleStatusResult);
  }

  /**
   * Test Builder {@link Builder#location(String)}.
   *
   * <ul>
   *   <li>When {@code Location}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#location(String)}
   */
  @Test
  @DisplayName("Test Builder location(String); when 'Location'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.location(String)"})
  void testBuilderLocation_whenLocation_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualLocationResult = builderResult.location("Location");

    // Assert
    assertSame(builderResult, actualLocationResult);
  }

  /**
   * Test Builder {@link Builder#operatingSystemVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operatingSystemVersion(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystemVersion(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operatingSystemVersion(String)"})
  void testBuilderOperatingSystemVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualOperatingSystemVersionResult = builderResult.operatingSystemVersion("1.0.2");

    // Assert
    assertSame(builderResult, actualOperatingSystemVersionResult);
  }

  /**
   * Test Builder {@link Builder#operatingSystem(String)}.
   *
   * <ul>
   *   <li>When {@code Operating System}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operatingSystem(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystem(String); when 'Operating System'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operatingSystem(String)"})
  void testBuilderOperatingSystem_whenOperatingSystem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualOperatingSystemResult = builderResult.operatingSystem("Operating System");

    // Assert
    assertSame(builderResult, actualOperatingSystemResult);
  }

  /**
   * Test Builder {@link Builder#virtual(boolean)}.
   *
   * <p>Method under test: {@link Builder#virtual(boolean)}
   */
  @Test
  @DisplayName("Test Builder virtual(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.virtual(boolean)"})
  void testBuilderVirtual() {
    // Arrange
    Builder builderResult = ImmutableServerInformation.builder();

    // Act
    Builder actualVirtualResult = builderResult.virtual(true);

    // Assert
    assertSame(builderResult, actualVirtualResult);
  }

  /**
   * Test {@link ImmutableServerInformation#copyOf(ServerInformation)}.
   *
   * <ul>
   *   <li>Then return operatingSystemVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#copyOf(ServerInformation)}
   */
  @Test
  @DisplayName("Test copyOf(ServerInformation); then return operatingSystemVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.copyOf(ServerInformation)"
  })
  void testCopyOf_thenReturnOperatingSystemVersionIs102() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation instance =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualCopyOfResult = ImmutableServerInformation.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.operatingSystemVersion());
    assertEquals("GB", actualCopyOfResult.country());
    assertEquals("Location", actualCopyOfResult.location());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("localhost", actualCopyOfResult.hostname());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualCopyOfResult.lifecycleStatus());
    assertFalse(actualCopyOfResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}, and {@link
   * ImmutableServerInformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerInformation#equals(Object)}
   *   <li>{@link ImmutableServerInformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation2 =
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableServerInformation, immutableServerInformation2);
    assertEquals(immutableServerInformation.hashCode(), immutableServerInformation2.hashCode());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}, and {@link
   * ImmutableServerInformation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableServerInformation#equals(Object)}
   *   <li>{@link ImmutableServerInformation#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableServerInformation, immutableServerInformation);
    int expectedHashCodeResult = immutableServerInformation.hashCode();
    assertEquals(expectedHashCodeResult, immutableServerInformation.hashCode());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GBR").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder externalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("localhost");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("Operating System")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(2L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("localhost")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("localhost");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("localhost")
            .provenance("Provenance")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("localhost")
            .build();

    Builder externalIdResult2 = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult2 =
        externalIdResult2
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        immutableServerInformation,
        operatingSystemResult2
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableServerInformation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableServerInformation.equals(Object)",
    "int ImmutableServerInformation.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertNotEquals(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableServerInformation");
  }

  /**
   * Test {@link ImmutableServerInformation#externalId()}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableServerInformation.externalId()"})
  void testExternalId() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    Optional<String> actualExternalIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
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
   *   <li>{@link ImmutableServerInformation#country()}
   *   <li>{@link ImmutableServerInformation#hardwareEndOfLifeDate()}
   *   <li>{@link ImmutableServerInformation#hostname()}
   *   <li>{@link ImmutableServerInformation#lifecycleStatus()}
   *   <li>{@link ImmutableServerInformation#location()}
   *   <li>{@link ImmutableServerInformation#operatingSystem()}
   *   <li>{@link ImmutableServerInformation#operatingSystemEndOfLifeDate()}
   *   <li>{@link ImmutableServerInformation#operatingSystemVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableServerInformation.country()",
    "Date ImmutableServerInformation.hardwareEndOfLifeDate()",
    "String ImmutableServerInformation.hostname()",
    "LifecycleStatus ImmutableServerInformation.lifecycleStatus()",
    "String ImmutableServerInformation.location()",
    "String ImmutableServerInformation.operatingSystem()",
    "Date ImmutableServerInformation.operatingSystemEndOfLifeDate()",
    "String ImmutableServerInformation.operatingSystemVersion()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");
    Date hardwareEndOfLifeDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(hardwareEndOfLifeDate)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    Date operatingSystemEndOfLifeDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(operatingSystemEndOfLifeDate)
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    String actualCountryResult = immutableServerInformation.country();
    Date actualHardwareEndOfLifeDateResult = immutableServerInformation.hardwareEndOfLifeDate();
    String actualHostnameResult = immutableServerInformation.hostname();
    LifecycleStatus actualLifecycleStatusResult = immutableServerInformation.lifecycleStatus();
    String actualLocationResult = immutableServerInformation.location();
    String actualOperatingSystemResult = immutableServerInformation.operatingSystem();
    Date actualOperatingSystemEndOfLifeDateResult =
        immutableServerInformation.operatingSystemEndOfLifeDate();

    // Assert
    assertEquals("1.0.2", immutableServerInformation.operatingSystemVersion());
    assertEquals("GB", actualCountryResult);
    assertEquals("Location", actualLocationResult);
    assertEquals("Operating System", actualOperatingSystemResult);
    assertEquals("localhost", actualHostnameResult);
    assertEquals(LifecycleStatus.ACTIVE, actualLifecycleStatusResult);
    assertSame(hardwareEndOfLifeDate, actualHardwareEndOfLifeDateResult);
    assertSame(operatingSystemEndOfLifeDate, actualOperatingSystemEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#id()}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableServerInformation.id()"})
  void testId() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    Optional<Long> actualIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#country()}.
   *
   * <p>Method under test: {@link Json#country()}
   */
  @Test
  @DisplayName("Test Json country()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.country()"})
  void testJsonCountry() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().country());
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
   * Test Json {@link Json#hardwareEndOfLifeDate()}.
   *
   * <p>Method under test: {@link Json#hardwareEndOfLifeDate()}
   */
  @Test
  @DisplayName("Test Json hardwareEndOfLifeDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.hardwareEndOfLifeDate()"})
  void testJsonHardwareEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().hardwareEndOfLifeDate());
  }

  /**
   * Test Json {@link Json#hardwareEndOfLifeStatus()}.
   *
   * <p>Method under test: {@link Json#hardwareEndOfLifeStatus()}
   */
  @Test
  @DisplayName("Test Json hardwareEndOfLifeStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EndOfLifeStatus Json.hardwareEndOfLifeStatus()"})
  void testJsonHardwareEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().hardwareEndOfLifeStatus());
  }

  /**
   * Test Json {@link Json#hostname()}.
   *
   * <p>Method under test: {@link Json#hostname()}
   */
  @Test
  @DisplayName("Test Json hostname()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.hostname()"})
  void testJsonHostname() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().hostname());
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
   * Test Json {@link Json#lifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#lifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json lifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LifecycleStatus Json.lifecycleStatus()"})
  void testJsonLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lifecycleStatus());
  }

  /**
   * Test Json {@link Json#location()}.
   *
   * <p>Method under test: {@link Json#location()}
   */
  @Test
  @DisplayName("Test Json location()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.location()"})
  void testJsonLocation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().location());
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
    assertNull(actualJson.country);
    assertNull(actualJson.hostname);
    assertNull(actualJson.location);
    assertNull(actualJson.operatingSystem);
    assertNull(actualJson.operatingSystemVersion);
    assertNull(actualJson.provenance);
    assertNull(actualJson.hardwareEndOfLifeDate);
    assertNull(actualJson.operatingSystemEndOfLifeDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecycleStatus);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.virtual);
    assertFalse(actualJson.virtualIsSet);
  }

  /**
   * Test Json {@link Json#operatingSystem()}.
   *
   * <p>Method under test: {@link Json#operatingSystem()}
   */
  @Test
  @DisplayName("Test Json operatingSystem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.operatingSystem()"})
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operatingSystem());
  }

  /**
   * Test Json {@link Json#operatingSystemEndOfLifeDate()}.
   *
   * <p>Method under test: {@link Json#operatingSystemEndOfLifeDate()}
   */
  @Test
  @DisplayName("Test Json operatingSystemEndOfLifeDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date Json.operatingSystemEndOfLifeDate()"})
  void testJsonOperatingSystemEndOfLifeDate() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().operatingSystemEndOfLifeDate());
  }

  /**
   * Test Json {@link Json#operatingSystemEndOfLifeStatus()}.
   *
   * <p>Method under test: {@link Json#operatingSystemEndOfLifeStatus()}
   */
  @Test
  @DisplayName("Test Json operatingSystemEndOfLifeStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EndOfLifeStatus Json.operatingSystemEndOfLifeStatus()"})
  void testJsonOperatingSystemEndOfLifeStatus() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().operatingSystemEndOfLifeStatus());
  }

  /**
   * Test Json {@link Json#operatingSystemVersion()}.
   *
   * <p>Method under test: {@link Json#operatingSystemVersion()}
   */
  @Test
  @DisplayName("Test Json operatingSystemVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.operatingSystemVersion()"})
  void testJsonOperatingSystemVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operatingSystemVersion());
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
   * Test Json {@link Json#setVirtual(boolean)}.
   *
   * <p>Method under test: {@link Json#setVirtual(boolean)}
   */
  @Test
  @DisplayName("Test Json setVirtual(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setVirtual(boolean)"})
  void testJsonSetVirtual() {
    // Arrange
    Json json = new Json();

    // Act
    json.setVirtual(true);

    // Assert
    assertTrue(json.virtual);
    assertTrue(json.virtualIsSet);
  }

  /**
   * Test Json {@link Json#virtual()}.
   *
   * <p>Method under test: {@link Json#virtual()}
   */
  @Test
  @DisplayName("Test Json virtual()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.virtual()"})
  void testJsonVirtual() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#kind()}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableServerInformation.kind()"})
  void testKind() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertEquals(
        EntityKind.ALL,
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableServerInformation#provenance()}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableServerInformation.provenance()"})
  void testProvenance() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertEquals(
        "Provenance",
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableServerInformation#virtual()}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#virtual()}
   */
  @Test
  @DisplayName("Test virtual()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableServerInformation.virtual()"})
  void testVirtual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act and Assert
    assertFalse(
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withCountry(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withCountry(String)}
   */
  @Test
  @DisplayName("Test withCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withCountry(String)"})
  void testWithCountry() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithCountryResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withCountry("42");

    // Assert
    assertEquals("1.0.2", actualWithCountryResult.operatingSystemVersion());
    assertEquals("42", actualWithCountryResult.country());
    assertEquals("Location", actualWithCountryResult.location());
    assertEquals("Operating System", actualWithCountryResult.operatingSystem());
    assertEquals("Provenance", actualWithCountryResult.provenance());
    assertEquals("localhost", actualWithCountryResult.hostname());
    assertEquals(EntityKind.ALL, actualWithCountryResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithCountryResult.lifecycleStatus());
    assertFalse(actualWithCountryResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withCountry(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withCountry(String)}
   */
  @Test
  @DisplayName("Test withCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withCountry(String)"})
  void testWithCountry2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("42").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithCountryResult =
        immutableServerInformation.withCountry("42");

    // Assert
    assertSame(immutableServerInformation, actualWithCountryResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withCountry(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withCountry(String)}
   */
  @Test
  @DisplayName("Test withCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withCountry(String)"})
  void testWithCountry3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithCountryResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withCountry("42");

    // Assert
    assertEquals("1.0.2", actualWithCountryResult.operatingSystemVersion());
    assertEquals("42", actualWithCountryResult.country());
    assertEquals("Location", actualWithCountryResult.location());
    assertEquals("Operating System", actualWithCountryResult.operatingSystem());
    assertEquals("Provenance", actualWithCountryResult.provenance());
    assertEquals("localhost", actualWithCountryResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithCountryResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithCountryResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithCountryResult.lifecycleStatus());
    assertFalse(actualWithCountryResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withCountry(String)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withCountry(String)}
   */
  @Test
  @DisplayName("Test withCountry(String); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withCountry(String)"})
  void testWithCountry_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithCountryResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withCountry("42");

    // Assert
    assertEquals("1.0.2", actualWithCountryResult.operatingSystemVersion());
    assertEquals("42", actualWithCountryResult.country());
    assertEquals("Location", actualWithCountryResult.location());
    assertEquals("Operating System", actualWithCountryResult.operatingSystem());
    assertEquals("Provenance", actualWithCountryResult.provenance());
    assertEquals("localhost", actualWithCountryResult.hostname());
    assertNull(actualWithCountryResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithCountryResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithCountryResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithCountryResult.lifecycleStatus());
    assertFalse(actualWithCountryResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        immutableServerInformation.withExternalId(optional);

    // Assert
    assertSame(immutableServerInformation, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional2() {
    // Arrange
    Builder externalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("External Id");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        immutableServerInformation.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithExternalIdResult.country());
    assertEquals("Location", actualWithExternalIdResult.location());
    assertEquals("Operating System", actualWithExternalIdResult.operatingSystem());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("localhost", actualWithExternalIdResult.hostname());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
    assertFalse(actualWithExternalIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional3() {
    // Arrange
    Builder externalIdResult =
        ImmutableServerInformation.builder().country("GB").externalId("External Id");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        immutableServerInformation.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithExternalIdResult.country());
    assertEquals("Location", actualWithExternalIdResult.location());
    assertEquals("Operating System", actualWithExternalIdResult.operatingSystem());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("localhost", actualWithExternalIdResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
    assertFalse(actualWithExternalIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("External Id")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        immutableServerInformation.withExternalId(optional);

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithExternalIdResult.country());
    assertEquals("Location", actualWithExternalIdResult.location());
    assertEquals("Operating System", actualWithExternalIdResult.operatingSystem());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("localhost", actualWithExternalIdResult.hostname());
    assertNull(actualWithExternalIdResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
    assertFalse(actualWithExternalIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithExternalIdResult.country());
    assertEquals("Location", actualWithExternalIdResult.location());
    assertEquals("Operating System", actualWithExternalIdResult.operatingSystem());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("localhost", actualWithExternalIdResult.hostname());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
    assertFalse(actualWithExternalIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithExternalIdResult.country());
    assertEquals("Location", actualWithExternalIdResult.location());
    assertEquals("Operating System", actualWithExternalIdResult.operatingSystem());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("localhost", actualWithExternalIdResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
    assertFalse(actualWithExternalIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        immutableServerInformation.withExternalId("42");

    // Assert
    assertSame(immutableServerInformation, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithExternalIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("1.0.2", actualWithExternalIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithExternalIdResult.country());
    assertEquals("Location", actualWithExternalIdResult.location());
    assertEquals("Operating System", actualWithExternalIdResult.operatingSystem());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals("localhost", actualWithExternalIdResult.hostname());
    assertNull(actualWithExternalIdResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithExternalIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithExternalIdResult.lifecycleStatus());
    assertFalse(actualWithExternalIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withHardwareEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHardwareEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withHardwareEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withHardwareEndOfLifeDate(Date)"
  })
  void testWithHardwareEndOfLifeDate() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithHardwareEndOfLifeDateResult =
        immutableServerInformation.withHardwareEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableServerInformation, actualWithHardwareEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withHardwareEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHardwareEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withHardwareEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withHardwareEndOfLifeDate(Date)"
  })
  void testWithHardwareEndOfLifeDate2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithHardwareEndOfLifeDateResult =
        immutableServerInformation.withHardwareEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableServerInformation, actualWithHardwareEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withHardwareEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHardwareEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withHardwareEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withHardwareEndOfLifeDate(Date)"
  })
  void testWithHardwareEndOfLifeDate3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");
    ImmutableServerInformation immutableServerInformation =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System")
            .operatingSystemEndOfLifeDate(null)
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithHardwareEndOfLifeDateResult =
        immutableServerInformation.withHardwareEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableServerInformation, actualWithHardwareEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withHostname(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHostname(String)}
   */
  @Test
  @DisplayName("Test withHostname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withHostname(String)"})
  void testWithHostname() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithHostnameResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withHostname("42");

    // Assert
    assertEquals("1.0.2", actualWithHostnameResult.operatingSystemVersion());
    assertEquals("42", actualWithHostnameResult.hostname());
    assertEquals("GB", actualWithHostnameResult.country());
    assertEquals("Location", actualWithHostnameResult.location());
    assertEquals("Operating System", actualWithHostnameResult.operatingSystem());
    assertEquals("Provenance", actualWithHostnameResult.provenance());
    assertEquals(EntityKind.ALL, actualWithHostnameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithHostnameResult.lifecycleStatus());
    assertFalse(actualWithHostnameResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withHostname(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHostname(String)}
   */
  @Test
  @DisplayName("Test withHostname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withHostname(String)"})
  void testWithHostname2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithHostnameResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withHostname("42");

    // Assert
    assertEquals("1.0.2", actualWithHostnameResult.operatingSystemVersion());
    assertEquals("42", actualWithHostnameResult.hostname());
    assertEquals("GB", actualWithHostnameResult.country());
    assertEquals("Location", actualWithHostnameResult.location());
    assertEquals("Operating System", actualWithHostnameResult.operatingSystem());
    assertEquals("Provenance", actualWithHostnameResult.provenance());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithHostnameResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithHostnameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithHostnameResult.lifecycleStatus());
    assertFalse(actualWithHostnameResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withHostname(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHostname(String)}
   */
  @Test
  @DisplayName("Test withHostname(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withHostname(String)"})
  void testWithHostname3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithHostnameResult =
        immutableServerInformation.withHostname("42");

    // Assert
    assertSame(immutableServerInformation, actualWithHostnameResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withHostname(String)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withHostname(String)}
   */
  @Test
  @DisplayName("Test withHostname(String); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withHostname(String)"})
  void testWithHostname_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithHostnameResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withHostname("42");

    // Assert
    assertEquals("1.0.2", actualWithHostnameResult.operatingSystemVersion());
    assertEquals("42", actualWithHostnameResult.hostname());
    assertEquals("GB", actualWithHostnameResult.country());
    assertEquals("Location", actualWithHostnameResult.location());
    assertEquals("Operating System", actualWithHostnameResult.operatingSystem());
    assertEquals("Provenance", actualWithHostnameResult.provenance());
    assertNull(actualWithHostnameResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithHostnameResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithHostnameResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithHostnameResult.lifecycleStatus());
    assertFalse(actualWithHostnameResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableServerInformation actualWithIdResult = immutableServerInformation.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithIdResult.country());
    assertEquals("Location", actualWithIdResult.location());
    assertEquals("Operating System", actualWithIdResult.operatingSystem());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("localhost", actualWithIdResult.hostname());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
    assertFalse(actualWithIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(Optional)"})
  void testWithIdWithOptional2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableServerInformation actualWithIdResult = immutableServerInformation.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithIdResult.country());
    assertEquals("Location", actualWithIdResult.location());
    assertEquals("Operating System", actualWithIdResult.operatingSystem());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("localhost", actualWithIdResult.hostname());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
    assertFalse(actualWithIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(Optional)"})
  void testWithIdWithOptional3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableServerInformation actualWithIdResult = immutableServerInformation.withId(optional);

    // Assert
    assertSame(immutableServerInformation, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(Optional)"})
  void testWithIdWithOptional_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableServerInformation actualWithIdResult = immutableServerInformation.withId(optional);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithIdResult.country());
    assertEquals("Location", actualWithIdResult.location());
    assertEquals("Operating System", actualWithIdResult.operatingSystem());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("localhost", actualWithIdResult.hostname());
    assertNull(actualWithIdResult.hardwareEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
    assertFalse(actualWithIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithIdResult.country());
    assertEquals("Location", actualWithIdResult.location());
    assertEquals("Operating System", actualWithIdResult.operatingSystem());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("localhost", actualWithIdResult.hostname());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
    assertFalse(actualWithIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(long)"})
  void testWithIdWithValue2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithIdResult.country());
    assertEquals("Location", actualWithIdResult.location());
    assertEquals("Operating System", actualWithIdResult.operatingSystem());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("localhost", actualWithIdResult.hostname());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
    assertFalse(actualWithIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(long)"})
  void testWithIdWithValue3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithIdResult = immutableServerInformation.withId(1L);

    // Assert
    assertSame(immutableServerInformation, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withId(long)"})
  void testWithIdWithValue_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithIdResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withId(42L);

    // Assert
    assertEquals("1.0.2", actualWithIdResult.operatingSystemVersion());
    assertEquals("GB", actualWithIdResult.country());
    assertEquals("Location", actualWithIdResult.location());
    assertEquals("Operating System", actualWithIdResult.operatingSystem());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("localhost", actualWithIdResult.hostname());
    assertNull(actualWithIdResult.hardwareEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithIdResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithIdResult.lifecycleStatus());
    assertFalse(actualWithIdResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithKindResult =
        immutableServerInformation.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableServerInformation, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withKind(EntityKind)"})
  void testWithKind2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithKindResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.operatingSystemVersion());
    assertEquals("GB", actualWithKindResult.country());
    assertEquals("Location", actualWithKindResult.location());
    assertEquals("Operating System", actualWithKindResult.operatingSystem());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("localhost", actualWithKindResult.hostname());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithKindResult.lifecycleStatus());
    assertFalse(actualWithKindResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withKind(EntityKind)"})
  void testWithKind3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithKindResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.operatingSystemVersion());
    assertEquals("GB", actualWithKindResult.country());
    assertEquals("Location", actualWithKindResult.location());
    assertEquals("Operating System", actualWithKindResult.operatingSystem());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("localhost", actualWithKindResult.hostname());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithKindResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithKindResult.lifecycleStatus());
    assertFalse(actualWithKindResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withKind(EntityKind)"})
  void testWithKind_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithKindResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("1.0.2", actualWithKindResult.operatingSystemVersion());
    assertEquals("GB", actualWithKindResult.country());
    assertEquals("Location", actualWithKindResult.location());
    assertEquals("Operating System", actualWithKindResult.operatingSystem());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("localhost", actualWithKindResult.hostname());
    assertNull(actualWithKindResult.hardwareEndOfLifeDate());
    assertEquals(EndOfLifeStatus.NOT_END_OF_LIFE, actualWithKindResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithKindResult.lifecycleStatus());
    assertFalse(actualWithKindResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithLifecycleStatusResult =
        immutableServerInformation.withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableServerInformation, actualWithLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithLifecycleStatusResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertEquals("1.0.2", actualWithLifecycleStatusResult.operatingSystemVersion());
    assertEquals("GB", actualWithLifecycleStatusResult.country());
    assertEquals("Location", actualWithLifecycleStatusResult.location());
    assertEquals("Operating System", actualWithLifecycleStatusResult.operatingSystem());
    assertEquals("Provenance", actualWithLifecycleStatusResult.provenance());
    assertEquals("localhost", actualWithLifecycleStatusResult.hostname());
    assertEquals(EntityKind.ALL, actualWithLifecycleStatusResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLifecycleStatusResult.lifecycleStatus());
    assertFalse(actualWithLifecycleStatusResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName("Test withLifecycleStatus(LifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithLifecycleStatusResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertEquals("1.0.2", actualWithLifecycleStatusResult.operatingSystemVersion());
    assertEquals("GB", actualWithLifecycleStatusResult.country());
    assertEquals("Location", actualWithLifecycleStatusResult.location());
    assertEquals("Operating System", actualWithLifecycleStatusResult.operatingSystem());
    assertEquals("Provenance", actualWithLifecycleStatusResult.provenance());
    assertEquals("localhost", actualWithLifecycleStatusResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithLifecycleStatusResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithLifecycleStatusResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLifecycleStatusResult.lifecycleStatus());
    assertFalse(actualWithLifecycleStatusResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLifecycleStatus(LifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test withLifecycleStatus(LifecycleStatus); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withLifecycleStatus(LifecycleStatus)"
  })
  void testWithLifecycleStatus_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.BUILDING)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithLifecycleStatusResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withLifecycleStatus(LifecycleStatus.ACTIVE);

    // Assert
    assertEquals("1.0.2", actualWithLifecycleStatusResult.operatingSystemVersion());
    assertEquals("GB", actualWithLifecycleStatusResult.country());
    assertEquals("Location", actualWithLifecycleStatusResult.location());
    assertEquals("Operating System", actualWithLifecycleStatusResult.operatingSystem());
    assertEquals("Provenance", actualWithLifecycleStatusResult.provenance());
    assertEquals("localhost", actualWithLifecycleStatusResult.hostname());
    assertNull(actualWithLifecycleStatusResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithLifecycleStatusResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithLifecycleStatusResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLifecycleStatusResult.lifecycleStatus());
    assertFalse(actualWithLifecycleStatusResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withLocation(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLocation(String)}
   */
  @Test
  @DisplayName("Test withLocation(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withLocation(String)"})
  void testWithLocation() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithLocationResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withLocation("42");

    // Assert
    assertEquals("1.0.2", actualWithLocationResult.operatingSystemVersion());
    assertEquals("42", actualWithLocationResult.location());
    assertEquals("GB", actualWithLocationResult.country());
    assertEquals("Operating System", actualWithLocationResult.operatingSystem());
    assertEquals("Provenance", actualWithLocationResult.provenance());
    assertEquals("localhost", actualWithLocationResult.hostname());
    assertEquals(EntityKind.ALL, actualWithLocationResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLocationResult.lifecycleStatus());
    assertFalse(actualWithLocationResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withLocation(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLocation(String)}
   */
  @Test
  @DisplayName("Test withLocation(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withLocation(String)"})
  void testWithLocation2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithLocationResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withLocation("42");

    // Assert
    assertEquals("1.0.2", actualWithLocationResult.operatingSystemVersion());
    assertEquals("42", actualWithLocationResult.location());
    assertEquals("GB", actualWithLocationResult.country());
    assertEquals("Operating System", actualWithLocationResult.operatingSystem());
    assertEquals("Provenance", actualWithLocationResult.provenance());
    assertEquals("localhost", actualWithLocationResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithLocationResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithLocationResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLocationResult.lifecycleStatus());
    assertFalse(actualWithLocationResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withLocation(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLocation(String)}
   */
  @Test
  @DisplayName("Test withLocation(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withLocation(String)"})
  void testWithLocation3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("42")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithLocationResult =
        immutableServerInformation.withLocation("42");

    // Assert
    assertSame(immutableServerInformation, actualWithLocationResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withLocation(String)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withLocation(String)}
   */
  @Test
  @DisplayName("Test withLocation(String); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withLocation(String)"})
  void testWithLocation_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithLocationResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withLocation("42");

    // Assert
    assertEquals("1.0.2", actualWithLocationResult.operatingSystemVersion());
    assertEquals("42", actualWithLocationResult.location());
    assertEquals("GB", actualWithLocationResult.country());
    assertEquals("Operating System", actualWithLocationResult.operatingSystem());
    assertEquals("Provenance", actualWithLocationResult.provenance());
    assertEquals("localhost", actualWithLocationResult.hostname());
    assertNull(actualWithLocationResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithLocationResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithLocationResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithLocationResult.lifecycleStatus());
    assertFalse(actualWithLocationResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystem(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystem(String)"
  })
  void testWithOperatingSystem() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithOperatingSystemResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withOperatingSystem("42");

    // Assert
    assertEquals("1.0.2", actualWithOperatingSystemResult.operatingSystemVersion());
    assertEquals("42", actualWithOperatingSystemResult.operatingSystem());
    assertEquals("GB", actualWithOperatingSystemResult.country());
    assertEquals("Location", actualWithOperatingSystemResult.location());
    assertEquals("Provenance", actualWithOperatingSystemResult.provenance());
    assertEquals("localhost", actualWithOperatingSystemResult.hostname());
    assertEquals(EntityKind.ALL, actualWithOperatingSystemResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithOperatingSystemResult.lifecycleStatus());
    assertFalse(actualWithOperatingSystemResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystem(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystem(String)"
  })
  void testWithOperatingSystem2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithOperatingSystemResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withOperatingSystem("42");

    // Assert
    assertEquals("1.0.2", actualWithOperatingSystemResult.operatingSystemVersion());
    assertEquals("42", actualWithOperatingSystemResult.operatingSystem());
    assertEquals("GB", actualWithOperatingSystemResult.country());
    assertEquals("Location", actualWithOperatingSystemResult.location());
    assertEquals("Provenance", actualWithOperatingSystemResult.provenance());
    assertEquals("localhost", actualWithOperatingSystemResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithOperatingSystemResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithOperatingSystemResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithOperatingSystemResult.lifecycleStatus());
    assertFalse(actualWithOperatingSystemResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystem(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystem(String)"
  })
  void testWithOperatingSystem3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("42");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithOperatingSystemResult =
        immutableServerInformation.withOperatingSystem("42");

    // Assert
    assertSame(immutableServerInformation, actualWithOperatingSystemResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withOperatingSystemEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemEndOfLifeDate(Date)"
  })
  void testWithOperatingSystemEndOfLifeDate() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithOperatingSystemEndOfLifeDateResult =
        immutableServerInformation.withOperatingSystemEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableServerInformation, actualWithOperatingSystemEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withOperatingSystemEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemEndOfLifeDate(Date)"
  })
  void testWithOperatingSystemEndOfLifeDate2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithOperatingSystemEndOfLifeDateResult =
        immutableServerInformation.withOperatingSystemEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableServerInformation, actualWithOperatingSystemEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemEndOfLifeDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemEndOfLifeDate(Date)}
   */
  @Test
  @DisplayName("Test withOperatingSystemEndOfLifeDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemEndOfLifeDate(Date)"
  })
  void testWithOperatingSystemEndOfLifeDate3() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithOperatingSystemEndOfLifeDateResult =
        immutableServerInformation.withOperatingSystemEndOfLifeDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableServerInformation, actualWithOperatingSystemEndOfLifeDateResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemVersion(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystemVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemVersion(String)"
  })
  void testWithOperatingSystemVersion() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithOperatingSystemVersionResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withOperatingSystemVersion("42");

    // Assert
    assertEquals("42", actualWithOperatingSystemVersionResult.operatingSystemVersion());
    assertEquals("GB", actualWithOperatingSystemVersionResult.country());
    assertEquals("Location", actualWithOperatingSystemVersionResult.location());
    assertEquals("Operating System", actualWithOperatingSystemVersionResult.operatingSystem());
    assertEquals("Provenance", actualWithOperatingSystemVersionResult.provenance());
    assertEquals("localhost", actualWithOperatingSystemVersionResult.hostname());
    assertEquals(EntityKind.ALL, actualWithOperatingSystemVersionResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithOperatingSystemVersionResult.lifecycleStatus());
    assertFalse(actualWithOperatingSystemVersionResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemVersion(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystemVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemVersion(String)"
  })
  void testWithOperatingSystemVersion2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithOperatingSystemVersionResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withOperatingSystemVersion("42");

    // Assert
    assertEquals("42", actualWithOperatingSystemVersionResult.operatingSystemVersion());
    assertEquals("GB", actualWithOperatingSystemVersionResult.country());
    assertEquals("Location", actualWithOperatingSystemVersionResult.location());
    assertEquals("Operating System", actualWithOperatingSystemVersionResult.operatingSystem());
    assertEquals("Provenance", actualWithOperatingSystemVersionResult.provenance());
    assertEquals("localhost", actualWithOperatingSystemVersionResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE,
        actualWithOperatingSystemVersionResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithOperatingSystemVersionResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithOperatingSystemVersionResult.lifecycleStatus());
    assertFalse(actualWithOperatingSystemVersionResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemVersion(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystemVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemVersion(String)"
  })
  void testWithOperatingSystemVersion3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("42")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithOperatingSystemVersionResult =
        immutableServerInformation.withOperatingSystemVersion("42");

    // Assert
    assertSame(immutableServerInformation, actualWithOperatingSystemVersionResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystemVersion(String)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystemVersion(String)}
   */
  @Test
  @DisplayName(
      "Test withOperatingSystemVersion(String); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystemVersion(String)"
  })
  void testWithOperatingSystemVersion_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithOperatingSystemVersionResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withOperatingSystemVersion("42");

    // Assert
    assertEquals("42", actualWithOperatingSystemVersionResult.operatingSystemVersion());
    assertEquals("GB", actualWithOperatingSystemVersionResult.country());
    assertEquals("Location", actualWithOperatingSystemVersionResult.location());
    assertEquals("Operating System", actualWithOperatingSystemVersionResult.operatingSystem());
    assertEquals("Provenance", actualWithOperatingSystemVersionResult.provenance());
    assertEquals("localhost", actualWithOperatingSystemVersionResult.hostname());
    assertNull(actualWithOperatingSystemVersionResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE,
        actualWithOperatingSystemVersionResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithOperatingSystemVersionResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithOperatingSystemVersionResult.lifecycleStatus());
    assertFalse(actualWithOperatingSystemVersionResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withOperatingSystem(String)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withOperatingSystem(String)"
  })
  void testWithOperatingSystem_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithOperatingSystemResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withOperatingSystem("42");

    // Assert
    assertEquals("1.0.2", actualWithOperatingSystemResult.operatingSystemVersion());
    assertEquals("42", actualWithOperatingSystemResult.operatingSystem());
    assertEquals("GB", actualWithOperatingSystemResult.country());
    assertEquals("Location", actualWithOperatingSystemResult.location());
    assertEquals("Provenance", actualWithOperatingSystemResult.provenance());
    assertEquals("localhost", actualWithOperatingSystemResult.hostname());
    assertNull(actualWithOperatingSystemResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithOperatingSystemResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithOperatingSystemResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithOperatingSystemResult.lifecycleStatus());
    assertFalse(actualWithOperatingSystemResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithProvenanceResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.operatingSystemVersion());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("GB", actualWithProvenanceResult.country());
    assertEquals("Location", actualWithProvenanceResult.location());
    assertEquals("Operating System", actualWithProvenanceResult.operatingSystem());
    assertEquals("localhost", actualWithProvenanceResult.hostname());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithProvenanceResult.lifecycleStatus());
    assertFalse(actualWithProvenanceResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withProvenance(String)"
  })
  void testWithProvenance2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithProvenanceResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.operatingSystemVersion());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("GB", actualWithProvenanceResult.country());
    assertEquals("Location", actualWithProvenanceResult.location());
    assertEquals("Operating System", actualWithProvenanceResult.operatingSystem());
    assertEquals("localhost", actualWithProvenanceResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithProvenanceResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithProvenanceResult.lifecycleStatus());
    assertFalse(actualWithProvenanceResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withProvenance(String)"
  })
  void testWithProvenance3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("42")
            .build();

    // Act
    ImmutableServerInformation actualWithProvenanceResult =
        immutableServerInformation.withProvenance("42");

    // Assert
    assertSame(immutableServerInformation, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableServerInformation ImmutableServerInformation.withProvenance(String)"
  })
  void testWithProvenance_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithProvenanceResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("1.0.2", actualWithProvenanceResult.operatingSystemVersion());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("GB", actualWithProvenanceResult.country());
    assertEquals("Location", actualWithProvenanceResult.location());
    assertEquals("Operating System", actualWithProvenanceResult.operatingSystem());
    assertEquals("localhost", actualWithProvenanceResult.hostname());
    assertNull(actualWithProvenanceResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithProvenanceResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithProvenanceResult.lifecycleStatus());
    assertFalse(actualWithProvenanceResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withVirtual(boolean)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withVirtual(boolean)}
   */
  @Test
  @DisplayName("Test withVirtual(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withVirtual(boolean)"})
  void testWithVirtual() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithVirtualResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withVirtual(true);

    // Assert
    assertEquals("1.0.2", actualWithVirtualResult.operatingSystemVersion());
    assertEquals("GB", actualWithVirtualResult.country());
    assertEquals("Location", actualWithVirtualResult.location());
    assertEquals("Operating System", actualWithVirtualResult.operatingSystem());
    assertEquals("Provenance", actualWithVirtualResult.provenance());
    assertEquals("localhost", actualWithVirtualResult.hostname());
    assertEquals(EntityKind.ALL, actualWithVirtualResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithVirtualResult.lifecycleStatus());
    assertTrue(actualWithVirtualResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withVirtual(boolean)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withVirtual(boolean)}
   */
  @Test
  @DisplayName("Test withVirtual(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withVirtual(boolean)"})
  void testWithVirtual2() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithVirtualResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withVirtual(true);

    // Assert
    assertEquals("1.0.2", actualWithVirtualResult.operatingSystemVersion());
    assertEquals("GB", actualWithVirtualResult.country());
    assertEquals("Location", actualWithVirtualResult.location());
    assertEquals("Operating System", actualWithVirtualResult.operatingSystem());
    assertEquals("Provenance", actualWithVirtualResult.provenance());
    assertEquals("localhost", actualWithVirtualResult.hostname());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithVirtualResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithVirtualResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithVirtualResult.lifecycleStatus());
    assertTrue(actualWithVirtualResult.virtual());
  }

  /**
   * Test {@link ImmutableServerInformation#withVirtual(boolean)}.
   *
   * <p>Method under test: {@link ImmutableServerInformation#withVirtual(boolean)}
   */
  @Test
  @DisplayName("Test withVirtual(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withVirtual(boolean)"})
  void testWithVirtual3() {
    // Arrange
    Builder externalIdResult = ImmutableServerInformation.builder().country("GB").externalId("42");

    Builder operatingSystemResult =
        externalIdResult
            .hardwareEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");
    ImmutableServerInformation immutableServerInformation =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableServerInformation actualWithVirtualResult =
        immutableServerInformation.withVirtual(false);

    // Assert
    assertSame(immutableServerInformation, actualWithVirtualResult);
  }

  /**
   * Test {@link ImmutableServerInformation#withVirtual(boolean)}.
   *
   * <ul>
   *   <li>Then return hardwareEndOfLifeDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableServerInformation#withVirtual(boolean)}
   */
  @Test
  @DisplayName("Test withVirtual(boolean); then return hardwareEndOfLifeDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableServerInformation ImmutableServerInformation.withVirtual(boolean)"})
  void testWithVirtual_thenReturnHardwareEndOfLifeDateIsNull() {
    // Arrange
    Builder operatingSystemResult =
        ImmutableServerInformation.builder()
            .country("GB")
            .externalId("42")
            .hardwareEndOfLifeDate(null)
            .hostname("localhost")
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecycleStatus(LifecycleStatus.ACTIVE)
            .location("Location")
            .operatingSystem("Operating System");

    // Act
    ImmutableServerInformation actualWithVirtualResult =
        operatingSystemResult
            .operatingSystemEndOfLifeDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .operatingSystemVersion("1.0.2")
            .provenance("Provenance")
            .build()
            .withVirtual(true);

    // Assert
    assertEquals("1.0.2", actualWithVirtualResult.operatingSystemVersion());
    assertEquals("GB", actualWithVirtualResult.country());
    assertEquals("Location", actualWithVirtualResult.location());
    assertEquals("Operating System", actualWithVirtualResult.operatingSystem());
    assertEquals("Provenance", actualWithVirtualResult.provenance());
    assertEquals("localhost", actualWithVirtualResult.hostname());
    assertNull(actualWithVirtualResult.hardwareEndOfLifeDate());
    assertEquals(
        EndOfLifeStatus.NOT_END_OF_LIFE, actualWithVirtualResult.hardwareEndOfLifeStatus());
    assertEquals(EntityKind.ALL, actualWithVirtualResult.kind());
    assertEquals(LifecycleStatus.ACTIVE, actualWithVirtualResult.lifecycleStatus());
    assertTrue(actualWithVirtualResult.virtual());
  }
}
