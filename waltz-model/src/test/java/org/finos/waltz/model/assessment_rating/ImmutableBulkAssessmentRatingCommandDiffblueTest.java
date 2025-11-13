package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.assessment_rating.ImmutableBulkAssessmentRatingCommand.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableBulkAssessmentRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkAssessmentRatingCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand Builder.build()",
    "Builder Builder.comment(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCommentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableEntityReference entityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand =
        actualCommentResult.entityRef(entityRef).operation(Operation.ADD).ratingId(1L).build();

    // Assert
    assertEquals("Comment", actualImmutableBulkAssessmentRatingCommand.comment());
    assertEquals(1L, actualImmutableBulkAssessmentRatingCommand.ratingId());
    assertEquals(Operation.ADD, actualImmutableBulkAssessmentRatingCommand.operation());
    assertSame(entityRef, actualImmutableBulkAssessmentRatingCommand.entityRef());
  }

  /**
   * Test Builder {@link Builder#entityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityRef(EntityReference)"})
  void testBuilderEntityRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act
    Builder actualEntityRefResult =
        builderResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityRefResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkAssessmentRatingCommand)} with {@code
   * BulkAssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(BulkAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkAssessmentRatingCommand) with 'BulkAssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkAssessmentRatingCommand)"})
  void testBuilderFromWithBulkAssessmentRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand instance =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkAssessmentRatingCommand)} with {@code
   * BulkAssessmentRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(BulkAssessmentRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkAssessmentRatingCommand) with 'BulkAssessmentRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkAssessmentRatingCommand)"})
  void testBuilderFromWithBulkAssessmentRatingCommand2() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment(null);
    ImmutableBulkAssessmentRatingCommand instance =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingCommand);
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
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand instance =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand =
        builderResult.from((CommentProvider) instance).build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingCommand);
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingCommand2);
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
  void testBuilderFromWithCommentProvider2() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment(null);
    ImmutableBulkAssessmentRatingCommand instance =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand =
        builderResult.from((CommentProvider) instance).build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingCommand);
    ImmutableBulkAssessmentRatingCommand actualImmutableBulkAssessmentRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableBulkAssessmentRatingCommand2);
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
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

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
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Test Builder {@link Builder#operation(Operation)}.
   *
   * <p>Method under test: {@link Builder#operation(Operation)}
   */
  @Test
  @DisplayName("Test Builder operation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operation(Operation)"})
  void testBuilderOperation() {
    // Arrange
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act
    Builder actualOperationResult = builderResult.operation(Operation.ADD);

    // Assert
    assertSame(builderResult, actualOperationResult);
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
    Builder builderResult = ImmutableBulkAssessmentRatingCommand.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#copyOf(BulkAssessmentRatingCommand)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBulkAssessmentRatingCommand#copyOf(BulkAssessmentRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BulkAssessmentRatingCommand); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.copyOf(BulkAssessmentRatingCommand)"
  })
  void testCopyOf_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand instance =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    ImmutableBulkAssessmentRatingCommand actualCopyOfResult =
        ImmutableBulkAssessmentRatingCommand.copyOf(instance);

    // Assert
    EntityReference entityRefResult = actualCopyOfResult.entityRef();
    assertTrue(entityRefResult instanceof ImmutableEntityReference);
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("The characteristics of someone or something", entityRefResult.description());
    assertEquals(1L, entityRefResult.id());
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertEquals(EntityKind.ALL, entityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualCopyOfResult.operation());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}, and {@link
   * ImmutableBulkAssessmentRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    Builder commentResult2 = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand2 =
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableBulkAssessmentRatingCommand, immutableBulkAssessmentRatingCommand2);
    assertEquals(
        immutableBulkAssessmentRatingCommand.hashCode(),
        immutableBulkAssessmentRatingCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}, and {@link
   * ImmutableBulkAssessmentRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableBulkAssessmentRatingCommand, immutableBulkAssessmentRatingCommand);
    int expectedHashCodeResult = immutableBulkAssessmentRatingCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkAssessmentRatingCommand.hashCode());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    Builder commentResult2 = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingCommand,
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ATTEST)
            .ratingId(1L)
            .build();

    Builder commentResult2 = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingCommand,
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(2L)
            .build();

    Builder commentResult2 = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act and Assert
    assertNotEquals(
        immutableBulkAssessmentRatingCommand,
        commentResult2
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act and Assert
    assertNotEquals(
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkAssessmentRatingCommand.equals(Object)",
    "int ImmutableBulkAssessmentRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act and Assert
    assertNotEquals(
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build(),
        "Different type to ImmutableBulkAssessmentRatingCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#toString()}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#comment()}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#entityRef()}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#operation()}
   *   <li>{@link ImmutableBulkAssessmentRatingCommand#ratingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBulkAssessmentRatingCommand.comment()",
    "EntityReference ImmutableBulkAssessmentRatingCommand.entityRef()",
    "Operation ImmutableBulkAssessmentRatingCommand.operation()",
    "long ImmutableBulkAssessmentRatingCommand.ratingId()",
    "String ImmutableBulkAssessmentRatingCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    String actualToStringResult = immutableBulkAssessmentRatingCommand.toString();
    String actualCommentResult = immutableBulkAssessmentRatingCommand.comment();
    EntityReference actualEntityRefResult = immutableBulkAssessmentRatingCommand.entityRef();
    Operation actualOperationResult = immutableBulkAssessmentRatingCommand.operation();

    // Assert
    assertTrue(actualEntityRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "BulkAssessmentRatingCommand{ratingId=1, entityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, operation=ADD}",
        actualToStringResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals(1L, immutableBulkAssessmentRatingCommand.ratingId());
    assertEquals(Operation.ADD, actualOperationResult);
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
   * Test Json {@link Json#entityRef()}.
   *
   * <p>Method under test: {@link Json#entityRef()}
   */
  @Test
  @DisplayName("Test Json entityRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityRef()"})
  void testJsonEntityRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityRef());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setEntityRef(EntityReference)}
   *   <li>{@link Json#setOperation(Operation)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setComment(String)",
    "void Json.setEntityRef(EntityReference)",
    "void Json.setOperation(Operation)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setEntityRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setOperation(Operation.ADD);

    // Assert
    EntityReference entityReference = actualJson.entityRef;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("Comment", actualJson.comment);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0L, actualJson.ratingId);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualJson.operation);
    assertFalse(actualJson.ratingIdIsSet);
  }

  /**
   * Test Json {@link Json#operation()}.
   *
   * <p>Method under test: {@link Json#operation()}
   */
  @Test
  @DisplayName("Test Json operation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation Json.operation()"})
  void testJsonOperation() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operation());
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
   * Test {@link ImmutableBulkAssessmentRatingCommand#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withComment(String)"
  })
  void testWithComment() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithCommentResult =
        immutableBulkAssessmentRatingCommand.withComment("42");

    // Assert
    assertEquals(immutableBulkAssessmentRatingCommand, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withComment(String)"
  })
  void testWithComment2() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("42");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithCommentResult =
        immutableBulkAssessmentRatingCommand.withComment("42");

    // Assert
    assertSame(immutableBulkAssessmentRatingCommand, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#withEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkAssessmentRatingCommand#withEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withEntityRef(EntityReference)"
  })
  void testWithEntityRef() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithEntityRefResult =
        immutableBulkAssessmentRatingCommand.withEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkAssessmentRatingCommand, actualWithEntityRefResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#withOperation(Operation)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withOperation(Operation)"
  })
  void testWithOperation() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build();

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithOperationResult =
        immutableBulkAssessmentRatingCommand.withOperation(Operation.ADD);

    // Assert
    assertSame(immutableBulkAssessmentRatingCommand, actualWithOperationResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#withOperation(Operation)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#withOperation(Operation)}
   */
  @Test
  @DisplayName("Test withOperation(Operation); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withOperation(Operation)"
  })
  void testWithOperation_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithOperationResult =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ATTEST)
            .ratingId(1L)
            .build()
            .withOperation(Operation.ADD);

    // Assert
    EntityReference entityRefResult = actualWithOperationResult.entityRef();
    assertTrue(entityRefResult instanceof ImmutableEntityReference);
    assertEquals("Comment", actualWithOperationResult.comment());
    assertEquals("The characteristics of someone or something", entityRefResult.description());
    assertEquals(1L, entityRefResult.id());
    assertEquals(1L, actualWithOperationResult.ratingId());
    assertEquals(EntityKind.ALL, entityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithOperationResult.operation());
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#withRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withRatingId(long)"
  })
  void testWithRatingId() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");
    ImmutableBulkAssessmentRatingCommand immutableBulkAssessmentRatingCommand =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(42L)
            .build();

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithRatingIdResult =
        immutableBulkAssessmentRatingCommand.withRatingId(42L);

    // Assert
    assertSame(immutableBulkAssessmentRatingCommand, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableBulkAssessmentRatingCommand#withRatingId(long)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkAssessmentRatingCommand#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkAssessmentRatingCommand ImmutableBulkAssessmentRatingCommand.withRatingId(long)"
  })
  void testWithRatingId_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder commentResult = ImmutableBulkAssessmentRatingCommand.builder().comment("Comment");

    // Act
    ImmutableBulkAssessmentRatingCommand actualWithRatingIdResult =
        commentResult
            .entityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .operation(Operation.ADD)
            .ratingId(1L)
            .build()
            .withRatingId(42L);

    // Assert
    EntityReference entityRefResult = actualWithRatingIdResult.entityRef();
    assertTrue(entityRefResult instanceof ImmutableEntityReference);
    assertEquals("Comment", actualWithRatingIdResult.comment());
    assertEquals("The characteristics of someone or something", entityRefResult.description());
    assertEquals(1L, entityRefResult.id());
    assertEquals(42L, actualWithRatingIdResult.ratingId());
    assertEquals(EntityKind.ALL, entityRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult.entityLifecycleStatus());
    assertEquals(Operation.ADD, actualWithRatingIdResult.operation());
  }
}
