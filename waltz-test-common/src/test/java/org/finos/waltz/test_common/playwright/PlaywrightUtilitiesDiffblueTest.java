package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.RequestOptions;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlaywrightUtilitiesDiffblueTest {
  /**
   * Test {@link PlaywrightUtilities#takeScreenshot(Page, String)}.
   *
   * <p>Method under test: {@link PlaywrightUtilities#takeScreenshot(Page, String)}
   */
  @Test
  @DisplayName("Test takeScreenshot(Page, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlaywrightUtilities.takeScreenshot(Page, String)"})
  void testTakeScreenshot() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PlaywrightUtilities.takeScreenshot(page, "Path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
  }

  /**
   * Test {@link PlaywrightUtilities#waitAndTakeScreenshot(Page, Locator, String)}.
   *
   * <p>Method under test: {@link PlaywrightUtilities#waitAndTakeScreenshot(Page, Locator, String)}
   */
  @Test
  @DisplayName("Test waitAndTakeScreenshot(Page, Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlaywrightUtilities.waitAndTakeScreenshot(Page, Locator, String)"})
  void testWaitAndTakeScreenshot() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    Locator locator = mock(Locator.class);
    doNothing().when(locator).waitFor();

    // Act
    PlaywrightUtilities.waitAndTakeScreenshot(page, locator, "Image Path");

    // Assert
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
  }

  /**
   * Test {@link PlaywrightUtilities#login(Page, String)}.
   *
   * <ul>
   *   <li>Given {@link APIResponse} {@link APIResponse#text()} return {@code {"userName":"admin",
   *       "password": "password"}}.
   *   <li>Then calls {@link APIRequestContext#post(String, RequestOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link PlaywrightUtilities#login(Page, String)}
   */
  @Test
  @DisplayName(
      "Test login(Page, String); given APIResponse text() return '{\"userName\":\"admin\", \"password\": \"password\"}'; then calls post(String, RequestOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlaywrightUtilities.login(Page, String)"})
  void testLogin_givenAPIResponseTextReturnUserNameAdminPasswordPassword_thenCallsPost()
      throws IOException {
    // Arrange
    APIResponse apiResponse = mock(APIResponse.class);
    when(apiResponse.text()).thenReturn("{\"userName\":\"admin\", \"password\": \"password\"}");

    APIRequestContext apiRequestContext = mock(APIRequestContext.class);
    when(apiRequestContext.post(Mockito.<String>any(), Mockito.<RequestOptions>any()))
        .thenReturn(apiResponse);

    BrowserContext browserContext = mock(BrowserContext.class);
    doNothing().when(browserContext).setExtraHTTPHeaders(Mockito.<Map<String, String>>any());
    when(browserContext.request()).thenReturn(apiRequestContext);

    Page page = mock(Page.class);
    when(page.context()).thenReturn(browserContext);

    // Act
    PlaywrightUtilities.login(page, "Base");

    // Assert
    verify(apiRequestContext).post(eq("Base/authentication/login"), isA(RequestOptions.class));
    verify(apiResponse).text();
    verify(browserContext).request();
    verify(browserContext).setExtraHTTPHeaders(isA(Map.class));
    verify(page, atLeast(1)).context();
  }

  /**
   * Test {@link PlaywrightUtilities#login(Page, String)}.
   *
   * <ul>
   *   <li>When {@code ///}.
   *   <li>Then calls {@link APIRequestContext#post(String, RequestOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link PlaywrightUtilities#login(Page, String)}
   */
  @Test
  @DisplayName("Test login(Page, String); when '///'; then calls post(String, RequestOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlaywrightUtilities.login(Page, String)"})
  void testLogin_whenSlashSlashSlash_thenCallsPost() throws IOException {
    // Arrange
    APIResponse apiResponse = mock(APIResponse.class);
    when(apiResponse.text()).thenReturn("{\"userName\":\"admin\", \"password\": \"password\"}");

    APIRequestContext apiRequestContext = mock(APIRequestContext.class);
    when(apiRequestContext.post(Mockito.<String>any(), Mockito.<RequestOptions>any()))
        .thenReturn(apiResponse);

    BrowserContext browserContext = mock(BrowserContext.class);
    doNothing().when(browserContext).setExtraHTTPHeaders(Mockito.<Map<String, String>>any());
    when(browserContext.request()).thenReturn(apiRequestContext);

    Page page = mock(Page.class);
    when(page.context()).thenReturn(browserContext);

    // Act
    PlaywrightUtilities.login(page, "///");

    // Assert
    verify(apiRequestContext).post(eq("/authentication/login"), isA(RequestOptions.class));
    verify(apiResponse).text();
    verify(browserContext).request();
    verify(browserContext).setExtraHTTPHeaders(isA(Map.class));
    verify(page, atLeast(1)).context();
  }

  /**
   * Test {@link PlaywrightUtilities#login(Page, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then calls {@link APIRequestContext#post(String, RequestOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link PlaywrightUtilities#login(Page, String)}
   */
  @Test
  @DisplayName("Test login(Page, String); when '/'; then calls post(String, RequestOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlaywrightUtilities.login(Page, String)"})
  void testLogin_whenSlash_thenCallsPost() throws IOException {
    // Arrange
    APIResponse apiResponse = mock(APIResponse.class);
    when(apiResponse.text()).thenReturn("{\"userName\":\"admin\", \"password\": \"password\"}");

    APIRequestContext apiRequestContext = mock(APIRequestContext.class);
    when(apiRequestContext.post(Mockito.<String>any(), Mockito.<RequestOptions>any()))
        .thenReturn(apiResponse);

    BrowserContext browserContext = mock(BrowserContext.class);
    doNothing().when(browserContext).setExtraHTTPHeaders(Mockito.<Map<String, String>>any());
    when(browserContext.request()).thenReturn(apiRequestContext);

    Page page = mock(Page.class);
    when(page.context()).thenReturn(browserContext);

    // Act
    PlaywrightUtilities.login(page, "/");

    // Assert
    verify(apiRequestContext).post(eq("/authentication/login"), isA(RequestOptions.class));
    verify(apiResponse).text();
    verify(browserContext).request();
    verify(browserContext).setExtraHTTPHeaders(isA(Map.class));
    verify(page, atLeast(1)).context();
  }

  /**
   * Test {@link PlaywrightUtilities#mkEmbeddedFrag(Section, EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@code embed/internal/ALL/1/17}.
   * </ul>
   *
   * <p>Method under test: {@link PlaywrightUtilities#mkEmbeddedFrag(Section, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test mkEmbeddedFrag(Section, EntityReference); then return 'embed/internal/ALL/1/17'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlaywrightUtilities.mkEmbeddedFrag(Section, EntityReference)"})
  void testMkEmbeddedFrag_thenReturnEmbedInternalAll117() {
    // Arrange
    ImmutableEntityReference appRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(
        "embed/internal/ALL/1/17", PlaywrightUtilities.mkEmbeddedFrag(Section.APP_SURVEYS, appRef));
  }

  /**
   * Test {@link PlaywrightUtilities#toFrag(EntityReference)}.
   *
   * <p>Method under test: {@link PlaywrightUtilities#toFrag(EntityReference)}
   */
  @Test
  @DisplayName("Test toFrag(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlaywrightUtilities.toFrag(EntityReference)"})
  void testToFrag() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals("ALL/1", PlaywrightUtilities.toFrag(ref));
  }

  /**
   * Test {@link PlaywrightUtilities#toFrag(EntityReference)}.
   *
   * <p>Method under test: {@link PlaywrightUtilities#toFrag(EntityReference)}
   */
  @Test
  @DisplayName("Test toFrag(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PlaywrightUtilities.toFrag(EntityReference)"})
  void testToFrag2() {
    // Arrange
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals("ALL/1", PlaywrightUtilities.toFrag(ref));
  }
}
