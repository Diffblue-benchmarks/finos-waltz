package org.finos.waltz.model.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.UserNameProvider;
import org.finos.waltz.model.user_agent_info.ImmutableUserAgentInfo.Builder;
import org.finos.waltz.model.user_agent_info.ImmutableUserAgentInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserAgentInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#from(UserAgentInfo)} with {@code UserAgentInfo}.
   * <ul>
   *   <li>Then builder build ipAddress is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserAgentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UserAgentInfo) with 'UserAgentInfo'; then builder build ipAddress is '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserAgentInfo)"})
  void testBuilderFromWithUserAgentInfo_thenBuilderBuildIpAddressIs42MainSt() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();
    UserAgentInfo instance = mock(UserAgentInfo.class);
    when(instance.operatingSystem()).thenReturn("Operating System");
    when(instance.resolution()).thenReturn("Resolution");
    when(instance.loginTimestamp()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.userAgent()).thenReturn("User Agent");
    when(instance.ipAddress()).thenReturn("42 Main St");
    when(instance.userName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(UserAgentInfo)} with {@code UserAgentInfo}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserAgentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UserAgentInfo) with 'UserAgentInfo'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserAgentInfo)"})
  void testBuilderFromWithUserAgentInfo_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();
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
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   * <ul>
   *   <li>Given {@code janedoe}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(UserNameProvider) with 'UserNameProvider'; given 'janedoe'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider_givenJanedoe_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();
    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).userName();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ipAddress(String)}.
   * <p>
   * Method under test: {@link Builder#ipAddress(String)}
   */
  @Test
  @DisplayName("Test Builder ipAddress(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ipAddress(String)"})
  void testBuilderIpAddress() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ipAddress("42 Main St"));
  }

  /**
   * Test Builder {@link Builder#loginTimestamp(LocalDateTime)}.
   * <p>
   * Method under test: {@link Builder#loginTimestamp(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder loginTimestamp(LocalDateTime)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.loginTimestamp(LocalDateTime)"})
  void testBuilderLoginTimestamp() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay()));
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
    Builder builderResult = ImmutableUserAgentInfo.builder();

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
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.resolution("Resolution"));
  }

  /**
   * Test Builder {@link Builder#userAgent(String)}.
   * <p>
   * Method under test: {@link Builder#userAgent(String)}
   */
  @Test
  @DisplayName("Test Builder userAgent(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userAgent(String)"})
  void testBuilderUserAgent() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userAgent("User Agent"));
  }

  /**
   * Test Builder {@link Builder#userName(String)}.
   * <p>
   * Method under test: {@link Builder#userName(String)}
   */
  @Test
  @DisplayName("Test Builder userName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userName(String)"})
  void testBuilderUserName() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userName("janedoe"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setIpAddress(String)}
   *   <li>{@link Json#setLoginTimestamp(LocalDateTime)}
   *   <li>{@link Json#setOperatingSystem(String)}
   *   <li>{@link Json#setResolution(String)}
   *   <li>{@link Json#setUserAgent(String)}
   *   <li>{@link Json#setUserName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setIpAddress(String)",
      "void Json.setLoginTimestamp(LocalDateTime)", "void Json.setOperatingSystem(String)",
      "void Json.setResolution(String)", "void Json.setUserAgent(String)", "void Json.setUserName(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#ipAddress()}.
   * <p>
   * Method under test: {@link Json#ipAddress()}
   */
  @Test
  @DisplayName("Test Json ipAddress()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ipAddress()"})
  void testJsonIpAddress() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ipAddress());
  }

  /**
   * Test Json {@link Json#loginTimestamp()}.
   * <p>
   * Method under test: {@link Json#loginTimestamp()}
   */
  @Test
  @DisplayName("Test Json loginTimestamp()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.loginTimestamp()"})
  void testJsonLoginTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).loginTimestamp());
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

  /**
   * Test Json {@link Json#userAgent()}.
   * <p>
   * Method under test: {@link Json#userAgent()}
   */
  @Test
  @DisplayName("Test Json userAgent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userAgent()"})
  void testJsonUserAgent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userAgent());
  }

  /**
   * Test Json {@link Json#userName()}.
   * <p>
   * Method under test: {@link Json#userName()}
   */
  @Test
  @DisplayName("Test Json userName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userName()"})
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userName());
  }
}
