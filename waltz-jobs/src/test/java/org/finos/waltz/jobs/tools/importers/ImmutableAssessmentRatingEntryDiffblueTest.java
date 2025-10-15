package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableAssessmentRatingEntry.Builder;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRatingEntry Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityReference entity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableAssessmentRatingEntry actualImmutableAssessmentRatingEntry =
        actualDescriptionResult.entity(entity).ratingId(1L).build();

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableAssessmentRatingEntry.description());
    assertEquals(1L, actualImmutableAssessmentRatingEntry.ratingId().longValue());
    assertSame(entity, actualImmutableAssessmentRatingEntry.entity());
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#entity(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entity(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(EntityReference)"})
  void testBuilderEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act
    Builder actualEntityResult = builderResult.entity(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingEntry)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry instance =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingEntry actualImmutableAssessmentRatingEntry = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingId(Long)}.
   *
   * <p>Method under test: {@link Builder#ratingId(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingId(Long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingEntry.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#copyOf(AssessmentRatingEntry)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#copyOf(AssessmentRatingEntry)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentRatingEntry); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingEntry ImmutableAssessmentRatingEntry.copyOf(AssessmentRatingEntry)"
  })
  void testCopyOf_thenEntityReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry instance =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRatingEntry actualCopyOfResult =
        ImmutableAssessmentRatingEntry.copyOf(instance);

    // Assert
    EntityReference entityResult = actualCopyOfResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, entityResult.id());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}, and {@link
   * ImmutableAssessmentRatingEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingEntry#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry2 =
        descriptionResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingEntry, immutableAssessmentRatingEntry2);
    assertEquals(
        immutableAssessmentRatingEntry.hashCode(), immutableAssessmentRatingEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}, and {@link
   * ImmutableAssessmentRatingEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingEntry#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingEntry, immutableAssessmentRatingEntry);
    int expectedHashCodeResult = immutableAssessmentRatingEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingEntry.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult = ImmutableAssessmentRatingEntry.builder().description("Description");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingEntry,
        descriptionResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    Builder descriptionResult2 =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingEntry,
        descriptionResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(2L)
            .build();

    Builder descriptionResult2 =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingEntry,
        descriptionResult2
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingEntry.equals(Object)",
    "int ImmutableAssessmentRatingEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build(),
        "Different type to ImmutableAssessmentRatingEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingEntry#toString()}
   *   <li>{@link ImmutableAssessmentRatingEntry#description()}
   *   <li>{@link ImmutableAssessmentRatingEntry#entity()}
   *   <li>{@link ImmutableAssessmentRatingEntry#ratingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentRatingEntry.description()",
    "EntityReference ImmutableAssessmentRatingEntry.entity()",
    "Long ImmutableAssessmentRatingEntry.ratingId()",
    "String ImmutableAssessmentRatingEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingEntry.toString();
    String actualDescriptionResult = immutableAssessmentRatingEntry.description();
    EntityReference actualEntityResult = immutableAssessmentRatingEntry.entity();

    // Assert
    assertTrue(actualEntityResult instanceof ImmutableEntityReference);
    assertEquals(
        "AssessmentRatingEntry{entity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, ratingId=1,"
            + " description=The characteristics of someone or something}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutableAssessmentRatingEntry.ratingId().longValue());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingEntry ImmutableAssessmentRatingEntry.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder descriptionResult = ImmutableAssessmentRatingEntry.builder().description("42");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRatingEntry actualWithDescriptionResult =
        immutableAssessmentRatingEntry.withDescription("42");

    // Assert
    assertSame(immutableAssessmentRatingEntry, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#withDescription(String)}.
   *
   * <ul>
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingEntry ImmutableAssessmentRatingEntry.withDescription(String)"
  })
  void testWithDescription_thenEntityReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableAssessmentRatingEntry actualWithDescriptionResult =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build()
            .withDescription("42");

    // Assert
    EntityReference entityResult = actualWithDescriptionResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, actualWithDescriptionResult.ratingId().longValue());
    assertEquals(1L, entityResult.id());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#withEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#withEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingEntry ImmutableAssessmentRatingEntry.withEntity(EntityReference)"
  })
  void testWithEntity() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRatingEntry actualWithEntityResult =
        immutableAssessmentRatingEntry.withEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingEntry, actualWithEntityResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#withRatingId(Long)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#withRatingId(Long)}
   */
  @Test
  @DisplayName("Test withRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingEntry ImmutableAssessmentRatingEntry.withRatingId(Long)"
  })
  void testWithRatingId() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");
    ImmutableAssessmentRatingEntry immutableAssessmentRatingEntry =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build();

    // Act
    ImmutableAssessmentRatingEntry actualWithRatingIdResult =
        immutableAssessmentRatingEntry.withRatingId(1L);

    // Assert
    assertSame(immutableAssessmentRatingEntry, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingEntry#withRatingId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then entity return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingEntry#withRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test withRatingId(Long); when forty-two; then entity return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingEntry ImmutableAssessmentRatingEntry.withRatingId(Long)"
  })
  void testWithRatingId_whenFortyTwo_thenEntityReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableAssessmentRatingEntry.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableAssessmentRatingEntry actualWithRatingIdResult =
        descriptionResult
            .entity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .build()
            .withRatingId(42L);

    // Assert
    EntityReference entityResult = actualWithRatingIdResult.entity();
    assertTrue(entityResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", actualWithRatingIdResult.description());
    assertEquals("The characteristics of someone or something", entityResult.description());
    assertEquals(1L, entityResult.id());
    assertEquals(42L, actualWithRatingIdResult.ratingId().longValue());
    assertEquals(EntityKind.ALL, entityResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityResult.entityLifecycleStatus());
  }
}
