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
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.IsReadOnlyProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.assessment_rating.ImmutableSaveAssessmentRatingCommand.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableSaveAssessmentRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveAssessmentRatingCommandDiffblueTest {
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    "ImmutableSaveAssessmentRatingCommand Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCommentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        actualCommentResult
            .entityReference(entityReference)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableSaveAssessmentRatingCommand.lastUpdatedBy());
    assertEquals("Comment", actualImmutableSaveAssessmentRatingCommand.comment());
    assertEquals("Provenance", actualImmutableSaveAssessmentRatingCommand.provenance());
    assertEquals(1L, actualImmutableSaveAssessmentRatingCommand.assessmentDefinitionId());
    assertEquals(1L, actualImmutableSaveAssessmentRatingCommand.ratingId());
    assertFalse(actualImmutableSaveAssessmentRatingCommand.isReadOnly());
    assertSame(lastUpdatedAt, actualImmutableSaveAssessmentRatingCommand.lastUpdatedAt());
    assertSame(entityReference, actualImmutableSaveAssessmentRatingCommand.entityReference());
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingCommand)} with {@code
   * AssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingCommand) with 'AssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingCommand)"})
  void testBuilderFromWithAssessmentRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    Builder actualFromResult =
        builderResult.from(
            assessmentDefinitionIdResult
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
                .ratingId(1L)
                .build());

    // Assert
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
        builderResult.build();
    assertEquals("2020-03-01", immutableSaveAssessmentRatingCommand.lastUpdatedBy());
    assertEquals("waltz", actualFromResult.build().provenance());
    assertEquals("waltz", immutableSaveAssessmentRatingCommand.provenance());
    assertNull(immutableSaveAssessmentRatingCommand.comment());
    assertEquals(1L, immutableSaveAssessmentRatingCommand.assessmentDefinitionId());
    assertEquals(1L, immutableSaveAssessmentRatingCommand.ratingId());
    assertFalse(immutableSaveAssessmentRatingCommand.isReadOnly());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingCommand)} with {@code
   * AssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingCommand) with 'AssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingCommand)"})
  void testBuilderFromWithAssessmentRatingCommand2() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((AssessmentRatingCommand) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingCommand)} with {@code
   * AssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingCommand) with 'AssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingCommand)"})
  void testBuilderFromWithAssessmentRatingCommand3() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment(null);
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((AssessmentRatingCommand) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((CommentProvider) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <ul>
   *   <li>Given {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenComment() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

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
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((IsReadOnlyProvider) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

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
                    .id(1L)
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment(null);

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
                    .id(1L)
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
  void testBuilderFromWithIsReadOnlyProvider5() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment(null);
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((IsReadOnlyProvider) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider4() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment(null);
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then builder build lastUpdatedBy is {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then builder build lastUpdatedBy is '2020-03-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenBuilderBuildLastUpdatedByIs20200301() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    ImmutableRemoveAssessmentRatingCommand.Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act
    Builder actualFromResult =
        builderResult.from(
            (LastUpdatedProvider)
                assessmentDefinitionIdResult
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
                    .ratingId(1L)
                    .build());

    // Assert
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
        builderResult.build();
    assertEquals("2020-03-01", immutableSaveAssessmentRatingCommand.lastUpdatedBy());
    assertEquals("waltz", actualFromResult.build().provenance());
    assertEquals("waltz", immutableSaveAssessmentRatingCommand.provenance());
    assertNull(immutableSaveAssessmentRatingCommand.comment());
    assertEquals(1L, immutableSaveAssessmentRatingCommand.assessmentDefinitionId());
    assertEquals(1L, immutableSaveAssessmentRatingCommand.ratingId());
    assertFalse(immutableSaveAssessmentRatingCommand.isReadOnly());
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment("Comment");

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
                    .id(1L)
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    ImmutableAssessmentRating.Builder commentResult =
        ImmutableAssessmentRating.builder().assessmentDefinitionId(1L).comment(null);

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
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .provenance("Provenance")
                    .ratingId(1L)
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveAssessmentRatingCommand)} with {@code
   * SaveAssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveAssessmentRatingCommand) with 'SaveAssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveAssessmentRatingCommand)"})
  void testBuilderFromWithSaveAssessmentRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveAssessmentRatingCommand)} with {@code
   * SaveAssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveAssessmentRatingCommand) with 'SaveAssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveAssessmentRatingCommand)"})
  void testBuilderFromWithSaveAssessmentRatingCommand2() {
    // Arrange
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment(null);
    ImmutableSaveAssessmentRatingCommand instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSaveAssessmentRatingCommand actualImmutableSaveAssessmentRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveAssessmentRatingCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveAssessmentRatingCommand.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#copyOf(SaveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveAssessmentRatingCommand#copyOf(SaveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SaveAssessmentRatingCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.copyOf(SaveAssessmentRatingCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableSaveAssessmentRatingCommand instance =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualCopyOfResult =
        ImmutableSaveAssessmentRatingCommand.copyOf(instance);

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
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}, and {@link
   * ImmutableSaveAssessmentRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand2 =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSaveAssessmentRatingCommand, immutableSaveAssessmentRatingCommand2);
    assertEquals(
        immutableSaveAssessmentRatingCommand.hashCode(),
        immutableSaveAssessmentRatingCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}, and {@link
   * ImmutableSaveAssessmentRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act and Assert
    assertEquals(immutableSaveAssessmentRatingCommand, immutableSaveAssessmentRatingCommand);
    int expectedHashCodeResult = immutableSaveAssessmentRatingCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSaveAssessmentRatingCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(2L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableSaveAssessmentRatingCommand,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableSaveAssessmentRatingCommand,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableSaveAssessmentRatingCommand,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .lastUpdatedBy("2020/03/01")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableSaveAssessmentRatingCommand,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .provenance("2020-03-01")
            .ratingId(1L)
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableSaveAssessmentRatingCommand,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .ratingId(2L)
            .build();

    Builder commentResult2 =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableSaveAssessmentRatingCommand,
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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveAssessmentRatingCommand.equals(Object)",
    "int ImmutableSaveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build(),
        "Different type to ImmutableSaveAssessmentRatingCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#toString()}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#assessmentDefinitionId()}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#comment()}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#entityReference()}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#lastUpdatedBy()}
   *   <li>{@link ImmutableSaveAssessmentRatingCommand#ratingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableSaveAssessmentRatingCommand.assessmentDefinitionId()",
    "String ImmutableSaveAssessmentRatingCommand.comment()",
    "EntityReference ImmutableSaveAssessmentRatingCommand.entityReference()",
    "String ImmutableSaveAssessmentRatingCommand.lastUpdatedBy()",
    "long ImmutableSaveAssessmentRatingCommand.ratingId()",
    "String ImmutableSaveAssessmentRatingCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    String actualToStringResult = immutableSaveAssessmentRatingCommand.toString();
    long actualAssessmentDefinitionIdResult =
        immutableSaveAssessmentRatingCommand.assessmentDefinitionId();
    String actualCommentResult = immutableSaveAssessmentRatingCommand.comment();
    EntityReference actualEntityReferenceResult =
        immutableSaveAssessmentRatingCommand.entityReference();
    String actualLastUpdatedByResult = immutableSaveAssessmentRatingCommand.lastUpdatedBy();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals(
        "SaveAssessmentRatingCommand{provenance=Provenance, isReadOnly=false, lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " assessmentDefinitionId=1, ratingId=1}",
        actualToStringResult);
    assertEquals(1L, actualAssessmentDefinitionIdResult);
    assertEquals(1L, immutableSaveAssessmentRatingCommand.ratingId());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableSaveAssessmentRatingCommand.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setComment(String)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setProvenance(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setProvenance("Provenance");

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
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
   * Test {@link ImmutableSaveAssessmentRatingCommand#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableSaveAssessmentRatingCommand.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

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
   * Test {@link ImmutableSaveAssessmentRatingCommand#provenance()}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSaveAssessmentRatingCommand.provenance()"})
  void testProvenance() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

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
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance")
            .ratingId(1L)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withAssessmentDefinitionId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveAssessmentRatingCommand#withAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withAssessmentDefinitionId(long)"
  })
  void testWithAssessmentDefinitionId() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(42L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithAssessmentDefinitionIdResult =
        immutableSaveAssessmentRatingCommand.withAssessmentDefinitionId(42L);

    // Assert
    assertSame(immutableSaveAssessmentRatingCommand, actualWithAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withAssessmentDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveAssessmentRatingCommand#withAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitionId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withAssessmentDefinitionId(long)"
  })
  void testWithAssessmentDefinitionId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithAssessmentDefinitionIdResult =
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
   * Test {@link ImmutableSaveAssessmentRatingCommand#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withComment(String)"
  })
  void testWithComment() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithCommentResult =
        immutableSaveAssessmentRatingCommand.withComment("42");

    // Assert
    assertEquals(immutableSaveAssessmentRatingCommand, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withComment(String)"
  })
  void testWithComment2() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder().assessmentDefinitionId(1L).comment("42");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithCommentResult =
        immutableSaveAssessmentRatingCommand.withComment("42");

    // Assert
    assertSame(immutableSaveAssessmentRatingCommand, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveAssessmentRatingCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithEntityReferenceResult =
        immutableSaveAssessmentRatingCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSaveAssessmentRatingCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithIsReadOnlyResult =
        immutableSaveAssessmentRatingCommand.withIsReadOnly(false);

    // Assert
    assertSame(immutableSaveAssessmentRatingCommand, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsReadOnly(boolean); when 'true'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly_whenTrue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithIsReadOnlyResult =
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
   * Test {@link ImmutableSaveAssessmentRatingCommand#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveAssessmentRatingCommand#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithLastUpdatedAtResult =
        immutableSaveAssessmentRatingCommand.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSaveAssessmentRatingCommand, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .lastUpdatedBy("42")
            .provenance("Provenance")
            .ratingId(1L)
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithLastUpdatedByResult =
        immutableSaveAssessmentRatingCommand.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableSaveAssessmentRatingCommand, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithLastUpdatedByResult =
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
   * Test {@link ImmutableSaveAssessmentRatingCommand#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .provenance("42")
            .ratingId(1L)
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithProvenanceResult =
        immutableSaveAssessmentRatingCommand.withProvenance("42");

    // Assert
    assertSame(immutableSaveAssessmentRatingCommand, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withProvenance(String)"
  })
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithProvenanceResult =
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
   * Test {@link ImmutableSaveAssessmentRatingCommand#withRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withRatingId(long)"
  })
  void testWithRatingId() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");
    ImmutableSaveAssessmentRatingCommand immutableSaveAssessmentRatingCommand =
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
            .ratingId(42L)
            .build();

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithRatingIdResult =
        immutableSaveAssessmentRatingCommand.withRatingId(42L);

    // Assert
    assertSame(immutableSaveAssessmentRatingCommand, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableSaveAssessmentRatingCommand#withRatingId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveAssessmentRatingCommand#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveAssessmentRatingCommand ImmutableSaveAssessmentRatingCommand.withRatingId(long)"
  })
  void testWithRatingId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableSaveAssessmentRatingCommand actualWithRatingIdResult =
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
