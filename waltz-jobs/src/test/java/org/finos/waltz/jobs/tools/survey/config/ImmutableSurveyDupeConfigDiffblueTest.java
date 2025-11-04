package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class ImmutableSurveyDupeConfigDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#addAllSections(Iterable)}
   */
  @Test
  void testBuilderAddAllSections() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSections(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#addSections(SectionDupeConfig)}
   */
  @Test
  void testBuilderAddSections() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSections(mock(SectionDupeConfig.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#addSections(SectionDupeConfig[])}
   */
  @Test
  void testBuilderAddSections2() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSections());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#from(SurveyDupeConfig)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(new HashSet<>());
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    ImmutableSurveyDupeConfig buildResult = builderResult.build();
    assertEquals("42", buildResult.sourceSurveyExternalId());
    assertEquals("42", buildResult.targetSurveyExternalId());
    assertEquals("Doe", buildResult.targetSurveyName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#from(SurveyDupeConfig)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();
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
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#from(SurveyDupeConfig)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#from(SurveyDupeConfig)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#sections(Iterable)}
   */
  @Test
  void testBuilderSections() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sections(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#sourceSurveyExternalId(String)}
   */
  @Test
  void testBuilderSourceSurveyExternalId() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sourceSurveyExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#targetSurveyExternalId(String)}
   */
  @Test
  void testBuilderTargetSurveyExternalId() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetSurveyExternalId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyDupeConfig.Builder#targetSurveyName(String)}
   */
  @Test
  void testBuilderTargetSurveyName() {
    // Arrange
    ImmutableSurveyDupeConfig.Builder builderResult = ImmutableSurveyDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetSurveyName("Doe"));
  }

  /**
   * Method under test: {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(new HashSet<>());
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig actualCopyOfResult = ImmutableSurveyDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    assertEquals("42", actualCopyOfResult.sourceSurveyExternalId());
    assertEquals("42", actualCopyOfResult.targetSurveyExternalId());
    assertEquals("Doe", actualCopyOfResult.targetSurveyName());
    assertTrue(actualCopyOfResult.sections().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig actualCopyOfResult = ImmutableSurveyDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    assertEquals("42", actualCopyOfResult.sourceSurveyExternalId());
    assertEquals("42", actualCopyOfResult.targetSurveyExternalId());
    assertEquals("Doe", actualCopyOfResult.targetSurveyName());
    assertEquals(1, actualCopyOfResult.sections().size());
  }

  /**
   * Method under test: {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig actualCopyOfResult = ImmutableSurveyDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    assertEquals("42", actualCopyOfResult.sourceSurveyExternalId());
    assertEquals("42", actualCopyOfResult.targetSurveyExternalId());
    assertEquals("Doe", actualCopyOfResult.targetSurveyName());
    assertEquals(sectionDupeConfigSet, actualCopyOfResult.sections());
  }

  /**
   * Method under test: {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("foo");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig actualCopyOfResult = ImmutableSurveyDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    assertEquals("42", actualCopyOfResult.sourceSurveyExternalId());
    assertEquals("Doe", actualCopyOfResult.targetSurveyName());
    assertEquals("foo", actualCopyOfResult.targetSurveyExternalId());
    assertEquals(sectionDupeConfigSet, actualCopyOfResult.sections());
  }

  /**
   * Method under test: {@link ImmutableSurveyDupeConfig#copyOf(SurveyDupeConfig)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<SectionDupeConfig> sectionDupeConfigSet = new HashSet<>();
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    sectionDupeConfigSet.add(mock(SectionDupeConfig.class));
    SurveyDupeConfig instance = mock(SurveyDupeConfig.class);
    when(instance.sections()).thenReturn(sectionDupeConfigSet);
    when(instance.targetSurveyExternalId()).thenReturn("42");
    when(instance.targetSurveyName()).thenReturn("Doe");
    when(instance.sourceSurveyExternalId()).thenReturn("42");

    // Act
    ImmutableSurveyDupeConfig actualCopyOfResult = ImmutableSurveyDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sections();
    verify(instance).sourceSurveyExternalId();
    verify(instance).targetSurveyExternalId();
    verify(instance).targetSurveyName();
    assertEquals("42", actualCopyOfResult.sourceSurveyExternalId());
    assertEquals("42", actualCopyOfResult.targetSurveyExternalId());
    assertEquals("Doe", actualCopyOfResult.targetSurveyName());
    assertEquals(sectionDupeConfigSet, actualCopyOfResult.sections());
  }
}
