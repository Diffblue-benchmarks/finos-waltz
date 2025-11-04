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
import org.junit.jupiter.api.Test;

class ImmutableSpdxLicenceDiffblueTest {
  /**
   * Method under test: {@link ImmutableSpdxLicence.Builder#from(SpdxLicence)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();
    SpdxLicence instance = mock(SpdxLicence.class);
    when(instance.isDeprecatedLicenseId()).thenReturn(true);
    when(instance.seeAlso()).thenReturn(new String[]{"See Also"});
    when(instance.licenseText()).thenReturn("License Text");
    when(instance.name()).thenReturn("Name");
    when(instance.licenseId()).thenReturn("42");

    // Act
    ImmutableSpdxLicence.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test: {@link ImmutableSpdxLicence.Builder#from(SpdxLicence)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();
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
   * Method under test:
   * {@link ImmutableSpdxLicence.Builder#isDeprecatedLicenseId(boolean)}
   */
  @Test
  void testBuilderIsDeprecatedLicenseId() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isDeprecatedLicenseId(true));
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Builder#licenseId(String)}
   */
  @Test
  void testBuilderLicenseId() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.licenseId("42"));
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Builder#licenseText(String)}
   */
  @Test
  void testBuilderLicenseText() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.licenseText("License Text"));
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Builder#seeAlso(String[])}
   */
  @Test
  void testBuilderSeeAlso() {
    // Arrange
    ImmutableSpdxLicence.Builder builderResult = ImmutableSpdxLicence.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.seeAlso("See Also"));
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence#copyOf(SpdxLicence)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SpdxLicence instance = mock(SpdxLicence.class);
    when(instance.isDeprecatedLicenseId()).thenReturn(true);
    when(instance.seeAlso()).thenReturn(new String[]{"See Also"});
    when(instance.licenseText()).thenReturn("License Text");
    when(instance.name()).thenReturn("Name");
    when(instance.licenseId()).thenReturn("42");

    // Act
    ImmutableSpdxLicence actualCopyOfResult = ImmutableSpdxLicence.copyOf(instance);

    // Assert
    verify(instance).isDeprecatedLicenseId();
    verify(instance).licenseId();
    verify(instance).licenseText();
    verify(instance).name();
    verify(instance).seeAlso();
    assertEquals("42", actualCopyOfResult.licenseId());
    assertEquals("License Text", actualCopyOfResult.licenseText());
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.isDeprecatedLicenseId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableSpdxLicence.Json}
   *   <li>{@link ImmutableSpdxLicence.Json#setLicenseId(String)}
   *   <li>{@link ImmutableSpdxLicence.Json#setLicenseText(String)}
   *   <li>{@link ImmutableSpdxLicence.Json#setName(String)}
   *   <li>{@link ImmutableSpdxLicence.Json#setSeeAlso(String[])}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableSpdxLicence.Json actualJson = new ImmutableSpdxLicence.Json();
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
   * Method under test: {@link ImmutableSpdxLicence.Json#isDeprecatedLicenseId()}
   */
  @Test
  void testJsonIsDeprecatedLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSpdxLicence.Json()).isDeprecatedLicenseId());
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Json#licenseId()}
   */
  @Test
  void testJsonLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSpdxLicence.Json()).licenseId());
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Json#licenseText()}
   */
  @Test
  void testJsonLicenseText() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSpdxLicence.Json()).licenseText());
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSpdxLicence.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableSpdxLicence.Json#seeAlso()}
   */
  @Test
  void testJsonSeeAlso() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSpdxLicence.Json()).seeAlso());
  }

  /**
   * Method under test:
   * {@link ImmutableSpdxLicence.Json#setIsDeprecatedLicenseId(boolean)}
   */
  @Test
  void testJsonSetIsDeprecatedLicenseId() {
    // Arrange
    ImmutableSpdxLicence.Json json = new ImmutableSpdxLicence.Json();

    // Act
    json.setIsDeprecatedLicenseId(true);

    // Assert
    assertTrue(json.isDeprecatedLicenseId);
    assertTrue(json.isDeprecatedLicenseIdIsSet);
  }
}
