package org.finos.waltz.jobs.tools.importers.licence.finos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLicenceComplianceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLicenceCompliance#builder()}
   *   <li>{@link ImmutableLicenceCompliance#notes(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableLicenceCompliance.Builder actualBuilderResult = ImmutableLicenceCompliance.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.notes("Notes"));
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance.Builder#from(LicenceCompliance)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLicenceCompliance.Builder builderResult = ImmutableLicenceCompliance.builder();
    LicenceCompliance instance = mock(LicenceCompliance.class);
    when(instance.notes()).thenReturn("Notes");
    when(instance.terms()).thenReturn(new ComplianceTerm[]{new ImmutableComplianceTerm.Json()});
    when(instance.licenseId()).thenReturn(new String[]{"42"});
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicenceCompliance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).licenseId();
    verify(instance).name();
    verify(instance).notes();
    verify(instance).terms();
    ImmutableLicenceCompliance buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Notes", buildResult.notes());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance.Builder#from(LicenceCompliance)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLicenceCompliance.Builder builderResult = ImmutableLicenceCompliance.builder();
    LicenceCompliance instance = mock(LicenceCompliance.class);
    when(instance.notes()).thenThrow(new IllegalStateException("instance"));
    when(instance.licenseId()).thenReturn(new String[]{"42"});
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).licenseId();
    verify(instance).name();
    verify(instance).notes();
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance.Builder#from(LicenceCompliance)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableLicenceCompliance.Builder builderResult = ImmutableLicenceCompliance.builder();
    LicenceCompliance instance = mock(LicenceCompliance.class);
    when(instance.notes()).thenReturn(null);
    when(instance.terms()).thenReturn(new ComplianceTerm[]{new ImmutableComplianceTerm.Json()});
    when(instance.licenseId()).thenReturn(new String[]{"42"});
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicenceCompliance.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).licenseId();
    verify(instance).name();
    verify(instance).notes();
    verify(instance).terms();
    ImmutableLicenceCompliance buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.notes());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance.Builder#licenseId(String[])}
   */
  @Test
  void testBuilderLicenseId() {
    // Arrange
    ImmutableLicenceCompliance.Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.licenseId("42"));
  }

  /**
   * Method under test: {@link ImmutableLicenceCompliance.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableLicenceCompliance.Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance.Builder#terms(ComplianceTerm[])}
   */
  @Test
  void testBuilderTerms() {
    // Arrange
    ImmutableLicenceCompliance.Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.terms(new ImmutableComplianceTerm.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance#copyOf(LicenceCompliance)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LicenceCompliance instance = mock(LicenceCompliance.class);
    when(instance.notes()).thenReturn("Notes");
    when(instance.terms()).thenReturn(new ComplianceTerm[]{new ImmutableComplianceTerm.Json()});
    when(instance.licenseId()).thenReturn(new String[]{"42"});
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableLicenceCompliance actualCopyOfResult = ImmutableLicenceCompliance.copyOf(instance);

    // Assert
    verify(instance).licenseId();
    verify(instance).name();
    verify(instance).notes();
    verify(instance).terms();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Notes", actualCopyOfResult.notes());
  }

  /**
   * Method under test:
   * {@link ImmutableLicenceCompliance#fromJson(ImmutableLicenceCompliance.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableLicenceCompliance.Json json = new ImmutableLicenceCompliance.Json();
    json.setName("Json");
    json.setLicenseId(new String[]{"Json"});
    json.setNotes(null);
    json.setTerms(new ComplianceTerm[]{new ImmutableComplianceTerm.Json()});

    // Act
    ImmutableLicenceCompliance actualFromJsonResult = ImmutableLicenceCompliance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.notes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableLicenceCompliance.Json}
   *   <li>{@link ImmutableLicenceCompliance.Json#setLicenseId(String[])}
   *   <li>{@link ImmutableLicenceCompliance.Json#setName(String)}
   *   <li>{@link ImmutableLicenceCompliance.Json#setNotes(String)}
   *   <li>{@link ImmutableLicenceCompliance.Json#setTerms(ComplianceTerm[])}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableLicenceCompliance.Json actualJson = new ImmutableLicenceCompliance.Json();
    actualJson.setLicenseId(new String[]{"42"});
    actualJson.setName("Name");
    actualJson.setNotes("Notes");
    ImmutableComplianceTerm.Json json = new ImmutableComplianceTerm.Json();
    actualJson.setTerms(new ComplianceTerm[]{json});

    // Assert
    assertEquals("Name", actualJson.name);
    assertEquals("Notes", actualJson.notes);
    ComplianceTerm[] complianceTermArray = actualJson.terms;
    assertEquals(1, complianceTermArray.length);
    assertSame(json, complianceTermArray[0]);
    assertArrayEquals(new String[]{"42"}, actualJson.licenseId);
  }

  /**
   * Method under test: {@link ImmutableLicenceCompliance.Json#licenseId()}
   */
  @Test
  void testJsonLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicenceCompliance.Json()).licenseId());
  }

  /**
   * Method under test: {@link ImmutableLicenceCompliance.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicenceCompliance.Json()).name());
  }

  /**
   * Method under test: {@link ImmutableLicenceCompliance.Json#notes()}
   */
  @Test
  void testJsonNotes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicenceCompliance.Json()).notes());
  }

  /**
   * Method under test: {@link ImmutableLicenceCompliance.Json#terms()}
   */
  @Test
  void testJsonTerms() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableLicenceCompliance.Json()).terms());
  }
}
