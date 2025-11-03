package org.finos.waltz.test_common.playwright;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and basePath is {@code /}.</li>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash_when42()
      throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and basePath is {@code /}.</li>
   *   <li>When {@code %d_%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'; when '%d_%s'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash_whenDS()
      throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and basePath is {@code /}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and basePath is '/'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePathIsSlash_whenName()
      throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and {@code Base Path}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); given DocumentationHelper(Page, String) with Page and 'Base Path'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_givenDocumentationHelperWithPageAndBasePath_whenName() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code 1_Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '1_Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_when1Name() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_when42() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayMustBeProvided() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayMustBeProvided2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayWasNull() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenArrayWasNull2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenCannotConvertEmptyOrNullSegmentsToPath() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenCannotConvertEmptyOrNullSegmentsToPath2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code %d_%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '%d_%s'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenDS() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenEmptyString() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenEmptyString2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenJavaLangString() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenJavaLangString2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenName() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code DocumentationHelper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'org.finos.waltz.test_common.playwright.DocumentationHelper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenOrgFinosWaltzTestCommonPlaywrightDocumentationHelper()
      throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code DocumentationHelper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'org.finos.waltz.test_common.playwright.DocumentationHelper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenOrgFinosWaltzTestCommonPlaywrightDocumentationHelper2()
      throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateMustBeProvided() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateMustBeProvided2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code : Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateWasNull() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code : Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when ': Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenPredicateWasNull2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code screenshots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'screenshots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenScreenshots() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code screenshots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when 'screenshots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenScreenshots2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenSlash() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takeElemSnapshot(Locator, String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takeElemSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takeElemSnapshot(Locator, String); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takeElemSnapshot(Locator, String)"})
  void testTakeElemSnapshot_whenSlash2() throws UnsupportedEncodingException {
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and {@code Base Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_givenDocumentationHelperWithPageAndBasePath()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code 1_Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '1_Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_when1Name() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "1_Name");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_when42() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_when422() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayMustBeProvided() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayMustBeProvided2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Array must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayWasNull() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenArrayWasNull2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Array was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenCannotConvertEmptyOrNullSegmentsToPath()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenCannotConvertEmptyOrNullSegmentsToPath2()
      throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code %d_%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '%d_%s'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenDS() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code %d_%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '%d_%s'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenDS2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenEmptyString2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenJavaLangString() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "java.lang.String");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenJavaLangString2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "java.lang.String");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenName() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenName2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
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
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateMustBeProvided() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateMustBeProvided2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "Predicate must be provided");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code : Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateWasNull() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code : Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when ': Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenPredicateWasNull2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, ": Predicate was null");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code screenshots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'screenshots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenScreenshots() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code screenshots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when 'screenshots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenScreenshots2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "screenshots");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenSlash() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "/");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Locator, String)} with {@code locator}, {@code name}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Locator, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Locator, String) with 'locator', 'name'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Locator DocumentationHelper.takePageSnapshot(Locator, String)"})
  void testTakePageSnapshotWithLocatorName_whenSlash2() throws UnsupportedEncodingException {
    // Arrange
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    DocumentationHelper documentationHelper = new DocumentationHelper(page, "/+");
    Locator locator = mock(Locator.class);
    doNothing().when(locator).scrollIntoViewIfNeeded();
    doNothing().when(locator).waitFor();

    // Act
    Locator actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(locator, "/");

    // Assert
    verify(locator).scrollIntoViewIfNeeded();
    verify(locator).waitFor();
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(locator, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "org.finos.waltz.test_common.playwright.DocumentationHelper");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>Given {@link DocumentationHelper#DocumentationHelper(Page, String)} with {@link Page} and {@code Base Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; given DocumentationHelper(Page, String) with Page and 'Base Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_givenDocumentationHelperWithPageAndBasePath()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "Base Path");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code 1_Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '1_Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_when1Name() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "1_Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_when42() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_when422() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "42");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayMustBeProvided() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayMustBeProvided2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Array must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayWasNull() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenArrayWasNull2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Array was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenCannotConvertEmptyOrNullSegmentsToPath()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenCannotConvertEmptyOrNullSegmentsToPath2()
      throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page,
        "Cannot convert empty or null segments to path");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code %d_%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '%d_%s'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenDS() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code %d_%s}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '%d_%s'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenDS2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "%d_%s");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenEmptyString2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenJavaLangString() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "java.lang.String");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenJavaLangString2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "java.lang.String");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenName() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenName2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Name");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateMustBeProvided() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateMustBeProvided2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "Predicate must be provided");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code : Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateWasNull() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code : Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when ': Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenPredicateWasNull2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, ": Predicate was null");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code screenshots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'screenshots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenScreenshots() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code screenshots}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when 'screenshots'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenScreenshots2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "screenshots");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenSlash() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "/");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#takePageSnapshot(Page, String)} with {@code page}, {@code name}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentationHelper#takePageSnapshot(Page, String)}
   */
  @Test
  @DisplayName("Test takePageSnapshot(Page, String) with 'page', 'name'; when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Page DocumentationHelper.takePageSnapshot(Page, String)"})
  void testTakePageSnapshotWithPageName_whenSlash2() throws UnsupportedEncodingException {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "/+");
    Page page = mock(Page.class);
    when(page.screenshot(Mockito.<ScreenshotOptions>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Page actualTakePageSnapshotResult = documentationHelper.takePageSnapshot(page, "/");

    // Assert
    verify(page).screenshot(isA(ScreenshotOptions.class));
    assertSame(page, actualTakePageSnapshotResult);
  }

  /**
   * Test {@link DocumentationHelper#pause()}.
   * <p>
   * Method under test: {@link DocumentationHelper#pause()}
   */
  @Test
  @DisplayName("Test pause()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DocumentationHelper DocumentationHelper.pause()"})
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
   * Test {@link DocumentationHelper#resume()}.
   * <p>
   * Method under test: {@link DocumentationHelper#resume()}
   */
  @Test
  @DisplayName("Test resume()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DocumentationHelper DocumentationHelper.resume()"})
  void testResume() {
    // Arrange
    DocumentationHelper documentationHelper = new DocumentationHelper(mock(Page.class), "Base Path");

    // Act and Assert
    assertSame(documentationHelper, documentationHelper.resume());
  }
}
