package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.assessment_rating.ImmutableRemoveAssessmentRatingCommand.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableRemoveAssessmentRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRemoveAssessmentRatingCommandDiffblueTest {
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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

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
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualAssessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
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
    ImmutableRemoveAssessmentRatingCommand actualImmutableRemoveAssessmentRatingCommand =
        actualAssessmentDefinitionIdResult
            .entityReference(entityReference)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableRemoveAssessmentRatingCommand.lastUpdatedBy());
    assertEquals(1L, actualImmutableRemoveAssessmentRatingCommand.assessmentDefinitionId());
    assertEquals(1L, actualImmutableRemoveAssessmentRatingCommand.ratingId());
    assertSame(lastUpdatedAt, actualImmutableRemoveAssessmentRatingCommand.lastUpdatedAt());
    assertSame(entityReference, actualImmutableRemoveAssessmentRatingCommand.entityReference());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from((AssessmentRatingCommand) instance);

    // Assert
    ImmutableRemoveAssessmentRatingCommand actualImmutableRemoveAssessmentRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableRemoveAssessmentRatingCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    ImmutableSaveAssessmentRatingCommand.Builder commentResult =
        ImmutableSaveAssessmentRatingCommand.builder()
            .assessmentDefinitionId(1L)
            .comment("Comment");

    // Act
    Builder actualFromResult =
        builderResult.from(
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
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
        builderResult.build();
    assertEquals("2020-03-01", immutableRemoveAssessmentRatingCommand.lastUpdatedBy());
    assertEquals(1L, immutableRemoveAssessmentRatingCommand.assessmentDefinitionId());
    assertEquals(1L, immutableRemoveAssessmentRatingCommand.ratingId());
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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableRemoveAssessmentRatingCommand actualImmutableRemoveAssessmentRatingCommand =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableRemoveAssessmentRatingCommand);
    ImmutableRemoveAssessmentRatingCommand actualImmutableRemoveAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableRemoveAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

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
   * Test Builder {@link Builder#from(RemoveAssessmentRatingCommand)} with {@code
   * RemoveAssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RemoveAssessmentRatingCommand) with 'RemoveAssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RemoveAssessmentRatingCommand)"})
  void testBuilderFromWithRemoveAssessmentRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand instance =
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
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRemoveAssessmentRatingCommand actualImmutableRemoveAssessmentRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableRemoveAssessmentRatingCommand);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableRemoveAssessmentRatingCommand.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#copyOf(RemoveAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRemoveAssessmentRatingCommand#copyOf(RemoveAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(RemoveAssessmentRatingCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.copyOf(RemoveAssessmentRatingCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableRemoveAssessmentRatingCommand instance =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build();

    // Act
    ImmutableRemoveAssessmentRatingCommand actualCopyOfResult =
        ImmutableRemoveAssessmentRatingCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}, and {@link
   * ImmutableRemoveAssessmentRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .build();

    Builder assessmentDefinitionIdResult2 =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand2 =
        assessmentDefinitionIdResult2
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
            .build();

    // Act and Assert
    assertEquals(immutableRemoveAssessmentRatingCommand, immutableRemoveAssessmentRatingCommand2);
    assertEquals(
        immutableRemoveAssessmentRatingCommand.hashCode(),
        immutableRemoveAssessmentRatingCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}, and {@link
   * ImmutableRemoveAssessmentRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .build();

    // Act and Assert
    assertEquals(immutableRemoveAssessmentRatingCommand, immutableRemoveAssessmentRatingCommand);
    int expectedHashCodeResult = immutableRemoveAssessmentRatingCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableRemoveAssessmentRatingCommand.hashCode());
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(2L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .build();

    Builder assessmentDefinitionIdResult2 =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRemoveAssessmentRatingCommand,
        assessmentDefinitionIdResult2
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
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
        assessmentDefinitionIdResult
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
            .ratingId(1L)
            .build();

    Builder assessmentDefinitionIdResult2 =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRemoveAssessmentRatingCommand,
        assessmentDefinitionIdResult2
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
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build();

    Builder assessmentDefinitionIdResult2 =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRemoveAssessmentRatingCommand,
        assessmentDefinitionIdResult2
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
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .lastUpdatedBy("2020/03/01")
            .ratingId(1L)
            .build();

    Builder assessmentDefinitionIdResult2 =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRemoveAssessmentRatingCommand,
        assessmentDefinitionIdResult2
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
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .ratingId(2L)
            .build();

    Builder assessmentDefinitionIdResult2 =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRemoveAssessmentRatingCommand,
        assessmentDefinitionIdResult2
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
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveAssessmentRatingCommand.equals(Object)",
    "int ImmutableRemoveAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableRemoveAssessmentRatingCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#toString()}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#assessmentDefinitionId()}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#entityReference()}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#lastUpdatedAt()}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#lastUpdatedBy()}
   *   <li>{@link ImmutableRemoveAssessmentRatingCommand#ratingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableRemoveAssessmentRatingCommand.assessmentDefinitionId()",
    "EntityReference ImmutableRemoveAssessmentRatingCommand.entityReference()",
    "LocalDateTime ImmutableRemoveAssessmentRatingCommand.lastUpdatedAt()",
    "String ImmutableRemoveAssessmentRatingCommand.lastUpdatedBy()",
    "long ImmutableRemoveAssessmentRatingCommand.ratingId()",
    "String ImmutableRemoveAssessmentRatingCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build();

    // Act
    String actualToStringResult = immutableRemoveAssessmentRatingCommand.toString();
    long actualAssessmentDefinitionIdResult =
        immutableRemoveAssessmentRatingCommand.assessmentDefinitionId();
    EntityReference actualEntityReferenceResult =
        immutableRemoveAssessmentRatingCommand.entityReference();
    LocalDateTime actualLastUpdatedAtResult =
        immutableRemoveAssessmentRatingCommand.lastUpdatedAt();
    String actualLastUpdatedByResult = immutableRemoveAssessmentRatingCommand.lastUpdatedBy();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals(
        "RemoveAssessmentRatingCommand{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, entityReference"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, assessmentDefinitionId=1,"
            + " ratingId=1}",
        actualToStringResult);
    assertEquals(1L, actualAssessmentDefinitionIdResult);
    assertEquals(1L, immutableRemoveAssessmentRatingCommand.ratingId());
    assertSame(ofResult, toLocalDateResult);
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
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
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
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withAssessmentDefinitionId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableRemoveAssessmentRatingCommand#withAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withAssessmentDefinitionId(long)"
  })
  void testWithAssessmentDefinitionId() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(42L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithAssessmentDefinitionIdResult =
        immutableRemoveAssessmentRatingCommand.withAssessmentDefinitionId(42L);

    // Assert
    assertSame(immutableRemoveAssessmentRatingCommand, actualWithAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withAssessmentDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRemoveAssessmentRatingCommand#withAssessmentDefinitionId(long)}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitionId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withAssessmentDefinitionId(long)"
  })
  void testWithAssessmentDefinitionId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithAssessmentDefinitionIdResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build()
            .withAssessmentDefinitionId(42L);

    // Assert
    EntityReference entityReferenceResult =
        actualWithAssessmentDefinitionIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithAssessmentDefinitionIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithAssessmentDefinitionIdResult.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithAssessmentDefinitionIdResult.ratingId());
    assertEquals(42L, actualWithAssessmentDefinitionIdResult.assessmentDefinitionId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableRemoveAssessmentRatingCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithEntityReferenceResult =
        immutableRemoveAssessmentRatingCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableRemoveAssessmentRatingCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableRemoveAssessmentRatingCommand#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .build();

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithLastUpdatedAtResult =
        immutableRemoveAssessmentRatingCommand.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableRemoveAssessmentRatingCommand, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .lastUpdatedBy("42")
            .ratingId(1L)
            .build();

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithLastUpdatedByResult =
        immutableRemoveAssessmentRatingCommand.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableRemoveAssessmentRatingCommand, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithLastUpdatedByResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    EntityReference entityReferenceResult = actualWithLastUpdatedByResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithLastUpdatedByResult.assessmentDefinitionId());
    assertEquals(1L, actualWithLastUpdatedByResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withRatingId(long)"
  })
  void testWithRatingId() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);
    ImmutableRemoveAssessmentRatingCommand immutableRemoveAssessmentRatingCommand =
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
            .ratingId(42L)
            .build();

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithRatingIdResult =
        immutableRemoveAssessmentRatingCommand.withRatingId(42L);

    // Assert
    assertSame(immutableRemoveAssessmentRatingCommand, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableRemoveAssessmentRatingCommand#withRatingId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveAssessmentRatingCommand#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveAssessmentRatingCommand ImmutableRemoveAssessmentRatingCommand.withRatingId(long)"
  })
  void testWithRatingId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder assessmentDefinitionIdResult =
        ImmutableRemoveAssessmentRatingCommand.builder().assessmentDefinitionId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableRemoveAssessmentRatingCommand actualWithRatingIdResult =
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
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .ratingId(1L)
            .build()
            .withRatingId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithRatingIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    LocalDateTime lastUpdatedAtResult = actualWithRatingIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithRatingIdResult.lastUpdatedBy());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithRatingIdResult.assessmentDefinitionId());
    assertEquals(42L, actualWithRatingIdResult.ratingId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
