package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableBrowserInfoDiffblueTest {
  /**
   * Method under test: {@link ImmutableBrowserInfo.Builder#from(BrowserInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableBrowserInfo.Builder builderResult = ImmutableBrowserInfo.builder();
    BrowserInfo instance = mock(BrowserInfo.class);
    when(instance.resolution()).thenReturn("Resolution");
    when(instance.operatingSystem()).thenReturn("Operating System");

    // Act
    ImmutableBrowserInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operatingSystem();
    verify(instance).resolution();
    ImmutableBrowserInfo buildResult = builderResult.build();
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Resolution", buildResult.resolution());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableBrowserInfo.Builder#from(BrowserInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableBrowserInfo.Builder builderResult = ImmutableBrowserInfo.builder();
    BrowserInfo instance = mock(BrowserInfo.class);
    when(instance.resolution()).thenThrow(new IllegalStateException("instance"));
    when(instance.operatingSystem()).thenReturn("Operating System");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).operatingSystem();
    verify(instance).resolution();
  }

  /**
   * Method under test:
   * {@link ImmutableBrowserInfo.Builder#operatingSystem(String)}
   */
  @Test
  void testBuilderOperatingSystem() {
    // Arrange
    ImmutableBrowserInfo.Builder builderResult = ImmutableBrowserInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystem("Operating System"));
  }

  /**
   * Method under test: {@link ImmutableBrowserInfo.Builder#resolution(String)}
   */
  @Test
  void testBuilderResolution() {
    // Arrange
    ImmutableBrowserInfo.Builder builderResult = ImmutableBrowserInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.resolution("Resolution"));
  }

  /**
   * Method under test: {@link ImmutableBrowserInfo#copyOf(BrowserInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    BrowserInfo instance = mock(BrowserInfo.class);
    when(instance.resolution()).thenReturn("Resolution");
    when(instance.operatingSystem()).thenReturn("Operating System");

    // Act
    ImmutableBrowserInfo actualCopyOfResult = ImmutableBrowserInfo.copyOf(instance);

    // Assert
    verify(instance).operatingSystem();
    verify(instance).resolution();
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Resolution", actualCopyOfResult.resolution());
  }

  /**
   * Method under test:
   * {@link ImmutableBrowserInfo#fromJson(ImmutableBrowserInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableBrowserInfo.Json json = new ImmutableBrowserInfo.Json();
    json.setOperatingSystem("Json");
    json.setResolution("Json");

    // Act
    ImmutableBrowserInfo actualFromJsonResult = ImmutableBrowserInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.operatingSystem());
    assertEquals("Json", actualFromJsonResult.resolution());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableBrowserInfo.Json}
   *   <li>{@link ImmutableBrowserInfo.Json#setOperatingSystem(String)}
   *   <li>{@link ImmutableBrowserInfo.Json#setResolution(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableBrowserInfo.Json actualJson = new ImmutableBrowserInfo.Json();
    actualJson.setOperatingSystem("Operating System");
    actualJson.setResolution("Resolution");

    // Assert
    assertEquals("Operating System", actualJson.operatingSystem);
    assertEquals("Resolution", actualJson.resolution);
  }

  /**
   * Method under test: {@link ImmutableBrowserInfo.Json#operatingSystem()}
   */
  @Test
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBrowserInfo.Json()).operatingSystem());
  }

  /**
   * Method under test: {@link ImmutableBrowserInfo.Json#resolution()}
   */
  @Test
  void testJsonResolution() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableBrowserInfo.Json()).resolution());
  }
}
