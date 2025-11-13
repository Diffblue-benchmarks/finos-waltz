package org.finos.waltz.jobs.tools.importers.licence.finos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableComplianceTerm.Builder;
import org.finos.waltz.jobs.tools.importers.licence.finos.ImmutableComplianceTerm.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplianceTermDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#complianceNotes(String)}
   *   <li>{@link Builder#useCases(ComplianceUseCase[])}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplianceTerm Builder.build()",
    "Builder Builder.complianceNotes(String)",
    "Builder Builder.useCases(ComplianceUseCase[])"
  })
  void testBuilderBuild() {
    // Arrange
    ComplianceUseCase[] useCases = new ComplianceUseCase[] {ComplianceUseCase.UB};

    // Act
    ImmutableComplianceTerm actualImmutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(useCases)
            .build();

    // Assert
    assertEquals("Compliance Notes", actualImmutableComplianceTerm.complianceNotes());
    assertEquals(
        "The characteristics of someone or something", actualImmutableComplianceTerm.description());
    assertEquals(ComplianceType.CONDITION, actualImmutableComplianceTerm.type());
    ComplianceUseCase[] useCasesResult = actualImmutableComplianceTerm.useCases();
    assertSame(useCases, useCasesResult);
    assertArrayEquals(new ComplianceUseCase[] {ComplianceUseCase.UB}, useCasesResult);
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   *
   * <p>Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ImmutableComplianceTerm instance =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    ImmutableComplianceTerm actualImmutableComplianceTerm = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableComplianceTerm);
    ImmutableComplianceTerm actualImmutableComplianceTerm2 = builderResult.build();
    assertEquals(instance, actualImmutableComplianceTerm2);
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   *
   * <p>Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ImmutableComplianceTerm instance =
        ImmutableComplianceTerm.builder()
            .complianceNotes(null)
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    ImmutableComplianceTerm actualImmutableComplianceTerm = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableComplianceTerm);
    ImmutableComplianceTerm actualImmutableComplianceTerm2 = builderResult.build();
    assertEquals(instance, actualImmutableComplianceTerm2);
  }

  /**
   * Test Builder {@link Builder#from(ComplianceTerm)}.
   *
   * <p>Method under test: {@link Builder#from(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test Builder from(ComplianceTerm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplianceTerm)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();
    ImmutableComplianceTerm instance =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplianceTerm actualImmutableComplianceTerm = builderResult.build();
    assertEquals(instance, actualImmutableComplianceTerm);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#type(ComplianceType)}.
   *
   * <p>Method under test: {@link Builder#type(ComplianceType)}
   */
  @Test
  @DisplayName("Test Builder type(ComplianceType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.type(ComplianceType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutableComplianceTerm.builder();

    // Act
    Builder actualTypeResult = builderResult.type(ComplianceType.CONDITION);

    // Assert
    assertSame(builderResult, actualTypeResult);
  }

  /**
   * Test {@link ImmutableComplianceTerm#copyOf(ComplianceTerm)}.
   *
   * <ul>
   *   <li>When {@code UB}.
   *   <li>Then return {@code Compliance Notes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#copyOf(ComplianceTerm)}
   */
  @Test
  @DisplayName("Test copyOf(ComplianceTerm); when 'UB'; then return 'Compliance Notes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.copyOf(ComplianceTerm)"})
  void testCopyOf_whenUb_thenReturnComplianceNotes() {
    // Arrange
    ImmutableComplianceTerm instance =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act
    ImmutableComplianceTerm actualCopyOfResult = ImmutableComplianceTerm.copyOf(instance);

    // Assert
    assertEquals("Compliance Notes", actualCopyOfResult.complianceNotes());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(ComplianceType.CONDITION, actualCopyOfResult.type());
    assertArrayEquals(
        new ComplianceUseCase[] {ComplianceUseCase.UB}, actualCopyOfResult.useCases());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}, and {@link
   * ImmutableComplianceTerm#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplianceTerm#equals(Object)}
   *   <li>{@link ImmutableComplianceTerm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();
    ImmutableComplianceTerm immutableComplianceTerm2 =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    assertEquals(immutableComplianceTerm, immutableComplianceTerm2);
    assertEquals(immutableComplianceTerm.hashCode(), immutableComplianceTerm2.hashCode());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}, and {@link
   * ImmutableComplianceTerm#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplianceTerm#equals(Object)}
   *   <li>{@link ImmutableComplianceTerm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    assertEquals(immutableComplianceTerm, immutableComplianceTerm);
    int expectedHashCodeResult = immutableComplianceTerm.hashCode();
    assertEquals(expectedHashCodeResult, immutableComplianceTerm.hashCode());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases()
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplianceTerm,
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("The characteristics of someone or something")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplianceTerm,
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("Description")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplianceTerm,
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.TERMINATION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableComplianceTerm,
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build());
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableComplianceTerm#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplianceTerm.equals(Object)",
    "int ImmutableComplianceTerm.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build(),
        "Different type to ImmutableComplianceTerm");
  }

  /**
   * Test {@link ImmutableComplianceTerm#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code CONDITION}.
   *   <li>Then return complianceNotes is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'CONDITION'; then return complianceNotes is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.fromJson(Json)"})
  void testFromJson_givenCondition_thenReturnComplianceNotesIsJson() {
    // Arrange
    Json json = new Json();
    json.setType(ComplianceType.CONDITION);
    json.setDescription("Json");
    json.setUseCases(new ComplianceUseCase[] {ComplianceUseCase.UB});
    json.setComplianceNotes("Json");

    // Act
    ImmutableComplianceTerm actualFromJsonResult = ImmutableComplianceTerm.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.complianceNotes());
    ComplianceUseCase[] expectedUseCasesResult = json.useCases;
    ComplianceUseCase[] useCasesResult = actualFromJsonResult.useCases();
    assertSame(expectedUseCasesResult, useCasesResult);
    assertArrayEquals(new ComplianceUseCase[] {ComplianceUseCase.UB}, useCasesResult);
  }

  /**
   * Test {@link ImmutableComplianceTerm#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code CONDITION}.
   *   <li>When {@link Json} (default constructor) UseCases is {@code null}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'CONDITION'; when Json (default constructor) UseCases is 'null'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.fromJson(Json)"})
  void testFromJson_givenCondition_whenJsonUseCasesIsNull_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setType(ComplianceType.CONDITION);
    json.setDescription("Json");
    json.setUseCases(null);
    json.setComplianceNotes("Json");

    // Act
    ImmutableComplianceTerm actualFromJsonResult = ImmutableComplianceTerm.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.complianceNotes());
    assertEquals("Json", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.useCases());
    assertEquals(ComplianceType.CONDITION, actualFromJsonResult.type());
  }

  /**
   * Test {@link ImmutableComplianceTerm#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ComplianceNotes is {@code null}.
   *   <li>Then return complianceNotes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ComplianceNotes is 'null'; then return complianceNotes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.fromJson(Json)"})
  void testFromJson_whenJsonComplianceNotesIsNull_thenReturnComplianceNotesIsNull() {
    // Arrange
    Json json = new Json();
    json.setType(ComplianceType.CONDITION);
    json.setDescription("Json");
    json.setUseCases(new ComplianceUseCase[] {ComplianceUseCase.UB});
    json.setComplianceNotes(null);

    // Act
    ImmutableComplianceTerm actualFromJsonResult = ImmutableComplianceTerm.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.complianceNotes());
    ComplianceUseCase[] expectedUseCasesResult = json.useCases;
    ComplianceUseCase[] useCasesResult = actualFromJsonResult.useCases();
    assertSame(expectedUseCasesResult, useCasesResult);
    assertArrayEquals(new ComplianceUseCase[] {ComplianceUseCase.UB}, useCasesResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplianceTerm#toString()}
   *   <li>{@link ImmutableComplianceTerm#complianceNotes()}
   *   <li>{@link ImmutableComplianceTerm#description()}
   *   <li>{@link ImmutableComplianceTerm#type()}
   *   <li>{@link ImmutableComplianceTerm#useCases()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableComplianceTerm.complianceNotes()",
    "String ImmutableComplianceTerm.description()",
    "String ImmutableComplianceTerm.toString()",
    "ComplianceType ImmutableComplianceTerm.type()",
    "ComplianceUseCase[] ImmutableComplianceTerm.useCases()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act
    String actualToStringResult = immutableComplianceTerm.toString();
    String actualComplianceNotesResult = immutableComplianceTerm.complianceNotes();
    String actualDescriptionResult = immutableComplianceTerm.description();
    ComplianceType actualTypeResult = immutableComplianceTerm.type();

    // Assert
    assertEquals("Compliance Notes", actualComplianceNotesResult);
    assertEquals(
        "ComplianceTerm{type=CONDITION, description=The characteristics of someone or something, useCases=[UB],"
            + " complianceNotes=Compliance Notes}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(ComplianceType.CONDITION, actualTypeResult);
    assertArrayEquals(
        new ComplianceUseCase[] {ComplianceUseCase.UB}, immutableComplianceTerm.useCases());
  }

  /**
   * Test Json {@link Json#complianceNotes()}.
   *
   * <p>Method under test: {@link Json#complianceNotes()}
   */
  @Test
  @DisplayName("Test Json complianceNotes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.complianceNotes()"})
  void testJsonComplianceNotes() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complianceNotes());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComplianceNotes(String)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setType(ComplianceType)}
   *   <li>{@link Json#setUseCases(ComplianceUseCase[])}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setComplianceNotes(String)",
    "void Json.setDescription(String)",
    "void Json.setType(ComplianceType)",
    "void Json.setUseCases(ComplianceUseCase[])"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComplianceNotes("Compliance Notes");
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setType(ComplianceType.CONDITION);
    actualJson.setUseCases(new ComplianceUseCase[] {ComplianceUseCase.UB});

    // Assert
    assertEquals("Compliance Notes", actualJson.complianceNotes);
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(ComplianceType.CONDITION, actualJson.type);
    assertArrayEquals(new ComplianceUseCase[] {ComplianceUseCase.UB}, actualJson.useCases);
  }

  /**
   * Test Json {@link Json#type()}.
   *
   * <p>Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplianceType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().type());
  }

  /**
   * Test Json {@link Json#useCases()}.
   *
   * <p>Method under test: {@link Json#useCases()}
   */
  @Test
  @DisplayName("Test Json useCases()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ComplianceUseCase[] Json.useCases()"})
  void testJsonUseCases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().useCases());
  }

  /**
   * Test {@link ImmutableComplianceTerm#withComplianceNotes(String)}.
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withComplianceNotes(String)}
   */
  @Test
  @DisplayName("Test withComplianceNotes(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.withComplianceNotes(String)"})
  void testWithComplianceNotes() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("42")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act
    ImmutableComplianceTerm actualWithComplianceNotesResult =
        immutableComplianceTerm.withComplianceNotes("42");

    // Assert
    assertSame(immutableComplianceTerm, actualWithComplianceNotesResult);
  }

  /**
   * Test {@link ImmutableComplianceTerm#withComplianceNotes(String)}.
   *
   * <ul>
   *   <li>Then return complianceNotes is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withComplianceNotes(String)}
   */
  @Test
  @DisplayName("Test withComplianceNotes(String); then return complianceNotes is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.withComplianceNotes(String)"})
  void testWithComplianceNotes_thenReturnComplianceNotesIs42() {
    // Arrange and Act
    ImmutableComplianceTerm actualWithComplianceNotesResult =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build()
            .withComplianceNotes("42");

    // Assert
    assertEquals("42", actualWithComplianceNotesResult.complianceNotes());
    assertEquals(
        "The characteristics of someone or something",
        actualWithComplianceNotesResult.description());
    assertEquals(ComplianceType.CONDITION, actualWithComplianceNotesResult.type());
    assertArrayEquals(
        new ComplianceUseCase[] {ComplianceUseCase.UB}, actualWithComplianceNotesResult.useCases());
  }

  /**
   * Test {@link ImmutableComplianceTerm#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("42")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act
    ImmutableComplianceTerm actualWithDescriptionResult =
        immutableComplianceTerm.withDescription("42");

    // Assert
    assertSame(immutableComplianceTerm, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableComplianceTerm#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.withDescription(String)"})
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableComplianceTerm actualWithDescriptionResult =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("Compliance Notes", actualWithDescriptionResult.complianceNotes());
    assertEquals(ComplianceType.CONDITION, actualWithDescriptionResult.type());
    assertArrayEquals(
        new ComplianceUseCase[] {ComplianceUseCase.UB}, actualWithDescriptionResult.useCases());
  }

  /**
   * Test {@link ImmutableComplianceTerm#withType(ComplianceType)}.
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withType(ComplianceType)}
   */
  @Test
  @DisplayName("Test withType(ComplianceType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.withType(ComplianceType)"})
  void testWithType() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act
    ImmutableComplianceTerm actualWithTypeResult =
        immutableComplianceTerm.withType(ComplianceType.CONDITION);

    // Assert
    assertSame(immutableComplianceTerm, actualWithTypeResult);
  }

  /**
   * Test {@link ImmutableComplianceTerm#withType(ComplianceType)}.
   *
   * <ul>
   *   <li>Then return {@code Compliance Notes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withType(ComplianceType)}
   */
  @Test
  @DisplayName("Test withType(ComplianceType); then return 'Compliance Notes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplianceTerm ImmutableComplianceTerm.withType(ComplianceType)"})
  void testWithType_thenReturnComplianceNotes() {
    // Arrange and Act
    ImmutableComplianceTerm actualWithTypeResult =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.TERMINATION)
            .useCases(ComplianceUseCase.UB)
            .build()
            .withType(ComplianceType.CONDITION);

    // Assert
    assertEquals("Compliance Notes", actualWithTypeResult.complianceNotes());
    assertEquals("The characteristics of someone or something", actualWithTypeResult.description());
    assertEquals(ComplianceType.CONDITION, actualWithTypeResult.type());
    assertArrayEquals(
        new ComplianceUseCase[] {ComplianceUseCase.UB}, actualWithTypeResult.useCases());
  }

  /**
   * Test {@link ImmutableComplianceTerm#withUseCases(ComplianceUseCase[])}.
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withUseCases(ComplianceUseCase[])}
   */
  @Test
  @DisplayName("Test withUseCases(ComplianceUseCase[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplianceTerm ImmutableComplianceTerm.withUseCases(ComplianceUseCase[])"
  })
  void testWithUseCases() {
    // Arrange
    ImmutableComplianceTerm immutableComplianceTerm =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build();

    // Act
    ImmutableComplianceTerm actualWithUseCasesResult =
        immutableComplianceTerm.withUseCases(ComplianceUseCase.UB);

    // Assert
    assertEquals(immutableComplianceTerm, actualWithUseCasesResult);
  }

  /**
   * Test {@link ImmutableComplianceTerm#withUseCases(ComplianceUseCase[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Compliance Notes}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplianceTerm#withUseCases(ComplianceUseCase[])}
   */
  @Test
  @DisplayName(
      "Test withUseCases(ComplianceUseCase[]); when 'null'; then return 'Compliance Notes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplianceTerm ImmutableComplianceTerm.withUseCases(ComplianceUseCase[])"
  })
  void testWithUseCases_whenNull_thenReturnComplianceNotes() {
    // Arrange and Act
    ImmutableComplianceTerm actualWithUseCasesResult =
        ImmutableComplianceTerm.builder()
            .complianceNotes("Compliance Notes")
            .description("The characteristics of someone or something")
            .type(ComplianceType.CONDITION)
            .useCases(ComplianceUseCase.UB)
            .build()
            .withUseCases(null);

    // Assert
    assertEquals("Compliance Notes", actualWithUseCasesResult.complianceNotes());
    assertEquals(
        "The characteristics of someone or something", actualWithUseCasesResult.description());
    assertNull(actualWithUseCasesResult.useCases());
    assertEquals(ComplianceType.CONDITION, actualWithUseCasesResult.type());
  }
}
