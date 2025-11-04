package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DocumentationHelperDiffblueTest {
  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "Base Path");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot4() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "/");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot5() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot6() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "screenshots");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot7() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot8() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot9() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot10() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot11() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "java.lang.String");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot12() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "42");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot13() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot14() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot15() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot16() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "/");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot17() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot18() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "screenshots");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot19() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot20() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot21() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot22() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot23() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "java.lang.String");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot24() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "42");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot25() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot26() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot27() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  void testTakeElemSnapshot28() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "1_Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "Base Path");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot4() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "/");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot5() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot6() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot7() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot8() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot9() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot10() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot11() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "java.lang.String");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot12() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "42");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot13() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot14() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot15() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot16() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "/");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot17() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot18() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot19() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot20() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot21() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot22() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot23() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "java.lang.String");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot24() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "42");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot25() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot26() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot27() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test:
   * {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  void testTakePageSnapshot28() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "1_Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot29() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "Base Path");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot30() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot31() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot32() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "/");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot33() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot34() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot35() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot36() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot37() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot38() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot39() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "java.lang.String");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot40() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot41() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot42() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot43() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot44() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "/");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot45() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot46() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot47() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot48() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot49() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot50() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot51() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "java.lang.String");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot52() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot53() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot54() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot55() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  void testTakePageSnapshot56() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<Page.ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "1_Name");

    // Assert
    verify(page).screenshot(isA(Page.ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#pause()}
   */
  @Test
  void testPause() {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "Base Path");

    // Act
    DocumentationHelper actualPauseResult = documentationHelper.pause();

    // Assert
    assertNull(documentationHelper.takeElemSnapshot(null, "Name"));
    assertNull(documentationHelper.takePageSnapshot((Page) null, "Name"));
    assertSame(documentationHelper, actualPauseResult);
  }

  /**
   * Method under test: {@link DocumentationHelper#resume()}
   */
  @Test
  void testResume() {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "Base Path");

    // Act and Assert
    assertSame(documentationHelper, documentationHelper.resume());
  }
}
