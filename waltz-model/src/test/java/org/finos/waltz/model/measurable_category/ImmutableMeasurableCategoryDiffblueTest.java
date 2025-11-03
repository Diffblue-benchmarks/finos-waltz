package org.finos.waltz.model.measurable_category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IconProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory.Builder;
import org.finos.waltz.model.measurable_category.ImmutableMeasurableCategory.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryDiffblueTest {
  /**
   * Test {@link ImmutableMeasurableCategory#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableCategory#builder()}
   *   <li>{@link ImmutableMeasurableCategory#description(String)}
   *   <li>{@link ImmutableMeasurableCategory#externalId(String)}
   *   <li>{@link ImmutableMeasurableCategory#kind(EntityKind)}
   *   <li>{@link ImmutableMeasurableCategory#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableCategory#ratingEditorRole(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableCategory Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)", "Builder Builder.kind(EntityKind)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.ratingEditorRole(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualConstrainingAssessmentDefinitionIdResult = ImmutableMeasurableCategory.builder()
        .constrainingAssessmentDefinitionId(1L);
    Optional<Long> constrainingAssessmentDefinitionId = Optional.<Long>of(1L);
    Builder actualExternalIdResult = actualConstrainingAssessmentDefinitionIdResult
        .constrainingAssessmentDefinitionId(constrainingAssessmentDefinitionId)
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    Builder actualLastUpdatedAtResult = actualKindResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.ratingEditorRole("Rating Editor Role"));
  }

  /**
   * Test Builder {@link Builder#allowPrimaryRatings(boolean)}.
   * <p>
   * Method under test: {@link Builder#allowPrimaryRatings(boolean)}
   */
  @Test
  @DisplayName("Test Builder allowPrimaryRatings(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.allowPrimaryRatings(boolean)"})
  void testBuilderAllowPrimaryRatings() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allowPrimaryRatings(true));
  }

  /**
   * Test Builder {@link Builder#constrainingAssessmentDefinitionId(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#constrainingAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder constrainingAssessmentDefinitionId(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.constrainingAssessmentDefinitionId(long)"})
  void testBuilderConstrainingAssessmentDefinitionIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.constrainingAssessmentDefinitionId(1L));
  }

  /**
   * Test Builder {@link Builder#constrainingAssessmentDefinitionId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#constrainingAssessmentDefinitionId(Optional)}
   */
  @Test
  @DisplayName("Test Builder constrainingAssessmentDefinitionId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.constrainingAssessmentDefinitionId(Optional)"})
  void testBuilderConstrainingAssessmentDefinitionIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<Long> constrainingAssessmentDefinitionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.constrainingAssessmentDefinitionId(constrainingAssessmentDefinitionId));
  }

  /**
   * Test Builder {@link Builder#editable(boolean)}.
   * <p>
   * Method under test: {@link Builder#editable(boolean)}
   */
  @Test
  @DisplayName("Test Builder editable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.editable(boolean)"})
  void testBuilderEditable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.editable(true));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
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
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   * <ul>
   *   <li>Given {@code ALL}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IconProvider)} with {@code IconProvider}.
   * <ul>
   *   <li>Given {@code Icon}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'; given 'Icon'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IconProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IconProvider) with 'IconProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IconProvider)"})
  void testBuilderFromWithIconProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    MeasurableCategory instance = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(true);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(ofResult3);
    when(instance.isDeprecated()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).allowPrimaryRatings();
    verify(instance).constrainingAssessmentDefinitionId();
    verify(instance).editable();
    verify(instance).isDeprecated();
    verify(instance).kind();
    verify(instance).ratingEditorRole();
    verify(instance).ratingSchemeId();
    ImmutableMeasurableCategory buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Editor Role", buildResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.allowPrimaryRatings());
    assertTrue(buildResult.editable());
    assertTrue(buildResult.isDeprecated());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    MeasurableCategory instance = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(true);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(ofResult2);
    when(instance.isDeprecated()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).allowPrimaryRatings();
    verify(instance).constrainingAssessmentDefinitionId();
    verify(instance).editable();
    verify(instance).isDeprecated();
    verify(instance).kind();
    verify(instance).ratingEditorRole();
    verify(instance).ratingSchemeId();
    ImmutableMeasurableCategory buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Editor Role", buildResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.allowPrimaryRatings());
    assertTrue(buildResult.editable());
    assertTrue(buildResult.isDeprecated());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    MeasurableCategory instance = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(true);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(emptyResult);
    when(instance.isDeprecated()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).allowPrimaryRatings();
    verify(instance).constrainingAssessmentDefinitionId();
    verify(instance).editable();
    verify(instance).isDeprecated();
    verify(instance).kind();
    verify(instance).ratingEditorRole();
    verify(instance).ratingSchemeId();
    ImmutableMeasurableCategory buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Editor Role", buildResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.allowPrimaryRatings());
    assertTrue(buildResult.editable());
    assertTrue(buildResult.isDeprecated());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   * <ul>
   *   <li>Then builder build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'; then builder build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory_thenBuilderBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    MeasurableCategory instance = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(true);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(ofResult3);
    when(instance.isDeprecated()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).allowPrimaryRatings();
    verify(instance).constrainingAssessmentDefinitionId();
    verify(instance).editable();
    verify(instance).isDeprecated();
    verify(instance).kind();
    verify(instance).ratingEditorRole();
    verify(instance).ratingSchemeId();
    ImmutableMeasurableCategory buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Editor Role", buildResult.ratingEditorRole());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.allowPrimaryRatings());
    assertTrue(buildResult.editable());
    assertTrue(buildResult.isDeprecated());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    MeasurableCategory instance = mock(MeasurableCategory.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(true);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(ofResult2);
    when(instance.isDeprecated()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).allowPrimaryRatings();
    verify(instance).constrainingAssessmentDefinitionId();
    verify(instance).editable();
    verify(instance).isDeprecated();
    verify(instance).kind();
    verify(instance).ratingEditorRole();
    verify(instance).ratingSchemeId();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategory)} with {@code MeasurableCategory}.
   * <ul>
   *   <li>When {@link MeasurableCategory} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableCategory)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategory) with 'MeasurableCategory'; when MeasurableCategory id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategory)"})
  void testBuilderFromWithMeasurableCategory_whenMeasurableCategoryIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    MeasurableCategory instance = mock(MeasurableCategory.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.position()).thenReturn(1);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(true);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(ofResult2);
    when(instance.isDeprecated()).thenReturn(true);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).icon();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).position();
    verify(instance).allowPrimaryRatings();
    verify(instance).constrainingAssessmentDefinitionId();
    verify(instance).editable();
    verify(instance).isDeprecated();
    verify(instance).kind();
    verify(instance).ratingEditorRole();
    verify(instance).ratingSchemeId();
    ImmutableMeasurableCategory buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Icon", buildResult.icon());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Editor Role", buildResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertTrue(buildResult.allowPrimaryRatings());
    assertTrue(buildResult.editable());
    assertTrue(buildResult.isDeprecated());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'; given one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider_givenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Test Builder {@link Builder#icon(String)}.
   * <p>
   * Method under test: {@link Builder#icon(String)}
   */
  @Test
  @DisplayName("Test Builder icon(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.icon(String)"})
  void testBuilderIcon() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.icon("Icon"));
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isDeprecated(boolean)}.
   * <p>
   * Method under test: {@link Builder#isDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDeprecated(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isDeprecated(boolean)"})
  void testBuilderIsDeprecated() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDeprecated(true));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   * <p>
   * Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Test Json {@link Json#allowPrimaryRatings()}.
   * <p>
   * Method under test: {@link Json#allowPrimaryRatings()}
   */
  @Test
  @DisplayName("Test Json allowPrimaryRatings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.allowPrimaryRatings()"})
  void testJsonAllowPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).allowPrimaryRatings());
  }

  /**
   * Test Json {@link Json#constrainingAssessmentDefinitionId()}.
   * <p>
   * Method under test: {@link Json#constrainingAssessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json constrainingAssessmentDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.constrainingAssessmentDefinitionId()"})
  void testJsonConstrainingAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).constrainingAssessmentDefinitionId());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#editable()}.
   * <p>
   * Method under test: {@link Json#editable()}
   */
  @Test
  @DisplayName("Test Json editable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.editable()"})
  void testJsonEditable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).editable());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#icon()}.
   * <p>
   * Method under test: {@link Json#icon()}
   */
  @Test
  @DisplayName("Test Json icon()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.icon()"})
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).icon());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isDeprecated()}.
   * <p>
   * Method under test: {@link Json#isDeprecated()}
   */
  @Test
  @DisplayName("Test Json isDeprecated()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isDeprecated()"})
  void testJsonIsDeprecated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isDeprecated());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#ratingEditorRole()}.
   * <p>
   * Method under test: {@link Json#ratingEditorRole()}
   */
  @Test
  @DisplayName("Test Json ratingEditorRole()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ratingEditorRole()"})
  void testJsonRatingEditorRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingEditorRole());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeId());
  }

  /**
   * Test Json {@link Json#setAllowPrimaryRatings(boolean)}.
   * <p>
   * Method under test: {@link Json#setAllowPrimaryRatings(boolean)}
   */
  @Test
  @DisplayName("Test Json setAllowPrimaryRatings(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setEditable(boolean)}
   */
  @Test
  @DisplayName("Test Json setEditable(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setIsDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDeprecated(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
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
}
