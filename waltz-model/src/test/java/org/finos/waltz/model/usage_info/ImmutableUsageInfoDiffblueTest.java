package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableUsageInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUsageInfo#builder()}
   *   <li>{@link ImmutableUsageInfo#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableUsageInfo.Builder actualBuilderResult = ImmutableUsageInfo.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.description("The characteristics of someone or something"));
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Builder#from(UsageInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUsageInfo.Builder builderResult = ImmutableUsageInfo.builder();
    UsageInfo instance = mock(UsageInfo.class);
    when(instance.isSelected()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(UsageKind.CONSUMER);

    // Act
    ImmutableUsageInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).isSelected();
    verify(instance).kind();
    ImmutableUsageInfo buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(UsageKind.CONSUMER, buildResult.kind());
    assertTrue(buildResult.isSelected());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Builder#from(UsageInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUsageInfo.Builder builderResult = ImmutableUsageInfo.builder();
    UsageInfo instance = mock(UsageInfo.class);
    when(instance.isSelected()).thenThrow(new IllegalStateException("instance"));
    when(instance.kind()).thenReturn(UsageKind.CONSUMER);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).isSelected();
    verify(instance).kind();
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Builder#isSelected(boolean)}
   */
  @Test
  void testBuilderIsSelected() {
    // Arrange
    ImmutableUsageInfo.Builder builderResult = ImmutableUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isSelected(true));
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Builder#kind(UsageKind)}
   */
  @Test
  void testBuilderKind() {
    // Arrange
    ImmutableUsageInfo.Builder builderResult = ImmutableUsageInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.kind(UsageKind.CONSUMER));
  }

  /**
   * Method under test: {@link ImmutableUsageInfo#copyOf(UsageInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UsageInfo instance = mock(UsageInfo.class);
    when(instance.isSelected()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(UsageKind.CONSUMER);

    // Act
    ImmutableUsageInfo actualCopyOfResult = ImmutableUsageInfo.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).isSelected();
    verify(instance).kind();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(UsageKind.CONSUMER, actualCopyOfResult.kind());
    assertTrue(actualCopyOfResult.isSelected());
  }

  /**
   * Method under test: {@link ImmutableUsageInfo#copyOf(UsageInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    UsageInfo instance = mock(UsageInfo.class);
    when(instance.isSelected()).thenReturn(false);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(UsageKind.CONSUMER);

    // Act
    ImmutableUsageInfo actualCopyOfResult = ImmutableUsageInfo.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).isSelected();
    verify(instance).kind();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(UsageKind.CONSUMER, actualCopyOfResult.kind());
    assertFalse(actualCopyOfResult.isSelected());
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUsageInfo.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableUsageInfo.Json}
   *   <li>{@link ImmutableUsageInfo.Json#setDescription(String)}
   *   <li>{@link ImmutableUsageInfo.Json#setKind(UsageKind)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUsageInfo.Json actualJson = new ImmutableUsageInfo.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setKind(UsageKind.CONSUMER);

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
    assertEquals(UsageKind.CONSUMER, actualJson.kind);
    assertFalse(actualJson.isSelected);
    assertFalse(actualJson.isSelectedIsSet);
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Json#isSelected()}
   */
  @Test
  void testJsonIsSelected() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUsageInfo.Json()).isSelected());
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUsageInfo.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableUsageInfo.Json#setIsSelected(boolean)}
   */
  @Test
  void testJsonSetIsSelected() {
    // Arrange
    ImmutableUsageInfo.Json json = new ImmutableUsageInfo.Json();

    // Act
    json.setIsSelected(true);

    // Assert
    assertTrue(json.isSelected);
    assertTrue(json.isSelectedIsSet);
  }
}
