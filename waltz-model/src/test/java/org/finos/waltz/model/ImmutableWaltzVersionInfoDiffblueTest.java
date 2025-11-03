package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.ImmutableWaltzVersionInfo.Builder;
import org.finos.waltz.model.ImmutableWaltzVersionInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableWaltzVersionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#from(WaltzVersionInfo)}.
   * <ul>
   *   <li>Given {@code Revision}.</li>
   *   <li>Then builder build pomVersion is {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzVersionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzVersionInfo); given 'Revision'; then builder build pomVersion is '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzVersionInfo)"})
  void testBuilderFrom_givenRevision_thenBuilderBuildPomVersionIs102() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();
    WaltzVersionInfo instance = mock(WaltzVersionInfo.class);
    when(instance.revision()).thenReturn("Revision");
    when(instance.timestamp()).thenReturn("Timestamp");
    when(instance.pomVersion()).thenReturn("1.0.2");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).pomVersion();
    verify(instance).revision();
    verify(instance).timestamp();
    ImmutableWaltzVersionInfo buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.pomVersion());
    assertEquals("Revision", buildResult.revision());
    assertEquals("Timestamp", buildResult.timestamp());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(WaltzVersionInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(WaltzVersionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(WaltzVersionInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(WaltzVersionInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();
    WaltzVersionInfo instance = mock(WaltzVersionInfo.class);
    when(instance.revision()).thenThrow(new IllegalStateException("instance"));
    when(instance.timestamp()).thenReturn("Timestamp");
    when(instance.pomVersion()).thenReturn("1.0.2");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).pomVersion();
    verify(instance).revision();
    verify(instance).timestamp();
  }

  /**
   * Test Builder {@link Builder#pomVersion(String)}.
   * <p>
   * Method under test: {@link Builder#pomVersion(String)}
   */
  @Test
  @DisplayName("Test Builder pomVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.pomVersion(String)"})
  void testBuilderPomVersion() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pomVersion("1.0.2"));
  }

  /**
   * Test Builder {@link Builder#revision(String)}.
   * <p>
   * Method under test: {@link Builder#revision(String)}
   */
  @Test
  @DisplayName("Test Builder revision(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.revision(String)"})
  void testBuilderRevision() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.revision("Revision"));
  }

  /**
   * Test Builder {@link Builder#timestamp(String)}.
   * <p>
   * Method under test: {@link Builder#timestamp(String)}
   */
  @Test
  @DisplayName("Test Builder timestamp(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.timestamp(String)"})
  void testBuilderTimestamp() {
    // Arrange
    Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.timestamp("Timestamp"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setPomVersion(String)}
   *   <li>{@link Json#setRevision(String)}
   *   <li>{@link Json#setTimestamp(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setPomVersion(String)", "void Json.setRevision(String)",
      "void Json.setTimestamp(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setPomVersion("1.0.2");
    actualJson.setRevision("Revision");
    actualJson.setTimestamp("Timestamp");

    // Assert
    assertEquals("1.0.2", actualJson.pomVersion);
    assertEquals("Revision", actualJson.revision);
    assertEquals("Timestamp", actualJson.timestamp);
  }

  /**
   * Test Json {@link Json#pomVersion()}.
   * <p>
   * Method under test: {@link Json#pomVersion()}
   */
  @Test
  @DisplayName("Test Json pomVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.pomVersion()"})
  void testJsonPomVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).pomVersion());
  }

  /**
   * Test Json {@link Json#revision()}.
   * <p>
   * Method under test: {@link Json#revision()}
   */
  @Test
  @DisplayName("Test Json revision()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.revision()"})
  void testJsonRevision() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).revision());
  }

  /**
   * Test Json {@link Json#timestamp()}.
   * <p>
   * Method under test: {@link Json#timestamp()}
   */
  @Test
  @DisplayName("Test Json timestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.timestamp()"})
  void testJsonTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).timestamp());
  }
}
