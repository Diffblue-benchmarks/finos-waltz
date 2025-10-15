package org.finos.waltz.model.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Builder;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse.Json;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppRegistrationResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#message(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse Builder.build()",
    "Builder Builder.message(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult = ImmutableAppRegistrationResponse.builder().id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualMessageResult = actualIdResult.id(id).message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");
    Builder actualMessageResult2 = actualMessageResult.message(message);
    ImmutableAppRegistrationRequest originalRequest =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();
    ImmutableAppRegistrationResponse actualImmutableAppRegistrationResponse =
        actualMessageResult2.originalRequest(originalRequest).build();

    // Assert
    assertTrue(actualImmutableAppRegistrationResponse.registered());
    assertSame(originalRequest, actualImmutableAppRegistrationResponse.originalRequest());
  }

  /**
   * Test Builder {@link Builder#from(AppRegistrationResponse)}.
   *
   * <p>Method under test: {@link Builder#from(AppRegistrationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(AppRegistrationResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppRegistrationResponse)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();

    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse instance =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppRegistrationResponse actualImmutableAppRegistrationResponse = builderResult.build();
    assertEquals(instance, actualImmutableAppRegistrationResponse);
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
    Builder builderResult = ImmutableAppRegistrationResponse.builder();

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
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#message(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.message(Optional)"})
  void testBuilderMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act
    Builder actualMessageResult = builderResult.message(message);

    // Assert
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#originalRequest(AppRegistrationRequest)}.
   *
   * <ul>
   *   <li>When {@link ImmutableAppRegistrationRequest.Json} (default constructor).
   *   <li>Then not builder build registered.
   * </ul>
   *
   * <p>Method under test: {@link Builder#originalRequest(AppRegistrationRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder originalRequest(AppRegistrationRequest); when Json (default constructor); then not builder build registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.originalRequest(AppRegistrationRequest)"})
  void testBuilderOriginalRequest_whenJson_thenNotBuilderBuildRegistered() {
    // Arrange
    Builder builderResult = ImmutableAppRegistrationResponse.builder();
    ImmutableAppRegistrationRequest.Json originalRequest =
        new ImmutableAppRegistrationRequest.Json();

    // Act
    Builder actualOriginalRequestResult = builderResult.originalRequest(originalRequest);

    // Assert
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse = builderResult.build();
    assertFalse(immutableAppRegistrationResponse.registered());
    assertSame(originalRequest, immutableAppRegistrationResponse.originalRequest());
    assertSame(builderResult, actualOriginalRequestResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#copyOf(AppRegistrationResponse)}.
   *
   * <ul>
   *   <li>Then originalRequest return {@link ImmutableAppRegistrationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#copyOf(AppRegistrationResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppRegistrationResponse); then originalRequest return ImmutableAppRegistrationRequest")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.copyOf(AppRegistrationResponse)"
  })
  void testCopyOf_thenOriginalRequestReturnImmutableAppRegistrationRequest() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse instance =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableAppRegistrationResponse actualCopyOfResult =
        ImmutableAppRegistrationResponse.copyOf(instance);

    // Assert
    AppRegistrationRequest originalRequestResult = actualCopyOfResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertEquals("Name", originalRequestResult.name());
    assertEquals("Provenance", originalRequestResult.provenance());
    assertEquals(
        "The characteristics of someone or something", originalRequestResult.description());
    assertEquals(1L, originalRequestResult.organisationalUnitId());
    assertEquals(Criticality.LOW, originalRequestResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, originalRequestResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, originalRequestResult.lifecyclePhase());
    assertEquals(RagRating.R, originalRequestResult.overallRating());
    Set<String> aliasesResult = originalRequestResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertTrue(actualCopyOfResult.registered());
    assertSame(aliasesResult, originalRequestResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}, and {@link
   * ImmutableAppRegistrationResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppRegistrationResponse#equals(Object)}
   *   <li>{@link ImmutableAppRegistrationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse2 =
        messageResult2
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAppRegistrationResponse, immutableAppRegistrationResponse2);
    assertEquals(
        immutableAppRegistrationResponse.hashCode(), immutableAppRegistrationResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}, and {@link
   * ImmutableAppRegistrationResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppRegistrationResponse#equals(Object)}
   *   <li>{@link ImmutableAppRegistrationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAppRegistrationResponse, immutableAppRegistrationResponse);
    int expectedHashCodeResult = immutableAppRegistrationResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppRegistrationResponse.hashCode());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(2L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationResponse,
        messageResult2
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder messageResult = ImmutableAppRegistrationResponse.builder().id(1L).message("Name");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationResponse,
        messageResult2
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult =
        ImmutableAppRegistrationRequest.builder();
    builderResult.addAliases("Name");
    ImmutableAppRegistrationRequest originalRequest =
        builderResult
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        ImmutableAppRegistrationResponse.builder()
            .id(1L)
            .message("Not all who wander are lost")
            .originalRequest(originalRequest)
            .build();

    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        immutableAppRegistrationResponse,
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppRegistrationResponse.equals(Object)",
    "int ImmutableAppRegistrationResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertNotEquals(
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutableAppRegistrationResponse");
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ImmutableAppRegistrationRequest.Json} (default constructor).
   *   <li>When {@link Json} (default constructor) Id is {@code null}.
   *   <li>Then return not registered.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given Json (default constructor); when Json (default constructor) Id is 'null'; then return not registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.fromJson(Json)"
  })
  void testFromJson_givenJson_whenJsonIdIsNull_thenReturnNotRegistered() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setMessage(null);
    ImmutableAppRegistrationRequest.Json originalRequest =
        new ImmutableAppRegistrationRequest.Json();
    json.setOriginalRequest(originalRequest);

    // Act
    ImmutableAppRegistrationResponse actualFromJsonResult =
        ImmutableAppRegistrationResponse.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.registered());
    assertSame(originalRequest, actualFromJsonResult.originalRequest());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) Message is of {@code foo}.
   *   <li>Then return not registered.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) Message is of 'foo'; then return not registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.fromJson(Json)"
  })
  void testFromJson_givenOfFoo_whenJsonMessageIsOfFoo_thenReturnNotRegistered() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    Optional<String> message = Optional.of("foo");
    json.setMessage(message);
    ImmutableAppRegistrationRequest.Json originalRequest =
        new ImmutableAppRegistrationRequest.Json();
    json.setOriginalRequest(originalRequest);

    // Act
    ImmutableAppRegistrationResponse actualFromJsonResult =
        ImmutableAppRegistrationResponse.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.registered());
    assertSame(originalRequest, actualFromJsonResult.originalRequest());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) Id is of one.
   *   <li>Then return registered.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) Id is of one; then return registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.fromJson(Json)"
  })
  void testFromJson_givenOfOne_whenJsonIdIsOfOne_thenReturnRegistered() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(1L);
    json.setId(id);
    json.setMessage(null);
    ImmutableAppRegistrationRequest.Json originalRequest =
        new ImmutableAppRegistrationRequest.Json();
    json.setOriginalRequest(originalRequest);

    // Act
    ImmutableAppRegistrationResponse actualFromJsonResult =
        ImmutableAppRegistrationResponse.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.registered());
    assertSame(originalRequest, actualFromJsonResult.originalRequest());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppRegistrationResponse#originalRequest()}
   *   <li>{@link ImmutableAppRegistrationResponse#registered()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AppRegistrationRequest ImmutableAppRegistrationResponse.originalRequest()",
    "boolean ImmutableAppRegistrationResponse.registered()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    AppRegistrationRequest actualOriginalRequestResult =
        immutableAppRegistrationResponse.originalRequest();

    // Assert
    assertTrue(actualOriginalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertTrue(immutableAppRegistrationResponse.registered());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#id()}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppRegistrationResponse.id()"})
  void testId() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act
    Optional<Long> actualIdResult =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
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
    assertNull(actualJson.originalRequest);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.message.isPresent());
  }

  /**
   * Test Json {@link Json#originalRequest()}.
   *
   * <p>Method under test: {@link Json#originalRequest()}
   */
  @Test
  @DisplayName("Test Json originalRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationRequest Json.originalRequest()"})
  void testJsonOriginalRequest() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().originalRequest());
  }

  /**
   * Test Json {@link Json#registered()}.
   *
   * <p>Method under test: {@link Json#registered()}
   */
  @Test
  @DisplayName("Test Json registered()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.registered()"})
  void testJsonRegistered() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().registered());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#message()}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableAppRegistrationResponse.message()"})
  void testMessage() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act
    Optional<String> actualMessageResult =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build()
            .message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableAppRegistrationResponse.toString()"})
  void testToString() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act and Assert
    assertEquals(
        "AppRegistrationResponse{id=1, message=Not all who wander are lost, originalRequest=AppRegistrationRequest"
            + "{name=Name, provenance=Provenance, organisationalUnitId=1, applicationKind=IN_HOUSE, lifecyclePhase"
            + "=PRODUCTION, assetCode=Asset Code, parentAssetCode=Parent Asset Code, aliases=[], tags=[], overallRating=R,"
            + " businessCriticality=LOW}, registered=true}",
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAppRegistrationResponse actualWithIdResult =
        immutableAppRegistrationResponse.withId(optional);

    // Assert
    assertSame(immutableAppRegistrationResponse, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then originalRequest return {@link ImmutableAppRegistrationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then originalRequest return ImmutableAppRegistrationRequest")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withId(Optional)"
  })
  void testWithIdWithOptional_thenOriginalRequestReturnImmutableAppRegistrationRequest() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(2L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableAppRegistrationResponse actualWithIdResult =
        immutableAppRegistrationResponse.withId(optional);

    // Assert
    AppRegistrationRequest originalRequestResult = actualWithIdResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertEquals("Name", originalRequestResult.name());
    assertEquals("Provenance", originalRequestResult.provenance());
    assertEquals(
        "The characteristics of someone or something", originalRequestResult.description());
    assertEquals(1L, originalRequestResult.organisationalUnitId());
    assertEquals(Criticality.LOW, originalRequestResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, originalRequestResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, originalRequestResult.lifecyclePhase());
    assertEquals(RagRating.R, originalRequestResult.overallRating());
    Set<String> aliasesResult = originalRequestResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertTrue(actualWithIdResult.registered());
    assertSame(aliasesResult, originalRequestResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableAppRegistrationResponse actualWithIdResult =
        immutableAppRegistrationResponse.withId(1L);

    // Assert
    assertSame(immutableAppRegistrationResponse, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then originalRequest return {@link ImmutableAppRegistrationRequest}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long) with 'value'; then originalRequest return ImmutableAppRegistrationRequest")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withId(long)"
  })
  void testWithIdWithValue_thenOriginalRequestReturnImmutableAppRegistrationRequest() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act
    ImmutableAppRegistrationResponse actualWithIdResult =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build()
            .withId(42L);

    // Assert
    AppRegistrationRequest originalRequestResult = actualWithIdResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertEquals("Name", originalRequestResult.name());
    assertEquals("Provenance", originalRequestResult.provenance());
    assertEquals(
        "The characteristics of someone or something", originalRequestResult.description());
    assertEquals(1L, originalRequestResult.organisationalUnitId());
    assertEquals(Criticality.LOW, originalRequestResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, originalRequestResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, originalRequestResult.lifecyclePhase());
    assertEquals(RagRating.R, originalRequestResult.overallRating());
    Set<String> aliasesResult = originalRequestResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertTrue(actualWithIdResult.registered());
    assertSame(aliasesResult, originalRequestResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withMessage(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableAppRegistrationResponse actualWithMessageResult =
        immutableAppRegistrationResponse.withMessage(optional);

    // Assert
    AppRegistrationRequest originalRequestResult = actualWithMessageResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertEquals("Name", originalRequestResult.name());
    assertEquals("Provenance", originalRequestResult.provenance());
    assertEquals(
        "The characteristics of someone or something", originalRequestResult.description());
    assertEquals(1L, originalRequestResult.organisationalUnitId());
    assertEquals(Criticality.LOW, originalRequestResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, originalRequestResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, originalRequestResult.lifecyclePhase());
    assertEquals(RagRating.R, originalRequestResult.overallRating());
    Set<String> aliasesResult = originalRequestResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertTrue(actualWithMessageResult.registered());
    assertSame(aliasesResult, originalRequestResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withMessage(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withMessage(String)"
  })
  void testWithMessageWithValue() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");

    // Act
    ImmutableAppRegistrationResponse actualWithMessageResult =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build()
            .withMessage("42");

    // Assert
    AppRegistrationRequest originalRequestResult = actualWithMessageResult.originalRequest();
    assertTrue(originalRequestResult instanceof ImmutableAppRegistrationRequest);
    assertEquals("Name", originalRequestResult.name());
    assertEquals("Provenance", originalRequestResult.provenance());
    assertEquals(
        "The characteristics of someone or something", originalRequestResult.description());
    assertEquals(1L, originalRequestResult.organisationalUnitId());
    assertEquals(Criticality.LOW, originalRequestResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, originalRequestResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, originalRequestResult.lifecyclePhase());
    assertEquals(RagRating.R, originalRequestResult.overallRating());
    Set<String> aliasesResult = originalRequestResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertTrue(actualWithMessageResult.registered());
    assertSame(aliasesResult, originalRequestResult.tags());
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withMessage(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableAppRegistrationResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withMessage(String)"
  })
  void testWithMessageWithValue2() {
    // Arrange
    Builder messageResult = ImmutableAppRegistrationResponse.builder().id(1L).message("42");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableAppRegistrationResponse actualWithMessageResult =
        immutableAppRegistrationResponse.withMessage("42");

    // Assert
    assertSame(immutableAppRegistrationResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableAppRegistrationResponse#withOriginalRequest(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link
   * ImmutableAppRegistrationResponse#withOriginalRequest(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test withOriginalRequest(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppRegistrationResponse ImmutableAppRegistrationResponse.withOriginalRequest(AppRegistrationRequest)"
  })
  void testWithOriginalRequest() {
    // Arrange
    Builder messageResult =
        ImmutableAppRegistrationResponse.builder().id(1L).message("Not all who wander are lost");
    ImmutableAppRegistrationResponse immutableAppRegistrationResponse =
        messageResult
            .originalRequest(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableAppRegistrationResponse actualWithOriginalRequestResult =
        immutableAppRegistrationResponse.withOriginalRequest(
            ImmutableAppRegistrationRequest.builder()
                .applicationKind(ApplicationKind.IN_HOUSE)
                .assetCode("Asset Code")
                .businessCriticality(Criticality.LOW)
                .description("The characteristics of someone or something")
                .lifecyclePhase(LifecyclePhase.PRODUCTION)
                .name("Name")
                .organisationalUnitId(1L)
                .overallRating(RagRating.R)
                .parentAssetCode("Parent Asset Code")
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableAppRegistrationResponse, actualWithOriginalRequestResult);
  }
}
