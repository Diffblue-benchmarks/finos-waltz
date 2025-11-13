package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.CreatedProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission.Builder;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPlannedDecommissionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#createdAt(LocalDateTime)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#subjectDecommissionDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission Builder.build()",
    "Builder Builder.createdAt(LocalDateTime)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.subjectDecommissionDate(LocalDate)"
  })
  void testBuilderBuild() {
    // Arrange
    LocalDateTime createdAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission =
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(createdAt)
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(lastUpdatedAt)
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build();

    // Assert
    LocalDate plannedDecommissionDateResult =
        actualImmutableMeasurableRatingPlannedDecommission.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult =
        actualImmutableMeasurableRatingPlannedDecommission.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualImmutableMeasurableRatingPlannedDecommission.lastUpdatedBy());
    assertEquals(
        "Jan 1, 2020 8:00am GMT+0100",
        actualImmutableMeasurableRatingPlannedDecommission.createdBy());
    assertEquals(1L, actualImmutableMeasurableRatingPlannedDecommission.id().longValue());
    assertEquals(
        1L, actualImmutableMeasurableRatingPlannedDecommission.measurableRatingId().longValue());
    assertTrue(actualImmutableMeasurableRatingPlannedDecommission.isValid());
    assertSame(createdAt, actualImmutableMeasurableRatingPlannedDecommission.createdAt());
    assertSame(lastUpdatedAt, actualImmutableMeasurableRatingPlannedDecommission.lastUpdatedAt());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   *
   * <ul>
   *   <li>When {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName(
      "Test Builder createdBy(String); when 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy_whenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act
    Builder actualCreatedByResult = builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100");

    // Assert
    assertSame(builderResult, actualCreatedByResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    ImmutableMeasurableRatingPlannedDecommission instance =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission =
            builderResult.from((CreatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission);
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission2);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_givenJan12020800amGmt0100_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).createdAt();
    verify(instance).createdBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CreatedProvider) with 'CreatedProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException());
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    ImmutableMeasurableRatingPlannedDecommission instance =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission =
            builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission);
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommission)} with {@code
   * MeasurableRatingPlannedDecommission}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableRatingPlannedDecommission) with 'MeasurableRatingPlannedDecommission'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommission)"})
  void testBuilderFromWithMeasurableRatingPlannedDecommission() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    ImmutableMeasurableRatingPlannedDecommission instance =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission);
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommission)} with {@code
   * MeasurableRatingPlannedDecommission}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableRatingPlannedDecommission) with 'MeasurableRatingPlannedDecommission'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommission)"})
  void testBuilderFromWithMeasurableRatingPlannedDecommission2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    ImmutableMeasurableRatingPlannedDecommission instance =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(null)
            .build();

    // Act and Assert
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission);
    ImmutableMeasurableRatingPlannedDecommission
        actualImmutableMeasurableRatingPlannedDecommission2 = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommission2);
  }

  /**
   * Test Builder {@link Builder#id(Long)}.
   *
   * <p>Method under test: {@link Builder#id(Long)}
   */
  @Test
  @DisplayName("Test Builder id(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String); when '2020-03-01'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy_when20200301_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(Long)}.
   *
   * <p>Method under test: {@link Builder#measurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRatingId(Long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act
    Builder actualMeasurableRatingIdResult = builderResult.measurableRatingId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableRatingIdResult);
  }

  /**
   * Test Builder {@link Builder#plannedDecommissionDate(LocalDate)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plannedDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder plannedDecommissionDate(LocalDate); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedDecommissionDate(LocalDate)"})
  void testBuilderPlannedDecommissionDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act
    Builder actualPlannedDecommissionDateResult =
        builderResult.plannedDecommissionDate(LocalDate.of(1970, 1, 1));

    // Assert
    assertSame(builderResult, actualPlannedDecommissionDateResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommission#copyOf(MeasurableRatingPlannedDecommission)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#copyOf(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingPlannedDecommission); then return plannedDecommissionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.copyOf(MeasurableRatingPlannedDecommission)"
  })
  void testCopyOf_thenReturnPlannedDecommissionDateToStringIs19700101() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableRatingPlannedDecommission instance =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualCopyOfResult =
        ImmutableMeasurableRatingPlannedDecommission.copyOf(instance);

    // Assert
    LocalDate plannedDecommissionDateResult = actualCopyOfResult.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult = actualCopyOfResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCopyOfResult.createdBy());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(1L, actualCopyOfResult.measurableRatingId().longValue());
    assertTrue(actualCopyOfResult.isValid());
    assertSame(ofResult, actualCopyOfResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualCopyOfResult.lastUpdatedAt().toLocalDate());
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#createdAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#createdAt()}
   */
  @Test
  @DisplayName("Test createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurableRatingPlannedDecommission.createdAt()"})
  void testCreatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualCreatedAtResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build()
            .createdAt();

    // Assert
    assertEquals("00:00", actualCreatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualCreatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}, and {@link
   * ImmutableMeasurableRatingPlannedDecommission#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission2 =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission,
        immutableMeasurableRatingPlannedDecommission2);
    assertEquals(
        immutableMeasurableRatingPlannedDecommission.hashCode(),
        immutableMeasurableRatingPlannedDecommission2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}, and {@link
   * ImmutableMeasurableRatingPlannedDecommission#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission, immutableMeasurableRatingPlannedDecommission);
    int expectedHashCodeResult = immutableMeasurableRatingPlannedDecommission.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingPlannedDecommission.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.now().atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("2020-03-01")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(2L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.now().atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020/03/01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(2L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.now())
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.now())
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommission,
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommission.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommission.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build(),
        "Different type to ImmutableMeasurableRatingPlannedDecommission");
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given now.
   *   <li>Then return plannedDecommissionDate is now.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given now; then return plannedDecommissionDate is now")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.fromJson(Json)"
  })
  void testFromJson_givenNow_thenReturnPlannedDecommissionDateIsNow() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setId(1L);
    json.setMeasurableRatingId(1L);
    LocalDate plannedDecommissionDate = LocalDate.now();
    json.setPlannedDecommissionDate(plannedDecommissionDate);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    json.setSubjectDecommissionDate(subjectDecommissionDate);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualFromJsonResult =
        ImmutableMeasurableRatingPlannedDecommission.fromJson(json);

    // Assert
    LocalDate subjectDecommissionDateResult = actualFromJsonResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertSame(plannedDecommissionDate, actualFromJsonResult.plannedDecommissionDate());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return subjectDecommissionDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return subjectDecommissionDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.fromJson(Json)"
  })
  void testFromJson_thenReturnSubjectDecommissionDateIsNull() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setId(1L);
    json.setMeasurableRatingId(1L);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    json.setPlannedDecommissionDate(plannedDecommissionDate);
    json.setSubjectDecommissionDate(null);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualFromJsonResult =
        ImmutableMeasurableRatingPlannedDecommission.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.subjectDecommissionDate());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(plannedDecommissionDate, actualFromJsonResult.plannedDecommissionDate());
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return subjectDecommissionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return subjectDecommissionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.fromJson(Json)"
  })
  void testFromJson_thenReturnSubjectDecommissionDateToStringIs19700101() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    json.setCreatedAt(ofResult.atStartOfDay());
    json.setCreatedBy("Json");
    json.setId(1L);
    json.setMeasurableRatingId(1L);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    json.setPlannedDecommissionDate(plannedDecommissionDate);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    json.setSubjectDecommissionDate(subjectDecommissionDate);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualFromJsonResult =
        ImmutableMeasurableRatingPlannedDecommission.fromJson(json);

    // Assert
    LocalDate subjectDecommissionDateResult = actualFromJsonResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    LocalDateTime createdAtResult = actualFromJsonResult.createdAt();
    assertSame(ofResult, createdAtResult.toLocalDate());
    assertSame(plannedDecommissionDate, actualFromJsonResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
    assertSame(json.createdAt, createdAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) CreatedAt is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) CreatedAt is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.fromJson(Json)"
  })
  void testFromJson_whenJsonCreatedAtIsNull() {
    // Arrange
    Json json = new Json();
    json.setLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    json.setLastUpdatedBy("Json");
    json.setCreatedAt(null);
    json.setCreatedBy("Json");
    json.setId(1L);
    json.setMeasurableRatingId(1L);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    json.setPlannedDecommissionDate(plannedDecommissionDate);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    json.setSubjectDecommissionDate(subjectDecommissionDate);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualFromJsonResult =
        ImmutableMeasurableRatingPlannedDecommission.fromJson(json);

    // Assert
    LocalDate subjectDecommissionDateResult = actualFromJsonResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertSame(plannedDecommissionDate, actualFromJsonResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#toString()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#createdBy()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#id()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#lastUpdatedBy()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#measurableRatingId()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#plannedDecommissionDate()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#subjectDecommissionDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableMeasurableRatingPlannedDecommission.createdBy()",
    "Long ImmutableMeasurableRatingPlannedDecommission.id()",
    "String ImmutableMeasurableRatingPlannedDecommission.lastUpdatedBy()",
    "Long ImmutableMeasurableRatingPlannedDecommission.measurableRatingId()",
    "LocalDate ImmutableMeasurableRatingPlannedDecommission.plannedDecommissionDate()",
    "LocalDate ImmutableMeasurableRatingPlannedDecommission.subjectDecommissionDate()",
    "String ImmutableMeasurableRatingPlannedDecommission.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build();

    // Act
    String actualToStringResult = immutableMeasurableRatingPlannedDecommission.toString();
    String actualCreatedByResult = immutableMeasurableRatingPlannedDecommission.createdBy();
    Long actualIdResult = immutableMeasurableRatingPlannedDecommission.id();
    String actualLastUpdatedByResult = immutableMeasurableRatingPlannedDecommission.lastUpdatedBy();
    Long actualMeasurableRatingIdResult =
        immutableMeasurableRatingPlannedDecommission.measurableRatingId();
    LocalDate actualPlannedDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.plannedDecommissionDate();
    LocalDate actualSubjectDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.subjectDecommissionDate();

    // Assert
    assertEquals("1970-01-01", actualPlannedDecommissionDateResult.toString());
    assertEquals("1970-01-01", actualSubjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualCreatedByResult);
    assertEquals(
        "MeasurableRatingPlannedDecommission{lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " createdAt=1970-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100, id=1, measurableRatingId=1,"
            + " plannedDecommissionDate=1970-01-01, subjectDecommissionDate=1970-01-01, isValid=true}",
        actualToStringResult);
    assertEquals(1L, actualIdResult.longValue());
    assertEquals(1L, actualMeasurableRatingIdResult.longValue());
    assertSame(plannedDecommissionDate, actualPlannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, actualSubjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableMeasurableRatingPlannedDecommission.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build()
            .isValid());
  }

  /**
   * Test Json {@link Json#createdAt()}.
   *
   * <p>Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   *
   * <p>Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().createdBy());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCreatedAt(LocalDateTime)}
   *   <li>{@link Json#setCreatedBy(String)}
   *   <li>{@link Json#setId(Long)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   *   <li>{@link Json#setLastUpdatedBy(String)}
   *   <li>{@link Json#setMeasurableRatingId(Long)}
   *   <li>{@link Json#setPlannedDecommissionDate(LocalDate)}
   *   <li>{@link Json#setSubjectDecommissionDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCreatedAt(LocalDateTime)",
    "void Json.setCreatedBy(String)",
    "void Json.setId(Long)",
    "void Json.setLastUpdatedAt(LocalDateTime)",
    "void Json.setLastUpdatedBy(String)",
    "void Json.setMeasurableRatingId(Long)",
    "void Json.setPlannedDecommissionDate(LocalDate)",
    "void Json.setSubjectDecommissionDate(LocalDate)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#isValid()}.
   *
   * <p>Method under test: {@link Json#isValid()}
   */
  @Test
  @DisplayName("Test Json isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isValid()"})
  void testJsonIsValid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isValid());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#measurableRatingId()}.
   *
   * <p>Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRatingId());
  }

  /**
   * Test Json {@link Json#plannedDecommissionDate()}.
   *
   * <p>Method under test: {@link Json#plannedDecommissionDate()}
   */
  @Test
  @DisplayName("Test Json plannedDecommissionDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.plannedDecommissionDate()"})
  void testJsonPlannedDecommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedDecommissionDate());
  }

  /**
   * Test Json {@link Json#subjectDecommissionDate()}.
   *
   * <p>Method under test: {@link Json#subjectDecommissionDate()}
   */
  @Test
  @DisplayName("Test Json subjectDecommissionDate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDate Json.subjectDecommissionDate()"})
  void testJsonSubjectDecommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectDecommissionDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableMeasurableRatingPlannedDecommission.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedAtResult =
        immutableMeasurableRatingPlannedDecommission.withCreatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommission, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.now())
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedAtResult =
        immutableMeasurableRatingPlannedDecommission.withCreatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommission, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withCreatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedAt(LocalDateTime)"
  })
  void testWithCreatedAt3() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(null)
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedAtResult =
        immutableMeasurableRatingPlannedDecommission.withCreatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommission, actualWithCreatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedBy(String)"
  })
  void testWithCreatedBy() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedByResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withCreatedBy("42");

    // Assert
    LocalDate subjectDecommissionDateResult = actualWithCreatedByResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertSame(plannedDecommissionDate, actualWithCreatedByResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedBy(String)"
  })
  void testWithCreatedBy2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("42")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedByResult =
        immutableMeasurableRatingPlannedDecommission.withCreatedBy("42");

    // Assert
    assertSame(immutableMeasurableRatingPlannedDecommission, actualWithCreatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate is now.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}
   */
  @Test
  @DisplayName("Test withCreatedBy(String); then return plannedDecommissionDate is now")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedBy(String)"
  })
  void testWithCreatedBy_thenReturnPlannedDecommissionDateIsNow() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.now();
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedByResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withCreatedBy("42");

    // Assert
    LocalDate subjectDecommissionDateResult = actualWithCreatedByResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertSame(plannedDecommissionDate, actualWithCreatedByResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withCreatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withCreatedBy(String); then return plannedDecommissionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withCreatedBy(String)"
  })
  void testWithCreatedBy_thenReturnPlannedDecommissionDateToStringIs19700101() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithCreatedByResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(null)
            .build()
            .withCreatedBy("42");

    // Assert
    assertEquals("1970-01-01", actualWithCreatedByResult.plannedDecommissionDate().toString());
    assertEquals("2020-03-01", actualWithCreatedByResult.lastUpdatedBy());
    assertEquals("42", actualWithCreatedByResult.createdBy());
    assertNull(actualWithCreatedByResult.subjectDecommissionDate());
    assertEquals(1L, actualWithCreatedByResult.id().longValue());
    assertEquals(1L, actualWithCreatedByResult.measurableRatingId().longValue());
    assertTrue(actualWithCreatedByResult.isValid());
    assertSame(ofResult, actualWithCreatedByResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithCreatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withId(Long)"
  })
  void testWithId() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithIdResult =
        immutableMeasurableRatingPlannedDecommission.withId(1L);

    // Assert
    assertSame(immutableMeasurableRatingPlannedDecommission, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate is now.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long); then return plannedDecommissionDate is now")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withId(Long)"
  })
  void testWithId_thenReturnPlannedDecommissionDateIsNow() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.now();
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithIdResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withId(42L);

    // Assert
    LocalDate subjectDecommissionDateResult = actualWithIdResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals(42L, actualWithIdResult.id().longValue());
    assertSame(plannedDecommissionDate, actualWithIdResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}.
   *
   * <ul>
   *   <li>Then return subjectDecommissionDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long); then return subjectDecommissionDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withId(Long)"
  })
  void testWithId_thenReturnSubjectDecommissionDateIsNull() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithIdResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(null)
            .build()
            .withId(42L);

    // Assert
    assertNull(actualWithIdResult.subjectDecommissionDate());
    assertEquals(42L, actualWithIdResult.id().longValue());
    assertSame(plannedDecommissionDate, actualWithIdResult.plannedDecommissionDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}.
   *
   * <ul>
   *   <li>Then return subjectDecommissionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommission#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long); then return subjectDecommissionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withId(Long)"
  })
  void testWithId_thenReturnSubjectDecommissionDateToStringIs19700101() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithIdResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withId(42L);

    // Assert
    LocalDate subjectDecommissionDateResult = actualWithIdResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals(42L, actualWithIdResult.id().longValue());
    assertSame(plannedDecommissionDate, actualWithIdResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedAtResult =
        immutableMeasurableRatingPlannedDecommission.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommission, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.now())
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedAtResult =
        immutableMeasurableRatingPlannedDecommission.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommission, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt3() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(null)
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedAtResult =
        immutableMeasurableRatingPlannedDecommission.withLastUpdatedAt(
            LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommission, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedByResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDate subjectDecommissionDateResult =
        actualWithLastUpdatedByResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertSame(plannedDecommissionDate, actualWithLastUpdatedByResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("42")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedByResult =
        immutableMeasurableRatingPlannedDecommission.withLastUpdatedBy("42");

    // Assert
    assertSame(immutableMeasurableRatingPlannedDecommission, actualWithLastUpdatedByResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate is now.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String); then return plannedDecommissionDate is now")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnPlannedDecommissionDateIsNow() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.now();
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedByResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDate subjectDecommissionDateResult =
        actualWithLastUpdatedByResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertSame(plannedDecommissionDate, actualWithLastUpdatedByResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName(
      "Test withLastUpdatedBy(String); then return plannedDecommissionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy_thenReturnPlannedDecommissionDateToStringIs19700101() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithLastUpdatedByResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(null)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    assertEquals("1970-01-01", actualWithLastUpdatedByResult.plannedDecommissionDate().toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", actualWithLastUpdatedByResult.createdBy());
    assertNull(actualWithLastUpdatedByResult.subjectDecommissionDate());
    assertEquals(1L, actualWithLastUpdatedByResult.id().longValue());
    assertEquals(1L, actualWithLastUpdatedByResult.measurableRatingId().longValue());
    assertTrue(actualWithLastUpdatedByResult.isValid());
    assertSame(ofResult, actualWithLastUpdatedByResult.createdAt().toLocalDate());
    assertSame(ofResult2, actualWithLastUpdatedByResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withMeasurableRatingId(Long)"
  })
  void testWithMeasurableRatingId() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithMeasurableRatingIdResult =
        immutableMeasurableRatingPlannedDecommission.withMeasurableRatingId(1L);

    // Assert
    assertSame(immutableMeasurableRatingPlannedDecommission, actualWithMeasurableRatingIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissionDate is now.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(Long); then return plannedDecommissionDate is now")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withMeasurableRatingId(Long)"
  })
  void testWithMeasurableRatingId_thenReturnPlannedDecommissionDateIsNow() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.now();
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithMeasurableRatingIdResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withMeasurableRatingId(42L);

    // Assert
    LocalDate subjectDecommissionDateResult =
        actualWithMeasurableRatingIdResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals(42L, actualWithMeasurableRatingIdResult.measurableRatingId().longValue());
    assertSame(
        plannedDecommissionDate, actualWithMeasurableRatingIdResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}.
   *
   * <ul>
   *   <li>Then return subjectDecommissionDate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test withMeasurableRatingId(Long); then return subjectDecommissionDate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withMeasurableRatingId(Long)"
  })
  void testWithMeasurableRatingId_thenReturnSubjectDecommissionDateIsNull() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithMeasurableRatingIdResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(null)
            .build()
            .withMeasurableRatingId(42L);

    // Assert
    assertNull(actualWithMeasurableRatingIdResult.subjectDecommissionDate());
    assertEquals(42L, actualWithMeasurableRatingIdResult.measurableRatingId().longValue());
    assertSame(
        plannedDecommissionDate, actualWithMeasurableRatingIdResult.plannedDecommissionDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}.
   *
   * <ul>
   *   <li>Then return subjectDecommissionDate toString is {@code 1970-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withMeasurableRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test withMeasurableRatingId(Long); then return subjectDecommissionDate toString is '1970-01-01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withMeasurableRatingId(Long)"
  })
  void testWithMeasurableRatingId_thenReturnSubjectDecommissionDateToStringIs19700101() {
    // Arrange
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithMeasurableRatingIdResult =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build()
            .withMeasurableRatingId(42L);

    // Assert
    LocalDate subjectDecommissionDateResult =
        actualWithMeasurableRatingIdResult.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals(42L, actualWithMeasurableRatingIdResult.measurableRatingId().longValue());
    assertSame(
        plannedDecommissionDate, actualWithMeasurableRatingIdResult.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommission#withPlannedDecommissionDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withPlannedDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withPlannedDecommissionDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withPlannedDecommissionDate(LocalDate)"
  })
  void testWithPlannedDecommissionDate() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithPlannedDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.withPlannedDecommissionDate(
            LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission, actualWithPlannedDecommissionDateResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommission#withPlannedDecommissionDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withPlannedDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withPlannedDecommissionDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withPlannedDecommissionDate(LocalDate)"
  })
  void testWithPlannedDecommissionDate2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(null)
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithPlannedDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.withPlannedDecommissionDate(
            LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission, actualWithPlannedDecommissionDateResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommission#withPlannedDecommissionDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withPlannedDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withPlannedDecommissionDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withPlannedDecommissionDate(LocalDate)"
  })
  void testWithPlannedDecommissionDate3() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.ofYearDay(1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithPlannedDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.withPlannedDecommissionDate(
            LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission, actualWithPlannedDecommissionDateResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommission#withSubjectDecommissionDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withSubjectDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withSubjectDecommissionDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withSubjectDecommissionDate(LocalDate)"
  })
  void testWithSubjectDecommissionDate() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithSubjectDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.withSubjectDecommissionDate(
            LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission, actualWithSubjectDecommissionDateResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommission#withSubjectDecommissionDate(LocalDate)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommission#withSubjectDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test withSubjectDecommissionDate(LocalDate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommission.withSubjectDecommissionDate(LocalDate)"
  })
  void testWithSubjectDecommissionDate2() {
    // Arrange
    ImmutableMeasurableRatingPlannedDecommission immutableMeasurableRatingPlannedDecommission =
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(LocalDate.now())
            .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommission actualWithSubjectDecommissionDateResult =
        immutableMeasurableRatingPlannedDecommission.withSubjectDecommissionDate(
            LocalDate.of(1970, 1, 1));

    // Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommission, actualWithSubjectDecommissionDateResult);
  }
}
