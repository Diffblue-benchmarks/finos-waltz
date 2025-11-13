package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAttestationEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationEntryDiffblueTest {
  /**
   * Test Builder {@link Builder#appId(long)}.
   *
   * <p>Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableAttestationEntry.builder();

    // Act
    Builder actualAppIdResult = builderResult.appId(1L);

    // Assert
    ImmutableAttestationEntry immutableAttestationEntry = builderResult.build();
    assertNull(immutableAttestationEntry.attestedBy());
    assertNull(immutableAttestationEntry.attestedAt());
    assertEquals(1L, immutableAttestationEntry.appId());
    assertSame(builderResult, actualAppIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#attestedAt(LocalDateTime)}
   *   <li>{@link Builder#attestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.attestedAt(LocalDateTime)",
    "Builder Builder.attestedBy(String)",
    "ImmutableAttestationEntry Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime attestedAt = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableAttestationEntry actualImmutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(attestedAt)
            .attestedBy("Attested By")
            .build();

    // Assert
    assertEquals("Attested By", actualImmutableAttestationEntry.attestedBy());
    assertEquals(1L, actualImmutableAttestationEntry.appId());
    assertSame(attestedAt, actualImmutableAttestationEntry.attestedAt());
  }

  /**
   * Test Builder {@link Builder#from(AttestationEntry)}.
   *
   * <p>Method under test: {@link Builder#from(AttestationEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAttestationEntry.builder();
    ImmutableAttestationEntry instance =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationEntry actualImmutableAttestationEntry = builderResult.build();
    assertEquals(instance, actualImmutableAttestationEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationEntry)}.
   *
   * <p>Method under test: {@link Builder#from(AttestationEntry)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationEntry)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAttestationEntry.builder();
    ImmutableAttestationEntry instance =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationEntry actualImmutableAttestationEntry = builderResult.build();
    assertEquals(instance, actualImmutableAttestationEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableAttestationEntry#copyOf(AttestationEntry)}.
   *
   * <ul>
   *   <li>Then return attestedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#copyOf(AttestationEntry)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AttestationEntry); then return attestedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationEntry ImmutableAttestationEntry.copyOf(AttestationEntry)"
  })
  void testCopyOf_thenReturnAttestedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAttestationEntry instance =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(ofResult.atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act
    ImmutableAttestationEntry actualCopyOfResult = ImmutableAttestationEntry.copyOf(instance);

    // Assert
    LocalDateTime attestedAtResult = actualCopyOfResult.attestedAt();
    assertEquals("00:00", attestedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = attestedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Attested By", actualCopyOfResult.attestedBy());
    assertEquals(1L, actualCopyOfResult.appId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}, and {@link
   * ImmutableAttestationEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationEntry#equals(Object)}
   *   <li>{@link ImmutableAttestationEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();
    ImmutableAttestationEntry immutableAttestationEntry2 =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act and Assert
    assertEquals(immutableAttestationEntry, immutableAttestationEntry2);
    assertEquals(immutableAttestationEntry.hashCode(), immutableAttestationEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}, and {@link
   * ImmutableAttestationEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationEntry#equals(Object)}
   *   <li>{@link ImmutableAttestationEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act and Assert
    assertEquals(immutableAttestationEntry, immutableAttestationEntry);
    int expectedHashCodeResult = immutableAttestationEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationEntry.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(2L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationEntry,
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.now().atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationEntry,
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("appId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationEntry,
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build());
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationEntry.equals(Object)",
    "int ImmutableAttestationEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build(),
        "Different type to ImmutableAttestationEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationEntry#toString()}
   *   <li>{@link ImmutableAttestationEntry#appId()}
   *   <li>{@link ImmutableAttestationEntry#attestedAt()}
   *   <li>{@link ImmutableAttestationEntry#attestedBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAttestationEntry.appId()",
    "LocalDateTime ImmutableAttestationEntry.attestedAt()",
    "String ImmutableAttestationEntry.attestedBy()",
    "String ImmutableAttestationEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(ofResult.atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act
    String actualToStringResult = immutableAttestationEntry.toString();
    long actualAppIdResult = immutableAttestationEntry.appId();
    LocalDateTime actualAttestedAtResult = immutableAttestationEntry.attestedAt();

    // Assert
    assertEquals("00:00", actualAttestedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualAttestedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals(
        "AttestationEntry{appId=1, attestedAt=1970-01-01T00:00, attestedBy=Attested By}",
        actualToStringResult);
    assertEquals("Attested By", immutableAttestationEntry.attestedBy());
    assertEquals(1L, actualAppIdResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#appId()}.
   *
   * <p>Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appId());
  }

  /**
   * Test Json {@link Json#attestedAt()}.
   *
   * <p>Method under test: {@link Json#attestedAt()}
   */
  @Test
  @DisplayName("Test Json attestedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.attestedAt()"})
  void testJsonAttestedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedAt());
  }

  /**
   * Test Json {@link Json#attestedBy()}.
   *
   * <p>Method under test: {@link Json#attestedBy()}
   */
  @Test
  @DisplayName("Test Json attestedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.attestedBy()"})
  void testJsonAttestedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().attestedBy());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setAttestedAt(LocalDateTime)}
   *   <li>{@link Json#setAttestedBy(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setAttestedAt(LocalDateTime)",
    "void Json.setAttestedBy(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setAttestedAt(ofResult.atStartOfDay());
    actualJson.setAttestedBy("Attested By");

    // Assert
    LocalDateTime localDateTime = actualJson.attestedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   *
   * <p>Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAppId(long)"})
  void testJsonSetAppId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Test {@link ImmutableAttestationEntry#withAppId(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationEntry ImmutableAttestationEntry.withAppId(long)"})
  void testWithAppId() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(42L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act
    ImmutableAttestationEntry actualWithAppIdResult = immutableAttestationEntry.withAppId(42L);

    // Assert
    assertSame(immutableAttestationEntry, actualWithAppIdResult);
  }

  /**
   * Test {@link ImmutableAttestationEntry#withAppId(long)}.
   *
   * <ul>
   *   <li>Then return attestedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long); then return attestedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationEntry ImmutableAttestationEntry.withAppId(long)"})
  void testWithAppId_thenReturnAttestedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttestationEntry actualWithAppIdResult =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(ofResult.atStartOfDay())
            .attestedBy("Attested By")
            .build()
            .withAppId(42L);

    // Assert
    LocalDateTime attestedAtResult = actualWithAppIdResult.attestedAt();
    assertEquals("00:00", attestedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = attestedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Attested By", actualWithAppIdResult.attestedBy());
    assertEquals(42L, actualWithAppIdResult.appId());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableAttestationEntry#withAttestedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#withAttestedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withAttestedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationEntry ImmutableAttestationEntry.withAttestedAt(LocalDateTime)"
  })
  void testWithAttestedAt() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("Attested By")
            .build();

    // Act
    ImmutableAttestationEntry actualWithAttestedAtResult =
        immutableAttestationEntry.withAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableAttestationEntry, actualWithAttestedAtResult);
  }

  /**
   * Test {@link ImmutableAttestationEntry#withAttestedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#withAttestedBy(String)}
   */
  @Test
  @DisplayName("Test withAttestedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationEntry ImmutableAttestationEntry.withAttestedBy(String)"})
  void testWithAttestedBy() {
    // Arrange
    ImmutableAttestationEntry immutableAttestationEntry =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .attestedBy("42")
            .build();

    // Act
    ImmutableAttestationEntry actualWithAttestedByResult =
        immutableAttestationEntry.withAttestedBy("42");

    // Assert
    assertSame(immutableAttestationEntry, actualWithAttestedByResult);
  }

  /**
   * Test {@link ImmutableAttestationEntry#withAttestedBy(String)}.
   *
   * <ul>
   *   <li>Then return attestedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationEntry#withAttestedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withAttestedBy(String); then return attestedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationEntry ImmutableAttestationEntry.withAttestedBy(String)"})
  void testWithAttestedBy_thenReturnAttestedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableAttestationEntry actualWithAttestedByResult =
        ImmutableAttestationEntry.builder()
            .appId(1L)
            .attestedAt(ofResult.atStartOfDay())
            .attestedBy("Attested By")
            .build()
            .withAttestedBy("42");

    // Assert
    LocalDateTime attestedAtResult = actualWithAttestedByResult.attestedAt();
    assertEquals("00:00", attestedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = attestedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithAttestedByResult.attestedBy());
    assertEquals(1L, actualWithAttestedByResult.appId());
    assertSame(ofResult, toLocalDateResult);
  }
}
