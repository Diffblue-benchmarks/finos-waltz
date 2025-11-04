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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.CommentProvider;
import org.junit.jupiter.api.Test;

class ImmutableReportGridCellDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridCell.Builder actualCommentResult = ImmutableReportGridCell.builder().comment("Comment");
    ImmutableReportGridCell.Builder actualErrorValueResult = actualCommentResult
        .dateTimeValue(LocalDate.of(1970, 1, 1).atStartOfDay())
        .errorValue("An error occurred");
    ImmutableReportGridCell.Builder actualNumberValueResult = actualErrorValueResult.numberValue(new BigDecimal("2.3"));

    // Assert
    assertSame(actualNumberValueResult, actualNumberValueResult.textValue("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addAllOptions(Iterable)}
   */
  @Test
  void testBuilderAddAllOptions() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOptions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIdValues() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addAllRatingIdValues(Iterable)}
   */
  @Test
  void testBuilderAddAllRatingIdValues2() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIdValues(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addOptions(CellOption)}
   */
  @Test
  void testBuilderAddOptions() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(new ImmutableCellOption.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addOptions(CellOption[])}
   */
  @Test
  void testBuilderAddOptions2() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addOptions(new ImmutableCellOption.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addRatingIdValues(long)}
   */
  @Test
  void testBuilderAddRatingIdValues() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#addRatingIdValues(long[])}
   */
  @Test
  void testBuilderAddRatingIdValues2() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIdValues(1L, -3L, 1L, -3L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#columnDefinitionId(Long)}
   */
  @Test
  void testBuilderColumnDefinitionId() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnDefinitionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn("Comment");

    // Act
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(CommentProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
    CommentProvider instance = mock(CommentProvider.class);
    when(instance.comment()).thenReturn(null);

    // Act
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertNull(buildResult.comment());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
    assertEquals("42", buildResult.textValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.errorValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.textValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(bigDecimal, buildResult.numberValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();
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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
    assertEquals("42", buildResult.textValue());
    assertEquals("An error occurred", buildResult.errorValue());
    assertEquals("Comment", buildResult.comment());
    assertNull(buildResult.numberValue());
    assertEquals(1L, buildResult.columnDefinitionId().longValue());
    assertEquals(1L, buildResult.subjectId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
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
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#from(ReportGridCell)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(new ImmutableCellOption.Json());
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
    ImmutableReportGridCell.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridCell buildResult = builderResult.build();
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
   * Method under test: {@link ImmutableReportGridCell.Builder#options(Iterable)}
   */
  @Test
  void testBuilderOptions() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.options(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#ratingIdValues(Iterable)}
   */
  @Test
  void testBuilderRatingIdValues() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridCell.Builder#ratingIdValues(Iterable)}
   */
  @Test
  void testBuilderRatingIdValues2() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIdValues(elements));
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Builder#subjectId(long)}
   */
  @Test
  void testBuilderSubjectId() {
    // Arrange
    ImmutableReportGridCell.Builder builderResult = ImmutableReportGridCell.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectId(1L));
  }

  /**
   * Method under test: {@link ImmutableReportGridCell#copyOf(ReportGridCell)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridCell actualCopyOfResult = ImmutableReportGridCell.copyOf(instance);

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
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell#copyOf(ReportGridCell)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    when(instance.numberValue()).thenReturn(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridCell actualCopyOfResult = ImmutableReportGridCell.copyOf(instance);

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
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell#copyOf(ReportGridCell)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(3L);
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridCell actualCopyOfResult = ImmutableReportGridCell.copyOf(instance);

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
    assertTrue(actualCopyOfResult.options().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(bigDecimal, numberValueResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell#copyOf(ReportGridCell)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    resultLongSet.add(3L);
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(resultLongSet);
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(new HashSet<>());

    // Act
    ImmutableReportGridCell actualCopyOfResult = ImmutableReportGridCell.copyOf(instance);

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
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    assertTrue(actualCopyOfResult.options().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertEquals(resultLongSet, actualCopyOfResult.ratingIdValues());
    assertSame(bigDecimal, numberValueResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell#copyOf(ReportGridCell)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    HashSet<CellOption> cellOptionSet = new HashSet<>();
    cellOptionSet.add(new ImmutableCellOption.Json());
    ReportGridCell instance = mock(ReportGridCell.class);
    when(instance.columnDefinitionId()).thenReturn(1L);
    when(instance.comment()).thenReturn("Comment");
    when(instance.errorValue()).thenReturn("An error occurred");
    when(instance.textValue()).thenReturn("42");
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(instance.numberValue()).thenReturn(bigDecimal);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.dateTimeValue()).thenReturn(ofResult.atStartOfDay());
    when(instance.ratingIdValues()).thenReturn(new HashSet<>());
    when(instance.subjectId()).thenReturn(1L);
    when(instance.options()).thenReturn(cellOptionSet);

    // Act
    ImmutableReportGridCell actualCopyOfResult = ImmutableReportGridCell.copyOf(instance);

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
    LocalDateTime dateTimeValueResult = actualCopyOfResult.dateTimeValue();
    assertEquals("00:00", dateTimeValueResult.toLocalTime().toString());
    LocalDate toLocalDateResult = dateTimeValueResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualCopyOfResult.textValue());
    assertEquals("An error occurred", actualCopyOfResult.errorValue());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals(1, actualCopyOfResult.options().size());
    assertEquals(1L, actualCopyOfResult.columnDefinitionId().longValue());
    assertEquals(1L, actualCopyOfResult.subjectId());
    assertTrue(actualCopyOfResult.ratingIdValues().isEmpty());
    BigDecimal expectedNumberValueResult = new BigDecimal("2.3");
    BigDecimal numberValueResult = actualCopyOfResult.numberValue();
    assertEquals(expectedNumberValueResult, numberValueResult);
    assertSame(bigDecimal, numberValueResult);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#columnDefinitionId()}
   */
  @Test
  void testJsonColumnDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).columnDefinitionId());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).comment());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#dateTimeValue()}
   */
  @Test
  void testJsonDateTimeValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).dateTimeValue());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#errorValue()}
   */
  @Test
  void testJsonErrorValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).errorValue());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridCell.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridCell.Json actualJson = new ImmutableReportGridCell.Json();

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
   * Method under test: {@link ImmutableReportGridCell.Json#numberValue()}
   */
  @Test
  void testJsonNumberValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).numberValue());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#options()}
   */
  @Test
  void testJsonOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).options());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#ratingIdValues()}
   */
  @Test
  void testJsonRatingIdValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).ratingIdValues());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#setOptions(Set)}
   */
  @Test
  void testJsonSetOptions() {
    // Arrange
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();

    // Act
    json.setOptions(new HashSet<>());

    // Assert
    assertTrue(json.options.isEmpty());
    assertTrue(json.ratingIdValues.isEmpty());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#setOptions(Set)}
   */
  @Test
  void testJsonSetOptions2() {
    // Arrange
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();

    // Act
    json.setOptions(null);

    // Assert
    assertNull(json.options);
    assertFalse(json.optionsIsSet);
    assertTrue(json.ratingIdValues.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#setOptions(Set)}
   */
  @Test
  void testJsonSetOptions3() {
    // Arrange
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();

    HashSet<CellOption> options = new HashSet<>();
    options.add(new ImmutableCellOption.Json());

    // Act
    json.setOptions(options);

    // Assert
    assertEquals(1, json.options.size());
    assertTrue(json.ratingIdValues.isEmpty());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#setOptions(Set)}
   */
  @Test
  void testJsonSetOptions4() {
    // Arrange
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();

    HashSet<CellOption> options = new HashSet<>();
    options.add(new ImmutableCellOption.Json());
    options.add(new ImmutableCellOption.Json());

    // Act
    json.setOptions(options);

    // Assert
    assertEquals(2, json.options.size());
    assertTrue(json.ratingIdValues.isEmpty());
    assertTrue(json.optionsIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#setSubjectId(long)}
   */
  @Test
  void testJsonSetSubjectId() {
    // Arrange
    ImmutableReportGridCell.Json json = new ImmutableReportGridCell.Json();

    // Act
    json.setSubjectId(1L);

    // Assert
    assertEquals(1L, json.subjectId);
    assertTrue(json.subjectIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#subjectId()}
   */
  @Test
  void testJsonSubjectId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).subjectId());
  }

  /**
   * Method under test: {@link ImmutableReportGridCell.Json#textValue()}
   */
  @Test
  void testJsonTextValue() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridCell.Json()).textValue());
  }
}
