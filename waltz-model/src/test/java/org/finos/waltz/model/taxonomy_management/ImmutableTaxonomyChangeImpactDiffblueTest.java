package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeImpact.Builder;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangeImpact.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangeImpactDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableTaxonomyChangeImpact Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableTaxonomyChangeImpact actualImmutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Assert
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableTaxonomyChangeImpact.description());
    assertEquals(3, actualImmutableTaxonomyChangeImpact.impactCount());
    assertEquals(Severity.INFORMATION, actualImmutableTaxonomyChangeImpact.severity());
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
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    ImmutableTaxonomyChangeImpact instance =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableTaxonomyChangeImpact actualImmutableTaxonomyChangeImpact = builderResult.build();
    assertEquals(instance, actualImmutableTaxonomyChangeImpact);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeImpact)} with {@code TaxonomyChangeImpact}.
   *
   * <p>Method under test: {@link Builder#from(TaxonomyChangeImpact)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeImpact) with 'TaxonomyChangeImpact'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeImpact)"})
  void testBuilderFromWithTaxonomyChangeImpact() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    ImmutableTaxonomyChangeImpact instance =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableTaxonomyChangeImpact actualImmutableTaxonomyChangeImpact = builderResult.build();
    assertEquals(instance, actualImmutableTaxonomyChangeImpact);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#impactCount(int)}.
   *
   * <p>Method under test: {@link Builder#impactCount(int)}
   */
  @Test
  @DisplayName("Test Builder impactCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.impactCount(int)"})
  void testBuilderImpactCount() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act
    Builder actualImpactCountResult = builderResult.impactCount(3);

    // Assert
    assertSame(builderResult, actualImpactCountResult);
  }

  /**
   * Test Builder {@link Builder#severity(Severity)}.
   *
   * <p>Method under test: {@link Builder#severity(Severity)}
   */
  @Test
  @DisplayName("Test Builder severity(Severity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.severity(Severity)"})
  void testBuilderSeverity() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act
    Builder actualSeverityResult = builderResult.severity(Severity.INFORMATION);

    // Assert
    assertSame(builderResult, actualSeverityResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#copyOf(TaxonomyChangeImpact)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#copyOf(TaxonomyChangeImpact)}
   */
  @Test
  @DisplayName(
      "Test copyOf(TaxonomyChangeImpact); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.copyOf(TaxonomyChangeImpact)"
  })
  void testCopyOf_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    ImmutableTaxonomyChangeImpact instance =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    ImmutableTaxonomyChangeImpact actualCopyOfResult =
        ImmutableTaxonomyChangeImpact.copyOf(instance);

    // Assert
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(3, actualCopyOfResult.impactCount());
    assertEquals(Severity.INFORMATION, actualCopyOfResult.severity());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}, and {@link
   * ImmutableTaxonomyChangeImpact#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeImpact#equals(Object)}
   *   <li>{@link ImmutableTaxonomyChangeImpact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact2 =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act and Assert
    assertEquals(immutableTaxonomyChangeImpact, immutableTaxonomyChangeImpact2);
    assertEquals(
        immutableTaxonomyChangeImpact.hashCode(), immutableTaxonomyChangeImpact2.hashCode());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}, and {@link
   * ImmutableTaxonomyChangeImpact#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeImpact#equals(Object)}
   *   <li>{@link ImmutableTaxonomyChangeImpact#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act and Assert
    assertEquals(immutableTaxonomyChangeImpact, immutableTaxonomyChangeImpact);
    int expectedHashCodeResult = immutableTaxonomyChangeImpact.hashCode();
    assertEquals(expectedHashCodeResult, immutableTaxonomyChangeImpact.hashCode());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("Description")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeImpact,
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(1)
            .severity(Severity.INFORMATION)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeImpact,
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.WARNING)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableTaxonomyChangeImpact,
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableTaxonomyChangeImpact.equals(Object)",
    "int ImmutableTaxonomyChangeImpact.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build(),
        "Different type to ImmutableTaxonomyChangeImpact");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableTaxonomyChangeImpact#toString()}
   *   <li>{@link ImmutableTaxonomyChangeImpact#description()}
   *   <li>{@link ImmutableTaxonomyChangeImpact#impactCount()}
   *   <li>{@link ImmutableTaxonomyChangeImpact#severity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableTaxonomyChangeImpact.description()",
    "int ImmutableTaxonomyChangeImpact.impactCount()",
    "Severity ImmutableTaxonomyChangeImpact.severity()",
    "String ImmutableTaxonomyChangeImpact.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    String actualToStringResult = immutableTaxonomyChangeImpact.toString();
    String actualDescriptionResult = immutableTaxonomyChangeImpact.description();
    int actualImpactCountResult = immutableTaxonomyChangeImpact.impactCount();

    // Assert
    assertEquals(
        "TaxonomyChangeImpact{severity=INFORMATION, description=The characteristics of someone or something,"
            + " impactCount=3}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(3, actualImpactCountResult);
    assertEquals(Severity.INFORMATION, immutableTaxonomyChangeImpact.severity());
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
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setSeverity(Severity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDescription(String)",
    "void Json.setSeverity(Severity)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setSeverity(Severity.INFORMATION);

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(0, actualJson.impactCount);
    assertEquals(Severity.INFORMATION, actualJson.severity);
    assertFalse(actualJson.impactCountIsSet);
  }

  /**
   * Test Json {@link Json#impactCount()}.
   *
   * <p>Method under test: {@link Json#impactCount()}
   */
  @Test
  @DisplayName("Test Json impactCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.impactCount()"})
  void testJsonImpactCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().impactCount());
  }

  /**
   * Test Json {@link Json#setImpactCount(int)}.
   *
   * <p>Method under test: {@link Json#setImpactCount(int)}
   */
  @Test
  @DisplayName("Test Json setImpactCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setImpactCount(int)"})
  void testJsonSetImpactCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setImpactCount(3);

    // Assert
    assertEquals(3, json.impactCount);
    assertTrue(json.impactCountIsSet);
  }

  /**
   * Test Json {@link Json#severity()}.
   *
   * <p>Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Severity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().severity());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("42")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    ImmutableTaxonomyChangeImpact actualWithDescriptionResult =
        immutableTaxonomyChangeImpact.withDescription("42");

    // Assert
    assertSame(immutableTaxonomyChangeImpact, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableTaxonomyChangeImpact actualWithDescriptionResult =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals(3, actualWithDescriptionResult.impactCount());
    assertEquals(Severity.INFORMATION, actualWithDescriptionResult.severity());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#withImpactCount(int)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#withImpactCount(int)}
   */
  @Test
  @DisplayName("Test withImpactCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.withImpactCount(int)"
  })
  void testWithImpactCount() {
    // Arrange and Act
    ImmutableTaxonomyChangeImpact actualWithImpactCountResult =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build()
            .withImpactCount(42);

    // Assert
    assertEquals(
        "The characteristics of someone or something", actualWithImpactCountResult.description());
    assertEquals(42, actualWithImpactCountResult.impactCount());
    assertEquals(Severity.INFORMATION, actualWithImpactCountResult.severity());
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#withImpactCount(int)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#withImpactCount(int)}
   */
  @Test
  @DisplayName("Test withImpactCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.withImpactCount(int)"
  })
  void testWithImpactCount2() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(42)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    ImmutableTaxonomyChangeImpact actualWithImpactCountResult =
        immutableTaxonomyChangeImpact.withImpactCount(42);

    // Assert
    assertSame(immutableTaxonomyChangeImpact, actualWithImpactCountResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#withSeverity(Severity)}.
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#withSeverity(Severity)}
   */
  @Test
  @DisplayName("Test withSeverity(Severity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.withSeverity(Severity)"
  })
  void testWithSeverity() {
    // Arrange
    ImmutableTaxonomyChangeImpact immutableTaxonomyChangeImpact =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.INFORMATION)
            .build();

    // Act
    ImmutableTaxonomyChangeImpact actualWithSeverityResult =
        immutableTaxonomyChangeImpact.withSeverity(Severity.INFORMATION);

    // Assert
    assertSame(immutableTaxonomyChangeImpact, actualWithSeverityResult);
  }

  /**
   * Test {@link ImmutableTaxonomyChangeImpact#withSeverity(Severity)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableTaxonomyChangeImpact#withSeverity(Severity)}
   */
  @Test
  @DisplayName(
      "Test withSeverity(Severity); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableTaxonomyChangeImpact ImmutableTaxonomyChangeImpact.withSeverity(Severity)"
  })
  void testWithSeverity_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange and Act
    ImmutableTaxonomyChangeImpact actualWithSeverityResult =
        ImmutableTaxonomyChangeImpact.builder()
            .description("The characteristics of someone or something")
            .impactCount(3)
            .severity(Severity.WARNING)
            .build()
            .withSeverity(Severity.INFORMATION);

    // Assert
    assertEquals(
        "The characteristics of someone or something", actualWithSeverityResult.description());
    assertEquals(3, actualWithSeverityResult.impactCount());
    assertEquals(Severity.INFORMATION, actualWithSeverityResult.severity());
  }
}
