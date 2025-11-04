package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableWaltzVersionInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableWaltzVersionInfo.Builder#from(WaltzVersionInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableWaltzVersionInfo.Builder builderResult = ImmutableWaltzVersionInfo.builder();
    WaltzVersionInfo instance = mock(WaltzVersionInfo.class);
    when(instance.revision()).thenReturn("Revision");
    when(instance.timestamp()).thenReturn("Timestamp");
    when(instance.pomVersion()).thenReturn("1.0.2");

    // Act
    ImmutableWaltzVersionInfo.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableWaltzVersionInfo.Builder#from(WaltzVersionInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableWaltzVersionInfo.Builder builderResult = ImmutableWaltzVersionInfo.builder();
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
   * Method under test:
   * {@link ImmutableWaltzVersionInfo.Builder#pomVersion(String)}
   */
  @Test
  void testBuilderPomVersion() {
    // Arrange
    ImmutableWaltzVersionInfo.Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pomVersion("1.0.2"));
  }

  /**
   * Method under test: {@link ImmutableWaltzVersionInfo.Builder#revision(String)}
   */
  @Test
  void testBuilderRevision() {
    // Arrange
    ImmutableWaltzVersionInfo.Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.revision("Revision"));
  }

  /**
   * Method under test:
   * {@link ImmutableWaltzVersionInfo.Builder#timestamp(String)}
   */
  @Test
  void testBuilderTimestamp() {
    // Arrange
    ImmutableWaltzVersionInfo.Builder builderResult = ImmutableWaltzVersionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.timestamp("Timestamp"));
  }

  /**
   * Method under test: {@link ImmutableWaltzVersionInfo#copyOf(WaltzVersionInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    WaltzVersionInfo instance = mock(WaltzVersionInfo.class);
    when(instance.revision()).thenReturn("Revision");
    when(instance.timestamp()).thenReturn("Timestamp");
    when(instance.pomVersion()).thenReturn("1.0.2");

    // Act
    ImmutableWaltzVersionInfo actualCopyOfResult = ImmutableWaltzVersionInfo.copyOf(instance);

    // Assert
    verify(instance).pomVersion();
    verify(instance).revision();
    verify(instance).timestamp();
    assertEquals("1.0.2", actualCopyOfResult.pomVersion());
    assertEquals("Revision", actualCopyOfResult.revision());
    assertEquals("Timestamp", actualCopyOfResult.timestamp());
  }

  /**
   * Method under test:
   * {@link ImmutableWaltzVersionInfo#fromJson(ImmutableWaltzVersionInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableWaltzVersionInfo.Json json = new ImmutableWaltzVersionInfo.Json();
    json.setPomVersion("Json");
    json.setTimestamp("Json");
    json.setRevision("Json");

    // Act
    ImmutableWaltzVersionInfo actualFromJsonResult = ImmutableWaltzVersionInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.pomVersion());
    assertEquals("Json", actualFromJsonResult.revision());
    assertEquals("Json", actualFromJsonResult.timestamp());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableWaltzVersionInfo.Json}
   *   <li>{@link ImmutableWaltzVersionInfo.Json#setPomVersion(String)}
   *   <li>{@link ImmutableWaltzVersionInfo.Json#setRevision(String)}
   *   <li>{@link ImmutableWaltzVersionInfo.Json#setTimestamp(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableWaltzVersionInfo.Json actualJson = new ImmutableWaltzVersionInfo.Json();
    actualJson.setPomVersion("1.0.2");
    actualJson.setRevision("Revision");
    actualJson.setTimestamp("Timestamp");

    // Assert
    assertEquals("1.0.2", actualJson.pomVersion);
    assertEquals("Revision", actualJson.revision);
    assertEquals("Timestamp", actualJson.timestamp);
  }

  /**
   * Method under test: {@link ImmutableWaltzVersionInfo.Json#pomVersion()}
   */
  @Test
  void testJsonPomVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableWaltzVersionInfo.Json()).pomVersion());
  }

  /**
   * Method under test: {@link ImmutableWaltzVersionInfo.Json#revision()}
   */
  @Test
  void testJsonRevision() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableWaltzVersionInfo.Json()).revision());
  }

  /**
   * Method under test: {@link ImmutableWaltzVersionInfo.Json#timestamp()}
   */
  @Test
  void testJsonTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableWaltzVersionInfo.Json()).timestamp());
  }
}
