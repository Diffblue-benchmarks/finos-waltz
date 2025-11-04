package org.finos.waltz.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableNotificationResponseDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#addAllSummary(Iterable)}
   */
  @Test
  void testBuilderAddAllSummary() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSummary(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#addSummary(NotificationSummary)}
   */
  @Test
  void testBuilderAddSummary() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();
    ImmutableNotificationSummary.Json element = new ImmutableNotificationSummary.Json();

    // Act
    ImmutableNotificationResponse.Builder actualAddSummaryResult = builderResult.addSummary(element);

    // Assert
    List<NotificationSummary> summaryResult = builderResult.build().summary();
    assertEquals(1, summaryResult.size());
    assertSame(element, summaryResult.get(0));
    assertSame(builderResult, actualAddSummaryResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#addSummary(NotificationSummary[])}
   */
  @Test
  void testBuilderAddSummary2() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();

    // Act
    ImmutableNotificationResponse.Builder actualAddSummaryResult = builderResult.addSummary(json);

    // Assert
    List<NotificationSummary> summaryResult = builderResult.build().summary();
    assertEquals(1, summaryResult.size());
    assertSame(json, summaryResult.get(0));
    assertSame(builderResult, actualAddSummaryResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableNotificationResponse.Builder#build()}
   *   <li>{@link ImmutableNotificationResponse.Builder#message(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableNotificationResponse.Builder messageResult = ImmutableNotificationResponse.builder()
        .message("Not all who wander are lost");
    Optional<String> message = Optional.of("foo");

    // Act and Assert
    assertTrue(messageResult.message(message).build().summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#from(NotificationResponse)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);

    // Act
    ImmutableNotificationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#from(NotificationResponse)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();

    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();
    notificationSummaryList.add(json);
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(notificationSummaryList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);

    // Act
    ImmutableNotificationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    List<NotificationSummary> summaryResult = builderResult.build().summary();
    assertEquals(1, summaryResult.size());
    assertSame(json, summaryResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#from(NotificationResponse)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(new ArrayList<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);

    // Act
    ImmutableNotificationResponse.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#message(Optional)}
   */
  @Test
  void testBuilderMessage() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();
    Optional<String> message = Optional.of("foo");

    // Act
    ImmutableNotificationResponse.Builder actualMessageResult = builderResult.message(message);

    // Assert
    assertTrue(actualMessageResult.build().summary().isEmpty());
    assertSame(builderResult, actualMessageResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse.Builder#summary(Iterable)}
   */
  @Test
  void testBuilderSummary() {
    // Arrange
    ImmutableNotificationResponse.Builder builderResult = ImmutableNotificationResponse.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.summary(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);

    // Act
    ImmutableNotificationResponse actualCopyOfResult = ImmutableNotificationResponse.copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    assertTrue(actualCopyOfResult.summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(new ImmutableNotificationSummary.Json());
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(notificationSummaryList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);

    // Act
    ImmutableNotificationResponse actualCopyOfResult = ImmutableNotificationResponse.copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    assertEquals(notificationSummaryList, actualCopyOfResult.summary());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(new ImmutableNotificationSummary.Json());
    notificationSummaryList.add(new ImmutableNotificationSummary.Json());
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(notificationSummaryList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.message()).thenReturn(ofResult);

    // Act
    ImmutableNotificationResponse actualCopyOfResult = ImmutableNotificationResponse.copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    assertEquals(notificationSummaryList, actualCopyOfResult.summary());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#copyOf(NotificationResponse)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    NotificationResponse instance = mock(NotificationResponse.class);
    when(instance.summary()).thenReturn(new ArrayList<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.message()).thenReturn(emptyResult);

    // Act
    ImmutableNotificationResponse actualCopyOfResult = ImmutableNotificationResponse.copyOf(instance);

    // Assert
    verify(instance).message();
    verify(instance).summary();
    assertTrue(actualCopyOfResult.summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#fromJson(ImmutableNotificationResponse.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableNotificationResponse.Json json = new ImmutableNotificationResponse.Json();

    // Act and Assert
    List<NotificationSummary> summaryResult = ImmutableNotificationResponse.fromJson(json).summary();
    assertTrue(summaryResult.isEmpty());
    assertSame(json.summary, summaryResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#fromJson(ImmutableNotificationResponse.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableNotificationResponse.Json json = new ImmutableNotificationResponse.Json();
    json.setSummary(null);
    json.setMessage(null);

    // Act and Assert
    assertTrue(ImmutableNotificationResponse.fromJson(json).summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#fromJson(ImmutableNotificationResponse.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<NotificationSummary> summary = new ArrayList<>();
    summary.add(new ImmutableNotificationSummary.Json());

    ImmutableNotificationResponse.Json json = new ImmutableNotificationResponse.Json();
    json.setSummary(summary);
    json.setMessage(null);

    // Act and Assert
    assertEquals(summary, ImmutableNotificationResponse.fromJson(json).summary());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#fromJson(ImmutableNotificationResponse.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    COWArrayList<NotificationSummary> summary = mock(COWArrayList.class);

    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    when(summary.iterator()).thenReturn(notificationSummaryList.iterator());

    ImmutableNotificationResponse.Json json = new ImmutableNotificationResponse.Json();
    json.setSummary(summary);
    json.setMessage(null);

    // Act
    ImmutableNotificationResponse actualFromJsonResult = ImmutableNotificationResponse.fromJson(json);

    // Assert
    verify(summary).iterator();
    assertTrue(actualFromJsonResult.summary().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationResponse#fromJson(ImmutableNotificationResponse.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ArrayList<NotificationSummary> notificationSummaryList = new ArrayList<>();
    notificationSummaryList.add(new ImmutableNotificationSummary.Json());
    notificationSummaryList.add(new ImmutableNotificationSummary.Json());
    COWArrayList<NotificationSummary> summary = mock(COWArrayList.class);
    when(summary.iterator()).thenReturn(notificationSummaryList.iterator());

    ImmutableNotificationResponse.Json json = new ImmutableNotificationResponse.Json();
    json.setSummary(summary);
    json.setMessage(null);

    // Act
    ImmutableNotificationResponse actualFromJsonResult = ImmutableNotificationResponse.fromJson(json);

    // Assert
    verify(summary).iterator();
    assertEquals(notificationSummaryList, actualFromJsonResult.summary());
  }

  /**
   * Method under test: {@link ImmutableNotificationResponse.Json#message()}
   */
  @Test
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableNotificationResponse.Json()).message());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableNotificationResponse.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableNotificationResponse.Json actualJson = new ImmutableNotificationResponse.Json();

    // Assert
    assertFalse(actualJson.message.isPresent());
    assertTrue(actualJson.summary.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableNotificationResponse.Json#summary()}
   */
  @Test
  void testJsonSummary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableNotificationResponse.Json()).summary());
  }
}
