package org.finos.waltz.model.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.notification.ImmutableNotificationSummary.Builder;
import org.finos.waltz.model.notification.ImmutableNotificationSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableNotificationSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#count(Integer)}.
   * <p>
   * Method under test: {@link Builder#count(Integer)}
   */
  @Test
  @DisplayName("Test Builder count(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.count(Integer)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.count(3));
  }

  /**
   * Test Builder {@link Builder#from(NotificationSummary)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build count intValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NotificationSummary)}
   */
  @Test
  @DisplayName("Test Builder from(NotificationSummary); given three; then builder build count intValue is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NotificationSummary)"})
  void testBuilderFrom_givenThree_thenBuilderBuildCountIntValueIsThree() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();
    NotificationSummary instance = mock(NotificationSummary.class);
    when(instance.count()).thenReturn(3);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).count();
    verify(instance).kind();
    ImmutableNotificationSummary buildResult = builderResult.build();
    assertEquals(3, buildResult.count().intValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NotificationSummary)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NotificationSummary)}
   */
  @Test
  @DisplayName("Test Builder from(NotificationSummary); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NotificationSummary)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();
    NotificationSummary instance = mock(NotificationSummary.class);
    when(instance.count()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).count();
    verify(instance).kind();
  }

  /**
   * Test Builder {@link Builder#kind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#kind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder kind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.kind(EntityKind)"})
  void testBuilderKind() {
    // Arrange
    Builder builderResult = ImmutableNotificationSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(EntityKind.ALL));
  }

  /**
   * Test Json {@link Json#count()}.
   * <p>
   * Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Integer Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).count());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCount(Integer)}
   *   <li>{@link Json#setKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCount(Integer)", "void Json.setKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCount(3);
    actualJson.setKind(EntityKind.ALL);

    // Assert
    assertEquals(3, actualJson.count.intValue());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }
}
