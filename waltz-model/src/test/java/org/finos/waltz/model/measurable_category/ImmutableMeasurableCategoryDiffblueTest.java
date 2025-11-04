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
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableCategory.Builder actualConstrainingAssessmentDefinitionIdResult = ImmutableMeasurableCategory
        .builder()
        .constrainingAssessmentDefinitionId(1L);
    Optional<Long> constrainingAssessmentDefinitionId = Optional.<Long>of(1L);
    ImmutableMeasurableCategory.Builder actualExternalIdResult = actualConstrainingAssessmentDefinitionIdResult
        .constrainingAssessmentDefinitionId(constrainingAssessmentDefinitionId)
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableMeasurableCategory.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableMeasurableCategory.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableMeasurableCategory.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.ratingEditorRole("Rating Editor Role"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#allowPrimaryRatings(boolean)}
   */
  @Test
  void testBuilderAllowPrimaryRatings() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.allowPrimaryRatings(true));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#constrainingAssessmentDefinitionId(long)}
   */
  @Test
  void testBuilderConstrainingAssessmentDefinitionId() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.constrainingAssessmentDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#constrainingAssessmentDefinitionId(Optional)}
   */
  @Test
  void testBuilderConstrainingAssessmentDefinitionId2() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<Long> constrainingAssessmentDefinitionId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.constrainingAssessmentDefinitionId(constrainingAssessmentDefinitionId));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#editable(boolean)}
   */
  @Test
  void testBuilderEditable() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.editable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(IconProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenReturn("Icon");

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).icon();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(IconProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    IconProvider instance = mock(IconProvider.class);
    when(instance.icon()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).icon();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(PositionProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(MeasurableCategory)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
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
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(MeasurableCategory)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
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
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(MeasurableCategory)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
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
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(MeasurableCategory)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
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
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(MeasurableCategory)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
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
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#from(MeasurableCategory)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
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
    ImmutableMeasurableCategory.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableMeasurableCategory.Builder#icon(String)}
   */
  @Test
  void testBuilderIcon() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.icon("Icon"));
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#isDeprecated(boolean)}
   */
  @Test
  void testBuilderIsDeprecated() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDeprecated(true));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableMeasurableCategory.Builder builderResult = ImmutableMeasurableCategory.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  void testCopyOf() {
    // Arrange
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
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.allowPrimaryRatings());
    assertTrue(actualCopyOfResult.editable());
    assertTrue(actualCopyOfResult.isDeprecated());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
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
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.allowPrimaryRatings());
    assertTrue(actualCopyOfResult.editable());
    assertTrue(actualCopyOfResult.isDeprecated());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
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
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.allowPrimaryRatings());
    assertTrue(actualCopyOfResult.editable());
    assertTrue(actualCopyOfResult.isDeprecated());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    MeasurableCategory instance = mock(MeasurableCategory.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.position()).thenReturn(1);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.ratingEditorRole()).thenReturn("Rating Editor Role");
    when(instance.allowPrimaryRatings()).thenReturn(false);
    when(instance.icon()).thenReturn("Icon");
    when(instance.editable()).thenReturn(true);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.constrainingAssessmentDefinitionId()).thenReturn(ofResult3);
    when(instance.isDeprecated()).thenReturn(true);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.allowPrimaryRatings());
    assertTrue(actualCopyOfResult.editable());
    assertTrue(actualCopyOfResult.isDeprecated());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
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
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.allowPrimaryRatings());
    assertTrue(actualCopyOfResult.editable());
    assertTrue(actualCopyOfResult.isDeprecated());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory#copyOf(MeasurableCategory)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
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
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMeasurableCategory actualCopyOfResult = ImmutableMeasurableCategory.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Icon", actualCopyOfResult.icon());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Editor Role", actualCopyOfResult.ratingEditorRole());
    assertNull(actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.allowPrimaryRatings());
    assertTrue(actualCopyOfResult.editable());
    assertTrue(actualCopyOfResult.isDeprecated());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#allowPrimaryRatings()}
   */
  @Test
  void testJsonAllowPrimaryRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCategory.Json()).allowPrimaryRatings());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#constrainingAssessmentDefinitionId()}
   */
  @Test
  void testJsonConstrainingAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCategory.Json()).constrainingAssessmentDefinitionId());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#editable()}
   */
  @Test
  void testJsonEditable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).editable());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#icon()}
   */
  @Test
  void testJsonIcon() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).icon());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#isDeprecated()}
   */
  @Test
  void testJsonIsDeprecated() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).isDeprecated());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableCategory.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableCategory.Json actualJson = new ImmutableMeasurableCategory.Json();

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
   * Method under test: {@link ImmutableMeasurableCategory.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#ratingEditorRole()}
   */
  @Test
  void testJsonRatingEditorRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableCategory.Json()).ratingEditorRole());
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#ratingSchemeId()}
   */
  @Test
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableCategory.Json()).ratingSchemeId());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#setAllowPrimaryRatings(boolean)}
   */
  @Test
  void testJsonSetAllowPrimaryRatings() {
    // Arrange
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();

    // Act
    json.setAllowPrimaryRatings(true);

    // Assert
    assertTrue(json.allowPrimaryRatings);
    assertTrue(json.allowPrimaryRatingsIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#setEditable(boolean)}
   */
  @Test
  void testJsonSetEditable() {
    // Arrange
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();

    // Act
    json.setEditable(true);

    // Assert
    assertTrue(json.editable);
    assertTrue(json.editableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#setIsDeprecated(boolean)}
   */
  @Test
  void testJsonSetIsDeprecated() {
    // Arrange
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();

    // Act
    json.setIsDeprecated(true);

    // Assert
    assertTrue(json.isDeprecated);
    assertTrue(json.isDeprecatedIsSet);
  }

  /**
   * Method under test: {@link ImmutableMeasurableCategory.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableCategory.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId() {
    // Arrange
    ImmutableMeasurableCategory.Json json = new ImmutableMeasurableCategory.Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }
}
