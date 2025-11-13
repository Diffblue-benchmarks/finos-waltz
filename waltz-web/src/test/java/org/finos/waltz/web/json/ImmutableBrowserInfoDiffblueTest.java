package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.web.json.ImmutableBrowserInfo.Builder;
import org.finos.waltz.web.json.ImmutableBrowserInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBrowserInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBrowserInfo actualImmutableBrowserInfo =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();

    // Assert
    assertEquals("Operating System", actualImmutableBrowserInfo.operatingSystem());
    assertEquals("Resolution", actualImmutableBrowserInfo.resolution());
  }

  /**
   * Test Builder {@link Builder#from(BrowserInfo)}.
   *
   * <p>Method under test: {@link Builder#from(BrowserInfo)}
   */
  @Test
  @DisplayName("Test Builder from(BrowserInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BrowserInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();
    ImmutableBrowserInfo instance =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBrowserInfo actualImmutableBrowserInfo = builderResult.build();
    assertEquals(instance, actualImmutableBrowserInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#operatingSystem(String)}.
   *
   * <ul>
   *   <li>When {@code Operating System}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operatingSystem(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystem(String); when 'Operating System'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operatingSystem(String)"})
  void testBuilderOperatingSystem_whenOperatingSystem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();

    // Act
    Builder actualOperatingSystemResult = builderResult.operatingSystem("Operating System");

    // Assert
    assertSame(builderResult, actualOperatingSystemResult);
  }

  /**
   * Test Builder {@link Builder#resolution(String)}.
   *
   * <ul>
   *   <li>When {@code Resolution}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#resolution(String)}
   */
  @Test
  @DisplayName("Test Builder resolution(String); when 'Resolution'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resolution(String)"})
  void testBuilderResolution_whenResolution_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();

    // Act
    Builder actualResolutionResult = builderResult.resolution("Resolution");

    // Assert
    assertSame(builderResult, actualResolutionResult);
  }

  /**
   * Test {@link ImmutableBrowserInfo#copyOf(BrowserInfo)}.
   *
   * <ul>
   *   <li>Then return {@code Operating System}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#copyOf(BrowserInfo)}
   */
  @Test
  @DisplayName("Test copyOf(BrowserInfo); then return 'Operating System'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo ImmutableBrowserInfo.copyOf(BrowserInfo)"})
  void testCopyOf_thenReturnOperatingSystem() {
    // Arrange
    ImmutableBrowserInfo instance =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();

    // Act
    ImmutableBrowserInfo actualCopyOfResult = ImmutableBrowserInfo.copyOf(instance);

    // Assert
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Resolution", actualCopyOfResult.resolution());
  }

  /**
   * Test {@link ImmutableBrowserInfo#equals(Object)}, and {@link ImmutableBrowserInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBrowserInfo#equals(Object)}
   *   <li>{@link ImmutableBrowserInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBrowserInfo.equals(Object)",
    "int ImmutableBrowserInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();
    ImmutableBrowserInfo immutableBrowserInfo2 =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();

    // Act and Assert
    assertEquals(immutableBrowserInfo, immutableBrowserInfo2);
    assertEquals(immutableBrowserInfo.hashCode(), immutableBrowserInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableBrowserInfo#equals(Object)}, and {@link ImmutableBrowserInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBrowserInfo#equals(Object)}
   *   <li>{@link ImmutableBrowserInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBrowserInfo.equals(Object)",
    "int ImmutableBrowserInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();

    // Act and Assert
    assertEquals(immutableBrowserInfo, immutableBrowserInfo);
    int expectedHashCodeResult = immutableBrowserInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableBrowserInfo.hashCode());
  }

  /**
   * Test {@link ImmutableBrowserInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBrowserInfo.equals(Object)",
    "int ImmutableBrowserInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Resolution")
            .resolution("Resolution")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBrowserInfo,
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build());
  }

  /**
   * Test {@link ImmutableBrowserInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBrowserInfo.equals(Object)",
    "int ImmutableBrowserInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Operating System")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableBrowserInfo,
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build());
  }

  /**
   * Test {@link ImmutableBrowserInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBrowserInfo.equals(Object)",
    "int ImmutableBrowserInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBrowserInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBrowserInfo.equals(Object)",
    "int ImmutableBrowserInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build(),
        "Different type to ImmutableBrowserInfo");
  }

  /**
   * Test {@link ImmutableBrowserInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) OperatingSystem is {@code Json}.
   *   <li>Then return operatingSystem is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) OperatingSystem is 'Json'; then return operatingSystem is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo ImmutableBrowserInfo.fromJson(Json)"})
  void testFromJson_whenJsonOperatingSystemIsJson_thenReturnOperatingSystemIsJson() {
    // Arrange
    Json json = new Json();
    json.setOperatingSystem("Json");
    json.setResolution("Json");

    // Act
    ImmutableBrowserInfo actualFromJsonResult = ImmutableBrowserInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.operatingSystem());
    assertEquals("Json", actualFromJsonResult.resolution());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBrowserInfo#toString()}
   *   <li>{@link ImmutableBrowserInfo#operatingSystem()}
   *   <li>{@link ImmutableBrowserInfo#resolution()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBrowserInfo.operatingSystem()",
    "String ImmutableBrowserInfo.resolution()",
    "String ImmutableBrowserInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build();

    // Act
    String actualToStringResult = immutableBrowserInfo.toString();
    String actualOperatingSystemResult = immutableBrowserInfo.operatingSystem();

    // Assert
    assertEquals(
        "BrowserInfo{operatingSystem=Operating System, resolution=Resolution}",
        actualToStringResult);
    assertEquals("Operating System", actualOperatingSystemResult);
    assertEquals("Resolution", immutableBrowserInfo.resolution());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOperatingSystem(String)}
   *   <li>{@link Json#setResolution(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setOperatingSystem(String)",
    "void Json.setResolution(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setOperatingSystem("Operating System");
    actualJson.setResolution("Resolution");

    // Assert
    assertEquals("Operating System", actualJson.operatingSystem);
    assertEquals("Resolution", actualJson.resolution);
  }

  /**
   * Test Json {@link Json#operatingSystem()}.
   *
   * <p>Method under test: {@link Json#operatingSystem()}
   */
  @Test
  @DisplayName("Test Json operatingSystem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.operatingSystem()"})
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operatingSystem());
  }

  /**
   * Test Json {@link Json#resolution()}.
   *
   * <p>Method under test: {@link Json#resolution()}
   */
  @Test
  @DisplayName("Test Json resolution()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.resolution()"})
  void testJsonResolution() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolution());
  }

  /**
   * Test {@link ImmutableBrowserInfo#withOperatingSystem(String)}.
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo ImmutableBrowserInfo.withOperatingSystem(String)"})
  void testWithOperatingSystem() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder().operatingSystem("42").resolution("Resolution").build();

    // Act
    ImmutableBrowserInfo actualWithOperatingSystemResult =
        immutableBrowserInfo.withOperatingSystem("42");

    // Assert
    assertSame(immutableBrowserInfo, actualWithOperatingSystemResult);
  }

  /**
   * Test {@link ImmutableBrowserInfo#withOperatingSystem(String)}.
   *
   * <ul>
   *   <li>Then return operatingSystem is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String); then return operatingSystem is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo ImmutableBrowserInfo.withOperatingSystem(String)"})
  void testWithOperatingSystem_thenReturnOperatingSystemIs42() {
    // Arrange and Act
    ImmutableBrowserInfo actualWithOperatingSystemResult =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build()
            .withOperatingSystem("42");

    // Assert
    assertEquals("42", actualWithOperatingSystemResult.operatingSystem());
    assertEquals("Resolution", actualWithOperatingSystemResult.resolution());
  }

  /**
   * Test {@link ImmutableBrowserInfo#withResolution(String)}.
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#withResolution(String)}
   */
  @Test
  @DisplayName("Test withResolution(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo ImmutableBrowserInfo.withResolution(String)"})
  void testWithResolution() {
    // Arrange
    ImmutableBrowserInfo immutableBrowserInfo =
        ImmutableBrowserInfo.builder().operatingSystem("Operating System").resolution("42").build();

    // Act
    ImmutableBrowserInfo actualWithResolutionResult = immutableBrowserInfo.withResolution("42");

    // Assert
    assertSame(immutableBrowserInfo, actualWithResolutionResult);
  }

  /**
   * Test {@link ImmutableBrowserInfo#withResolution(String)}.
   *
   * <ul>
   *   <li>Then return resolution is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBrowserInfo#withResolution(String)}
   */
  @Test
  @DisplayName("Test withResolution(String); then return resolution is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBrowserInfo ImmutableBrowserInfo.withResolution(String)"})
  void testWithResolution_thenReturnResolutionIs42() {
    // Arrange and Act
    ImmutableBrowserInfo actualWithResolutionResult =
        ImmutableBrowserInfo.builder()
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .build()
            .withResolution("42");

    // Assert
    assertEquals("42", actualWithResolutionResult.resolution());
    assertEquals("Operating System", actualWithResolutionResult.operatingSystem());
  }
}
