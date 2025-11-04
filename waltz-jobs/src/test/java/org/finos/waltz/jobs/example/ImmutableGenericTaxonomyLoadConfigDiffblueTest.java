package org.finos.waltz.jobs.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ImmutableGenericTaxonomyLoadConfigDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#descriptionOffset(int)}
   */
  @Test
  void testBuilderDescriptionOffset() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.descriptionOffset(1));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#descriptionOffset(Optional)}
   */
  @Test
  void testBuilderDescriptionOffset2() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    Optional<Integer> descriptionOffset = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(builderResult, builderResult.descriptionOffset(descriptionOffset));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    GenericTaxonomyLoadConfig instance = mock(GenericTaxonomyLoadConfig.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.taxonomyDescription()).thenReturn("Taxonomy Description");
    when(instance.maxLevels()).thenReturn(3);
    when(instance.taxonomyName()).thenReturn("Taxonomy Name");
    Optional<Integer> ofResult = Optional.<Integer>of(1);
    when(instance.descriptionOffset()).thenReturn(ofResult);
    when(instance.resourcePath()).thenReturn("Resource Path");

    // Act
    ImmutableGenericTaxonomyLoadConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).descriptionOffset();
    verify(instance).maxLevels();
    verify(instance).ratingSchemeId();
    verify(instance).resourcePath();
    verify(instance).taxonomyDescription();
    verify(instance).taxonomyExternalId();
    verify(instance).taxonomyName();
    ImmutableGenericTaxonomyLoadConfig buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Resource Path", buildResult.resourcePath());
    assertEquals("Taxonomy Description", buildResult.taxonomyDescription());
    assertEquals("Taxonomy Name", buildResult.taxonomyName());
    assertEquals(1L, buildResult.ratingSchemeId().longValue());
    assertEquals(3, buildResult.maxLevels().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    GenericTaxonomyLoadConfig instance = mock(GenericTaxonomyLoadConfig.class);
    when(instance.ratingSchemeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.taxonomyDescription()).thenReturn("Taxonomy Description");
    when(instance.maxLevels()).thenReturn(3);
    when(instance.taxonomyName()).thenReturn("Taxonomy Name");
    Optional<Integer> ofResult = Optional.<Integer>of(1);
    when(instance.descriptionOffset()).thenReturn(ofResult);
    when(instance.resourcePath()).thenReturn("Resource Path");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).descriptionOffset();
    verify(instance).maxLevels();
    verify(instance).ratingSchemeId();
    verify(instance).resourcePath();
    verify(instance).taxonomyDescription();
    verify(instance).taxonomyExternalId();
    verify(instance).taxonomyName();
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    GenericTaxonomyLoadConfig instance = mock(GenericTaxonomyLoadConfig.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.taxonomyDescription()).thenReturn("Taxonomy Description");
    when(instance.maxLevels()).thenReturn(3);
    when(instance.taxonomyName()).thenReturn("Taxonomy Name");
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.descriptionOffset()).thenReturn(emptyResult);
    when(instance.resourcePath()).thenReturn("Resource Path");

    // Act
    ImmutableGenericTaxonomyLoadConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).descriptionOffset();
    verify(instance).maxLevels();
    verify(instance).ratingSchemeId();
    verify(instance).resourcePath();
    verify(instance).taxonomyDescription();
    verify(instance).taxonomyExternalId();
    verify(instance).taxonomyName();
    ImmutableGenericTaxonomyLoadConfig buildResult = builderResult.build();
    assertEquals("42", buildResult.taxonomyExternalId());
    assertEquals("Resource Path", buildResult.resourcePath());
    assertEquals("Taxonomy Description", buildResult.taxonomyDescription());
    assertEquals("Taxonomy Name", buildResult.taxonomyName());
    assertEquals(1L, buildResult.ratingSchemeId().longValue());
    assertEquals(3, buildResult.maxLevels().intValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#maxLevels(Integer)}
   */
  @Test
  void testBuilderMaxLevels() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.maxLevels(3));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#ratingSchemeId(Long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#resourcePath(String)}
   */
  @Test
  void testBuilderResourcePath() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.resourcePath("Resource Path"));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#taxonomyDescription(String)}
   */
  @Test
  void testBuilderTaxonomyDescription() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyDescription("Taxonomy Description"));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#taxonomyExternalId(String)}
   */
  @Test
  void testBuilderTaxonomyExternalId() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig.Builder#taxonomyName(String)}
   */
  @Test
  void testBuilderTaxonomyName() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig.Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyName("Taxonomy Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig#copyOf(GenericTaxonomyLoadConfig)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    GenericTaxonomyLoadConfig instance = mock(GenericTaxonomyLoadConfig.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.taxonomyDescription()).thenReturn("Taxonomy Description");
    when(instance.maxLevels()).thenReturn(3);
    when(instance.taxonomyName()).thenReturn("Taxonomy Name");
    Optional<Integer> ofResult = Optional.<Integer>of(1);
    when(instance.descriptionOffset()).thenReturn(ofResult);
    when(instance.resourcePath()).thenReturn("Resource Path");

    // Act
    ImmutableGenericTaxonomyLoadConfig actualCopyOfResult = ImmutableGenericTaxonomyLoadConfig.copyOf(instance);

    // Assert
    verify(instance).descriptionOffset();
    verify(instance).maxLevels();
    verify(instance).ratingSchemeId();
    verify(instance).resourcePath();
    verify(instance).taxonomyDescription();
    verify(instance).taxonomyExternalId();
    verify(instance).taxonomyName();
    assertEquals("42", actualCopyOfResult.taxonomyExternalId());
    assertEquals("Resource Path", actualCopyOfResult.resourcePath());
    assertEquals("Taxonomy Description", actualCopyOfResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualCopyOfResult.taxonomyName());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId().longValue());
    assertEquals(3, actualCopyOfResult.maxLevels().intValue());
  }

  /**
   * Method under test:
   * {@link ImmutableGenericTaxonomyLoadConfig#copyOf(GenericTaxonomyLoadConfig)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    GenericTaxonomyLoadConfig instance = mock(GenericTaxonomyLoadConfig.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.taxonomyExternalId()).thenReturn("42");
    when(instance.taxonomyDescription()).thenReturn("Taxonomy Description");
    when(instance.maxLevels()).thenReturn(3);
    when(instance.taxonomyName()).thenReturn("Taxonomy Name");
    Optional<Integer> emptyResult = Optional.empty();
    when(instance.descriptionOffset()).thenReturn(emptyResult);
    when(instance.resourcePath()).thenReturn("Resource Path");

    // Act
    ImmutableGenericTaxonomyLoadConfig actualCopyOfResult = ImmutableGenericTaxonomyLoadConfig.copyOf(instance);

    // Assert
    verify(instance).descriptionOffset();
    verify(instance).maxLevels();
    verify(instance).ratingSchemeId();
    verify(instance).resourcePath();
    verify(instance).taxonomyDescription();
    verify(instance).taxonomyExternalId();
    verify(instance).taxonomyName();
    assertEquals("42", actualCopyOfResult.taxonomyExternalId());
    assertEquals("Resource Path", actualCopyOfResult.resourcePath());
    assertEquals("Taxonomy Description", actualCopyOfResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualCopyOfResult.taxonomyName());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId().longValue());
    assertEquals(3, actualCopyOfResult.maxLevels().intValue());
  }
}
