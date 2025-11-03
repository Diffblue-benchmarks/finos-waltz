package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.jobs.tools.survey.config.ImmutableSurveyDupeConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyDupeConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSections(Iterable)}.
   * <p>
   * Method under test: {@link Builder#addAllSections(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSections(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllSections(Iterable)"})
  void testBuilderAddAllSections() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSections(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addSections(SectionDupeConfig)} with {@code element}.
   * <ul>
   *   <li>When {@link SectionDupeConfig}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSections(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder addSections(SectionDupeConfig) with 'element'; when SectionDupeConfig; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSections(SectionDupeConfig)"})
  void testBuilderAddSectionsWithElement_whenSectionDupeConfig_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSections(mock(SectionDupeConfig.class)));
  }

  /**
   * Test Builder {@link Builder#addSections(SectionDupeConfig[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSections(SectionDupeConfig[])}
   */
  @Test
  @DisplayName("Test Builder addSections(SectionDupeConfig[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSections(SectionDupeConfig[])"})
  void testBuilderAddSectionsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSections());
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build sourceSurveyExternalId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDupeConfig); given HashSet(); then return build sourceSurveyExternalId is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildSourceSurveyExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(new HashSet<>());
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    ImmutableSurveyDupeConfig buildResult = actualFromResult.build();
    assertEquals("42", buildResult.sourceSurveyExternalId());
    assertEquals("42", buildResult.targetSurveyExternalId());
    assertEquals("Doe", buildResult.targetSurveyName());
    assertTrue(buildResult.sections().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   * <ul>
   *   <li>Then builder build sections is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDupeConfig); then builder build sections is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom_thenBuilderBuildSectionsIsHashSet() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    ImmutableSurveyDupeConfig buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceSurveyExternalId());
    assertEquals("42", buildResult.targetSurveyExternalId());
    assertEquals("Doe", buildResult.targetSurveyName());
    assertEquals(sectionDupeConfigSet, buildResult.sections());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   * <ul>
   *   <li>Then builder build sections size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDupeConfig); then builder build sections size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom_thenBuilderBuildSectionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    ImmutableSurveyDupeConfig buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceSurveyExternalId());
    assertEquals("42", buildResult.targetSurveyExternalId());
    assertEquals("Doe", buildResult.targetSurveyName());
    assertEquals(1, buildResult.sections().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyDupeConfig)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyDupeConfig); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyDupeConfig)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenThrow(new IllegalStateException("instance"));
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
  }

  /**
   * Test Builder {@link Builder#sections(Iterable)}.
   * <p>
   * Method under test: {@link Builder#sections(Iterable)}
   */
  @Test
  @DisplayName("Test Builder sections(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sections(Iterable)"})
  void testBuilderSections() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sections(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#sourceSurveyExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#sourceSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder sourceSurveyExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceSurveyExternalId(String)"})
  void testBuilderSourceSurveyExternalId() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceSurveyExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#targetSurveyExternalId(String)}.
   * <p>
   * Method under test: {@link Builder#targetSurveyExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder targetSurveyExternalId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetSurveyExternalId(String)"})
  void testBuilderTargetSurveyExternalId() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetSurveyExternalId("42"));
  }

  /**
   * Test Builder {@link Builder#targetSurveyName(String)}.
   * <p>
   * Method under test: {@link Builder#targetSurveyName(String)}
   */
  @Test
  @DisplayName("Test Builder targetSurveyName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetSurveyName(String)"})
  void testBuilderTargetSurveyName() {
    // Arrange
    Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetSurveyName("Doe"));
  }
}
