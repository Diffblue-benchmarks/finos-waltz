package org.finos.waltz.model.user_agent_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    LocalDateTime loginTimestamp = LocalDate.of(1970, 1, 1).atStartOfDay();

    // Act
    ImmutableUserAgentInfo actualImmutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(loginTimestamp)
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Assert
    assertEquals("42 Main St", actualImmutableUserAgentInfo.ipAddress());
    assertEquals("Operating System", actualImmutableUserAgentInfo.operatingSystem());
    assertEquals("Resolution", actualImmutableUserAgentInfo.resolution());
    assertEquals("User Agent", actualImmutableUserAgentInfo.userAgent());
    assertEquals("janedoe", actualImmutableUserAgentInfo.userName());
    assertSame(loginTimestamp, actualImmutableUserAgentInfo.loginTimestamp());
  }

  /**
   * Test Builder {@link Builder#from(UserAgentInfo)} with {@code UserAgentInfo}.
   *
   * <p>Method under test: {@link Builder#from(UserAgentInfo)}
   */
  @Test
  @DisplayName("Test Builder from(UserAgentInfo) with 'UserAgentInfo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserAgentInfo)"})
  void testBuilderFromWithUserAgentInfo() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();
    ImmutableUserAgentInfo instance =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUserAgentInfo actualImmutableUserAgentInfo = builderResult.build();
    assertEquals(instance, actualImmutableUserAgentInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   *
   * <p>Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(UserNameProvider) with 'UserNameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();
    ImmutableUserAgentInfo instance =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    ImmutableUserAgentInfo actualImmutableUserAgentInfo =
        builderResult.from((UserNameProvider) instance).build();
    assertEquals(instance, actualImmutableUserAgentInfo);
    ImmutableUserAgentInfo actualImmutableUserAgentInfo2 = builderResult.build();
    assertEquals(instance, actualImmutableUserAgentInfo2);
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   *
   * <ul>
   *   <li>Given {@code janedoe}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UserNameProvider) with 'UserNameProvider'; given 'janedoe'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code 42 Main St}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ipAddress(String)}
   */
  @Test
  @DisplayName("Test Builder ipAddress(String); when '42 Main St'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ipAddress(String)"})
  void testBuilderIpAddress_when42MainSt_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act
    Builder actualIpAddressResult = builderResult.ipAddress("42 Main St");

    // Assert
    assertSame(builderResult, actualIpAddressResult);
  }

  /**
   * Test Builder {@link Builder#loginTimestamp(LocalDateTime)}.
   *
   * <p>Method under test: {@link Builder#loginTimestamp(LocalDateTime)}
   */
  @Test
  @DisplayName("Test Builder loginTimestamp(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.loginTimestamp(LocalDateTime)"})
  void testBuilderLoginTimestamp() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act
    Builder actualLoginTimestampResult =
        builderResult.loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(builderResult, actualLoginTimestampResult);
  }

  /**
   * Test Builder {@link Builder#operatingSystem(String)}.
   *
   * <ul>
   *   <li>When {@code Operating System}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operatingSystem(String)}
   */
  @Test
  @DisplayName("Test Builder operatingSystem(String); when 'Operating System'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operatingSystem(String)"})
  void testBuilderOperatingSystem_whenOperatingSystem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act
    Builder actualOperatingSystemResult = builderResult.operatingSystem("Operating System");

    // Assert
    assertSame(builderResult, actualOperatingSystemResult);
  }

  /**
   * Test Builder {@link Builder#resolution(String)}.
   *
   * <ul>
   *   <li>When {@code Resolution}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#resolution(String)}
   */
  @Test
  @DisplayName("Test Builder resolution(String); when 'Resolution'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resolution(String)"})
  void testBuilderResolution_whenResolution_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act
    Builder actualResolutionResult = builderResult.resolution("Resolution");

    // Assert
    assertSame(builderResult, actualResolutionResult);
  }

  /**
   * Test Builder {@link Builder#userAgent(String)}.
   *
   * <ul>
   *   <li>When {@code User Agent}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userAgent(String)}
   */
  @Test
  @DisplayName("Test Builder userAgent(String); when 'User Agent'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userAgent(String)"})
  void testBuilderUserAgent_whenUserAgent_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act
    Builder actualUserAgentResult = builderResult.userAgent("User Agent");

    // Assert
    assertSame(builderResult, actualUserAgentResult);
  }

  /**
   * Test Builder {@link Builder#userName(String)}.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userName(String)}
   */
  @Test
  @DisplayName("Test Builder userName(String); when 'janedoe'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userName(String)"})
  void testBuilderUserName_whenJanedoe_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUserAgentInfo.builder();

    // Act
    Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertSame(builderResult, actualUserNameResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#copyOf(UserAgentInfo)}.
   *
   * <ul>
   *   <li>Then return loginTimestamp toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#copyOf(UserAgentInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(UserAgentInfo); then return loginTimestamp toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.copyOf(UserAgentInfo)"})
  void testCopyOf_thenReturnLoginTimestampToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableUserAgentInfo instance =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    ImmutableUserAgentInfo actualCopyOfResult = ImmutableUserAgentInfo.copyOf(instance);

    // Assert
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
   * Test {@link ImmutableUserAgentInfo#equals(Object)}, and {@link
   * ImmutableUserAgentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserAgentInfo#equals(Object)}
   *   <li>{@link ImmutableUserAgentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();
    ImmutableUserAgentInfo immutableUserAgentInfo2 =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertEquals(immutableUserAgentInfo, immutableUserAgentInfo2);
    assertEquals(immutableUserAgentInfo.hashCode(), immutableUserAgentInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}, and {@link
   * ImmutableUserAgentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserAgentInfo#equals(Object)}
   *   <li>{@link ImmutableUserAgentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertEquals(immutableUserAgentInfo, immutableUserAgentInfo);
    int expectedHashCodeResult = immutableUserAgentInfo.hashCode();
    assertEquals(expectedHashCodeResult, immutableUserAgentInfo.hashCode());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("17 High St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserAgentInfo,
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.now().atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserAgentInfo,
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("janedoe")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserAgentInfo,
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("janedoe")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserAgentInfo,
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("janedoe")
            .userName("janedoe")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserAgentInfo,
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("User Agent")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableUserAgentInfo,
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableUserAgentInfo.equals(Object)",
    "int ImmutableUserAgentInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build(),
        "Different type to ImmutableUserAgentInfo");
  }

  /**
   * Test {@link ImmutableUserAgentInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ipAddress is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ipAddress is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.fromJson(Json)"})
  void testFromJson_thenReturnIpAddressIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setUserAgent("Json");
    json.setResolution("Json");
    json.setOperatingSystem("Json");
    json.setIpAddress("Json");
    json.setLoginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableUserAgentInfo actualFromJsonResult = ImmutableUserAgentInfo.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.ipAddress());
    assertEquals("Json", actualFromJsonResult.operatingSystem());
    assertEquals("Json", actualFromJsonResult.resolution());
    assertEquals("Json", actualFromJsonResult.userAgent());
    assertEquals("Json", actualFromJsonResult.userName());
    LocalDateTime expectedLoginTimestampResult = json.loginTimestamp;
    assertSame(expectedLoginTimestampResult, actualFromJsonResult.loginTimestamp());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUserAgentInfo#toString()}
   *   <li>{@link ImmutableUserAgentInfo#ipAddress()}
   *   <li>{@link ImmutableUserAgentInfo#loginTimestamp()}
   *   <li>{@link ImmutableUserAgentInfo#operatingSystem()}
   *   <li>{@link ImmutableUserAgentInfo#resolution()}
   *   <li>{@link ImmutableUserAgentInfo#userAgent()}
   *   <li>{@link ImmutableUserAgentInfo#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableUserAgentInfo.ipAddress()",
    "LocalDateTime ImmutableUserAgentInfo.loginTimestamp()",
    "String ImmutableUserAgentInfo.operatingSystem()",
    "String ImmutableUserAgentInfo.resolution()",
    "String ImmutableUserAgentInfo.toString()",
    "String ImmutableUserAgentInfo.userAgent()",
    "String ImmutableUserAgentInfo.userName()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    String actualToStringResult = immutableUserAgentInfo.toString();
    String actualIpAddressResult = immutableUserAgentInfo.ipAddress();
    LocalDateTime actualLoginTimestampResult = immutableUserAgentInfo.loginTimestamp();
    String actualOperatingSystemResult = immutableUserAgentInfo.operatingSystem();
    String actualResolutionResult = immutableUserAgentInfo.resolution();
    String actualUserAgentResult = immutableUserAgentInfo.userAgent();

    // Assert
    assertEquals("00:00", actualLoginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLoginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42 Main St", actualIpAddressResult);
    assertEquals("Operating System", actualOperatingSystemResult);
    assertEquals("Resolution", actualResolutionResult);
    assertEquals("User Agent", actualUserAgentResult);
    assertEquals(
        "UserAgentInfo{userName=janedoe, userAgent=User Agent, resolution=Resolution, operatingSystem=Operating"
            + " System, ipAddress=42 Main St, loginTimestamp=1970-01-01T00:00}",
        actualToStringResult);
    assertEquals("janedoe", immutableUserAgentInfo.userName());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setIpAddress(String)",
    "void Json.setLoginTimestamp(LocalDateTime)",
    "void Json.setOperatingSystem(String)",
    "void Json.setResolution(String)",
    "void Json.setUserAgent(String)",
    "void Json.setUserName(String)"
  })
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
   *
   * <p>Method under test: {@link Json#ipAddress()}
   */
  @Test
  @DisplayName("Test Json ipAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ipAddress()"})
  void testJsonIpAddress() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ipAddress());
  }

  /**
   * Test Json {@link Json#loginTimestamp()}.
   *
   * <p>Method under test: {@link Json#loginTimestamp()}
   */
  @Test
  @DisplayName("Test Json loginTimestamp()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.loginTimestamp()"})
  void testJsonLoginTimestamp() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().loginTimestamp());
  }

  /**
   * Test Json {@link Json#operatingSystem()}.
   *
   * <p>Method under test: {@link Json#operatingSystem()}
   */
  @Test
  @DisplayName("Test Json operatingSystem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.operatingSystem()"})
  void testJsonOperatingSystem() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operatingSystem());
  }

  /**
   * Test Json {@link Json#resolution()}.
   *
   * <p>Method under test: {@link Json#resolution()}
   */
  @Test
  @DisplayName("Test Json resolution()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.resolution()"})
  void testJsonResolution() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().resolution());
  }

  /**
   * Test Json {@link Json#userAgent()}.
   *
   * <p>Method under test: {@link Json#userAgent()}
   */
  @Test
  @DisplayName("Test Json userAgent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userAgent()"})
  void testJsonUserAgent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userAgent());
  }

  /**
   * Test Json {@link Json#userName()}.
   *
   * <p>Method under test: {@link Json#userName()}
   */
  @Test
  @DisplayName("Test Json userName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userName()"})
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userName());
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withIpAddress(String)}.
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withIpAddress(String)}
   */
  @Test
  @DisplayName("Test withIpAddress(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withIpAddress(String)"})
  void testWithIpAddress() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    ImmutableUserAgentInfo actualWithIpAddressResult = immutableUserAgentInfo.withIpAddress("42");

    // Assert
    assertSame(immutableUserAgentInfo, actualWithIpAddressResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withIpAddress(String)}.
   *
   * <ul>
   *   <li>Then return loginTimestamp toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withIpAddress(String)}
   */
  @Test
  @DisplayName(
      "Test withIpAddress(String); then return loginTimestamp toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withIpAddress(String)"})
  void testWithIpAddress_thenReturnLoginTimestampToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableUserAgentInfo actualWithIpAddressResult =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build()
            .withIpAddress("42");

    // Assert
    LocalDateTime loginTimestampResult = actualWithIpAddressResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithIpAddressResult.ipAddress());
    assertEquals("Operating System", actualWithIpAddressResult.operatingSystem());
    assertEquals("Resolution", actualWithIpAddressResult.resolution());
    assertEquals("User Agent", actualWithIpAddressResult.userAgent());
    assertEquals("janedoe", actualWithIpAddressResult.userName());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withLoginTimestamp(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withLoginTimestamp(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLoginTimestamp(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableUserAgentInfo ImmutableUserAgentInfo.withLoginTimestamp(LocalDateTime)"
  })
  void testWithLoginTimestamp() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    ImmutableUserAgentInfo actualWithLoginTimestampResult =
        immutableUserAgentInfo.withLoginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableUserAgentInfo, actualWithLoginTimestampResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withOperatingSystem(String)}.
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withOperatingSystem(String)}
   */
  @Test
  @DisplayName("Test withOperatingSystem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withOperatingSystem(String)"})
  void testWithOperatingSystem() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("42")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    ImmutableUserAgentInfo actualWithOperatingSystemResult =
        immutableUserAgentInfo.withOperatingSystem("42");

    // Assert
    assertSame(immutableUserAgentInfo, actualWithOperatingSystemResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withOperatingSystem(String)}.
   *
   * <ul>
   *   <li>Then return loginTimestamp toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withOperatingSystem(String)}
   */
  @Test
  @DisplayName(
      "Test withOperatingSystem(String); then return loginTimestamp toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withOperatingSystem(String)"})
  void testWithOperatingSystem_thenReturnLoginTimestampToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableUserAgentInfo actualWithOperatingSystemResult =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build()
            .withOperatingSystem("42");

    // Assert
    LocalDateTime loginTimestampResult = actualWithOperatingSystemResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42 Main St", actualWithOperatingSystemResult.ipAddress());
    assertEquals("42", actualWithOperatingSystemResult.operatingSystem());
    assertEquals("Resolution", actualWithOperatingSystemResult.resolution());
    assertEquals("User Agent", actualWithOperatingSystemResult.userAgent());
    assertEquals("janedoe", actualWithOperatingSystemResult.userName());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withResolution(String)}.
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withResolution(String)}
   */
  @Test
  @DisplayName("Test withResolution(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withResolution(String)"})
  void testWithResolution() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("42")
            .userAgent("User Agent")
            .userName("janedoe")
            .build();

    // Act
    ImmutableUserAgentInfo actualWithResolutionResult = immutableUserAgentInfo.withResolution("42");

    // Assert
    assertSame(immutableUserAgentInfo, actualWithResolutionResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withResolution(String)}.
   *
   * <ul>
   *   <li>Then return loginTimestamp toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withResolution(String)}
   */
  @Test
  @DisplayName(
      "Test withResolution(String); then return loginTimestamp toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withResolution(String)"})
  void testWithResolution_thenReturnLoginTimestampToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableUserAgentInfo actualWithResolutionResult =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build()
            .withResolution("42");

    // Assert
    LocalDateTime loginTimestampResult = actualWithResolutionResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42 Main St", actualWithResolutionResult.ipAddress());
    assertEquals("42", actualWithResolutionResult.resolution());
    assertEquals("Operating System", actualWithResolutionResult.operatingSystem());
    assertEquals("User Agent", actualWithResolutionResult.userAgent());
    assertEquals("janedoe", actualWithResolutionResult.userName());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withUserAgent(String)}.
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withUserAgent(String)}
   */
  @Test
  @DisplayName("Test withUserAgent(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withUserAgent(String)"})
  void testWithUserAgent() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("42")
            .userName("janedoe")
            .build();

    // Act
    ImmutableUserAgentInfo actualWithUserAgentResult = immutableUserAgentInfo.withUserAgent("42");

    // Assert
    assertSame(immutableUserAgentInfo, actualWithUserAgentResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withUserAgent(String)}.
   *
   * <ul>
   *   <li>Then return loginTimestamp toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withUserAgent(String)}
   */
  @Test
  @DisplayName(
      "Test withUserAgent(String); then return loginTimestamp toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withUserAgent(String)"})
  void testWithUserAgent_thenReturnLoginTimestampToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableUserAgentInfo actualWithUserAgentResult =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build()
            .withUserAgent("42");

    // Assert
    LocalDateTime loginTimestampResult = actualWithUserAgentResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42 Main St", actualWithUserAgentResult.ipAddress());
    assertEquals("42", actualWithUserAgentResult.userAgent());
    assertEquals("Operating System", actualWithUserAgentResult.operatingSystem());
    assertEquals("Resolution", actualWithUserAgentResult.resolution());
    assertEquals("janedoe", actualWithUserAgentResult.userName());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withUserName(String)}.
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withUserName(String)}
   */
  @Test
  @DisplayName("Test withUserName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withUserName(String)"})
  void testWithUserName() {
    // Arrange
    ImmutableUserAgentInfo immutableUserAgentInfo =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("42")
            .build();

    // Act
    ImmutableUserAgentInfo actualWithUserNameResult = immutableUserAgentInfo.withUserName("42");

    // Assert
    assertSame(immutableUserAgentInfo, actualWithUserNameResult);
  }

  /**
   * Test {@link ImmutableUserAgentInfo#withUserName(String)}.
   *
   * <ul>
   *   <li>Then return loginTimestamp toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUserAgentInfo#withUserName(String)}
   */
  @Test
  @DisplayName(
      "Test withUserName(String); then return loginTimestamp toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUserAgentInfo ImmutableUserAgentInfo.withUserName(String)"})
  void testWithUserName_thenReturnLoginTimestampToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableUserAgentInfo actualWithUserNameResult =
        ImmutableUserAgentInfo.builder()
            .ipAddress("42 Main St")
            .loginTimestamp(ofResult.atStartOfDay())
            .operatingSystem("Operating System")
            .resolution("Resolution")
            .userAgent("User Agent")
            .userName("janedoe")
            .build()
            .withUserName("42");

    // Assert
    LocalDateTime loginTimestampResult = actualWithUserNameResult.loginTimestamp();
    assertEquals("00:00", loginTimestampResult.toLocalTime().toString());
    LocalDate toLocalDateResult = loginTimestampResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42 Main St", actualWithUserNameResult.ipAddress());
    assertEquals("42", actualWithUserNameResult.userName());
    assertEquals("Operating System", actualWithUserNameResult.operatingSystem());
    assertEquals("Resolution", actualWithUserNameResult.resolution());
    assertEquals("User Agent", actualWithUserNameResult.userAgent());
    assertSame(ofResult, toLocalDateResult);
  }
}
