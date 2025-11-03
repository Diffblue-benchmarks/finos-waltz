package org.finos.waltz.jobs.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.jobs.example.ImmutableGenericTaxonomyLoadConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGenericTaxonomyLoadConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#descriptionOffset(int)} with {@code int}.
   * <p>
   * Method under test: {@link Builder#descriptionOffset(int)}
   */
  @Test
  @DisplayName("Test Builder descriptionOffset(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.descriptionOffset(int)"})
  void testBuilderDescriptionOffsetWithInt() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.descriptionOffset(1));
  }

  /**
   * Test Builder {@link Builder#descriptionOffset(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#descriptionOffset(Optional)}
   */
  @Test
  @DisplayName("Test Builder descriptionOffset(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.descriptionOffset(Optional)"})
  void testBuilderDescriptionOffsetWithOptional() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    Optional<Integer> descriptionOffset = Optional.<Integer>of(1);

    // Act and Assert
    assertSame(builderResult, builderResult.descriptionOffset(descriptionOffset));
  }

  /**
   * Test Builder {@link Builder#from(GenericTaxonomyLoadConfig)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName("Test Builder from(GenericTaxonomyLoadConfig); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GenericTaxonomyLoadConfig)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(GenericTaxonomyLoadConfig)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then builder build taxonomyExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName("Test Builder from(GenericTaxonomyLoadConfig); given one; then builder build taxonomyExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GenericTaxonomyLoadConfig)"})
  void testBuilderFrom_givenOne_thenBuilderBuildTaxonomyExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(GenericTaxonomyLoadConfig)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName("Test Builder from(GenericTaxonomyLoadConfig); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(GenericTaxonomyLoadConfig)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
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
   * Test Builder {@link Builder#maxLevels(Integer)}.
   * <p>
   * Method under test: {@link Builder#maxLevels(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxLevels(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.maxLevels(Integer)"})
  void testBuilderMaxLevels() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.maxLevels(3));
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(Long)}.
   * <p>
   * Method under test: {@link Builder#ratingSchemeId(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(Long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Test Builder {@link Builder#resourcePath(String)}.
   * <p>
   * Method under test: {@link Builder#resourcePath(String)}
   */
  @Test
  @DisplayName("Test Builder resourcePath(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.resourcePath(String)"})
  void testBuilderResourcePath() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.resourcePath("Resource Path"));
  }

  /**
   * Test Builder {@link Builder#taxonomyDescription(String)}.
   * <p>
   * Method under test: {@link Builder#taxonomyDescription(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyDescription(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.taxonomyDescription(String)"})
  void testBuilderTaxonomyDescription() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyDescription("Taxonomy Description"));
  }

  /**
   * Test Builder {@link Builder#taxonomyExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#taxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.taxonomyExternalId(String)"})
  void testBuilderTaxonomyExternalId() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#taxonomyName(String)}.
   * <p>
   * Method under test: {@link Builder#taxonomyName(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.taxonomyName(String)"})
  void testBuilderTaxonomyName() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.taxonomyName("Taxonomy Name"));
  }
}
