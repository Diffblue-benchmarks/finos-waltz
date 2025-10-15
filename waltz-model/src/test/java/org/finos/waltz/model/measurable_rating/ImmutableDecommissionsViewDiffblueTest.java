package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable_rating.ImmutableDecommissionsView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableDecommissionsView.Json;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.ImmutableMeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_replacement.ImmutableMeasurableRatingReplacement;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDecommissionsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllPlannedDecommissions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllPlannedDecommissions(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllPlannedDecommissions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllPlannedDecommissions(Iterable)"})
  void testBuilderAddAllPlannedDecommissions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddAllPlannedDecommissionsResult =
        builderResult.addAllPlannedDecommissions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllPlannedDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllPlannedReplacements(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllPlannedReplacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllPlannedReplacements(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllPlannedReplacements(Iterable)"})
  void testBuilderAddAllPlannedReplacements_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddAllPlannedReplacementsResult =
        builderResult.addAllPlannedReplacements(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllPlannedReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addAllReplacingDecommissions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllReplacingDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllReplacingDecommissions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllReplacingDecommissions(Iterable)"})
  void testBuilderAddAllReplacingDecommissions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddAllReplacingDecommissionsResult =
        builderResult.addAllReplacingDecommissions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllReplacingDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission)} with
   * {@code element}.
   *
   * <p>Method under test: {@link
   * Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName(
      "Test Builder addPlannedDecommissions(MeasurableRatingPlannedDecommission) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPlannedDecommissions(MeasurableRatingPlannedDecommission)"
  })
  void testBuilderAddPlannedDecommissionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedDecommissionsResult =
        builderResult.addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualAddPlannedDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   * with {@code elements}.
   *
   * <p>Method under test: {@link
   * Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   */
  @Test
  @DisplayName(
      "Test Builder addPlannedDecommissions(MeasurableRatingPlannedDecommission[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addPlannedDecommissions(MeasurableRatingPlannedDecommission[])"
  })
  void testBuilderAddPlannedDecommissionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedDecommissionsResult =
        builderResult.addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualAddPlannedDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedReplacements(MeasurableRatingReplacement)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addPlannedReplacements(MeasurableRatingReplacement)}
   */
  @Test
  @DisplayName("Test Builder addPlannedReplacements(MeasurableRatingReplacement) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPlannedReplacements(MeasurableRatingReplacement)"})
  void testBuilderAddPlannedReplacementsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedReplacementsResult =
        builderResult.addPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualAddPlannedReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedReplacements(MeasurableRatingReplacement[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addPlannedReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName("Test Builder addPlannedReplacements(MeasurableRatingReplacement[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addPlannedReplacements(MeasurableRatingReplacement[])"})
  void testBuilderAddPlannedReplacementsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedReplacementsResult =
        builderResult.addPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualAddPlannedReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)}
   * with {@code element}.
   *
   * <p>Method under test: {@link
   * Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  @DisplayName(
      "Test Builder addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)"
  })
  void testBuilderAddReplacingDecommissionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddReplacingDecommissionsResult =
        builderResult.addReplacingDecommissions(
            mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualAddReplacingDecommissionsResult);
  }

  /**
   * Test Builder {@link
   * Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link
   * Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])}
   */
  @Test
  @DisplayName(
      "Test Builder addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])"
  })
  void testBuilderAddReplacingDecommissionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddReplacingDecommissionsResult =
        builderResult.addReplacingDecommissions(
            mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualAddReplacingDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableDecommissionsView.builder().build().plannedDecommissions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(DecommissionsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DecommissionsView)}
   */
  @Test
  @DisplayName("Test Builder from(DecommissionsView); when builder build; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DecommissionsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualFromResult = builderResult.from(ImmutableDecommissionsView.builder().build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#plannedDecommissions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plannedDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder plannedDecommissions(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedDecommissions(Iterable)"})
  void testBuilderPlannedDecommissions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualPlannedDecommissionsResult =
        builderResult.plannedDecommissions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualPlannedDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#plannedReplacements(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#plannedReplacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder plannedReplacements(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.plannedReplacements(Iterable)"})
  void testBuilderPlannedReplacements_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualPlannedReplacementsResult = builderResult.plannedReplacements(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualPlannedReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#replacingDecommissions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#replacingDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder replacingDecommissions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.replacingDecommissions(Iterable)"})
  void testBuilderReplacingDecommissions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualReplacingDecommissionsResult =
        builderResult.replacingDecommissions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualReplacingDecommissionsResult);
  }

  /**
   * Test {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return plannedDecommissions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DecommissionsView); when builder build; then return plannedDecommissions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecommissionsView ImmutableDecommissionsView.copyOf(DecommissionsView)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnPlannedDecommissionsEmpty() {
    // Arrange
    ImmutableDecommissionsView instance = ImmutableDecommissionsView.builder().build();

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult =
        actualCopyOfResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}, and {@link
   * ImmutableDecommissionsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDecommissionsView#equals(Object)}
   *   <li>{@link ImmutableDecommissionsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDecommissionsView immutableDecommissionsView =
        ImmutableDecommissionsView.builder().build();
    ImmutableDecommissionsView immutableDecommissionsView2 =
        ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertEquals(immutableDecommissionsView, immutableDecommissionsView2);
    assertEquals(immutableDecommissionsView.hashCode(), immutableDecommissionsView2.hashCode());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}, and {@link
   * ImmutableDecommissionsView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDecommissionsView#equals(Object)}
   *   <li>{@link ImmutableDecommissionsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDecommissionsView immutableDecommissionsView =
        ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertEquals(immutableDecommissionsView, immutableDecommissionsView);
    int expectedHashCodeResult = immutableDecommissionsView.hashCode();
    assertEquals(expectedHashCodeResult, immutableDecommissionsView.hashCode());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    builderResult.addPlannedDecommissions(
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

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableDecommissionsView.builder().build());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult2 =
        ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder decommissionResult =
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
    builderResult.addReplacingDecommissions(
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
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableDecommissionsView.builder().build());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    builderResult.addPlannedReplacements(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableDecommissionsView.builder().build());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableDecommissionsView.builder().build(), null);
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDecommissionsView.equals(Object)",
    "int ImmutableDecommissionsView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDecommissionsView.builder().build(),
        "Different type to ImmutableDecommissionsView");
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissions Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedDecommissions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnPlannedDecommissionsEmpty() {
    // Arrange
    Json json = new Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(null);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult =
        actualFromJsonResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return plannedDecommissions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedDecommissions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnPlannedDecommissionsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRatingPlannedDecommission> plannedDecommissions = new LinkedHashSet<>();
    plannedDecommissions.add(mock(MeasurableRatingPlannedDecommission.class));

    Json json = new Json();
    json.setPlannedDecommissions(plannedDecommissions);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(null);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.plannedDecommissions().size());
    Set<MeasurableRatingReplacement> plannedReplacementsResult =
        actualFromJsonResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertSame(plannedReplacementsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return plannedReplacements is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedReplacements is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnPlannedReplacementsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<MeasurableRatingReplacement> plannedReplacements = new LinkedHashSet<>();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");
    plannedReplacements.add(
        lastUpdatedByResult
            .plannedCommissionDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
    plannedReplacements.add(mock(MeasurableRatingReplacement.class));

    Json json = new Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(plannedReplacements);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(plannedReplacements, actualFromJsonResult.plannedReplacements());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return plannedReplacements size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedReplacements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnPlannedReplacementsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRatingReplacement> plannedReplacements = new LinkedHashSet<>();
    plannedReplacements.add(mock(MeasurableRatingReplacement.class));

    Json json = new Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(plannedReplacements);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.plannedReplacements().size());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return replacingDecommissions size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return replacingDecommissions size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnReplacingDecommissionsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRatingPlannedDecommissionInfo> replacingDecommissions =
        new LinkedHashSet<>();
    replacingDecommissions.add(mock(MeasurableRatingPlannedDecommissionInfo.class));

    Json json = new Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(replacingDecommissions);
    json.setPlannedReplacements(null);

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.replacingDecommissions().size());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return plannedReplacements is {@link Json} (default constructor) {@link
   *       Json#replacingDecommissions}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return plannedReplacements is Json (default constructor) replacingDecommissions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnPlannedReplacementsIsJsonReplacingDecommissions() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    Set<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoSet =
        json.replacingDecommissions;
    assertSame(
        measurableRatingPlannedDecommissionInfoSet, actualFromJsonResult.plannedReplacements());
    assertSame(
        measurableRatingPlannedDecommissionInfoSet, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDecommissionsView#toString()}
   *   <li>{@link ImmutableDecommissionsView#plannedDecommissions()}
   *   <li>{@link ImmutableDecommissionsView#plannedReplacements()}
   *   <li>{@link ImmutableDecommissionsView#replacingDecommissions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableDecommissionsView.plannedDecommissions()",
    "Set ImmutableDecommissionsView.plannedReplacements()",
    "Set ImmutableDecommissionsView.replacingDecommissions()",
    "String ImmutableDecommissionsView.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDecommissionsView immutableDecommissionsView =
        ImmutableDecommissionsView.builder().build();

    // Act
    String actualToStringResult = immutableDecommissionsView.toString();
    Set<MeasurableRatingPlannedDecommission> actualPlannedDecommissionsResult =
        immutableDecommissionsView.plannedDecommissions();
    Set<MeasurableRatingReplacement> actualPlannedReplacementsResult =
        immutableDecommissionsView.plannedReplacements();
    Set<MeasurableRatingPlannedDecommissionInfo> actualReplacingDecommissionsResult =
        immutableDecommissionsView.replacingDecommissions();

    // Assert
    assertEquals(
        "DecommissionsView{plannedDecommissions=[], replacingDecommissions=[], plannedReplacements=[]}",
        actualToStringResult);
    assertTrue(actualPlannedDecommissionsResult.isEmpty());
    assertSame(actualPlannedDecommissionsResult, actualPlannedReplacementsResult);
    assertSame(actualPlannedDecommissionsResult, actualReplacingDecommissionsResult);
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
    assertTrue(actualJson.plannedDecommissions.isEmpty());
    assertTrue(actualJson.plannedReplacements.isEmpty());
    assertTrue(actualJson.replacingDecommissions.isEmpty());
  }

  /**
   * Test Json {@link Json#plannedDecommissions()}.
   *
   * <p>Method under test: {@link Json#plannedDecommissions()}
   */
  @Test
  @DisplayName("Test Json plannedDecommissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.plannedDecommissions()"})
  void testJsonPlannedDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedDecommissions());
  }

  /**
   * Test Json {@link Json#plannedReplacements()}.
   *
   * <p>Method under test: {@link Json#plannedReplacements()}
   */
  @Test
  @DisplayName("Test Json plannedReplacements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.plannedReplacements()"})
  void testJsonPlannedReplacements() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().plannedReplacements());
  }

  /**
   * Test Json {@link Json#replacingDecommissions()}.
   *
   * <p>Method under test: {@link Json#replacingDecommissions()}
   */
  @Test
  @DisplayName("Test Json replacingDecommissions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.replacingDecommissions()"})
  void testJsonReplacingDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().replacingDecommissions());
  }

  /**
   * Test {@link
   * ImmutableDecommissionsView#withPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   * with {@code MeasurableRatingPlannedDecommission[]}.
   *
   * <p>Method under test: {@link
   * ImmutableDecommissionsView#withPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   */
  @Test
  @DisplayName(
      "Test withPlannedDecommissions(MeasurableRatingPlannedDecommission[]) with 'MeasurableRatingPlannedDecommission[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecommissionsView ImmutableDecommissionsView.withPlannedDecommissions(MeasurableRatingPlannedDecommission[])"
  })
  void testWithPlannedDecommissionsWithMeasurableRatingPlannedDecommission() {
    // Arrange
    ImmutableDecommissionsView immutableDecommissionsView =
        ImmutableDecommissionsView.builder().build();

    // Act
    ImmutableDecommissionsView actualWithPlannedDecommissionsResult =
        immutableDecommissionsView.withPlannedDecommissions(
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
    assertEquals(1, actualWithPlannedDecommissionsResult.plannedDecommissions().size());
    Set<MeasurableRatingReplacement> plannedReplacementsResult =
        actualWithPlannedDecommissionsResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertSame(
        plannedReplacementsResult, actualWithPlannedDecommissionsResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#withPlannedReplacements(MeasurableRatingReplacement[])}
   * with {@code MeasurableRatingReplacement[]}.
   *
   * <p>Method under test: {@link
   * ImmutableDecommissionsView#withPlannedReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName(
      "Test withPlannedReplacements(MeasurableRatingReplacement[]) with 'MeasurableRatingReplacement[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecommissionsView ImmutableDecommissionsView.withPlannedReplacements(MeasurableRatingReplacement[])"
  })
  void testWithPlannedReplacementsWithMeasurableRatingReplacement() {
    // Arrange
    ImmutableDecommissionsView immutableDecommissionsView =
        ImmutableDecommissionsView.builder().build();

    ImmutableMeasurableRatingReplacement.Builder decommissionIdResult =
        ImmutableMeasurableRatingReplacement.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .decommissionId(1L);

    ImmutableMeasurableRatingReplacement.Builder lastUpdatedByResult =
        decommissionIdResult
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
            .lastUpdatedBy("2020-03-01");

    // Act
    ImmutableDecommissionsView actualWithPlannedReplacementsResult =
        immutableDecommissionsView.withPlannedReplacements(
            lastUpdatedByResult
                .plannedCommissionDate(
                    Date.from(
                        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
                .build());

    // Assert
    assertEquals(1, actualWithPlannedReplacementsResult.plannedReplacements().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult =
        actualWithPlannedReplacementsResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(
        plannedDecommissionsResult, actualWithPlannedReplacementsResult.replacingDecommissions());
  }

  /**
   * Test {@link
   * ImmutableDecommissionsView#withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])}
   * with {@code MeasurableRatingPlannedDecommissionInfo[]}.
   *
   * <p>Method under test: {@link
   * ImmutableDecommissionsView#withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])}
   */
  @Test
  @DisplayName(
      "Test withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[]) with 'MeasurableRatingPlannedDecommissionInfo[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDecommissionsView ImmutableDecommissionsView.withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])"
  })
  void testWithReplacingDecommissionsWithMeasurableRatingPlannedDecommissionInfo() {
    // Arrange
    ImmutableDecommissionsView immutableDecommissionsView =
        ImmutableDecommissionsView.builder().build();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder builderResult =
        ImmutableMeasurableRatingPlannedDecommissionInfo.builder();

    ImmutableMeasurableRatingPlannedDecommissionInfo.Builder decommissionResult =
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

    // Act
    ImmutableDecommissionsView actualWithReplacingDecommissionsResult =
        immutableDecommissionsView.withReplacingDecommissions(
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
                .build());

    // Assert
    assertEquals(1, actualWithReplacingDecommissionsResult.replacingDecommissions().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult =
        actualWithReplacingDecommissionsResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(
        plannedDecommissionsResult, actualWithReplacingDecommissionsResult.plannedReplacements());
  }
}
