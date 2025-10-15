package org.finos.waltz.model.measurable_category;

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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IconProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEnumValue;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory.Builder;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryDiffblueTest {
  /**
   * Test Builder {@link Builder#allowPrimaryRatings(boolean)}.
   *
   * <p>Method under test: {@link Builder#allowPrimaryRatings(boolean)}
   */
  @Test
  @DisplayName("Test Builder allowPrimaryRatings(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.allowPrimaryRatings(boolean)"})
  void testBuilderAllowPrimaryRatings() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualAllowPrimaryRatingsResult = builderResult.allowPrimaryRatings(true);

    // Assert
    assertSame(builderResult, actualAllowPrimaryRatingsResult);
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
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#ratingEditorRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.ratingEditorRole(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualConstrainingAssessmentDefinitionIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L);
    Optional<Long> constrainingAssessmentDefinitionId = Optional.of(1L);
    Builder actualExternalIdResult =
        actualConstrainingAssessmentDefinitionIdResult
            .constrainingAssessmentDefinitionId(constrainingAssessmentDefinitionId)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).icon("Icon").id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        actualIdResult
            .id(id)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableMeasurableCategory.lastUpdatedBy());
    assertEquals("Icon", actualImmutableMeasurableCategory.icon());
    assertEquals("Name", actualImmutableMeasurableCategory.name());
    assertEquals("Rating Editor Role", actualImmutableMeasurableCategory.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableMeasurableCategory.description());
    assertEquals(0, actualImmutableMeasurableCategory.position());
    assertEquals(1L, actualImmutableMeasurableCategory.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualImmutableMeasurableCategory.kind());
    assertFalse(actualImmutableMeasurableCategory.editable());
    assertFalse(actualImmutableMeasurableCategory.isDeprecated());
    assertTrue(actualImmutableMeasurableCategory.allowPrimaryRatings());
    assertSame(lastUpdatedAt, actualImmutableMeasurableCategory.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#constrainingAssessmentDefinitionId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#constrainingAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder constrainingAssessmentDefinitionId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.constrainingAssessmentDefinitionId(long)"})
  void testBuilderConstrainingAssessmentDefinitionIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualConstrainingAssessmentDefinitionIdResult =
        builderResult.constrainingAssessmentDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualConstrainingAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#constrainingAssessmentDefinitionId(Optional)} with {@code
   * Optional}.
   *
   * <p>Method under test: {@link Builder#constrainingAssessmentDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test Builder constrainingAssessmentDefinitionId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.constrainingAssessmentDefinitionId(Optional)"})
  void testBuilderConstrainingAssessmentDefinitionIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<Long> constrainingAssessmentDefinitionId = Optional.of(1L);

    // Act
    Builder actualConstrainingAssessmentDefinitionIdResult =
        builderResult.constrainingAssessmentDefinitionId(constrainingAssessmentDefinitionId);

    // Assert
    assertSame(builderResult, actualConstrainingAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#editable(boolean)}.
   *
   * <p>Method under test: {@link Builder#editable(boolean)}
   */
  @Test
  @DisplayName("Test Builder editable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.editable(boolean)"})
  void testBuilderEditable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualEditableResult = builderResult.editable(true);

    // Assert
    assertSame(builderResult, actualEditableResult);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((EntityKindProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((IconProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <ul>
   *   <li>Given {@code Icon}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IconProvider) with 'IconProvider'; given 'Icon'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_givenIcon_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IconProvider) with 'IconProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(false)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description(null)
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(false)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description(null)
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableEnumValue.builder()
                    .description("The characteristics of someone or something")
                    .icon("Icon")
                    .iconColor("Icon Color")
                    .key("Key")
                    .name("Name")
                    .type("Type")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((PositionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description(null)
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider5() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(false)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    ImmutableMeasurableCategory actualImmutableMeasurableCategory =
        builderResult.from((PositionProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableCategory);
    ImmutableMeasurableCategory actualImmutableMeasurableCategory2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategory2);
  }

  /**
   * Test Builder {@link Builder#icon(String)}.
   *
   * <ul>
   *   <li>When {@code Icon}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#icon(String)}
   */
  @Test
  @DisplayName("Test Builder icon(String); when 'Icon'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.icon(String)"})
  void testBuilderIcon_whenIcon_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualIconResult = builderResult.icon("Icon");

    // Assert
    assertSame(builderResult, actualIconResult);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isDeprecated(boolean)}.
   *
   * <p>Method under test: {@link Builder#isDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDeprecated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isDeprecated(boolean)"})
  void testBuilderIsDeprecated() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualIsDeprecatedResult = builderResult.isDeprecated(true);

    // Assert
    assertSame(builderResult, actualIsDeprecatedResult);
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
    Builder builderResult = ImmutableMeasurableCategory.builder();

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
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   *
   * <p>Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act
    Builder actualRatingSchemeIdResult = builderResult.ratingSchemeId(1L);

    // Assert
    assertSame(builderResult, actualRatingSchemeIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#constrainingAssessmentDefinitionId()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#constrainingAssessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test constrainingAssessmentDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurableCategory.constrainingAssessmentDefinitionId()"})
  void testConstrainingAssessmentDefinitionId() {
    // Arrange and Act
    Optional<Long> actualConstrainingAssessmentDefinitionIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .constrainingAssessmentDefinitionId();

    // Assert
    assertEquals(1L, actualConstrainingAssessmentDefinitionIdResult.get().longValue());
    assertTrue(actualConstrainingAssessmentDefinitionIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableCategory); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.copyOf(MeasurableCategory)"
  })
  void testCopyOf_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableCategory instance =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

    // Assert
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(0, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.editable());
    assertFalse(actualCopyOfResult.isDeprecated());
    assertTrue(actualCopyOfResult.allowPrimaryRatings());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#editable()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#editable()}
   */
  @Test
  @DisplayName("Test editable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableMeasurableCategory.editable()"})
  void testEditable() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .editable());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}, and {@link
   * ImmutableMeasurableCategory#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategory#equals(Object)}
   *   <li>{@link ImmutableMeasurableCategory#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    ImmutableMeasurableCategory immutableMeasurableCategory2 =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableCategory, immutableMeasurableCategory2);
    assertEquals(immutableMeasurableCategory.hashCode(), immutableMeasurableCategory2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}, and {@link
   * ImmutableMeasurableCategory#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategory#equals(Object)}
   *   <li>{@link ImmutableMeasurableCategory#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableCategory, immutableMeasurableCategory);
    int expectedHashCodeResult = immutableMeasurableCategory.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableCategory.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(false)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(2L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("Name")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("2020-03-01")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Name")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategory,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.equals(Object)",
    "int ImmutableMeasurableCategory.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build(),
        "Different type to ImmutableMeasurableCategory");
  }

  /**
   * Test {@link ImmutableMeasurableCategory#externalId()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurableCategory.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
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
   *   <li>{@link ImmutableMeasurableCategory#allowPrimaryRatings()}
   *   <li>{@link ImmutableMeasurableCategory#description()}
   *   <li>{@link ImmutableMeasurableCategory#icon()}
   *   <li>{@link ImmutableMeasurableCategory#lastUpdatedBy()}
   *   <li>{@link ImmutableMeasurableCategory#name()}
   *   <li>{@link ImmutableMeasurableCategory#ratingSchemeId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategory.allowPrimaryRatings()",
    "String ImmutableMeasurableCategory.description()",
    "String ImmutableMeasurableCategory.icon()",
    "String ImmutableMeasurableCategory.lastUpdatedBy()",
    "String ImmutableMeasurableCategory.name()",
    "long ImmutableMeasurableCategory.ratingSchemeId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    boolean actualAllowPrimaryRatingsResult = immutableMeasurableCategory.allowPrimaryRatings();
    String actualDescriptionResult = immutableMeasurableCategory.description();
    String actualIconResult = immutableMeasurableCategory.icon();
    String actualLastUpdatedByResult = immutableMeasurableCategory.lastUpdatedBy();
    String actualNameResult = immutableMeasurableCategory.name();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Icon", actualIconResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutableMeasurableCategory.ratingSchemeId());
    assertTrue(actualAllowPrimaryRatingsResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#id()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMeasurableCategory.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#isDeprecated()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#isDeprecated()}
   */
  @Test
  @DisplayName("Test isDeprecated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableMeasurableCategory.isDeprecated()"})
  void testIsDeprecated() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .isDeprecated());
  }

  /**
   * Test Json {@link Json#allowPrimaryRatings()}.
   *
   * <p>Method under test: {@link Json#allowPrimaryRatings()}
   */
  @Test
  @DisplayName("Test Json allowPrimaryRatings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.allowPrimaryRatings()"})
  void testJsonAllowPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().allowPrimaryRatings());
  }

  /**
   * Test Json {@link Json#constrainingAssessmentDefinitionId()}.
   *
   * <p>Method under test: {@link Json#constrainingAssessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json constrainingAssessmentDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.constrainingAssessmentDefinitionId()"})
  void testJsonConstrainingAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new Json().constrainingAssessmentDefinitionId());
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
   * Test Json {@link Json#editable()}.
   *
   * <p>Method under test: {@link Json#editable()}
   */
  @Test
  @DisplayName("Test Json editable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.editable()"})
  void testJsonEditable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().editable());
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
   * Test Json {@link Json#icon()}.
   *
   * <p>Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().icon());
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
   * Test Json {@link Json#isDeprecated()}.
   *
   * <p>Method under test: {@link Json#isDeprecated()}
   */
  @Test
  @DisplayName("Test Json isDeprecated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isDeprecated()"})
  void testJsonIsDeprecated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isDeprecated());
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
    assertNull(actualJson.icon);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.ratingEditorRole);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.constrainingAssessmentDefinitionId.isPresent());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.allowPrimaryRatings);
    assertFalse(actualJson.allowPrimaryRatingsIsSet);
    assertFalse(actualJson.editable);
    assertFalse(actualJson.editableIsSet);
    assertFalse(actualJson.isDeprecated);
    assertFalse(actualJson.isDeprecatedIsSet);
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.ratingSchemeIdIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#ratingEditorRole()}.
   *
   * <p>Method under test: {@link Json#ratingEditorRole()}
   */
  @Test
  @DisplayName("Test Json ratingEditorRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ratingEditorRole()"})
  void testJsonRatingEditorRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingEditorRole());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeId());
  }

  /**
   * Test Json {@link Json#setAllowPrimaryRatings(boolean)}.
   *
   * <p>Method under test: {@link Json#setAllowPrimaryRatings(boolean)}
   */
  @Test
  @DisplayName("Test Json setAllowPrimaryRatings(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAllowPrimaryRatings(boolean)"})
  void testJsonSetAllowPrimaryRatings() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAllowPrimaryRatings(true);

    // Assert
    assertTrue(json.allowPrimaryRatings);
    assertTrue(json.allowPrimaryRatingsIsSet);
  }

  /**
   * Test Json {@link Json#setEditable(boolean)}.
   *
   * <p>Method under test: {@link Json#setEditable(boolean)}
   */
  @Test
  @DisplayName("Test Json setEditable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setEditable(boolean)"})
  void testJsonSetEditable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setEditable(true);

    // Assert
    assertTrue(json.editable);
    assertTrue(json.editableIsSet);
  }

  /**
   * Test Json {@link Json#setIsDeprecated(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDeprecated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsDeprecated(boolean)"})
  void testJsonSetIsDeprecated() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsDeprecated(true);

    // Assert
    assertTrue(json.isDeprecated);
    assertTrue(json.isDeprecatedIsSet);
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test Json {@link Json#setRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatingSchemeId(long)"})
  void testJsonSetRatingSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#kind()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind ImmutableMeasurableCategory.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        EntityKind.ALL,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurableCategory.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#position()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableMeasurableCategory.position()"})
  void testPosition() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .position());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#ratingEditorRole()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#ratingEditorRole()}
   */
  @Test
  @DisplayName("Test ratingEditorRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMeasurableCategory.ratingEditorRole()"})
  void testRatingEditorRole() {
    // Arrange, Act and Assert
    assertEquals(
        "Rating Editor Role",
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .ratingEditorRole());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#toString()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMeasurableCategory.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "MeasurableCategory{id=1, name=Name, externalId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " icon=Icon, position=0, kind=ALL, editable=false, isDeprecated=false, ratingEditorRole=Rating Editor"
            + " Role, ratingSchemeId=1, constrainingAssessmentDefinitionId=1, allowPrimaryRatings=true}",
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withAllowPrimaryRatings(boolean)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withAllowPrimaryRatings(boolean)}
   */
  @Test
  @DisplayName("Test withAllowPrimaryRatings(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withAllowPrimaryRatings(boolean)"
  })
  void testWithAllowPrimaryRatings() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithAllowPrimaryRatingsResult =
        immutableMeasurableCategory.withAllowPrimaryRatings(true);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithAllowPrimaryRatingsResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withAllowPrimaryRatings(boolean)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withAllowPrimaryRatings(boolean)}
   */
  @Test
  @DisplayName("Test withAllowPrimaryRatings(boolean); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withAllowPrimaryRatings(boolean)"
  })
  void testWithAllowPrimaryRatings_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithAllowPrimaryRatingsResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(false)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withAllowPrimaryRatings(true);

    // Assert
    assertEquals("2020-03-01", actualWithAllowPrimaryRatingsResult.lastUpdatedBy());
    assertEquals("Icon", actualWithAllowPrimaryRatingsResult.icon());
    assertEquals("Name", actualWithAllowPrimaryRatingsResult.name());
    assertEquals("Rating Editor Role", actualWithAllowPrimaryRatingsResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something",
        actualWithAllowPrimaryRatingsResult.description());
    assertEquals(0, actualWithAllowPrimaryRatingsResult.position());
    assertEquals(1L, actualWithAllowPrimaryRatingsResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithAllowPrimaryRatingsResult.kind());
    assertFalse(actualWithAllowPrimaryRatingsResult.editable());
    assertFalse(actualWithAllowPrimaryRatingsResult.isDeprecated());
    assertTrue(actualWithAllowPrimaryRatingsResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithAllowPrimaryRatingsResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test withConstrainingAssessmentDefinitionId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withConstrainingAssessmentDefinitionId(Optional)"
  })
  void testWithConstrainingAssessmentDefinitionIdWithOptional() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurableCategory actualWithConstrainingAssessmentDefinitionIdResult =
        immutableMeasurableCategory.withConstrainingAssessmentDefinitionId(optional);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithConstrainingAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test withConstrainingAssessmentDefinitionId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withConstrainingAssessmentDefinitionId(Optional)"
  })
  void testWithConstrainingAssessmentDefinitionIdWithOptional2() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(2L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurableCategory actualWithConstrainingAssessmentDefinitionIdResult =
        immutableMeasurableCategory.withConstrainingAssessmentDefinitionId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithConstrainingAssessmentDefinitionIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithConstrainingAssessmentDefinitionIdResult.icon());
    assertEquals("Name", actualWithConstrainingAssessmentDefinitionIdResult.name());
    assertEquals(
        "Rating Editor Role",
        actualWithConstrainingAssessmentDefinitionIdResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something",
        actualWithConstrainingAssessmentDefinitionIdResult.description());
    assertEquals(0, actualWithConstrainingAssessmentDefinitionIdResult.position());
    assertEquals(1L, actualWithConstrainingAssessmentDefinitionIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithConstrainingAssessmentDefinitionIdResult.kind());
    assertFalse(actualWithConstrainingAssessmentDefinitionIdResult.editable());
    assertFalse(actualWithConstrainingAssessmentDefinitionIdResult.isDeprecated());
    assertTrue(actualWithConstrainingAssessmentDefinitionIdResult.allowPrimaryRatings());
    assertSame(
        ofResult, actualWithConstrainingAssessmentDefinitionIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(long)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withConstrainingAssessmentDefinitionId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withConstrainingAssessmentDefinitionId(long)"
  })
  void testWithConstrainingAssessmentDefinitionIdWithValue() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithConstrainingAssessmentDefinitionIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withConstrainingAssessmentDefinitionId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithConstrainingAssessmentDefinitionIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithConstrainingAssessmentDefinitionIdResult.icon());
    assertEquals("Name", actualWithConstrainingAssessmentDefinitionIdResult.name());
    assertEquals(
        "Rating Editor Role",
        actualWithConstrainingAssessmentDefinitionIdResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something",
        actualWithConstrainingAssessmentDefinitionIdResult.description());
    assertEquals(0, actualWithConstrainingAssessmentDefinitionIdResult.position());
    assertEquals(1L, actualWithConstrainingAssessmentDefinitionIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithConstrainingAssessmentDefinitionIdResult.kind());
    assertFalse(actualWithConstrainingAssessmentDefinitionIdResult.editable());
    assertFalse(actualWithConstrainingAssessmentDefinitionIdResult.isDeprecated());
    assertTrue(actualWithConstrainingAssessmentDefinitionIdResult.allowPrimaryRatings());
    assertSame(
        ofResult, actualWithConstrainingAssessmentDefinitionIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(long)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategory#withConstrainingAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withConstrainingAssessmentDefinitionId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withConstrainingAssessmentDefinitionId(long)"
  })
  void testWithConstrainingAssessmentDefinitionIdWithValue2() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithConstrainingAssessmentDefinitionIdResult =
        immutableMeasurableCategory.withConstrainingAssessmentDefinitionId(1L);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithConstrainingAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithDescriptionResult =
        immutableMeasurableCategory.withDescription("42");

    // Assert
    assertEquals(immutableMeasurableCategory, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("42")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithDescriptionResult =
        immutableMeasurableCategory.withDescription("42");

    // Assert
    assertSame(immutableMeasurableCategory, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withEditable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withEditable(boolean)}
   */
  @Test
  @DisplayName("Test withEditable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withEditable(boolean)"
  })
  void testWithEditable() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithEditableResult =
        immutableMeasurableCategory.withEditable(false);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithEditableResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withEditable(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withEditable(boolean)}
   */
  @Test
  @DisplayName("Test withEditable(boolean); when 'true'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withEditable(boolean)"
  })
  void testWithEditable_whenTrue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithEditableResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withEditable(true);

    // Assert
    assertEquals("2020-03-01", actualWithEditableResult.lastUpdatedBy());
    assertEquals("Icon", actualWithEditableResult.icon());
    assertEquals("Name", actualWithEditableResult.name());
    assertEquals("Rating Editor Role", actualWithEditableResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something", actualWithEditableResult.description());
    assertEquals(0, actualWithEditableResult.position());
    assertEquals(1L, actualWithEditableResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithEditableResult.kind());
    assertFalse(actualWithEditableResult.isDeprecated());
    assertTrue(actualWithEditableResult.allowPrimaryRatings());
    assertTrue(actualWithEditableResult.editable());
    assertSame(ofResult, actualWithEditableResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableMeasurableCategory actualWithExternalIdResult =
        immutableMeasurableCategory.withExternalId(optional);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withExternalId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(Optional) with 'optional'; when of 'foo'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableMeasurableCategory actualWithExternalIdResult =
        immutableMeasurableCategory.withExternalId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithExternalIdResult.icon());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Rating Editor Role", actualWithExternalIdResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(0, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertFalse(actualWithExternalIdResult.editable());
    assertFalse(actualWithExternalIdResult.isDeprecated());
    assertTrue(actualWithExternalIdResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithExternalIdResult =
        immutableMeasurableCategory.withExternalId("42");

    // Assert
    assertSame(immutableMeasurableCategory, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withExternalId(String)"
  })
  void testWithExternalIdWithValue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithExternalIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithExternalIdResult.icon());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Rating Editor Role", actualWithExternalIdResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(0, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
    assertFalse(actualWithExternalIdResult.editable());
    assertFalse(actualWithExternalIdResult.isDeprecated());
    assertTrue(actualWithExternalIdResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithExternalIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withIcon(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withIcon(String)"})
  void testWithIcon() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithIconResult = immutableMeasurableCategory.withIcon("42");

    // Assert
    assertSame(immutableMeasurableCategory, actualWithIconResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withIcon(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withIcon(String)}
   */
  @Test
  @DisplayName("Test withIcon(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withIcon(String)"})
  void testWithIcon_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithIconResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withIcon("42");

    // Assert
    assertEquals("2020-03-01", actualWithIconResult.lastUpdatedBy());
    assertEquals("42", actualWithIconResult.icon());
    assertEquals("Name", actualWithIconResult.name());
    assertEquals("Rating Editor Role", actualWithIconResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualWithIconResult.description());
    assertEquals(0, actualWithIconResult.position());
    assertEquals(1L, actualWithIconResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithIconResult.kind());
    assertFalse(actualWithIconResult.editable());
    assertFalse(actualWithIconResult.isDeprecated());
    assertTrue(actualWithIconResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithIconResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurableCategory actualWithIdResult = immutableMeasurableCategory.withId(optional);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withId(Optional)"})
  void testWithIdWithOptional_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMeasurableCategory actualWithIdResult = immutableMeasurableCategory.withId(optional);

    // Assert
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithIdResult.icon());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Rating Editor Role", actualWithIdResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertFalse(actualWithIdResult.editable());
    assertFalse(actualWithIdResult.isDeprecated());
    assertTrue(actualWithIdResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithIdResult = immutableMeasurableCategory.withId(1L);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithIdResult.icon());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Rating Editor Role", actualWithIdResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
    assertFalse(actualWithIdResult.editable());
    assertFalse(actualWithIdResult.isDeprecated());
    assertTrue(actualWithIdResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withIsDeprecated(boolean)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withIsDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test withIsDeprecated(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withIsDeprecated(boolean)"
  })
  void testWithIsDeprecated() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithIsDeprecatedResult =
        immutableMeasurableCategory.withIsDeprecated(false);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithIsDeprecatedResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withIsDeprecated(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withIsDeprecated(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsDeprecated(boolean); when 'true'; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withIsDeprecated(boolean)"
  })
  void testWithIsDeprecated_whenTrue_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithIsDeprecatedResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withIsDeprecated(true);

    // Assert
    assertEquals("2020-03-01", actualWithIsDeprecatedResult.lastUpdatedBy());
    assertEquals("Icon", actualWithIsDeprecatedResult.icon());
    assertEquals("Name", actualWithIsDeprecatedResult.name());
    assertEquals("Rating Editor Role", actualWithIsDeprecatedResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something", actualWithIsDeprecatedResult.description());
    assertEquals(0, actualWithIsDeprecatedResult.position());
    assertEquals(1L, actualWithIsDeprecatedResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithIsDeprecatedResult.kind());
    assertFalse(actualWithIsDeprecatedResult.editable());
    assertTrue(actualWithIsDeprecatedResult.allowPrimaryRatings());
    assertTrue(actualWithIsDeprecatedResult.isDeprecated());
    assertSame(ofResult, actualWithIsDeprecatedResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithKindResult =
        immutableMeasurableCategory.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withKind(EntityKind)"
  })
  void testWithKind_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithKindResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Icon", actualWithKindResult.icon());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Rating Editor Role", actualWithKindResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(0, actualWithKindResult.position());
    assertEquals(1L, actualWithKindResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
    assertFalse(actualWithKindResult.editable());
    assertFalse(actualWithKindResult.isDeprecated());
    assertTrue(actualWithKindResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithKindResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithLastUpdatedAtResult =
        immutableMeasurableCategory.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableCategory, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithLastUpdatedByResult =
        immutableMeasurableCategory.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableMeasurableCategory, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then return lastUpdatedBy is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnLastUpdatedByIs42() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithLastUpdatedByResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Icon", actualWithLastUpdatedByResult.icon());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Rating Editor Role", actualWithLastUpdatedByResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(0, actualWithLastUpdatedByResult.position());
    assertEquals(1L, actualWithLastUpdatedByResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.kind());
    assertFalse(actualWithLastUpdatedByResult.editable());
    assertFalse(actualWithLastUpdatedByResult.isDeprecated());
    assertTrue(actualWithLastUpdatedByResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("42")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithNameResult = immutableMeasurableCategory.withName("42");

    // Assert
    assertSame(immutableMeasurableCategory, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withName(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withName(String)"})
  void testWithName_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithNameResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withName("42");

    // Assert
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Icon", actualWithNameResult.icon());
    assertEquals("Rating Editor Role", actualWithNameResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(0, actualWithNameResult.position());
    assertEquals(1L, actualWithNameResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
    assertFalse(actualWithNameResult.editable());
    assertFalse(actualWithNameResult.isDeprecated());
    assertTrue(actualWithNameResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithNameResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithPositionResult =
        immutableMeasurableCategory.withPosition(0);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withPosition(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); when forty-two; then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableCategory ImmutableMeasurableCategory.withPosition(int)"})
  void testWithPosition_whenFortyTwo_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithPositionResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("2020-03-01", actualWithPositionResult.lastUpdatedBy());
    assertEquals("Icon", actualWithPositionResult.icon());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals("Rating Editor Role", actualWithPositionResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(1L, actualWithPositionResult.ratingSchemeId());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.ALL, actualWithPositionResult.kind());
    assertFalse(actualWithPositionResult.editable());
    assertFalse(actualWithPositionResult.isDeprecated());
    assertTrue(actualWithPositionResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithPositionResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withRatingEditorRole(String)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withRatingEditorRole(String)}
   */
  @Test
  @DisplayName("Test withRatingEditorRole(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withRatingEditorRole(String)"
  })
  void testWithRatingEditorRole() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("42")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithRatingEditorRoleResult =
        immutableMeasurableCategory.withRatingEditorRole("42");

    // Assert
    assertSame(immutableMeasurableCategory, actualWithRatingEditorRoleResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withRatingEditorRole(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withRatingEditorRole(String)}
   */
  @Test
  @DisplayName("Test withRatingEditorRole(String); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withRatingEditorRole(String)"
  })
  void testWithRatingEditorRole_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithRatingEditorRoleResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withRatingEditorRole("42");

    // Assert
    assertEquals("2020-03-01", actualWithRatingEditorRoleResult.lastUpdatedBy());
    assertEquals("42", actualWithRatingEditorRoleResult.ratingEditorRole());
    assertEquals("Icon", actualWithRatingEditorRoleResult.icon());
    assertEquals("Name", actualWithRatingEditorRoleResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRatingEditorRoleResult.description());
    assertEquals(0, actualWithRatingEditorRoleResult.position());
    assertEquals(1L, actualWithRatingEditorRoleResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithRatingEditorRoleResult.kind());
    assertFalse(actualWithRatingEditorRoleResult.editable());
    assertFalse(actualWithRatingEditorRoleResult.isDeprecated());
    assertTrue(actualWithRatingEditorRoleResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithRatingEditorRoleResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId() {
    // Arrange
    ImmutableMeasurableCategory immutableMeasurableCategory =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(42L)
            .build();

    // Act
    ImmutableMeasurableCategory actualWithRatingSchemeIdResult =
        immutableMeasurableCategory.withRatingSchemeId(42L);

    // Assert
    assertSame(immutableMeasurableCategory, actualWithRatingSchemeIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategory#withRatingSchemeId(long)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategory#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long); then return lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategory ImmutableMeasurableCategory.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId_thenReturnLastUpdatedByIs20200301() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableCategory actualWithRatingSchemeIdResult =
        ImmutableMeasurableCategory.builder()
            .allowPrimaryRatings(true)
            .constrainingAssessmentDefinitionId(1L)
            .description("The characteristics of someone or something")
            .externalId("42")
            .icon("Icon")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .ratingEditorRole("Rating Editor Role")
            .ratingSchemeId(1L)
            .build()
            .withRatingSchemeId(42L);

    // Assert
    assertEquals("2020-03-01", actualWithRatingSchemeIdResult.lastUpdatedBy());
    assertEquals("Icon", actualWithRatingSchemeIdResult.icon());
    assertEquals("Name", actualWithRatingSchemeIdResult.name());
    assertEquals("Rating Editor Role", actualWithRatingSchemeIdResult.ratingEditorRole());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRatingSchemeIdResult.description());
    assertEquals(0, actualWithRatingSchemeIdResult.position());
    assertEquals(42L, actualWithRatingSchemeIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualWithRatingSchemeIdResult.kind());
    assertFalse(actualWithRatingSchemeIdResult.editable());
    assertFalse(actualWithRatingSchemeIdResult.isDeprecated());
    assertTrue(actualWithRatingSchemeIdResult.allowPrimaryRatings());
    assertSame(ofResult, actualWithRatingSchemeIdResult.lastUpdatedAt().toLocalDate());
  }
}
