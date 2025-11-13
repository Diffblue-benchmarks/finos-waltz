package org.finos.waltz.model.accesslog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessTime Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableAccessTime actualImmutableAccessTime =
        ImmutableAccessTime.builder().createdAt(createdAt).userId("42").build();

    // Assert
    assertEquals("42", actualImmutableAccessTime.userId());
    assertSame(createdAt, actualImmutableAccessTime.createdAt());
  }

  /**
   * Test Builder {@link Builder#createdAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link Builder#createdAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder createdAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdAt(LocalDateTime)"})
  void testBuilderCreatedAt() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();

    // Act
    Builder actualCreatedAtResult =
        builderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(builderResult, actualCreatedAtResult);
  }

  /**
   * Test Builder {@link Builder#from(AccessTime)}.
   *
   * <p>Method under test: {@link Builder#from(AccessTime)}
   */
  @Test
  @DisplayName("Test Builder from(AccessTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AccessTime)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();
    ImmutableAccessTime instance =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAccessTime actualImmutableAccessTime = builderResult.build();
    assertEquals(instance, actualImmutableAccessTime);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAccessTime.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableAccessTime#copyOf(AccessTime)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#copyOf(AccessTime)}
   */
  @Test
  @DisplayName("Test copyOf(AccessTime); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessTime ImmutableAccessTime.copyOf(AccessTime)"})
  void testCopyOf_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAccessTime instance =
        ImmutableAccessTime.builder().createdAt(ofResult.atStartOfDay()).userId("42").build();

    // Act
    ImmutableAccessTime actualCopyOfResult = ImmutableAccessTime.copyOf(instance);

    // Assert
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAccessTime#equals(Object)}, and {@link ImmutableAccessTime#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAccessTime#equals(Object)}
   *   <li>{@link ImmutableAccessTime#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessTime.equals(Object)",
    "int ImmutableAccessTime.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build();
    ImmutableAccessTime immutableAccessTime2 =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAccessTime, immutableAccessTime2);
    assertEquals(immutableAccessTime.hashCode(), immutableAccessTime2.hashCode());
  }

  /**
   * Test {@link ImmutableAccessTime#equals(Object)}, and {@link ImmutableAccessTime#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAccessTime#equals(Object)}
   *   <li>{@link ImmutableAccessTime#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessTime.equals(Object)",
    "int ImmutableAccessTime.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAccessTime, immutableAccessTime);
    int expectedHashCodeResult = immutableAccessTime.hashCode();
    assertEquals(expectedHashCodeResult, immutableAccessTime.hashCode());
  }

  /**
   * Test {@link ImmutableAccessTime#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessTime.equals(Object)",
    "int ImmutableAccessTime.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAccessTime,
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAccessTime#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessTime.equals(Object)",
    "int ImmutableAccessTime.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("User Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAccessTime,
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAccessTime#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessTime.equals(Object)",
    "int ImmutableAccessTime.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAccessTime#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessTime.equals(Object)",
    "int ImmutableAccessTime.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build(),
        "Different type to ImmutableAccessTime");
  }

  /**
   * Test {@link ImmutableAccessTime#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) UserId is {@code Json}.
   *   <li>Then return userId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) UserId is 'Json'; then return userId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessTime ImmutableAccessTime.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonUserIdIsJson_thenReturnUserIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserId("Json");
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableAccessTime actualFromJsonResult = ImmutableAccessTime.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    LocalDateTime expectedCreatedAtResult = json.createdAt;
    assertSame(expectedCreatedAtResult, actualFromJsonResult.createdAt());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAccessTime#toString()}
   *   <li>{@link ImmutableAccessTime#createdAt()}
   *   <li>{@link ImmutableAccessTime#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDateTime ImmutableAccessTime.createdAt()",
    "String ImmutableAccessTime.toString()",
    "String ImmutableAccessTime.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder().createdAt(ofResult.atStartOfDay()).userId("42").build();

    // Act
    String actualToStringResult = immutableAccessTime.toString();
    LocalDateTime actualCreatedAtResult = immutableAccessTime.createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", immutableAccessTime.userId());
    assertEquals("AccessTime{userId=42, createdAt=1970-01-01T00:00}", actualToStringResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCreatedAt(LocalDateTime)",
    "void Json.setUserId(String)"
  })
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
   *
   * <p>Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userId());
  }

  /**
   * Test {@link ImmutableAccessTime#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAccessTime#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessTime ImmutableAccessTime.withCreatedAt(LocalDateTime)"})
  void testWithCreatedAt() {
    // Arrange
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build();

    // Act
    ImmutableAccessTime actualWithCreatedAtResult =
        immutableAccessTime.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAccessTime, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableAccessTime#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutableAccessTime#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessTime ImmutableAccessTime.withUserId(String)"})
  void testWithUserId() {
    // Arrange
    ImmutableAccessTime immutableAccessTime =
        ImmutableAccessTime.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .userId("42")
            .build();

    // Act
    ImmutableAccessTime actualWithUserIdResult = immutableAccessTime.withUserId("42");

    // Assert
    assertSame(immutableAccessTime, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableAccessTime#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessTime#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessTime ImmutableAccessTime.withUserId(String)"})
  void testWithUserId_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAccessTime actualWithUserIdResult =
        ImmutableAccessTime.builder()
            .createdAt(ofResult.atStartOfDay())
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    LocalDateTime createdAtResult = actualWithUserIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithUserIdResult.userId());
    assertSame(ofResult, toLocalDateResult);
  }
}
