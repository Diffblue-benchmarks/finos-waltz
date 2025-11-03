package org.finos.waltz.jobs.tools.importers.licence.spdx;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.licence.spdx.ImmutableSpdxLicence.Builder;
import org.finos.waltz.jobs.tools.importers.licence.spdx.ImmutableSpdxLicence.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSpdxLicenceDiffblueTest {
  /**
   * Test Builder {@link Builder#from(SpdxLicence)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build licenseId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SpdxLicence)}
   */
  @Test
  @DisplayName("Test Builder from(SpdxLicence); given 'true'; then builder build licenseId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SpdxLicence)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildLicenseIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();
    SpdxLicence instance = mock(SpdxLicence.class);
    when(instance.isDeprecatedLicenseId()).thenReturn(true);
    when(instance.seeAlso()).thenReturn(new String[]{"See Also"});
    when(instance.licenseText()).thenReturn("License Text");
    when(instance.name()).thenReturn("Name");
    when(instance.licenseId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).isDeprecatedLicenseId();
    verify(instance).licenseId();
    verify(instance).licenseText();
    verify(instance).name();
    verify(instance).seeAlso();
    ImmutableSpdxLicence buildResult = builderResult.build();
    assertEquals("42", buildResult.licenseId());
    assertEquals("License Text", buildResult.licenseText());
    assertEquals("Name", buildResult.name());
    assertTrue(buildResult.isDeprecatedLicenseId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SpdxLicence)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SpdxLicence)}
   */
  @Test
  @DisplayName("Test Builder from(SpdxLicence); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SpdxLicence)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();
    SpdxLicence instance = mock(SpdxLicence.class);
    when(instance.isDeprecatedLicenseId()).thenThrow(new IllegalStateException("instance"));
    when(instance.seeAlso()).thenReturn(new String[]{"See Also"});
    when(instance.licenseText()).thenReturn("License Text");
    when(instance.name()).thenReturn("Name");
    when(instance.licenseId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).isDeprecatedLicenseId();
    verify(instance).licenseId();
    verify(instance).licenseText();
    verify(instance).name();
    verify(instance).seeAlso();
  }

  /**
   * Test Builder {@link Builder#isDeprecatedLicenseId(boolean)}.
   * <p>
   * Method under test: {@link Builder#isDeprecatedLicenseId(boolean)}
   */
  @Test
  @DisplayName("Test Builder isDeprecatedLicenseId(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isDeprecatedLicenseId(boolean)"})
  void testBuilderIsDeprecatedLicenseId() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDeprecatedLicenseId(true));
  }

  /**
   * Test Builder {@link Builder#licenseId(String)}.
   * <p>
   * Method under test: {@link Builder#licenseId(String)}
   */
  @Test
  @DisplayName("Test Builder licenseId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.licenseId(String)"})
  void testBuilderLicenseId() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.licenseId("42"));
  }

  /**
   * Test Builder {@link Builder#licenseText(String)}.
   * <p>
   * Method under test: {@link Builder#licenseText(String)}
   */
  @Test
  @DisplayName("Test Builder licenseText(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.licenseText(String)"})
  void testBuilderLicenseText() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.licenseText("License Text"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#seeAlso(String[])}.
   * <p>
   * Method under test: {@link Builder#seeAlso(String[])}
   */
  @Test
  @DisplayName("Test Builder seeAlso(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.seeAlso(String[])"})
  void testBuilderSeeAlso() {
    // Arrange
    Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.seeAlso("See Also"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLicenseId(String)", "void Json.setLicenseText(String)",
      "void Json.setName(String)", "void Json.setSeeAlso(String[])"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLicenseId("42");
    actualJson.setLicenseText("License Text");
    actualJson.setName("Name");
    actualJson.setSeeAlso(new String[]{"See Also"});

    // Assert
    assertEquals("42", actualJson.licenseId);
    assertEquals("License Text", actualJson.licenseText);
    assertEquals("Name", actualJson.name);
    assertFalse(actualJson.isDeprecatedLicenseId);
    assertFalse(actualJson.isDeprecatedLicenseIdIsSet);
    assertArrayEquals(new String[]{"See Also"}, actualJson.seeAlso);
  }

  /**
   * Test Json {@link Json#isDeprecatedLicenseId()}.
   * <p>
   * Method under test: {@link Json#isDeprecatedLicenseId()}
   */
  @Test
  @DisplayName("Test Json isDeprecatedLicenseId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isDeprecatedLicenseId()"})
  void testJsonIsDeprecatedLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isDeprecatedLicenseId());
  }

  /**
   * Test Json {@link Json#licenseId()}.
   * <p>
   * Method under test: {@link Json#licenseId()}
   */
  @Test
  @DisplayName("Test Json licenseId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.licenseId()"})
  void testJsonLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).licenseId());
  }

  /**
   * Test Json {@link Json#licenseText()}.
   * <p>
   * Method under test: {@link Json#licenseText()}
   */
  @Test
  @DisplayName("Test Json licenseText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.licenseText()"})
  void testJsonLicenseText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).licenseText());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json {@link Json#seeAlso()}.
   * <p>
   * Method under test: {@link Json#seeAlso()}
   */
  @Test
  @DisplayName("Test Json seeAlso()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] Json.seeAlso()"})
  void testJsonSeeAlso() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).seeAlso());
  }

  /**
   * Test Json {@link Json#setIsDeprecatedLicenseId(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsDeprecatedLicenseId(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsDeprecatedLicenseId(boolean)")
  @Tag("MaintainedByDiffblue")
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
}
