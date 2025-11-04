package org.finos.waltz.model.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.Severity;
import org.junit.jupiter.api.Test;

class ImmutableTaxonomyChangeImpactDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#description(String)}
   */
  @Test
  void testBuilderDescription() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableTaxonomyChangeImpact.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#from(TaxonomyChangeImpact)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    TaxonomyChangeImpact instance = mock(TaxonomyChangeImpact.class);
    when(instance.impactCount()).thenReturn(3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.severity()).thenReturn(Severity.INFORMATION);

    // Act
    ImmutableTaxonomyChangeImpact.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#from(TaxonomyChangeImpact)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();
    TaxonomyChangeImpact instance = mock(TaxonomyChangeImpact.class);
    when(instance.impactCount()).thenThrow(new IllegalStateException("instance"));
    when(instance.severity()).thenReturn(Severity.INFORMATION);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).impactCount();
    verify(instance).severity();
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#impactCount(int)}
   */
  @Test
  void testBuilderImpactCount() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.impactCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Builder#severity(Severity)}
   */
  @Test
  void testBuilderSeverity() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Builder builderResult = ImmutableTaxonomyChangeImpact.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.severity(Severity.INFORMATION));
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact#copyOf(TaxonomyChangeImpact)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TaxonomyChangeImpact instance = mock(TaxonomyChangeImpact.class);
    when(instance.impactCount()).thenReturn(3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.severity()).thenReturn(Severity.INFORMATION);

    // Act
    ImmutableTaxonomyChangeImpact actualCopyOfResult = ImmutableTaxonomyChangeImpact.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).impactCount();
    verify(instance).severity();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(3, actualCopyOfResult.impactCount());
    assertEquals(Severity.INFORMATION, actualCopyOfResult.severity());
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeImpact.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeImpact.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableTaxonomyChangeImpact.Json}
   *   <li>{@link ImmutableTaxonomyChangeImpact.Json#setDescription(String)}
   *   <li>{@link ImmutableTaxonomyChangeImpact.Json#setSeverity(Severity)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableTaxonomyChangeImpact.Json actualJson = new ImmutableTaxonomyChangeImpact.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setSeverity(Severity.INFORMATION);

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(0, actualJson.impactCount);
    assertEquals(Severity.INFORMATION, actualJson.severity);
    assertFalse(actualJson.impactCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeImpact.Json#impactCount()}
   */
  @Test
  void testJsonImpactCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeImpact.Json()).impactCount());
  }

  /**
   * Method under test:
   * {@link ImmutableTaxonomyChangeImpact.Json#setImpactCount(int)}
   */
  @Test
  void testJsonSetImpactCount() {
    // Arrange
    ImmutableTaxonomyChangeImpact.Json json = new ImmutableTaxonomyChangeImpact.Json();

    // Act
    json.setImpactCount(3);

    // Assert
    assertEquals(3, json.impactCount);
    assertTrue(json.impactCountIsSet);
  }

  /**
   * Method under test: {@link ImmutableTaxonomyChangeImpact.Json#severity()}
   */
  @Test
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableTaxonomyChangeImpact.Json()).severity());
  }
}
