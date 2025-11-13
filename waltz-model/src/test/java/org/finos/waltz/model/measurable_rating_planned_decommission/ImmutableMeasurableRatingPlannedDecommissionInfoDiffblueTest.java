package org.finos.waltz.model.measurable_rating_planned_decommission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRating;
import org.finos.waltz.model.measurable_rating.MeasurableRating;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommissionInfo.Builder;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommissionInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingPlannedDecommissionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingPlannedDecommissionInfo Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();
    ImmutableMeasurableRatingPlannedDecommission decommission =
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
    Builder actualDecommissionResult = actualBuilderResult.decommission(decommission);
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRating measurableRating =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build();
    ImmutableMeasurableRatingPlannedDecommissionInfo
        actualImmutableMeasurableRatingPlannedDecommissionInfo =
            actualDecommissionResult.measurableRating(measurableRating).build();

    // Assert
    assertSame(
        measurableRating,
        actualImmutableMeasurableRatingPlannedDecommissionInfo.measurableRating());
    assertSame(decommission, actualImmutableMeasurableRatingPlannedDecommissionInfo.decommission());
  }

  /**
   * Test Builder {@link Builder#decommission(MeasurableRatingPlannedDecommission)}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableRatingPlannedDecommission.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#decommission(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName(
      "Test Builder decommission(MeasurableRatingPlannedDecommission); when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.decommission(MeasurableRatingPlannedDecommission)"})
  void testBuilderDecommission_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    // Act
    Builder actualDecommissionResult =
        builderResult.decommission(new ImmutableMeasurableRatingPlannedDecommission.Json());

    // Assert
    assertSame(builderResult, actualDecommissionResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingPlannedDecommissionInfo)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingPlannedDecommissionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingPlannedDecommissionInfo)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder builderResult2 = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult2.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo instance =
        decommissionResult
            .measurableRating(
                descriptionResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingPlannedDecommissionInfo
        actualImmutableMeasurableRatingPlannedDecommissionInfo = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingPlannedDecommissionInfo);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurableRating(MeasurableRating)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableRating(MeasurableRating)}
   */
  @Test
  @DisplayName("Test Builder measurableRating(MeasurableRating); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRating(MeasurableRating)"})
  void testBuilderMeasurableRating_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act
    Builder actualMeasurableRatingResult =
        builderResult.measurableRating(
            descriptionResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Assert
    assertSame(builderResult, actualMeasurableRatingResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#copyOf(MeasurableRatingPlannedDecommissionInfo)}.
   *
   * <ul>
   *   <li>Then measurableRating entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#copyOf(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingPlannedDecommissionInfo); then measurableRating entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommissionInfo ImmutableMeasurableRatingPlannedDecommissionInfo.copyOf(MeasurableRatingPlannedDecommissionInfo)"
  })
  void testCopyOf_thenMeasurableRatingEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);

    Builder decommissionResult =
        builderResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(plannedDecommissionDate)
                .subjectDecommissionDate(subjectDecommissionDate)
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo instance =
        decommissionResult
            .measurableRating(
                descriptionResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo actualCopyOfResult =
        ImmutableMeasurableRatingPlannedDecommissionInfo.copyOf(instance);

    // Assert
    MeasurableRating measurableRatingResult = actualCopyOfResult.measurableRating();
    assertTrue(measurableRatingResult.entityReference() instanceof ImmutableEntityReference);
    assertTrue(measurableRatingResult instanceof ImmutableMeasurableRating);
    MeasurableRatingPlannedDecommission decommissionResult2 = actualCopyOfResult.decommission();
    assertTrue(decommissionResult2 instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertEquals("2020-03-01", decommissionResult2.lastUpdatedBy());
    assertEquals("2020-03-01", measurableRatingResult.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", decommissionResult2.createdBy());
    assertEquals("Provenance", measurableRatingResult.provenance());
    assertEquals(
        "The characteristics of someone or something", measurableRatingResult.description());
    assertEquals('A', measurableRatingResult.rating());
    assertEquals(1L, measurableRatingResult.ratingId().longValue());
    assertEquals(1L, decommissionResult2.id().longValue());
    assertEquals(1L, decommissionResult2.measurableRatingId().longValue());
    assertEquals(1L, measurableRatingResult.measurableId());
    assertFalse(measurableRatingResult.isPrimary());
    assertFalse(measurableRatingResult.isReadOnly());
    assertTrue(decommissionResult2.isValid());
    assertSame(plannedDecommissionDate, decommissionResult2.plannedDecommissionDate());
    assertSame(subjectDecommissionDate, decommissionResult2.subjectDecommissionDate());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}, and {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommissionInfo.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommissionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    Builder builderResult2 = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult2 =
        builderResult2.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo2 =
            decommissionResult2
                .measurableRating(
                    descriptionResult2
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    // Act and Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommissionInfo,
        immutableMeasurableRatingPlannedDecommissionInfo2);
    assertEquals(
        immutableMeasurableRatingPlannedDecommissionInfo.hashCode(),
        immutableMeasurableRatingPlannedDecommissionInfo2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}, and {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommissionInfo.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommissionInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    // Act and Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommissionInfo,
        immutableMeasurableRatingPlannedDecommissionInfo);
    int expectedHashCodeResult = immutableMeasurableRatingPlannedDecommissionInfo.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableMeasurableRatingPlannedDecommissionInfo.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommissionInfo.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommissionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
            ImmutableMeasurableRatingPlannedDecommission.builder()
                .createdAt(LocalDate.now().atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableRatingId(1L)
                .plannedDecommissionDate(LocalDate.of(1970, 1, 1))
                .subjectDecommissionDate(LocalDate.of(1970, 1, 1))
                .build());

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    Builder builderResult2 = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult2 =
        builderResult2.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommissionInfo,
        decommissionResult2
            .measurableRating(
                descriptionResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommissionInfo.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommissionInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    Builder builderResult2 = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult2 =
        builderResult2.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingPlannedDecommissionInfo,
        decommissionResult2
            .measurableRating(
                descriptionResult2
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommissionInfo.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommissionInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        decommissionResult
            .measurableRating(
                descriptionResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingPlannedDecommissionInfo.equals(Object)",
    "int ImmutableMeasurableRatingPlannedDecommissionInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(
        decommissionResult
            .measurableRating(
                descriptionResult
                    .entityReference(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .id(1L)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .measurableId(1L)
                    .provenance("Provenance")
                    .rating('A')
                    .ratingId(1L)
                    .build())
            .build(),
        "Different type to ImmutableMeasurableRatingPlannedDecommissionInfo");
  }

  /**
   * Test {@link ImmutableMeasurableRatingPlannedDecommissionInfo#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return decommission is {@link Json} (default constructor) {@link Json#decommission}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingPlannedDecommissionInfo#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return decommission is Json (default constructor) decommission")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommissionInfo ImmutableMeasurableRatingPlannedDecommissionInfo.fromJson(Json)"
  })
  void testFromJson_thenReturnDecommissionIsJsonDecommission() {
    // Arrange
    Json json = new Json();

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    json.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());
    json.setDecommission(
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

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo actualFromJsonResult =
        ImmutableMeasurableRatingPlannedDecommissionInfo.fromJson(json);

    // Assert
    MeasurableRatingPlannedDecommission expectedDecommissionResult = json.decommission;
    assertSame(expectedDecommissionResult, actualFromJsonResult.decommission());
    MeasurableRating expectedMeasurableRatingResult = json.measurableRating;
    assertSame(expectedMeasurableRatingResult, actualFromJsonResult.measurableRating());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#toString()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#decommission()}
   *   <li>{@link ImmutableMeasurableRatingPlannedDecommissionInfo#measurableRating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MeasurableRatingPlannedDecommission ImmutableMeasurableRatingPlannedDecommissionInfo.decommission()",
    "MeasurableRating ImmutableMeasurableRatingPlannedDecommissionInfo.measurableRating()",
    "String ImmutableMeasurableRatingPlannedDecommissionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    // Act
    String actualToStringResult = immutableMeasurableRatingPlannedDecommissionInfo.toString();
    MeasurableRatingPlannedDecommission actualDecommissionResult =
        immutableMeasurableRatingPlannedDecommissionInfo.decommission();

    // Assert
    assertTrue(
        immutableMeasurableRatingPlannedDecommissionInfo.measurableRating()
            instanceof ImmutableMeasurableRating);
    assertTrue(actualDecommissionResult instanceof ImmutableMeasurableRatingPlannedDecommission);
    assertEquals(
        "MeasurableRatingPlannedDecommissionInfo{measurableRating=MeasurableRating{id=1, lastUpdatedAt=1970"
            + "-01-01T00:00, lastUpdatedBy=2020-03-01, provenance=Provenance, entityReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, measurableId=1, rating=A, isReadOnly=false, isPrimary=false,"
            + " ratingId=1}, decommission=MeasurableRatingPlannedDecommission{lastUpdatedAt=1970-01-01T00:00,"
            + " lastUpdatedBy=2020-03-01, createdAt=1970-01-01T00:00, createdBy=Jan 1, 2020 8:00am GMT+0100, id=1,"
            + " measurableRatingId=1, plannedDecommissionDate=1970-01-01, subjectDecommissionDate=1970-01-01,"
            + " isValid=true}}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#decommission()}.
   *
   * <p>Method under test: {@link Json#decommission()}
   */
  @Test
  @DisplayName("Test Json decommission()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRatingPlannedDecommission Json.decommission()"})
  void testJsonDecommission() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().decommission());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDecommission(MeasurableRatingPlannedDecommission)}
   *   <li>{@link Json#setMeasurableRating(MeasurableRating)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDecommission(MeasurableRatingPlannedDecommission)",
    "void Json.setMeasurableRating(MeasurableRating)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    LocalDate plannedDecommissionDate = LocalDate.of(1970, 1, 1);
    LocalDate subjectDecommissionDate = LocalDate.of(1970, 1, 1);
    actualJson.setDecommission(
        ImmutableMeasurableRatingPlannedDecommission.builder()
            .createdAt(ofResult.atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .id(1L)
            .lastUpdatedAt(ofResult2.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableRatingId(1L)
            .plannedDecommissionDate(plannedDecommissionDate)
            .subjectDecommissionDate(subjectDecommissionDate)
            .build());
    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    actualJson.setMeasurableRating(
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .id(1L)
            .lastUpdatedAt(ofResult3.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .measurableId(1L)
            .provenance("Provenance")
            .rating('A')
            .ratingId(1L)
            .build());

    // Assert
    MeasurableRating measurableRating = actualJson.measurableRating;
    EntityReference entityReferenceResult = measurableRating.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(measurableRating instanceof ImmutableMeasurableRating);
    MeasurableRatingPlannedDecommission measurableRatingPlannedDecommission =
        actualJson.decommission;
    assertTrue(
        measurableRatingPlannedDecommission
            instanceof ImmutableMeasurableRatingPlannedDecommission);
    LocalDateTime createdAtResult = measurableRatingPlannedDecommission.createdAt();
    LocalTime toLocalTimeResult = createdAtResult.toLocalTime();
    assertEquals("00:00", toLocalTimeResult.toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    LocalDateTime lastUpdatedAtResult = measurableRatingPlannedDecommission.lastUpdatedAt();
    LocalDate toLocalDateResult2 = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult2.toString());
    LocalDateTime lastUpdatedAtResult2 = measurableRating.lastUpdatedAt();
    LocalDate toLocalDateResult3 = lastUpdatedAtResult2.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult3.toString());
    LocalDate plannedDecommissionDateResult =
        measurableRatingPlannedDecommission.plannedDecommissionDate();
    assertEquals("1970-01-01", plannedDecommissionDateResult.toString());
    LocalDate subjectDecommissionDateResult =
        measurableRatingPlannedDecommission.subjectDecommissionDate();
    assertEquals("1970-01-01", subjectDecommissionDateResult.toString());
    assertEquals("2020-03-01", measurableRatingPlannedDecommission.lastUpdatedBy());
    assertEquals("2020-03-01", measurableRating.lastUpdatedBy());
    assertEquals("Jan 1, 2020 8:00am GMT+0100", measurableRatingPlannedDecommission.createdBy());
    assertEquals("Provenance", measurableRating.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", measurableRating.description());
    assertEquals('A', measurableRating.rating());
    assertEquals(1L, measurableRating.ratingId().longValue());
    assertEquals(1L, measurableRatingPlannedDecommission.id().longValue());
    assertEquals(1L, measurableRatingPlannedDecommission.measurableRatingId().longValue());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, measurableRating.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(measurableRating.isPrimary());
    assertFalse(measurableRating.isReadOnly());
    assertTrue(measurableRatingPlannedDecommission.isValid());
    assertSame(toLocalTimeResult, lastUpdatedAtResult.toLocalTime());
    assertSame(toLocalTimeResult, lastUpdatedAtResult2.toLocalTime());
    assertSame(ofResult, toLocalDateResult);
    assertSame(ofResult2, toLocalDateResult2);
    assertSame(ofResult3, toLocalDateResult3);
    assertSame(plannedDecommissionDate, plannedDecommissionDateResult);
    assertSame(subjectDecommissionDate, subjectDecommissionDateResult);
  }

  /**
   * Test Json {@link Json#measurableRating()}.
   *
   * <p>Method under test: {@link Json#measurableRating()}
   */
  @Test
  @DisplayName("Test Json measurableRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MeasurableRating Json.measurableRating()"})
  void testJsonMeasurableRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableRating());
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#withDecommission(MeasurableRatingPlannedDecommission)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#withDecommission(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test withDecommission(MeasurableRatingPlannedDecommission)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommissionInfo ImmutableMeasurableRatingPlannedDecommissionInfo.withDecommission(MeasurableRatingPlannedDecommission)"
  })
  void testWithDecommission() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo actualWithDecommissionResult =
        immutableMeasurableRatingPlannedDecommissionInfo.withDecommission(
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

    // Assert
    assertEquals(immutableMeasurableRatingPlannedDecommissionInfo, actualWithDecommissionResult);
  }

  /**
   * Test {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#withMeasurableRating(MeasurableRating)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingPlannedDecommissionInfo#withMeasurableRating(MeasurableRating)}
   */
  @Test
  @DisplayName("Test withMeasurableRating(MeasurableRating)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingPlannedDecommissionInfo ImmutableMeasurableRatingPlannedDecommissionInfo.withMeasurableRating(MeasurableRating)"
  })
  void testWithMeasurableRating() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    Builder decommissionResult =
        builderResult.decommission(
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

    ImmutableMeasurableRating.Builder descriptionResult =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");
    ImmutableMeasurableRatingPlannedDecommissionInfo
        immutableMeasurableRatingPlannedDecommissionInfo =
            decommissionResult
                .measurableRating(
                    descriptionResult
                        .entityReference(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .id(1L)
                        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .lastUpdatedBy("2020-03-01")
                        .measurableId(1L)
                        .provenance("Provenance")
                        .rating('A')
                        .ratingId(1L)
                        .build())
                .build();

    ImmutableMeasurableRating.Builder descriptionResult2 =
        ImmutableMeasurableRating.builder()
            .description("The characteristics of someone or something");

    // Act
    ImmutableMeasurableRatingPlannedDecommissionInfo actualWithMeasurableRatingResult =
        immutableMeasurableRatingPlannedDecommissionInfo.withMeasurableRating(
            descriptionResult2
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .measurableId(1L)
                .provenance("Provenance")
                .rating('A')
                .ratingId(1L)
                .build());

    // Assert
    assertEquals(
        immutableMeasurableRatingPlannedDecommissionInfo, actualWithMeasurableRatingResult);
  }
}
