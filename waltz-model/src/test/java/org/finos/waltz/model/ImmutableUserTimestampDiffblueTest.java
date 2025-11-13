package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Timestamp;
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
   * Test {@link ImmutableUserTimestamp#at()}.
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#at()}
   */
  @Test
  @DisplayName("Test at()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableUserTimestamp.at()"})
  void testAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualAtResult =
        ImmutableUserTimestamp.builder().at(ofResult.atStartOfDay()).by("By").build().at();

    // Assert
    assertEquals("00:00", actualAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserTimestamp#atTimestamp()}.
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#atTimestamp()}
   */
  @Test
  @DisplayName("Test atTimestamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timestamp ImmutableUserTimestamp.atTimestamp()"})
  void testAtTimestamp() {
    // Arrange and Act
    Timestamp actualAtTimestampResult =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build()
            .atTimestamp();

    // Assert
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(actualAtTimestampResult);
    assertEquals("1970-01-01", actualFormatResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#at(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.at(LocalDateTime)", "ImmutableUserTimestamp Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDateTime at = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableUserTimestamp actualImmutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(at).by("By").build();

    // Assert
    assertEquals("By", actualImmutableUserTimestamp.by());
    assertSame(at, actualImmutableUserTimestamp.at());
  }

  /**
   * Test Builder {@link Builder#by(String)}.
   *
   * <ul>
   *   <li>When {@code By}.
   *   <li>Then builder build by is {@code By}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#by(String)}
   */
  @Test
  @DisplayName("Test Builder by(String); when 'By'; then builder build by is 'By'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.by(String)"})
  void testBuilderBy_whenBy_thenBuilderBuildByIsBy() {
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
   *
   * <p>Method under test: {@link Builder#from(UserTimestamp)}
   */
  @Test
  @DisplayName("Test Builder from(UserTimestamp)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserTimestamp)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableUserTimestamp.builder();
    ImmutableUserTimestamp instance =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUserTimestamp actualImmutableUserTimestamp = builderResult.build();
    assertEquals(instance, actualImmutableUserTimestamp);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableUserTimestamp#copyOf(UserTimestamp)}.
   *
   * <ul>
   *   <li>Then return at toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#copyOf(UserTimestamp)}
   */
  @Test
  @DisplayName("Test copyOf(UserTimestamp); then return at toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserTimestamp ImmutableUserTimestamp.copyOf(UserTimestamp)"})
  void testCopyOf_thenReturnAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableUserTimestamp instance =
        ImmutableUserTimestamp.builder().at(ofResult.atStartOfDay()).by("By").build();

    // Act
    ImmutableUserTimestamp actualCopyOfResult = ImmutableUserTimestamp.copyOf(instance);

    // Assert
    LocalDateTime atResult = actualCopyOfResult.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(actualCopyOfResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("By", actualCopyOfResult.by());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserTimestamp#equals(Object)}, and {@link
   * ImmutableUserTimestamp#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserTimestamp#equals(Object)}
   *   <li>{@link ImmutableUserTimestamp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserTimestamp.equals(Object)",
    "int ImmutableUserTimestamp.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();

    // Act and Assert
    assertEquals(immutableUserTimestamp, immutableUserTimestamp2);
    assertEquals(immutableUserTimestamp.hashCode(), immutableUserTimestamp2.hashCode());
  }

  /**
   * Test {@link ImmutableUserTimestamp#equals(Object)}, and {@link
   * ImmutableUserTimestamp#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserTimestamp#equals(Object)}
   *   <li>{@link ImmutableUserTimestamp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserTimestamp.equals(Object)",
    "int ImmutableUserTimestamp.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();

    // Act and Assert
    assertEquals(immutableUserTimestamp, immutableUserTimestamp);
    int expectedHashCodeResult = immutableUserTimestamp.hashCode();
    assertEquals(expectedHashCodeResult, immutableUserTimestamp.hashCode());
  }

  /**
   * Test {@link ImmutableUserTimestamp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserTimestamp.equals(Object)",
    "int ImmutableUserTimestamp.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder().at(LocalDate.now().atStartOfDay()).by("By").build();

    // Act and Assert
    assertNotEquals(
        immutableUserTimestamp,
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build());
  }

  /**
   * Test {@link ImmutableUserTimestamp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserTimestamp.equals(Object)",
    "int ImmutableUserTimestamp.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("at")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserTimestamp,
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build());
  }

  /**
   * Test {@link ImmutableUserTimestamp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserTimestamp.equals(Object)",
    "int ImmutableUserTimestamp.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUserTimestamp#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserTimestamp.equals(Object)",
    "int ImmutableUserTimestamp.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build(),
        "Different type to ImmutableUserTimestamp");
  }

  /**
   * Test {@link ImmutableUserTimestamp#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) At is {@code null}.
   *   <li>Then return by is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) At is 'null'; then return by is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserTimestamp ImmutableUserTimestamp.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonAtIsNull_thenReturnByIsJson() {
    // Arrange
    Json json = new Json();
    json.setAt(null);
    json.setBy("Json");

    // Act
    ImmutableUserTimestamp actualFromJsonResult = ImmutableUserTimestamp.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.by());
  }

  /**
   * Test {@link ImmutableUserTimestamp#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy-MM-dd}
   *       format atTimestamp is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return SimpleDateFormat(String) with 'yyyy-MM-dd' format atTimestamp is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserTimestamp ImmutableUserTimestamp.fromJson(Json)"})
  void testFromJson_thenReturnSimpleDateFormatWithYyyyMmDdFormatAtTimestampIs19700101() {
    // Arrange
    Json json = new Json();
    json.setAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setBy("Json");

    // Act
    ImmutableUserTimestamp actualFromJsonResult = ImmutableUserTimestamp.fromJson(json);

    // Assert
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(actualFromJsonResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("Json", actualFromJsonResult.by());
    LocalDateTime expectedAtResult = json.at;
    assertSame(expectedAtResult, actualFromJsonResult.at());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserTimestamp#toString()}
   *   <li>{@link ImmutableUserTimestamp#by()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUserTimestamp.by()",
    "String ImmutableUserTimestamp.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();

    // Act
    String actualToStringResult = immutableUserTimestamp.toString();

    // Assert
    assertEquals("By", immutableUserTimestamp.by());
    assertEquals(
        "UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp=1970-01-01 00:00:00.0}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#at()}.
   *
   * <p>Method under test: {@link Json#at()}
   */
  @Test
  @DisplayName("Test Json at()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.at()"})
  void testJsonAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().at());
  }

  /**
   * Test Json {@link Json#atTimestamp()}.
   *
   * <p>Method under test: {@link Json#atTimestamp()}
   */
  @Test
  @DisplayName("Test Json atTimestamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Timestamp Json.atTimestamp()"})
  void testJsonAtTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().atTimestamp());
  }

  /**
   * Test Json {@link Json#by()}.
   *
   * <p>Method under test: {@link Json#by()}
   */
  @Test
  @DisplayName("Test Json by()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.by()"})
  void testJsonBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().by());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAt(LocalDateTime)}
   *   <li>{@link Json#setBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAt(LocalDateTime)",
    "void Json.setBy(String)"
  })
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

  /**
   * Test {@link ImmutableUserTimestamp#withAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#withAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserTimestamp ImmutableUserTimestamp.withAt(LocalDateTime)"})
  void testWithAt() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();

    // Act
    ImmutableUserTimestamp actualWithAtResult =
        immutableUserTimestamp.withAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableUserTimestamp, actualWithAtResult);
  }

  /**
   * Test {@link ImmutableUserTimestamp#withBy(String)}.
   *
   * <ul>
   *   <li>Then return at toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#withBy(String)}
   */
  @Test
  @DisplayName("Test withBy(String); then return at toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserTimestamp ImmutableUserTimestamp.withBy(String)"})
  void testWithBy_thenReturnAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableUserTimestamp actualWithByResult =
        ImmutableUserTimestamp.builder().at(ofResult.atStartOfDay()).by("By").build().withBy("42");

    // Assert
    LocalDateTime atResult = actualWithByResult.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(actualWithByResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithByResult.by());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserTimestamp#withBy(String)}.
   *
   * <ul>
   *   <li>Then return builder at {@link LocalDate} with {@code 1970} and one and one atStartOfDay
   *       by {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserTimestamp#withBy(String)}
   */
  @Test
  @DisplayName(
      "Test withBy(String); then return builder at LocalDate with '1970' and one and one atStartOfDay by '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserTimestamp ImmutableUserTimestamp.withBy(String)"})
  void testWithBy_thenReturnBuilderAtLocalDateWith1970AndOneAndOneAtStartOfDayBy42Build() {
    // Arrange
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("42")
            .build();

    // Act
    ImmutableUserTimestamp actualWithByResult = immutableUserTimestamp.withBy("42");

    // Assert
    assertSame(immutableUserTimestamp, actualWithByResult);
  }
}
