package org.finos.waltz.jobs.tools.importers.licence.spdx;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.licence.spdx.ImmutableSpdxLicence.Builder;
import org.finos.waltz.jobs.tools.importers.licence.spdx.ImmutableSpdxLicence.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSpdxLicenceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSpdxLicence actualImmutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Assert
    assertEquals("42", actualImmutableSpdxLicence.licenseId());
    assertEquals("License Text", actualImmutableSpdxLicence.licenseText());
    assertEquals("Name", actualImmutableSpdxLicence.name());
    assertTrue(actualImmutableSpdxLicence.isDeprecatedLicenseId());
  }

  /**
   * Test Builder {@link Builder#from(SpdxLicence)}.
   *
   * <p>Method under test: {@link Builder#from(SpdxLicence)}
   */
  @Test
  @DisplayName("Test Builder from(SpdxLicence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SpdxLicence)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();
    ImmutableSpdxLicence instance =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSpdxLicence actualImmutableSpdxLicence = builderResult.build();
    assertEquals(instance, actualImmutableSpdxLicence);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isDeprecatedLicenseId(boolean)}.
   *
   * <p>Method under test: {@link Builder#isDeprecatedLicenseId(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDeprecatedLicenseId(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isDeprecatedLicenseId(boolean)"})
  void testBuilderIsDeprecatedLicenseId() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act
    Builder actualIsDeprecatedLicenseIdResult = builderResult.isDeprecatedLicenseId(true);

    // Assert
    assertSame(builderResult, actualIsDeprecatedLicenseIdResult);
  }

  /**
   * Test Builder {@link Builder#licenseId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#licenseId(String)}
   */
  @Test
  @DisplayName("Test Builder licenseId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.licenseId(String)"})
  void testBuilderLicenseId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act
    Builder actualLicenseIdResult = builderResult.licenseId("42");

    // Assert
    assertSame(builderResult, actualLicenseIdResult);
  }

  /**
   * Test Builder {@link Builder#licenseText(String)}.
   *
   * <ul>
   *   <li>When {@code License Text}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#licenseText(String)}
   */
  @Test
  @DisplayName("Test Builder licenseText(String); when 'License Text'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.licenseText(String)"})
  void testBuilderLicenseText_whenLicenseText_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act
    Builder actualLicenseTextResult = builderResult.licenseText("License Text");

    // Assert
    assertSame(builderResult, actualLicenseTextResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#seeAlso(String[])}.
   *
   * <p>Method under test: {@link Builder#seeAlso(String[])}
   */
  @Test
  @DisplayName("Test Builder seeAlso(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.seeAlso(String[])"})
  void testBuilderSeeAlso() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act
    Builder actualSeeAlsoResult = builderResult.seeAlso("See Also");

    // Assert
    assertSame(builderResult, actualSeeAlsoResult);
  }

  /**
   * Test {@link ImmutableSpdxLicence#copyOf(SpdxLicence)}.
   *
   * <ul>
   *   <li>When {@code See Also}.
   *   <li>Then return licenseId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#copyOf(SpdxLicence)}
   */
  @Test
  @DisplayName("Test copyOf(SpdxLicence); when 'See Also'; then return licenseId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.copyOf(SpdxLicence)"})
  void testCopyOf_whenSeeAlso_thenReturnLicenseIdIs42() {
    // Arrange
    ImmutableSpdxLicence instance =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act
    ImmutableSpdxLicence actualCopyOfResult = ImmutableSpdxLicence.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.licenseId());
    assertEquals("License Text", actualCopyOfResult.licenseText());
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.isDeprecatedLicenseId());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}, and {@link ImmutableSpdxLicence#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSpdxLicence#equals(Object)}
   *   <li>{@link ImmutableSpdxLicence#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();
    ImmutableSpdxLicence immutableSpdxLicence2 =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act and Assert
    assertEquals(immutableSpdxLicence, immutableSpdxLicence2);
    assertEquals(immutableSpdxLicence.hashCode(), immutableSpdxLicence2.hashCode());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}, and {@link ImmutableSpdxLicence#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSpdxLicence#equals(Object)}
   *   <li>{@link ImmutableSpdxLicence#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act and Assert
    assertEquals(immutableSpdxLicence, immutableSpdxLicence);
    int expectedHashCodeResult = immutableSpdxLicence.hashCode();
    assertEquals(expectedHashCodeResult, immutableSpdxLicence.hashCode());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(false)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSpdxLicence,
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("Name")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSpdxLicence,
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("42")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSpdxLicence,
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("42")
            .seeAlso("See Also")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSpdxLicence,
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSpdxLicence,
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build());
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSpdxLicence#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.equals(Object)",
    "int ImmutableSpdxLicence.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build(),
        "Different type to ImmutableSpdxLicence");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSpdxLicence#toString()}
   *   <li>{@link ImmutableSpdxLicence#isDeprecatedLicenseId()}
   *   <li>{@link ImmutableSpdxLicence#licenseId()}
   *   <li>{@link ImmutableSpdxLicence#licenseText()}
   *   <li>{@link ImmutableSpdxLicence#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSpdxLicence.isDeprecatedLicenseId()",
    "String ImmutableSpdxLicence.licenseId()",
    "String ImmutableSpdxLicence.licenseText()",
    "String ImmutableSpdxLicence.name()",
    "String ImmutableSpdxLicence.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act
    String actualToStringResult = immutableSpdxLicence.toString();
    boolean actualIsDeprecatedLicenseIdResult = immutableSpdxLicence.isDeprecatedLicenseId();
    String actualLicenseIdResult = immutableSpdxLicence.licenseId();
    String actualLicenseTextResult = immutableSpdxLicence.licenseText();

    // Assert
    assertEquals("42", actualLicenseIdResult);
    assertEquals("License Text", actualLicenseTextResult);
    assertEquals("Name", immutableSpdxLicence.name());
    assertEquals(
        "SpdxLicence{licenseId=42, name=Name, licenseText=License Text, seeAlso=[See Also], isDeprecatedLicenseId"
            + "=true}",
        actualToStringResult);
    assertTrue(actualIsDeprecatedLicenseIdResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLicenseId(String)}
   *   <li>{@link Json#setLicenseText(String)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setSeeAlso(String[])}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setLicenseId(String)",
    "void Json.setLicenseText(String)",
    "void Json.setName(String)",
    "void Json.setSeeAlso(String[])"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLicenseId("42");
    actualJson.setLicenseText("License Text");
    actualJson.setName("Name");
    actualJson.setSeeAlso(new String[] {"See Also"});

    // Assert
    assertEquals("42", actualJson.licenseId);
    assertEquals("License Text", actualJson.licenseText);
    assertEquals("Name", actualJson.name);
    assertFalse(actualJson.isDeprecatedLicenseId);
    assertFalse(actualJson.isDeprecatedLicenseIdIsSet);
    assertArrayEquals(new String[] {"See Also"}, actualJson.seeAlso);
  }

  /**
   * Test Json {@link Json#isDeprecatedLicenseId()}.
   *
   * <p>Method under test: {@link Json#isDeprecatedLicenseId()}
   */
  @Test
  @DisplayName("Test Json isDeprecatedLicenseId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isDeprecatedLicenseId()"})
  void testJsonIsDeprecatedLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isDeprecatedLicenseId());
  }

  /**
   * Test Json {@link Json#licenseId()}.
   *
   * <p>Method under test: {@link Json#licenseId()}
   */
  @Test
  @DisplayName("Test Json licenseId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.licenseId()"})
  void testJsonLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().licenseId());
  }

  /**
   * Test Json {@link Json#licenseText()}.
   *
   * <p>Method under test: {@link Json#licenseText()}
   */
  @Test
  @DisplayName("Test Json licenseText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.licenseText()"})
  void testJsonLicenseText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().licenseText());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json {@link Json#seeAlso()}.
   *
   * <p>Method under test: {@link Json#seeAlso()}
   */
  @Test
  @DisplayName("Test Json seeAlso()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] Json.seeAlso()"})
  void testJsonSeeAlso() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().seeAlso());
  }

  /**
   * Test Json {@link Json#setIsDeprecatedLicenseId(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsDeprecatedLicenseId(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDeprecatedLicenseId(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsDeprecatedLicenseId(boolean)"})
  void testJsonSetIsDeprecatedLicenseId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsDeprecatedLicenseId(true);

    // Assert
    assertTrue(json.isDeprecatedLicenseId);
    assertTrue(json.isDeprecatedLicenseIdIsSet);
  }

  /**
   * Test {@link ImmutableSpdxLicence#seeAlso()}.
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#seeAlso()}
   */
  @Test
  @DisplayName("Test seeAlso()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ImmutableSpdxLicence.seeAlso()"})
  void testSeeAlso() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"See Also"},
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build()
            .seeAlso());
  }

  /**
   * Test {@link ImmutableSpdxLicence#withIsDeprecatedLicenseId(boolean)}.
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withIsDeprecatedLicenseId(boolean)}
   */
  @Test
  @DisplayName("Test withIsDeprecatedLicenseId(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSpdxLicence ImmutableSpdxLicence.withIsDeprecatedLicenseId(boolean)"
  })
  void testWithIsDeprecatedLicenseId() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act
    ImmutableSpdxLicence actualWithIsDeprecatedLicenseIdResult =
        immutableSpdxLicence.withIsDeprecatedLicenseId(true);

    // Assert
    assertSame(immutableSpdxLicence, actualWithIsDeprecatedLicenseIdResult);
  }

  /**
   * Test {@link ImmutableSpdxLicence#withIsDeprecatedLicenseId(boolean)}.
   *
   * <ul>
   *   <li>Then return licenseId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withIsDeprecatedLicenseId(boolean)}
   */
  @Test
  @DisplayName("Test withIsDeprecatedLicenseId(boolean); then return licenseId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSpdxLicence ImmutableSpdxLicence.withIsDeprecatedLicenseId(boolean)"
  })
  void testWithIsDeprecatedLicenseId_thenReturnLicenseIdIs42() {
    // Arrange and Act
    ImmutableSpdxLicence actualWithIsDeprecatedLicenseIdResult =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(false)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build()
            .withIsDeprecatedLicenseId(true);

    // Assert
    assertEquals("42", actualWithIsDeprecatedLicenseIdResult.licenseId());
    assertEquals("License Text", actualWithIsDeprecatedLicenseIdResult.licenseText());
    assertEquals("Name", actualWithIsDeprecatedLicenseIdResult.name());
    assertTrue(actualWithIsDeprecatedLicenseIdResult.isDeprecatedLicenseId());
  }

  /**
   * Test {@link ImmutableSpdxLicence#withLicenseId(String)}.
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withLicenseId(String)}
   */
  @Test
  @DisplayName("Test withLicenseId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withLicenseId(String)"})
  void testWithLicenseId() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act
    ImmutableSpdxLicence actualWithLicenseIdResult = immutableSpdxLicence.withLicenseId("42");

    // Assert
    assertSame(immutableSpdxLicence, actualWithLicenseIdResult);
  }

  /**
   * Test {@link ImmutableSpdxLicence#withLicenseId(String)}.
   *
   * <ul>
   *   <li>Then return licenseId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withLicenseId(String)}
   */
  @Test
  @DisplayName("Test withLicenseId(String); then return licenseId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withLicenseId(String)"})
  void testWithLicenseId_thenReturnLicenseIdIs42() {
    // Arrange and Act
    ImmutableSpdxLicence actualWithLicenseIdResult =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("licenseId")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build()
            .withLicenseId("42");

    // Assert
    assertEquals("42", actualWithLicenseIdResult.licenseId());
    assertEquals("License Text", actualWithLicenseIdResult.licenseText());
    assertEquals("Name", actualWithLicenseIdResult.name());
    assertTrue(actualWithLicenseIdResult.isDeprecatedLicenseId());
  }

  /**
   * Test {@link ImmutableSpdxLicence#withLicenseText(String)}.
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withLicenseText(String)}
   */
  @Test
  @DisplayName("Test withLicenseText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withLicenseText(String)"})
  void testWithLicenseText() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("42")
            .name("Name")
            .seeAlso("See Also")
            .build();

    // Act
    ImmutableSpdxLicence actualWithLicenseTextResult = immutableSpdxLicence.withLicenseText("42");

    // Assert
    assertSame(immutableSpdxLicence, actualWithLicenseTextResult);
  }

  /**
   * Test {@link ImmutableSpdxLicence#withLicenseText(String)}.
   *
   * <ul>
   *   <li>Then return licenseId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withLicenseText(String)}
   */
  @Test
  @DisplayName("Test withLicenseText(String); then return licenseId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withLicenseText(String)"})
  void testWithLicenseText_thenReturnLicenseIdIs42() {
    // Arrange and Act
    ImmutableSpdxLicence actualWithLicenseTextResult =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build()
            .withLicenseText("42");

    // Assert
    assertEquals("42", actualWithLicenseTextResult.licenseId());
    assertEquals("42", actualWithLicenseTextResult.licenseText());
    assertEquals("Name", actualWithLicenseTextResult.name());
    assertTrue(actualWithLicenseTextResult.isDeprecatedLicenseId());
  }

  /**
   * Test {@link ImmutableSpdxLicence#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableSpdxLicence immutableSpdxLicence =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("42")
            .seeAlso("See Also")
            .build();

    // Act
    ImmutableSpdxLicence actualWithNameResult = immutableSpdxLicence.withName("42");

    // Assert
    assertSame(immutableSpdxLicence, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableSpdxLicence#withName(String)}.
   *
   * <ul>
   *   <li>Then return licenseId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return licenseId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withName(String)"})
  void testWithName_thenReturnLicenseIdIs42() {
    // Arrange and Act
    ImmutableSpdxLicence actualWithNameResult =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.licenseId());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("License Text", actualWithNameResult.licenseText());
    assertTrue(actualWithNameResult.isDeprecatedLicenseId());
  }

  /**
   * Test {@link ImmutableSpdxLicence#withSeeAlso(String[])}.
   *
   * <p>Method under test: {@link ImmutableSpdxLicence#withSeeAlso(String[])}
   */
  @Test
  @DisplayName("Test withSeeAlso(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSpdxLicence ImmutableSpdxLicence.withSeeAlso(String[])"})
  void testWithSeeAlso() {
    // Arrange and Act
    ImmutableSpdxLicence actualWithSeeAlsoResult =
        ImmutableSpdxLicence.builder()
            .isDeprecatedLicenseId(true)
            .licenseId("42")
            .licenseText("License Text")
            .name("Name")
            .seeAlso("See Also")
            .build()
            .withSeeAlso("Elements");

    // Assert
    assertEquals("42", actualWithSeeAlsoResult.licenseId());
    assertEquals("License Text", actualWithSeeAlsoResult.licenseText());
    assertEquals("Name", actualWithSeeAlsoResult.name());
    assertTrue(actualWithSeeAlsoResult.isDeprecatedLicenseId());
  }
}
