package org.finos.waltz.model.measurable_rating_replacement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.LastUpdatedProvider;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingReplacementDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingReplacement#builder()}
   *   <li>{@link ImmutableMeasurableRatingReplacement#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRatingReplacement#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMeasurableRatingReplacement.Builder actualBuilderResult = ImmutableMeasurableRatingReplacement.builder();
    ImmutableMeasurableRatingReplacement.Builder actualCreatedAtResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualCreatedAtResult, actualCreatedAtResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#createdBy(String)}
   */
  @Test
  void testBuilderCreatedBy() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#decommissionId(Long)}
   */
  @Test
  void testBuilderDecommissionId() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.decommissionId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    ImmutableMeasurableRatingReplacement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(CreatedProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
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
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
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
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(MeasurableRatingReplacement)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
    MeasurableRatingReplacement instance = mock(MeasurableRatingReplacement.class);
    when(instance.entityReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedCommissionDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).entityReference();
    verify(instance).plannedCommissionDate();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(MeasurableRatingReplacement)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
    MeasurableRatingReplacement instance = mock(MeasurableRatingReplacement.class);
    when(instance.decommissionId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.plannedCommissionDate()).thenReturn(fromResult);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).decommissionId();
    verify(instance).entityReference();
    verify(instance).id();
    verify(instance).plannedCommissionDate();
    ImmutableMeasurableRatingReplacement buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", buildResult.createdBy());
    assertEquals(1L, buildResult.decommissionId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertSame(fromResult, buildResult.plannedCommissionDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#from(MeasurableRatingReplacement)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();
    MeasurableRatingReplacement instance = mock(MeasurableRatingReplacement.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.plannedCommissionDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).entityReference();
    verify(instance).id();
    verify(instance).plannedCommissionDate();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#id(Long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#plannedCommissionDate(Date)}
   */
  @Test
  void testBuilderPlannedCommissionDate() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult
        .plannedCommissionDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Builder#plannedCommissionDate(java.util.Date)}
   */
  @Test
  void testBuilderPlannedCommissionDate2() {
    // Arrange
    ImmutableMeasurableRatingReplacement.Builder builderResult = ImmutableMeasurableRatingReplacement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedCommissionDate(mock(java.sql.Date.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement#copyOf(MeasurableRatingReplacement)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableRatingReplacement instance = mock(MeasurableRatingReplacement.class);
    when(instance.decommissionId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.plannedCommissionDate()).thenReturn(fromResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableMeasurableRatingReplacement actualCopyOfResult = ImmutableMeasurableRatingReplacement.copyOf(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).decommissionId();
    verify(instance).entityReference();
    verify(instance).id();
    verify(instance).plannedCommissionDate();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(1L, actualCopyOfResult.decommissionId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(ofResult2, toLocalDateResult);
    assertSame(ofResult, toLocalDateResult2);
    assertSame(fromResult, actualCopyOfResult.plannedCommissionDate());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).createdAt());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#createdBy()}
   */
  @Test
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).createdBy());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#decommissionId()}
   */
  @Test
  void testJsonDecommissionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).decommissionId());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableRatingReplacement.Json}
   *   <li>
   * {@link ImmutableMeasurableRatingReplacement.Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRatingReplacement.Json#setCreatedBy(String)}
   *   <li>{@link ImmutableMeasurableRatingReplacement.Json#setDecommissionId(Long)}
   *   <li>
   * {@link ImmutableMeasurableRatingReplacement.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableMeasurableRatingReplacement.Json#setId(Long)}
   *   <li>
   * {@link ImmutableMeasurableRatingReplacement.Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>
   * {@link ImmutableMeasurableRatingReplacement.Json#setLastUpdatedBy(String)}
   *   <li>
   * {@link ImmutableMeasurableRatingReplacement.Json#setPlannedCommissionDate(Date)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableRatingReplacement.Json actualJson = new ImmutableMeasurableRatingReplacement.Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setCreatedAt(ofResult.atStartOfDay());
    actualJson.setCreatedBy("Jan 1, 2020 8:00am GMT+0100");
    actualJson.setDecommissionId(1L);
    actualJson.setEntityReference(null);
    actualJson.setId(1L);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult2.atStartOfDay());
    actualJson.setLastUpdatedBy("2020-03-01");
    actualJson.setPlannedCommissionDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    LocalDateTime localDateTime = actualJson.createdAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDate toLocalDateResult2 = actualJson.lastUpdatedAt.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    assertEquals(1L, actualJson.decommissionId.longValue());
    assertEquals(1L, actualJson.id.longValue());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
  }

  /**
   * Method under test: {@link ImmutableMeasurableRatingReplacement.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableRatingReplacement.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).lastUpdatedAt());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).lastUpdatedBy());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableRatingReplacement.Json#plannedCommissionDate()}
   */
  @Test
  void testJsonPlannedCommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableRatingReplacement.Json()).plannedCommissionDate());
  }
}
