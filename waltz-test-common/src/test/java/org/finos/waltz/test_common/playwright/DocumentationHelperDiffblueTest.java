package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DocumentationHelperDiffblueTest {
  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Cannot convert empty or null segments to path");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), ": Predicate was null");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot4() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Array must be provided");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot5() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(
            mock(Page.class), "org.finos.waltz.test_common.playwright.DocumentationHelper");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot6() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Predicate must be provided");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       {@code Base Path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePath()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Base Path");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code 1_///}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '1_///'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIs1()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "1_///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIs42()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "42");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsArrayWasNull()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), ": Array was null");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsDS()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "%d_%s");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsScreenshots()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "screenshots");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code /+}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlashPlusSign()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "///");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code /}.
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash_when42()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "42");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code /}.
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash_whenDS()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code /}.
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash_whenName()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       {@code Base Path}.
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and 'Base Path'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePath_whenName()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Base Path");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_when42() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "42");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_when422() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "42");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayMustBeProvided() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayMustBeProvided2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayMustBeProvided3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayWasNull() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayWasNull2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayWasNull3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenCannotConvertEmptyOrNullSegmentsToPath()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(
            locator, "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenCannotConvertEmptyOrNullSegmentsToPath2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(
            locator, "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenCannotConvertEmptyOrNullSegmentsToPath3()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(
            locator, "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenDS() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenDS2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenEmptyString2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenEmptyString3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenName() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenName2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult = documentationHelper.takeElemSnapshot(locator, "Name");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code DocumentationHelper}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); when 'org.finos.waltz.test_common.playwright.DocumentationHelper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenOrgFinosWaltzTestCommonPlaywrightDocumentationHelper()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(
            locator, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code DocumentationHelper}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); when 'org.finos.waltz.test_common.playwright.DocumentationHelper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenOrgFinosWaltzTestCommonPlaywrightDocumentationHelper2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(
            locator, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code DocumentationHelper}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takeElemSnapshot(Locator, String); when 'org.finos.waltz.test_common.playwright.DocumentationHelper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenOrgFinosWaltzTestCommonPlaywrightDocumentationHelper3()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(
            locator, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateMustBeProvided() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateMustBeProvided2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateMustBeProvided3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateWasNull() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateWasNull2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateWasNull3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenScreenshots() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "screenshots");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenScreenshots2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "screenshots");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenScreenshots3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Locator locator = mock(Locator.class);
    when(locator.screenshot(Mockito.<Locator.ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Locator actualTakeElemSnapshotResult =
        documentationHelper.takeElemSnapshot(locator, "screenshots");

    // Assert
    verify(locator).screenshot(isA(Locator.ScreenshotOptions.class));
    assertSame(locator, actualTakeElemSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "%d_%s");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "screenshots");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName4() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper =
        new DocumentationHelper(page, "Cannot convert empty or null segments to path");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName5() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, ": Array was null");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName6() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, ": Predicate was null");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName7() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper =
        new DocumentationHelper(page, "Array must be provided");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName8() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper =
        new DocumentationHelper(page, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName9() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "42");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName10() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper =
        new DocumentationHelper(page, "Predicate must be provided");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName11() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            locator, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName12() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName13() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            locator, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName14() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName15() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            locator, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName16() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "1_///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       {@code Base Path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_givenDocumentationHelperWithPageAndBasePath()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "Base Path");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       {@code Base Path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_givenDocumentationHelperWithPageAndBasePath2()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "Base Path");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "///");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_when42() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "42");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_when422() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "42");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_when423() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "42");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayMustBeProvided()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayMustBeProvided2()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayMustBeProvided3()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayWasNull() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayWasNull2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayWasNull3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenCannotConvertEmptyOrNullSegmentsToPath()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            locator, "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenCannotConvertEmptyOrNullSegmentsToPath2()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            locator, "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenCannotConvertEmptyOrNullSegmentsToPath3()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            locator, "Cannot convert empty or null segments to path");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenDS() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenDS2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenDS3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "%d_%s");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenEmptyString2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenEmptyString3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenName() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenName2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenName3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateMustBeProvided()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateMustBeProvided2()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateMustBeProvided3()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateWasNull()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateWasNull2()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateWasNull3()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenScreenshots() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "///");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenScreenshots2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenScreenshots3() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");

    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "screenshots");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Cannot convert empty or null segments to path");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName4() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), ": Array was null");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName5() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), ": Predicate was null");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName6() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Array must be provided");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName7() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(
            mock(Page.class), "org.finos.waltz.test_common.playwright.DocumentationHelper");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName8() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Predicate must be provided");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName9() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            page, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName10() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName11() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            page, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName12() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName13() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(
            page, "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       {@code Base Path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_givenDocumentationHelperWithPageAndBasePath()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Base Path");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       {@code Base Path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_givenDocumentationHelperWithPageAndBasePath2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Base Path");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code 1_///}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; given DocumentationHelper(Page, String) with Page and basePath is '1_///'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_givenDocumentationHelperWithPageAndBasePathIs1()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "1_///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; given DocumentationHelper(Page, String) with Page and basePath is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_givenDocumentationHelperWithPageAndBasePathIs42()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "42");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and
   *       basePath is {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; given DocumentationHelper(Page, String) with Page and basePath is '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_givenDocumentationHelperWithPageAndBasePathIsDS()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "%d_%s");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "///");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_when42() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_when422() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_when423() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayMustBeProvided()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayMustBeProvided2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayMustBeProvided3()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayWasNull() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayWasNull2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayWasNull3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenCannotConvertEmptyOrNullSegmentsToPath()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenCannotConvertEmptyOrNullSegmentsToPath2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenCannotConvertEmptyOrNullSegmentsToPath3()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenDS() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenDS2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code %d_%s}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '%d_%s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenDS3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenEmptyString2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenEmptyString3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenName() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenName2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenName3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateMustBeProvided()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateMustBeProvided2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateMustBeProvided3()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateWasNull() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateWasNull2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName(
      "Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateWasNull3()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult =
        documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenScreenshots() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "///");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenScreenshots2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code
   * name}.
   *
   * <ul>
   *   <li>When {@code screenshots}.
   * </ul>
   *
   * <p>Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'screenshots'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenScreenshots3() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");

    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#pause()}.
   *
   * <p>Method under test: {@link DocumentationHelper#pause()}
   */
  @Test
  @DisplayName("Test pause()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DocumentationHelper DocumentationHelper.pause()"})
  void testPause() {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Base Path");

    // Act
    DocumentationHelper actualPauseResult = documentationHelper.pause();

    // Assert
    assertNull(documentationHelper.takeElemSnapshot(null, "Name"));
    assertNull(documentationHelper.takePageSnapshot((Page) null, "Name"));
    assertSame(documentationHelper, actualPauseResult);
  }

  /**
   * Test {@link DocumentationHelper#resume()}.
   *
   * <p>Method under test: {@link DocumentationHelper#resume()}
   */
  @Test
  @DisplayName("Test resume()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DocumentationHelper DocumentationHelper.resume()"})
  void testResume() {
    // Arrange
    DocumentationHelper documentationHelper =
        new DocumentationHelper(mock(Page.class), "Base Path");

    // Act
    DocumentationHelper actualResumeResult = documentationHelper.resume();

    // Assert
    assertSame(documentationHelper, actualResumeResult);
  }
}
