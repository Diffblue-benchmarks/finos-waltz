package org.finos.waltz.model.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.UserNameProvider;
import org.junit.jupiter.api.Test;

class ImmutableUserAgentInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUserAgentInfo.Builder#from(UserNameProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();
    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableUserAgentInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).userName();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Builder#from(UserAgentInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();
    UserAgentInfo instance = mock(UserAgentInfo.class);
    when(instance.operatingSystem()).thenReturn("Operating System");
    when(instance.resolution()).thenReturn("Resolution");
    when(instance.loginTimestamp()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userAgent()).thenReturn("User Agent");
    when(instance.ipAddress()).thenReturn("42 Main St");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableUserAgentInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).userName();
    verify(instance).ipAddress();
    verify(instance).loginTimestamp();
    verify(instance).operatingSystem();
    verify(instance).resolution();
    verify(instance).userAgent();
    ImmutableUserAgentInfo buildResult = builderResult.build();
    assertEquals("42 Main St", buildResult.ipAddress());
    assertEquals("Operating System", buildResult.operatingSystem());
    assertEquals("Resolution", buildResult.resolution());
    assertEquals("User Agent", buildResult.userAgent());
    assertEquals("janedoe", buildResult.userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Builder#from(UserAgentInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();
    UserAgentInfo instance = mock(UserAgentInfo.class);
    when(instance.operatingSystem()).thenThrow(new IllegalStateException("instance"));
    when(instance.resolution()).thenReturn("Resolution");
    when(instance.loginTimestamp()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userAgent()).thenReturn("User Agent");
    when(instance.ipAddress()).thenReturn("42 Main St");
    when(instance.userName()).thenReturn("janedoe");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).userName();
    verify(instance).ipAddress();
    verify(instance).loginTimestamp();
    verify(instance).operatingSystem();
    verify(instance).resolution();
    verify(instance).userAgent();
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Builder#ipAddress(String)}
   */
  @Test
  void testBuilderIpAddress() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ipAddress("42 Main St"));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAgentInfo.Builder#loginTimestamp(LocalDateTime)}
   */
  @Test
  void testBuilderLoginTimestamp() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableUserAgentInfo.Builder#operatingSystem(String)}
   */
  @Test
  void testBuilderOperatingSystem() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.operatingSystem("Operating System"));
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Builder#resolution(String)}
   */
  @Test
  void testBuilderResolution() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.resolution("Resolution"));
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Builder#userAgent(String)}
   */
  @Test
  void testBuilderUserAgent() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userAgent("User Agent"));
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Builder#userName(String)}
   */
  @Test
  void testBuilderUserName() {
    // Arrange
    ImmutableUserAgentInfo.Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo#copyOf(UserAgentInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UserAgentInfo instance = mock(UserAgentInfo.class);
    when(instance.operatingSystem()).thenReturn("Operating System");
    when(instance.resolution()).thenReturn("Resolution");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.loginTimestamp()).thenReturn(ofResult.atStartOfDay());
    when(instance.userAgent()).thenReturn("User Agent");
    when(instance.ipAddress()).thenReturn("42 Main St");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableUserAgentInfo actualCopyOfResult = ImmutableUserAgentInfo.copyOf(instance);

    // Assert
    verify(instance).userName();
    verify(instance).ipAddress();
    verify(instance).loginTimestamp();
    verify(instance).operatingSystem();
    verify(instance).resolution();
    verify(instance).userAgent();
    LocalDateTime loginTimestampResult = actualCopyOfResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42 Main St", actualCopyOfResult.ipAddress());
    assertEquals("Operating System", actualCopyOfResult.operatingSystem());
    assertEquals("Resolution", actualCopyOfResult.resolution());
    assertEquals("User Agent", actualCopyOfResult.userAgent());
    assertEquals("janedoe", actualCopyOfResult.userName());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableUserAgentInfo.Json}
   *   <li>{@link ImmutableUserAgentInfo.Json#setIpAddress(String)}
   *   <li>{@link ImmutableUserAgentInfo.Json#setLoginTimestamp(LocalDateTime)}
   *   <li>{@link ImmutableUserAgentInfo.Json#setOperatingSystem(String)}
   *   <li>{@link ImmutableUserAgentInfo.Json#setResolution(String)}
   *   <li>{@link ImmutableUserAgentInfo.Json#setUserAgent(String)}
   *   <li>{@link ImmutableUserAgentInfo.Json#setUserName(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableUserAgentInfo.Json actualJson = new ImmutableUserAgentInfo.Json();
    actualJson.setIpAddress("42 Main St");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLoginTimestamp(ofResult.atStartOfDay());
    actualJson.setOperatingSystem("Operating System");
    actualJson.setResolution("Resolution");
    actualJson.setUserAgent("User Agent");
    actualJson.setUserName("janedoe");

    // Assert
    LocalDateTime localDateTime = actualJson.loginTimestamp;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Json#ipAddress()}
   */
  @Test
  void testJsonIpAddress() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserAgentInfo.Json()).ipAddress());
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Json#loginTimestamp()}
   */
  @Test
  void testJsonLoginTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserAgentInfo.Json()).loginTimestamp());
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Json#operatingSystem()}
   */
  @Test
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserAgentInfo.Json()).operatingSystem());
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Json#resolution()}
   */
  @Test
  void testJsonResolution() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserAgentInfo.Json()).resolution());
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Json#userAgent()}
   */
  @Test
  void testJsonUserAgent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserAgentInfo.Json()).userAgent());
  }

  /**
   * Method under test: {@link ImmutableUserAgentInfo.Json#userName()}
   */
  @Test
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUserAgentInfo.Json()).userName());
  }
}
