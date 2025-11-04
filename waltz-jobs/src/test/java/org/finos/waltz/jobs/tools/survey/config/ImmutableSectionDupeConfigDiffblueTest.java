package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ImmutableSectionDupeConfigDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#addAllTargets(Iterable)}
   */
  @Test
  void testBuilderAddAllTargets() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTargets(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#addTargets(TargetSectionConfig)}
   */
  @Test
  void testBuilderAddTargets() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTargets(mock(TargetSectionConfig.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#addTargets(TargetSectionConfig[])}
   */
  @Test
  void testBuilderAddTargets2() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTargets());
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#from(SectionDupeConfig)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(new ArrayList<>());
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    assertEquals("Section Name", builderResult.build().sectionName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#from(SectionDupeConfig)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenThrow(new IllegalStateException("instance"));
    when(instance.sectionName()).thenReturn("Section Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).sectionName();
    verify(instance).targets();
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#from(SectionDupeConfig)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    ImmutableSectionDupeConfig buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(1, buildResult.targets().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#from(SectionDupeConfig)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    ImmutableSectionDupeConfig buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(targetSectionConfigList, buildResult.targets());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#sectionName(String)}
   */
  @Test
  void testBuilderSectionName() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    ImmutableSectionDupeConfig.Builder actualSectionNameResult = builderResult.sectionName("Section Name");

    // Assert
    assertEquals("Section Name", builderResult.build().sectionName());
    assertSame(builderResult, actualSectionNameResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig.Builder#targets(Iterable)}
   */
  @Test
  void testBuilderTargets() {
    // Arrange
    ImmutableSectionDupeConfig.Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targets(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig#copyOf(SectionDupeConfig)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(new ArrayList<>());
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig actualCopyOfResult = ImmutableSectionDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertTrue(actualCopyOfResult.targets().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig#copyOf(SectionDupeConfig)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig actualCopyOfResult = ImmutableSectionDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(1, actualCopyOfResult.targets().size());
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig#copyOf(SectionDupeConfig)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig actualCopyOfResult = ImmutableSectionDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(targetSectionConfigList, actualCopyOfResult.targets());
  }

  /**
   * Method under test:
   * {@link ImmutableSectionDupeConfig#copyOf(SectionDupeConfig)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableSectionDupeConfig actualCopyOfResult = ImmutableSectionDupeConfig.copyOf(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(targetSectionConfigList, actualCopyOfResult.targets());
  }
}
