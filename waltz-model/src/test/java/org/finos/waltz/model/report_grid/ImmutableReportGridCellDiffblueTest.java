package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridCellDiffblueTest {
  /**
   * Test {@link ImmutableReportGridCell#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridCell#builder()}
   *   <li>{@link ImmutableReportGridCell#comment(String)}
   *   <li>{@link ImmutableReportGridCell#dateTimeValue(LocalDateTime)}
   *   <li>{@link ImmutableReportGridCell#errorValue(String)}
   *   <li>{@link ImmutableReportGridCell#numberValue(BigDecimal)}
   *   <li>{@link ImmutableReportGridCell#textValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridCell Builder.build()", "Builder Builder.comment(String)",
      "Builder Builder.dateTimeValue(LocalDateTime)", "Builder Builder.errorValue(String)",
      "Builder Builder.numberValue(BigDecimal)", "Builder Builder.textValue(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualCommentResult = ImmutableReportGridCell.builder().comment("Comment");
    Builder actualErrorValueResult = actualCommentResult.dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
        .errorValue("An error occurred");
    Builder actualNumberValueResult = actualErrorValueResult.numberValue(new BigDecimal("2.3"));

    // Assert
    assertSame(actualNumberValueResult, actualNumberValueResult.textValue("42"));
  }

  /**
   * Test Builder {@link Builder#addAllOptions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllOptions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOptions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllOptions(Iterable)"})
  void testBuilderAddAllOptions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOptions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRatingIdValues(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIdValues(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingIdValues(Iterable)"})
  void testBuilderAddAllRatingIdValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(elements));
  }

  /**
   * Test Builder {@link Builder#addAllRatingIdValues(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIdValues(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingIdValues(Iterable)"})
  void testBuilderAddAllRatingIdValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableCellOption.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOptions(CellOption)}
   */
  @Test
  @DisplayName("Test Builder addOptions(CellOption) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption)"})
  void testBuilderAddOptionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(new ImmutableCellOption.Json()));
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableCellOption.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOptions(CellOption[])}
   */
  @Test
  @DisplayName("Test Builder addOptions(CellOption[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption[])"})
  void testBuilderAddOptionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(new ImmutableCellOption.Json()));
  }

  /**
   * Test Builder {@link Builder#addRatingIdValues(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRatingIdValues(long)}
   */
  @Test
  @DisplayName("Test Builder addRatingIdValues(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingIdValues(long)"})
  void testBuilderAddRatingIdValuesWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L));
  }

  /**
   * Test Builder {@link Builder#addRatingIdValues(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRatingIdValues(long[])}
   */
  @Test
  @DisplayName("Test Builder addRatingIdValues(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingIdValues(long[])"})
  void testBuilderAddRatingIdValuesWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L, -3L, 1L, -3L));
  }

  /**
   * Test Builder {@link Builder#columnDefinitionId(Long)}.
   * <p>
   * Method under test: {@link Builder#columnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder columnDefinitionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnDefinitionId(Long)"})
  void testBuilderColumnDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   * <ul>
   *   <li>Given {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenComment() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Given {@code Comment}.</li>
   *   <li>Then return build textValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; given 'Comment'; then return build textValue is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_givenComment_thenReturnBuildTextValueIs42() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    ImmutableReportGridCell buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableReportGridCell buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("An error occurred", buildResult2.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Comment", buildResult2.comment());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, buildResult.numberValue());
    assertSame(bigDecimal, buildResult2.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then return build comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildCommentIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn(null);
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    ImmutableReportGridCell buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableReportGridCell buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("An error occurred", buildResult2.errorValue());
    assertNull(buildResult.comment());
    assertNull(buildResult2.comment());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, buildResult.numberValue());
    assertSame(bigDecimal, buildResult2.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then return build errorValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build errorValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildErrorValueIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn(null);
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    ImmutableReportGridCell buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableReportGridCell buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.textValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Comment", buildResult2.comment());
    assertNull(buildResult.errorValue());
    assertNull(buildResult2.errorValue());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, buildResult.numberValue());
    assertSame(bigDecimal, buildResult2.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then return build numberValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build numberValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildNumberValueIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(null);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    ImmutableReportGridCell buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableReportGridCell buildResult2 = builderResult.build();
    assertEquals("42", buildResult2.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("An error occurred", buildResult2.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Comment", buildResult2.comment());
    assertNull(buildResult.numberValue());
    assertNull(buildResult2.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then return build options size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build options size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildOptionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(new ImmutableCellOption.Json());
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(cellOptionSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    ImmutableReportGridCell buildResult = actualFromResult.build();
    assertEquals(1, buildResult.options().size());
    assertEquals(1, builderResult.build().options().size());
    assertTrue(buildResult.ratingIdValues().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then return build ratingIdValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build ratingIdValues size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildRatingIdValuesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    Set<Long> ratingIdValuesResult = actualFromResult.build().ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    Set<Long> ratingIdValuesResult2 = builderResult.build().ratingIdValues();
    assertEquals(1, ratingIdValuesResult2.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(ratingIdValuesResult2.contains(1L));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then return build textValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build textValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildTextValueIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn(null);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    ImmutableReportGridCell buildResult = actualFromResult.build();
    assertEquals("An error occurred", buildResult.errorValue());
    ImmutableReportGridCell buildResult2 = builderResult.build();
    assertEquals("An error occurred", buildResult2.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Comment", buildResult2.comment());
    assertNull(buildResult.textValue());
    assertNull(buildResult2.textValue());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, buildResult.numberValue());
    assertSame(bigDecimal, buildResult2.numberValue());
  }

  /**
   * Test Builder {@link Builder#options(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#options(Iterable)}
   */
  @Test
  @DisplayName("Test Builder options(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.options(Iterable)"})
  void testBuilderOptions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.options(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#ratingIdValues(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIdValues(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingIdValues(Iterable)"})
  void testBuilderRatingIdValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(elements));
  }

  /**
   * Test Builder {@link Builder#ratingIdValues(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIdValues(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingIdValues(Iterable)"})
  void testBuilderRatingIdValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#subjectId(long)}.
   * <p>
   * Method under test: {@link Builder#subjectId(long)}
   */
  @Test
  @DisplayName("Test Builder subjectId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjectId(long)"})
  void testBuilderSubjectId() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectId(1L));
  }

  /**
   * Test Json {@link Json#columnDefinitionId()}.
   * <p>
   * Method under test: {@link Json#columnDefinitionId()}
   */
  @Test
  @DisplayName("Test Json columnDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.columnDefinitionId()"})
  void testJsonColumnDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnDefinitionId());
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
  }

  /**
   * Test Json {@link Json#dateTimeValue()}.
   * <p>
   * Method under test: {@link Json#dateTimeValue()}
   */
  @Test
  @DisplayName("Test Json dateTimeValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.dateTimeValue()"})
  void testJsonDateTimeValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dateTimeValue());
  }

  /**
   * Test Json {@link Json#errorValue()}.
   * <p>
   * Method under test: {@link Json#errorValue()}
   */
  @Test
  @DisplayName("Test Json errorValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.errorValue()"})
  void testJsonErrorValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).errorValue());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.columnDefinitionId);
    assertNull(actualJson.comment);
    assertNull(actualJson.errorValue);
    assertNull(actualJson.textValue);
    assertNull(actualJson.numberValue);
    assertNull(actualJson.dateTimeValue);
    assertEquals(0L, actualJson.subjectId);
    assertFalse(actualJson.optionsIsSet);
    assertFalse(actualJson.subjectIdIsSet);
    assertTrue(actualJson.options.isEmpty());
    assertTrue(actualJson.ratingIdValues.isEmpty());
  }

  /**
   * Test Json {@link Json#numberValue()}.
   * <p>
   * Method under test: {@link Json#numberValue()}
   */
  @Test
  @DisplayName("Test Json numberValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BigDecimal Json.numberValue()"})
  void testJsonNumberValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).numberValue());
  }

  /**
   * Test Json {@link Json#options()}.
   * <p>
   * Method under test: {@link Json#options()}
   */
  @Test
  @DisplayName("Test Json options()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.options()"})
  void testJsonOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).options());
  }

  /**
   * Test Json {@link Json#ratingIdValues()}.
   * <p>
   * Method under test: {@link Json#ratingIdValues()}
   */
  @Test
  @DisplayName("Test Json ratingIdValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ratingIdValues()"})
  void testJsonRatingIdValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingIdValues());
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   * <ul>
   *   <li>Given {@link ImmutableCellOption.Json} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link ImmutableCellOption.Json} (default constructor).</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#options} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName("Test Json setOptions(Set); given Json (default constructor); when HashSet() add Json (default constructor); then Json (default constructor) options size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setOptions(Set)"})
  void testJsonSetOptions_givenJson_whenHashSetAddJson_thenJsonOptionsSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<CellOption> options = new HashSet<>();
    options.add(new ImmutableCellOption.Json());

    // Act
    json.setOptions(options);

    // Assert
    assertEquals(1, json.options.size());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   * <ul>
   *   <li>Given {@link ImmutableCellOption.Json} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()} add {@link ImmutableCellOption.Json} (default constructor).</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#options} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName("Test Json setOptions(Set); given Json (default constructor); when HashSet() add Json (default constructor); then Json (default constructor) options size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setOptions(Set)"})
  void testJsonSetOptions_givenJson_whenHashSetAddJson_thenJsonOptionsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    HashSet<CellOption> options = new HashSet<>();
    options.add(new ImmutableCellOption.Json());
    options.add(new ImmutableCellOption.Json());

    // Act
    json.setOptions(options);

    // Assert
    assertEquals(2, json.options.size());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#options} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName("Test Json setOptions(Set); when HashSet(); then Json (default constructor) options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setOptions(Set)"})
  void testJsonSetOptions_whenHashSet_thenJsonOptionsEmpty() {
    // Arrange
    Json json = new Json();

    // Act
    json.setOptions(new HashSet<>());

    // Assert
    assertTrue(json.options.isEmpty());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Json} (default constructor) {@link Json#options} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName("Test Json setOptions(Set); when 'null'; then Json (default constructor) options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setOptions(Set)"})
  void testJsonSetOptions_whenNull_thenJsonOptionsIsNull() {
    // Arrange
    Json json = new Json();

    // Act
    json.setOptions(null);

    // Assert
    assertNull(json.options);
    assertFalse(json.optionsIsSet);
  }

  /**
   * Test Json {@link Json#setSubjectId(long)}.
   * <p>
   * Method under test: {@link Json#setSubjectId(long)}
   */
  @Test
  @DisplayName("Test Json setSubjectId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setSubjectId(long)"})
  void testJsonSetSubjectId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSubjectId(1L);

    // Assert
    assertEquals(1L, json.subjectId);
    assertTrue(json.subjectIdIsSet);
  }

  /**
   * Test Json {@link Json#subjectId()}.
   * <p>
   * Method under test: {@link Json#subjectId()}
   */
  @Test
  @DisplayName("Test Json subjectId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.subjectId()"})
  void testJsonSubjectId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectId());
  }

  /**
   * Test Json {@link Json#textValue()}.
   * <p>
   * Method under test: {@link Json#textValue()}
   */
  @Test
  @DisplayName("Test Json textValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.textValue()"})
  void testJsonTextValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).textValue());
  }
}
