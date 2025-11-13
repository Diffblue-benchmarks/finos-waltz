package org.finos.waltz.web.endpoints.extracts;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CustomDataExtractorDiffblueTest {
  /**
   * Test {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CustomDataExtractor#formatReport(ExtractFormat, String, List,
   * List)}
   */
  @Test
  @DisplayName(
      "Test formatReport(ExtractFormat, String, List, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple3 CustomDataExtractor.formatReport(ExtractFormat, String, List, List)"
  })
  void testFormatReport_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor =
        new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    ArrayList<String> headers = new ArrayList<>();
    headers.add("42");
    headers.add("foo");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            logicalFlowExtractor.formatReport(
                ExtractFormat.SVG, "Report Name", reportRows, headers));
  }

  /**
   * Test {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code SVG}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomDataExtractor#formatReport(ExtractFormat, String, List,
   * List)}
   */
  @Test
  @DisplayName(
      "Test formatReport(ExtractFormat, String, List, List); given ArrayList(); when 'SVG'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple3 CustomDataExtractor.formatReport(ExtractFormat, String, List, List)"
  })
  void testFormatReport_givenArrayList_whenSvg_thenThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor =
        new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));

    ArrayList<List<Object>> reportRows = new ArrayList<>();
    reportRows.add(new ArrayList<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            logicalFlowExtractor.formatReport(
                ExtractFormat.SVG, "Report Name", reportRows, new ArrayList<>()));
  }

  /**
   * Test {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code SVG}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomDataExtractor#formatReport(ExtractFormat, String, List,
   * List)}
   */
  @Test
  @DisplayName(
      "Test formatReport(ExtractFormat, String, List, List); given ArrayList(); when 'SVG'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple3 CustomDataExtractor.formatReport(ExtractFormat, String, List, List)"
  })
  void testFormatReport_givenArrayList_whenSvg_thenThrowUnsupportedOperationException2()
      throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor =
        new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));

    ArrayList<List<Object>> reportRows = new ArrayList<>();
    reportRows.add(new ArrayList<>());
    reportRows.add(new ArrayList<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            logicalFlowExtractor.formatReport(
                ExtractFormat.SVG, "Report Name", reportRows, new ArrayList<>()));
  }

  /**
   * Test {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomDataExtractor#formatReport(ExtractFormat, String, List,
   * List)}
   */
  @Test
  @DisplayName(
      "Test formatReport(ExtractFormat, String, List, List); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple3 CustomDataExtractor.formatReport(ExtractFormat, String, List, List)"
  })
  void testFormatReport_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor =
        new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            logicalFlowExtractor.formatReport(
                ExtractFormat.SVG, "Report Name", reportRows, new ArrayList<>()));
  }

  /**
   * Test {@link CustomDataExtractor#formatReport(ExtractFormat, String, List, List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomDataExtractor#formatReport(ExtractFormat, String, List,
   * List)}
   */
  @Test
  @DisplayName(
      "Test formatReport(ExtractFormat, String, List, List); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.jooq.lambda.tuple.Tuple3 CustomDataExtractor.formatReport(ExtractFormat, String, List, List)"
  })
  void testFormatReport_thenThrowUnsupportedOperationException2() throws IOException {
    // Arrange
    LogicalFlowExtractor logicalFlowExtractor =
        new LogicalFlowExtractor(new DefaultDSLContext(SQLDialect.SQL99));
    ArrayList<List<Object>> reportRows = new ArrayList<>();

    ArrayList<String> headers = new ArrayList<>();
    headers.add("foo");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            logicalFlowExtractor.formatReport(
                ExtractFormat.SVG, "Report Name", reportRows, headers));
  }
}
