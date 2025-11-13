package org.finos.waltz.model.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey.Builder;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableClientCacheKeyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableClientCacheKey Builder.build()",
    "Builder Builder.lastUpdatedAt(LocalDateTime)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableClientCacheKey actualImmutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(lastUpdatedAt)
            .build();

    // Assert
    assertEquals("1234", actualImmutableClientCacheKey.guid());
    assertEquals("Key", actualImmutableClientCacheKey.key());
    assertSame(lastUpdatedAt, actualImmutableClientCacheKey.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#from(ClientCacheKey)}.
   *
   * <p>Method under test: {@link Builder#from(ClientCacheKey)}
   */
  @Test
  @DisplayName("Test Builder from(ClientCacheKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ClientCacheKey)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();
    ImmutableClientCacheKey instance =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableClientCacheKey actualImmutableClientCacheKey = builderResult.build();
    assertEquals(instance, actualImmutableClientCacheKey);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#guid(String)}.
   *
   * <ul>
   *   <li>When {@code 1234}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#guid(String)}
   */
  @Test
  @DisplayName("Test Builder guid(String); when '1234'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.guid(String)"})
  void testBuilderGuid_when1234_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();

    // Act
    Builder actualGuidResult = builderResult.guid("1234");

    // Assert
    assertSame(builderResult, actualGuidResult);
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String); when 'Key'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey_whenKey_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();

    // Act
    Builder actualKeyResult = builderResult.key("Key");

    // Assert
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test {@link ImmutableClientCacheKey#copyOf(ClientCacheKey)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#copyOf(ClientCacheKey)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ClientCacheKey); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.copyOf(ClientCacheKey)"})
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableClientCacheKey instance =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build();

    // Act
    ImmutableClientCacheKey actualCopyOfResult = ImmutableClientCacheKey.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1234", actualCopyOfResult.guid());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Key", actualCopyOfResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}, and {@link
   * ImmutableClientCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableClientCacheKey#equals(Object)}
   *   <li>{@link ImmutableClientCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();
    ImmutableClientCacheKey immutableClientCacheKey2 =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act and Assert
    assertEquals(immutableClientCacheKey, immutableClientCacheKey2);
    assertEquals(immutableClientCacheKey.hashCode(), immutableClientCacheKey2.hashCode());
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}, and {@link
   * ImmutableClientCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableClientCacheKey#equals(Object)}
   *   <li>{@link ImmutableClientCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act and Assert
    assertEquals(immutableClientCacheKey, immutableClientCacheKey);
    int expectedHashCodeResult = immutableClientCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, immutableClientCacheKey.hashCode());
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("Key")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableClientCacheKey,
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("1234")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableClientCacheKey,
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableClientCacheKey,
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build());
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableClientCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableClientCacheKey.equals(Object)",
    "int ImmutableClientCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build(),
        "Different type to ImmutableClientCacheKey");
  }

  /**
   * Test {@link ImmutableClientCacheKey#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) LastUpdatedAt is {@code null}.
   *   <li>Then return guid is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) LastUpdatedAt is 'null'; then return guid is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonLastUpdatedAtIsNull_thenReturnGuidIsJson() {
    // Arrange
    Json json = new Json();
    json.setKey("Json");
    json.setGuid("Json");
    json.setLastUpdatedAt(null);

    // Act
    ImmutableClientCacheKey actualFromJsonResult = ImmutableClientCacheKey.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.guid());
    assertEquals("Json", actualFromJsonResult.key());
  }

  /**
   * Test {@link ImmutableClientCacheKey#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt is {@link Json} (default constructor) {@link
   *       Json#lastUpdatedAt}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return lastUpdatedAt is Json (default constructor) lastUpdatedAt")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.fromJson(Json)"})
  void testFromJson_thenReturnLastUpdatedAtIsJsonLastUpdatedAt() {
    // Arrange
    Json json = new Json();
    json.setKey("Json");
    json.setGuid("Json");
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableClientCacheKey actualFromJsonResult = ImmutableClientCacheKey.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.guid());
    assertEquals("Json", actualFromJsonResult.key());
    LocalDateTime expectedLastUpdatedAtResult = json.lastUpdatedAt;
    assertSame(expectedLastUpdatedAtResult, actualFromJsonResult.lastUpdatedAt());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableClientCacheKey#toString()}
   *   <li>{@link ImmutableClientCacheKey#guid()}
   *   <li>{@link ImmutableClientCacheKey#key()}
   *   <li>{@link ImmutableClientCacheKey#lastUpdatedAt()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableClientCacheKey.guid()",
    "String ImmutableClientCacheKey.key()",
    "LocalDateTime ImmutableClientCacheKey.lastUpdatedAt()",
    "String ImmutableClientCacheKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build();

    // Act
    String actualToStringResult = immutableClientCacheKey.toString();
    String actualGuidResult = immutableClientCacheKey.guid();
    String actualKeyResult = immutableClientCacheKey.key();
    LocalDateTime actualLastUpdatedAtResult = immutableClientCacheKey.lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1234", actualGuidResult);
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "ClientCacheKey{key=Key, guid=1234, lastUpdatedAt=1970-01-01T00:00}", actualToStringResult);
    assertEquals("Key", actualKeyResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGuid(String)}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setGuid(String)",
    "void Json.setKey(String)",
    "void Json.setLastUpdatedAt(LocalDateTime)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGuid("1234");
    actualJson.setKey("Key");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#guid()}.
   *
   * <p>Method under test: {@link Json#guid()}
   */
  @Test
  @DisplayName("Test Json guid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.guid()"})
  void testJsonGuid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().guid());
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test {@link ImmutableClientCacheKey#withGuid(String)}.
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#withGuid(String)}
   */
  @Test
  @DisplayName("Test withGuid(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.withGuid(String)"})
  void testWithGuid() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("42")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    ImmutableClientCacheKey actualWithGuidResult = immutableClientCacheKey.withGuid("42");

    // Assert
    assertSame(immutableClientCacheKey, actualWithGuidResult);
  }

  /**
   * Test {@link ImmutableClientCacheKey#withGuid(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#withGuid(String)}
   */
  @Test
  @DisplayName("Test withGuid(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.withGuid(String)"})
  void testWithGuid_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableClientCacheKey actualWithGuidResult =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build()
            .withGuid("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithGuidResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithGuidResult.guid());
    assertEquals("Key", actualWithGuidResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableClientCacheKey#withKey(String)}.
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.withKey(String)"})
  void testWithKey() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    ImmutableClientCacheKey actualWithKeyResult = immutableClientCacheKey.withKey("42");

    // Assert
    assertSame(immutableClientCacheKey, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableClientCacheKey#withKey(String)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#withKey(String)}
   */
  @Test
  @DisplayName("Test withKey(String); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableClientCacheKey ImmutableClientCacheKey.withKey(String)"})
  void testWithKey_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableClientCacheKey actualWithKeyResult =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .build()
            .withKey("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKeyResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    assertEquals("1234", actualWithKeyResult.guid());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithKeyResult.key());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableClientCacheKey#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableClientCacheKey#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableClientCacheKey ImmutableClientCacheKey.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableClientCacheKey immutableClientCacheKey =
        ImmutableClientCacheKey.builder()
            .guid("1234")
            .key("Key")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .build();

    // Act
    ImmutableClientCacheKey actualWithLastUpdatedAtResult =
        immutableClientCacheKey.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableClientCacheKey, actualWithLastUpdatedAtResult);
  }
}
