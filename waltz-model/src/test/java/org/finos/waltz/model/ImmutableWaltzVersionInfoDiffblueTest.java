package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableWaltzVersionInfo.Builder;
import org.finos.waltz.model.ImmutableWaltzVersionInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableWaltzVersionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableWaltzVersionInfo actualImmutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Assert
    assertEquals("1.0.2", actualImmutableWaltzVersionInfo.pomVersion());
    assertEquals("Revision", actualImmutableWaltzVersionInfo.revision());
    assertEquals("Timestamp", actualImmutableWaltzVersionInfo.timestamp());
  }

  /**
   * Test Builder {@link Builder#from(WaltzVersionInfo)}.
   *
   * <p>Method under test: {@link Builder#from(WaltzVersionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzVersionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(WaltzVersionInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();
    ImmutableWaltzVersionInfo instance =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableWaltzVersionInfo actualImmutableWaltzVersionInfo = builderResult.build();
    assertEquals(instance, actualImmutableWaltzVersionInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#pomVersion(String)}.
   *
   * <ul>
   *   <li>When {@code 1.0.2}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#pomVersion(String)}
   */
  @Test
  @DisplayName("Test Builder pomVersion(String); when '1.0.2'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.pomVersion(String)"})
  void testBuilderPomVersion_when102_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act
    Builder actualPomVersionResult = builderResult.pomVersion("1.0.2");

    // Assert
    assertSame(builderResult, actualPomVersionResult);
  }

  /**
   * Test Builder {@link Builder#revision(String)}.
   *
   * <ul>
   *   <li>When {@code Revision}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#revision(String)}
   */
  @Test
  @DisplayName("Test Builder revision(String); when 'Revision'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.revision(String)"})
  void testBuilderRevision_whenRevision_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act
    Builder actualRevisionResult = builderResult.revision("Revision");

    // Assert
    assertSame(builderResult, actualRevisionResult);
  }

  /**
   * Test Builder {@link Builder#timestamp(String)}.
   *
   * <ul>
   *   <li>When {@code Timestamp}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#timestamp(String)}
   */
  @Test
  @DisplayName("Test Builder timestamp(String); when 'Timestamp'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.timestamp(String)"})
  void testBuilderTimestamp_whenTimestamp_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act
    Builder actualTimestampResult = builderResult.timestamp("Timestamp");

    // Assert
    assertSame(builderResult, actualTimestampResult);
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#copyOf(WaltzVersionInfo)}.
   *
   * <ul>
   *   <li>Then return pomVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#copyOf(WaltzVersionInfo)}
   */
  @Test
  @DisplayName("Test copyOf(WaltzVersionInfo); then return pomVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.copyOf(WaltzVersionInfo)"
  })
  void testCopyOf_thenReturnPomVersionIs102() {
    // Arrange
    ImmutableWaltzVersionInfo instance =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act
    ImmutableWaltzVersionInfo actualCopyOfResult = ImmutableWaltzVersionInfo.copyOf(instance);

    // Assert
    assertEquals("1.0.2", actualCopyOfResult.pomVersion());
    assertEquals("Revision", actualCopyOfResult.revision());
    assertEquals("Timestamp", actualCopyOfResult.timestamp());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}, and {@link
   * ImmutableWaltzVersionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableWaltzVersionInfo#equals(Object)}
   *   <li>{@link ImmutableWaltzVersionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo2 =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act and Assert
    assertEquals(immutableWaltzVersionInfo, immutableWaltzVersionInfo2);
    assertEquals(immutableWaltzVersionInfo.hashCode(), immutableWaltzVersionInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}, and {@link
   * ImmutableWaltzVersionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableWaltzVersionInfo#equals(Object)}
   *   <li>{@link ImmutableWaltzVersionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act and Assert
    assertEquals(immutableWaltzVersionInfo, immutableWaltzVersionInfo);
    int expectedHashCodeResult = immutableWaltzVersionInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableWaltzVersionInfo.hashCode());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("Timestamp")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableWaltzVersionInfo,
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("1.0.2")
            .timestamp("Timestamp")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableWaltzVersionInfo,
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("1.0.2")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableWaltzVersionInfo,
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableWaltzVersionInfo.equals(Object)",
    "int ImmutableWaltzVersionInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build(),
        "Different type to ImmutableWaltzVersionInfo");
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Timestamp is {@code Json}.
   *   <li>Then return pomVersion is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Timestamp is 'Json'; then return pomVersion is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonTimestampIsJson_thenReturnPomVersionIsJson() {
    // Arrange
    Json json = new Json();
    json.setPomVersion("Json");
    json.setTimestamp("Json");
    json.setRevision("Json");

    // Act
    ImmutableWaltzVersionInfo actualFromJsonResult = ImmutableWaltzVersionInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.pomVersion());
    assertEquals("Json", actualFromJsonResult.revision());
    assertEquals("Json", actualFromJsonResult.timestamp());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableWaltzVersionInfo#toString()}
   *   <li>{@link ImmutableWaltzVersionInfo#pomVersion()}
   *   <li>{@link ImmutableWaltzVersionInfo#revision()}
   *   <li>{@link ImmutableWaltzVersionInfo#timestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableWaltzVersionInfo.pomVersion()",
    "String ImmutableWaltzVersionInfo.revision()",
    "String ImmutableWaltzVersionInfo.timestamp()",
    "String ImmutableWaltzVersionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act
    String actualToStringResult = immutableWaltzVersionInfo.toString();
    String actualPomVersionResult = immutableWaltzVersionInfo.pomVersion();
    String actualRevisionResult = immutableWaltzVersionInfo.revision();

    // Assert
    assertEquals("1.0.2", actualPomVersionResult);
    assertEquals("Revision", actualRevisionResult);
    assertEquals("Timestamp", immutableWaltzVersionInfo.timestamp());
    assertEquals(
        "WaltzVersionInfo{pomVersion=1.0.2, timestamp=Timestamp, revision=Revision}",
        actualToStringResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setPomVersion(String)}
   *   <li>{@link Json#setRevision(String)}
   *   <li>{@link Json#setTimestamp(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setPomVersion(String)",
    "void Json.setRevision(String)",
    "void Json.setTimestamp(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setPomVersion("1.0.2");
    actualJson.setRevision("Revision");
    actualJson.setTimestamp("Timestamp");

    // Assert
    assertEquals("1.0.2", actualJson.pomVersion);
    assertEquals("Revision", actualJson.revision);
    assertEquals("Timestamp", actualJson.timestamp);
  }

  /**
   * Test Json {@link Json#pomVersion()}.
   *
   * <p>Method under test: {@link Json#pomVersion()}
   */
  @Test
  @DisplayName("Test Json pomVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.pomVersion()"})
  void testJsonPomVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().pomVersion());
  }

  /**
   * Test Json {@link Json#revision()}.
   *
   * <p>Method under test: {@link Json#revision()}
   */
  @Test
  @DisplayName("Test Json revision()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.revision()"})
  void testJsonRevision() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().revision());
  }

  /**
   * Test Json {@link Json#timestamp()}.
   *
   * <p>Method under test: {@link Json#timestamp()}
   */
  @Test
  @DisplayName("Test Json timestamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.timestamp()"})
  void testJsonTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().timestamp());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#withPomVersion(String)}.
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#withPomVersion(String)}
   */
  @Test
  @DisplayName("Test withPomVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.withPomVersion(String)"})
  void testWithPomVersion() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("42")
            .revision("Revision")
            .timestamp("Timestamp")
            .build();

    // Act
    ImmutableWaltzVersionInfo actualWithPomVersionResult =
        immutableWaltzVersionInfo.withPomVersion("42");

    // Assert
    assertSame(immutableWaltzVersionInfo, actualWithPomVersionResult);
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#withPomVersion(String)}.
   *
   * <ul>
   *   <li>Then return pomVersion is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#withPomVersion(String)}
   */
  @Test
  @DisplayName("Test withPomVersion(String); then return pomVersion is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.withPomVersion(String)"})
  void testWithPomVersion_thenReturnPomVersionIs42() {
    // Arrange and Act
    ImmutableWaltzVersionInfo actualWithPomVersionResult =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build()
            .withPomVersion("42");

    // Assert
    assertEquals("42", actualWithPomVersionResult.pomVersion());
    assertEquals("Revision", actualWithPomVersionResult.revision());
    assertEquals("Timestamp", actualWithPomVersionResult.timestamp());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#withRevision(String)}.
   *
   * <ul>
   *   <li>Then return builder pomVersion {@code 1.0.2} revision {@code 42} timestamp {@code
   *       Timestamp} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#withRevision(String)}
   */
  @Test
  @DisplayName(
      "Test withRevision(String); then return builder pomVersion '1.0.2' revision '42' timestamp 'Timestamp' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.withRevision(String)"})
  void testWithRevision_thenReturnBuilderPomVersion102Revision42TimestampTimestampBuild() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("42")
            .timestamp("Timestamp")
            .build();

    // Act
    ImmutableWaltzVersionInfo actualWithRevisionResult =
        immutableWaltzVersionInfo.withRevision("42");

    // Assert
    assertSame(immutableWaltzVersionInfo, actualWithRevisionResult);
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#withRevision(String)}.
   *
   * <ul>
   *   <li>Then return pomVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#withRevision(String)}
   */
  @Test
  @DisplayName("Test withRevision(String); then return pomVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.withRevision(String)"})
  void testWithRevision_thenReturnPomVersionIs102() {
    // Arrange and Act
    ImmutableWaltzVersionInfo actualWithRevisionResult =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build()
            .withRevision("42");

    // Assert
    assertEquals("1.0.2", actualWithRevisionResult.pomVersion());
    assertEquals("42", actualWithRevisionResult.revision());
    assertEquals("Timestamp", actualWithRevisionResult.timestamp());
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#withTimestamp(String)}.
   *
   * <ul>
   *   <li>Then return builder pomVersion {@code 1.0.2} revision {@code Revision} timestamp {@code
   *       42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#withTimestamp(String)}
   */
  @Test
  @DisplayName(
      "Test withTimestamp(String); then return builder pomVersion '1.0.2' revision 'Revision' timestamp '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.withTimestamp(String)"})
  void testWithTimestamp_thenReturnBuilderPomVersion102RevisionRevisionTimestamp42Build() {
    // Arrange
    ImmutableWaltzVersionInfo immutableWaltzVersionInfo =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("42")
            .build();

    // Act
    ImmutableWaltzVersionInfo actualWithTimestampResult =
        immutableWaltzVersionInfo.withTimestamp("42");

    // Assert
    assertSame(immutableWaltzVersionInfo, actualWithTimestampResult);
  }

  /**
   * Test {@link ImmutableWaltzVersionInfo#withTimestamp(String)}.
   *
   * <ul>
   *   <li>Then return pomVersion is {@code 1.0.2}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableWaltzVersionInfo#withTimestamp(String)}
   */
  @Test
  @DisplayName("Test withTimestamp(String); then return pomVersion is '1.0.2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableWaltzVersionInfo ImmutableWaltzVersionInfo.withTimestamp(String)"})
  void testWithTimestamp_thenReturnPomVersionIs102() {
    // Arrange and Act
    ImmutableWaltzVersionInfo actualWithTimestampResult =
        ImmutableWaltzVersionInfo.builder()
            .pomVersion("1.0.2")
            .revision("Revision")
            .timestamp("Timestamp")
            .build()
            .withTimestamp("42");

    // Assert
    assertEquals("1.0.2", actualWithTimestampResult.pomVersion());
    assertEquals("42", actualWithTimestampResult.timestamp());
    assertEquals("Revision", actualWithTimestampResult.revision());
  }
}
