package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.measurable_rating.ImmutableDecommissionsView.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableDecommissionsView.Json;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommission;
import org.finos.waltz.model.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionInfo;
import org.finos.waltz.model.measurable_rating_replacement.MeasurableRatingReplacement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDecommissionsViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllPlannedDecommissions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllPlannedDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllPlannedDecommissions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllPlannedDecommissions(Iterable)"})
  void testBuilderAddAllPlannedDecommissions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPlannedDecommissions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllPlannedReplacements(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllPlannedReplacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllPlannedReplacements(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllPlannedReplacements(Iterable)"})
  void testBuilderAddAllPlannedReplacements_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllPlannedReplacements(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllReplacingDecommissions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllReplacingDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllReplacingDecommissions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllReplacingDecommissions(Iterable)"})
  void testBuilderAddAllReplacingDecommissions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllReplacingDecommissions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission)}
   */
  @Test
  @DisplayName("Test Builder addPlannedDecommissions(MeasurableRatingPlannedDecommission) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPlannedDecommissions(MeasurableRatingPlannedDecommission)"})
  void testBuilderAddPlannedDecommissionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedDecommissionsResult = builderResult
        .addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualAddPlannedDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   */
  @Test
  @DisplayName("Test Builder addPlannedDecommissions(MeasurableRatingPlannedDecommission[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPlannedDecommissions(MeasurableRatingPlannedDecommission[])"})
  void testBuilderAddPlannedDecommissionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedDecommissionsResult = builderResult
        .addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, builderResult.build().plannedDecommissions().size());
    assertSame(builderResult, actualAddPlannedDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedReplacements(MeasurableRatingReplacement)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addPlannedReplacements(MeasurableRatingReplacement)}
   */
  @Test
  @DisplayName("Test Builder addPlannedReplacements(MeasurableRatingReplacement) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPlannedReplacements(MeasurableRatingReplacement)"})
  void testBuilderAddPlannedReplacementsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedReplacementsResult = builderResult
        .addPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualAddPlannedReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addPlannedReplacements(MeasurableRatingReplacement[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addPlannedReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName("Test Builder addPlannedReplacements(MeasurableRatingReplacement[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addPlannedReplacements(MeasurableRatingReplacement[])"})
  void testBuilderAddPlannedReplacementsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddPlannedReplacementsResult = builderResult
        .addPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, builderResult.build().plannedReplacements().size());
    assertSame(builderResult, actualAddPlannedReplacementsResult);
  }

  /**
   * Test Builder {@link Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)}
   */
  @Test
  @DisplayName("Test Builder addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo)"})
  void testBuilderAddReplacingDecommissionsWithElement() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddReplacingDecommissionsResult = builderResult
        .addReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualAddReplacingDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])}
   */
  @Test
  @DisplayName("Test Builder addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])"})
  void testBuilderAddReplacingDecommissionsWithElements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act
    Builder actualAddReplacingDecommissionsResult = builderResult
        .addReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, builderResult.build().replacingDecommissions().size());
    assertSame(builderResult, actualAddReplacingDecommissionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDecommissionsView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableDecommissionsView.builder().build().plannedDecommissions().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(DecommissionsView)}.
   * <ul>
   *   <li>Then return build plannedReplacements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DecommissionsView)}
   */
  @Test
  @DisplayName("Test Builder from(DecommissionsView); then return build plannedReplacements size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DecommissionsView)"})
  void testBuilderFrom_thenReturnBuildPlannedReplacementsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    Builder builderResult2 = ImmutableDecommissionsView.builder();
    builderResult2.addPlannedReplacements(mock(MeasurableRatingReplacement.class));
    builderResult2.addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));
    ImmutableDecommissionsView instance = builderResult2.build();

    // Act and Assert
    ImmutableDecommissionsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.plannedDecommissions().size());
    assertEquals(1, buildResult.plannedReplacements().size());
    assertTrue(buildResult.replacingDecommissions().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(DecommissionsView)}.
   * <ul>
   *   <li>Then return build replacingDecommissions is build plannedReplacements.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DecommissionsView)}
   */
  @Test
  @DisplayName("Test Builder from(DecommissionsView); then return build replacingDecommissions is build plannedReplacements")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DecommissionsView)"})
  void testBuilderFrom_thenReturnBuildReplacingDecommissionsIsBuildPlannedReplacements() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    Builder builderResult2 = ImmutableDecommissionsView.builder();
    builderResult2.addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));
    ImmutableDecommissionsView instance = builderResult2.build();

    // Act and Assert
    ImmutableDecommissionsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.plannedDecommissions().size());
    Set<MeasurableRatingReplacement> plannedReplacementsResult = buildResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(plannedReplacementsResult, buildResult.replacingDecommissions());
  }

  /**
   * Test Builder {@link Builder#from(DecommissionsView)}.
   * <ul>
   *   <li>Then return build replacingDecommissions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DecommissionsView)}
   */
  @Test
  @DisplayName("Test Builder from(DecommissionsView); then return build replacingDecommissions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DecommissionsView)"})
  void testBuilderFrom_thenReturnBuildReplacingDecommissionsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    Builder builderResult2 = ImmutableDecommissionsView.builder();
    builderResult2.addReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));
    builderResult2.addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));
    ImmutableDecommissionsView instance = builderResult2.build();

    // Act and Assert
    ImmutableDecommissionsView buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.plannedDecommissions().size());
    assertEquals(1, buildResult.replacingDecommissions().size());
    assertTrue(buildResult.plannedReplacements().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(DecommissionsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build plannedDecommissions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DecommissionsView)}
   */
  @Test
  @DisplayName("Test Builder from(DecommissionsView); when builder build; then return build plannedDecommissions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DecommissionsView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildPlannedDecommissionsEmpty() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    ImmutableDecommissionsView instance = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    ImmutableDecommissionsView buildResult = builderResult.from(instance).build();
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = buildResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(plannedDecommissionsResult, buildResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, buildResult.replacingDecommissions());
  }

  /**
   * Test Builder {@link Builder#plannedDecommissions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#plannedDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder plannedDecommissions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.plannedDecommissions(Iterable)"})
  void testBuilderPlannedDecommissions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedDecommissions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#plannedReplacements(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#plannedReplacements(Iterable)}
   */
  @Test
  @DisplayName("Test Builder plannedReplacements(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.plannedReplacements(Iterable)"})
  void testBuilderPlannedReplacements_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.plannedReplacements(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#replacingDecommissions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#replacingDecommissions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder replacingDecommissions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.replacingDecommissions(Iterable)"})
  void testBuilderReplacingDecommissions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.replacingDecommissions(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return plannedDecommissions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#copyOf(DecommissionsView)}
   */
  @Test
  @DisplayName("Test copyOf(DecommissionsView); when builder build; then return plannedDecommissions Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.copyOf(DecommissionsView)"})
  void testCopyOf_whenBuilderBuild_thenReturnPlannedDecommissionsEmpty() {
    // Arrange
    ImmutableDecommissionsView instance = ImmutableDecommissionsView.builder().build();

    // Act
    ImmutableDecommissionsView actualCopyOfResult = ImmutableDecommissionsView.copyOf(instance);

    // Assert
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualCopyOfResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, actualCopyOfResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}, and {@link ImmutableDecommissionsView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDecommissionsView#equals(Object)}
   *   <li>{@link ImmutableDecommissionsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();
    ImmutableDecommissionsView buildResult2 = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}, and {@link ImmutableDecommissionsView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDecommissionsView#equals(Object)}
   *   <li>{@link ImmutableDecommissionsView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    builderResult.addPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));
    ImmutableDecommissionsView buildResult = builderResult.build();
    ImmutableDecommissionsView buildResult2 = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    builderResult.addReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));
    ImmutableDecommissionsView buildResult = builderResult.build();
    ImmutableDecommissionsView buildResult2 = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableDecommissionsView.builder();
    builderResult.addPlannedReplacements(mock(MeasurableRatingReplacement.class));
    ImmutableDecommissionsView buildResult = builderResult.build();
    ImmutableDecommissionsView buildResult2 = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableDecommissionsView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableDecommissionsView.equals(Object)", "int ImmutableDecommissionsView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableDecommissionsView");
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return plannedDecommissions Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedDecommissions Empty")
  @Tag("MaintainedByDiffblue")
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
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualFromJsonResult.plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.plannedReplacements());
    assertSame(plannedDecommissionsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return plannedDecommissions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedDecommissions size is one")
  @Tag("MaintainedByDiffblue")
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
    Set<MeasurableRatingReplacement> plannedReplacementsResult = actualFromJsonResult.plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertSame(plannedReplacementsResult, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return plannedReplacements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return plannedReplacements size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnPlannedReplacementsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRatingReplacement> plannedReplacements = new LinkedHashSet<>();
    plannedReplacements.add(mock(MeasurableRatingReplacement.class));

    Json json = new Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(null);
    json.setPlannedReplacements(plannedReplacements);

    // Act and Assert
    assertEquals(1, ImmutableDecommissionsView.fromJson(json).plannedReplacements().size());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   * <ul>
   *   <li>Then return replacingDecommissions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return replacingDecommissions size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_thenReturnReplacingDecommissionsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableRatingPlannedDecommissionInfo> replacingDecommissions = new LinkedHashSet<>();
    replacingDecommissions.add(mock(MeasurableRatingPlannedDecommissionInfo.class));

    Json json = new Json();
    json.setPlannedDecommissions(null);
    json.setReplacingDecommissions(replacingDecommissions);
    json.setPlannedReplacements(null);

    // Act and Assert
    assertEquals(1, ImmutableDecommissionsView.fromJson(json).replacingDecommissions().size());
  }

  /**
   * Test {@link ImmutableDecommissionsView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return plannedReplacements is {@link Json} (default constructor) {@link Json#replacingDecommissions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return plannedReplacements is Json (default constructor) replacingDecommissions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDecommissionsView ImmutableDecommissionsView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnPlannedReplacementsIsJsonReplacingDecommissions() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableDecommissionsView actualFromJsonResult = ImmutableDecommissionsView.fromJson(json);

    // Assert
    Set<MeasurableRatingPlannedDecommissionInfo> measurableRatingPlannedDecommissionInfoSet = json.replacingDecommissions;
    assertSame(measurableRatingPlannedDecommissionInfoSet, actualFromJsonResult.plannedReplacements());
    assertSame(measurableRatingPlannedDecommissionInfoSet, actualFromJsonResult.replacingDecommissions());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDecommissionsView#toString()}
   *   <li>{@link ImmutableDecommissionsView#plannedDecommissions()}
   *   <li>{@link ImmutableDecommissionsView#plannedReplacements()}
   *   <li>{@link ImmutableDecommissionsView#replacingDecommissions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableDecommissionsView.plannedDecommissions()",
      "Set ImmutableDecommissionsView.plannedReplacements()", "Set ImmutableDecommissionsView.replacingDecommissions()",
      "String ImmutableDecommissionsView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<MeasurableRatingPlannedDecommission> actualPlannedDecommissionsResult = buildResult.plannedDecommissions();
    Set<MeasurableRatingReplacement> actualPlannedReplacementsResult = buildResult.plannedReplacements();
    Set<MeasurableRatingPlannedDecommissionInfo> actualReplacingDecommissionsResult = buildResult
        .replacingDecommissions();

    // Assert
    assertEquals("DecommissionsView{plannedDecommissions=[], replacingDecommissions=[], plannedReplacements=[]}",
        actualToStringResult);
    assertTrue(actualPlannedDecommissionsResult.isEmpty());
    assertSame(actualPlannedDecommissionsResult, actualPlannedReplacementsResult);
    assertSame(actualPlannedDecommissionsResult, actualReplacingDecommissionsResult);
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#plannedDecommissions()}
   */
  @Test
  @DisplayName("Test Json plannedDecommissions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.plannedDecommissions()"})
  void testJsonPlannedDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).plannedDecommissions());
  }

  /**
   * Test Json {@link Json#plannedReplacements()}.
   * <p>
   * Method under test: {@link Json#plannedReplacements()}
   */
  @Test
  @DisplayName("Test Json plannedReplacements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.plannedReplacements()"})
  void testJsonPlannedReplacements() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).plannedReplacements());
  }

  /**
   * Test Json {@link Json#replacingDecommissions()}.
   * <p>
   * Method under test: {@link Json#replacingDecommissions()}
   */
  @Test
  @DisplayName("Test Json replacingDecommissions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.replacingDecommissions()"})
  void testJsonReplacingDecommissions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#withPlannedDecommissions(MeasurableRatingPlannedDecommission[])} with {@code MeasurableRatingPlannedDecommission[]}.
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#withPlannedDecommissions(MeasurableRatingPlannedDecommission[])}
   */
  @Test
  @DisplayName("Test withPlannedDecommissions(MeasurableRatingPlannedDecommission[]) with 'MeasurableRatingPlannedDecommission[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableDecommissionsView ImmutableDecommissionsView.withPlannedDecommissions(MeasurableRatingPlannedDecommission[])"})
  void testWithPlannedDecommissionsWithMeasurableRatingPlannedDecommission() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act
    ImmutableDecommissionsView actualWithPlannedDecommissionsResult = buildResult
        .withPlannedDecommissions(mock(MeasurableRatingPlannedDecommission.class));

    // Assert
    assertEquals(1, actualWithPlannedDecommissionsResult.plannedDecommissions().size());
    Set<MeasurableRatingReplacement> plannedReplacementsResult = actualWithPlannedDecommissionsResult
        .plannedReplacements();
    assertTrue(plannedReplacementsResult.isEmpty());
    assertSame(plannedReplacementsResult, actualWithPlannedDecommissionsResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#withPlannedReplacements(MeasurableRatingReplacement[])} with {@code MeasurableRatingReplacement[]}.
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#withPlannedReplacements(MeasurableRatingReplacement[])}
   */
  @Test
  @DisplayName("Test withPlannedReplacements(MeasurableRatingReplacement[]) with 'MeasurableRatingReplacement[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableDecommissionsView ImmutableDecommissionsView.withPlannedReplacements(MeasurableRatingReplacement[])"})
  void testWithPlannedReplacementsWithMeasurableRatingReplacement() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act
    ImmutableDecommissionsView actualWithPlannedReplacementsResult = buildResult
        .withPlannedReplacements(mock(MeasurableRatingReplacement.class));

    // Assert
    assertEquals(1, actualWithPlannedReplacementsResult.plannedReplacements().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualWithPlannedReplacementsResult
        .plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualWithPlannedReplacementsResult.replacingDecommissions());
  }

  /**
   * Test {@link ImmutableDecommissionsView#withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])} with {@code MeasurableRatingPlannedDecommissionInfo[]}.
   * <p>
   * Method under test: {@link ImmutableDecommissionsView#withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])}
   */
  @Test
  @DisplayName("Test withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[]) with 'MeasurableRatingPlannedDecommissionInfo[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableDecommissionsView ImmutableDecommissionsView.withReplacingDecommissions(MeasurableRatingPlannedDecommissionInfo[])"})
  void testWithReplacingDecommissionsWithMeasurableRatingPlannedDecommissionInfo() {
    // Arrange
    ImmutableDecommissionsView buildResult = ImmutableDecommissionsView.builder().build();

    // Act
    ImmutableDecommissionsView actualWithReplacingDecommissionsResult = buildResult
        .withReplacingDecommissions(mock(MeasurableRatingPlannedDecommissionInfo.class));

    // Assert
    assertEquals(1, actualWithReplacingDecommissionsResult.replacingDecommissions().size());
    Set<MeasurableRatingPlannedDecommission> plannedDecommissionsResult = actualWithReplacingDecommissionsResult
        .plannedDecommissions();
    assertTrue(plannedDecommissionsResult.isEmpty());
    assertSame(plannedDecommissionsResult, actualWithReplacingDecommissionsResult.plannedReplacements());
  }
}
