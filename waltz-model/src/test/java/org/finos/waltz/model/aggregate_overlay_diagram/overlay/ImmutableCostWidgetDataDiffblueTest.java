package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetData.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableCostWidgetData.Json;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.cost.EntityCostKind;
import org.finos.waltz.model.measurable.Measurable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCostWidgetDataDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplications(Iterable); when ArrayList(); then return build applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplications(Iterable)"})
  void testBuilderAddAllApplications_whenArrayList_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    ImmutableCostWidgetData buildResult = builderResult.addAllApplications(new ArrayList<>()).build();
    Set<Application> applicationsResult = buildResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, buildResult.cellData());
    assertSame(applicationsResult, buildResult.costKinds());
    assertSame(applicationsResult, buildResult.measurables());
  }

  /**
   * Test Builder {@link Builder#addAllCellData(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCellData(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCellData(Iterable)"})
  void testBuilderAddAllCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllCostKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCostKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCostKinds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCostKinds(Iterable)"})
  void testBuilderAddAllCostKinds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCostKinds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllMeasurables(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllMeasurables(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllMeasurables(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllMeasurables(Iterable)"})
  void testBuilderAddAllMeasurables_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllMeasurables(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplications(Application)} with {@code element}.
   * <ul>
   *   <li>Then builder build applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplications(Application)}
   */
  @Test
  @DisplayName("Test Builder addApplications(Application) with 'element'; then builder build applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplications(Application)"})
  void testBuilderAddApplicationsWithElement_thenBuilderBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddApplicationsResult = builderResult.addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addApplications(Application[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addApplications(Application[])}
   */
  @Test
  @DisplayName("Test Builder addApplications(Application[]) with 'elements'; then builder build applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addApplications(Application[])"})
  void testBuilderAddApplicationsWithElements_thenBuilderBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddApplicationsResult = builderResult.addApplications(mock(Application.class));

    // Assert
    assertEquals(1, builderResult.build().applications().size());
    assertSame(builderResult, actualAddApplicationsResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(CostWidgetDatum)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableCostWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(CostWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder addCellData(CostWidgetDatum) with 'element'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(CostWidgetDatum)"})
  void testBuilderAddCellDataWithElement_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCellData(CostWidgetDatum[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableCostWidgetDatum.Json} (default constructor).</li>
   *   <li>Then builder build cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCellData(CostWidgetDatum[])}
   */
  @Test
  @DisplayName("Test Builder addCellData(CostWidgetDatum[]) with 'elements'; when Json (default constructor); then builder build cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCellData(CostWidgetDatum[])"})
  void testBuilderAddCellDataWithElements_whenJson_thenBuilderBuildCellDataSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCellDataResult = builderResult.addCellData(new ImmutableCostWidgetDatum.Json());

    // Assert
    assertEquals(1, builderResult.build().cellData().size());
    assertSame(builderResult, actualAddCellDataResult);
  }

  /**
   * Test Builder {@link Builder#addCostKinds(EntityCostKind)} with {@code element}.
   * <ul>
   *   <li>Then builder build costKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCostKinds(EntityCostKind)}
   */
  @Test
  @DisplayName("Test Builder addCostKinds(EntityCostKind) with 'element'; then builder build costKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCostKinds(EntityCostKind)"})
  void testBuilderAddCostKindsWithElement_thenBuilderBuildCostKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCostKindsResult = builderResult.addCostKinds(mock(EntityCostKind.class));

    // Assert
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualAddCostKindsResult);
  }

  /**
   * Test Builder {@link Builder#addCostKinds(EntityCostKind[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build costKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCostKinds(EntityCostKind[])}
   */
  @Test
  @DisplayName("Test Builder addCostKinds(EntityCostKind[]) with 'elements'; then builder build costKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCostKinds(EntityCostKind[])"})
  void testBuilderAddCostKindsWithElements_thenBuilderBuildCostKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddCostKindsResult = builderResult.addCostKinds(mock(EntityCostKind.class));

    // Assert
    assertEquals(1, builderResult.build().costKinds().size());
    assertSame(builderResult, actualAddCostKindsResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable)} with {@code element}.
   * <ul>
   *   <li>Then builder build measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMeasurables(Measurable)}
   */
  @Test
  @DisplayName("Test Builder addMeasurables(Measurable) with 'element'; then builder build measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable)"})
  void testBuilderAddMeasurablesWithElement_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddMeasurablesResult = builderResult.addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#addMeasurables(Measurable[])} with {@code elements}.
   * <ul>
   *   <li>Then builder build measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addMeasurables(Measurable[])}
   */
  @Test
  @DisplayName("Test Builder addMeasurables(Measurable[]) with 'elements'; then builder build measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addMeasurables(Measurable[])"})
  void testBuilderAddMeasurablesWithElements_thenBuilderBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act
    Builder actualAddMeasurablesResult = builderResult.addMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, builderResult.build().measurables().size());
    assertSame(builderResult, actualAddMeasurablesResult);
  }

  /**
   * Test Builder {@link Builder#applications(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applications(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applications(Iterable); when ArrayList(); then return build applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applications(Iterable)"})
  void testBuilderApplications_whenArrayList_thenReturnBuildApplicationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    ImmutableCostWidgetData buildResult = builderResult.applications(new ArrayList<>()).build();
    Set<Application> applicationsResult = buildResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, buildResult.cellData());
    assertSame(applicationsResult, buildResult.costKinds());
    assertSame(applicationsResult, buildResult.measurables());
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableCostWidgetData.builder().build().applications().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellData(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#cellData(Iterable)}
   */
  @Test
  @DisplayName("Test Builder cellData(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.cellData(Iterable)"})
  void testBuilderCellData_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.cellData(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#costKinds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#costKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder costKinds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.costKinds(Iterable)"})
  void testBuilderCostKinds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.costKinds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetData)}.
   * <ul>
   *   <li>Given {@link ImmutableCostWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return build costKinds is {@link ImmutableCostWidgetDatum.Json} (default constructor) {@link ImmutableCostWidgetDatum.Json#measurableCosts}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetData); given Json (default constructor); then return build costKinds is Json (default constructor) measurableCosts")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetData)"})
  void testBuilderFrom_givenJson_thenReturnBuildCostKindsIsJsonMeasurableCosts() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    Builder builderResult2 = ImmutableCostWidgetData.builder();
    ImmutableCostWidgetDatum.Json element = new ImmutableCostWidgetDatum.Json();
    builderResult2.addCellData(element);
    ImmutableCostWidgetData instance = builderResult2.build();

    // Act and Assert
    Set<MeasurableCostEntry> measurableCostEntrySet = element.measurableCosts;
    ImmutableCostWidgetData buildResult = builderResult.from(instance).build();
    assertSame(measurableCostEntrySet, buildResult.costKinds());
    assertSame(measurableCostEntrySet, buildResult.measurables());
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetData)}.
   * <ul>
   *   <li>Then return build applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetData); then return build applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetData)"})
  void testBuilderFrom_thenReturnBuildApplicationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    Builder builderResult2 = ImmutableCostWidgetData.builder();
    builderResult2.addApplications(mock(Application.class));
    ImmutableCostWidgetDatum.Json element = new ImmutableCostWidgetDatum.Json();
    builderResult2.addCellData(element);
    ImmutableCostWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableCostWidgetData buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.applications().size());
    assertTrue(buildResult.costKinds().isEmpty());
    Set<MeasurableCostEntry> expectedMeasurablesResult = element.measurableCosts;
    assertSame(expectedMeasurablesResult, buildResult.measurables());
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetData)}.
   * <ul>
   *   <li>Then return build costKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetData); then return build costKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetData)"})
  void testBuilderFrom_thenReturnBuildCostKindsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    Builder builderResult2 = ImmutableCostWidgetData.builder();
    builderResult2.addCostKinds(mock(EntityCostKind.class));
    builderResult2.addCellData(new ImmutableCostWidgetDatum.Json());
    ImmutableCostWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableCostWidgetData buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.cellData().size());
    assertEquals(1, buildResult.costKinds().size());
    assertTrue(buildResult.applications().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetData)}.
   * <ul>
   *   <li>Then return build measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetData); then return build measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetData)"})
  void testBuilderFrom_thenReturnBuildMeasurablesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    Builder builderResult2 = ImmutableCostWidgetData.builder();
    builderResult2.addMeasurables(mock(Measurable.class));
    ImmutableCostWidgetDatum.Json element = new ImmutableCostWidgetDatum.Json();
    builderResult2.addCellData(element);
    ImmutableCostWidgetData instance = builderResult2.build();

    // Act and Assert
    ImmutableCostWidgetData buildResult = builderResult.from(instance).build();
    assertEquals(1, buildResult.cellData().size());
    assertEquals(1, buildResult.measurables().size());
    assertTrue(buildResult.applications().isEmpty());
    assertEquals(instance, builderResult.build());
    Set<MeasurableCostEntry> expectedCostKindsResult = element.measurableCosts;
    assertSame(expectedCostKindsResult, buildResult.costKinds());
  }

  /**
   * Test Builder {@link Builder#from(CostWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(CostWidgetData)}
   */
  @Test
  @DisplayName("Test Builder from(CostWidgetData); when builder build; then builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(CostWidgetData)"})
  void testBuilderFrom_whenBuilderBuild_thenBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    ImmutableCostWidgetData instance = ImmutableCostWidgetData.builder().build();

    // Act
    builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#measurables(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#measurables(Iterable)}
   */
  @Test
  @DisplayName("Test Builder measurables(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurables(Iterable)"})
  void testBuilderMeasurables_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurables(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#copyOf(CostWidgetData)}
   */
  @Test
  @DisplayName("Test copyOf(CostWidgetData); when builder build; then return applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.copyOf(CostWidgetData)"})
  void testCopyOf_whenBuilderBuild_thenReturnApplicationsEmpty() {
    // Arrange
    ImmutableCostWidgetData instance = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualCopyOfResult = ImmutableCostWidgetData.copyOf(instance);

    // Assert
    Set<Application> applicationsResult = actualCopyOfResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualCopyOfResult.cellData());
    assertSame(applicationsResult, actualCopyOfResult.costKinds());
    assertSame(applicationsResult, actualCopyOfResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}, and {@link ImmutableCostWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCostWidgetData#equals(Object)}
   *   <li>{@link ImmutableCostWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();
    ImmutableCostWidgetData buildResult2 = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}, and {@link ImmutableCostWidgetData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCostWidgetData#equals(Object)}
   *   <li>{@link ImmutableCostWidgetData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addCellData(new ImmutableCostWidgetDatum.Json());
    ImmutableCostWidgetData buildResult = builderResult.build();
    ImmutableCostWidgetData buildResult2 = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addApplications(mock(Application.class));
    ImmutableCostWidgetData buildResult = builderResult.build();
    ImmutableCostWidgetData buildResult2 = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addMeasurables(mock(Measurable.class));
    ImmutableCostWidgetData buildResult = builderResult.build();
    ImmutableCostWidgetData buildResult2 = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableCostWidgetData.builder();
    builderResult.addCostKinds(mock(EntityCostKind.class));
    ImmutableCostWidgetData buildResult = builderResult.build();
    ImmutableCostWidgetData buildResult2 = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableCostWidgetData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableCostWidgetData.equals(Object)", "int ImmutableCostWidgetData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableCostWidgetData");
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableCostWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData is {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return cellData is HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnCellDataIsHashSet() {
    // Arrange
    HashSet<CostWidgetDatum> cellData = new HashSet<>();
    cellData.add(new ImmutableCostWidgetDatum.Json());
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(cellData, actualFromJsonResult.cellData());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableCostWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet() add Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenHashSetAddJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    HashSet<CostWidgetDatum> cellData = new HashSet<>();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();
    cellData.add(json);

    Json json2 = new Json();
    json2.setCellData(cellData);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json2);

    // Assert
    assertEquals(1, actualFromJsonResult.cellData().size());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualFromJsonResult.costKinds());
    assertSame(measurableCostEntrySet, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Application}.</li>
   *   <li>Then return applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Application; then return applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddApplication_thenReturnApplicationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Application> applications = new LinkedHashSet<>();
    applications.add(mock(Application.class));

    Json json = new Json();
    json.setCellData(null);
    json.setApplications(applications);
    json.setMeasurables(null);
    json.setCostKinds(null);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualFromJsonResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualFromJsonResult.costKinds());
    assertSame(cellDataResult, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link EntityCostKind}.</li>
   *   <li>Then return costKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add EntityCostKind; then return costKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddEntityCostKind_thenReturnCostKindsSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityCostKind> costKinds = new LinkedHashSet<>();
    costKinds.add(mock(EntityCostKind.class));

    Json json = new Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setMeasurables(null);
    json.setCostKinds(costKinds);

    // Act and Assert
    assertEquals(1, ImmutableCostWidgetData.fromJson(json).costKinds().size());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Measurable}.</li>
   *   <li>Then return measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Measurable; then return measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddMeasurable_thenReturnMeasurablesSizeIsOne() {
    // Arrange
    LinkedHashSet<Measurable> measurables = new LinkedHashSet<>();
    measurables.add(mock(Measurable.class));

    Json json = new Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setMeasurables(measurables);
    json.setCostKinds(null);

    // Act and Assert
    assertEquals(1, ImmutableCostWidgetData.fromJson(json).measurables().size());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Applications is {@code null}.</li>
   *   <li>Then return applications Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Applications is 'null'; then return applications Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonApplicationsIsNull_thenReturnApplicationsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellData(null);
    json.setApplications(null);
    json.setMeasurables(null);
    json.setCostKinds(null);

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    Set<Application> applicationsResult = actualFromJsonResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualFromJsonResult.cellData());
    assertSame(applicationsResult, actualFromJsonResult.costKinds());
    assertSame(applicationsResult, actualFromJsonResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return costKinds is {@link Json} (default constructor) {@link Json#cellData}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return costKinds is Json (default constructor) cellData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCostKindsIsJsonCellData() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableCostWidgetData actualFromJsonResult = ImmutableCostWidgetData.fromJson(json);

    // Assert
    Set<CostWidgetDatum> costWidgetDatumSet = json.cellData;
    assertSame(costWidgetDatumSet, actualFromJsonResult.costKinds());
    assertSame(costWidgetDatumSet, actualFromJsonResult.measurables());
    Set<Measurable> expectedCellDataResult = json.measurables;
    assertSame(expectedCellDataResult, actualFromJsonResult.cellData());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableCostWidgetData#toString()}
   *   <li>{@link ImmutableCostWidgetData#applications()}
   *   <li>{@link ImmutableCostWidgetData#cellData()}
   *   <li>{@link ImmutableCostWidgetData#costKinds()}
   *   <li>{@link ImmutableCostWidgetData#measurables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableCostWidgetData.applications()", "Set ImmutableCostWidgetData.cellData()",
      "Set ImmutableCostWidgetData.costKinds()", "Set ImmutableCostWidgetData.measurables()",
      "String ImmutableCostWidgetData.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<Application> actualApplicationsResult = buildResult.applications();
    Set<CostWidgetDatum> actualCellDataResult = buildResult.cellData();
    Set<EntityCostKind> actualCostKindsResult = buildResult.costKinds();
    Set<Measurable> actualMeasurablesResult = buildResult.measurables();

    // Assert
    assertEquals("CostWidgetData{cellData=[], applications=[], measurables=[], costKinds=[]}", actualToStringResult);
    assertTrue(actualApplicationsResult.isEmpty());
    assertSame(actualApplicationsResult, actualCellDataResult);
    assertSame(actualApplicationsResult, actualCostKindsResult);
    assertSame(actualApplicationsResult, actualMeasurablesResult);
  }

  /**
   * Test Json {@link Json#applications()}.
   * <p>
   * Method under test: {@link Json#applications()}
   */
  @Test
  @DisplayName("Test Json applications()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.applications()"})
  void testJsonApplications() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applications());
  }

  /**
   * Test Json {@link Json#cellData()}.
   * <p>
   * Method under test: {@link Json#cellData()}
   */
  @Test
  @DisplayName("Test Json cellData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.cellData()"})
  void testJsonCellData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).cellData());
  }

  /**
   * Test Json {@link Json#costKinds()}.
   * <p>
   * Method under test: {@link Json#costKinds()}
   */
  @Test
  @DisplayName("Test Json costKinds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.costKinds()"})
  void testJsonCostKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).costKinds());
  }

  /**
   * Test Json {@link Json#measurables()}.
   * <p>
   * Method under test: {@link Json#measurables()}
   */
  @Test
  @DisplayName("Test Json measurables()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.measurables()"})
  void testJsonMeasurables() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurables());
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
    assertTrue(actualJson.applications.isEmpty());
    assertTrue(actualJson.cellData.isEmpty());
    assertTrue(actualJson.costKinds.isEmpty());
    assertTrue(actualJson.measurables.isEmpty());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withApplications(Application[])} with {@code Application[]}.
   * <ul>
   *   <li>Then return applications size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#withApplications(Application[])}
   */
  @Test
  @DisplayName("Test withApplications(Application[]) with 'Application[]'; then return applications size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.withApplications(Application[])"})
  void testWithApplicationsWithApplication_thenReturnApplicationsSizeIsOne() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualWithApplicationsResult = buildResult.withApplications(mock(Application.class));

    // Assert
    assertEquals(1, actualWithApplicationsResult.applications().size());
    Set<CostWidgetDatum> cellDataResult = actualWithApplicationsResult.cellData();
    assertTrue(cellDataResult.isEmpty());
    assertSame(cellDataResult, actualWithApplicationsResult.costKinds());
    assertSame(cellDataResult, actualWithApplicationsResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withCellData(CostWidgetDatum[])} with {@code CostWidgetDatum[]}.
   * <ul>
   *   <li>When {@link ImmutableCostWidgetDatum.Json} (default constructor).</li>
   *   <li>Then return cellData size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#withCellData(CostWidgetDatum[])}
   */
  @Test
  @DisplayName("Test withCellData(CostWidgetDatum[]) with 'CostWidgetDatum[]'; when Json (default constructor); then return cellData size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.withCellData(CostWidgetDatum[])"})
  void testWithCellDataWithCostWidgetDatum_whenJson_thenReturnCellDataSizeIsOne() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();
    ImmutableCostWidgetDatum.Json json = new ImmutableCostWidgetDatum.Json();

    // Act
    ImmutableCostWidgetData actualWithCellDataResult = buildResult.withCellData(json);

    // Assert
    assertEquals(1, actualWithCellDataResult.cellData().size());
    assertTrue(actualWithCellDataResult.applications().isEmpty());
    Set<MeasurableCostEntry> measurableCostEntrySet = json.measurableCosts;
    assertSame(measurableCostEntrySet, actualWithCellDataResult.costKinds());
    assertSame(measurableCostEntrySet, actualWithCellDataResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withCostKinds(EntityCostKind[])} with {@code EntityCostKind[]}.
   * <ul>
   *   <li>Then return costKinds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#withCostKinds(EntityCostKind[])}
   */
  @Test
  @DisplayName("Test withCostKinds(EntityCostKind[]) with 'EntityCostKind[]'; then return costKinds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.withCostKinds(EntityCostKind[])"})
  void testWithCostKindsWithEntityCostKind_thenReturnCostKindsSizeIsOne() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualWithCostKindsResult = buildResult.withCostKinds(mock(EntityCostKind.class));

    // Assert
    assertEquals(1, actualWithCostKindsResult.costKinds().size());
    Set<Application> applicationsResult = actualWithCostKindsResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithCostKindsResult.cellData());
    assertSame(applicationsResult, actualWithCostKindsResult.measurables());
  }

  /**
   * Test {@link ImmutableCostWidgetData#withMeasurables(Measurable[])} with {@code Measurable[]}.
   * <ul>
   *   <li>When {@link Measurable}.</li>
   *   <li>Then return measurables size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableCostWidgetData#withMeasurables(Measurable[])}
   */
  @Test
  @DisplayName("Test withMeasurables(Measurable[]) with 'Measurable[]'; when Measurable; then return measurables size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableCostWidgetData ImmutableCostWidgetData.withMeasurables(Measurable[])"})
  void testWithMeasurablesWithMeasurable_whenMeasurable_thenReturnMeasurablesSizeIsOne() {
    // Arrange
    ImmutableCostWidgetData buildResult = ImmutableCostWidgetData.builder().build();

    // Act
    ImmutableCostWidgetData actualWithMeasurablesResult = buildResult.withMeasurables(mock(Measurable.class));

    // Assert
    assertEquals(1, actualWithMeasurablesResult.measurables().size());
    Set<Application> applicationsResult = actualWithMeasurablesResult.applications();
    assertTrue(applicationsResult.isEmpty());
    assertSame(applicationsResult, actualWithMeasurablesResult.cellData());
    assertSame(applicationsResult, actualWithMeasurablesResult.costKinds());
  }
}
