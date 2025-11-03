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
import org.finos.waltz.jobs.tools.survey.config.ImmutableSectionDupeConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSectionDupeConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllTargets(Iterable)}.
   * <p>
   * Method under test: {@link Builder#addAllTargets(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllTargets(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllTargets(Iterable)"})
  void testBuilderAddAllTargets() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTargets(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addTargets(TargetSectionConfig)} with {@code element}.
   * <ul>
   *   <li>When {@link TargetSectionConfig}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTargets(TargetSectionConfig)}
   */
  @Test
  @DisplayName("Test Builder addTargets(TargetSectionConfig) with 'element'; when TargetSectionConfig; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTargets(TargetSectionConfig)"})
  void testBuilderAddTargetsWithElement_whenTargetSectionConfig_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTargets(mock(TargetSectionConfig.class)));
  }

  /**
   * Test Builder {@link Builder#addTargets(TargetSectionConfig[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addTargets(TargetSectionConfig[])}
   */
  @Test
  @DisplayName("Test Builder addTargets(TargetSectionConfig[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addTargets(TargetSectionConfig[])"})
  void testBuilderAddTargetsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTargets());
  }

  /**
   * Test Builder {@link Builder#from(SectionDupeConfig)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build sectionName is {@code Section Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SectionDupeConfig); given ArrayList(); then return build sectionName is 'Section Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SectionDupeConfig)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildSectionNameIsSectionName() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(new ArrayList<>());
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    ImmutableSectionDupeConfig buildResult = actualFromResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertTrue(buildResult.targets().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(SectionDupeConfig)}.
   * <ul>
   *   <li>Then builder build targets is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SectionDupeConfig); then builder build targets is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SectionDupeConfig)"})
  void testBuilderFrom_thenBuilderBuildTargetsIsArrayList() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    ImmutableSectionDupeConfig buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(targetSectionConfigList, buildResult.targets());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SectionDupeConfig)}.
   * <ul>
   *   <li>Then builder build targets size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SectionDupeConfig); then builder build targets size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SectionDupeConfig)"})
  void testBuilderFrom_thenBuilderBuildTargetsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    ArrayList<TargetSectionConfig> targetSectionConfigList = new ArrayList<>();
    targetSectionConfigList.add(mock(TargetSectionConfig.class));
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenReturn(targetSectionConfigList);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).sectionName();
    verify(instance).targets();
    ImmutableSectionDupeConfig buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(1, buildResult.targets().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SectionDupeConfig)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SectionDupeConfig)}
   */
  @Test
  @DisplayName("Test Builder from(SectionDupeConfig); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SectionDupeConfig)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();
    SectionDupeConfig instance = mock(SectionDupeConfig.class);
    when(instance.targets()).thenThrow(new IllegalStateException("instance"));
    when(instance.sectionName()).thenReturn("Section Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).sectionName();
    verify(instance).targets();
  }

  /**
   * Test Builder {@link Builder#sectionName(String)}.
   * <p>
   * Method under test: {@link Builder#sectionName(String)}
   */
  @Test
  @DisplayName("Test Builder sectionName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sectionName(String)"})
  void testBuilderSectionName() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act
    Builder actualSectionNameResult = builderResult.sectionName("Section Name");

    // Assert
    assertEquals("Section Name", builderResult.build().sectionName());
    assertSame(builderResult, actualSectionNameResult);
  }

  /**
   * Test Builder {@link Builder#targets(Iterable)}.
   * <p>
   * Method under test: {@link Builder#targets(Iterable)}
   */
  @Test
  @DisplayName("Test Builder targets(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targets(Iterable)"})
  void testBuilderTargets() {
    // Arrange
    Builder builderResult = ImmutableSectionDupeConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targets(new ArrayList<>()));
  }
}
