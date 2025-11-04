package org.finos.waltz.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityKind;
import org.junit.jupiter.api.Test;

class ImmutableNotificationSummaryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableNotificationSummary.Builder#count(Integer)}
   */
  @Test
  void testBuilderCount() {
    // Arrange
    ImmutableNotificationSummary.Builder builderResult = ImmutableNotificationSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationSummary.Builder#from(NotificationSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableNotificationSummary.Builder builderResult = ImmutableNotificationSummary.builder();
    NotificationSummary instance = mock(NotificationSummary.class);
    when(instance.count()).thenReturn(3);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableNotificationSummary.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).kind();
    ImmutableNotificationSummary buildResult = builderResult.build();
    assertEquals(3, buildResult.count().intValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationSummary.Builder#from(NotificationSummary)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableNotificationSummary.Builder builderResult = ImmutableNotificationSummary.builder();
    NotificationSummary instance = mock(NotificationSummary.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationSummary.Builder#kind(EntityKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableNotificationSummary.Builder builderResult = ImmutableNotificationSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationSummary#copyOf(NotificationSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    NotificationSummary instance = mock(NotificationSummary.class);
    when(instance.count()).thenReturn(3);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableNotificationSummary actualCopyOfResult = ImmutableNotificationSummary.copyOf(instance);

    // Assert
    verify(instance).count();
    verify(instance).kind();
    assertEquals(3, actualCopyOfResult.count().intValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableNotificationSummary#fromJson(ImmutableNotificationSummary.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableNotificationSummary.Json json = new ImmutableNotificationSummary.Json();
    json.setKind(EntityKind.ALL);
    json.setCount(1);

    // Act
    ImmutableNotificationSummary actualFromJsonResult = ImmutableNotificationSummary.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.count().intValue());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Method under test: {@link ImmutableNotificationSummary.Json#count()}
   */
  @Test
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableNotificationSummary.Json()).count());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableNotificationSummary.Json}
   *   <li>{@link ImmutableNotificationSummary.Json#setCount(Integer)}
   *   <li>{@link ImmutableNotificationSummary.Json#setKind(EntityKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableNotificationSummary.Json actualJson = new ImmutableNotificationSummary.Json();
    actualJson.setCount(3);
    actualJson.setKind(EntityKind.ALL);

    // Assert
    assertEquals(3, actualJson.count.intValue());
  }

  /**
   * Method under test: {@link ImmutableNotificationSummary.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableNotificationSummary.Json()).kind());
  }
}
