package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlaywrightUtilitiesDiffblueTest {
  /**
   * Test {@link PlaywrightUtilities#takeScreenshot(Page, String)}.
   * <p>
   * Method under test: {@link PlaywrightUtilities#takeScreenshot(Page, String)}
   */
  @Test
  @DisplayName("Test takeScreenshot(Page, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PlaywrightUtilities.takeScreenshot(Page, String)"})
  void testTakeScreenshot() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PlaywrightUtilities.takeScreenshot(page, "Path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
  }

  /**
   * Test {@link PlaywrightUtilities#waitAndTakeScreenshot(Page, Locator, String)}.
   * <p>
   * Method under test: {@link PlaywrightUtilities#waitAndTakeScreenshot(Page, Locator, String)}
   */
  @Test
  @DisplayName("Test waitAndTakeScreenshot(Page, Locator, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PlaywrightUtilities.waitAndTakeScreenshot(Page, Locator, String)"})
  void testWaitAndTakeScreenshot() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * <ul>
   *   <li>Given {@link APIResponse} {@link APIResponse#text()} return {@code {"userName":"admin", "password": "password"}}.</li>
   *   <li>Then calls {@link APIRequestContext#post(String, RequestOptions)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlaywrightUtilities#login(Page, String)}
   */
  @Test
  @DisplayName("Test login(Page, String); given APIResponse text() return '{\"userName\":\"admin\", \"password\": \"password\"}'; then calls post(String, RequestOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PlaywrightUtilities.login(Page, String)"})
  void testLogin_givenAPIResponseTextReturnUserNameAdminPasswordPassword_thenCallsPost() throws IOException {
    // Arrange
    APIResponse apiResponse = mock(APIResponse.class);
    when(apiResponse.text()).thenReturn("{\"userName\":\"admin\", \"password\": \"password\"}");
    APIRequestContext apiRequestContext = mock(APIRequestContext.class);
    when(apiRequestContext.post(Mockito.<String>any(), Mockito.<RequestOptions>any())).thenReturn(apiResponse);
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
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then calls {@link APIRequestContext#post(String, RequestOptions)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlaywrightUtilities#login(Page, String)}
   */
  @Test
  @DisplayName("Test login(Page, String); when '/'; then calls post(String, RequestOptions)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PlaywrightUtilities.login(Page, String)"})
  void testLogin_whenSlash_thenCallsPost() throws IOException {
    // Arrange
    APIResponse apiResponse = mock(APIResponse.class);
    when(apiResponse.text()).thenReturn("{\"userName\":\"admin\", \"password\": \"password\"}");
    APIRequestContext apiRequestContext = mock(APIRequestContext.class);
    when(apiRequestContext.post(Mockito.<String>any(), Mockito.<RequestOptions>any())).thenReturn(apiResponse);
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
   * <p>
   * Method under test: {@link PlaywrightUtilities#mkEmbeddedFrag(Section, EntityReference)}
   */
  @Test
  @DisplayName("Test mkEmbeddedFrag(Section, EntityReference)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PlaywrightUtilities.mkEmbeddedFrag(Section, EntityReference)"})
  void testMkEmbeddedFrag() {
    // Arrange
    EntityReference appRef = mock(EntityReference.class);
    when(appRef.id()).thenReturn(1L);
    when(appRef.kind()).thenReturn(EntityKind.ALL);

    // Act
    String actualMkEmbeddedFragResult = PlaywrightUtilities.mkEmbeddedFrag(Section.APP_SURVEYS, appRef);

    // Assert
    verify(appRef).id();
    verify(appRef).kind();
    assertEquals("embed/internal/ALL/1/17", actualMkEmbeddedFragResult);
  }

  /**
   * Test {@link PlaywrightUtilities#toFrag(EntityReference)}.
   * <p>
   * Method under test: {@link PlaywrightUtilities#toFrag(EntityReference)}
   */
  @Test
  @DisplayName("Test toFrag(EntityReference)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PlaywrightUtilities.toFrag(EntityReference)"})
  void testToFrag() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    String actualToFragResult = PlaywrightUtilities.toFrag(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    assertEquals("ALL/1", actualToFragResult);
  }

  /**
   * Test {@link PlaywrightUtilities#logAppLink(EntityReference)}.
   * <p>
   * Method under test: {@link PlaywrightUtilities#logAppLink(EntityReference)}
   */
  @Test
  @DisplayName("Test logAppLink(EntityReference)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PlaywrightUtilities.logAppLink(EntityReference)"})
  void testLogAppLink() {
    // Arrange
    EntityReference appRef = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(appRef.name()).thenReturn(ofResult);
    when(appRef.id()).thenReturn(1L);

    // Act
    PlaywrightUtilities.logAppLink(appRef);

    // Assert
    verify(appRef).id();
    verify(appRef).name();
  }
}
