package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SearchHelperDiffblueTest {
  /**
   * Method under test: {@link SearchHelper#search(String)}
   */
  @Test
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
   * Method under test: {@link SearchHelper#waitForResult(String)}
   */
  @Test
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
   * Method under test: {@link SearchHelper#getSearchResultsPanel()}
   */
  @Test
  void testGetSearchResultsPanel() {
    // Arrange
    Page page = mock(Page.class);
    when(page.locator(Mockito.<String>any())).thenReturn(mock(Locator.class));

    // Act
    (new SearchHelper(page)).getSearchResultsPanel();

    // Assert
    verify(page).locator(eq(".wnso-search-results"));
  }

  /**
   * Method under test: {@link SearchHelper#SearchHelper(Page)}
   */
  @Test
  void testNewSearchHelper() {
    // Arrange, Act and Assert
    assertNull((new SearchHelper(mock(Page.class))).getSearchResultsPanel());
  }
}
