package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   * Test {@link ImmutableMeasurableRatingPlannedDecommission#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#builder()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommission#subjectDecommissionDate(LocalDate)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMeasurableRatingPlannedDecommission Builder.build()",
      "Builder Builder.createdAt(LocalDateTime)", "Builder Builder.lastUpdatedAt(LocalDateTime)",
      "Builder Builder.subjectDecommissionDate(LocalDate)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    Builder actualCreatedAtResult = actualBuilderResult.createdAt(LocalDate.of(1970, 1, 1).atStartOfDay());
    Builder actualLastUpdatedAtResult = actualCreatedAtResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.subjectDecommissionDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Builder {@link Builder#createdBy(String)}.
   * <p>
   * Method under test: {@link Builder#createdBy(String)}
   */
  @Test
  @DisplayName("Test Builder createdBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.createdBy(String)"})
  void testBuilderCreatedBy() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.createdBy("Jan 1, 2020 8:00am GMT+0100"));
  }

  /**
   * Test Builder {@link Builder#from(CreatedProvider)} with {@code CreatedProvider}.
   * <ul>
   *   <li>Given {@code Jan 1, 2020 8:00am GMT+0100}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; given 'Jan 1, 2020 8:00am GMT+0100'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CreatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CreatedProvider) with 'CreatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CreatedProvider)"})
  void testBuilderFromWithCreatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    CreatedProvider instance = mock(CreatedProvider.class);
    when(instance.createdBy()).thenThrow(new IllegalStateException("instance"));
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).createdAt();
    verify(instance).createdBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommission)} with {@code MeasurableRatingPlannedDecommission}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPlannedDecommission) with 'MeasurableRatingPlannedDecommission'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommission)"})
  void testBuilderFromWithMeasurableRatingPlannedDecommission() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommission)} with {@code MeasurableRatingPlannedDecommission}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPlannedDecommission) with 'MeasurableRatingPlannedDecommission'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommission)"})
  void testBuilderFromWithMeasurableRatingPlannedDecommission2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
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
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommission)} with {@code MeasurableRatingPlannedDecommission}.
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPlannedDecommission) with 'MeasurableRatingPlannedDecommission'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommission)"})
  void testBuilderFromWithMeasurableRatingPlannedDecommission3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#id(Long)}.
   * <p>
   * Method under test: {@link Builder#id(Long)}
   */
  @Test
  @DisplayName("Test Builder id(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#measurableRatingId(Long)}.
   * <p>
   * Method under test: {@link Builder#measurableRatingId(Long)}
   */
  @Test
  @DisplayName("Test Builder measurableRatingId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableRatingId(Long)"})
  void testBuilderMeasurableRatingId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableRatingId(1L));
  }

  /**
   * Test Builder {@link Builder#plannedDecommissionDate(LocalDate)}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#plannedDecommissionDate(LocalDate)}
   */
  @Test
  @DisplayName("Test Builder plannedDecommissionDate(LocalDate); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.plannedDecommissionDate(LocalDate)"})
  void testBuilderPlannedDecommissionDate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommission.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedDecommissionDate(LocalDate.of(1970, 1, 1)));
  }

  /**
   * Test Json {@link Json#createdAt()}.
   * <p>
   * Method under test: {@link Json#createdAt()}
   */
  @Test
  @DisplayName("Test Json createdAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.createdAt()"})
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdAt());
  }

  /**
   * Test Json {@link Json#createdBy()}.
   * <p>
   * Method under test: {@link Json#createdBy()}
   */
  @Test
  @DisplayName("Test Json createdBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.createdBy()"})
  void testJsonCreatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).createdBy());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setCreatedAt(LocalDateTime)", "void Json.setCreatedBy(String)",
      "void Json.setId(Long)", "void Json.setLastUpdatedAt(LocalDateTime)", "void Json.setLastUpdatedBy(String)",
      "void Json.setMeasurableRatingId(Long)", "void Json.setPlannedDecommissionDate(LocalDate)",
      "void Json.setSubjectDecommissionDate(LocalDate)"})
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
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isValid()}.
   * <p>
   * Method under test: {@link Json#isValid()}
   */
  @Test
  @DisplayName("Test Json isValid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isValid()"})
  void testJsonIsValid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isValid());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#measurableRatingId()}.
   * <p>
   * Method under test: {@link Json#measurableRatingId()}
   */
  @Test
  @DisplayName("Test Json measurableRatingId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.measurableRatingId()"})
  void testJsonMeasurableRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableRatingId());
  }

  /**
   * Test Json {@link Json#plannedDecommissionDate()}.
   * <p>
   * Method under test: {@link Json#plannedDecommissionDate()}
   */
  @Test
  @DisplayName("Test Json plannedDecommissionDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.plannedDecommissionDate()"})
  void testJsonPlannedDecommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).plannedDecommissionDate());
  }

  /**
   * Test Json {@link Json#subjectDecommissionDate()}.
   * <p>
   * Method under test: {@link Json#subjectDecommissionDate()}
   */
  @Test
  @DisplayName("Test Json subjectDecommissionDate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDate Json.subjectDecommissionDate()"})
  void testJsonSubjectDecommissionDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectDecommissionDate());
  }
}
