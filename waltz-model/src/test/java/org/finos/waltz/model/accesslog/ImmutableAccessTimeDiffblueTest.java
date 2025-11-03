package org.finos.waltz.model.accesslog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.accesslog.ImmutableAccessTime.Builder;
import org.finos.waltz.model.accesslog.ImmutableAccessTime.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAccessTimeDiffblueTest {
  /**
   * Test Builder {@link Builder#createdAt(LocalDateTime)}.
   * <p>
   * Method under test: {@link Builder#createdAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder createdAt(LocalDateTime)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdAt(LocalDateTime)"})
  void testBuilderCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#from(AccessTime)}.
   * <ul>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AccessTime)}
   */
  @Test
  @DisplayName("Test Builder from(AccessTime); then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AccessTime)"})
  void testBuilderFrom_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();
    AccessTime instance = mock(AccessTime.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).userId();
    assertEquals("42", builderResult.build().userId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AccessTime)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AccessTime)}
   */
  @Test
  @DisplayName("Test Builder from(AccessTime); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AccessTime)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();
    AccessTime instance = mock(AccessTime.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).userId();
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   * <p>
   * Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userId("42"));
  }

  /**
   * Test Json {@link Json#createdAt()}.
   * <p>
   * Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdAt());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCreatedAt(LocalDateTime)", "void Json.setUserId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setUserId("42");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#userId()}.
   * <p>
   * Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userId());
  }
}
