package org.finos.waltz.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.notification.ImmutableNotificationResponse.Builder;
import org.finos.waltz.model.notification.ImmutableNotificationResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableNotificationResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSummary(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build summary Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllSummary(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllSummary(Iterable); when ArrayList(); then return build summary Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSummary(Iterable)"})
  void testBuilderAddAllSummary_whenArrayList_thenReturnBuildSummaryEmpty() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();

    // Act
    Builder actualAddAllSummaryResult = builderResult.addAllSummary(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllSummaryResult.build().summary().isEmpty());
    assertSame(builderResult, actualAddAllSummaryResult);
  }

  /**
   * Test Builder {@link Builder#addSummary(NotificationSummary)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableNotificationSummary.Json} (default constructor).
   *   <li>Then builder build summary size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSummary(NotificationSummary)}
   */
  @Test
  @DisplayName(
      "Test Builder addSummary(NotificationSummary) with 'element'; when Json (default constructor); then builder build summary size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSummary(NotificationSummary)"})
  void testBuilderAddSummaryWithElement_whenJson_thenBuilderBuildSummarySizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    ImmutableNotificationSummary.Json element = new ImmutableNotificationSummary.Json();

    // Act
    Builder actualAddSummaryResult = builderResult.addSummary(element);

    // Assert
    List<NotificationSummary> summaryResult = builderResult.build().summary();
    assertEquals(1, summaryResult.size());
    assertSame(element, summaryResult.get(0));
    assertSame(builderResult, actualAddSummaryResult);
  }

  /**
   * Test Builder {@link Builder#addSummary(NotificationSummary[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableNotificationSummary.Json} (default constructor).
   *   <li>Then builder build summary size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSummary(NotificationSummary[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSummary(NotificationSummary[]) with 'elements'; when Json (default constructor); then builder build summary size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSummary(NotificationSummary[])"})
  void testBuilderAddSummaryWithElements_whenJson_thenBuilderBuildSummarySizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();

    // Act
    Builder actualAddSummaryResult = builderResult.addSummary(json);

    // Assert
    List<NotificationSummary> summaryResult = builderResult.build().summary();
    assertEquals(1, summaryResult.size());
    assertSame(json, summaryResult.get(0));
    assertSame(builderResult, actualAddSummaryResult);
  }

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
    "ImmutableNotificationResponse Builder.build()",
    "Builder Builder.message(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualMessageResult =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost");
    Optional<String> message = Optional.of("42");

    // Assert
    assertTrue(actualMessageResult.message(message).build().summary().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(NotificationResponse)}.
   *
   * <ul>
   *   <li>Then builder build is builder message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NotificationResponse)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NotificationResponse); then builder build is builder message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NotificationResponse)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    ImmutableNotificationResponse instance =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableNotificationResponse actualImmutableNotificationResponse = builderResult.build();
    assertEquals(instance, actualImmutableNotificationResponse);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NotificationResponse)}.
   *
   * <ul>
   *   <li>Then return build summary size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NotificationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(NotificationResponse); then return build summary size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NotificationResponse)"})
  void testBuilderFrom_thenReturnBuildSummarySizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();

    Builder builderResult2 = ImmutableNotificationResponse.builder();
    builderResult2.addSummary(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());

    // Act and Assert
    List<NotificationSummary> summaryResult =
        builderResult
            .from(builderResult2.message("Not all who wander are lost").build())
            .build()
            .summary();
    assertEquals(1, summaryResult.size());
    NotificationSummary getResult = summaryResult.get(0);
    assertTrue(getResult instanceof ImmutableNotificationSummary);
    assertEquals(3, getResult.count().intValue());
    assertEquals(EntityKind.ALL, getResult.kind());
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
    Builder builderResult = ImmutableNotificationResponse.builder();
    Optional<String> message = Optional.of("42");

    // Act
    Builder actualMessageResult = builderResult.message(message);

    // Assert
    assertTrue(actualMessageResult.build().summary().isEmpty());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#summary(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build summary Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#summary(Iterable)}
   */
  @Test
  @DisplayName("Test Builder summary(Iterable); when ArrayList(); then return build summary Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.summary(Iterable)"})
  void testBuilderSummary_whenArrayList_thenReturnBuildSummaryEmpty() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();

    // Act
    Builder actualSummaryResult = builderResult.summary(new ArrayList<>());

    // Assert
    assertTrue(actualSummaryResult.build().summary().isEmpty());
    assertSame(builderResult, actualSummaryResult);
  }

  /**
   * Test {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}.
   *
   * <ul>
   *   <li>When builder message {@code Not all who wander are lost} build.
   *   <li>Then return summary Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}
   */
  @Test
  @DisplayName(
      "Test copyOf(NotificationResponse); when builder message 'Not all who wander are lost' build; then return summary Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationResponse ImmutableNotificationResponse.copyOf(NotificationResponse)"
  })
  void testCopyOf_whenBuilderMessageNotAllWhoWanderAreLostBuild_thenReturnSummaryEmpty() {
    // Arrange
    ImmutableNotificationResponse instance =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();

    // Act and Assert
    assertTrue(ImmutableNotificationResponse.copyOf(instance).summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}, and {@link
   * ImmutableNotificationResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableNotificationResponse#equals(Object)}
   *   <li>{@link ImmutableNotificationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationResponse.equals(Object)",
    "int ImmutableNotificationResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();
    ImmutableNotificationResponse immutableNotificationResponse2 =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();

    // Act and Assert
    assertEquals(immutableNotificationResponse, immutableNotificationResponse2);
    assertEquals(
        immutableNotificationResponse.hashCode(), immutableNotificationResponse2.hashCode());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}, and {@link
   * ImmutableNotificationResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableNotificationResponse#equals(Object)}
   *   <li>{@link ImmutableNotificationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationResponse.equals(Object)",
    "int ImmutableNotificationResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();

    // Act and Assert
    assertEquals(immutableNotificationResponse, immutableNotificationResponse);
    int expectedHashCodeResult = immutableNotificationResponse.hashCode();
    assertEquals(expectedHashCodeResult, immutableNotificationResponse.hashCode());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationResponse.equals(Object)",
    "int ImmutableNotificationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    builderResult.addSummary(
        ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
    ImmutableNotificationResponse immutableNotificationResponse =
        builderResult.message("Not all who wander are lost").build();

    // Act and Assert
    assertNotEquals(
        immutableNotificationResponse,
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationResponse.equals(Object)",
    "int ImmutableNotificationResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("Message").build();

    // Act and Assert
    assertNotEquals(
        immutableNotificationResponse,
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationResponse.equals(Object)",
    "int ImmutableNotificationResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build(),
        null);
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableNotificationResponse.equals(Object)",
    "int ImmutableNotificationResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build(),
        "Different type to ImmutableNotificationResponse");
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableNotificationSummary.Json}
   *       (default constructor).
   *   <li>Then return summary size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return summary size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnSummarySizeIsOne() {
    // Arrange
    ArrayList<NotificationSummary> summary = new ArrayList<>();
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();
    summary.add(json);

    Json json2 = new Json();
    json2.setSummary(summary);
    Optional<String> message = Optional.of("42");
    json2.setMessage(message);

    // Act
    ImmutableNotificationResponse actualFromJsonResult =
        ImmutableNotificationResponse.fromJson(json2);

    // Assert
    List<NotificationSummary> summaryResult = actualFromJsonResult.summary();
    assertEquals(1, summaryResult.size());
    assertSame(json, summaryResult.get(0));
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Message is {@code null}.
   *   <li>Then return summary size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Message is 'null'; then return summary size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonMessageIsNull_thenReturnSummarySizeIsOne() {
    // Arrange
    ArrayList<NotificationSummary> summary = new ArrayList<>();
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();
    summary.add(json);

    Json json2 = new Json();
    json2.setSummary(summary);
    json2.setMessage(null);

    // Act
    ImmutableNotificationResponse actualFromJsonResult =
        ImmutableNotificationResponse.fromJson(json2);

    // Assert
    List<NotificationSummary> summaryResult = actualFromJsonResult.summary();
    assertEquals(1, summaryResult.size());
    assertSame(json, summaryResult.get(0));
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Summary is {@code null}.
   *   <li>Then return summary Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Summary is 'null'; then return summary Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonSummaryIsNull_thenReturnSummaryEmpty() {
    // Arrange
    Json json = new Json();
    json.setSummary(null);
    Optional<String> message = Optional.of("42");
    json.setMessage(message);

    // Act
    ImmutableNotificationResponse actualFromJsonResult =
        ImmutableNotificationResponse.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return summary size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return summary size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_thenReturnSummarySizeIsTwo() {
    // Arrange
    ArrayList<NotificationSummary> summary = new ArrayList<>();
    summary.add(ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build());
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();
    summary.add(json);

    Json json2 = new Json();
    json2.setSummary(summary);
    Optional<String> message = Optional.of("42");
    json2.setMessage(message);

    // Act
    ImmutableNotificationResponse actualFromJsonResult =
        ImmutableNotificationResponse.fromJson(json2);

    // Assert
    List<NotificationSummary> summaryResult = actualFromJsonResult.summary();
    assertEquals(2, summaryResult.size());
    NotificationSummary getResult = summaryResult.get(0);
    assertTrue(getResult instanceof ImmutableNotificationSummary);
    assertEquals(3, getResult.count().intValue());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertSame(json, summaryResult.get(1));
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return summary Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return summary Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnSummaryEmpty() {
    // Arrange and Act
    ImmutableNotificationResponse actualFromJsonResult =
        ImmutableNotificationResponse.fromJson(new Json());

    // Assert
    assertTrue(actualFromJsonResult.summary().isEmpty());
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
    assertFalse(actualJson.message.isPresent());
    assertTrue(actualJson.summary.isEmpty());
  }

  /**
   * Test Json {@link Json#summary()}.
   *
   * <p>Method under test: {@link Json#summary()}
   */
  @Test
  @DisplayName("Test Json summary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.summary()"})
  void testJsonSummary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().summary());
  }

  /**
   * Test {@link ImmutableNotificationResponse#message()}.
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableNotificationResponse.message()"})
  void testMessage() {
    // Arrange and Act
    Optional<String> actualMessageResult =
        ImmutableNotificationResponse.builder()
            .message("Not all who wander are lost")
            .build()
            .message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutableNotificationResponse#summary()}.
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#summary()}
   */
  @Test
  @DisplayName("Test summary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ImmutableNotificationResponse.summary()"})
  void testSummary() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableNotificationResponse.builder()
            .message("Not all who wander are lost")
            .build()
            .summary()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#toString()}.
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableNotificationResponse.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "NotificationResponse{summary=[], message=Not all who wander are lost}",
        ImmutableNotificationResponse.builder()
            .message("Not all who wander are lost")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Given builder message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName(
      "Test withMessage(Optional) with 'optional'; given builder message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional_givenBuilderMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();
    Optional<String> optional = Optional.of("42");

    // Act and Assert
    assertTrue(immutableNotificationResponse.withMessage(optional).summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return builder message {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'; then return builder message '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(Optional)"
  })
  void testWithMessageWithOptional_thenReturnBuilderMessage42Build() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("42").build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableNotificationResponse actualWithMessageResult =
        immutableNotificationResponse.withMessage(optional);

    // Assert
    assertTrue(actualWithMessageResult.summary().isEmpty());
    assertSame(immutableNotificationResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Given builder message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#withMessage(String)}
   */
  @Test
  @DisplayName(
      "Test withMessage(String) with 'value'; given builder message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(String)"
  })
  void testWithMessageWithValue_givenBuilderMessageNotAllWhoWanderAreLostBuild() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableNotificationResponse.builder()
            .message("Not all who wander are lost")
            .build()
            .withMessage("42")
            .summary()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return builder message {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'; then return builder message '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(String)"
  })
  void testWithMessageWithValue_thenReturnBuilderMessage42Build() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("42").build();

    // Act
    ImmutableNotificationResponse actualWithMessageResult =
        immutableNotificationResponse.withMessage("42");

    // Assert
    assertTrue(actualWithMessageResult.summary().isEmpty());
    assertSame(immutableNotificationResponse, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableNotificationResponse#withSummary(NotificationSummary[])} with {@code
   * NotificationSummary[]}.
   *
   * <p>Method under test: {@link ImmutableNotificationResponse#withSummary(NotificationSummary[])}
   */
  @Test
  @DisplayName("Test withSummary(NotificationSummary[]) with 'NotificationSummary[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableNotificationResponse ImmutableNotificationResponse.withSummary(NotificationSummary[])"
  })
  void testWithSummaryWithNotificationSummary() {
    // Arrange
    ImmutableNotificationResponse immutableNotificationResponse =
        ImmutableNotificationResponse.builder().message("Not all who wander are lost").build();

    // Act and Assert
    List<NotificationSummary> summaryResult =
        immutableNotificationResponse
            .withSummary(
                ImmutableNotificationSummary.builder().count(3).kind(EntityKind.ALL).build())
            .summary();
    assertEquals(1, summaryResult.size());
    NotificationSummary getResult = summaryResult.get(0);
    assertTrue(getResult instanceof ImmutableNotificationSummary);
    assertEquals(3, getResult.count().intValue());
    assertEquals(EntityKind.ALL, getResult.kind());
  }
}
