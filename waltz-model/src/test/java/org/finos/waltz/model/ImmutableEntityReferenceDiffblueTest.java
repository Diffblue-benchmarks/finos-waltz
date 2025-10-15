package org.finos.waltz.model;

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
import org.finos.waltz.model.ImmutableEntityReference.Builder;
import org.finos.waltz.model.ImmutableEntityReference.Json;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityReferenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#entityLifecycleStatus(EntityLifecycleStatus)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#name(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReference Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.entityLifecycleStatus(EntityLifecycleStatus)",
    "Builder Builder.externalId(String)",
    "Builder Builder.name(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualNameResult =
        actualExternalIdResult.externalId(externalId).id(1L).kind(EntityKind.ALL).name("Name");
    Optional<String> name = Optional.of("foo");
    ImmutableEntityReference actualImmutableEntityReference = actualNameResult.name(name).build();

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityReference.description());
    assertEquals(1L, actualImmutableEntityReference.id());
    assertEquals(EntityKind.ALL, actualImmutableEntityReference.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE, actualImmutableEntityReference.entityLifecycleStatus());
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
    Builder builderResult = ImmutableEntityReference.builder();
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
    Builder builderResult = ImmutableEntityReference.builder();
    ImmutableEntityReference instance =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableEntityReference actualImmutableEntityReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link DescriptionProvider#description()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then calls description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenCallsDescription() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();
    ImmutableEntityReference instance =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityLifecycleStatusProvider) instance);

    // Assert
    ImmutableEntityReference actualImmutableEntityReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider2() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    // Act
    builderResult.from(
        (EntityLifecycleStatusProvider)
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
    ImmutableEntityReference immutableEntityReference = builderResult.build();
    assertEquals(
        "The characteristics of someone or something", immutableEntityReference.description());
    assertEquals(1L, immutableEntityReference.id());
    assertEquals(EntityKind.ALL, immutableEntityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableEntityReference.entityLifecycleStatus());
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider3() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider4() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    // Act
    builderResult.from(
        (EntityLifecycleStatusProvider)
            ImmutableAppGroupEntry.builder()
                .description(null)
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    ImmutableEntityReference immutableEntityReference = builderResult.build();
    assertNull(immutableEntityReference.description());
    assertEquals(1L, immutableEntityReference.id());
    assertEquals(EntityKind.ALL, immutableEntityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableEntityReference.entityLifecycleStatus());
  }

  /**
   * Test Builder {@link Builder#from(EntityLifecycleStatusProvider)} with {@code
   * EntityLifecycleStatusProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityLifecycleStatusProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityLifecycleStatusProvider) with 'EntityLifecycleStatusProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityLifecycleStatusProvider)"})
  void testBuilderFromWithEntityLifecycleStatusProvider5() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));

    // Act
    Builder actualFromResult =
        builderResult.from(
            (EntityLifecycleStatusProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityReference)} with {@code EntityReference}.
   *
   * <p>Method under test: {@link Builder#from(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReference) with 'EntityReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReference)"})
  void testBuilderFromWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();
    ImmutableEntityReference instance =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityReference actualImmutableEntityReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityReference);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityReference)} with {@code EntityReference}.
   *
   * <p>Method under test: {@link Builder#from(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReference) with 'EntityReference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReference)"})
  void testBuilderFromWithEntityReference2() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    // Act
    builderResult.from(
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
    ImmutableEntityReference immutableEntityReference = builderResult.build();
    assertEquals(
        "The characteristics of someone or something", immutableEntityReference.description());
    assertEquals(1L, immutableEntityReference.id());
    assertEquals(EntityKind.ALL, immutableEntityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableEntityReference.entityLifecycleStatus());
  }

  /**
   * Test Builder {@link Builder#from(EntityReference)} with {@code EntityReference}.
   *
   * <ul>
   *   <li>Then builder build description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityReference) with 'EntityReference'; then builder build description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReference)"})
  void testBuilderFromWithEntityReference_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    // Act
    builderResult.from(
        ImmutableAppGroupEntry.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build());

    // Assert
    ImmutableEntityReference immutableEntityReference = builderResult.build();
    assertNull(immutableEntityReference.description());
    assertEquals(1L, immutableEntityReference.id());
    assertEquals(EntityKind.ALL, immutableEntityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, immutableEntityReference.entityLifecycleStatus());
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
    Builder builderResult = ImmutableEntityReference.builder();
    ImmutableEntityReference instance =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableEntityReference actualImmutableEntityReference = builderResult.build();
    assertEquals(instance, actualImmutableEntityReference);
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
    Builder builderResult = ImmutableEntityReference.builder();

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
    Builder builderResult = ImmutableEntityReference.builder();

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
    Builder builderResult = ImmutableEntityReference.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#id(long)}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();

    // Act
    Builder actualKindResult = builderResult.kind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualKindResult);
  }

  /**
   * Test Builder {@link Builder#name(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#name(Optional)}
   */
  @Test
  @DisplayName("Test Builder name(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(Optional)"})
  void testBuilderNameWithOptional() {
    // Arrange
    Builder builderResult = ImmutableEntityReference.builder();
    Optional<String> name = Optional.of("foo");

    // Act
    Builder actualNameResult = builderResult.name(name);

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableEntityReference#copyOf(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  @DisplayName("Test copyOf(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.copyOf(EntityReference)"})
  void testCopyOf() {
    // Arrange
    ImmutableEntityReference instance =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReference#copyOf(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  @DisplayName("Test copyOf(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.copyOf(EntityReference)"})
  void testCopyOf2() {
    // Arrange
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReference#copyOf(EntityReference)}.
   *
   * <ul>
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#copyOf(EntityReference)}
   */
  @Test
  @DisplayName("Test copyOf(EntityReference); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.copyOf(EntityReference)"})
  void testCopyOf_thenReturnDescriptionIsNull() {
    // Arrange
    ImmutableAppGroupEntry instance =
        ImmutableAppGroupEntry.builder()
            .description(null)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    ImmutableEntityReference actualCopyOfResult = ImmutableEntityReference.copyOf(instance);

    // Assert
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualCopyOfResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}, and {@link
   * ImmutableEntityReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityReference#equals(Object)}
   *   <li>{@link ImmutableEntityReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableEntityReference, immutableEntityReference2);
    assertEquals(immutableEntityReference.hashCode(), immutableEntityReference2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}, and {@link
   * ImmutableEntityReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityReference#equals(Object)}
   *   <li>{@link ImmutableEntityReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableEntityReference, immutableEntityReference);
    int expectedHashCodeResult = immutableEntityReference.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityReference.hashCode());
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityReference,
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReference.equals(Object)",
    "int ImmutableEntityReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Different type to ImmutableEntityReference");
  }

  /**
   * Test {@link ImmutableEntityReference#externalId()}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityReference.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
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
   *   <li>{@link ImmutableEntityReference#toString()}
   *   <li>{@link ImmutableEntityReference#description()}
   *   <li>{@link ImmutableEntityReference#entityLifecycleStatus()}
   *   <li>{@link ImmutableEntityReference#id()}
   *   <li>{@link ImmutableEntityReference#kind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntityReference.description()",
    "EntityLifecycleStatus ImmutableEntityReference.entityLifecycleStatus()",
    "long ImmutableEntityReference.id()",
    "EntityKind ImmutableEntityReference.kind()",
    "String ImmutableEntityReference.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    String actualToStringResult = immutableEntityReference.toString();
    String actualDescriptionResult = immutableEntityReference.description();
    EntityLifecycleStatus actualEntityLifecycleStatusResult =
        immutableEntityReference.entityLifecycleStatus();
    long actualIdResult = immutableEntityReference.id();

    // Assert
    assertEquals(
        "EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}", actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualIdResult);
    assertEquals(EntityKind.ALL, immutableEntityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualEntityLifecycleStatusResult);
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
   * Test Json {@link Json#entityLifecycleStatus()}.
   *
   * <p>Method under test: {@link Json#entityLifecycleStatus()}
   */
  @Test
  @DisplayName("Test Json entityLifecycleStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus Json.entityLifecycleStatus()"})
  void testJsonEntityLifecycleStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityLifecycleStatus());
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
  @MethodsUnderTest({"long Json.id()"})
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
  @MethodsUnderTest({"Optional Json.name()"})
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
    assertNull(actualJson.kind);
    assertNull(actualJson.entityLifecycleStatus);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.name.isPresent());
    assertFalse(actualJson.idIsSet);
  }

  /**
   * Test Json {@link Json#setId(long)}.
   *
   * <p>Method under test: {@link Json#setId(long)}
   */
  @Test
  @DisplayName("Test Json setId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setId(long)"})
  void testJsonSetId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Test {@link ImmutableEntityReference#name()}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#name()}
   */
  @Test
  @DisplayName("Test name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityReference.name()"})
  void testName() {
    // Arrange and Act
    Optional<String> actualNameResult =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .name();

    // Assert
    assertEquals("Name", actualNameResult.get());
    assertTrue(actualNameResult.isPresent());
  }

  /**
   * Test {@link ImmutableEntityReference#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithDescriptionResult =
        immutableEntityReference.withDescription("42");

    // Assert
    assertEquals(immutableEntityReference, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("42")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithDescriptionResult =
        immutableEntityReference.withDescription("42");

    // Assert
    assertSame(immutableEntityReference, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityReference#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReference ImmutableEntityReference.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithEntityLifecycleStatusResult =
        immutableEntityReference.withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertSame(immutableEntityReference, actualWithEntityLifecycleStatusResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withEntityLifecycleStatus(EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityReference#withEntityLifecycleStatus(EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test withEntityLifecycleStatus(EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReference ImmutableEntityReference.withEntityLifecycleStatus(EntityLifecycleStatus)"
  })
  void testWithEntityLifecycleStatus2() {
    // Arrange and Act
    ImmutableEntityReference actualWithEntityLifecycleStatusResult =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withEntityLifecycleStatus(EntityLifecycleStatus.ACTIVE);

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        actualWithEntityLifecycleStatusResult.description());
    assertEquals(1L, actualWithEntityLifecycleStatusResult.id());
    assertEquals(EntityKind.ALL, actualWithEntityLifecycleStatusResult.kind());
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        actualWithEntityLifecycleStatusResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReference#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOf42() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityReference actualWithExternalIdResult =
        immutableEntityReference.withExternalId(optional);

    // Assert
    assertSame(immutableEntityReference, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableEntityReference actualWithExternalIdResult =
        immutableEntityReference.withExternalId(optional);

    // Assert
    assertEquals(immutableEntityReference, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withExternalId(String)"})
  void testWithExternalIdWithValue_when42() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithExternalIdResult =
        immutableEntityReference.withExternalId("42");

    // Assert
    assertSame(immutableEntityReference, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'; when '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithExternalIdResult =
        immutableEntityReference.withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals(immutableEntityReference, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withId(long)}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withId(long)"})
  void testWithId() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(42L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithIdResult = immutableEntityReference.withId(42L);

    // Assert
    assertSame(immutableEntityReference, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withId(long)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withId(long)"})
  void testWithId_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange and Act
    ImmutableEntityReference actualWithIdResult =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(42L, actualWithIdResult.id());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithIdResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReference#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithKindResult =
        immutableEntityReference.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableEntityReference, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReference#withKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(EntityKind); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withKind(EntityKind)"})
  void testWithKind_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange and Act
    ImmutableEntityReference actualWithKindResult =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(1L, actualWithKindResult.id());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualWithKindResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReference#withName(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withName(Optional)}
   */
  @Test
  @DisplayName("Test withName(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withName(Optional)"})
  void testWithNameWithOptional() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableEntityReference actualWithNameResult = immutableEntityReference.withName(optional);

    // Assert
    assertEquals(immutableEntityReference, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withName(String)"})
  void testWithNameWithValue() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableEntityReference actualWithNameResult = immutableEntityReference.withName("42");

    // Assert
    assertEquals(immutableEntityReference, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityReference#withName(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityReference#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityReference ImmutableEntityReference.withName(String)"})
  void testWithNameWithValue2() {
    // Arrange
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .build();

    // Act
    ImmutableEntityReference actualWithNameResult = immutableEntityReference.withName("42");

    // Assert
    assertSame(immutableEntityReference, actualWithNameResult);
  }
}
