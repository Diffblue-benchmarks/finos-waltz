package org.finos.waltz.jobs.tools.importers.licence.finos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableLicenceCompliance.Builder;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableLicenceCompliance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLicenceComplianceDiffblueTest {
  /**
   * Test {@link ImmutableLicenceCompliance#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLicenceCompliance#builder()}
   *   <li>{@link ImmutableLicenceCompliance#notes(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLicenceCompliance Builder.build()", "Builder Builder.notes(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableLicenceCompliance.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.notes("Notes"));
  }

  /**
   * Test Builder {@link Builder#from(LicenceCompliance)}.
   * <ul>
   *   <li>Given {@code Notes}.</li>
   *   <li>Then builder build notes is {@code Notes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LicenceCompliance)}
   */
  @Test
  @DisplayName("Test Builder from(LicenceCompliance); given 'Notes'; then builder build notes is 'Notes'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LicenceCompliance)"})
  void testBuilderFrom_givenNotes_thenBuilderBuildNotesIsNotes() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();
    LicenceCompliance instance = mock(LicenceCompliance.class);
    when(instance.notes()).thenReturn("Notes");
    when(instance.terms()).thenReturn(new ComplianceTerm[]{new ImmutableComplianceTerm.Json()});
    when(instance.licenseId()).thenReturn(new String[]{"42"});
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(LicenceCompliance)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LicenceCompliance)}
   */
  @Test
  @DisplayName("Test Builder from(LicenceCompliance); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LicenceCompliance)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();
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
   * Test Builder {@link Builder#from(LicenceCompliance)}.
   * <ul>
   *   <li>When {@link LicenceCompliance} {@link LicenceCompliance#notes()} return {@code null}.</li>
   *   <li>Then builder build notes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LicenceCompliance)}
   */
  @Test
  @DisplayName("Test Builder from(LicenceCompliance); when LicenceCompliance notes() return 'null'; then builder build notes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LicenceCompliance)"})
  void testBuilderFrom_whenLicenceComplianceNotesReturnNull_thenBuilderBuildNotesIsNull() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();
    LicenceCompliance instance = mock(LicenceCompliance.class);
    when(instance.notes()).thenReturn(null);
    when(instance.terms()).thenReturn(new ComplianceTerm[]{new ImmutableComplianceTerm.Json()});
    when(instance.licenseId()).thenReturn(new String[]{"42"});
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#licenseId(String[])}.
   * <p>
   * Method under test: {@link Builder#licenseId(String[])}
   */
  @Test
  @DisplayName("Test Builder licenseId(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.licenseId(String[])"})
  void testBuilderLicenseId() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.licenseId("42"));
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
    Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#terms(ComplianceTerm[])}.
   * <p>
   * Method under test: {@link Builder#terms(ComplianceTerm[])}
   */
  @Test
  @DisplayName("Test Builder terms(ComplianceTerm[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.terms(ComplianceTerm[])"})
  void testBuilderTerms() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.terms(new ImmutableComplianceTerm.Json()));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLicenseId(String[])}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setNotes(String)}
   *   <li>{@link Json#setTerms(ComplianceTerm[])}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setLicenseId(String[])", "void Json.setName(String)",
      "void Json.setNotes(String)", "void Json.setTerms(ComplianceTerm[])"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#licenseId()}.
   * <p>
   * Method under test: {@link Json#licenseId()}
   */
  @Test
  @DisplayName("Test Json licenseId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] Json.licenseId()"})
  void testJsonLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).licenseId());
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
   * Test Json {@link Json#notes()}.
   * <p>
   * Method under test: {@link Json#notes()}
   */
  @Test
  @DisplayName("Test Json notes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.notes()"})
  void testJsonNotes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).notes());
  }

  /**
   * Test Json {@link Json#terms()}.
   * <p>
   * Method under test: {@link Json#terms()}
   */
  @Test
  @DisplayName("Test Json terms()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ComplianceTerm[] Json.terms()"})
  void testJsonTerms() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).terms());
  }
}
