package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.jobs.tools.survey.config.ImmutableSurveyDupeConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyDupeConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSections(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllSections(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSections(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSections(Iterable)"})
  void testBuilderAddAllSections() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());

    // Act
    Builder actualAddAllSectionsResult = builderResult.addAllSections(elements);

    // Assert
    assertSame(builderResult, actualAddAllSectionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllSections(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllSections(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSections(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSections(Iterable)"})
  void testBuilderAddAllSections2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult2.targets(new ArrayList<>()).build());

    // Act
    Builder actualAddAllSectionsResult = builderResult.addAllSections(elements);

    // Assert
    assertSame(builderResult, actualAddAllSectionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllSections(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllSections(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSections(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSections(Iterable)"})
  void testBuilderAddAllSections_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    Builder actualAddAllSectionsResult = builderResult.addAllSections(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllSectionsResult);
  }

  /**
   * Test Builder {@link Builder#addSections(SectionDupeConfig)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSections(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder addSections(SectionDupeConfig) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSections(SectionDupeConfig)"})
  void testBuilderAddSectionsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act
    Builder actualAddSectionsResult =
        builderResult.addSections(sectionNameResult.targets(new ArrayList<>()).build());

    // Assert
    assertSame(builderResult, actualAddSectionsResult);
  }

  /**
   * Test Builder {@link Builder#addSections(SectionDupeConfig[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSections(SectionDupeConfig[])}
   */
  @Test
  @DisplayName("Test Builder addSections(SectionDupeConfig[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSections(SectionDupeConfig[])"})
  void testBuilderAddSectionsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act
    Builder actualAddSectionsResult =
        builderResult.addSections(sectionNameResult.targets(new ArrayList<>()).build());

    // Assert
    assertSame(builderResult, actualAddSectionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig actualImmutableSurveyDupeConfig =
        actualBuilderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Assert
    assertEquals("42", actualImmutableSurveyDupeConfig.sourceSurveyExternalId());
    assertEquals("42", actualImmutableSurveyDupeConfig.targetSurveyExternalId());
    assertEquals("Doe", actualImmutableSurveyDupeConfig.targetSurveyName());
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDupeConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    Builder builderResult2 = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig instance =
        builderResult2
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act and Assert
    ImmutableSurveyDupeConfig actualImmutableSurveyDupeConfig =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSurveyDupeConfig);
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   *
   * <p>Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDupeConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());
    ImmutableSurveyDupeConfig instance =
        ImmutableSurveyDupeConfig.builder()
            .sections(elements)
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyDupeConfig actualImmutableSurveyDupeConfig = builderResult.build();
    assertEquals(instance, actualImmutableSurveyDupeConfig);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   *
   * <ul>
   *   <li>Given builder sectionName {@code String} targets {@link ArrayList#ArrayList()} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyDupeConfig); given builder sectionName 'java.lang.String' targets ArrayList() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom_givenBuilderSectionNameJavaLangStringTargetsArrayListBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("java.lang.String");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult2.targets(new ArrayList<>()).build());
    ImmutableSurveyDupeConfig instance =
        ImmutableSurveyDupeConfig.builder()
            .sections(elements)
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyDupeConfig actualImmutableSurveyDupeConfig = builderResult.build();
    assertEquals(instance, actualImmutableSurveyDupeConfig);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#sections(Iterable)}.
   *
   * <ul>
   *   <li>Given builder sectionName {@code Section Name} targets {@link ArrayList#ArrayList()}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sections(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder sections(Iterable); given builder sectionName 'Section Name' targets ArrayList() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sections(Iterable)"})
  void testBuilderSections_givenBuilderSectionNameSectionNameTargetsArrayListBuild() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());

    // Act
    Builder actualSectionsResult = builderResult.sections(elements);

    // Assert
    assertSame(builderResult, actualSectionsResult);
  }

  /**
   * Test Builder {@link Builder#sections(Iterable)}.
   *
   * <ul>
   *   <li>Given builder sectionName {@code Section Name} targets {@link ArrayList#ArrayList()}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sections(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder sections(Iterable); given builder sectionName 'Section Name' targets ArrayList() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sections(Iterable)"})
  void testBuilderSections_givenBuilderSectionNameSectionNameTargetsArrayListBuild2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult2.targets(new ArrayList<>()).build());

    // Act
    Builder actualSectionsResult = builderResult.sections(elements);

    // Assert
    assertSame(builderResult, actualSectionsResult);
  }

  /**
   * Test Builder {@link Builder#sections(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sections(Iterable)}
   */
  @Test
  @DisplayName("Test Builder sections(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sections(Iterable)"})
  void testBuilderSections_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    Builder actualSectionsResult = builderResult.sections(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualSectionsResult);
  }

  /**
   * Test Builder {@link Builder#sourceSurveyExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder sourceSurveyExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceSurveyExternalId(String)"})
  void testBuilderSourceSurveyExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    Builder actualSourceSurveyExternalIdResult = builderResult.sourceSurveyExternalId("42");

    // Assert
    assertSame(builderResult, actualSourceSurveyExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#targetSurveyExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder targetSurveyExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetSurveyExternalId(String)"})
  void testBuilderTargetSurveyExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    Builder actualTargetSurveyExternalIdResult = builderResult.targetSurveyExternalId("42");

    // Assert
    assertSame(builderResult, actualTargetSurveyExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#targetSurveyName(String)}.
   *
   * <ul>
   *   <li>When {@code Doe}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetSurveyName(String)}
   */
  @Test
  @DisplayName("Test Builder targetSurveyName(String); when 'Doe'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetSurveyName(String)"})
  void testBuilderTargetSurveyName_whenDoe_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    Builder actualTargetSurveyNameResult = builderResult.targetSurveyName("Doe");

    // Assert
    assertSame(builderResult, actualTargetSurveyNameResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}.
   *
   * <ul>
   *   <li>Then return sourceSurveyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test copyOf(SurveyDupeConfig); then return sourceSurveyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.copyOf(SurveyDupeConfig)"
  })
  void testCopyOf_thenReturnSourceSurveyExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig instance =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    ImmutableSurveyDupeConfig actualCopyOfResult = ImmutableSurveyDupeConfig.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.sourceSurveyExternalId());
    assertEquals("42", actualCopyOfResult.targetSurveyExternalId());
    assertEquals("Doe", actualCopyOfResult.targetSurveyName());
    assertTrue(actualCopyOfResult.sections().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}, and {@link
   * ImmutableSurveyDupeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyDupeConfig#equals(Object)}
   *   <li>{@link ImmutableSurveyDupeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    Builder builderResult2 = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig2 =
        builderResult2
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyDupeConfig, immutableSurveyDupeConfig2);
    assertEquals(immutableSurveyDupeConfig.hashCode(), immutableSurveyDupeConfig2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}, and {@link
   * ImmutableSurveyDupeConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyDupeConfig#equals(Object)}
   *   <li>{@link ImmutableSurveyDupeConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act and Assert
    assertEquals(immutableSurveyDupeConfig, immutableSurveyDupeConfig);
    int expectedHashCodeResult = immutableSurveyDupeConfig.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyDupeConfig.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<SectionDupeConfig> elements = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    elements.add(sectionNameResult.targets(new ArrayList<>()).build());
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        ImmutableSurveyDupeConfig.builder()
            .sections(elements)
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertNotEquals(
        immutableSurveyDupeConfig,
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("Doe")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    Builder builderResult2 = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertNotEquals(
        immutableSurveyDupeConfig,
        builderResult2
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("Doe")
            .targetSurveyName("Doe")
            .build();

    Builder builderResult2 = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertNotEquals(
        immutableSurveyDupeConfig,
        builderResult2
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("42")
            .build();

    Builder builderResult2 = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertNotEquals(
        immutableSurveyDupeConfig,
        builderResult2
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyDupeConfig.equals(Object)",
    "int ImmutableSurveyDupeConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build(),
        "Different type to ImmutableSurveyDupeConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyDupeConfig#toString()}
   *   <li>{@link ImmutableSurveyDupeConfig#sourceSurveyExternalId()}
   *   <li>{@link ImmutableSurveyDupeConfig#targetSurveyExternalId()}
   *   <li>{@link ImmutableSurveyDupeConfig#targetSurveyName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyDupeConfig.sourceSurveyExternalId()",
    "String ImmutableSurveyDupeConfig.targetSurveyExternalId()",
    "String ImmutableSurveyDupeConfig.targetSurveyName()",
    "String ImmutableSurveyDupeConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    String actualToStringResult = immutableSurveyDupeConfig.toString();
    String actualSourceSurveyExternalIdResult = immutableSurveyDupeConfig.sourceSurveyExternalId();
    String actualTargetSurveyExternalIdResult = immutableSurveyDupeConfig.targetSurveyExternalId();

    // Assert
    assertEquals("42", actualSourceSurveyExternalIdResult);
    assertEquals("42", actualTargetSurveyExternalIdResult);
    assertEquals("Doe", immutableSurveyDupeConfig.targetSurveyName());
    assertEquals(
        "SurveyDupeConfig{sourceSurveyExternalId=42, targetSurveyName=Doe, targetSurveyExternalId=42,"
            + " sections=[]}",
        actualToStringResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#sections()}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#sections()}
   */
  @Test
  @DisplayName("Test sections()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.google.common.collect.ImmutableSet ImmutableSurveyDupeConfig.sections()"})
  void testSections() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build()
            .sections()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    Iterable<SectionDupeConfig> elements = mock(Iterable.class);

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();
    when(elements.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements);

    // Assert
    verify(elements).iterator();
    assertEquals(immutableSurveyDupeConfig, actualWithSectionsResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("42");
    sectionDupeConfigList.add(sectionNameResult2.targets(new ArrayList<>()).build());

    Iterable<SectionDupeConfig> elements = mock(Iterable.class);
    when(elements.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements);

    // Assert
    verify(elements).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(2, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable3() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name").targets(elements).build();

    ArrayList<TargetSectionConfig> elements2 = new ArrayList<>();
    elements2.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    ImmutableSectionDupeConfig immutableSectionDupeConfig2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name").targets(elements2).build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();
    sectionDupeConfigList.add(immutableSectionDupeConfig2);
    sectionDupeConfigList.add(immutableSectionDupeConfig);

    Iterable<SectionDupeConfig> elements3 = mock(Iterable.class);
    when(elements3.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements3);

    // Assert
    verify(elements3).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(1, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return sections size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'; then return sections size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable_thenReturnSectionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult.targets(new ArrayList<>()).build());

    Iterable<SectionDupeConfig> elements = mock(Iterable.class);
    when(elements.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements);

    // Assert
    verify(elements).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(1, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return sections size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'; then return sections size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable_thenReturnSectionsSizeIsOne2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult2.targets(new ArrayList<>()).build());

    Iterable<SectionDupeConfig> elements = mock(Iterable.class);
    when(elements.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements);

    // Assert
    verify(elements).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(1, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return sections size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'; then return sections size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable_thenReturnSectionsSizeIsOne3() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult2.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult3 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult3.targets(new ArrayList<>()).build());

    Iterable<SectionDupeConfig> elements = mock(Iterable.class);
    when(elements.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements);

    // Assert
    verify(elements).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(1, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return sections size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'; then return sections size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable_thenReturnSectionsSizeIsTwo() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name").targets(elements).build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();
    sectionDupeConfigList.add(immutableSectionDupeConfig);

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult.targets(new ArrayList<>()).build());

    Iterable<SectionDupeConfig> elements2 = mock(Iterable.class);
    when(elements2.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements2);

    // Assert
    verify(elements2).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(2, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return sections size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'; then return sections size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable_thenReturnSectionsSizeIsTwo2() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ArrayList<TargetSectionConfig> elements = new ArrayList<>();
    elements.add(
        ImmutableTargetSectionConfig.builder().extIdPrefix("Ext Id Prefix").name("Name").build());
    ImmutableSectionDupeConfig immutableSectionDupeConfig =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name").targets(elements).build();

    ArrayList<SectionDupeConfig> sectionDupeConfigList = new ArrayList<>();
    sectionDupeConfigList.add(immutableSectionDupeConfig);

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult.targets(new ArrayList<>()).build());

    ImmutableSectionDupeConfig.Builder sectionNameResult2 =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");
    sectionDupeConfigList.add(sectionNameResult2.targets(new ArrayList<>()).build());

    Iterable<SectionDupeConfig> elements2 = mock(Iterable.class);
    when(elements2.iterator()).thenReturn(sectionDupeConfigList.iterator());

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(elements2);

    // Assert
    verify(elements2).iterator();
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(2, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(Iterable)}
   */
  @Test
  @DisplayName("Test withSections(Iterable) with 'Iterable'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(Iterable)"})
  void testWithSectionsWithIterable_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(new ArrayList<>());

    // Assert
    assertEquals(immutableSurveyDupeConfig, actualWithSectionsResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSections(SectionDupeConfig[])} with {@code
   * SectionDupeConfig[]}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSections(SectionDupeConfig[])}
   */
  @Test
  @DisplayName("Test withSections(SectionDupeConfig[]) with 'SectionDupeConfig[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSections(SectionDupeConfig[])"
  })
  void testWithSectionsWithSectionDupeConfig() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    ImmutableSectionDupeConfig.Builder sectionNameResult =
        ImmutableSectionDupeConfig.builder().sectionName("Section Name");

    // Act
    ImmutableSurveyDupeConfig actualWithSectionsResult =
        immutableSurveyDupeConfig.withSections(
            sectionNameResult.targets(new ArrayList<>()).build());

    // Assert
    assertEquals("42", actualWithSectionsResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSectionsResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSectionsResult.targetSurveyName());
    assertEquals(1, actualWithSectionsResult.sections().size());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSourceSurveyExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSourceSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test withSourceSurveyExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSourceSurveyExternalId(String)"
  })
  void testWithSourceSurveyExternalId() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    ImmutableSurveyDupeConfig actualWithSourceSurveyExternalIdResult =
        immutableSurveyDupeConfig.withSourceSurveyExternalId("42");

    // Assert
    assertSame(immutableSurveyDupeConfig, actualWithSourceSurveyExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withSourceSurveyExternalId(String)}.
   *
   * <ul>
   *   <li>Then return sourceSurveyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withSourceSurveyExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withSourceSurveyExternalId(String); then return sourceSurveyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withSourceSurveyExternalId(String)"
  })
  void testWithSourceSurveyExternalId_thenReturnSourceSurveyExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    ImmutableSurveyDupeConfig actualWithSourceSurveyExternalIdResult =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("sourceSurveyExternalId")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build()
            .withSourceSurveyExternalId("42");

    // Assert
    assertEquals("42", actualWithSourceSurveyExternalIdResult.sourceSurveyExternalId());
    assertEquals("42", actualWithSourceSurveyExternalIdResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithSourceSurveyExternalIdResult.targetSurveyName());
    assertTrue(actualWithSourceSurveyExternalIdResult.sections().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withTargetSurveyExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withTargetSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test withTargetSurveyExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withTargetSurveyExternalId(String)"
  })
  void testWithTargetSurveyExternalId() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build();

    // Act
    ImmutableSurveyDupeConfig actualWithTargetSurveyExternalIdResult =
        immutableSurveyDupeConfig.withTargetSurveyExternalId("42");

    // Assert
    assertSame(immutableSurveyDupeConfig, actualWithTargetSurveyExternalIdResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withTargetSurveyExternalId(String)}.
   *
   * <ul>
   *   <li>Then return sourceSurveyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withTargetSurveyExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withTargetSurveyExternalId(String); then return sourceSurveyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withTargetSurveyExternalId(String)"
  })
  void testWithTargetSurveyExternalId_thenReturnSourceSurveyExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    ImmutableSurveyDupeConfig actualWithTargetSurveyExternalIdResult =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("targetSurveyExternalId")
            .targetSurveyName("Doe")
            .build()
            .withTargetSurveyExternalId("42");

    // Assert
    assertEquals("42", actualWithTargetSurveyExternalIdResult.sourceSurveyExternalId());
    assertEquals("42", actualWithTargetSurveyExternalIdResult.targetSurveyExternalId());
    assertEquals("Doe", actualWithTargetSurveyExternalIdResult.targetSurveyName());
    assertTrue(actualWithTargetSurveyExternalIdResult.sections().isEmpty());
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withTargetSurveyName(String)}.
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withTargetSurveyName(String)}
   */
  @Test
  @DisplayName("Test withTargetSurveyName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withTargetSurveyName(String)"
  })
  void testWithTargetSurveyName() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    ImmutableSurveyDupeConfig immutableSurveyDupeConfig =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("42")
            .build();

    // Act
    ImmutableSurveyDupeConfig actualWithTargetSurveyNameResult =
        immutableSurveyDupeConfig.withTargetSurveyName("42");

    // Assert
    assertSame(immutableSurveyDupeConfig, actualWithTargetSurveyNameResult);
  }

  /**
   * Test {@link ImmutableSurveyDupeConfig#withTargetSurveyName(String)}.
   *
   * <ul>
   *   <li>Then return sourceSurveyExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyDupeConfig#withTargetSurveyName(String)}
   */
  @Test
  @DisplayName("Test withTargetSurveyName(String); then return sourceSurveyExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyDupeConfig ImmutableSurveyDupeConfig.withTargetSurveyName(String)"
  })
  void testWithTargetSurveyName_thenReturnSourceSurveyExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act
    ImmutableSurveyDupeConfig actualWithTargetSurveyNameResult =
        builderResult
            .sections(new ArrayList<>())
            .sourceSurveyExternalId("42")
            .targetSurveyExternalId("42")
            .targetSurveyName("Doe")
            .build()
            .withTargetSurveyName("42");

    // Assert
    assertEquals("42", actualWithTargetSurveyNameResult.sourceSurveyExternalId());
    assertEquals("42", actualWithTargetSurveyNameResult.targetSurveyExternalId());
    assertEquals("42", actualWithTargetSurveyNameResult.targetSurveyName());
    assertTrue(actualWithTargetSurveyNameResult.sections().isEmpty());
  }
}
