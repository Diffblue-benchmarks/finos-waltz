package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.web.json.ImmutableBrowserInfo.Builder;
import org.finos.waltz.web.json.ImmutableBrowserInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBrowserInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#from(BrowserInfo)}.
   * <ul>
   *   <li>Given {@code Resolution}.</li>
   *   <li>Then builder build operatingSystem is {@code Operating System}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BrowserInfo)}
   */
  @Test
  @DisplayName("Test Builder from(BrowserInfo); given 'Resolution'; then builder build operatingSystem is 'Operating System'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BrowserInfo)"})
  void testBuilderFrom_givenResolution_thenBuilderBuildOperatingSystemIsOperatingSystem() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();
    BrowserInfo instance = mock(BrowserInfo.class);
    when(instance.resolution()).thenReturn("Resolution");
    when(instance.operatingSystem()).thenReturn("Operating System");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).operatingSystem();
    verify(instance).resolution();
    ImmutableBrowserInfo buildResult = builderResult.build();
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Resolution", buildResult.resolution());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BrowserInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(BrowserInfo)}
   */
  @Test
  @DisplayName("Test Builder from(BrowserInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(BrowserInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();
    BrowserInfo instance = mock(BrowserInfo.class);
    when(instance.resolution()).thenThrow(new IllegalStateException("instance"));
    when(instance.operatingSystem()).thenReturn("Operating System");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).operatingSystem();
    verify(instance).resolution();
  }

  /**
   * Test Builder {@link Builder#operatingSystem(String)}.
   * <p>
   * Method under test: {@link Builder#operatingSystem(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystem(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.operatingSystem(String)"})
  void testBuilderOperatingSystem() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystem("Operating System"));
  }

  /**
   * Test Builder {@link Builder#resolution(String)}.
   * <p>
   * Method under test: {@link Builder#resolution(String)}
   */
  @Test
  @DisplayName("Test Builder resolution(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.resolution(String)"})
  void testBuilderResolution() {
    // Arrange
    Builder builderResult = ImmutableBrowserInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.resolution("Resolution"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setOperatingSystem(String)}
   *   <li>{@link Json#setResolution(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setOperatingSystem(String)", "void Json.setResolution(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setOperatingSystem("Operating System");
    actualJson.setResolution("Resolution");

    // Assert
    assertEquals("Operating System", actualJson.operatingSystem);
    assertEquals("Resolution", actualJson.resolution);
  }

  /**
   * Test Json {@link Json#operatingSystem()}.
   * <p>
   * Method under test: {@link Json#operatingSystem()}
   */
  @Test
  @DisplayName("Test Json operatingSystem()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.operatingSystem()"})
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).operatingSystem());
  }

  /**
   * Test Json {@link Json#resolution()}.
   * <p>
   * Method under test: {@link Json#resolution()}
   */
  @Test
  @DisplayName("Test Json resolution()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.resolution()"})
  void testJsonResolution() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).resolution());
  }
}
