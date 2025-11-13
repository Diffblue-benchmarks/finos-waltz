package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#addAllOptions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOptions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllOptions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOptions(Iterable)"})
  void testBuilderAddAllOptions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualAddAllOptionsResult = builderResult.addAllOptions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllOptionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatingIdValues(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRatingIdValues(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingIdValues(Iterable)"})
  void testBuilderAddAllRatingIdValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllRatingIdValuesResult = builderResult.addAllRatingIdValues(elements);

    // Assert
    assertSame(builderResult, actualAddAllRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatingIdValues(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIdValues(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingIdValues(Iterable)"})
  void testBuilderAddAllRatingIdValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualAddAllRatingIdValuesResult =
        builderResult.addAllRatingIdValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableCellOption.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOptions(CellOption)}
   */
  @Test
  @DisplayName(
      "Test Builder addOptions(CellOption) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption)"})
  void testBuilderAddOptionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualAddOptionsResult = builderResult.addOptions(new ImmutableCellOption.Json());

    // Assert
    assertSame(builderResult, actualAddOptionsResult);
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableCellOption.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOptions(CellOption[])}
   */
  @Test
  @DisplayName(
      "Test Builder addOptions(CellOption[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption[])"})
  void testBuilderAddOptionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualAddOptionsResult = builderResult.addOptions(new ImmutableCellOption.Json());

    // Assert
    assertSame(builderResult, actualAddOptionsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingIdValues(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRatingIdValues(long)}
   */
  @Test
  @DisplayName("Test Builder addRatingIdValues(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingIdValues(long)"})
  void testBuilderAddRatingIdValuesWithElement() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualAddRatingIdValuesResult = builderResult.addRatingIdValues(1L);

    // Assert
    assertSame(builderResult, actualAddRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#addRatingIdValues(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRatingIdValues(long[])}
   */
  @Test
  @DisplayName("Test Builder addRatingIdValues(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingIdValues(long[])"})
  void testBuilderAddRatingIdValuesWithElements() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualAddRatingIdValuesResult = builderResult.addRatingIdValues(1L, -3L, 1L, -3L);

    // Assert
    assertSame(builderResult, actualAddRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   *   <li>{@link Builder#dateTimeValue(LocalDateTime)}
   *   <li>{@link Builder#errorValue(String)}
   *   <li>{@link Builder#numberValue(BigDecimal)}
   *   <li>{@link Builder#textValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCell Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.dateTimeValue(LocalDateTime)",
    "Builder Builder.errorValue(String)",
    "Builder Builder.numberValue(BigDecimal)",
    "Builder Builder.textValue(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableReportGridCell.builder();
    Builder actualAddAllOptionsResult = actualBuilderResult.addAllOptions(new ArrayList<>());
    Builder actualAddOptionsResult =
        actualAddAllOptionsResult.addOptions(
            ImmutableCellOption.builder().code("Code").text("Text").build());
    LocalDateTime dateTimeValue = LocalDate.of(1970, 1, 1).atStartOfDay();
    Builder actualErrorValueResult =
        actualAddOptionsResult
            .addOptions(ImmutableCellOption.builder().code("Code").text("Text").build())
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(dateTimeValue)
            .errorValue("An error occurred");
    BigDecimal numberValue = new BigDecimal("2.3");
    ImmutableReportGridCell actualImmutableReportGridCell =
        actualErrorValueResult.numberValue(numberValue).subjectId(1L).textValue("42").build();

    // Assert
    assertEquals("42", actualImmutableReportGridCell.textValue());
    assertEquals("An error occurred", actualImmutableReportGridCell.errorValue());
    assertEquals("Comment", actualImmutableReportGridCell.comment());
    assertEquals(1, actualImmutableReportGridCell.options().size());
    assertEquals(1L, actualImmutableReportGridCell.columnDefinitionId().longValue());
    assertEquals(1L, actualImmutableReportGridCell.subjectId());
    assertTrue(actualImmutableReportGridCell.ratingIdValues().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualImmutableReportGridCell.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(numberValue, numberValueResult);
    assertSame(dateTimeValue, actualImmutableReportGridCell.dateTimeValue());
  }

  /**
   * Test Builder {@link Builder#columnDefinitionId(Long)}.
   *
   * <p>Method under test: {@link Builder#columnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder columnDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columnDefinitionId(Long)"})
  void testBuilderColumnDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualColumnDefinitionIdResult = builderResult.columnDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualColumnDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableReportGridCell actualImmutableReportGridCell =
        builderResult.from((CommentProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridCell);
    ImmutableReportGridCell actualImmutableReportGridCell2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCell2);
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <ul>
   *   <li>Given {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder builderResult2 = ImmutableReportGridCell.builder();
    builderResult2.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());
    builderResult2.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableReportGridCell actualImmutableReportGridCell = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridCell);
    ImmutableReportGridCell actualImmutableReportGridCell2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCell2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell2() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment(null)
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableReportGridCell actualImmutableReportGridCell = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridCell);
    ImmutableReportGridCell actualImmutableReportGridCell2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCell2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell3() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue(null);

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableReportGridCell actualImmutableReportGridCell = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridCell);
    ImmutableReportGridCell actualImmutableReportGridCell2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCell2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell4() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder numberValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred")
            .numberValue(null);
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableReportGridCell actualImmutableReportGridCell = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridCell);
    ImmutableReportGridCell actualImmutableReportGridCell2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCell2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <ul>
   *   <li>Then return build errorValue is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build errorValue is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildErrorValueIsAnErrorOccurred() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    ImmutableReportGridCell immutableReportGridCell =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build();
    assertEquals("An error occurred", immutableReportGridCell.errorValue());
    assertEquals("Comment", immutableReportGridCell.comment());
    Set<CellOption> optionsResult = immutableReportGridCell.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, immutableReportGridCell.numberValue());
    assertSame(optionsResult, immutableReportGridCell.ratingIdValues());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <ul>
   *   <li>Then return build ratingIdValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build ratingIdValues size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildRatingIdValuesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    Builder builderResult2 = ImmutableReportGridCell.builder();
    builderResult2.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    Set<Long> ratingIdValuesResult = builderResult.from(instance).build().ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    ImmutableReportGridCell actualImmutableReportGridCell = builderResult.build();
    assertEquals(instance, actualImmutableReportGridCell);
  }

  /**
   * Test Builder {@link Builder#options(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#options(Iterable)}
   */
  @Test
  @DisplayName("Test Builder options(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.options(Iterable)"})
  void testBuilderOptions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualOptionsResult = builderResult.options(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualOptionsResult);
  }

  /**
   * Test Builder {@link Builder#ratingIdValues(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIdValues(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingIdValues(Iterable)"})
  void testBuilderRatingIdValues_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualRatingIdValuesResult = builderResult.ratingIdValues(elements);

    // Assert
    assertSame(builderResult, actualRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#ratingIdValues(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIdValues(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingIdValues(Iterable)"})
  void testBuilderRatingIdValues_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualRatingIdValuesResult = builderResult.ratingIdValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#subjectId(long)}.
   *
   * <p>Method under test: {@link Builder#subjectId(long)}
   */
  @Test
  @DisplayName("Test Builder subjectId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectId(long)"})
  void testBuilderSubjectId() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();

    // Act
    Builder actualSubjectIdResult = builderResult.subjectId(1L);

    // Assert
    assertSame(builderResult, actualSubjectIdResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#copyOf(ReportGridCell)}.
   *
   * <ul>
   *   <li>Then return dateTimeValue toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#copyOf(ReportGridCell)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridCell); then return dateTimeValue toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.copyOf(ReportGridCell)"})
  void testCopyOf_thenReturnDateTimeValueToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualCopyOfResult = ImmutableReportGridCell.copyOf(instance);

    // Assert
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    Set<CellOption> optionsResult = actualCopyOfResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualCopyOfResult.numberValue());
    assertSame(optionsResult, actualCopyOfResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}, and {@link
   * ImmutableReportGridCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridCell#equals(Object)}
   *   <li>{@link ImmutableReportGridCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell2 =
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    assertEquals(immutableReportGridCell, immutableReportGridCell2);
    assertEquals(immutableReportGridCell.hashCode(), immutableReportGridCell2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}, and {@link
   * ImmutableReportGridCell#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridCell#equals(Object)}
   *   <li>{@link ImmutableReportGridCell#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    assertEquals(immutableReportGridCell, immutableReportGridCell);
    int expectedHashCodeResult = immutableReportGridCell.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridCell.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    builderResult.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableReportGridCell.builder();
    builderResult.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());

    Builder errorValueResult =
        builderResult
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(2L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.now().atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("42");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("4.5"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(2L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("Text Value")
            .build();

    Builder errorValueResult2 =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableReportGridCell,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridCell#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridCell.equals(Object)",
    "int ImmutableReportGridCell.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build(),
        "Different type to ImmutableReportGridCell");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridCell#toString()}
   *   <li>{@link ImmutableReportGridCell#columnDefinitionId()}
   *   <li>{@link ImmutableReportGridCell#comment()}
   *   <li>{@link ImmutableReportGridCell#dateTimeValue()}
   *   <li>{@link ImmutableReportGridCell#errorValue()}
   *   <li>{@link ImmutableReportGridCell#numberValue()}
   *   <li>{@link ImmutableReportGridCell#options()}
   *   <li>{@link ImmutableReportGridCell#ratingIdValues()}
   *   <li>{@link ImmutableReportGridCell#subjectId()}
   *   <li>{@link ImmutableReportGridCell#textValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableReportGridCell.columnDefinitionId()",
    "String ImmutableReportGridCell.comment()",
    "LocalDateTime ImmutableReportGridCell.dateTimeValue()",
    "String ImmutableReportGridCell.errorValue()",
    "BigDecimal ImmutableReportGridCell.numberValue()",
    "Set ImmutableReportGridCell.options()",
    "Set ImmutableReportGridCell.ratingIdValues()",
    "long ImmutableReportGridCell.subjectId()",
    "String ImmutableReportGridCell.textValue()",
    "String ImmutableReportGridCell.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");
    BigDecimal numberValue = new BigDecimal("2.3");

    Builder numberValueResult = errorValueResult.numberValue(numberValue);
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    String actualToStringResult = immutableReportGridCell.toString();
    Long actualColumnDefinitionIdResult = immutableReportGridCell.columnDefinitionId();
    String actualCommentResult = immutableReportGridCell.comment();
    LocalDateTime actualDateTimeValueResult = immutableReportGridCell.dateTimeValue();
    String actualErrorValueResult = immutableReportGridCell.errorValue();
    BigDecimal actualNumberValueResult = immutableReportGridCell.numberValue();
    Set<CellOption> actualOptionsResult = immutableReportGridCell.options();
    Set<Long> actualRatingIdValuesResult = immutableReportGridCell.ratingIdValues();
    long actualSubjectIdResult = immutableReportGridCell.subjectId();

    // Assert
    assertEquals("00:00", actualDateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualDateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", immutableReportGridCell.textValue());
    assertEquals("An error occurred", actualErrorValueResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals(
        "ReportGridCell{columnDefinitionId=1, subjectId=1, ratingIdValues=[], numberValue=2.3, textValue=42,"
            + " errorValue=An error occurred, dateTimeValue=1970-01-01T00:00, options=[]}",
        actualToStringResult);
    assertEquals(1L, actualColumnDefinitionIdResult.longValue());
    assertEquals(1L, actualSubjectIdResult);
    assertTrue(actualOptionsResult.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualNumberValueResult);
    assertSame(numberValue, actualNumberValueResult);
    assertSame(actualOptionsResult, actualRatingIdValuesResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#columnDefinitionId()}.
   *
   * <p>Method under test: {@link Json#columnDefinitionId()}
   */
  @Test
  @DisplayName("Test Json columnDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.columnDefinitionId()"})
  void testJsonColumnDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnDefinitionId());
  }

  /**
   * Test Json {@link Json#comment()}.
   *
   * <p>Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json {@link Json#dateTimeValue()}.
   *
   * <p>Method under test: {@link Json#dateTimeValue()}
   */
  @Test
  @DisplayName("Test Json dateTimeValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.dateTimeValue()"})
  void testJsonDateTimeValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dateTimeValue());
  }

  /**
   * Test Json {@link Json#errorValue()}.
   *
   * <p>Method under test: {@link Json#errorValue()}
   */
  @Test
  @DisplayName("Test Json errorValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.errorValue()"})
  void testJsonErrorValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().errorValue());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#numberValue()}
   */
  @Test
  @DisplayName("Test Json numberValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.numberValue()"})
  void testJsonNumberValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().numberValue());
  }

  /**
   * Test Json {@link Json#options()}.
   *
   * <p>Method under test: {@link Json#options()}
   */
  @Test
  @DisplayName("Test Json options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.options()"})
  void testJsonOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().options());
  }

  /**
   * Test Json {@link Json#ratingIdValues()}.
   *
   * <p>Method under test: {@link Json#ratingIdValues()}
   */
  @Test
  @DisplayName("Test Json ratingIdValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratingIdValues()"})
  void testJsonRatingIdValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingIdValues());
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   *
   * <ul>
   *   <li>Given builder code {@code Code} text {@code Text} build.
   *   <li>Then {@link Json} (default constructor) {@link Json#options} size is one.
   * </ul>
   *
   * <p>Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setOptions(Set); given builder code 'Code' text 'Text' build; then Json (default constructor) options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setOptions(Set)"})
  void testJsonSetOptions_givenBuilderCodeCodeTextTextBuild_thenJsonOptionsSizeIsOne() {
    // Arrange
    Json json = new Json();

    HashSet<CellOption> options = new HashSet<>();
    options.add(ImmutableCellOption.builder().code("Code").text("Text").build());

    // Act
    json.setOptions(options);

    // Assert
    assertEquals(1, json.options.size());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   *
   * <ul>
   *   <li>Given builder code {@code code} text {@code Text} build.
   *   <li>Then {@link Json} (default constructor) {@link Json#options} size is two.
   * </ul>
   *
   * <p>Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setOptions(Set); given builder code 'code' text 'Text' build; then Json (default constructor) options size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setOptions(Set)"})
  void testJsonSetOptions_givenBuilderCodeCodeTextTextBuild_thenJsonOptionsSizeIsTwo() {
    // Arrange
    Json json = new Json();

    HashSet<CellOption> options = new HashSet<>();
    options.add(ImmutableCellOption.builder().code("code").text("Text").build());
    options.add(ImmutableCellOption.builder().code("Code").text("Text").build());

    // Act
    json.setOptions(options);

    // Assert
    assertEquals(2, json.options.size());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Test Json {@link Json#setOptions(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then {@link Json} (default constructor) {@link Json#options} Empty.
   * </ul>
   *
   * <p>Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setOptions(Set); when HashSet(); then Json (default constructor) options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link Json} (default constructor) {@link Json#options} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Json#setOptions(Set)}
   */
  @Test
  @DisplayName(
      "Test Json setOptions(Set); when 'null'; then Json (default constructor) options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setSubjectId(long)}
   */
  @Test
  @DisplayName("Test Json setSubjectId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#subjectId()}
   */
  @Test
  @DisplayName("Test Json subjectId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.subjectId()"})
  void testJsonSubjectId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectId());
  }

  /**
   * Test Json {@link Json#textValue()}.
   *
   * <p>Method under test: {@link Json#textValue()}
   */
  @Test
  @DisplayName("Test Json textValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.textValue()"})
  void testJsonTextValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().textValue());
  }

  /**
   * Test {@link ImmutableReportGridCell#withColumnDefinitionId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withColumnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withColumnDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCell ImmutableReportGridCell.withColumnDefinitionId(Long)"
  })
  void testWithColumnDefinitionId() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithColumnDefinitionIdResult =
        immutableReportGridCell.withColumnDefinitionId(1L);

    // Assert
    assertSame(immutableReportGridCell, actualWithColumnDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withColumnDefinitionId(Long)}.
   *
   * <ul>
   *   <li>Then return dateTimeValue toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withColumnDefinitionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withColumnDefinitionId(Long); then return dateTimeValue toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCell ImmutableReportGridCell.withColumnDefinitionId(Long)"
  })
  void testWithColumnDefinitionId_thenReturnDateTimeValueToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableReportGridCell actualWithColumnDefinitionIdResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withColumnDefinitionId(42L);

    // Assert
    LocalDateTime dateTimeValueResult = actualWithColumnDefinitionIdResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithColumnDefinitionIdResult.textValue());
    assertEquals("An error occurred", actualWithColumnDefinitionIdResult.errorValue());
    assertEquals("Comment", actualWithColumnDefinitionIdResult.comment());
    assertEquals(1L, actualWithColumnDefinitionIdResult.subjectId());
    assertEquals(42L, actualWithColumnDefinitionIdResult.columnDefinitionId().longValue());
    Set<CellOption> optionsResult = actualWithColumnDefinitionIdResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithColumnDefinitionIdResult.numberValue());
    assertSame(optionsResult, actualWithColumnDefinitionIdResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withComment(String)"})
  void testWithComment() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithCommentResult = immutableReportGridCell.withComment("42");

    // Assert
    assertEquals(immutableReportGridCell, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withComment(String)"})
  void testWithComment2() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("42")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithCommentResult = immutableReportGridCell.withComment("42");

    // Assert
    assertSame(immutableReportGridCell, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withDateTimeValue(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withDateTimeValue(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withDateTimeValue(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCell ImmutableReportGridCell.withDateTimeValue(LocalDateTime)"
  })
  void testWithDateTimeValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithDateTimeValueResult =
        immutableReportGridCell.withDateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableReportGridCell, actualWithDateTimeValueResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withErrorValue(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withErrorValue(String)}
   */
  @Test
  @DisplayName("Test withErrorValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withErrorValue(String)"})
  void testWithErrorValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("42");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithErrorValueResult =
        immutableReportGridCell.withErrorValue("42");

    // Assert
    assertSame(immutableReportGridCell, actualWithErrorValueResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withErrorValue(String)}.
   *
   * <ul>
   *   <li>Then return dateTimeValue toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withErrorValue(String)}
   */
  @Test
  @DisplayName(
      "Test withErrorValue(String); then return dateTimeValue toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withErrorValue(String)"})
  void testWithErrorValue_thenReturnDateTimeValueToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableReportGridCell actualWithErrorValueResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withErrorValue("42");

    // Assert
    LocalDateTime dateTimeValueResult = actualWithErrorValueResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithErrorValueResult.errorValue());
    assertEquals("42", actualWithErrorValueResult.textValue());
    assertEquals("Comment", actualWithErrorValueResult.comment());
    assertEquals(1L, actualWithErrorValueResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithErrorValueResult.subjectId());
    Set<CellOption> optionsResult = actualWithErrorValueResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithErrorValueResult.numberValue());
    assertSame(optionsResult, actualWithErrorValueResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withNumberValue(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withNumberValue(BigDecimal)}
   */
  @Test
  @DisplayName("Test withNumberValue(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withNumberValue(BigDecimal)"})
  void testWithNumberValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithNumberValueResult =
        immutableReportGridCell.withNumberValue(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableReportGridCell, actualWithNumberValueResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withNumberValue(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return dateTimeValue toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withNumberValue(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test withNumberValue(BigDecimal); then return dateTimeValue toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withNumberValue(BigDecimal)"})
  void testWithNumberValue_thenReturnDateTimeValueToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("4.5"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithNumberValueResult =
        immutableReportGridCell.withNumberValue(new BigDecimal("2.3"));

    // Assert
    LocalDateTime dateTimeValueResult = actualWithNumberValueResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithNumberValueResult.textValue());
    assertEquals("An error occurred", actualWithNumberValueResult.errorValue());
    assertEquals("Comment", actualWithNumberValueResult.comment());
    assertEquals(1L, actualWithNumberValueResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithNumberValueResult.subjectId());
    Set<CellOption> optionsResult = actualWithNumberValueResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithNumberValueResult.numberValue());
    assertSame(optionsResult, actualWithNumberValueResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withOptions(CellOption[])} with {@code CellOption[]}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withOptions(CellOption[])}
   */
  @Test
  @DisplayName("Test withOptions(CellOption[]) with 'CellOption[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withOptions(CellOption[])"})
  void testWithOptionsWithCellOption() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithOptionsResult =
        immutableReportGridCell.withOptions(
            ImmutableCellOption.builder().code("Code").text("Text").build());

    // Assert
    LocalDateTime dateTimeValueResult = actualWithOptionsResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithOptionsResult.textValue());
    assertEquals("An error occurred", actualWithOptionsResult.errorValue());
    assertEquals("Comment", actualWithOptionsResult.comment());
    assertEquals(1, actualWithOptionsResult.options().size());
    assertEquals(1L, actualWithOptionsResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithOptionsResult.subjectId());
    assertTrue(actualWithOptionsResult.ratingIdValues().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithOptionsResult.numberValue());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withRatingIdValues(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withRatingIdValues(Iterable)}
   */
  @Test
  @DisplayName("Test withRatingIdValues(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridCell ImmutableReportGridCell.withRatingIdValues(Iterable)"
  })
  void testWithRatingIdValuesWithIterable() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableReportGridCell actualWithRatingIdValuesResult =
        immutableReportGridCell.withRatingIdValues(elements);

    // Assert
    LocalDateTime dateTimeValueResult = actualWithRatingIdValuesResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithRatingIdValuesResult.textValue());
    assertEquals("An error occurred", actualWithRatingIdValuesResult.errorValue());
    assertEquals("Comment", actualWithRatingIdValuesResult.comment());
    assertEquals(1L, actualWithRatingIdValuesResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithRatingIdValuesResult.subjectId());
    assertTrue(actualWithRatingIdValuesResult.options().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithRatingIdValuesResult.numberValue());
    assertEquals(elements, actualWithRatingIdValuesResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withRatingIdValues(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withRatingIdValues(long[])}
   */
  @Test
  @DisplayName("Test withRatingIdValues(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withRatingIdValues(long[])"})
  void testWithRatingIdValuesWithLong() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableReportGridCell actualWithRatingIdValuesResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withRatingIdValues(1L, -1L, 1L, -1L);

    // Assert
    assertEquals("42", actualWithRatingIdValuesResult.textValue());
    assertEquals("An error occurred", actualWithRatingIdValuesResult.errorValue());
    assertEquals("Comment", actualWithRatingIdValuesResult.comment());
    assertEquals(1L, actualWithRatingIdValuesResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithRatingIdValuesResult.subjectId());
    Set<Long> ratingIdValuesResult = actualWithRatingIdValuesResult.ratingIdValues();
    assertEquals(2, ratingIdValuesResult.size());
    assertTrue(ratingIdValuesResult.contains(-1L));
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(actualWithRatingIdValuesResult.options().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithRatingIdValuesResult.numberValue());
    assertSame(ofResult, actualWithRatingIdValuesResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableReportGridCell#withSubjectId(long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withSubjectId(long)}
   */
  @Test
  @DisplayName("Test withSubjectId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withSubjectId(long)"})
  void testWithSubjectId() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(42L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithSubjectIdResult = immutableReportGridCell.withSubjectId(42L);

    // Assert
    assertSame(immutableReportGridCell, actualWithSubjectIdResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withSubjectId(long)}.
   *
   * <ul>
   *   <li>Then return dateTimeValue toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withSubjectId(long)}
   */
  @Test
  @DisplayName(
      "Test withSubjectId(long); then return dateTimeValue toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withSubjectId(long)"})
  void testWithSubjectId_thenReturnDateTimeValueToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableReportGridCell actualWithSubjectIdResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withSubjectId(42L);

    // Assert
    LocalDateTime dateTimeValueResult = actualWithSubjectIdResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithSubjectIdResult.textValue());
    assertEquals("An error occurred", actualWithSubjectIdResult.errorValue());
    assertEquals("Comment", actualWithSubjectIdResult.comment());
    assertEquals(1L, actualWithSubjectIdResult.columnDefinitionId().longValue());
    assertEquals(42L, actualWithSubjectIdResult.subjectId());
    Set<CellOption> optionsResult = actualWithSubjectIdResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithSubjectIdResult.numberValue());
    assertSame(optionsResult, actualWithSubjectIdResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withTextValue(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withTextValue(String)}
   */
  @Test
  @DisplayName("Test withTextValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withTextValue(String)"})
  void testWithTextValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableReportGridCell immutableReportGridCell =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableReportGridCell actualWithTextValueResult = immutableReportGridCell.withTextValue("42");

    // Assert
    assertSame(immutableReportGridCell, actualWithTextValueResult);
  }

  /**
   * Test {@link ImmutableReportGridCell#withTextValue(String)}.
   *
   * <ul>
   *   <li>Then return dateTimeValue toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridCell#withTextValue(String)}
   */
  @Test
  @DisplayName(
      "Test withTextValue(String); then return dateTimeValue toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridCell ImmutableReportGridCell.withTextValue(String)"})
  void testWithTextValue_thenReturnDateTimeValueToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableReportGridCell actualWithTextValueResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("Text Value")
            .build()
            .withTextValue("42");

    // Assert
    LocalDateTime dateTimeValueResult = actualWithTextValueResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithTextValueResult.textValue());
    assertEquals("An error occurred", actualWithTextValueResult.errorValue());
    assertEquals("Comment", actualWithTextValueResult.comment());
    assertEquals(1L, actualWithTextValueResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithTextValueResult.subjectId());
    Set<CellOption> optionsResult = actualWithTextValueResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithTextValueResult.numberValue());
    assertSame(optionsResult, actualWithTextValueResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }
}
