package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipAssessmentInfo.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipAssessmentInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipAssessmentInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableEntityReference definitionRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableLegalEntityRelationshipAssessmentInfo
        actualImmutableLegalEntityRelationshipAssessmentInfo =
            actualBuilderResult
                .definitionRef(definitionRef)
                .ratingId(1L)
                .relationshipId(1L)
                .build();

    // Assert
    assertEquals(1L, actualImmutableLegalEntityRelationshipAssessmentInfo.ratingId().longValue());
    assertEquals(
        1L, actualImmutableLegalEntityRelationshipAssessmentInfo.relationshipId().longValue());
    assertSame(definitionRef, actualImmutableLegalEntityRelationshipAssessmentInfo.definitionRef());
  }

  /**
   * Test Builder {@link Builder#definitionRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#definitionRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder definitionRef(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.definitionRef(EntityReference)"})
  void testBuilderDefinitionRef_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act
    Builder actualDefinitionRefResult =
        builderResult.definitionRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualDefinitionRefResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}.
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipAssessmentInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipAssessmentInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    Builder builderResult2 = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo instance =
        builderResult2
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipAssessmentInfo
        actualImmutableLegalEntityRelationshipAssessmentInfo = builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipAssessmentInfo);
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
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test Builder {@link Builder#relationshipId(Long)}.
   *
   * <p>Method under test: {@link Builder#relationshipId(Long)}
   */
  @Test
  @DisplayName("Test Builder relationshipId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relationshipId(Long)"})
  void testBuilderRelationshipId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act
    Builder actualRelationshipIdResult = builderResult.relationshipId(1L);

    // Assert
    assertSame(builderResult, actualRelationshipIdResult);
  }

  /**
   * Test {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#copyOf(LegalEntityRelationshipAssessmentInfo)}.
   *
   * <ul>
   *   <li>Then definitionRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#copyOf(LegalEntityRelationshipAssessmentInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LegalEntityRelationshipAssessmentInfo); then definitionRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipAssessmentInfo ImmutableLegalEntityRelationshipAssessmentInfo.copyOf(LegalEntityRelationshipAssessmentInfo)"
  })
  void testCopyOf_thenDefinitionRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo instance =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualCopyOfResult =
        ImmutableLegalEntityRelationshipAssessmentInfo.copyOf(instance);

    // Assert
    EntityReference definitionRefResult = actualCopyOfResult.definitionRef();
    assertTrue(definitionRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", definitionRefResult.description());
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertEquals(1L, actualCopyOfResult.relationshipId().longValue());
    assertEquals(1L, definitionRefResult.id());
    assertEquals(EntityKind.ALL, definitionRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, definitionRefResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo2 =
        builderResult2
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableLegalEntityRelationshipAssessmentInfo,
        immutableLegalEntityRelationshipAssessmentInfo2);
    assertEquals(
        immutableLegalEntityRelationshipAssessmentInfo.hashCode(),
        immutableLegalEntityRelationshipAssessmentInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutableLegalEntityRelationshipAssessmentInfo,
        immutableLegalEntityRelationshipAssessmentInfo);
    int expectedHashCodeResult = immutableLegalEntityRelationshipAssessmentInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableLegalEntityRelationshipAssessmentInfo.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipAssessmentInfo,
        builderResult2
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(2L)
            .relationshipId(1L)
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipAssessmentInfo,
        builderResult2
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(2L)
            .build();

    Builder builderResult2 = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipAssessmentInfo,
        builderResult2
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipAssessmentInfo.equals(Object)",
    "int ImmutableLegalEntityRelationshipAssessmentInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build(),
        "Different type to ImmutableLegalEntityRelationshipAssessmentInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#toString()}
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#definitionRef()}
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#ratingId()}
   *   <li>{@link ImmutableLegalEntityRelationshipAssessmentInfo#relationshipId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableLegalEntityRelationshipAssessmentInfo.definitionRef()",
    "Long ImmutableLegalEntityRelationshipAssessmentInfo.ratingId()",
    "Long ImmutableLegalEntityRelationshipAssessmentInfo.relationshipId()",
    "String ImmutableLegalEntityRelationshipAssessmentInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act
    String actualToStringResult = immutableLegalEntityRelationshipAssessmentInfo.toString();
    EntityReference actualDefinitionRefResult =
        immutableLegalEntityRelationshipAssessmentInfo.definitionRef();
    Long actualRatingIdResult = immutableLegalEntityRelationshipAssessmentInfo.ratingId();
    Long actualRelationshipIdResult =
        immutableLegalEntityRelationshipAssessmentInfo.relationshipId();

    // Assert
    assertTrue(actualDefinitionRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "LegalEntityRelationshipAssessmentInfo{relationshipId=1, definitionRef=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, ratingId=1}",
        actualToStringResult);
    assertEquals(1L, actualRatingIdResult.longValue());
    assertEquals(1L, actualRelationshipIdResult.longValue());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#withDefinitionRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#withDefinitionRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withDefinitionRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipAssessmentInfo ImmutableLegalEntityRelationshipAssessmentInfo.withDefinitionRef(EntityReference)"
  })
  void testWithDefinitionRef() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualWithDefinitionRefResult =
        immutableLegalEntityRelationshipAssessmentInfo.withDefinitionRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableLegalEntityRelationshipAssessmentInfo, actualWithDefinitionRefResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#withRatingId(Long)}.
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#withRatingId(Long)}
   */
  @Test
  @DisplayName("Test withRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipAssessmentInfo ImmutableLegalEntityRelationshipAssessmentInfo.withRatingId(Long)"
  })
  void testWithRatingId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualWithRatingIdResult =
        immutableLegalEntityRelationshipAssessmentInfo.withRatingId(1L);

    // Assert
    assertSame(immutableLegalEntityRelationshipAssessmentInfo, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#withRatingId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then definitionRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipAssessmentInfo#withRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test withRatingId(Long); when forty-two; then definitionRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipAssessmentInfo ImmutableLegalEntityRelationshipAssessmentInfo.withRatingId(Long)"
  })
  void testWithRatingId_whenFortyTwo_thenDefinitionRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualWithRatingIdResult =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build()
            .withRatingId(42L);

    // Assert
    EntityReference definitionRefResult = actualWithRatingIdResult.definitionRef();
    assertTrue(definitionRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", definitionRefResult.description());
    assertEquals(1L, actualWithRatingIdResult.relationshipId().longValue());
    assertEquals(1L, definitionRefResult.id());
    assertEquals(42L, actualWithRatingIdResult.ratingId().longValue());
    assertEquals(EntityKind.ALL, definitionRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, definitionRefResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#withRelationshipId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#withRelationshipId(Long)}
   */
  @Test
  @DisplayName("Test withRelationshipId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipAssessmentInfo ImmutableLegalEntityRelationshipAssessmentInfo.withRelationshipId(Long)"
  })
  void testWithRelationshipId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    ImmutableLegalEntityRelationshipAssessmentInfo immutableLegalEntityRelationshipAssessmentInfo =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build();

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualWithRelationshipIdResult =
        immutableLegalEntityRelationshipAssessmentInfo.withRelationshipId(1L);

    // Assert
    assertSame(immutableLegalEntityRelationshipAssessmentInfo, actualWithRelationshipIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipAssessmentInfo#withRelationshipId(Long)}.
   *
   * <ul>
   *   <li>Then definitionRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipAssessmentInfo#withRelationshipId(Long)}
   */
  @Test
  @DisplayName("Test withRelationshipId(Long); then definitionRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipAssessmentInfo ImmutableLegalEntityRelationshipAssessmentInfo.withRelationshipId(Long)"
  })
  void testWithRelationshipId_thenDefinitionRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipAssessmentInfo.builder();

    // Act
    ImmutableLegalEntityRelationshipAssessmentInfo actualWithRelationshipIdResult =
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build()
            .withRelationshipId(42L);

    // Assert
    EntityReference definitionRefResult = actualWithRelationshipIdResult.definitionRef();
    assertTrue(definitionRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", definitionRefResult.description());
    assertEquals(1L, actualWithRelationshipIdResult.ratingId().longValue());
    assertEquals(1L, definitionRefResult.id());
    assertEquals(42L, actualWithRelationshipIdResult.relationshipId().longValue());
    assertEquals(EntityKind.ALL, definitionRefResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, definitionRefResult.entityLifecycleStatus());
  }
}
