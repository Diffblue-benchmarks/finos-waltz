package org.finos.waltz.model.licence;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.LastUpdatedUserTimestampProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableAggregateOverlayDiagram;
import org.finos.waltz.model.aggregate_overlay_diagram.OverlayDiagramKind;
import org.finos.waltz.model.licence.ImmutableLicence.Builder;
import org.finos.waltz.model.licence.ImmutableLicence.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLicenceDiffblueTest {
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
   *   <li>{@link Builder#lastUpdated(UserTimestamp)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLicence Builder.build()",
    "Builder Builder.created(UserTimestamp)",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.lastUpdated(UserTimestamp)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableLicence.builder();
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
    Builder actualIdResult2 = actualIdResult.id(id);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    Builder actualLastUpdatedResult = actualIdResult2.lastUpdated(lastUpdated);
    ImmutableLicence actualImmutableLicence =
        actualLastUpdatedResult
            .lastUpdated(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .name("Name")
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("Name", actualImmutableLicence.name());
    assertEquals("Provenance", actualImmutableLicence.provenance());
    assertEquals(
        "The characteristics of someone or something", actualImmutableLicence.description());
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
    Builder builderResult = ImmutableLicence.builder();
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
    Builder builderResult = ImmutableLicence.builder();
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((CreatedUserTimestampProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedUserTimestampProvider)} with {@code
   * LastUpdatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedUserTimestampProvider) with 'LastUpdatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedUserTimestampProvider)"})
  void testBuilderFromWithLastUpdatedUserTimestampProvider() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((LastUpdatedUserTimestampProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedUserTimestampProvider)} with {@code
   * LastUpdatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedUserTimestampProvider) with 'LastUpdatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedUserTimestampProvider)"})
  void testBuilderFromWithLastUpdatedUserTimestampProvider2() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    LastUpdatedUserTimestampProvider instance = mock(LastUpdatedUserTimestampProvider.class);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> ofResult = Optional.of(immutableUserTimestamp);
    when(instance.lastUpdated()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdated();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedUserTimestampProvider)} with {@code
   * LastUpdatedUserTimestampProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedUserTimestampProvider) with 'LastUpdatedUserTimestampProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedUserTimestampProvider)"})
  void testBuilderFromWithLastUpdatedUserTimestampProvider3() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    LastUpdatedUserTimestampProvider instance = mock(LastUpdatedUserTimestampProvider.class);
    when(instance.lastUpdated()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdated();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedUserTimestampProvider)} with {@code
   * LastUpdatedUserTimestampProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedUserTimestampProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedUserTimestampProvider) with 'LastUpdatedUserTimestampProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedUserTimestampProvider)"})
  void testBuilderFromWithLastUpdatedUserTimestampProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    LastUpdatedUserTimestampProvider instance = mock(LastUpdatedUserTimestampProvider.class);
    Optional<UserTimestamp> emptyResult = Optional.empty();
    when(instance.lastUpdated()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdated();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Licence)} with {@code Licence}.
   *
   * <p>Method under test: {@link Builder#from(Licence)}
   */
  @Test
  @DisplayName("Test Builder from(Licence) with 'Licence'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Licence)"})
  void testBuilderFromWithLicence() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Licence)} with {@code Licence}.
   *
   * <p>Method under test: {@link Builder#from(Licence)}
   */
  @Test
  @DisplayName("Test Builder from(Licence) with 'Licence'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Licence)"})
  void testBuilderFromWithLicence2() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Licence)} with {@code Licence}.
   *
   * <p>Method under test: {@link Builder#from(Licence)}
   */
  @Test
  @DisplayName("Test Builder from(Licence) with 'Licence'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Licence)"})
  void testBuilderFromWithLicence3() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult = builderResult2.created(created).description(null).externalId("42").id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(Licence)} with {@code Licence}.
   *
   * <p>Method under test: {@link Builder#from(Licence)}
   */
  @Test
  @DisplayName("Test Builder from(Licence) with 'Licence'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Licence)"})
  void testBuilderFromWithLicence4() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdated = Optional.empty();
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult = builderResult2.created(created).description(null).externalId("42").id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdated = Optional.empty();
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableLicence immutableLicence = builderResult.build();
    assertEquals("Name", immutableLicence.name());
    assertEquals("waltz", immutableLicence.provenance());
    assertNull(immutableLicence.description());
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
    Builder builderResult = ImmutableLicence.builder();

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
    ImmutableLicence immutableLicence = builderResult.build();
    assertEquals("Name", immutableLicence.name());
    assertEquals("Provenance", immutableLicence.provenance());
    assertEquals("The characteristics of someone or something", immutableLicence.description());
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

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
    ImmutableLicence immutableLicence = builderResult.build();
    assertEquals("Name", immutableLicence.name());
    assertEquals("Provenance", immutableLicence.provenance());
    assertEquals("The characteristics of someone or something", immutableLicence.description());
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult = builderResult2.created(created).description(null).externalId("42").id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdated = Optional.empty();
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    Builder actualFromResult = builderResult.from((ProvenanceProvider) instance);

    // Assert
    ImmutableLicence actualImmutableLicence = builderResult.build();
    assertEquals(instance, actualImmutableLicence);
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
    Builder builderResult = ImmutableLicence.builder();

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
    ImmutableLicence immutableLicence = builderResult.build();
    assertEquals("Name", immutableLicence.name());
    assertEquals("Provenance", immutableLicence.provenance());
    assertNull(immutableLicence.description());
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
    Builder builderResult = ImmutableLicence.builder();

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
    Builder builderResult = ImmutableLicence.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdated(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#lastUpdated(Optional)}
   */
  @Test
  @DisplayName("Test Builder lastUpdated(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdated(Optional)"})
  void testBuilderLastUpdatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp);

    // Act
    Builder actualLastUpdatedResult = builderResult.lastUpdated(lastUpdated);

    // Assert
    assertSame(builderResult, actualLastUpdatedResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableLicence immutableLicence = builderResult.build();
    assertEquals("Name", immutableLicence.name());
    assertEquals("waltz", immutableLicence.provenance());
    assertNull(immutableLicence.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableLicence#copyOf(Licence)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#copyOf(Licence)}
   */
  @Test
  @DisplayName("Test copyOf(Licence); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.copyOf(Licence)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence instance =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualCopyOfResult = ImmutableLicence.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableLicence#created()}.
   *
   * <p>Method under test: {@link ImmutableLicence#created()}
   */
  @Test
  @DisplayName("Test created()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLicence.created()"})
  void testCreated() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertEquals(
        created,
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build().created());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}, and {@link ImmutableLicence#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLicence#equals(Object)}
   *   <li>{@link ImmutableLicence#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);
    ImmutableLicence immutableLicence2 =
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build();

    // Act and Assert
    assertEquals(immutableLicence, immutableLicence2);
    assertEquals(immutableLicence.hashCode(), immutableLicence2.hashCode());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}, and {@link ImmutableLicence#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLicence#equals(Object)}
   *   <li>{@link ImmutableLicence#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act and Assert
    assertEquals(immutableLicence, immutableLicence);
    int expectedHashCodeResult = immutableLicence.hashCode();
    assertEquals(expectedHashCodeResult, immutableLicence.hashCode());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);

    // Act and Assert
    assertNotEquals(
        immutableLicence,
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);

    // Act and Assert
    assertNotEquals(
        immutableLicence,
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);

    // Act and Assert
    assertNotEquals(
        immutableLicence,
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);

    // Act and Assert
    assertNotEquals(
        immutableLicence,
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("By").provenance("Provenance").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);

    // Act and Assert
    assertNotEquals(
        immutableLicence,
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Name").build();

    Builder builderResult2 = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp3);

    Builder idResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp4 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated2 = Optional.of(immutableUserTimestamp4);

    // Act and Assert
    assertNotEquals(
        immutableLicence,
        idResult2.lastUpdated(lastUpdated2).name("Name").provenance("Provenance").build());
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build(), null);
  }

  /**
   * Test {@link ImmutableLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableLicence.equals(Object)", "int ImmutableLicence.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertNotEquals(
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build(),
        "Different type to ImmutableLicence");
  }

  /**
   * Test {@link ImmutableLicence#externalId()}.
   *
   * <p>Method under test: {@link ImmutableLicence#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLicence.externalId()"})
  void testExternalId() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act
    Optional<String> actualExternalIdResult =
        idResult
            .lastUpdated(lastUpdated)
            .name("Name")
            .provenance("Provenance")
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setCreated(null);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp);
    json.setLastUpdated(lastUpdated);
    json.setProvenance(null);

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson2() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<UserTimestamp> created = Optional.of(immutableUserTimestamp);
    json.setCreated(created);
    json.setLastUpdated(null);
    json.setProvenance(null);

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId(null);
    json.setCreated(null);
    json.setLastUpdated(null);
    json.setProvenance(null);

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return name is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Name is 'Json'; then return name is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNameIsJson_thenReturnNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setCreated(null);
    json.setLastUpdated(null);
    json.setProvenance(null);

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Provenance is {@code Json}.
   *   <li>Then return provenance is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Provenance is 'Json'; then return provenance is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonProvenanceIsJson_thenReturnProvenanceIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setCreated(null);
    json.setLastUpdated(null);
    json.setProvenance("Json");

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Name is {@code name}.
   *   <li>Then return {@code name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Name is 'name'; then return 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson_givenName_whenJsonNameIsName_thenReturnName() {
    // Arrange
    Json json = new Json();
    json.setName("name");

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test {@link ImmutableLicence#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return name is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return name is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setDescription(null);
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setCreated(null);
    json.setLastUpdated(null);
    json.setProvenance(null);

    // Act
    ImmutableLicence actualFromJsonResult = ImmutableLicence.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("waltz", actualFromJsonResult.provenance());
    assertNull(actualFromJsonResult.description());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLicence#description()}
   *   <li>{@link ImmutableLicence#name()}
   *   <li>{@link ImmutableLicence#provenance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableLicence.description()",
    "String ImmutableLicence.name()",
    "String ImmutableLicence.provenance()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    String actualDescriptionResult = immutableLicence.description();
    String actualNameResult = immutableLicence.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("Provenance", immutableLicence.provenance());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableLicence#id()}.
   *
   * <p>Method under test: {@link ImmutableLicence#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLicence.id()"})
  void testId() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act
    Optional<Long> actualIdResult =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build().id();

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
   * Test Json {@link Json#lastUpdated()}.
   *
   * <p>Method under test: {@link Json#lastUpdated()}
   */
  @Test
  @DisplayName("Test Json lastUpdated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.lastUpdated()"})
  void testJsonLastUpdated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdated());
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
    assertFalse(actualJson.created.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastUpdated.isPresent());
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
   * Test {@link ImmutableLicence#lastUpdated()}.
   *
   * <p>Method under test: {@link ImmutableLicence#lastUpdated()}
   */
  @Test
  @DisplayName("Test lastUpdated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableLicence.lastUpdated()"})
  void testLastUpdated() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertEquals(
        created,
        idResult
            .lastUpdated(lastUpdated)
            .name("Name")
            .provenance("Provenance")
            .build()
            .lastUpdated());
  }

  /**
   * Test {@link ImmutableLicence#toString()}.
   *
   * <p>Method under test: {@link ImmutableLicence#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLicence.toString()"})
  void testToString() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act and Assert
    assertEquals(
        "Licence{id=1, name=Name, externalId=42, created=UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp"
            + "=1970-01-01 00:00:00.0}, lastUpdated=UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp=1970-01-01"
            + " 00:00:00.0}, provenance=Provenance}",
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build().toString());
  }

  /**
   * Test {@link ImmutableLicence#toString()}.
   *
   * <p>Method under test: {@link ImmutableLicence#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLicence.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    Optional<? extends UserTimestamp> created = Optional.empty();

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp);

    // Act and Assert
    assertEquals(
        "Licence{id=1, name=Name, externalId=42, lastUpdated=UserTimestamp{at=1970-01-01T00:00, by=By,"
            + " atTimestamp=1970-01-01 00:00:00.0}, provenance=Provenance}",
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build().toString());
  }

  /**
   * Test {@link ImmutableLicence#toString()}.
   *
   * <p>Method under test: {@link ImmutableLicence#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableLicence.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    Optional<? extends UserTimestamp> lastUpdated = Optional.empty();

    // Act and Assert
    assertEquals(
        "Licence{id=1, name=Name, externalId=42, created=UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp"
            + "=1970-01-01 00:00:00.0}, provenance=Provenance}",
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build().toString());
  }

  /**
   * Test {@link ImmutableLicence#withCreated(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLicence#withCreated(Optional)}
   */
  @Test
  @DisplayName("Test withCreated(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withCreated(Optional)"})
  void testWithCreatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> optional = Optional.of(immutableUserTimestamp3);

    // Act
    ImmutableLicence actualWithCreatedResult = immutableLicence.withCreated(optional);

    // Assert
    assertEquals(immutableLicence, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableLicence#withCreated(UserTimestamp)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLicence#withCreated(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withCreated(UserTimestamp) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withCreated(UserTimestamp)"})
  void testWithCreatedWithValue() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithCreatedResult =
        immutableLicence.withCreated(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableLicence, actualWithCreatedResult);
  }

  /**
   * Test {@link ImmutableLicence#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLicence#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithDescriptionResult = immutableLicence.withDescription("42");

    // Assert
    assertEquals(immutableLicence, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLicence#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableLicence#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult = builderResult.created(created).description("42").externalId("42").id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithDescriptionResult = immutableLicence.withDescription("42");

    // Assert
    assertSame(immutableLicence, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableLicence#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLicence#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableLicence actualWithExternalIdResult = immutableLicence.withExternalId(optional);

    // Assert
    assertSame(immutableLicence, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLicence#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableLicence actualWithExternalIdResult = immutableLicence.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
  }

  /**
   * Test {@link ImmutableLicence#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLicence#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithExternalIdResult = immutableLicence.withExternalId("42");

    // Assert
    assertSame(immutableLicence, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableLicence#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableLicence actualWithExternalIdResult =
        idResult
            .lastUpdated(lastUpdated)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
  }

  /**
   * Test {@link ImmutableLicence#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLicence#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableLicence actualWithIdResult = immutableLicence.withId(optional);

    // Assert
    assertSame(immutableLicence, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLicence#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableLicence actualWithIdResult = immutableLicence.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutableLicence#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLicence#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithIdResult = immutableLicence.withId(1L);

    // Assert
    assertSame(immutableLicence, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableLicence#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableLicence actualWithIdResult =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build().withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
  }

  /**
   * Test {@link ImmutableLicence#withLastUpdated(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableLicence#withLastUpdated(Optional)}
   */
  @Test
  @DisplayName("Test withLastUpdated(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withLastUpdated(Optional)"})
  void testWithLastUpdatedWithOptional() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> optional = Optional.of(immutableUserTimestamp3);

    // Act
    ImmutableLicence actualWithLastUpdatedResult = immutableLicence.withLastUpdated(optional);

    // Assert
    assertEquals(immutableLicence, actualWithLastUpdatedResult);
  }

  /**
   * Test {@link ImmutableLicence#withLastUpdated(UserTimestamp)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableLicence#withLastUpdated(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withLastUpdated(UserTimestamp) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withLastUpdated(UserTimestamp)"})
  void testWithLastUpdatedWithValue() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithLastUpdatedResult =
        immutableLicence.withLastUpdated(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableLicence, actualWithLastUpdatedResult);
  }

  /**
   * Test {@link ImmutableLicence#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableLicence#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withName(String)"})
  void testWithName() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("42").provenance("Provenance").build();

    // Act
    ImmutableLicence actualWithNameResult = immutableLicence.withName("42");

    // Assert
    assertSame(immutableLicence, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableLicence#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableLicence actualWithNameResult =
        idResult
            .lastUpdated(lastUpdated)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
  }

  /**
   * Test {@link ImmutableLicence#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableLicence#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);
    ImmutableLicence immutableLicence =
        idResult.lastUpdated(lastUpdated).name("Name").provenance("42").build();

    // Act
    ImmutableLicence actualWithProvenanceResult = immutableLicence.withProvenance("42");

    // Assert
    assertSame(immutableLicence, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableLicence#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then return provenance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicence#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then return provenance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicence ImmutableLicence.withProvenance(String)"})
  void testWithProvenance_thenReturnProvenanceIs42() {
    // Arrange
    Builder builderResult = ImmutableLicence.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder idResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> lastUpdated = Optional.of(immutableUserTimestamp2);

    // Act
    ImmutableLicence actualWithProvenanceResult =
        idResult
            .lastUpdated(lastUpdated)
            .name("Name")
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
  }
}
