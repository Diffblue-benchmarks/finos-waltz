package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.finos.waltz.model.report_grid.CellOption;
import org.finos.waltz.model.report_grid.ReportGridCell;
import org.finos.waltz.service.report_grid.ImmutableCellVariable.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCellVariableDiffblueTest {
  /**
   * Test {@link ImmutableCellVariable#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCellVariable#builder()}
   *   <li>{@link ImmutableCellVariable#comment(String)}
   *   <li>{@link ImmutableCellVariable#dateTimeValue(LocalDateTime)}
   *   <li>{@link ImmutableCellVariable#errorValue(String)}
   *   <li>{@link ImmutableCellVariable#numberValue(BigDecimal)}
   *   <li>{@link ImmutableCellVariable#textValue(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCellVariable Builder.build()", "Builder Builder.comment(String)",
      "Builder Builder.dateTimeValue(LocalDateTime)", "Builder Builder.errorValue(String)",
      "Builder Builder.numberValue(BigDecimal)", "Builder Builder.textValue(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualCommentResult = ImmutableCellVariable.builder().comment("Comment");
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRatings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatings(Iterable)"})
  void testBuilderAddAllRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption)} with {@code element}.
   * <ul>
   *   <li>When {@link CellOption}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOptions(CellOption)}
   */
  @Test
  @DisplayName("Test Builder addOptions(CellOption) with 'element'; when CellOption; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption)"})
  void testBuilderAddOptionsWithElement_whenCellOption_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(mock(CellOption.class)));
  }

  /**
   * Test Builder {@link Builder#addOptions(CellOption[])} with {@code elements}.
   * <ul>
   *   <li>When {@link CellOption}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addOptions(CellOption[])}
   */
  @Test
  @DisplayName("Test Builder addOptions(CellOption[]) with 'elements'; when CellOption; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addOptions(CellOption[])"})
  void testBuilderAddOptionsWithElements_whenCellOption_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(mock(CellOption.class)));
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L, -3L, 1L, -3L));
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem)} with {@code element}.
   * <ul>
   *   <li>When {@link RatingSchemeItem}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder addRatings(RatingSchemeItem) with 'element'; when RatingSchemeItem; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem)"})
  void testBuilderAddRatingsWithElement_whenRatingSchemeItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(mock(RatingSchemeItem.class)));
  }

  /**
   * Test Builder {@link Builder#addRatings(RatingSchemeItem[])} with {@code elements}.
   * <ul>
   *   <li>When {@link RatingSchemeItem}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatings(RatingSchemeItem[])}
   */
  @Test
  @DisplayName("Test Builder addRatings(RatingSchemeItem[]) with 'elements'; when RatingSchemeItem; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatings(RatingSchemeItem[])"})
  void testBuilderAddRatingsWithElements_whenRatingSchemeItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(mock(RatingSchemeItem.class)));
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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build cellName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build cellName is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildCellNameIsEmptyString() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("", buildResult.cellName());
    ImmutableCellVariable buildResult2 = builderResult.build();
    assertEquals("", buildResult2.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("42", buildResult2.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("An error occurred", buildResult2.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals("Comment", buildResult2.comment());
    assertTrue(buildResult.options().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    assertEquals(expectedNumberValueResult, buildResult.numberValue());
    assertSame(bigDecimal, buildResult2.numberValue());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build cellName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build cellName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildCellNameIsNull() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(ratingSchemeItemSet);
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
    verify(instance).ratings();
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("null", buildResult.cellName());
    ImmutableCellVariable buildResult2 = builderResult.build();
    assertEquals("null", buildResult2.cellName());
    assertEquals(1, buildResult.ratings().size());
    assertEquals(1, buildResult2.ratings().size());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildCommentIsNull() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn(null);
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    assertNull(actualFromResult.build().comment());
    assertNull(builderResult.build().comment());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build errorValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build errorValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildErrorValueIsNull() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn(null);
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    assertNull(actualFromResult.build().errorValue());
    assertNull(builderResult.build().errorValue());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build numberValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build numberValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildNumberValueIsNull() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(null);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    assertNull(actualFromResult.build().numberValue());
    assertNull(builderResult.build().numberValue());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build options size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build options size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildOptionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(mock(CellOption.class));
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals(1, buildResult.options().size());
    assertEquals(1, builderResult.build().options().size());
    Set<Long> ratingIdValuesResult = buildResult.ratingIdValues();
    assertTrue(ratingIdValuesResult.isEmpty());
    assertSame(ratingIdValuesResult, buildResult.ratings());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build ratingIdValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build ratingIdValues size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildRatingIdValuesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    Set<Long> ratingIdValuesResult = actualFromResult.build().ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    Set<Long> ratingIdValuesResult2 = builderResult.build().ratingIdValues();
    assertEquals(1, ratingIdValuesResult2.size());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertTrue(ratingIdValuesResult2.contains(1L));
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then return build textValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then return build textValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenReturnBuildTextValueIsNull() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn(null);
    when(instance.numberValue()).thenReturn(new BigDecimal("2.3"));
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
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
    verify(instance).ratings();
    assertNull(actualFromResult.build().textValue());
    assertNull(builderResult.build().textValue());
  }

  /**
   * Test Builder {@link Builder#from(CellVariable)} with {@code CellVariable}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CellVariable)}
   */
  @Test
  @DisplayName("Test Builder from(CellVariable) with 'CellVariable'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CellVariable)"})
  void testBuilderFromWithCellVariable_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.textValue()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).textValue();
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CommentProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CommentProvider) with 'CommentProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CommentProvider)"})
  void testBuilderFromWithCommentProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
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
    Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableCellVariable buildResult2 = builderResult.build();
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
    Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableCellVariable buildResult2 = builderResult.build();
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
    Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableCellVariable buildResult2 = builderResult.build();
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
    Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("42", buildResult.textValue());
    ImmutableCellVariable buildResult2 = builderResult.build();
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
    Builder builderResult = ImmutableCellVariable.builder();

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(mock(CellOption.class));
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
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals(1, buildResult.options().size());
    assertEquals(1, builderResult.build().options().size());
    Set<Long> ratingIdValuesResult = buildResult.ratingIdValues();
    assertTrue(ratingIdValuesResult.isEmpty());
    assertSame(ratingIdValuesResult, buildResult.ratings());
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable buildResult = actualFromResult.build();
    assertEquals("An error occurred", buildResult.errorValue());
    ImmutableCellVariable buildResult2 = builderResult.build();
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
   * Test Builder {@link Builder#from(ReportGridCell)} with {@code ReportGridCell}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridCell)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridCell) with 'ReportGridCell'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridCell)"})
  void testBuilderFromWithReportGridCell_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#ratings(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratings(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratings(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratings(Iterable)"})
  void testBuilderRatings_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
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
    Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectId(1L));
  }
}
