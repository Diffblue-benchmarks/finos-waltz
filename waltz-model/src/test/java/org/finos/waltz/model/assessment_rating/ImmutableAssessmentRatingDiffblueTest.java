package org.finos.waltz.model.assessment_rating;

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
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRating.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentDefinitionId(long)}.
   *
   * <p>Method under test: {@link Builder#assessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionId(long)"})
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    // Act
    Builder actualAssessmentDefinitionIdResult = builderResult.assessmentDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCommentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIdResult = actualCommentResult.entityReference(entityReference).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableAssessmentRating actualImmutableAssessmentRating =
        actualIdResult
            .id(id)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableAssessmentRating.lastUpdatedBy());
    assertEquals("Comment", actualImmutableAssessmentRating.comment());
    assertEquals("Provenance", actualImmutableAssessmentRating.provenance());
    assertEquals(1L, actualImmutableAssessmentRating.assessmentDefinitionId());
    assertEquals(1L, actualImmutableAssessmentRating.ratingId());
    assertFalse(actualImmutableAssessmentRating.isReadOnly());
    assertSame(lastUpdatedAt, actualImmutableAssessmentRating.lastUpdatedAt());
    assertSame(entityReference, actualImmutableAssessmentRating.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRating)} with {@code AssessmentRating}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRating) with 'AssessmentRating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRating)"})
  void testBuilderFromWithAssessmentRating() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRating)} with {@code AssessmentRating}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRating) with 'AssessmentRating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRating)"})
  void testBuilderFromWithAssessmentRating2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment(null);
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating =
        builderResult.from((CommentProvider) instance).build();
    assertEquals(instance, actualImmutableAssessmentRating);
    ImmutableAssessmentRating actualImmutableAssessmentRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating2);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CommentProvider) with 'CommentProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CommentProvider) with 'CommentProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
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
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableAssessmentRating);
    ImmutableAssessmentRating actualImmutableAssessmentRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating2);
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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsReadOnlyProvider)
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
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating =
        builderResult.from((IsReadOnlyProvider) instance).build();
    assertEquals(instance, actualImmutableAssessmentRating);
    ImmutableAssessmentRating actualImmutableAssessmentRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating2);
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsReadOnlyProvider)
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IsReadOnlyProvider)} with {@code IsReadOnlyProvider}.
   *
   * <p>Method under test: {@link Builder#from(IsReadOnlyProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IsReadOnlyProvider) with 'IsReadOnlyProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IsReadOnlyProvider)"})
  void testBuilderFromWithIsReadOnlyProvider4() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment(null);

    // Act
    Builder actualFromResult =
        builderResult.from(
            (IsReadOnlyProvider)
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableAssessmentRating);
    ImmutableAssessmentRating actualImmutableAssessmentRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating2);
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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();

    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableAssessmentRating actualImmutableAssessmentRating =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableAssessmentRating);
    ImmutableAssessmentRating actualImmutableAssessmentRating2 = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRating2);
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
    Builder builderResult = ImmutableAssessmentRating.builder();

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
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
    Builder builderResult = ImmutableAssessmentRating.builder();

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment(null);

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                commentResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build());

    // Assert
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
    Builder builderResult = ImmutableAssessmentRating.builder();

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
    Builder builderResult = ImmutableAssessmentRating.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
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
    Builder builderResult = ImmutableAssessmentRating.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#ratingId(long)}.
   *
   * <p>Method under test: {@link Builder#ratingId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingId(long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRating.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#copyOf(AssessmentRating)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#copyOf(AssessmentRating)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRating); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.copyOf(AssessmentRating)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAssessmentRating instance =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualCopyOfResult = ImmutableAssessmentRating.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertSame(ofResult, actualCopyOfResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}, and {@link
   * ImmutableAssessmentRating#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRating#equals(Object)}
   *   <li>{@link ImmutableAssessmentRating#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating2 =
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRating, immutableAssessmentRating2);
    assertEquals(immutableAssessmentRating.hashCode(), immutableAssessmentRating2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}, and {@link
   * ImmutableAssessmentRating#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRating#equals(Object)}
   *   <li>{@link ImmutableAssessmentRating#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRating, immutableAssessmentRating);
    int expectedHashCodeResult = immutableAssessmentRating.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRating.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(2L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("2020-03-01")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(2L)
            .build();

    Builder commentResult2 =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRating,
        commentResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRating#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRating.equals(Object)",
    "int ImmutableAssessmentRating.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertNotEquals(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build(),
        "Different type to ImmutableAssessmentRating");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRating#assessmentDefinitionId()}
   *   <li>{@link ImmutableAssessmentRating#comment()}
   *   <li>{@link ImmutableAssessmentRating#entityReference()}
   *   <li>{@link ImmutableAssessmentRating#lastUpdatedBy()}
   *   <li>{@link ImmutableAssessmentRating#ratingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAssessmentRating.assessmentDefinitionId()",
    "String ImmutableAssessmentRating.comment()",
    "EntityReference ImmutableAssessmentRating.entityReference()",
    "String ImmutableAssessmentRating.lastUpdatedBy()",
    "long ImmutableAssessmentRating.ratingId()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    long actualAssessmentDefinitionIdResult = immutableAssessmentRating.assessmentDefinitionId();
    String actualCommentResult = immutableAssessmentRating.comment();
    EntityReference actualEntityReferenceResult = immutableAssessmentRating.entityReference();
    String actualLastUpdatedByResult = immutableAssessmentRating.lastUpdatedBy();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals(1L, actualAssessmentDefinitionIdResult);
    assertEquals(1L, immutableAssessmentRating.ratingId());
  }

  /**
   * Test {@link ImmutableAssessmentRating#id()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAssessmentRating.id()"})
  void testId() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act
    Optional<Long> actualIdResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableAssessmentRating#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableAssessmentRating.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertFalse(
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .isReadOnly());
  }

  /**
   * Test Json {@link Json#assessmentDefinitionId()}.
   *
   * <p>Method under test: {@link Json#assessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.assessmentDefinitionId()"})
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentDefinitionId());
  }

  /**
   * Test Json {@link Json#comment()}.
   *
   * <p>Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
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
   * Test Json {@link Json#isReadOnly()}.
   *
   * <p>Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadOnly());
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
    assertNull(actualJson.comment);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.entityReference);
    assertEquals(0L, actualJson.assessmentDefinitionId);
    assertEquals(0L, actualJson.ratingId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.assessmentDefinitionIdIsSet);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.ratingIdIsSet);
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
   * Test Json {@link Json#ratingId()}.
   *
   * <p>Method under test: {@link Json#ratingId()}
   */
  @Test
  @DisplayName("Test Json ratingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.ratingId()"})
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingId());
  }

  /**
   * Test Json {@link Json#setAssessmentDefinitionId(long)}.
   *
   * <p>Method under test: {@link Json#setAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setAssessmentDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAssessmentDefinitionId(long)"})
  void testJsonSetAssessmentDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAssessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, json.assessmentDefinitionId);
    assertTrue(json.assessmentDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#setRatingId(long)}.
   *
   * <p>Method under test: {@link Json#setRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatingId(long)"})
  void testJsonSetRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Test {@link ImmutableAssessmentRating#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableAssessmentRating.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#provenance()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentRating.provenance()"})
  void testProvenance() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertEquals(
        "Provenance",
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableAssessmentRating#toString()}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAssessmentRating.toString()"})
  void testToString() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    // Act and Assert
    assertEquals(
        "AssessmentRating{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance,"
            + " isReadOnly=false, id=1, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " assessmentDefinitionId=1, ratingId=1}",
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withAssessmentDefinitionId(long)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.withAssessmentDefinitionId(long)"
  })
  void testWithAssessmentDefinitionId() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(42L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithAssessmentDefinitionIdResult =
        immutableAssessmentRating.withAssessmentDefinitionId(42L);

    // Assert
    assertSame(immutableAssessmentRating, actualWithAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withAssessmentDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitionId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.withAssessmentDefinitionId(long)"
  })
  void testWithAssessmentDefinitionId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAssessmentRating actualWithAssessmentDefinitionIdResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .withAssessmentDefinitionId(42L);

    // Assert
    EntityReference entityReferenceResult =
        actualWithAssessmentDefinitionIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithAssessmentDefinitionIdResult.lastUpdatedBy());
    assertEquals("Comment", actualWithAssessmentDefinitionIdResult.comment());
    assertEquals("Provenance", actualWithAssessmentDefinitionIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithAssessmentDefinitionIdResult.ratingId());
    assertEquals(42L, actualWithAssessmentDefinitionIdResult.assessmentDefinitionId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithAssessmentDefinitionIdResult.isReadOnly());
    assertSame(ofResult, actualWithAssessmentDefinitionIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withComment(String)"})
  void testWithComment() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithCommentResult = immutableAssessmentRating.withComment("42");

    // Assert
    assertEquals(immutableAssessmentRating, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withComment(String)"})
  void testWithComment2() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("42");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithCommentResult = immutableAssessmentRating.withComment("42");

    // Assert
    assertSame(immutableAssessmentRating, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithEntityReferenceResult =
        immutableAssessmentRating.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAssessmentRating, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAssessmentRating actualWithIdResult = immutableAssessmentRating.withId(optional);

    // Assert
    assertSame(immutableAssessmentRating, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withId(Optional)"})
  void testWithIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(2L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAssessmentRating actualWithIdResult = immutableAssessmentRating.withId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Comment", actualWithIdResult.comment());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithIdResult.assessmentDefinitionId());
    assertEquals(1L, actualWithIdResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadOnly());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithIdResult = immutableAssessmentRating.withId(1L);

    // Assert
    assertSame(immutableAssessmentRating, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withId(long)"})
  void testWithIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAssessmentRating actualWithIdResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .withId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Comment", actualWithIdResult.comment());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithIdResult.assessmentDefinitionId());
    assertEquals(1L, actualWithIdResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithIdResult.isReadOnly());
    assertSame(ofResult, actualWithIdResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withIsReadOnly(boolean)"})
  void testWithIsReadOnly() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithIsReadOnlyResult =
        immutableAssessmentRating.withIsReadOnly(false);

    // Assert
    assertSame(immutableAssessmentRating, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsReadOnly(boolean); when 'true'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withIsReadOnly(boolean)"})
  void testWithIsReadOnly_whenTrue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAssessmentRating actualWithIsReadOnlyResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .withIsReadOnly(true);

    // Assert
    EntityReference entityReferenceResult = actualWithIsReadOnlyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithIsReadOnlyResult.lastUpdatedBy());
    assertEquals("Comment", actualWithIsReadOnlyResult.comment());
    assertEquals("Provenance", actualWithIsReadOnlyResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithIsReadOnlyResult.assessmentDefinitionId());
    assertEquals(1L, actualWithIsReadOnlyResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithIsReadOnlyResult.isReadOnly());
    assertSame(ofResult, actualWithIsReadOnlyResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithLastUpdatedAtResult =
        immutableAssessmentRating.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAssessmentRating, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithLastUpdatedByResult =
        immutableAssessmentRating.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableAssessmentRating, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRating ImmutableAssessmentRating.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAssessmentRating actualWithLastUpdatedByResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithLastUpdatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Comment", actualWithLastUpdatedByResult.comment());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithLastUpdatedByResult.assessmentDefinitionId());
    assertEquals(1L, actualWithLastUpdatedByResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithLastUpdatedByResult.isReadOnly());
    assertSame(ofResult, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("42")
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithProvenanceResult =
        immutableAssessmentRating.withProvenance("42");

    // Assert
    assertSame(immutableAssessmentRating, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withProvenance(String)"})
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAssessmentRating actualWithProvenanceResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Comment", actualWithProvenanceResult.comment());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithProvenanceResult.assessmentDefinitionId());
    assertEquals(1L, actualWithProvenanceResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithProvenanceResult.isReadOnly());
    assertSame(ofResult, actualWithProvenanceResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableAssessmentRating#withRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withRatingId(long)"})
  void testWithRatingId() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");
    ImmutableAssessmentRating immutableAssessmentRating =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(42L)
            .build();

    // Act
    ImmutableAssessmentRating actualWithRatingIdResult =
        immutableAssessmentRating.withRatingId(42L);

    // Assert
    assertSame(immutableAssessmentRating, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRating#withRatingId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRating#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRating ImmutableAssessmentRating.withRatingId(long)"})
  void testWithRatingId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAssessmentRating actualWithRatingIdResult =
        commentResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .withRatingId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithRatingIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualWithRatingIdResult.lastUpdatedBy());
    assertEquals("Comment", actualWithRatingIdResult.comment());
    assertEquals("Provenance", actualWithRatingIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithRatingIdResult.assessmentDefinitionId());
    assertEquals(42L, actualWithRatingIdResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithRatingIdResult.isReadOnly());
    assertSame(ofResult, actualWithRatingIdResult.lastUpdatedAt().toLocalDate());
  }
}
