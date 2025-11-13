package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse.Json;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceQuestionResponseDiffblueTest {
  /**
   * Test Builder {@link ImmutableSurveyInstanceQuestionResponse.Builder#build()}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse.Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualPersonIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder().lastUpdatedAt(lastUpdatedAt).personId(1L);
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);
    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));
    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);
    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse questionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    ImmutableSurveyInstanceQuestionResponse actualImmutableSurveyInstanceQuestionResponse =
        actualPersonIdResult.questionResponse(questionResponse).surveyInstanceId(1L).build();

    // Assert
    SurveyQuestionResponse questionResponseResult =
        actualImmutableSurveyInstanceQuestionResponse.questionResponse();
    assertTrue(questionResponseResult instanceof ImmutableSurveyQuestionResponse);
    assertEquals(1L, actualImmutableSurveyInstanceQuestionResponse.personId().longValue());
    assertEquals(1L, actualImmutableSurveyInstanceQuestionResponse.surveyInstanceId().longValue());
    assertSame(lastUpdatedAt, actualImmutableSurveyInstanceQuestionResponse.lastUpdatedAt());
    assertSame(questionResponse, questionResponseResult);
  }

  /**
   * Test Builder {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#from(SurveyInstanceQuestionResponse)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#from(SurveyInstanceQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse.Builder ImmutableSurveyInstanceQuestionResponse.Builder.from(SurveyInstanceQuestionResponse)"
  })
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult =
        ImmutableSurveyInstanceQuestionResponse.builder();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult2
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse instance =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyInstanceQuestionResponse actualImmutableSurveyInstanceQuestionResponse =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyInstanceQuestionResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#lastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#lastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse.Builder ImmutableSurveyInstanceQuestionResponse.Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderLastUpdatedAt() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult =
        ImmutableSurveyInstanceQuestionResponse.builder();

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualLastUpdatedAtResult =
        builderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(builderResult, actualLastUpdatedAtResult);
  }

  /**
   * Test Builder {@link ImmutableSurveyInstanceQuestionResponse.Builder#personId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse.Builder#personId(Long)}
   */
  @Test
  @DisplayName("Test Builder personId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse.Builder ImmutableSurveyInstanceQuestionResponse.Builder.personId(Long)"
  })
  void testBuilderPersonId() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult =
        ImmutableSurveyInstanceQuestionResponse.builder();

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualPersonIdResult =
        builderResult.personId(1L);

    // Assert
    assertSame(builderResult, actualPersonIdResult);
  }

  /**
   * Test Builder {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#questionResponse(SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>When {@link ImmutableSurveyQuestionResponse.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#questionResponse(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test Builder questionResponse(SurveyQuestionResponse); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse.Builder ImmutableSurveyInstanceQuestionResponse.Builder.questionResponse(SurveyQuestionResponse)"
  })
  void testBuilderQuestionResponse_whenJson_thenReturnBuilder() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult =
        ImmutableSurveyInstanceQuestionResponse.builder();

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualQuestionResponseResult =
        builderResult.questionResponse(new ImmutableSurveyQuestionResponse.Json());

    // Assert
    assertSame(builderResult, actualQuestionResponseResult);
  }

  /**
   * Test Builder {@link ImmutableSurveyInstanceQuestionResponse.Builder#surveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse.Builder#surveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder surveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse.Builder ImmutableSurveyInstanceQuestionResponse.Builder.surveyInstanceId(Long)"
  })
  void testBuilderSurveyInstanceId() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder builderResult =
        ImmutableSurveyInstanceQuestionResponse.builder();

    // Act
    ImmutableSurveyInstanceQuestionResponse.Builder actualSurveyInstanceIdResult =
        builderResult.surveyInstanceId(1L);

    // Assert
    assertSame(builderResult, actualSurveyInstanceIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#copyOf(SurveyInstanceQuestionResponse)}.
   *
   * <ul>
   *   <li>Then questionResponse return {@link ImmutableSurveyQuestionResponse}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse#copyOf(SurveyInstanceQuestionResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyInstanceQuestionResponse); then questionResponse return ImmutableSurveyQuestionResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.copyOf(SurveyInstanceQuestionResponse)"
  })
  void testCopyOf_thenQuestionResponseReturnImmutableSurveyQuestionResponse() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(ofResult.atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse instance =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceQuestionResponse actualCopyOfResult =
        ImmutableSurveyInstanceQuestionResponse.copyOf(instance);

    // Assert
    SurveyQuestionResponse questionResponseResult = actualCopyOfResult.questionResponse();
    assertTrue(questionResponseResult instanceof ImmutableSurveyQuestionResponse);
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(1L, actualCopyOfResult.personId().longValue());
    assertEquals(1L, actualCopyOfResult.surveyInstanceId().longValue());
    assertEquals(1L, questionResponseResult.questionId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}, and {@link
   * ImmutableSurveyInstanceQuestionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse2 =
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceQuestionResponse, immutableSurveyInstanceQuestionResponse2);
    assertEquals(
        immutableSurveyInstanceQuestionResponse.hashCode(),
        immutableSurveyInstanceQuestionResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}, and {@link
   * ImmutableSurveyInstanceQuestionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableSurveyInstanceQuestionResponse, immutableSurveyInstanceQuestionResponse);
    int expectedHashCodeResult = immutableSurveyInstanceQuestionResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyInstanceQuestionResponse.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceQuestionResponse,
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(2L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceQuestionResponse,
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(false);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceQuestionResponse,
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(2L)
            .build();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyInstanceQuestionResponse,
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertNotEquals(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyInstanceQuestionResponse.equals(Object)",
    "int ImmutableSurveyInstanceQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertNotEquals(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build(),
        "Different type to ImmutableSurveyInstanceQuestionResponse");
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return personId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return personId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.fromJson(Json)"
  })
  void testFromJson_thenReturnPersonIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setSurveyInstanceId(1L);
    json.setPersonId(1L);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setLastUpdatedAt(ofResult.atStartOfDay());
    ImmutableSurveyQuestionResponse.Json questionResponse =
        new ImmutableSurveyQuestionResponse.Json();
    json.setQuestionResponse(questionResponse);

    // Act
    ImmutableSurveyInstanceQuestionResponse actualFromJsonResult =
        ImmutableSurveyInstanceQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.personId().longValue());
    assertEquals(1L, actualFromJsonResult.surveyInstanceId().longValue());
    assertSame(questionResponse, actualFromJsonResult.questionResponse());
    LocalDateTime lastUpdatedAtResult = actualFromJsonResult.lastUpdatedAt();
    assertSame(ofResult, lastUpdatedAtResult.toLocalDate());
    assertSame(json.lastUpdatedAt, lastUpdatedAtResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#toString()}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#lastUpdatedAt()}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#personId()}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#questionResponse()}
   *   <li>{@link ImmutableSurveyInstanceQuestionResponse#surveyInstanceId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDateTime ImmutableSurveyInstanceQuestionResponse.lastUpdatedAt()",
    "Long ImmutableSurveyInstanceQuestionResponse.personId()",
    "SurveyQuestionResponse ImmutableSurveyInstanceQuestionResponse.questionResponse()",
    "Long ImmutableSurveyInstanceQuestionResponse.surveyInstanceId()",
    "String ImmutableSurveyInstanceQuestionResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(ofResult.atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act
    String actualToStringResult = immutableSurveyInstanceQuestionResponse.toString();
    LocalDateTime actualLastUpdatedAtResult =
        immutableSurveyInstanceQuestionResponse.lastUpdatedAt();
    Long actualPersonIdResult = immutableSurveyInstanceQuestionResponse.personId();
    SurveyQuestionResponse actualQuestionResponseResult =
        immutableSurveyInstanceQuestionResponse.questionResponse();
    Long actualSurveyInstanceIdResult = immutableSurveyInstanceQuestionResponse.surveyInstanceId();

    // Assert
    assertTrue(actualQuestionResponseResult instanceof ImmutableSurveyQuestionResponse);
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "SurveyInstanceQuestionResponse{surveyInstanceId=1, personId=1, lastUpdatedAt=1970-01-01T00:00,"
            + " questionResponse=SurveyQuestionResponse{questionId=1, comment=Comment, stringResponse=String Response,"
            + " numberResponse=10.0, booleanResponse=true, dateResponse=1970-01-01, entityResponse=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, listResponse=[], entityListResponse=[]}}",
        actualToStringResult);
    assertEquals(1L, actualPersonIdResult.longValue());
    assertEquals(1L, actualSurveyInstanceIdResult.longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setPersonId(Long)}
   *   <li>{@link Json#setQuestionResponse(SurveyQuestionResponse)}
   *   <li>{@link Json#setSurveyInstanceId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setPersonId(Long)",
    "void Json.setQuestionResponse(SurveyQuestionResponse)",
    "void Json.setSurveyInstanceId(Long)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());
    actualJson.setPersonId(1L);
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);
    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));
    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);
    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    actualJson.setQuestionResponse(
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
    actualJson.setSurveyInstanceId(1L);

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(1L, actualJson.personId.longValue());
    assertEquals(1L, actualJson.surveyInstanceId.longValue());
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
   * Test Json {@link Json#personId()}.
   *
   * <p>Method under test: {@link Json#personId()}
   */
  @Test
  @DisplayName("Test Json personId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.personId()"})
  void testJsonPersonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().personId());
  }

  /**
   * Test Json {@link Json#questionResponse()}.
   *
   * <p>Method under test: {@link Json#questionResponse()}
   */
  @Test
  @DisplayName("Test Json questionResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyQuestionResponse Json.questionResponse()"})
  void testJsonQuestionResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().questionResponse());
  }

  /**
   * Test Json {@link Json#surveyInstanceId()}.
   *
   * <p>Method under test: {@link Json#surveyInstanceId()}
   */
  @Test
  @DisplayName("Test Json surveyInstanceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.surveyInstanceId()"})
  void testJsonSurveyInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().surveyInstanceId());
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceQuestionResponse actualWithLastUpdatedAtResult =
        immutableSurveyInstanceQuestionResponse.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableSurveyInstanceQuestionResponse, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#withPersonId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#withPersonId(Long)}
   */
  @Test
  @DisplayName("Test withPersonId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.withPersonId(Long)"
  })
  void testWithPersonId() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceQuestionResponse actualWithPersonIdResult =
        immutableSurveyInstanceQuestionResponse.withPersonId(1L);

    // Assert
    assertSame(immutableSurveyInstanceQuestionResponse, actualWithPersonIdResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#withPersonId(Long)}.
   *
   * <ul>
   *   <li>Then questionResponse return {@link ImmutableSurveyQuestionResponse}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyInstanceQuestionResponse#withPersonId(Long)}
   */
  @Test
  @DisplayName(
      "Test withPersonId(Long); then questionResponse return ImmutableSurveyQuestionResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.withPersonId(Long)"
  })
  void testWithPersonId_thenQuestionResponseReturnImmutableSurveyQuestionResponse() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(ofResult.atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);

    // Act
    ImmutableSurveyInstanceQuestionResponse actualWithPersonIdResult =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build()
            .withPersonId(42L);

    // Assert
    SurveyQuestionResponse questionResponseResult = actualWithPersonIdResult.questionResponse();
    assertTrue(questionResponseResult instanceof ImmutableSurveyQuestionResponse);
    LocalDateTime lastUpdatedAtResult = actualWithPersonIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(1L, actualWithPersonIdResult.surveyInstanceId().longValue());
    assertEquals(1L, questionResponseResult.questionId().longValue());
    assertEquals(42L, actualWithPersonIdResult.personId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyInstanceQuestionResponse#withQuestionResponse(SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse#withQuestionResponse(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test withQuestionResponse(SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.withQuestionResponse(SurveyQuestionResponse)"
  })
  void testWithQuestionResponse() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);

    // Act
    ImmutableSurveyInstanceQuestionResponse actualWithQuestionResponseResult =
        immutableSurveyInstanceQuestionResponse.withQuestionResponse(
            entityResponseResult2
                .listResponse(new ArrayList<>())
                .numberResponse(10.0d)
                .questionId(1L)
                .stringResponse("String Response")
                .build());

    // Assert
    assertEquals(immutableSurveyInstanceQuestionResponse, actualWithQuestionResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#withSurveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(ofResult.atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);

    // Act
    ImmutableSurveyInstanceQuestionResponse actualWithSurveyInstanceIdResult =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build()
            .withSurveyInstanceId(42L);

    // Assert
    SurveyQuestionResponse questionResponseResult =
        actualWithSurveyInstanceIdResult.questionResponse();
    assertTrue(questionResponseResult instanceof ImmutableSurveyQuestionResponse);
    LocalDateTime lastUpdatedAtResult = actualWithSurveyInstanceIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(1L, actualWithSurveyInstanceIdResult.personId().longValue());
    assertEquals(1L, questionResponseResult.questionId().longValue());
    assertEquals(42L, actualWithSurveyInstanceIdResult.surveyInstanceId().longValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableSurveyInstanceQuestionResponse#withSurveyInstanceId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyInstanceQuestionResponse#withSurveyInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withSurveyInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyInstanceQuestionResponse ImmutableSurveyInstanceQuestionResponse.withSurveyInstanceId(Long)"
  })
  void testWithSurveyInstanceId2() {
    // Arrange
    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyInstanceQuestionResponse immutableSurveyInstanceQuestionResponse =
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build();

    // Act
    ImmutableSurveyInstanceQuestionResponse actualWithSurveyInstanceIdResult =
        immutableSurveyInstanceQuestionResponse.withSurveyInstanceId(1L);

    // Assert
    assertSame(immutableSurveyInstanceQuestionResponse, actualWithSurveyInstanceIdResult);
  }
}
