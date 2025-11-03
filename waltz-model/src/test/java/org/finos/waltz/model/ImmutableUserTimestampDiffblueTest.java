package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.ImmutableUserTimestamp.Builder;
import org.finos.waltz.model.ImmutableUserTimestamp.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserTimestampDiffblueTest {
  /**
   * Test {@link ImmutableUserTimestamp#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUserTimestamp#builder()}
   *   <li>{@link ImmutableUserTimestamp#at(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.at(LocalDateTime)", "ImmutableUserTimestamp Builder.build()"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableUserTimestamp.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.at(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#by(String)}.
   * <p>
   * Method under test: {@link Builder#by(String)}
   */
  @Test
  @DisplayName("Test Builder by(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.by(String)"})
  void testBuilderBy() {
    // Arrange
    Builder builderResult = ImmutableUserTimestamp.builder();

    // Act
    Builder actualByResult = builderResult.by("By");

    // Assert
    assertEquals("By", builderResult.build().by());
    assertSame(builderResult, actualByResult);
  }

  /**
   * Test Builder {@link Builder#from(UserTimestamp)}.
   * <p>
   * Method under test: {@link Builder#from(UserTimestamp)}
   */
  @Test
  @DisplayName("Test Builder from(UserTimestamp)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserTimestamp)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUserTimestamp.builder();
    UserTimestamp instance = mock(UserTimestamp.class);
    when(instance.by()).thenReturn("By");
    when(instance.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).at();
    verify(instance).by();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ImmutableUserTimestamp buildResult = builderResult.build();
    assertEquals("1970-01-01", simpleDateFormat.format(buildResult.atTimestamp()));
    assertEquals("By", buildResult.by());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserTimestamp)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserTimestamp)}
   */
  @Test
  @DisplayName("Test Builder from(UserTimestamp); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserTimestamp)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUserTimestamp.builder();
    UserTimestamp instance = mock(UserTimestamp.class);
    when(instance.by()).thenThrow(new IllegalStateException("instance"));
    when(instance.at()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).at();
    verify(instance).by();
  }

  /**
   * Test Json {@link Json#at()}.
   * <p>
   * Method under test: {@link Json#at()}
   */
  @Test
  @DisplayName("Test Json at()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.at()"})
  void testJsonAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).at());
  }

  /**
   * Test Json {@link Json#atTimestamp()}.
   * <p>
   * Method under test: {@link Json#atTimestamp()}
   */
  @Test
  @DisplayName("Test Json atTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.sql.Timestamp Json.atTimestamp()"})
  void testJsonAtTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).atTimestamp());
  }

  /**
   * Test Json {@link Json#by()}.
   * <p>
   * Method under test: {@link Json#by()}
   */
  @Test
  @DisplayName("Test Json by()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.by()"})
  void testJsonBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).by());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAt(LocalDateTime)}
   *   <li>{@link Json#setBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setAt(LocalDateTime)", "void Json.setBy(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setAt(ofResult.atStartOfDay());
    actualJson.setBy("By");

    // Assert
    LocalDateTime localDateTime = actualJson.at;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }
}
