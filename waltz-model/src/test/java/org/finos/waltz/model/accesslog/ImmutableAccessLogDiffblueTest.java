package org.finos.waltz.model.accesslog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAccessLog Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableAccessLog actualImmutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(createdAt)
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableAccessLog.userId());
    assertEquals("MD", actualImmutableAccessLog.state());
    assertEquals("Params", actualImmutableAccessLog.params());
    assertSame(createdAt, actualImmutableAccessLog.createdAt());
  }

  /**
   * Test Builder {@link Builder#from(AccessLog)}.
   *
   * <p>Method under test: {@link Builder#from(AccessLog)}
   */
  @Test
  @DisplayName("Test Builder from(AccessLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AccessLog)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();
    ImmutableAccessLog instance =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAccessLog actualImmutableAccessLog = builderResult.build();
    assertEquals(instance, actualImmutableAccessLog);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#params(String)}.
   *
   * <ul>
   *   <li>When {@code Params}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#params(String)}
   */
  @Test
  @DisplayName("Test Builder params(String); when 'Params'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.params(String)"})
  void testBuilderParams_whenParams_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();

    // Act
    Builder actualParamsResult = builderResult.params("Params");

    // Assert
    assertSame(builderResult, actualParamsResult);
  }

  /**
   * Test Builder {@link Builder#state(String)}.
   *
   * <ul>
   *   <li>When {@code MD}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#state(String)}
   */
  @Test
  @DisplayName("Test Builder state(String); when 'MD'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.state(String)"})
  void testBuilderState_whenMd_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAccessLog.builder();

    // Act
    Builder actualStateResult = builderResult.state("MD");

    // Assert
    assertSame(builderResult, actualStateResult);
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
    Builder builderResult = ImmutableAccessLog.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableAccessLog#copyOf(AccessLog)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#copyOf(AccessLog)}
   */
  @Test
  @DisplayName("Test copyOf(AccessLog); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.copyOf(AccessLog)"})
  void testCopyOf_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAccessLog instance =
        ImmutableAccessLog.builder()
            .createdAt(ofResult.atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act
    ImmutableAccessLog actualCopyOfResult = ImmutableAccessLog.copyOf(instance);

    // Assert
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals("MD", actualCopyOfResult.state());
    assertEquals("Params", actualCopyOfResult.params());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}, and {@link ImmutableAccessLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAccessLog#equals(Object)}
   *   <li>{@link ImmutableAccessLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();
    ImmutableAccessLog immutableAccessLog2 =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAccessLog, immutableAccessLog2);
    assertEquals(immutableAccessLog.hashCode(), immutableAccessLog2.hashCode());
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}, and {@link ImmutableAccessLog#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAccessLog#equals(Object)}
   *   <li>{@link ImmutableAccessLog#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAccessLog, immutableAccessLog);
    int expectedHashCodeResult = immutableAccessLog.hashCode();
    assertEquals(expectedHashCodeResult, immutableAccessLog.hashCode());
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAccessLog,
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("MD")
            .state("MD")
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAccessLog,
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("Params")
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAccessLog,
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("MD")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAccessLog,
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAccessLog#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAccessLog.equals(Object)",
    "int ImmutableAccessLog.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build(),
        "Different type to ImmutableAccessLog");
  }

  /**
   * Test {@link ImmutableAccessLog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) State is {@code Json}.
   *   <li>Then return params is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) State is 'Json'; then return params is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonStateIsJson_thenReturnParamsIsJson() {
    // Arrange
    Json json = new Json();
    json.setState("Json");
    json.setParams("Json");
    json.setUserId("Json");
    json.setCreatedAt(null);

    // Act
    ImmutableAccessLog actualFromJsonResult = ImmutableAccessLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.params());
    assertEquals("Json", actualFromJsonResult.state());
    assertEquals("Json", actualFromJsonResult.userId());
  }

  /**
   * Test {@link ImmutableAccessLog#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return createdAt is {@link Json} (default constructor) {@link Json#createdAt}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return createdAt is Json (default constructor) createdAt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.fromJson(Json)"})
  void testFromJson_thenReturnCreatedAtIsJsonCreatedAt() {
    // Arrange
    Json json = new Json();
    json.setState("Json");
    json.setParams("Json");
    json.setUserId("Json");
    json.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableAccessLog actualFromJsonResult = ImmutableAccessLog.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.params());
    assertEquals("Json", actualFromJsonResult.state());
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
   *   <li>{@link ImmutableAccessLog#toString()}
   *   <li>{@link ImmutableAccessLog#createdAt()}
   *   <li>{@link ImmutableAccessLog#params()}
   *   <li>{@link ImmutableAccessLog#state()}
   *   <li>{@link ImmutableAccessLog#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalDateTime ImmutableAccessLog.createdAt()",
    "String ImmutableAccessLog.params()",
    "String ImmutableAccessLog.state()",
    "String ImmutableAccessLog.toString()",
    "String ImmutableAccessLog.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(ofResult.atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act
    String actualToStringResult = immutableAccessLog.toString();
    LocalDateTime actualCreatedAtResult = immutableAccessLog.createdAt();
    String actualParamsResult = immutableAccessLog.params();
    String actualStateResult = immutableAccessLog.state();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", immutableAccessLog.userId());
    assertEquals(
        "AccessLog{state=MD, params=Params, userId=42, createdAt=1970-01-01T00:00}",
        actualToStringResult);
    assertEquals("MD", actualStateResult);
    assertEquals("Params", actualParamsResult);
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
   *   <li>{@link Json#setParams(String)}
   *   <li>{@link Json#setState(String)}
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
    "void Json.setParams(String)",
    "void Json.setState(String)",
    "void Json.setUserId(String)"
  })
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
   *
   * <p>Method under test: {@link Json#params()}
   */
  @Test
  @DisplayName("Test Json params()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.params()"})
  void testJsonParams() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().params());
  }

  /**
   * Test Json {@link Json#state()}.
   *
   * <p>Method under test: {@link Json#state()}
   */
  @Test
  @DisplayName("Test Json state()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.state()"})
  void testJsonState() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().state());
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
   * Test {@link ImmutableAccessLog#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAccessLog#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withCreatedAt(LocalDateTime)"})
  void testWithCreatedAt() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act
    ImmutableAccessLog actualWithCreatedAtResult =
        immutableAccessLog.withCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAccessLog, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableAccessLog#withParams(String)}.
   *
   * <p>Method under test: {@link ImmutableAccessLog#withParams(String)}
   */
  @Test
  @DisplayName("Test withParams(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withParams(String)"})
  void testWithParams() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("42")
            .state("MD")
            .userId("42")
            .build();

    // Act
    ImmutableAccessLog actualWithParamsResult = immutableAccessLog.withParams("42");

    // Assert
    assertSame(immutableAccessLog, actualWithParamsResult);
  }

  /**
   * Test {@link ImmutableAccessLog#withParams(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#withParams(String)}
   */
  @Test
  @DisplayName("Test withParams(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withParams(String)"})
  void testWithParams_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAccessLog actualWithParamsResult =
        ImmutableAccessLog.builder()
            .createdAt(ofResult.atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build()
            .withParams("42");

    // Assert
    LocalDateTime createdAtResult = actualWithParamsResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithParamsResult.params());
    assertEquals("42", actualWithParamsResult.userId());
    assertEquals("MD", actualWithParamsResult.state());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAccessLog#withState(String)}.
   *
   * <p>Method under test: {@link ImmutableAccessLog#withState(String)}
   */
  @Test
  @DisplayName("Test withState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withState(String)"})
  void testWithState() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("42")
            .userId("42")
            .build();

    // Act
    ImmutableAccessLog actualWithStateResult = immutableAccessLog.withState("42");

    // Assert
    assertSame(immutableAccessLog, actualWithStateResult);
  }

  /**
   * Test {@link ImmutableAccessLog#withState(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#withState(String)}
   */
  @Test
  @DisplayName("Test withState(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withState(String)"})
  void testWithState_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAccessLog actualWithStateResult =
        ImmutableAccessLog.builder()
            .createdAt(ofResult.atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build()
            .withState("42");

    // Assert
    LocalDateTime createdAtResult = actualWithStateResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithStateResult.state());
    assertEquals("42", actualWithStateResult.userId());
    assertEquals("Params", actualWithStateResult.params());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAccessLog#withUserId(String)}.
   *
   * <p>Method under test: {@link ImmutableAccessLog#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withUserId(String)"})
  void testWithUserId() {
    // Arrange
    ImmutableAccessLog immutableAccessLog =
        ImmutableAccessLog.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("42")
            .build();

    // Act
    ImmutableAccessLog actualWithUserIdResult = immutableAccessLog.withUserId("42");

    // Assert
    assertSame(immutableAccessLog, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableAccessLog#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return createdAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAccessLog#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return createdAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAccessLog ImmutableAccessLog.withUserId(String)"})
  void testWithUserId_thenReturnCreatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAccessLog actualWithUserIdResult =
        ImmutableAccessLog.builder()
            .createdAt(ofResult.atStartOfDay())
            .params("Params")
            .state("MD")
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    LocalDateTime createdAtResult = actualWithUserIdResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals("MD", actualWithUserIdResult.state());
    assertEquals("Params", actualWithUserIdResult.params());
    assertSame(ofResult, toLocalDateResult);
  }
}
