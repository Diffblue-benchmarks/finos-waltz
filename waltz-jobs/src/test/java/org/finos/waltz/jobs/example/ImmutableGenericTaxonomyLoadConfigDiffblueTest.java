package org.finos.waltz.jobs.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.jobs.example.ImmutableGenericTaxonomyLoadConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableGenericTaxonomyLoadConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableGenericTaxonomyLoadConfig Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionOffsetResult =
        ImmutableGenericTaxonomyLoadConfig.builder().descriptionOffset(1);
    Optional<Integer> descriptionOffset = Optional.of(42);
    ImmutableGenericTaxonomyLoadConfig actualImmutableGenericTaxonomyLoadConfig =
        actualDescriptionOffsetResult
            .descriptionOffset(descriptionOffset)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Assert
    assertEquals("42", actualImmutableGenericTaxonomyLoadConfig.taxonomyExternalId());
    assertEquals("Resource Path", actualImmutableGenericTaxonomyLoadConfig.resourcePath());
    assertEquals(
        "Taxonomy Description", actualImmutableGenericTaxonomyLoadConfig.taxonomyDescription());
    assertEquals("Taxonomy Name", actualImmutableGenericTaxonomyLoadConfig.taxonomyName());
    assertEquals(1L, actualImmutableGenericTaxonomyLoadConfig.ratingSchemeId().longValue());
    assertEquals(3, actualImmutableGenericTaxonomyLoadConfig.maxLevels().intValue());
  }

  /**
   * Test Builder {@link Builder#descriptionOffset(int)} with {@code int}.
   *
   * <p>Method under test: {@link Builder#descriptionOffset(int)}
   */
  @Test
  @DisplayName("Test Builder descriptionOffset(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.descriptionOffset(int)"})
  void testBuilderDescriptionOffsetWithInt() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualDescriptionOffsetResult = builderResult.descriptionOffset(1);

    // Assert
    assertSame(builderResult, actualDescriptionOffsetResult);
  }

  /**
   * Test Builder {@link Builder#descriptionOffset(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#descriptionOffset(Optional)}
   */
  @Test
  @DisplayName("Test Builder descriptionOffset(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.descriptionOffset(Optional)"})
  void testBuilderDescriptionOffsetWithOptional() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    Optional<Integer> descriptionOffset = Optional.of(42);

    // Act
    Builder actualDescriptionOffsetResult = builderResult.descriptionOffset(descriptionOffset);

    // Assert
    assertSame(builderResult, actualDescriptionOffsetResult);
  }

  /**
   * Test Builder {@link Builder#from(GenericTaxonomyLoadConfig)}.
   *
   * <p>Method under test: {@link Builder#from(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName("Test Builder from(GenericTaxonomyLoadConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(GenericTaxonomyLoadConfig)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();
    ImmutableGenericTaxonomyLoadConfig instance =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableGenericTaxonomyLoadConfig actualImmutableGenericTaxonomyLoadConfig =
        builderResult.build();
    assertEquals(instance, actualImmutableGenericTaxonomyLoadConfig);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#maxLevels(Integer)}.
   *
   * <p>Method under test: {@link Builder#maxLevels(Integer)}
   */
  @Test
  @DisplayName("Test Builder maxLevels(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.maxLevels(Integer)"})
  void testBuilderMaxLevels() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualMaxLevelsResult = builderResult.maxLevels(3);

    // Assert
    assertSame(builderResult, actualMaxLevelsResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(Long)}.
   *
   * <p>Method under test: {@link Builder#ratingSchemeId(Long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(Long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualRatingSchemeIdResult = builderResult.ratingSchemeId(1L);

    // Assert
    assertSame(builderResult, actualRatingSchemeIdResult);
  }

  /**
   * Test Builder {@link Builder#resourcePath(String)}.
   *
   * <ul>
   *   <li>When {@code Resource Path}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#resourcePath(String)}
   */
  @Test
  @DisplayName("Test Builder resourcePath(String); when 'Resource Path'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resourcePath(String)"})
  void testBuilderResourcePath_whenResourcePath_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualResourcePathResult = builderResult.resourcePath("Resource Path");

    // Assert
    assertSame(builderResult, actualResourcePathResult);
  }

  /**
   * Test Builder {@link Builder#taxonomyDescription(String)}.
   *
   * <ul>
   *   <li>When {@code Taxonomy Description}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#taxonomyDescription(String)}
   */
  @Test
  @DisplayName(
      "Test Builder taxonomyDescription(String); when 'Taxonomy Description'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.taxonomyDescription(String)"})
  void testBuilderTaxonomyDescription_whenTaxonomyDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualTaxonomyDescriptionResult =
        builderResult.taxonomyDescription("Taxonomy Description");

    // Assert
    assertSame(builderResult, actualTaxonomyDescriptionResult);
  }

  /**
   * Test Builder {@link Builder#taxonomyExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#taxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.taxonomyExternalId(String)"})
  void testBuilderTaxonomyExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualTaxonomyExternalIdResult = builderResult.taxonomyExternalId("42");

    // Assert
    assertSame(builderResult, actualTaxonomyExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#taxonomyName(String)}.
   *
   * <ul>
   *   <li>When {@code Taxonomy Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#taxonomyName(String)}
   */
  @Test
  @DisplayName("Test Builder taxonomyName(String); when 'Taxonomy Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.taxonomyName(String)"})
  void testBuilderTaxonomyName_whenTaxonomyName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableGenericTaxonomyLoadConfig.builder();

    // Act
    Builder actualTaxonomyNameResult = builderResult.taxonomyName("Taxonomy Name");

    // Assert
    assertSame(builderResult, actualTaxonomyNameResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#copyOf(GenericTaxonomyLoadConfig)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableGenericTaxonomyLoadConfig#copyOf(GenericTaxonomyLoadConfig)}
   */
  @Test
  @DisplayName("Test copyOf(GenericTaxonomyLoadConfig); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.copyOf(GenericTaxonomyLoadConfig)"
  })
  void testCopyOf_thenReturnTaxonomyExternalIdIs42() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig instance =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualCopyOfResult =
        ImmutableGenericTaxonomyLoadConfig.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.taxonomyExternalId());
    assertEquals("Resource Path", actualCopyOfResult.resourcePath());
    assertEquals("Taxonomy Description", actualCopyOfResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualCopyOfResult.taxonomyName());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId().longValue());
    assertEquals(3, actualCopyOfResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#descriptionOffset()}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#descriptionOffset()}
   */
  @Test
  @DisplayName("Test descriptionOffset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableGenericTaxonomyLoadConfig.descriptionOffset()"})
  void testDescriptionOffset() {
    // Arrange and Act
    Optional<Integer> actualDescriptionOffsetResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .descriptionOffset();

    // Assert
    assertEquals(1, actualDescriptionOffsetResult.get().intValue());
    assertTrue(actualDescriptionOffsetResult.isPresent());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}, and {@link
   * ImmutableGenericTaxonomyLoadConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig2 =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertEquals(immutableGenericTaxonomyLoadConfig, immutableGenericTaxonomyLoadConfig2);
    assertEquals(
        immutableGenericTaxonomyLoadConfig.hashCode(),
        immutableGenericTaxonomyLoadConfig2.hashCode());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}, and {@link
   * ImmutableGenericTaxonomyLoadConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertEquals(immutableGenericTaxonomyLoadConfig, immutableGenericTaxonomyLoadConfig);
    int expectedHashCodeResult = immutableGenericTaxonomyLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, immutableGenericTaxonomyLoadConfig.hashCode());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(0)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(1)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(2L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Taxonomy Name")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Resource Path")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("Resource Path")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Resource Path")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableGenericTaxonomyLoadConfig,
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableGenericTaxonomyLoadConfig.equals(Object)",
    "int ImmutableGenericTaxonomyLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build(),
        "Different type to ImmutableGenericTaxonomyLoadConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#toString()}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#maxLevels()}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#ratingSchemeId()}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#resourcePath()}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#taxonomyDescription()}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#taxonomyExternalId()}
   *   <li>{@link ImmutableGenericTaxonomyLoadConfig#taxonomyName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableGenericTaxonomyLoadConfig.maxLevels()",
    "Long ImmutableGenericTaxonomyLoadConfig.ratingSchemeId()",
    "String ImmutableGenericTaxonomyLoadConfig.resourcePath()",
    "String ImmutableGenericTaxonomyLoadConfig.taxonomyDescription()",
    "String ImmutableGenericTaxonomyLoadConfig.taxonomyExternalId()",
    "String ImmutableGenericTaxonomyLoadConfig.taxonomyName()",
    "String ImmutableGenericTaxonomyLoadConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    String actualToStringResult = immutableGenericTaxonomyLoadConfig.toString();
    Integer actualMaxLevelsResult = immutableGenericTaxonomyLoadConfig.maxLevels();
    Long actualRatingSchemeIdResult = immutableGenericTaxonomyLoadConfig.ratingSchemeId();
    String actualResourcePathResult = immutableGenericTaxonomyLoadConfig.resourcePath();
    String actualTaxonomyDescriptionResult =
        immutableGenericTaxonomyLoadConfig.taxonomyDescription();
    String actualTaxonomyExternalIdResult = immutableGenericTaxonomyLoadConfig.taxonomyExternalId();

    // Assert
    assertEquals("42", actualTaxonomyExternalIdResult);
    assertEquals(
        "GenericTaxonomyLoadConfig{resourcePath=Resource Path, maxLevels=3, descriptionOffset=1, taxonomyName=Taxonomy"
            + " Name, taxonomyDescription=Taxonomy Description, taxonomyExternalId=42, ratingSchemeId=1}",
        actualToStringResult);
    assertEquals("Resource Path", actualResourcePathResult);
    assertEquals("Taxonomy Description", actualTaxonomyDescriptionResult);
    assertEquals("Taxonomy Name", immutableGenericTaxonomyLoadConfig.taxonomyName());
    assertEquals(1L, actualRatingSchemeIdResult.longValue());
    assertEquals(3, actualMaxLevelsResult.intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link
   * ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(Optional)}
   */
  @Test
  @DisplayName("Test withDescriptionOffset(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withDescriptionOffset(Optional)"
  })
  void testWithDescriptionOffsetWithOptional() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();
    Optional<Integer> optional = Optional.of(1);

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithDescriptionOffsetResult =
        immutableGenericTaxonomyLoadConfig.withDescriptionOffset(optional);

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithDescriptionOffsetResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(Optional)} with {@code
   * optional}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(Optional)}
   */
  @Test
  @DisplayName(
      "Test withDescriptionOffset(Optional) with 'optional'; then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withDescriptionOffset(Optional)"
  })
  void testWithDescriptionOffsetWithOptional_thenReturnTaxonomyExternalIdIs42() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();
    Optional<Integer> optional = Optional.of(42);

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithDescriptionOffsetResult =
        immutableGenericTaxonomyLoadConfig.withDescriptionOffset(optional);

    // Assert
    assertEquals("42", actualWithDescriptionOffsetResult.taxonomyExternalId());
    assertEquals("Resource Path", actualWithDescriptionOffsetResult.resourcePath());
    assertEquals("Taxonomy Description", actualWithDescriptionOffsetResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualWithDescriptionOffsetResult.taxonomyName());
    assertEquals(1L, actualWithDescriptionOffsetResult.ratingSchemeId().longValue());
    assertEquals(3, actualWithDescriptionOffsetResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(int)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(int)}
   */
  @Test
  @DisplayName("Test withDescriptionOffset(int) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withDescriptionOffset(int)"
  })
  void testWithDescriptionOffsetWithValue() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithDescriptionOffsetResult =
        immutableGenericTaxonomyLoadConfig.withDescriptionOffset(1);

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithDescriptionOffsetResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(int)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withDescriptionOffset(int)}
   */
  @Test
  @DisplayName(
      "Test withDescriptionOffset(int) with 'value'; when forty-two; then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withDescriptionOffset(int)"
  })
  void testWithDescriptionOffsetWithValue_whenFortyTwo_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithDescriptionOffsetResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .withDescriptionOffset(42);

    // Assert
    assertEquals("42", actualWithDescriptionOffsetResult.taxonomyExternalId());
    assertEquals("Resource Path", actualWithDescriptionOffsetResult.resourcePath());
    assertEquals("Taxonomy Description", actualWithDescriptionOffsetResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualWithDescriptionOffsetResult.taxonomyName());
    assertEquals(1L, actualWithDescriptionOffsetResult.ratingSchemeId().longValue());
    assertEquals(3, actualWithDescriptionOffsetResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withMaxLevels(Integer)}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withMaxLevels(Integer)}
   */
  @Test
  @DisplayName("Test withMaxLevels(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withMaxLevels(Integer)"
  })
  void testWithMaxLevels() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(1)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithMaxLevelsResult =
        immutableGenericTaxonomyLoadConfig.withMaxLevels(1);

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithMaxLevelsResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withMaxLevels(Integer)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withMaxLevels(Integer)}
   */
  @Test
  @DisplayName("Test withMaxLevels(Integer); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withMaxLevels(Integer)"
  })
  void testWithMaxLevels_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithMaxLevelsResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .withMaxLevels(42);

    // Assert
    assertEquals("42", actualWithMaxLevelsResult.taxonomyExternalId());
    assertEquals("Resource Path", actualWithMaxLevelsResult.resourcePath());
    assertEquals("Taxonomy Description", actualWithMaxLevelsResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualWithMaxLevelsResult.taxonomyName());
    assertEquals(1L, actualWithMaxLevelsResult.ratingSchemeId().longValue());
    assertEquals(42, actualWithMaxLevelsResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withRatingSchemeId(Long)}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withRatingSchemeId(Long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withRatingSchemeId(Long)"
  })
  void testWithRatingSchemeId() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithRatingSchemeIdResult =
        immutableGenericTaxonomyLoadConfig.withRatingSchemeId(1L);

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithRatingSchemeIdResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withRatingSchemeId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withRatingSchemeId(Long)}
   */
  @Test
  @DisplayName(
      "Test withRatingSchemeId(Long); when forty-two; then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withRatingSchemeId(Long)"
  })
  void testWithRatingSchemeId_whenFortyTwo_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithRatingSchemeIdResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .withRatingSchemeId(42L);

    // Assert
    assertEquals("42", actualWithRatingSchemeIdResult.taxonomyExternalId());
    assertEquals("Resource Path", actualWithRatingSchemeIdResult.resourcePath());
    assertEquals("Taxonomy Description", actualWithRatingSchemeIdResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualWithRatingSchemeIdResult.taxonomyName());
    assertEquals(3, actualWithRatingSchemeIdResult.maxLevels().intValue());
    assertEquals(42L, actualWithRatingSchemeIdResult.ratingSchemeId().longValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withResourcePath(String)}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withResourcePath(String)}
   */
  @Test
  @DisplayName("Test withResourcePath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withResourcePath(String)"
  })
  void testWithResourcePath() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("42")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithResourcePathResult =
        immutableGenericTaxonomyLoadConfig.withResourcePath("42");

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithResourcePathResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withResourcePath(String)}.
   *
   * <ul>
   *   <li>Then return resourcePath is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withResourcePath(String)}
   */
  @Test
  @DisplayName("Test withResourcePath(String); then return resourcePath is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withResourcePath(String)"
  })
  void testWithResourcePath_thenReturnResourcePathIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithResourcePathResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .withResourcePath("42");

    // Assert
    assertEquals("42", actualWithResourcePathResult.resourcePath());
    assertEquals("42", actualWithResourcePathResult.taxonomyExternalId());
    assertEquals("Taxonomy Description", actualWithResourcePathResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualWithResourcePathResult.taxonomyName());
    assertEquals(1L, actualWithResourcePathResult.ratingSchemeId().longValue());
    assertEquals(3, actualWithResourcePathResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableGenericTaxonomyLoadConfig#withTaxonomyDescription(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withTaxonomyDescription(String)"
  })
  void testWithTaxonomyDescription() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("42")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithTaxonomyDescriptionResult =
        immutableGenericTaxonomyLoadConfig.withTaxonomyDescription("42");

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithTaxonomyDescriptionResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyDescription(String)}.
   *
   * <ul>
   *   <li>Then return taxonomyDescription is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableGenericTaxonomyLoadConfig#withTaxonomyDescription(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyDescription(String); then return taxonomyDescription is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withTaxonomyDescription(String)"
  })
  void testWithTaxonomyDescription_thenReturnTaxonomyDescriptionIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithTaxonomyDescriptionResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .withTaxonomyDescription("42");

    // Assert
    assertEquals("42", actualWithTaxonomyDescriptionResult.taxonomyDescription());
    assertEquals("42", actualWithTaxonomyDescriptionResult.taxonomyExternalId());
    assertEquals("Resource Path", actualWithTaxonomyDescriptionResult.resourcePath());
    assertEquals("Taxonomy Name", actualWithTaxonomyDescriptionResult.taxonomyName());
    assertEquals(1L, actualWithTaxonomyDescriptionResult.ratingSchemeId().longValue());
    assertEquals(3, actualWithTaxonomyDescriptionResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withTaxonomyExternalId(String)"
  })
  void testWithTaxonomyExternalId() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithTaxonomyExternalIdResult =
        immutableGenericTaxonomyLoadConfig.withTaxonomyExternalId("42");

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithTaxonomyExternalIdResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyExternalId(String)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyExternalId(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyExternalId(String); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withTaxonomyExternalId(String)"
  })
  void testWithTaxonomyExternalId_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithTaxonomyExternalIdResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("taxonomyExternalId")
            .taxonomyName("Taxonomy Name")
            .build()
            .withTaxonomyExternalId("42");

    // Assert
    assertEquals("42", actualWithTaxonomyExternalIdResult.taxonomyExternalId());
    assertEquals("Resource Path", actualWithTaxonomyExternalIdResult.resourcePath());
    assertEquals("Taxonomy Description", actualWithTaxonomyExternalIdResult.taxonomyDescription());
    assertEquals("Taxonomy Name", actualWithTaxonomyExternalIdResult.taxonomyName());
    assertEquals(1L, actualWithTaxonomyExternalIdResult.ratingSchemeId().longValue());
    assertEquals(3, actualWithTaxonomyExternalIdResult.maxLevels().intValue());
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyName(String)}.
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyName(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withTaxonomyName(String)"
  })
  void testWithTaxonomyName() {
    // Arrange
    ImmutableGenericTaxonomyLoadConfig immutableGenericTaxonomyLoadConfig =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("42")
            .build();

    // Act
    ImmutableGenericTaxonomyLoadConfig actualWithTaxonomyNameResult =
        immutableGenericTaxonomyLoadConfig.withTaxonomyName("42");

    // Assert
    assertSame(immutableGenericTaxonomyLoadConfig, actualWithTaxonomyNameResult);
  }

  /**
   * Test {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyName(String)}.
   *
   * <ul>
   *   <li>Then return taxonomyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableGenericTaxonomyLoadConfig#withTaxonomyName(String)}
   */
  @Test
  @DisplayName("Test withTaxonomyName(String); then return taxonomyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableGenericTaxonomyLoadConfig ImmutableGenericTaxonomyLoadConfig.withTaxonomyName(String)"
  })
  void testWithTaxonomyName_thenReturnTaxonomyExternalIdIs42() {
    // Arrange and Act
    ImmutableGenericTaxonomyLoadConfig actualWithTaxonomyNameResult =
        ImmutableGenericTaxonomyLoadConfig.builder()
            .descriptionOffset(1)
            .maxLevels(3)
            .ratingSchemeId(1L)
            .resourcePath("Resource Path")
            .taxonomyDescription("Taxonomy Description")
            .taxonomyExternalId("42")
            .taxonomyName("Taxonomy Name")
            .build()
            .withTaxonomyName("42");

    // Assert
    assertEquals("42", actualWithTaxonomyNameResult.taxonomyExternalId());
    assertEquals("42", actualWithTaxonomyNameResult.taxonomyName());
    assertEquals("Resource Path", actualWithTaxonomyNameResult.resourcePath());
    assertEquals("Taxonomy Description", actualWithTaxonomyNameResult.taxonomyDescription());
    assertEquals(1L, actualWithTaxonomyNameResult.ratingSchemeId().longValue());
    assertEquals(3, actualWithTaxonomyNameResult.maxLevels().intValue());
  }
}
