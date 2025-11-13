package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.CommentProvider;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.report_grid.CellOption;
import org.finos.waltz.model.report_grid.ImmutableCellOption;
import org.finos.waltz.model.report_grid.ImmutableReportGridCell;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.service.report_grid.ImmutableCellVariable.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellVariableDiffblueTest {
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddAllRatingIdValuesResult =
        builderResult.addAllRatingIdValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddAllRatingsResult = builderResult.addAllRatings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOptions(CellOption)}
   */
  @Test
  @DisplayName("Test Builder addOptions(CellOption) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption)"})
  void testBuilderAddOptionsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddOptionsResult =
        builderResult.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());

    // Assert
    assertSame(builderResult, actualAddOptionsResult);
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOptions(CellOption[])}
   */
  @Test
  @DisplayName("Test Builder addOptions(CellOption[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption[])"})
  void testBuilderAddOptionsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddOptionsResult =
        builderResult.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());

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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddRatingIdValuesResult = builderResult.addRatingIdValues(1L, -3L, 1L, -3L);

    // Assert
    assertSame(builderResult, actualAddRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatings(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatings(RatingSchemeItem) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem)"})
  void testBuilderAddRatingsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddRatingsResult =
        builderResult.addRatings(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertSame(builderResult, actualAddRatingsResult);
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatings(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatings(RatingSchemeItem[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem[])"})
  void testBuilderAddRatingsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualAddRatingsResult =
        builderResult.addRatings(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertSame(builderResult, actualAddRatingsResult);
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
    "ImmutableCellVariable Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.dateTimeValue(LocalDateTime)",
    "Builder Builder.errorValue(String)",
    "Builder Builder.numberValue(BigDecimal)",
    "Builder Builder.textValue(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable actualImmutableCellVariable =
        actualErrorValueResult.numberValue(numberValue).subjectId(1L).textValue("42").build();

    // Assert
    assertEquals("", actualImmutableCellVariable.cellName());
    assertEquals("42", actualImmutableCellVariable.textValue());
    assertEquals("An error occurred", actualImmutableCellVariable.errorValue());
    assertEquals("Comment", actualImmutableCellVariable.comment());
    assertEquals(1, actualImmutableCellVariable.options().size());
    assertEquals(1L, actualImmutableCellVariable.columnDefinitionId().longValue());
    assertEquals(1L, actualImmutableCellVariable.subjectId());
    assertTrue(actualImmutableCellVariable.ratingIdValues().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualImmutableCellVariable.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(numberValue, numberValueResult);
    assertSame(dateTimeValue, actualImmutableCellVariable.dateTimeValue());
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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualColumnDefinitionIdResult = builderResult.columnDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualColumnDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return build ratings is build options.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellVariable) with 'CellVariable'; given one; then return build ratings is build options")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_givenOne_thenReturnBuildRatingsIsBuildOptions() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    Builder builderResult2 = ImmutableCellVariable.builder();
    builderResult2.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    ImmutableCellVariable immutableCellVariable =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build();
    assertEquals("", immutableCellVariable.cellName());
    Set<Long> ratingIdValuesResult = immutableCellVariable.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    Set<CellOption> optionsResult = immutableCellVariable.options();
    assertTrue(optionsResult.isEmpty());
    assertSame(optionsResult, immutableCellVariable.ratings());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   *
   * <ul>
   *   <li>Then return build cellName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellVariable) with 'CellVariable'; then return build cellName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildCellNameIsName() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    Builder builderResult2 = ImmutableCellVariable.builder();
    builderResult2.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
    builderResult2.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    ImmutableCellVariable immutableCellVariable =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build();
    assertEquals("Name", immutableCellVariable.cellName());
    Set<Long> ratingIdValuesResult = immutableCellVariable.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertEquals(1, immutableCellVariable.ratings().size());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(immutableCellVariable.options().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   *
   * <ul>
   *   <li>Then return build options size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellVariable) with 'CellVariable'; then return build options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildOptionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    Builder builderResult2 = ImmutableCellVariable.builder();
    builderResult2.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());
    builderResult2.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    ImmutableCellVariable immutableCellVariable =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build();
    assertEquals("", immutableCellVariable.cellName());
    assertEquals(1, immutableCellVariable.options().size());
    Set<Long> ratingIdValuesResult = immutableCellVariable.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(immutableCellVariable.ratings().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   *
   * <ul>
   *   <li>Then return build ratingIdValues is build options.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellVariable) with 'CellVariable'; then return build ratingIdValues is build options")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildRatingIdValuesIsBuildOptions() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    ImmutableCellVariable immutableCellVariable =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build();
    assertEquals("", immutableCellVariable.cellName());
    Set<CellOption> optionsResult = immutableCellVariable.options();
    assertTrue(optionsResult.isEmpty());
    assertSame(optionsResult, immutableCellVariable.ratingIdValues());
    assertSame(optionsResult, immutableCellVariable.ratings());
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
    Builder builderResult = ImmutableCellVariable.builder();

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableCellVariable actualImmutableCellVariable =
        builderResult.from((CommentProvider) instance).build();
    assertEquals(instance, actualImmutableCellVariable);
    ImmutableCellVariable actualImmutableCellVariable2 = builderResult.build();
    assertEquals(instance, actualImmutableCellVariable2);
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

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
   *   <li>Then builder build cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CommentProvider) with 'CommentProvider'; then builder build cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_thenBuilderBuildCellNameIsEmptyString() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");
    BigDecimal numberValue = new BigDecimal("2.3");

    ImmutableReportGridCell.Builder numberValueResult = errorValueResult.numberValue(numberValue);

    // Act
    builderResult.from(
        (CommentProvider)
            numberValueResult
                .addAllOptions(new ArrayList<>())
                .subjectId(1L)
                .textValue("42")
                .build());

    // Assert
    ImmutableCellVariable immutableCellVariable = builderResult.build();
    assertEquals("", immutableCellVariable.cellName());
    assertEquals("42", immutableCellVariable.textValue());
    assertEquals("An error occurred", immutableCellVariable.errorValue());
    assertEquals("Comment", immutableCellVariable.comment());
    assertEquals(1L, immutableCellVariable.columnDefinitionId().longValue());
    assertEquals(1L, immutableCellVariable.subjectId());
    assertSame(numberValue, immutableCellVariable.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(CommentProvider)} with {@code CommentProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CommentProvider) with 'CommentProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
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
    Builder builderResult = ImmutableCellVariable.builder();

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableCellVariable actualImmutableCellVariable =
        builderResult.from((ReportGridCell) instance).build();
    assertEquals(instance, actualImmutableCellVariable);
    ImmutableCellVariable actualImmutableCellVariable2 = builderResult.build();
    assertEquals(instance, actualImmutableCellVariable2);
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
    Builder builderResult = ImmutableCellVariable.builder();

    Builder builderResult2 = ImmutableCellVariable.builder();
    builderResult2.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    ImmutableCellVariable actualImmutableCellVariable =
        builderResult.from((ReportGridCell) instance).build();
    assertEquals(instance, actualImmutableCellVariable);
    ImmutableCellVariable actualImmutableCellVariable2 = builderResult.build();
    assertEquals(instance, actualImmutableCellVariable2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <ul>
   *   <li>Then builder build cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridCell) with 'ReportGridCell'; then builder build cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenBuilderBuildCellNameIsEmptyString() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    ImmutableReportGridCell.Builder errorValueResult =
        ImmutableReportGridCell.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");
    BigDecimal numberValue = new BigDecimal("2.3");

    ImmutableReportGridCell.Builder numberValueResult = errorValueResult.numberValue(numberValue);

    // Act
    builderResult.from(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());

    // Assert
    ImmutableCellVariable immutableCellVariable = builderResult.build();
    assertEquals("", immutableCellVariable.cellName());
    assertEquals("42", immutableCellVariable.textValue());
    assertEquals("An error occurred", immutableCellVariable.errorValue());
    assertEquals("Comment", immutableCellVariable.comment());
    assertEquals(1L, immutableCellVariable.columnDefinitionId().longValue());
    assertEquals(1L, immutableCellVariable.subjectId());
    assertSame(numberValue, immutableCellVariable.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   *
   * <ul>
   *   <li>Then return build options size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridCell) with 'ReportGridCell'; then return build options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenReturnBuildOptionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    ImmutableReportGridCell.Builder builderResult2 = ImmutableReportGridCell.builder();
    builderResult2.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());
    builderResult2.addRatingIdValues(1L);

    ImmutableReportGridCell.Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    ImmutableCellVariable immutableCellVariable =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build();
    assertEquals(1, immutableCellVariable.options().size());
    ImmutableCellVariable immutableCellVariable2 = builderResult.build();
    assertEquals(1, immutableCellVariable2.options().size());
    Set<Long> ratingIdValuesResult = immutableCellVariable.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    Set<Long> ratingIdValuesResult2 = immutableCellVariable2.ratingIdValues();
    assertEquals(1, ratingIdValuesResult2.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(ratingIdValuesResult2.contains(1L));
    assertTrue(immutableCellVariable.ratings().isEmpty());
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
    Builder builderResult = ImmutableCellVariable.builder();

    ImmutableReportGridCell.Builder builderResult2 = ImmutableReportGridCell.builder();
    builderResult2.addRatingIdValues(1L);

    ImmutableReportGridCell.Builder errorValueResult =
        builderResult2
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    ImmutableReportGridCell.Builder numberValueResult =
        errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    Set<Long> ratingIdValuesResult =
        builderResult
            .from(
                numberValueResult
                    .addAllOptions(new ArrayList<>())
                    .subjectId(1L)
                    .textValue("42")
                    .build())
            .build()
            .ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    Set<Long> ratingIdValuesResult2 = builderResult.build().ratingIdValues();
    assertEquals(1, ratingIdValuesResult2.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(ratingIdValuesResult2.contains(1L));
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualRatingIdValuesResult = builderResult.ratingIdValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingIdValuesResult);
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualRatingsResult = builderResult.ratings(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingsResult);
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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act
    Builder actualSubjectIdResult = builderResult.subjectId(1L);

    // Assert
    assertSame(builderResult, actualSubjectIdResult);
  }

  /**
   * Test {@link ImmutableCellVariable#cellName()}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#cellName()}
   */
  @Test
  @DisplayName("Test cellName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableCellVariable.cellName()"})
  void testCellName() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(
        "",
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .cellName());
  }

  /**
   * Test {@link ImmutableCellVariable#copyOf(CellVariable)}.
   *
   * <ul>
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  @DisplayName("Test copyOf(CellVariable); then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.copyOf(CellVariable)"})
  void testCopyOf_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable instance =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

    // Assert
    assertEquals("", actualCopyOfResult.cellName());
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
    assertSame(optionsResult, actualCopyOfResult.ratings());
    assertSame(ofResult, actualCopyOfResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#equals(Object)}, and {@link
   * ImmutableCellVariable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellVariable#equals(Object)}
   *   <li>{@link ImmutableCellVariable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable2 =
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    assertEquals(immutableCellVariable, immutableCellVariable2);
    assertEquals(immutableCellVariable.hashCode(), immutableCellVariable2.hashCode());
  }

  /**
   * Test {@link ImmutableCellVariable#equals(Object)}, and {@link
   * ImmutableCellVariable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellVariable#equals(Object)}
   *   <li>{@link ImmutableCellVariable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act and Assert
    assertEquals(immutableCellVariable, immutableCellVariable);
    int expectedHashCodeResult = immutableCellVariable.hashCode();
    assertEquals(expectedHashCodeResult, immutableCellVariable.hashCode());
  }

  /**
   * Test {@link ImmutableCellVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addRatingIdValues(1L);

    Builder errorValueResult =
        builderResult
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableCellVariable,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableCellVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(ImmutableCellOption.builder().code("Code").text("Text").build());

    Builder errorValueResult =
        builderResult
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableCellVariable,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableCellVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addRatings(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    Builder errorValueResult =
        builderResult
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    Builder errorValueResult2 =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult2 = errorValueResult2.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        immutableCellVariable,
        numberValueResult2.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build());
  }

  /**
   * Test {@link ImmutableCellVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
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
   * Test {@link ImmutableCellVariable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableCellVariable.equals(Object)",
    "int ImmutableCellVariable.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build(),
        "Different type to ImmutableCellVariable");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableCellVariable#toString()}
   *   <li>{@link ImmutableCellVariable#columnDefinitionId()}
   *   <li>{@link ImmutableCellVariable#comment()}
   *   <li>{@link ImmutableCellVariable#dateTimeValue()}
   *   <li>{@link ImmutableCellVariable#errorValue()}
   *   <li>{@link ImmutableCellVariable#numberValue()}
   *   <li>{@link ImmutableCellVariable#ratingIdValues()}
   *   <li>{@link ImmutableCellVariable#ratings()}
   *   <li>{@link ImmutableCellVariable#subjectId()}
   *   <li>{@link ImmutableCellVariable#textValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableCellVariable.columnDefinitionId()",
    "String ImmutableCellVariable.comment()",
    "LocalDateTime ImmutableCellVariable.dateTimeValue()",
    "String ImmutableCellVariable.errorValue()",
    "BigDecimal ImmutableCellVariable.numberValue()",
    "Set ImmutableCellVariable.ratingIdValues()",
    "Set ImmutableCellVariable.ratings()",
    "long ImmutableCellVariable.subjectId()",
    "String ImmutableCellVariable.textValue()",
    "String ImmutableCellVariable.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");
    BigDecimal numberValue = new BigDecimal("2.3");

    Builder numberValueResult = errorValueResult.numberValue(numberValue);
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    String actualToStringResult = immutableCellVariable.toString();
    Long actualColumnDefinitionIdResult = immutableCellVariable.columnDefinitionId();
    String actualCommentResult = immutableCellVariable.comment();
    LocalDateTime actualDateTimeValueResult = immutableCellVariable.dateTimeValue();
    String actualErrorValueResult = immutableCellVariable.errorValue();
    BigDecimal actualNumberValueResult = immutableCellVariable.numberValue();
    Set<Long> actualRatingIdValuesResult = immutableCellVariable.ratingIdValues();
    Set<RatingSchemeItem> actualRatingsResult = immutableCellVariable.ratings();
    long actualSubjectIdResult = immutableCellVariable.subjectId();

    // Assert
    assertEquals("00:00", actualDateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualDateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", immutableCellVariable.textValue());
    assertEquals("An error occurred", actualErrorValueResult);
    assertEquals(
        "CellVariable{columnDefinitionId=1, subjectId=1, ratingIdValues=[], numberValue=2.3, textValue=42,"
            + " errorValue=An error occurred, dateTimeValue=1970-01-01T00:00, options=[], ratings=[], cellName=}",
        actualToStringResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals(1L, actualColumnDefinitionIdResult.longValue());
    assertEquals(1L, actualSubjectIdResult);
    assertTrue(actualRatingIdValuesResult.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualNumberValueResult);
    assertSame(numberValue, actualNumberValueResult);
    assertSame(actualRatingIdValuesResult, actualRatingsResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableCellVariable#options()}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#options()}
   */
  @Test
  @DisplayName("Test options()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ImmutableCellVariable.options()"})
  void testOptions() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act and Assert
    assertTrue(
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .options()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableCellVariable#withColumnDefinitionId(Long)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withColumnDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withColumnDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withColumnDefinitionId(Long)"})
  void testWithColumnDefinitionId() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithColumnDefinitionIdResult =
        immutableCellVariable.withColumnDefinitionId(1L);

    // Assert
    assertSame(immutableCellVariable, actualWithColumnDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withColumnDefinitionId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#withColumnDefinitionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withColumnDefinitionId(Long); when forty-two; then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withColumnDefinitionId(Long)"})
  void testWithColumnDefinitionId_whenFortyTwo_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableCellVariable actualWithColumnDefinitionIdResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withColumnDefinitionId(42L);

    // Assert
    assertEquals("", actualWithColumnDefinitionIdResult.cellName());
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
    assertSame(optionsResult, actualWithColumnDefinitionIdResult.ratings());
    assertSame(ofResult, actualWithColumnDefinitionIdResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withComment(String)"})
  void testWithComment() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithCommentResult = immutableCellVariable.withComment("42");

    // Assert
    assertEquals(immutableCellVariable, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withComment(String)"})
  void testWithComment2() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("42")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithCommentResult = immutableCellVariable.withComment("42");

    // Assert
    assertSame(immutableCellVariable, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withDateTimeValue(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withDateTimeValue(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withDateTimeValue(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableCellVariable ImmutableCellVariable.withDateTimeValue(LocalDateTime)"
  })
  void testWithDateTimeValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithDateTimeValueResult =
        immutableCellVariable.withDateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableCellVariable, actualWithDateTimeValueResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withErrorValue(String)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withErrorValue(String)}
   */
  @Test
  @DisplayName("Test withErrorValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withErrorValue(String)"})
  void testWithErrorValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("42");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithErrorValueResult = immutableCellVariable.withErrorValue("42");

    // Assert
    assertSame(immutableCellVariable, actualWithErrorValueResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withErrorValue(String)}.
   *
   * <ul>
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#withErrorValue(String)}
   */
  @Test
  @DisplayName("Test withErrorValue(String); then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withErrorValue(String)"})
  void testWithErrorValue_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableCellVariable actualWithErrorValueResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withErrorValue("42");

    // Assert
    assertEquals("", actualWithErrorValueResult.cellName());
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
    assertSame(optionsResult, actualWithErrorValueResult.ratings());
    assertSame(ofResult, actualWithErrorValueResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withNumberValue(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withNumberValue(BigDecimal)}
   */
  @Test
  @DisplayName("Test withNumberValue(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withNumberValue(BigDecimal)"})
  void testWithNumberValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithNumberValueResult =
        immutableCellVariable.withNumberValue(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableCellVariable, actualWithNumberValueResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withNumberValue(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#withNumberValue(BigDecimal)}
   */
  @Test
  @DisplayName("Test withNumberValue(BigDecimal); then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withNumberValue(BigDecimal)"})
  void testWithNumberValue_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("4.5"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithNumberValueResult =
        immutableCellVariable.withNumberValue(new BigDecimal("2.3"));

    // Assert
    assertEquals("", actualWithNumberValueResult.cellName());
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
    assertSame(optionsResult, actualWithNumberValueResult.ratings());
    assertSame(ofResult, actualWithNumberValueResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withOptions(CellOption[])} with {@code CellOption[]}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withOptions(CellOption[])}
   */
  @Test
  @DisplayName("Test withOptions(CellOption[]) with 'CellOption[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withOptions(CellOption[])"})
  void testWithOptionsWithCellOption() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithOptionsResult =
        immutableCellVariable.withOptions(
            ImmutableCellOption.builder().code("Code").text("Text").build());

    // Assert
    assertEquals("", actualWithOptionsResult.cellName());
    assertEquals("42", actualWithOptionsResult.textValue());
    assertEquals("An error occurred", actualWithOptionsResult.errorValue());
    assertEquals("Comment", actualWithOptionsResult.comment());
    assertEquals(1, actualWithOptionsResult.options().size());
    assertEquals(1L, actualWithOptionsResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithOptionsResult.subjectId());
    Set<Long> ratingIdValuesResult = actualWithOptionsResult.ratingIdValues();
    assertTrue(ratingIdValuesResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithOptionsResult.numberValue());
    assertSame(ratingIdValuesResult, actualWithOptionsResult.ratings());
    assertSame(ofResult, actualWithOptionsResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withRatingIdValues(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#withRatingIdValues(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRatingIdValues(Iterable) with 'Iterable'; given one; then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withRatingIdValues(Iterable)"})
  void testWithRatingIdValuesWithIterable_givenOne_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableCellVariable actualWithRatingIdValuesResult =
        immutableCellVariable.withRatingIdValues(elements);

    // Assert
    assertEquals("", actualWithRatingIdValuesResult.cellName());
    assertEquals("42", actualWithRatingIdValuesResult.textValue());
    assertEquals("An error occurred", actualWithRatingIdValuesResult.errorValue());
    assertEquals("Comment", actualWithRatingIdValuesResult.comment());
    assertEquals(1L, actualWithRatingIdValuesResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithRatingIdValuesResult.subjectId());
    Set<CellOption> optionsResult = actualWithRatingIdValuesResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithRatingIdValuesResult.numberValue());
    assertEquals(elements, actualWithRatingIdValuesResult.ratingIdValues());
    assertSame(optionsResult, actualWithRatingIdValuesResult.ratings());
    assertSame(ofResult, actualWithRatingIdValuesResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withRatingIdValues(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withRatingIdValues(long[])}
   */
  @Test
  @DisplayName("Test withRatingIdValues(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withRatingIdValues(long[])"})
  void testWithRatingIdValuesWithLong() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableCellVariable actualWithRatingIdValuesResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withRatingIdValues(1L, -1L, 1L, -1L);

    // Assert
    assertEquals("", actualWithRatingIdValuesResult.cellName());
    assertEquals("42", actualWithRatingIdValuesResult.textValue());
    assertEquals("An error occurred", actualWithRatingIdValuesResult.errorValue());
    assertEquals("Comment", actualWithRatingIdValuesResult.comment());
    assertEquals(1L, actualWithRatingIdValuesResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithRatingIdValuesResult.subjectId());
    Set<Long> ratingIdValuesResult = actualWithRatingIdValuesResult.ratingIdValues();
    assertEquals(2, ratingIdValuesResult.size());
    assertTrue(ratingIdValuesResult.contains(-1L));
    assertTrue(ratingIdValuesResult.contains(1L));
    Set<CellOption> optionsResult = actualWithRatingIdValuesResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithRatingIdValuesResult.numberValue());
    assertSame(optionsResult, actualWithRatingIdValuesResult.ratings());
    assertSame(ofResult, actualWithRatingIdValuesResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withRatings(RatingSchemeItem[])} with {@code
   * RatingSchemeItem[]}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withRatings(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test withRatings(RatingSchemeItem[]) with 'RatingSchemeItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withRatings(RatingSchemeItem[])"})
  void testWithRatingsWithRatingSchemeItem() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithRatingsResult =
        immutableCellVariable.withRatings(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertEquals("42", actualWithRatingsResult.textValue());
    assertEquals("An error occurred", actualWithRatingsResult.errorValue());
    assertEquals("Comment", actualWithRatingsResult.comment());
    assertEquals("Name", actualWithRatingsResult.cellName());
    assertEquals(1, actualWithRatingsResult.ratings().size());
    assertEquals(1L, actualWithRatingsResult.columnDefinitionId().longValue());
    assertEquals(1L, actualWithRatingsResult.subjectId());
    Set<CellOption> optionsResult = actualWithRatingsResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, actualWithRatingsResult.numberValue());
    assertSame(optionsResult, actualWithRatingsResult.ratingIdValues());
    assertSame(ofResult, actualWithRatingsResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withSubjectId(long)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withSubjectId(long)}
   */
  @Test
  @DisplayName("Test withSubjectId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withSubjectId(long)"})
  void testWithSubjectId() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(42L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithSubjectIdResult = immutableCellVariable.withSubjectId(42L);

    // Assert
    assertSame(immutableCellVariable, actualWithSubjectIdResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withSubjectId(long)}.
   *
   * <ul>
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#withSubjectId(long)}
   */
  @Test
  @DisplayName("Test withSubjectId(long); then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withSubjectId(long)"})
  void testWithSubjectId_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableCellVariable actualWithSubjectIdResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("42")
            .build()
            .withSubjectId(42L);

    // Assert
    assertEquals("", actualWithSubjectIdResult.cellName());
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
    assertSame(optionsResult, actualWithSubjectIdResult.ratings());
    assertSame(ofResult, actualWithSubjectIdResult.dateTimeValue().toLocalDate());
  }

  /**
   * Test {@link ImmutableCellVariable#withTextValue(String)}.
   *
   * <p>Method under test: {@link ImmutableCellVariable#withTextValue(String)}
   */
  @Test
  @DisplayName("Test withTextValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withTextValue(String)"})
  void testWithTextValue() {
    // Arrange
    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));
    ImmutableCellVariable immutableCellVariable =
        numberValueResult.addAllOptions(new ArrayList<>()).subjectId(1L).textValue("42").build();

    // Act
    ImmutableCellVariable actualWithTextValueResult = immutableCellVariable.withTextValue("42");

    // Assert
    assertSame(immutableCellVariable, actualWithTextValueResult);
  }

  /**
   * Test {@link ImmutableCellVariable#withTextValue(String)}.
   *
   * <ul>
   *   <li>Then return cellName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableCellVariable#withTextValue(String)}
   */
  @Test
  @DisplayName("Test withTextValue(String); then return cellName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableCellVariable ImmutableCellVariable.withTextValue(String)"})
  void testWithTextValue_thenReturnCellNameIsEmptyString() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder errorValueResult =
        ImmutableCellVariable.builder()
            .columnDefinitionId(1L)
            .comment("Comment")
            .dateTimeValue(ofResult.atStartOfDay())
            .errorValue("An error occurred");

    Builder numberValueResult = errorValueResult.numberValue(new BigDecimal("2.3"));

    // Act
    ImmutableCellVariable actualWithTextValueResult =
        numberValueResult
            .addAllOptions(new ArrayList<>())
            .subjectId(1L)
            .textValue("Text Value")
            .build()
            .withTextValue("42");

    // Assert
    assertEquals("", actualWithTextValueResult.cellName());
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
    assertSame(optionsResult, actualWithTextValueResult.ratings());
    assertSame(ofResult, actualWithTextValueResult.dateTimeValue().toLocalDate());
  }
}
