package org.finos.waltz.service.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;

class ImmutableCellVariableDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableCellVariable.Builder actualCommentResult = ImmutableCellVariable.builder().comment("Comment");
    ImmutableCellVariable.Builder actualErrorValueResult = actualCommentResult
        .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
        .errorValue("An error occurred");
    ImmutableCellVariable.Builder actualNumberValueResult = actualErrorValueResult.numberValue(new BigDecimal("2.3"));

    // Assert
    assertSame(actualNumberValueResult, actualNumberValueResult.textValue("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addAllOptions(Iterable)}
   */
  @Test
  void testBuilderAddAllOptions() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOptions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIdValues() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIdValues2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIdValues3() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(mock(CellOption.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addAllRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllRatings() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addOptions(CellOption)}
   */
  @Test
  void testBuilderAddOptions() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(mock(CellOption.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addOptions(CellOption[])}
   */
  @Test
  void testBuilderAddOptions2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(mock(CellOption.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addRatingIdValues(long)}
   */
  @Test
  void testBuilderAddRatingIdValues() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addRatingIdValues(long)}
   */
  @Test
  void testBuilderAddRatingIdValues2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(mock(CellOption.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addRatingIdValues(long[])}
   */
  @Test
  void testBuilderAddRatingIdValues3() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L, -3L, 1L, -3L));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addRatingIdValues(long[])}
   */
  @Test
  void testBuilderAddRatingIdValues4() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(mock(CellOption.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L, -3L, 1L, -3L));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addRatings(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatings() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(mock(RatingSchemeItem.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#addRatings(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatings2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(mock(RatingSchemeItem.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#columnDefinitionId(Long)}
   */
  @Test
  void testBuilderColumnDefinitionId() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#columnDefinitionId(Long)}
   */
  @Test
  void testBuilderColumnDefinitionId2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(mock(CellOption.class));

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertNull(buildResult.comment());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.errorValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.textValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.numberValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    Set<Long> ratingIdValuesResult = buildResult.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(mock(CellOption.class));
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
    when(instance.options()).thenReturn(cellOptionSet);

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals(1, buildResult.options().size());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.comment()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).comment();
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn(null);
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertNull(buildResult.comment());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn(null);
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.errorValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn(null);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.textValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
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
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.numberValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    Set<Long> ratingIdValuesResult = buildResult.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertTrue(ratingIdValuesResult.contains(1L));
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(mock(RatingSchemeItem.class));
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    when(instance.dateTimeValue()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(ratingSchemeItemSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals("null", buildResult.cellName());
    assertEquals(1, buildResult.ratings().size());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(mock(CellOption.class));
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
    when(instance.options()).thenReturn(cellOptionSet);

    // Act
    ImmutableCellVariable.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableCellVariable buildResult = builderResult.build();
    assertEquals("", buildResult.cellName());
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals(1, buildResult.options().size());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#from(CellVariable)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    CellVariable instance = mock(CellVariable.class);
    when(instance.textValue()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).textValue();
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#options(Iterable)}
   */
  @Test
  void testBuilderOptions() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.options(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#ratingIdValues(Iterable)}
   */
  @Test
  void testBuilderRatingIdValues() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#ratingIdValues(Iterable)}
   */
  @Test
  void testBuilderRatingIdValues2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableCellVariable.Builder#ratingIdValues(Iterable)}
   */
  @Test
  void testBuilderRatingIdValues3() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(mock(CellOption.class));

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#ratings(Iterable)}
   */
  @Test
  void testBuilderRatings() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#subjectId(long)}
   */
  @Test
  void testBuilderSubjectId() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectId(1L));
  }

  /**
   * Method under test: {@link ImmutableCellVariable.Builder#subjectId(long)}
   */
  @Test
  void testBuilderSubjectId2() {
    // Arrange
    ImmutableCellVariable.Builder builderResult = ImmutableCellVariable.builder();
    builderResult.addOptions(mock(CellOption.class));

    // Act and Assert
    assertSame(builderResult, builderResult.subjectId(1L));
  }

  /**
   * Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

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
    assertEquals("", actualCopyOfResult.cellName());
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
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(bigDecimal, numberValueResult);
    assertSame(optionsResult, actualCopyOfResult.ratingIdValues());
    assertSame(optionsResult, actualCopyOfResult.ratings());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

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
    assertEquals("", actualCopyOfResult.cellName());
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertNull(actualCopyOfResult.numberValue());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    Set<CellOption> optionsResult = actualCopyOfResult.options();
    assertTrue(optionsResult.isEmpty());
    assertSame(optionsResult, actualCopyOfResult.ratingIdValues());
    assertSame(optionsResult, actualCopyOfResult.ratings());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(3L);
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

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
    assertEquals("", actualCopyOfResult.cellName());
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    Set<Long> ratingIdValuesResult = actualCopyOfResult.ratingIdValues();
    assertEquals(1, ratingIdValuesResult.size());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    assertTrue(ratingIdValuesResult.contains(3L));
    Set<CellOption> optionsResult = actualCopyOfResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(bigDecimal, numberValueResult);
    assertSame(optionsResult, actualCopyOfResult.ratings());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(3L);
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.ratings()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

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
    assertEquals("", actualCopyOfResult.cellName());
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
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertEquals(resultLongSet, actualCopyOfResult.ratingIdValues());
    assertSame(bigDecimal, numberValueResult);
    assertSame(optionsResult, actualCopyOfResult.ratings());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    when(ratingSchemeItem.name()).thenReturn("Name");

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(ratingSchemeItem);
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(ratingSchemeItemSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(ratingSchemeItem).name();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    verify(instance).ratings();
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Name", actualCopyOfResult.cellName());
    assertEquals(1, actualCopyOfResult.ratings().size());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    Set<CellOption> optionsResult = actualCopyOfResult.options();
    assertTrue(optionsResult.isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(bigDecimal, numberValueResult);
    assertSame(optionsResult, actualCopyOfResult.ratingIdValues());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableCellVariable#copyOf(CellVariable)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    RatingSchemeItem ratingSchemeItem = mock(RatingSchemeItem.class);
    when(ratingSchemeItem.name()).thenReturn("Name");

    HashSet<RatingSchemeItem> ratingSchemeItemSet = new HashSet<>();
    ratingSchemeItemSet.add(ratingSchemeItem);

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(mock(CellOption.class));
    CellVariable instance = mock(CellVariable.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.ratings()).thenReturn(ratingSchemeItemSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(cellOptionSet);

    // Act
    ImmutableCellVariable actualCopyOfResult = ImmutableCellVariable.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(ratingSchemeItem).name();
    verify(instance).columnDefinitionId();
    verify(instance).dateTimeValue();
    verify(instance).errorValue();
    verify(instance).numberValue();
    verify(instance).options();
    verify(instance).ratingIdValues();
    verify(instance).subjectId();
    verify(instance).textValue();
    verify(instance).ratings();
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Name", actualCopyOfResult.cellName());
    assertEquals(1, actualCopyOfResult.options().size());
    assertEquals(1, actualCopyOfResult.ratings().size());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    assertTrue(actualCopyOfResult.ratingIdValues().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(bigDecimal, numberValueResult);
    assertSame(ofResult, toLocalDateResult);
  }
}
