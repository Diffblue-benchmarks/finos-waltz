package org.finos.waltz.model.app_group;

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
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.IsRemovedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.app_group.ImmutableAppGroup.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroup.Json;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagram;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupDiffblueTest {
  /**
   * Test Builder {@link Builder#appGroupKind(AppGroupKind)}.
   *
   * <p>Method under test: {@link Builder#appGroupKind(AppGroupKind)}
   */
  @Test
  @DisplayName("Test Builder appGroupKind(AppGroupKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appGroupKind(AppGroupKind)"})
  void testBuilderAppGroupKind() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

    // Act
    Builder actualAppGroupKindResult = builderResult.appGroupKind(AppGroupKind.PUBLIC);

    // Assert
    assertSame(builderResult, actualAppGroupKindResult);
  }

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
    "ImmutableAppGroup Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableAppGroup actualImmutableAppGroup =
        actualIdResult.id(id).kind(EntityKind.ALL).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableAppGroup.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableAppGroup.description());
    assertEquals(EntityKind.ALL, actualImmutableAppGroup.kind());
    assertEquals(AppGroupKind.PUBLIC, actualImmutableAppGroup.appGroupKind());
    assertFalse(actualImmutableAppGroup.isFavouriteGroup());
    assertFalse(actualImmutableAppGroup.isRemoved());
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
    Builder builderResult = ImmutableAppGroup.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroup)} with {@code AppGroup}.
   *
   * <p>Method under test: {@link Builder#from(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroup) with 'AppGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroup)"})
  void testBuilderFromWithAppGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroup)} with {@code AppGroup}.
   *
   * <p>Method under test: {@link Builder#from(AppGroup)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroup) with 'AppGroup'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroup)"})
  void testBuilderFromWithAppGroup2() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IsRemovedProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider2() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

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
            (IsRemovedProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider3() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsRemovedProvider)
                ImmutableFlowDiagram.builder()
                    .description("The characteristics of someone or something")
                    .editorRole("Editor Role")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .layoutData("Layout Data")
                    .name("Name")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider4() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

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
            (IsRemovedProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsRemovedProvider)} with {@code IsRemovedProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsRemovedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsRemovedProvider) with 'IsRemovedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsRemovedProvider)"})
  void testBuilderFromWithIsRemovedProvider5() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

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
            .description(null)
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
            (IsRemovedProvider)
                overallRatingResult
                    .parentAssetCode(parentAssetCode)
                    .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .provenance("Provenance")
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
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableAppGroup actualImmutableAppGroup = builderResult.build();
    assertEquals(instance, actualImmutableAppGroup);
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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();

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
    Builder builderResult = ImmutableAppGroup.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isFavouriteGroup(boolean)}.
   *
   * <p>Method under test: {@link Builder#isFavouriteGroup(boolean)}
   */
  @Test
  @DisplayName("Test Builder isFavouriteGroup(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isFavouriteGroup(boolean)"})
  void testBuilderIsFavouriteGroup() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

    // Act
    Builder actualIsFavouriteGroupResult = builderResult.isFavouriteGroup(true);

    // Assert
    assertSame(builderResult, actualIsFavouriteGroupResult);
  }

  /**
   * Test Builder {@link Builder#isRemoved(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRemoved(boolean)"})
  void testBuilderIsRemoved() {
    // Arrange
    Builder builderResult = ImmutableAppGroup.builder();

    // Act
    Builder actualIsRemovedResult = builderResult.isRemoved(true);

    // Assert
    assertSame(builderResult, actualIsRemovedResult);
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
    Builder builderResult = ImmutableAppGroup.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test {@link ImmutableAppGroup#copyOf(AppGroup)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#copyOf(AppGroup)}
   */
  @Test
  @DisplayName("Test copyOf(AppGroup); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.copyOf(AppGroup)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableAppGroup instance =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualCopyOfResult = ImmutableAppGroup.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualCopyOfResult.appGroupKind());
    assertFalse(actualCopyOfResult.isFavouriteGroup());
    assertFalse(actualCopyOfResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}, and {@link ImmutableAppGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroup#equals(Object)}
   *   <li>{@link ImmutableAppGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAppGroup immutableAppGroup2 =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableAppGroup, immutableAppGroup2);
    assertEquals(immutableAppGroup.hashCode(), immutableAppGroup2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}, and {@link ImmutableAppGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroup#equals(Object)}
   *   <li>{@link ImmutableAppGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableAppGroup, immutableAppGroup);
    int expectedHashCodeResult = immutableAppGroup.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppGroup.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PRIVATE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroup,
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroup,
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroup,
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroup,
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("appGroupKind")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroup,
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroup.equals(Object)",
    "int ImmutableAppGroup.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "Different type to ImmutableAppGroup");
  }

  /**
   * Test {@link ImmutableAppGroup#externalId()}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppGroup.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
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
   * Test {@link ImmutableAppGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code ALL}.
   *   <li>Then return kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'ALL'; then return kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonKindIsAll_thenReturnKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setKind(EntityKind.ALL);
    json.setAppGroupKind(AppGroupKind.PUBLIC);
    json.setName("name");

    // Act
    ImmutableAppGroup actualFromJsonResult = ImmutableAppGroup.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualFromJsonResult.appGroupKind());
    assertFalse(actualFromJsonResult.isFavouriteGroup());
    assertFalse(actualFromJsonResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code PUBLIC}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'PUBLIC'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.fromJson(Json)"})
  void testFromJson_givenPublic_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setAppGroupKind(AppGroupKind.PUBLIC);
    json.setName("name");

    // Act
    ImmutableAppGroup actualFromJsonResult = ImmutableAppGroup.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.APP_GROUP, actualFromJsonResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualFromJsonResult.appGroupKind());
    assertFalse(actualFromJsonResult.isFavouriteGroup());
    assertFalse(actualFromJsonResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setDescription("The characteristics of someone or something");
    json.setAppGroupKind(AppGroupKind.PUBLIC);
    json.setName("name");

    // Act
    ImmutableAppGroup actualFromJsonResult = ImmutableAppGroup.fromJson(json);

    // Assert
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("name", actualFromJsonResult.name());
    assertEquals(EntityKind.APP_GROUP, actualFromJsonResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualFromJsonResult.appGroupKind());
    assertFalse(actualFromJsonResult.isFavouriteGroup());
    assertFalse(actualFromJsonResult.isRemoved());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroup#appGroupKind()}
   *   <li>{@link ImmutableAppGroup#description()}
   *   <li>{@link ImmutableAppGroup#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppGroupKind ImmutableAppGroup.appGroupKind()",
    "String ImmutableAppGroup.description()",
    "String ImmutableAppGroup.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    AppGroupKind actualAppGroupKindResult = immutableAppGroup.appGroupKind();
    String actualDescriptionResult = immutableAppGroup.description();

    // Assert
    assertEquals("Name", immutableAppGroup.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(AppGroupKind.PUBLIC, actualAppGroupKindResult);
  }

  /**
   * Test {@link ImmutableAppGroup#id()}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppGroup.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableAppGroup#isFavouriteGroup()}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#isFavouriteGroup()}
   */
  @Test
  @DisplayName("Test isFavouriteGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableAppGroup.isFavouriteGroup()"})
  void testIsFavouriteGroup() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .isFavouriteGroup());
  }

  /**
   * Test {@link ImmutableAppGroup#isRemoved()}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#isRemoved()}
   */
  @Test
  @DisplayName("Test isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableAppGroup.isRemoved()"})
  void testIsRemoved() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .isRemoved());
  }

  /**
   * Test Json {@link Json#appGroupKind()}.
   *
   * <p>Method under test: {@link Json#appGroupKind()}
   */
  @Test
  @DisplayName("Test Json appGroupKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppGroupKind Json.appGroupKind()"})
  void testJsonAppGroupKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appGroupKind());
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
   * Test Json {@link Json#isFavouriteGroup()}.
   *
   * <p>Method under test: {@link Json#isFavouriteGroup()}
   */
  @Test
  @DisplayName("Test Json isFavouriteGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isFavouriteGroup()"})
  void testJsonIsFavouriteGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isFavouriteGroup());
  }

  /**
   * Test Json {@link Json#isRemoved()}.
   *
   * <p>Method under test: {@link Json#isRemoved()}
   */
  @Test
  @DisplayName("Test Json isRemoved()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRemoved()"})
  void testJsonIsRemoved() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRemoved());
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
    assertNull(actualJson.appGroupKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isFavouriteGroup);
    assertFalse(actualJson.isFavouriteGroupIsSet);
    assertFalse(actualJson.isRemoved);
    assertFalse(actualJson.isRemovedIsSet);
  }

  /**
   * Test Json {@link Json#setIsFavouriteGroup(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsFavouriteGroup(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsFavouriteGroup(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsFavouriteGroup(boolean)"})
  void testJsonSetIsFavouriteGroup() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsFavouriteGroup(true);

    // Assert
    assertTrue(json.isFavouriteGroup);
    assertTrue(json.isFavouriteGroupIsSet);
  }

  /**
   * Test Json {@link Json#setIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRemoved(boolean)"})
  void testJsonSetIsRemoved() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemoved(true);

    // Assert
    assertTrue(json.isRemoved);
    assertTrue(json.isRemovedIsSet);
  }

  /**
   * Test {@link ImmutableAppGroup#kind()}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableAppGroup.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableAppGroup#toString()}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAppGroup.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "AppGroup{id=1, name=Name, externalId=42, isRemoved=false, appGroupKind=PUBLIC, kind=ALL, isFavouriteGroup"
            + "=false}",
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAppGroup#withAppGroupKind(AppGroupKind)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withAppGroupKind(AppGroupKind)}
   */
  @Test
  @DisplayName("Test withAppGroupKind(AppGroupKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withAppGroupKind(AppGroupKind)"})
  void testWithAppGroupKind() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithAppGroupKindResult =
        immutableAppGroup.withAppGroupKind(AppGroupKind.PUBLIC);

    // Assert
    assertSame(immutableAppGroup, actualWithAppGroupKindResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withAppGroupKind(AppGroupKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withAppGroupKind(AppGroupKind)}
   */
  @Test
  @DisplayName("Test withAppGroupKind(AppGroupKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withAppGroupKind(AppGroupKind)"})
  void testWithAppGroupKind_thenReturnName() {
    // Arrange and Act
    ImmutableAppGroup actualWithAppGroupKindResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PRIVATE)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withAppGroupKind(AppGroupKind.PUBLIC);

    // Assert
    assertEquals("Name", actualWithAppGroupKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithAppGroupKindResult.description());
    assertEquals(EntityKind.ALL, actualWithAppGroupKindResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithAppGroupKindResult.appGroupKind());
    assertFalse(actualWithAppGroupKindResult.isFavouriteGroup());
    assertFalse(actualWithAppGroupKindResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithDescriptionResult = immutableAppGroup.withDescription("42");

    // Assert
    assertEquals(immutableAppGroup, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithDescriptionResult = immutableAppGroup.withDescription("42");

    // Assert
    assertSame(immutableAppGroup, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withExternalId(Optional)"})
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableAppGroup actualWithExternalIdResult = immutableAppGroup.withExternalId(optional);

    // Assert
    assertSame(immutableAppGroup, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withExternalId(Optional)"})
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableAppGroup actualWithExternalIdResult = immutableAppGroup.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithExternalIdResult.appGroupKind());
    assertFalse(actualWithExternalIdResult.isFavouriteGroup());
    assertFalse(actualWithExternalIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithExternalIdResult = immutableAppGroup.withExternalId("42");

    // Assert
    assertSame(immutableAppGroup, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableAppGroup actualWithExternalIdResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithExternalIdResult.appGroupKind());
    assertFalse(actualWithExternalIdResult.isFavouriteGroup());
    assertFalse(actualWithExternalIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAppGroup actualWithIdResult = immutableAppGroup.withId(optional);

    // Assert
    assertSame(immutableAppGroup, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAppGroup actualWithIdResult = immutableAppGroup.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithIdResult.appGroupKind());
    assertFalse(actualWithIdResult.isFavouriteGroup());
    assertFalse(actualWithIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithIdResult = immutableAppGroup.withId(1L);

    // Assert
    assertSame(immutableAppGroup, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableAppGroup actualWithIdResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithIdResult.appGroupKind());
    assertFalse(actualWithIdResult.isFavouriteGroup());
    assertFalse(actualWithIdResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withIsFavouriteGroup(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withIsFavouriteGroup(boolean)}
   */
  @Test
  @DisplayName("Test withIsFavouriteGroup(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withIsFavouriteGroup(boolean)"})
  void testWithIsFavouriteGroup() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithIsFavouriteGroupResult =
        immutableAppGroup.withIsFavouriteGroup(false);

    // Assert
    assertSame(immutableAppGroup, actualWithIsFavouriteGroupResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withIsFavouriteGroup(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withIsFavouriteGroup(boolean)}
   */
  @Test
  @DisplayName("Test withIsFavouriteGroup(boolean); when 'true'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withIsFavouriteGroup(boolean)"})
  void testWithIsFavouriteGroup_whenTrue_thenReturnName() {
    // Arrange and Act
    ImmutableAppGroup actualWithIsFavouriteGroupResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withIsFavouriteGroup(true);

    // Assert
    assertEquals("Name", actualWithIsFavouriteGroupResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithIsFavouriteGroupResult.description());
    assertEquals(EntityKind.ALL, actualWithIsFavouriteGroupResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithIsFavouriteGroupResult.appGroupKind());
    assertFalse(actualWithIsFavouriteGroupResult.isRemoved());
    assertTrue(actualWithIsFavouriteGroupResult.isFavouriteGroup());
  }

  /**
   * Test {@link ImmutableAppGroup#withIsRemoved(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withIsRemoved(boolean)"})
  void testWithIsRemoved() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithIsRemovedResult = immutableAppGroup.withIsRemoved(false);

    // Assert
    assertSame(immutableAppGroup, actualWithIsRemovedResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withIsRemoved(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withIsRemoved(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemoved(boolean); when 'true'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withIsRemoved(boolean)"})
  void testWithIsRemoved_whenTrue_thenReturnName() {
    // Arrange and Act
    ImmutableAppGroup actualWithIsRemovedResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withIsRemoved(true);

    // Assert
    assertEquals("Name", actualWithIsRemovedResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsRemovedResult.description());
    assertEquals(EntityKind.ALL, actualWithIsRemovedResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithIsRemovedResult.appGroupKind());
    assertFalse(actualWithIsRemovedResult.isFavouriteGroup());
    assertTrue(actualWithIsRemovedResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withKind(EntityKind)"})
  void testWithKind() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    ImmutableAppGroup actualWithKindResult = immutableAppGroup.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableAppGroup, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withKind(EntityKind)"})
  void testWithKind_thenReturnName() {
    // Arrange and Act
    ImmutableAppGroup actualWithKindResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithKindResult.appGroupKind());
    assertFalse(actualWithKindResult.isFavouriteGroup());
    assertFalse(actualWithKindResult.isRemoved());
  }

  /**
   * Test {@link ImmutableAppGroup#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableAppGroup#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableAppGroup immutableAppGroup =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .build();

    // Act
    ImmutableAppGroup actualWithNameResult = immutableAppGroup.withName("42");

    // Assert
    assertSame(immutableAppGroup, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAppGroup#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroup#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroup ImmutableAppGroup.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableAppGroup actualWithNameResult =
        ImmutableAppGroup.builder()
            .appGroupKind(AppGroupKind.PUBLIC)
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertEquals(AppGroupKind.PUBLIC, actualWithNameResult.appGroupKind());
    assertFalse(actualWithNameResult.isFavouriteGroup());
    assertFalse(actualWithNameResult.isRemoved());
  }
}
