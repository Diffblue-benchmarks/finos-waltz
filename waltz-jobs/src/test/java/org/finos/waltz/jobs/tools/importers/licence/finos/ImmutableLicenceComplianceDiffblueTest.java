package org.finos.waltz.jobs.tools.importers.licence.finos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableLicenceCompliance.Builder;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableLicenceCompliance.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLicenceComplianceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#notes(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance Builder.build()", "Builder Builder.notes(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualNotesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance actualImmutableLicenceCompliance =
        actualNotesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Assert
    assertEquals("Name", actualImmutableLicenceCompliance.name());
    assertEquals("Notes", actualImmutableLicenceCompliance.notes());
  }

  /**
   * Test Builder {@link Builder#from(LicenceCompliance)}.
   *
   * <p>Method under test: {@link Builder#from(LicenceCompliance)}
   */
  @Test
  @DisplayName("Test Builder from(LicenceCompliance)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LicenceCompliance)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();

    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance instance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLicenceCompliance actualImmutableLicenceCompliance = builderResult.build();
    assertEquals(instance, actualImmutableLicenceCompliance);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LicenceCompliance)}.
   *
   * <p>Method under test: {@link Builder#from(LicenceCompliance)}
   */
  @Test
  @DisplayName("Test Builder from(LicenceCompliance)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LicenceCompliance)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();

    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes(null);
    ImmutableLicenceCompliance instance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLicenceCompliance actualImmutableLicenceCompliance = builderResult.build();
    assertEquals(instance, actualImmutableLicenceCompliance);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#licenseId(String[])}.
   *
   * <p>Method under test: {@link Builder#licenseId(String[])}
   */
  @Test
  @DisplayName("Test Builder licenseId(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.licenseId(String[])"})
  void testBuilderLicenseId() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act
    Builder actualLicenseIdResult = builderResult.licenseId("42");

    // Assert
    assertSame(builderResult, actualLicenseIdResult);
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
    Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#terms(ComplianceTerm[])}.
   *
   * <p>Method under test: {@link Builder#terms(ComplianceTerm[])}
   */
  @Test
  @DisplayName("Test Builder terms(ComplianceTerm[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.terms(ComplianceTerm[])"})
  void testBuilderTerms() {
    // Arrange
    Builder builderResult = ImmutableLicenceCompliance.builder();

    // Act
    Builder actualTermsResult = builderResult.terms(new ImmutableComplianceTerm.Json());

    // Assert
    assertSame(builderResult, actualTermsResult);
  }

  /**
   * Test {@link ImmutableLicenceCompliance#copyOf(LicenceCompliance)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#copyOf(LicenceCompliance)}
   */
  @Test
  @DisplayName("Test copyOf(LicenceCompliance); when '42'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLicenceCompliance ImmutableLicenceCompliance.copyOf(LicenceCompliance)"
  })
  void testCopyOf_when42_thenReturnName() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance instance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    ImmutableLicenceCompliance actualCopyOfResult = ImmutableLicenceCompliance.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Notes", actualCopyOfResult.notes());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}, and {@link
   * ImmutableLicenceCompliance#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLicenceCompliance#equals(Object)}
   *   <li>{@link ImmutableLicenceCompliance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    Builder notesResult2 =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance2 =
        notesResult2
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLicenceCompliance, immutableLicenceCompliance2);
    assertEquals(immutableLicenceCompliance.hashCode(), immutableLicenceCompliance2.hashCode());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}, and {@link
   * ImmutableLicenceCompliance#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLicenceCompliance#equals(Object)}
   *   <li>{@link ImmutableLicenceCompliance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableLicenceCompliance, immutableLicenceCompliance);
    int expectedHashCodeResult = immutableLicenceCompliance.hashCode();
    assertEquals(expectedHashCodeResult, immutableLicenceCompliance.hashCode());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases()
                    .build())
            .build();

    Builder notesResult2 =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertNotEquals(
        immutableLicenceCompliance,
        notesResult2
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("Name").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    Builder notesResult2 =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertNotEquals(
        immutableLicenceCompliance,
        notesResult2
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder()
            .licenseId("42")
            .name("The characteristics of someone or something")
            .notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    Builder notesResult2 =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertNotEquals(
        immutableLicenceCompliance,
        notesResult2
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Name");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    Builder notesResult2 =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertNotEquals(
        immutableLicenceCompliance,
        notesResult2
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertNotEquals(
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableLicenceCompliance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLicenceCompliance.equals(Object)",
    "int ImmutableLicenceCompliance.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertNotEquals(
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build(),
        "Different type to ImmutableLicenceCompliance");
  }

  /**
   * Test {@link ImmutableLicenceCompliance#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return notes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given array of String with 'Json'; when Json (default constructor) Name is 'Json'; then return notes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance ImmutableLicenceCompliance.fromJson(Json)"})
  void testFromJson_givenArrayOfStringWithJson_whenJsonNameIsJson_thenReturnNotesIsNull() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setLicenseId(new String[] {"Json"});
    json.setNotes(null);
    json.setTerms(new ComplianceTerm[] {new ImmutableComplianceTerm.Json()});

    // Act
    ImmutableLicenceCompliance actualFromJsonResult = ImmutableLicenceCompliance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.notes());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Notes is {@code Json}.
   *   <li>Then return notes is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Notes is 'Json'; then return notes is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance ImmutableLicenceCompliance.fromJson(Json)"})
  void testFromJson_whenJsonNotesIsJson_thenReturnNotesIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setLicenseId(new String[] {"Json"});
    json.setNotes("Json");
    json.setTerms(new ComplianceTerm[] {new ImmutableComplianceTerm.Json()});

    // Act
    ImmutableLicenceCompliance actualFromJsonResult = ImmutableLicenceCompliance.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals("Json", actualFromJsonResult.notes());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLicenceCompliance#toString()}
   *   <li>{@link ImmutableLicenceCompliance#name()}
   *   <li>{@link ImmutableLicenceCompliance#notes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableLicenceCompliance.name()",
    "String ImmutableLicenceCompliance.notes()",
    "String ImmutableLicenceCompliance.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableLicenceCompliance.toString();
    String actualNameResult = immutableLicenceCompliance.name();

    // Assert
    assertEquals(
        "LicenceCompliance{name=Name, licenseId=[42], notes=Notes, terms=[ComplianceTerm{type=CONDITION,"
            + " description=The characteristics of someone or something, useCases=[UB], complianceNotes=Compliance"
            + " Notes}]}",
        actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Notes", immutableLicenceCompliance.notes());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setLicenseId(String[])",
    "void Json.setName(String)",
    "void Json.setNotes(String)",
    "void Json.setTerms(ComplianceTerm[])"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLicenseId(new String[] {"42"});
    actualJson.setName("Name");
    actualJson.setNotes("Notes");
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();
    actualJson.setTerms(new ComplianceTerm[] {immutableComplianceTerm});

    // Assert
    ComplianceTerm[] complianceTermArray = actualJson.terms;
    ComplianceTerm complianceTerm = complianceTermArray[0];
    assertTrue(complianceTerm instanceof ImmutableComplianceTerm);
    assertEquals("Compliance Notes", complianceTerm.complianceNotes());
    assertEquals("Name", actualJson.name);
    assertEquals("Notes", actualJson.notes);
    assertEquals("The characteristics of someone or something", complianceTerm.description());
    assertEquals(1, complianceTermArray.length);
    assertEquals(ComplianceType.CONDITION, complianceTerm.type());
    assertArrayEquals(new String[] {"42"}, actualJson.licenseId);
    assertArrayEquals(new ComplianceUseCase[] {ComplianceUseCase.UB}, complianceTerm.useCases());
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
  @MethodsUnderTest({"String[] Json.licenseId()"})
  void testJsonLicenseId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().licenseId());
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
   * Test Json {@link Json#notes()}.
   *
   * <p>Method under test: {@link Json#notes()}
   */
  @Test
  @DisplayName("Test Json notes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.notes()"})
  void testJsonNotes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().notes());
  }

  /**
   * Test Json {@link Json#terms()}.
   *
   * <p>Method under test: {@link Json#terms()}
   */
  @Test
  @DisplayName("Test Json terms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplianceTerm[] Json.terms()"})
  void testJsonTerms() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().terms());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#licenseId()}.
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#licenseId()}
   */
  @Test
  @DisplayName("Test licenseId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] ImmutableLicenceCompliance.licenseId()"})
  void testLicenseId() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act and Assert
    assertArrayEquals(
        new String[] {"42"},
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build()
            .licenseId());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#terms()}.
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#terms()}
   */
  @Test
  @DisplayName("Test terms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplianceTerm[] ImmutableLicenceCompliance.terms()"})
  void testTerms() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act
    ComplianceTerm[] actualTermsResult =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build()
            .terms();

    // Assert
    ComplianceTerm complianceTerm = actualTermsResult[0];
    assertTrue(complianceTerm instanceof ImmutableComplianceTerm);
    assertEquals("Compliance Notes", complianceTerm.complianceNotes());
    assertEquals("The characteristics of someone or something", complianceTerm.description());
    assertEquals(1, actualTermsResult.length);
    assertEquals(ComplianceType.CONDITION, complianceTerm.type());
    assertArrayEquals(new ComplianceUseCase[] {ComplianceUseCase.UB}, complianceTerm.useCases());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#withLicenseId(String[])}.
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#withLicenseId(String[])}
   */
  @Test
  @DisplayName("Test withLicenseId(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLicenceCompliance ImmutableLicenceCompliance.withLicenseId(String[])"
  })
  void testWithLicenseId() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act
    ImmutableLicenceCompliance actualWithLicenseIdResult =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build()
            .withLicenseId("Elements");

    // Assert
    assertEquals("Name", actualWithLicenseIdResult.name());
    assertEquals("Notes", actualWithLicenseIdResult.notes());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance ImmutableLicenceCompliance.withName(String)"})
  void testWithName() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("42").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    ImmutableLicenceCompliance actualWithNameResult = immutableLicenceCompliance.withName("42");

    // Assert
    assertSame(immutableLicenceCompliance, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableLicenceCompliance#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance ImmutableLicenceCompliance.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act
    ImmutableLicenceCompliance actualWithNameResult =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Notes", actualWithNameResult.notes());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#withNotes(String)}.
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#withNotes(String)}
   */
  @Test
  @DisplayName("Test withNotes(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance ImmutableLicenceCompliance.withNotes(String)"})
  void testWithNotes() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("42");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    ImmutableLicenceCompliance actualWithNotesResult = immutableLicenceCompliance.withNotes("42");

    // Assert
    assertSame(immutableLicenceCompliance, actualWithNotesResult);
  }

  /**
   * Test {@link ImmutableLicenceCompliance#withNotes(String)}.
   *
   * <ul>
   *   <li>Then return notes is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#withNotes(String)}
   */
  @Test
  @DisplayName("Test withNotes(String); then return notes is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLicenceCompliance ImmutableLicenceCompliance.withNotes(String)"})
  void testWithNotes_thenReturnNotesIs42() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");

    // Act
    ImmutableLicenceCompliance actualWithNotesResult =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build()
            .withNotes("42");

    // Assert
    assertEquals("42", actualWithNotesResult.notes());
    assertEquals("Name", actualWithNotesResult.name());
  }

  /**
   * Test {@link ImmutableLicenceCompliance#withTerms(ComplianceTerm[])}.
   *
   * <p>Method under test: {@link ImmutableLicenceCompliance#withTerms(ComplianceTerm[])}
   */
  @Test
  @DisplayName("Test withTerms(ComplianceTerm[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLicenceCompliance ImmutableLicenceCompliance.withTerms(ComplianceTerm[])"
  })
  void testWithTerms() {
    // Arrange
    Builder notesResult =
        ImmutableLicenceCompliance.builder().licenseId("42").name("Name").notes("Notes");
    ImmutableLicenceCompliance immutableLicenceCompliance =
        notesResult
            .terms(
                ImmutableComplianceTerm.builder()
                    .complianceNotes("Compliance Notes")
                    .description("The characteristics of someone or something")
                    .type(ComplianceType.CONDITION)
                    .useCases(ComplianceUseCase.UB)
                    .build())
            .build();

    // Act
    ImmutableLicenceCompliance actualWithTermsResult =
        immutableLicenceCompliance.withTerms(
            ImmutableComplianceTerm.builder()
                .complianceNotes("Compliance Notes")
                .description("The characteristics of someone or something")
                .type(ComplianceType.CONDITION)
                .useCases(ComplianceUseCase.UB)
                .build());

    // Assert
    assertEquals(immutableLicenceCompliance, actualWithTermsResult);
  }
}
