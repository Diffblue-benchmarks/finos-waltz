package org.finos.waltz.jobs.tools.survey.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableTargetSectionConfigDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableTargetSectionConfig.Builder#extIdPrefix(String)}
   */
  @Test
  void testBuilderExtIdPrefix() {
    // Arrange
    ImmutableTargetSectionConfig.Builder builderResult = ImmutableTargetSectionConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.extIdPrefix("Ext Id Prefix"));
  }

  /**
   * Method under test:
   * {@link ImmutableTargetSectionConfig.Builder#from(TargetSectionConfig)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableTargetSectionConfig.Builder builderResult = ImmutableTargetSectionConfig.builder();
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.extIdPrefix()).thenReturn("Ext Id Prefix");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTargetSectionConfig.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).extIdPrefix();
    verify(instance).name();
    ImmutableTargetSectionConfig buildResult = builderResult.build();
    assertEquals("Ext Id Prefix", buildResult.extIdPrefix());
    assertEquals("Name", buildResult.name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableTargetSectionConfig.Builder#from(TargetSectionConfig)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableTargetSectionConfig.Builder builderResult = ImmutableTargetSectionConfig.builder();
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.extIdPrefix()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).extIdPrefix();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableTargetSectionConfig.Builder#from(TargetSectionConfig)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableTargetSectionConfig.Builder builderResult = ImmutableTargetSectionConfig.builder();
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableTargetSectionConfig.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableTargetSectionConfig.Builder builderResult = ImmutableTargetSectionConfig.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableTargetSectionConfig#copyOf(TargetSectionConfig)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    TargetSectionConfig instance = mock(TargetSectionConfig.class);
    when(instance.extIdPrefix()).thenReturn("Ext Id Prefix");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableTargetSectionConfig actualCopyOfResult = ImmutableTargetSectionConfig.copyOf(instance);

    // Assert
    verify(instance).extIdPrefix();
    verify(instance).name();
    assertEquals("Ext Id Prefix", actualCopyOfResult.extIdPrefix());
    assertEquals("Name", actualCopyOfResult.name());
  }
}
