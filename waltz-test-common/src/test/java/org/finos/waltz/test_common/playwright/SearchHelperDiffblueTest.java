package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchHelperDiffblueTest {
  /**
   * Test {@link SearchHelper#SearchHelper(Page)}.
   * <p>
   * Method under test: {@link SearchHelper#SearchHelper(Page)}
   */
  @Test
  @DisplayName("Test new SearchHelper(Page)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchHelper.<init>(Page)"})
  void testNewSearchHelper() {
    // Arrange, Act and Assert
    assertNull((new SearchHelper(mock(Page.class))).getSearchResultsPanel());
  }

  /**
   * Test {@link SearchHelper#search(String)}.
   * <p>
   * Method under test: {@link SearchHelper#search(String)}
   */
  @Test
  @DisplayName("Test search(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator SearchHelper.search(String)"})
  void testSearch() {
    // Arrange
    Locator locator = mock(Locator.class);
    doNothing().when(locator).click();
    Locator locator2 = mock(Locator.class);
    doNothing().when(locator2).fill(Mockito.<String>any());
    Locator locator3 = mock(Locator.class);
    when(locator3.locator(Mockito.<String>any())).thenReturn(locator2);
    when(locator3.getByTestId(Mockito.<String>any())).thenReturn(locator);
    Page page = mock(Page.class);
    when(page.locator(Mockito.<String>any())).thenReturn(locator3);

    // Act
    (new SearchHelper(page)).search("Qry");

    // Assert
    verify(locator).click();
    verify(locator2).fill(eq("Qry"));
    verify(locator3).getByTestId(eq("search-button"));
    verify(locator3).locator(eq("input[type=search]"));
    verify(page, atLeast(1)).locator(Mockito.<String>any());
  }

  /**
   * Test {@link SearchHelper#waitForResult(String)}.
   * <p>
   * Method under test: {@link SearchHelper#waitForResult(String)}
   */
  @Test
  @DisplayName("Test waitForResult(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator SearchHelper.waitForResult(String)"})
  void testWaitForResult() {
    // Arrange
    Locator locator = mock(Locator.class);
    doNothing().when(locator).waitFor();
    Locator locator2 = mock(Locator.class);
    when(locator2.getByText(Mockito.<String>any())).thenReturn(locator);
    Locator locator3 = mock(Locator.class);
    when(locator3.getByTestId(Mockito.<String>any())).thenReturn(locator2);
    Page page = mock(Page.class);
    when(page.locator(Mockito.<String>any())).thenReturn(locator3);

    // Act
    (new SearchHelper(page)).waitForResult("Name");

    // Assert
    verify(locator3).getByTestId(eq("entity-name"));
    verify(locator2).getByText(eq("Name"));
    verify(locator).waitFor();
    verify(page).locator(eq(".wnso-search-results"));
  }

  /**
   * Test {@link SearchHelper#getSearchResultsPanel()}.
   * <p>
   * Method under test: {@link SearchHelper#getSearchResultsPanel()}
   */
  @Test
  @DisplayName("Test getSearchResultsPanel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator SearchHelper.getSearchResultsPanel()"})
  void testGetSearchResultsPanel() {
    // Arrange
    Page page = mock(Page.class);
    when(page.locator(Mockito.<String>any())).thenReturn(mock(Locator.class));

    // Act
    (new SearchHelper(page)).getSearchResultsPanel();

    // Assert
    verify(page).locator(eq(".wnso-search-results"));
  }
}
