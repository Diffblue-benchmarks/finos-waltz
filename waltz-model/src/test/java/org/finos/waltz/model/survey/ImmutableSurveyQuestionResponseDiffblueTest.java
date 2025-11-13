package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseDiffblueTest {
  /**
   * Test {@link ImmutableSurveyQuestionResponse#booleanResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#booleanResponse()}
   */
  @Test
  @DisplayName("Test booleanResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.booleanResponse()"})
  void testBooleanResponse() {
    // Arrange
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
    assertEquals(
        booleanResponse,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .booleanResponse());
  }

  /**
   * Test Builder {@link Builder#booleanResponse(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link Builder#booleanResponse(boolean)}
   */
  @Test
  @DisplayName("Test Builder booleanResponse(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.booleanResponse(boolean)"})
  void testBuilderBooleanResponseWithBoolean() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act
    Builder actualBooleanResponseResult = builderResult.booleanResponse(true);

    // Assert
    assertSame(builderResult, actualBooleanResponseResult);
  }

  /**
   * Test Builder {@link Builder#booleanResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#booleanResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder booleanResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.booleanResponse(Optional)"})
  void testBuilderBooleanResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    // Act
    Builder actualBooleanResponseResult = builderResult.booleanResponse(booleanResponse);

    // Assert
    assertSame(builderResult, actualBooleanResponseResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   *   <li>{@link Builder#dateResponse(LocalDate)}
   *   <li>{@link Builder#entityListResponse(List)}
   *   <li>{@link Builder#entityResponse(EntityReference)}
   *   <li>{@link Builder#listResponse(List)}
   *   <li>{@link Builder#stringResponse(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.dateResponse(LocalDate)",
    "Builder Builder.entityListResponse(List)",
    "Builder Builder.entityResponse(EntityReference)",
    "Builder Builder.listResponse(List)",
    "Builder Builder.stringResponse(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);
    Builder actualCommentResult =
        actualBuilderResult
            .booleanResponse(booleanResponse)
            .booleanResponse(true)
            .comment("Comment");
    Optional<String> comment = Optional.of("42");
    Builder actualDateResponseResult =
        actualCommentResult.comment(comment).dateResponse(LocalDate.of(1970, 1, 1));
    Optional<? extends LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    Builder actualDateResponseResult2 = actualDateResponseResult.dateResponse(dateResponse);
    Builder actualEntityListResponseResult =
        actualDateResponseResult2.entityListResponse(new ArrayList<>());
    Optional<? extends List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    Builder actualEntityListResponseResult2 =
        actualEntityListResponseResult.entityListResponse(entityListResponse);
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
    Builder actualEntityResponseResult =
        actualEntityListResponseResult2.entityResponse(entityResponse);
    Builder actualEntityResponseResult2 =
        actualEntityResponseResult.entityResponse(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    Builder actualListResponseResult = actualEntityResponseResult2.listResponse(new ArrayList<>());
    Optional<? extends List<String>> listResponse = Optional.of(new ArrayList<>());
    Builder actualNumberResponseResult =
        actualListResponseResult.listResponse(listResponse).numberResponse(10.0d);
    Optional<Double> numberResponse = Optional.of(10.0d);
    Builder actualStringResponseResult =
        actualNumberResponseResult
            .numberResponse(numberResponse)
            .questionId(1L)
            .stringResponse("String Response");
    Optional<String> stringResponse = Optional.of("42");

    // Assert
    assertEquals(
        1L,
        actualStringResponseResult.stringResponse(stringResponse).build().questionId().longValue());
  }

  /**
   * Test Builder {@link Builder#comment(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#comment(Optional)}
   */
  @Test
  @DisplayName("Test Builder comment(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.comment(Optional)"})
  void testBuilderCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<String> comment = Optional.of("42");

    // Act
    Builder actualCommentResult = builderResult.comment(comment);

    // Assert
    assertSame(builderResult, actualCommentResult);
  }

  /**
   * Test Builder {@link Builder#dateResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#dateResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder dateResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dateResponse(Optional)"})
  void testBuilderDateResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    Builder actualDateResponseResult = builderResult.dateResponse(dateResponse);

    // Assert
    assertSame(builderResult, actualDateResponseResult);
  }

  /**
   * Test Builder {@link Builder#entityListResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#entityListResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder entityListResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityListResponse(Optional)"})
  void testBuilderEntityListResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());

    // Act
    Builder actualEntityListResponseResult = builderResult.entityListResponse(entityListResponse);

    // Assert
    assertSame(builderResult, actualEntityListResponseResult);
  }

  /**
   * Test Builder {@link Builder#entityResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#entityResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder entityResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityResponse(Optional)"})
  void testBuilderEntityResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
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

    // Act
    Builder actualEntityResponseResult = builderResult.entityResponse(entityResponse);

    // Assert
    assertSame(builderResult, actualEntityResponseResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

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
    ImmutableSurveyQuestionResponse instance =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionResponse actualImmutableSurveyQuestionResponse = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.empty();

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
    ImmutableSurveyQuestionResponse instance =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionResponse actualImmutableSurveyQuestionResponse = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponse)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponse)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult2
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    Optional<? extends EntityReference> entityResponse = Optional.empty();

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse instance =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionResponse actualImmutableSurveyQuestionResponse = builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#listResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#listResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder listResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.listResponse(Optional)"})
  void testBuilderListResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<? extends List<String>> listResponse = Optional.of(new ArrayList<>());

    // Act
    Builder actualListResponseResult = builderResult.listResponse(listResponse);

    // Assert
    assertSame(builderResult, actualListResponseResult);
  }

  /**
   * Test Builder {@link Builder#numberResponse(double)} with {@code double}.
   *
   * <p>Method under test: {@link Builder#numberResponse(double)}
   */
  @Test
  @DisplayName("Test Builder numberResponse(double) with 'double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.numberResponse(double)"})
  void testBuilderNumberResponseWithDouble() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act
    Builder actualNumberResponseResult = builderResult.numberResponse(10.0d);

    // Assert
    assertSame(builderResult, actualNumberResponseResult);
  }

  /**
   * Test Builder {@link Builder#numberResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#numberResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder numberResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.numberResponse(Optional)"})
  void testBuilderNumberResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Double> numberResponse = Optional.of(10.0d);

    // Act
    Builder actualNumberResponseResult = builderResult.numberResponse(numberResponse);

    // Assert
    assertSame(builderResult, actualNumberResponseResult);
  }

  /**
   * Test Builder {@link Builder#questionId(Long)}.
   *
   * <p>Method under test: {@link Builder#questionId(Long)}
   */
  @Test
  @DisplayName("Test Builder questionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.questionId(Long)"})
  void testBuilderQuestionId() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();

    // Act
    Builder actualQuestionIdResult = builderResult.questionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().questionId().longValue());
    assertSame(builderResult, actualQuestionIdResult);
  }

  /**
   * Test Builder {@link Builder#stringResponse(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#stringResponse(Optional)}
   */
  @Test
  @DisplayName("Test Builder stringResponse(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.stringResponse(Optional)"})
  void testBuilderStringResponseWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<String> stringResponse = Optional.of("42");

    // Act
    Builder actualStringResponseResult = builderResult.stringResponse(stringResponse);

    // Assert
    assertSame(builderResult, actualStringResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#comment()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#comment()}
   */
  @Test
  @DisplayName("Test comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.comment()"})
  void testComment() {
    // Arrange
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
    Optional<String> actualCommentResult =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .comment();

    // Assert
    assertEquals("Comment", actualCommentResult.get());
    assertTrue(actualCommentResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#copyOf(SurveyQuestionResponse)}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#copyOf(SurveyQuestionResponse)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyQuestionResponse); then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.copyOf(SurveyQuestionResponse)"
  })
  void testCopyOf_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    ImmutableSurveyQuestionResponse instance =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act and Assert
    assertEquals(1L, ImmutableSurveyQuestionResponse.copyOf(instance).questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#dateResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#dateResponse()}
   */
  @Test
  @DisplayName("Test dateResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.dateResponse()"})
  void testDateResponse() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);
    LocalDate dateResponse = LocalDate.of(1970, 1, 1);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(dateResponse);

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
    Optional<LocalDate> actualDateResponseResult =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .dateResponse();

    // Assert
    LocalDate getResult = actualDateResponseResult.get();
    assertEquals("1970-01-01", getResult.toString());
    assertTrue(actualDateResponseResult.isPresent());
    assertSame(dateResponse, getResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#entityListResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#entityListResponse()}
   */
  @Test
  @DisplayName("Test entityListResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.entityListResponse()"})
  void testEntityListResponse() {
    // Arrange
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
    Optional<List<EntityReference>> actualEntityListResponseResult =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .entityListResponse();

    // Assert
    assertTrue(actualEntityListResponseResult.get().isEmpty());
    assertTrue(actualEntityListResponseResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#entityResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#entityResponse()}
   */
  @Test
  @DisplayName("Test entityResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.entityResponse()"})
  void testEntityResponse() {
    // Arrange
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
    assertEquals(
        entityResponse,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .entityResponse());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}, and {@link
   * ImmutableSurveyQuestionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponse#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse2 =
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionResponse, immutableSurveyQuestionResponse2);
    assertEquals(
        immutableSurveyQuestionResponse.hashCode(), immutableSurveyQuestionResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}, and {@link
   * ImmutableSurveyQuestionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponse#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyQuestionResponse, immutableSurveyQuestionResponse);
    int expectedHashCodeResult = immutableSurveyQuestionResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyQuestionResponse.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("comment")
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.now());

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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<EntityReference> entityListResponse = new ArrayList<>();
    entityListResponse.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder entityListResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1))
            .entityListResponse(entityListResponse);
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult.entityListResponse(new ArrayList<>());
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
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
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
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<String> listResponse = new ArrayList<>();
    listResponse.add("foo");

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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityListResponseResult
            .entityResponse(entityResponse)
            .listResponse(listResponse)
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
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

    Builder entityResponseResult = entityListResponseResult2.entityResponse(entityResponse2);

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(0.5d)
            .questionId(1L)
            .stringResponse("String Response")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(2L)
            .stringResponse("String Response")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("comment")
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

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponse,
        entityResponseResult2
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
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
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponse.equals(Object)",
    "int ImmutableSurveyQuestionResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
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
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build(),
        "Different type to ImmutableSurveyQuestionResponse");
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Comment is {@code null}.
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Comment is 'null'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonCommentIsNull_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    json.setComment(null);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) NumberResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) NumberResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonNumberResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    json.setNumberResponse(null);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) StringResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) StringResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonStringResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    json.setStringResponse(null);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of ten.
   *   <li>When {@link Json} (default constructor) BooleanResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of ten; when Json (default constructor) BooleanResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenOfTen_whenJsonBooleanResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    json.setBooleanResponse(null);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of ten.
   *   <li>When {@link Json} (default constructor) Comment is of {@code 42}.
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of ten; when Json (default constructor) Comment is of '42'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenOfTen_whenJsonCommentIsOf42_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of ten.
   *   <li>When {@link Json} (default constructor) DateResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of ten; when Json (default constructor) DateResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenOfTen_whenJsonDateResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    json.setDateResponse(null);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of ten.
   *   <li>When {@link Json} (default constructor) EntityListResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of ten; when Json (default constructor) EntityListResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenOfTen_whenJsonEntityListResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    json.setEntityListResponse(null);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of ten.
   *   <li>When {@link Json} (default constructor) EntityResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of ten; when Json (default constructor) EntityResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenOfTen_whenJsonEntityResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    json.setEntityResponse(null);
    Optional<List<String>> listResponse = Optional.of(new ArrayList<>());
    json.setListResponse(listResponse);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of ten.
   *   <li>When {@link Json} (default constructor) ListResponse is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of ten; when Json (default constructor) ListResponse is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.fromJson(Json)"
  })
  void testFromJson_givenOfTen_whenJsonListResponseIsNull() {
    // Arrange
    Json json = new Json();
    json.setQuestionId(1L);
    Optional<String> comment = Optional.of("42");
    json.setComment(comment);
    Optional<String> stringResponse = Optional.of("42");
    json.setStringResponse(stringResponse);
    Optional<Double> numberResponse = Optional.of(10.0d);
    json.setNumberResponse(numberResponse);
    Optional<Boolean> booleanResponse = Optional.of(true);
    json.setBooleanResponse(booleanResponse);
    Optional<LocalDate> dateResponse = Optional.of(LocalDate.of(1970, 1, 1));
    json.setDateResponse(dateResponse);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> entityResponse = Optional.of(immutableEntityReference);
    json.setEntityResponse(entityResponse);
    json.setListResponse(null);
    Optional<List<EntityReference>> entityListResponse = Optional.of(new ArrayList<>());
    json.setEntityListResponse(entityListResponse);

    // Act
    ImmutableSurveyQuestionResponse actualFromJsonResult =
        ImmutableSurveyQuestionResponse.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.questionId().longValue());
  }

  /**
   * Test Json {@link Json#booleanResponse()}.
   *
   * <p>Method under test: {@link Json#booleanResponse()}
   */
  @Test
  @DisplayName("Test Json booleanResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.booleanResponse()"})
  void testJsonBooleanResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().booleanResponse());
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
  @MethodsUnderTest({"Optional Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json {@link Json#dateResponse()}.
   *
   * <p>Method under test: {@link Json#dateResponse()}
   */
  @Test
  @DisplayName("Test Json dateResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.dateResponse()"})
  void testJsonDateResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dateResponse());
  }

  /**
   * Test Json {@link Json#entityListResponse()}.
   *
   * <p>Method under test: {@link Json#entityListResponse()}
   */
  @Test
  @DisplayName("Test Json entityListResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.entityListResponse()"})
  void testJsonEntityListResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityListResponse());
  }

  /**
   * Test Json {@link Json#entityResponse()}.
   *
   * <p>Method under test: {@link Json#entityResponse()}
   */
  @Test
  @DisplayName("Test Json entityResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.entityResponse()"})
  void testJsonEntityResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityResponse());
  }

  /**
   * Test Json {@link Json#listResponse()}.
   *
   * <p>Method under test: {@link Json#listResponse()}
   */
  @Test
  @DisplayName("Test Json listResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.listResponse()"})
  void testJsonListResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().listResponse());
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
    assertNull(actualJson.questionId);
    assertFalse(actualJson.booleanResponse.isPresent());
    assertFalse(actualJson.comment.isPresent());
    assertFalse(actualJson.dateResponse.isPresent());
    assertFalse(actualJson.entityListResponse.isPresent());
    assertFalse(actualJson.entityResponse.isPresent());
    assertFalse(actualJson.listResponse.isPresent());
    assertFalse(actualJson.numberResponse.isPresent());
    assertFalse(actualJson.stringResponse.isPresent());
  }

  /**
   * Test Json {@link Json#numberResponse()}.
   *
   * <p>Method under test: {@link Json#numberResponse()}
   */
  @Test
  @DisplayName("Test Json numberResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.numberResponse()"})
  void testJsonNumberResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().numberResponse());
  }

  /**
   * Test Json {@link Json#questionId()}.
   *
   * <p>Method under test: {@link Json#questionId()}
   */
  @Test
  @DisplayName("Test Json questionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.questionId()"})
  void testJsonQuestionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().questionId());
  }

  /**
   * Test Json {@link Json#stringResponse()}.
   *
   * <p>Method under test: {@link Json#stringResponse()}
   */
  @Test
  @DisplayName("Test Json stringResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.stringResponse()"})
  void testJsonStringResponse() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().stringResponse());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#listResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#listResponse()}
   */
  @Test
  @DisplayName("Test listResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.listResponse()"})
  void testListResponse() {
    // Arrange
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
    Optional<List<String>> actualListResponseResult =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .listResponse();

    // Assert
    assertTrue(actualListResponseResult.get().isEmpty());
    assertTrue(actualListResponseResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#numberResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#numberResponse()}
   */
  @Test
  @DisplayName("Test numberResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.numberResponse()"})
  void testNumberResponse() {
    // Arrange
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
    Optional<Double> actualNumberResponseResult =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .numberResponse();

    // Assert
    assertEquals(10.0d, actualNumberResponseResult.get().doubleValue());
    assertTrue(actualNumberResponseResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#questionId()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#questionId()}
   */
  @Test
  @DisplayName("Test questionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ImmutableSurveyQuestionResponse.questionId()"})
  void testQuestionId() {
    // Arrange
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
    assertEquals(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .questionId()
            .longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#stringResponse()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#stringResponse()}
   */
  @Test
  @DisplayName("Test stringResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSurveyQuestionResponse.stringResponse()"})
  void testStringResponse() {
    // Arrange
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
    Optional<String> actualStringResponseResult =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .stringResponse();

    // Assert
    assertEquals("String Response", actualStringResponseResult.get());
    assertTrue(actualStringResponseResult.isPresent());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionResponse.toString()"})
  void testToString() {
    // Arrange
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
    assertEquals(
        "SurveyQuestionResponse{questionId=1, comment=Comment, stringResponse=String Response, numberResponse=10.0,"
            + " booleanResponse=true, dateResponse=1970-01-01, entityResponse=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, listResponse=[], entityListResponse=[]}",
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionResponse.toString()"})
  void testToString2() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.empty();

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
    assertEquals(
        "SurveyQuestionResponse{questionId=1, comment=Comment, stringResponse=String Response, numberResponse=10.0,"
            + " dateResponse=1970-01-01, entityResponse=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " listResponse=[], entityListResponse=[]}",
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSurveyQuestionResponse.toString()"})
  void testToString3() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    Optional<? extends EntityReference> entityResponse = Optional.empty();

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);

    // Act and Assert
    assertEquals(
        "SurveyQuestionResponse{questionId=1, comment=Comment, stringResponse=String Response, numberResponse=10.0,"
            + " booleanResponse=true, dateResponse=1970-01-01, listResponse=[], entityListResponse=[]}",
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withBooleanResponse(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withBooleanResponse(Optional)}
   */
  @Test
  @DisplayName("Test withBooleanResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withBooleanResponse(Optional)"
  })
  void testWithBooleanResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<Boolean> optional = Optional.of(true);

    // Act
    ImmutableSurveyQuestionResponse actualWithBooleanResponseResult =
        immutableSurveyQuestionResponse.withBooleanResponse(optional);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithBooleanResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withBooleanResponse(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withBooleanResponse(Optional)}
   */
  @Test
  @DisplayName(
      "Test withBooleanResponse(Optional) with 'optional'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withBooleanResponse(Optional)"
  })
  void testWithBooleanResponseWithOptional_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<Boolean> optional = Optional.of(true);

    // Act and Assert
    assertEquals(
        1L, immutableSurveyQuestionResponse.withBooleanResponse(optional).questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withBooleanResponse(boolean)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withBooleanResponse(boolean)}
   */
  @Test
  @DisplayName("Test withBooleanResponse(boolean) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withBooleanResponse(boolean)"
  })
  void testWithBooleanResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithBooleanResponseResult =
        immutableSurveyQuestionResponse.withBooleanResponse(true);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithBooleanResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withBooleanResponse(boolean)} with {@code value}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withBooleanResponse(boolean)}
   */
  @Test
  @DisplayName(
      "Test withBooleanResponse(boolean) with 'value'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withBooleanResponse(boolean)"
  })
  void testWithBooleanResponseWithValue_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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

    // Act and Assert
    assertEquals(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .withBooleanResponse(true)
            .questionId()
            .longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withComment(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withComment(Optional)}
   */
  @Test
  @DisplayName("Test withComment(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withComment(Optional)"
  })
  void testWithCommentWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("42")
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestionResponse actualWithCommentResult =
        immutableSurveyQuestionResponse.withComment(optional);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withComment(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withComment(Optional)}
   */
  @Test
  @DisplayName(
      "Test withComment(Optional) with 'optional'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withComment(Optional)"
  })
  void testWithCommentWithOptional_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertEquals(
        1L, immutableSurveyQuestionResponse.withComment(optional).questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withComment(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withComment(String)"
  })
  void testWithCommentWithValue() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("42")
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithCommentResult =
        immutableSurveyQuestionResponse.withComment("42");

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withComment(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String) with 'value'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withComment(String)"
  })
  void testWithCommentWithValue_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    assertEquals(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .withComment("42")
            .questionId()
            .longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withDateResponse(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withDateResponse(Optional)}
   */
  @Test
  @DisplayName("Test withDateResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withDateResponse(Optional)"
  })
  void testWithDateResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<? extends LocalDate> optional = Optional.of(LocalDate.of(1970, 1, 1));

    // Act
    ImmutableSurveyQuestionResponse actualWithDateResponseResult =
        immutableSurveyQuestionResponse.withDateResponse(optional);

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithDateResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withDateResponse(LocalDate)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withDateResponse(LocalDate)}
   */
  @Test
  @DisplayName("Test withDateResponse(LocalDate) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withDateResponse(LocalDate)"
  })
  void testWithDateResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithDateResponseResult =
        immutableSurveyQuestionResponse.withDateResponse(LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithDateResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withEntityListResponse(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withEntityListResponse(Optional)}
   */
  @Test
  @DisplayName("Test withEntityListResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withEntityListResponse(Optional)"
  })
  void testWithEntityListResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<? extends List<EntityReference>> optional = Optional.of(new ArrayList<>());

    // Act
    ImmutableSurveyQuestionResponse actualWithEntityListResponseResult =
        immutableSurveyQuestionResponse.withEntityListResponse(optional);

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithEntityListResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withEntityListResponse(List)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withEntityListResponse(List)}
   */
  @Test
  @DisplayName("Test withEntityListResponse(List) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withEntityListResponse(List)"
  })
  void testWithEntityListResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithEntityListResponseResult =
        immutableSurveyQuestionResponse.withEntityListResponse(new ArrayList<>());

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithEntityListResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withEntityResponse(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withEntityResponse(Optional)}
   */
  @Test
  @DisplayName("Test withEntityResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withEntityResponse(Optional)"
  })
  void testWithEntityResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableSurveyQuestionResponse actualWithEntityResponseResult =
        immutableSurveyQuestionResponse.withEntityResponse(optional);

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithEntityResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withEntityResponse(EntityReference)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponse#withEntityResponse(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityResponse(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withEntityResponse(EntityReference)"
  })
  void testWithEntityResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithEntityResponseResult =
        immutableSurveyQuestionResponse.withEntityResponse(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithEntityResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withListResponse(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withListResponse(Optional)}
   */
  @Test
  @DisplayName("Test withListResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withListResponse(Optional)"
  })
  void testWithListResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<? extends List<String>> optional = Optional.of(new ArrayList<>());

    // Act
    ImmutableSurveyQuestionResponse actualWithListResponseResult =
        immutableSurveyQuestionResponse.withListResponse(optional);

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithListResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withListResponse(List)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withListResponse(List)}
   */
  @Test
  @DisplayName("Test withListResponse(List) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withListResponse(List)"
  })
  void testWithListResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithListResponseResult =
        immutableSurveyQuestionResponse.withListResponse(new ArrayList<>());

    // Assert
    assertEquals(immutableSurveyQuestionResponse, actualWithListResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withNumberResponse(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withNumberResponse(Optional)}
   */
  @Test
  @DisplayName("Test withNumberResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withNumberResponse(Optional)"
  })
  void testWithNumberResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<Double> optional = Optional.of(10.0d);

    // Act
    ImmutableSurveyQuestionResponse actualWithNumberResponseResult =
        immutableSurveyQuestionResponse.withNumberResponse(optional);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithNumberResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withNumberResponse(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withNumberResponse(Optional)}
   */
  @Test
  @DisplayName(
      "Test withNumberResponse(Optional) with 'optional'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withNumberResponse(Optional)"
  })
  void testWithNumberResponseWithOptional_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(0.5d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<Double> optional = Optional.of(10.0d);

    // Act and Assert
    assertEquals(
        1L, immutableSurveyQuestionResponse.withNumberResponse(optional).questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withNumberResponse(double)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withNumberResponse(double)}
   */
  @Test
  @DisplayName("Test withNumberResponse(double) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withNumberResponse(double)"
  })
  void testWithNumberResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithNumberResponseResult =
        immutableSurveyQuestionResponse.withNumberResponse(10.0d);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithNumberResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withNumberResponse(double)} with {@code value}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withNumberResponse(double)}
   */
  @Test
  @DisplayName(
      "Test withNumberResponse(double) with 'value'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withNumberResponse(double)"
  })
  void testWithNumberResponseWithValue_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    assertEquals(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(0.5d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .withNumberResponse(10.0d)
            .questionId()
            .longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withQuestionId(Long)}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withQuestionId(Long)}
   */
  @Test
  @DisplayName("Test withQuestionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withQuestionId(Long)"
  })
  void testWithQuestionId() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithQuestionIdResult =
        immutableSurveyQuestionResponse.withQuestionId(1L);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithQuestionIdResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withQuestionId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return questionId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withQuestionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withQuestionId(Long); when forty-two; then return questionId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withQuestionId(Long)"
  })
  void testWithQuestionId_whenFortyTwo_thenReturnQuestionIdLongValueIsFortyTwo() {
    // Arrange
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
    assertEquals(
        42L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .withQuestionId(42L)
            .questionId()
            .longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withStringResponse(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withStringResponse(Optional)}
   */
  @Test
  @DisplayName("Test withStringResponse(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withStringResponse(Optional)"
  })
  void testWithStringResponseWithOptional() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("42")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableSurveyQuestionResponse actualWithStringResponseResult =
        immutableSurveyQuestionResponse.withStringResponse(optional);

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithStringResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withStringResponse(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withStringResponse(Optional)}
   */
  @Test
  @DisplayName(
      "Test withStringResponse(Optional) with 'optional'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withStringResponse(Optional)"
  })
  void testWithStringResponseWithOptional_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertEquals(
        1L, immutableSurveyQuestionResponse.withStringResponse(optional).questionId().longValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withStringResponse(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withStringResponse(String)}
   */
  @Test
  @DisplayName("Test withStringResponse(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withStringResponse(String)"
  })
  void testWithStringResponseWithValue() {
    // Arrange
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
    ImmutableSurveyQuestionResponse immutableSurveyQuestionResponse =
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("42")
            .build();

    // Act
    ImmutableSurveyQuestionResponse actualWithStringResponseResult =
        immutableSurveyQuestionResponse.withStringResponse("42");

    // Assert
    assertSame(immutableSurveyQuestionResponse, actualWithStringResponseResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponse#withStringResponse(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return questionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponse#withStringResponse(String)}
   */
  @Test
  @DisplayName(
      "Test withStringResponse(String) with 'value'; then return questionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponse ImmutableSurveyQuestionResponse.withStringResponse(String)"
  })
  void testWithStringResponseWithValue_thenReturnQuestionIdLongValueIsOne() {
    // Arrange
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
    assertEquals(
        1L,
        entityResponseResult
            .listResponse(new ArrayList<>())
            .numberResponse(10.0d)
            .questionId(1L)
            .stringResponse("String Response")
            .build()
            .withStringResponse("42")
            .questionId()
            .longValue());
  }
}
