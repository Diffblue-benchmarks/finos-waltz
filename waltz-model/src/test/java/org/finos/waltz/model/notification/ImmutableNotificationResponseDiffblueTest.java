package org.finos.waltz.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.notification.ImmutableNotificationResponse.Builder;
import org.finos.waltz.model.notification.ImmutableNotificationResponse.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableNotificationResponseDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSummary(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build summary Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllSummary(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSummary(Iterable); when ArrayList(); then return build summary Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableNotificationSummary.Json} (default constructor).</li>
   *   <li>Then builder build summary size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSummary(NotificationSummary)}
   */
  @Test
  @DisplayName("Test Builder addSummary(NotificationSummary) with 'element'; when Json (default constructor); then builder build summary size is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ImmutableNotificationSummary.Json} (default constructor).</li>
   *   <li>Then builder build summary size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSummary(NotificationSummary[])}
   */
  @Test
  @DisplayName("Test Builder addSummary(NotificationSummary[]) with 'elements'; when Json (default constructor); then builder build summary size is one")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#message(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse Builder.build()", "Builder Builder.message(String)"})
  void testBuilderBuild() {
    // Arrange
    Builder messageResult = ImmutableNotificationResponse.builder().message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertTrue(messageResult.message(message).build().summary().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(NotificationResponse)}.
   * <ul>
   *   <li>Given {@link ImmutableNotificationSummary.Json} (default constructor).</li>
   *   <li>Then return build summary size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NotificationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(NotificationResponse); given Json (default constructor); then return build summary size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NotificationResponse)"})
  void testBuilderFrom_givenJson_thenReturnBuildSummarySizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    Builder builderResult2 = ImmutableNotificationResponse.builder();
    ImmutableNotificationSummary.Json element = new ImmutableNotificationSummary.Json();
    builderResult2.addSummary(element);
    ImmutableNotificationResponse instance = builderResult2.message("Not all who wander are lost").build();

    // Act and Assert
    List<NotificationSummary> summaryResult = builderResult.from(instance).build().summary();
    assertEquals(1, summaryResult.size());
    assertSame(element, summaryResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(NotificationResponse)}.
   * <ul>
   *   <li>Then builder build is builder message {@code Not all who wander are lost} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NotificationResponse)}
   */
  @Test
  @DisplayName("Test Builder from(NotificationResponse); then builder build is builder message 'Not all who wander are lost' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NotificationResponse)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    ImmutableNotificationResponse instance = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#message(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#message(Optional)}
   */
  @Test
  @DisplayName("Test Builder message(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.message(Optional)"})
  void testBuilderMessageWithOptional() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act
    Builder actualMessageResult = builderResult.message(message);

    // Assert
    assertTrue(actualMessageResult.build().summary().isEmpty());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Test Builder {@link Builder#summary(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build summary Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#summary(Iterable)}
   */
  @Test
  @DisplayName("Test Builder summary(Iterable); when ArrayList(); then return build summary Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When builder message {@code Not all who wander are lost} build.</li>
   *   <li>Then return summary Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}
   */
  @Test
  @DisplayName("Test copyOf(NotificationResponse); when builder message 'Not all who wander are lost' build; then return summary Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.copyOf(NotificationResponse)"})
  void testCopyOf_whenBuilderMessageNotAllWhoWanderAreLostBuild_thenReturnSummaryEmpty() {
    // Arrange
    ImmutableNotificationResponse instance = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertTrue(ImmutableNotificationResponse.copyOf(instance).summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}, and {@link ImmutableNotificationResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableNotificationResponse#equals(Object)}
   *   <li>{@link ImmutableNotificationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableNotificationResponse.equals(Object)",
      "int ImmutableNotificationResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();
    ImmutableNotificationResponse buildResult2 = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}, and {@link ImmutableNotificationResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableNotificationResponse#equals(Object)}
   *   <li>{@link ImmutableNotificationResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableNotificationResponse.equals(Object)",
      "int ImmutableNotificationResponse.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableNotificationResponse.equals(Object)",
      "int ImmutableNotificationResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableNotificationResponse.builder();
    builderResult.addSummary(new ImmutableNotificationSummary.Json());
    ImmutableNotificationResponse buildResult = builderResult.message("Not all who wander are lost").build();
    ImmutableNotificationResponse buildResult2 = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableNotificationResponse.equals(Object)",
      "int ImmutableNotificationResponse.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder().message("Message").build();
    ImmutableNotificationResponse buildResult2 = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableNotificationResponse.equals(Object)",
      "int ImmutableNotificationResponse.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableNotificationResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableNotificationResponse.equals(Object)",
      "int ImmutableNotificationResponse.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableNotificationResponse");
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableNotificationSummary.Json} (default constructor).</li>
   *   <li>Then return summary is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return summary is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnSummaryIsArrayList() {
    // Arrange
    ArrayList<NotificationSummary> summary = new ArrayList<>();
    summary.add(new ImmutableNotificationSummary.Json());

    Json json = new Json();
    json.setSummary(summary);
    json.setMessage(null);

    // Act and Assert
    assertEquals(summary, ImmutableNotificationResponse.fromJson(json).summary());
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableNotificationSummary.Json} (default constructor).</li>
   *   <li>Then return summary size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add Json (default constructor); then return summary size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnSummarySizeIsTwo() {
    // Arrange
    ArrayList<NotificationSummary> summary = new ArrayList<>();
    summary.add(new ImmutableNotificationSummary.Json());
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();
    summary.add(json);

    Json json2 = new Json();
    json2.setSummary(summary);
    json2.setMessage(null);

    // Act and Assert
    List<NotificationSummary> summaryResult = ImmutableNotificationResponse.fromJson(json2).summary();
    assertEquals(2, summaryResult.size());
    assertSame(json, summaryResult.get(1));
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Summary is {@code null}.</li>
   *   <li>Then return summary Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Summary is 'null'; then return summary Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonSummaryIsNull_thenReturnSummaryEmpty() {
    // Arrange
    Json json = new Json();
    json.setSummary(null);
    json.setMessage(null);

    // Act and Assert
    assertTrue(ImmutableNotificationResponse.fromJson(json).summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return summary Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return summary Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnSummaryEmpty() {
    // Arrange, Act and Assert
    assertTrue(ImmutableNotificationResponse.fromJson(new Json()).summary().isEmpty());
  }

  /**
   * Test Json {@link Json#message()}.
   * <p>
   * Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).message());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#summary()}
   */
  @Test
  @DisplayName("Test Json summary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.summary()"})
  void testJsonSummary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).summary());
  }

  /**
   * Test {@link ImmutableNotificationResponse#message()}.
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#message()}
   */
  @Test
  @DisplayName("Test message()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional ImmutableNotificationResponse.message()"})
  void testMessage() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act
    Optional<String> actualMessageResult = buildResult.message();

    // Assert
    assertEquals("Not all who wander are lost", actualMessageResult.get());
    assertTrue(actualMessageResult.isPresent());
  }

  /**
   * Test {@link ImmutableNotificationResponse#summary()}.
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#summary()}
   */
  @Test
  @DisplayName("Test summary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableNotificationResponse.summary()"})
  void testSummary() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertTrue(buildResult.summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(Optional)} with {@code optional}.
   * <ul>
   *   <li>Given builder message {@code Not all who wander are lost} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'; given builder message 'Not all who wander are lost' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(Optional)"})
  void testWithMessageWithOptional_givenBuilderMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();
    Optional<String> optional = Optional.of("foo");

    // Act and Assert
    assertTrue(buildResult.withMessage(optional).summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(Optional)} with {@code optional}.
   * <ul>
   *   <li>Then return builder message {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#withMessage(Optional)}
   */
  @Test
  @DisplayName("Test withMessage(Optional) with 'optional'; then return builder message '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(Optional)"})
  void testWithMessageWithOptional_thenReturnBuilderMessage42Build() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder().message("42").build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableNotificationResponse actualWithMessageResult = buildResult.withMessage(optional);

    // Assert
    assertTrue(actualWithMessageResult.summary().isEmpty());
    assertSame(buildResult, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(String)} with {@code value}.
   * <ul>
   *   <li>Given builder message {@code Not all who wander are lost} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'; given builder message 'Not all who wander are lost' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(String)"})
  void testWithMessageWithValue_givenBuilderMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();

    // Act and Assert
    assertTrue(buildResult.withMessage("42").summary().isEmpty());
  }

  /**
   * Test {@link ImmutableNotificationResponse#withMessage(String)} with {@code value}.
   * <ul>
   *   <li>Then return builder message {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String) with 'value'; then return builder message '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.withMessage(String)"})
  void testWithMessageWithValue_thenReturnBuilderMessage42Build() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder().message("42").build();

    // Act
    ImmutableNotificationResponse actualWithMessageResult = buildResult.withMessage("42");

    // Assert
    assertTrue(actualWithMessageResult.summary().isEmpty());
    assertSame(buildResult, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableNotificationResponse#withSummary(NotificationSummary[])} with {@code NotificationSummary[]}.
   * <ul>
   *   <li>When {@link ImmutableNotificationSummary.Json} (default constructor).</li>
   *   <li>Then return summary size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableNotificationResponse#withSummary(NotificationSummary[])}
   */
  @Test
  @DisplayName("Test withSummary(NotificationSummary[]) with 'NotificationSummary[]'; when Json (default constructor); then return summary size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableNotificationResponse ImmutableNotificationResponse.withSummary(NotificationSummary[])"})
  void testWithSummaryWithNotificationSummary_whenJson_thenReturnSummarySizeIsOne() {
    // Arrange
    ImmutableNotificationResponse buildResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost")
        .build();
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();

    // Act and Assert
    List<NotificationSummary> summaryResult = buildResult.withSummary(json).summary();
    assertEquals(1, summaryResult.size());
    assertSame(json, summaryResult.get(0));
  }
}
