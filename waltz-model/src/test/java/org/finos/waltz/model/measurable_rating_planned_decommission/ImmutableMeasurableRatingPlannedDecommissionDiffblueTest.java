package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPlannedDecommissionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#builder()}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission#createdAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission#lastUpdatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission#subjectDecommissionDate(LocalDate)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableRatingPlannedDecommission.Builder actualBuilderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    ImmutableMeasurableRatingPlannedDecommission.Builder actualCreatedAtResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    ImmutableMeasurableRatingPlannedDecommission.Builder actualLastUpdatedAtResult = actualCreatedAtResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.subjectDecommissionDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableMeasurableRatingPlannedDecommission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableRatingPlannedDecommission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    MeasurableRatingPlannedDecommission instance = mock(MeasurableRatingPlannedDecommission.class);
    when(instance.id()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.subjectDecommissionDate()).thenReturn(ofResult);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.plannedDecommissionDate()).thenReturn(ofResult2);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableMeasurableRatingPlannedDecommission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).id();
    verify(instance).measurableRatingId();
    verify(instance).plannedDecommissionDate();
    verify(instance).subjectDecommissionDate();
    ImmutableMeasurableRatingPlannedDecommission buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertTrue(buildResult.isValid());
    assertSame(ofResult2, buildResult.plannedDecommissionDate());
    assertSame(ofResult, buildResult.subjectDecommissionDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    MeasurableRatingPlannedDecommission instance = mock(MeasurableRatingPlannedDecommission.class);
    when(instance.measurableRatingId()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectDecommissionDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedDecommissionDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).measurableRatingId();
    verify(instance).plannedDecommissionDate();
    verify(instance).subjectDecommissionDate();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();
    MeasurableRatingPlannedDecommission instance = mock(MeasurableRatingPlannedDecommission.class);
    when(instance.id()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.subjectDecommissionDate()).thenReturn(null);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.plannedDecommissionDate()).thenReturn(ofResult);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableMeasurableRatingPlannedDecommission.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).id();
    verify(instance).measurableRatingId();
    verify(instance).plannedDecommissionDate();
    verify(instance).subjectDecommissionDate();
    ImmutableMeasurableRatingPlannedDecommission buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertNull(buildResult.subjectDecommissionDate());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(1L, buildResult.measurableRatingId().longValue());
    assertTrue(buildResult.isValid());
    assertSame(ofResult, buildResult.plannedDecommissionDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#id(Long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#measurableRatingId(Long)}
   */
  @Test
  void testBuilderMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Builder#plannedDecommissionDate(LocalDate)}
   */
  @Test
  void testBuilderPlannedDecommissionDate() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission.Builder builderResult = ImmutableMeasurableRatingPlannedDecommission
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedDecommissionDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission#copyOf(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingPlannedDecommission instance = mock(MeasurableRatingPlannedDecommission.class);
    when(instance.id()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.subjectDecommissionDate()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.plannedDecommissionDate()).thenReturn(ofResult3);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult4.atStartOfDay());

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualCopyOfResult = ImmutableMeasurableRatingPlannedDecommission
        .copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).id();
    verify(instance).measurableRatingId();
    verify(instance).plannedDecommissionDate();
    verify(instance).subjectDecommissionDate();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate plannedDecommissionDateResult = actualCopyOfResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualCopyOfResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertTrue(actualCopyOfResult.isValid());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult4, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, plannedDecommissionDateResult);
    assertSame(ofResult, subjectDecommissionDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission#copyOf(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableRatingPlannedDecommission instance = mock(MeasurableRatingPlannedDecommission.class);
    when(instance.id()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    when(instance.subjectDecommissionDate()).thenReturn(null);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.plannedDecommissionDate()).thenReturn(ofResult2);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualCopyOfResult = ImmutableMeasurableRatingPlannedDecommission
        .copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).id();
    verify(instance).measurableRatingId();
    verify(instance).plannedDecommissionDate();
    verify(instance).subjectDecommissionDate();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate plannedDecommissionDateResult = actualCopyOfResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertNull(actualCopyOfResult.subjectDecommissionDate());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertTrue(actualCopyOfResult.isValid());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, toLocalDateResult2);
    assertSame(ofResult2, plannedDecommissionDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission#copyOf(MeasurableRatingPlannedDecommission)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    MeasurableRatingPlannedDecommission instance = mock(MeasurableRatingPlannedDecommission.class);
    when(instance.id()).thenReturn(1L);
    when(instance.measurableRatingId()).thenReturn(1L);
    LocalDate ofYearDayResult = LocalDate.ofYearDay(31, 31);
    when(instance.subjectDecommissionDate()).thenReturn(ofYearDayResult);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.plannedDecommissionDate()).thenReturn(ofResult2);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualCopyOfResult = ImmutableMeasurableRatingPlannedDecommission
        .copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).id();
    verify(instance).measurableRatingId();
    verify(instance).plannedDecommissionDate();
    verify(instance).subjectDecommissionDate();
    LocalDate subjectDecommissionDateResult = actualCopyOfResult.subjectDecommissionDate();
    assertEquals("0031-01-31", subjectDecommissionDateResult.toString());
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDate plannedDecommissionDateResult = actualCopyOfResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertFalse(actualCopyOfResult.isValid());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult3, toLocalDateResult);
    assertSame(ofResult, toLocalDateResult2);
    assertSame(ofResult2, plannedDecommissionDateResult);
    assertSame(ofYearDayResult, subjectDecommissionDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).createdAt());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).createdBy());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setCreatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setCreatedBy(String)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission.Json#setId(Long)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setLastUpdatedBy(String)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setMeasurableRatingId(Long)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setPlannedDecommissionDate(LocalDate)}
   *   <li>
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#setSubjectDecommissionDate(LocalDate)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRatingPlannedDecommission.Json actualJson = new ImmutableMeasurableRatingPlannedDecommission.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setId(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult2.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setMeasurableRatingId(1L);
    actualJson.setPlannedDecommissionDate(LocalDate.of(1970, 1, 1));
    actualJson.setSubjectDecommissionDate(LocalDate.of(1970, 1, 1));

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = actualJson.lastUpdatedAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("1970-01-01", actualJson.plannedDecommissionDate.toString());
    assertEquals("1970-01-01", actualJson.subjectDecommissionDate.toString());
    assertEquals(1L, actualJson.id.longValue());
    assertEquals(1L, actualJson.measurableRatingId.longValue());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#isValid()}
   */
  @Test
  void testJsonIsValid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).isValid());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#measurableRatingId()}
   */
  @Test
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).measurableRatingId());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#plannedDecommissionDate()}
   */
  @Test
  void testJsonPlannedDecommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).plannedDecommissionDate());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingPlannedDecommission.Json#subjectDecommissionDate()}
   */
  @Test
  void testJsonSubjectDecommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingPlannedDecommission.Json()).subjectDecommissionDate());
  }
}
