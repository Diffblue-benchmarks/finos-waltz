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
import org.finos.waltz.model.accesslog.ImmutableAccessLog.Builder;
import org.finos.waltz.model.accesslog.ImmutableAccessLog.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAccessLogDiffblueTest {
  /**
   * Test {@link ImmutableAccessLog#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAccessLog#builder()}
   *   <li>{@link ImmutableAccessLog#createdAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAccessLog Builder.build()", "Builder Builder.createdAt(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAccessLog.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#from(AccessLog)}.
   * <ul>
   *   <li>Then builder build userId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AccessLog)}
   */
  @Test
  @DisplayName("Test Builder from(AccessLog); then builder build userId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AccessLog)"})
  void testBuilderFrom_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();
    AccessLog instance = mock(AccessLog.class);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userId()).thenReturn("42");
    when(instance.params()).thenReturn("Params");
    when(instance.state()).thenReturn("MD");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).params();
    verify(instance).state();
    verify(instance).userId();
    ImmutableAccessLog buildResult = builderResult.build();
    assertEquals("42", buildResult.userId());
    assertEquals("MD", buildResult.state());
    assertEquals("Params", buildResult.params());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AccessLog)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AccessLog)}
   */
  @Test
  @DisplayName("Test Builder from(AccessLog); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AccessLog)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();
    AccessLog instance = mock(AccessLog.class);
    when(instance.createdAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.userId()).thenReturn("42");
    when(instance.params()).thenReturn("Params");
    when(instance.state()).thenReturn("MD");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).params();
    verify(instance).state();
    verify(instance).userId();
  }

  /**
   * Test Builder {@link Builder#params(String)}.
   * <p>
   * Method under test: {@link Builder#params(String)}
   */
  @Test
  @DisplayName("Test Builder params(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.params(String)"})
  void testBuilderParams() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.params("Params"));
  }

  /**
   * Test Builder {@link Builder#state(String)}.
   * <p>
   * Method under test: {@link Builder#state(String)}
   */
  @Test
  @DisplayName("Test Builder state(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.state(String)"})
  void testBuilderState() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.state("MD"));
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
    Builder builderResult = ImmutableAccessLog.builder();

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
   *   <li>{@link Json#setParams(String)}
   *   <li>{@link Json#setState(String)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCreatedAt(LocalDateTime)", "void Json.setParams(String)",
      "void Json.setState(String)", "void Json.setUserId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setParams("Params");
    actualJson.setState("MD");
    actualJson.setUserId("42");

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#params()}.
   * <p>
   * Method under test: {@link Json#params()}
   */
  @Test
  @DisplayName("Test Json params()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.params()"})
  void testJsonParams() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).params());
  }

  /**
   * Test Json {@link Json#state()}.
   * <p>
   * Method under test: {@link Json#state()}
   */
  @Test
  @DisplayName("Test Json state()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.state()"})
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).state());
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
