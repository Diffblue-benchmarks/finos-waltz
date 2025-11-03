package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenReturnBuilder() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeImpact)} with {@code TaxonomyChangeImpact}.
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeImpact)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeImpact) with 'TaxonomyChangeImpact'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeImpact)"})
  void testBuilderFromWithTaxonomyChangeImpact() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    TaxonomyChangeImpact instance = mock(TaxonomyChangeImpact.class);
    when(instance.impactCount()).thenReturn(3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.severity()).thenReturn(Severity.INFORMATION);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).impactCount();
    verify(instance).severity();
    ImmutableTaxonomyChangeImpact buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(3, buildResult.impactCount());
    assertEquals(Severity.INFORMATION, buildResult.severity());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(TaxonomyChangeImpact)} with {@code TaxonomyChangeImpact}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TaxonomyChangeImpact)}
   */
  @Test
  @DisplayName("Test Builder from(TaxonomyChangeImpact) with 'TaxonomyChangeImpact'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TaxonomyChangeImpact)"})
  void testBuilderFromWithTaxonomyChangeImpact_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    TaxonomyChangeImpact instance = mock(TaxonomyChangeImpact.class);
    when(instance.impactCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.severity()).thenReturn(Severity.INFORMATION);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).impactCount();
    verify(instance).severity();
  }

  /**
   * Test Builder {@link Builder#impactCount(int)}.
   * <p>
   * Method under test: {@link Builder#impactCount(int)}
   */
  @Test
  @DisplayName("Test Builder impactCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.impactCount(int)"})
  void testBuilderImpactCount() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.impactCount(3));
  }

  /**
   * Test Builder {@link Builder#severity(Severity)}.
   * <p>
   * Method under test: {@link Builder#severity(Severity)}
   */
  @Test
  @DisplayName("Test Builder severity(Severity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.severity(Severity)"})
  void testBuilderSeverity() {
    // Arrange
    Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.severity(Severity.INFORMATION));
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setSeverity(Severity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setDescription(String)", "void Json.setSeverity(Severity)"})
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
   * <p>
   * Method under test: {@link Json#impactCount()}
   */
  @Test
  @DisplayName("Test Json impactCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.impactCount()"})
  void testJsonImpactCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).impactCount());
  }

  /**
   * Test Json {@link Json#setImpactCount(int)}.
   * <p>
   * Method under test: {@link Json#setImpactCount(int)}
   */
  @Test
  @DisplayName("Test Json setImpactCount(int)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Severity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).severity());
  }
}
