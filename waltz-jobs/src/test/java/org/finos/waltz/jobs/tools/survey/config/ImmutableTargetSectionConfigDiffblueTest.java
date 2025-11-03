package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.survey.config.ImmutableTargetSectionConfig.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableTargetSectionConfigDiffblueTest {
  /**
   * Test Builder {@link Builder#extIdPrefix(String)}.
   * <p>
   * Method under test: {@link Builder#extIdPrefix(String)}
   */
  @Test
  @DisplayName("Test Builder extIdPrefix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.extIdPrefix(String)"})
  void testBuilderExtIdPrefix() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.extIdPrefix("Ext Id Prefix"));
  }

  /**
   * Test Builder {@link Builder#from(TargetSectionConfig)}.
   * <p>
   * Method under test: {@link Builder#from(TargetSectionConfig)}
   */
  @Test
  @DisplayName("Test Builder from(TargetSectionConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TargetSectionConfig)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.extIdPrefix()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).extIdPrefix();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(TargetSectionConfig)}.
   * <p>
   * Method under test: {@link Builder#from(TargetSectionConfig)}
   */
  @Test
  @DisplayName("Test Builder from(TargetSectionConfig)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TargetSectionConfig)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(TargetSectionConfig)}.
   * <ul>
   *   <li>Given {@code Ext Id Prefix}.</li>
   *   <li>Then builder build extIdPrefix is {@code Ext Id Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(TargetSectionConfig)}
   */
  @Test
  @DisplayName("Test Builder from(TargetSectionConfig); given 'Ext Id Prefix'; then builder build extIdPrefix is 'Ext Id Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(TargetSectionConfig)"})
  void testBuilderFrom_givenExtIdPrefix_thenBuilderBuildExtIdPrefixIsExtIdPrefix() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.extIdPrefix()).thenReturn("Ext Id Prefix");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).extIdPrefix();
    verify(instance).name();
    ImmutableTargetSectionConfig buildResult = builderResult.build();
    assertEquals("Ext Id Prefix", buildResult.extIdPrefix());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableTargetSectionConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }
}
